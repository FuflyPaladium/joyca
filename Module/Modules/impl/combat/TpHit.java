/*     */ package me.lavache.BaseClient.Module.Modules.impl.combat;
/*     */ 
/*     */ import de.Hero.settings.Setting;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*     */ import me.lavache.BaseClient.Eventbus.Events.EventUpdate;
/*     */ import me.lavache.BaseClient.Main;
/*     */ import me.lavache.BaseClient.Module.Category;
/*     */ import me.lavache.BaseClient.Module.Module;
/*     */ import me.lavache.BaseClient.Utils.RotationUtils;
/*     */ import me.lavache.BaseClient.Utils.TimeHelper;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.network.play.client.C02PacketUseEntity;
/*     */ import net.minecraft.network.play.client.C03PacketPlayer;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TpHit
/*     */   extends Module
/*     */ {
/*     */   private int attacked;
/*     */   private static int switchIndex;
/*  42 */   private TimeHelper switchTimer = new TimeHelper(); public static EntityLivingBase currentTarget;
/*     */   private boolean AIMed;
/*     */   private boolean attackTick;
/*     */   TimeHelper delay;
/*     */   private int count;
/*     */   
/*  48 */   public TpHit() { super("InfiniteAura", 34, Category.COMBAT);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  58 */     this.delay = new TimeHelper();
/*  59 */     this.count = 0; }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onEnable() {
/*  64 */     super.onEnable();
/*  65 */     this.attacked = 0; } public void setup() {
/*     */     ArrayList<String> options = new ArrayList<String>();
/*     */     Main.instance.setmgr.rSetting(new Setting("MotionY0", this, true));
/*     */     Main.instance.setmgr.rSetting(new Setting("Infinite Aura Delay", this, 20.0D, 1.0D, 50.0D, true));
/*     */   } public void onDisable() {
/*  70 */     super.onDisable();
/*  71 */     this.attacked = 0;
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   private void onUpdate(EventUpdate event) {
/*  76 */     if (Main.instance.setmgr.getSettingByName("MotionY0").getValBoolean()) {
/*  77 */       mc.thePlayer.motionY = 0.0D;
/*     */     }
/*  79 */     if (this.count == (int)Main.instance.setmgr.getSettingByName("Infinite Aura Delay").getValDouble()) {
/*  80 */       if (getTargets().size() <= 0) {
/*  81 */         TpHit.currentTarget = null;
/*     */       } else {
/*  83 */         int count = 0;
/*  84 */         int max = 2;
/*  85 */         Iterator var5 = getTargets().iterator();
/*     */         
/*  87 */         while (var5.hasNext()) {
/*  88 */           EntityLivingBase currentTarget = (EntityLivingBase)var5.next();
/*  89 */           count++;
/*  90 */           if (count > max) {
/*     */             break;
/*     */           }
/*     */           
/*  94 */           if (!isNeedTeleport(currentTarget)) {
/*  95 */             float[] rot = RotationUtils.getRotations(currentTarget);
/*  96 */             mc.thePlayer.sendQueue.getNetworkManager().sendPacket(new C03PacketPlayer.C05PacketPlayerLook(rot[0], rot[1], mc.thePlayer.onGround));
/*  97 */             if (isEntityValid(currentTarget, true))
/*  98 */               attack(currentTarget, false); 
/*     */             continue;
/*     */           } 
/* 101 */           List<BlockPos> path = PathBlocks(new Vec3(mc.thePlayer.posX, mc.thePlayer.posY + mc.thePlayer.getEyeHeight(), mc.thePlayer.posZ), new Vec3(currentTarget.posX, currentTarget.posY + currentTarget.getEyeHeight(), currentTarget.posZ), false, true, true);
/* 102 */           if (path == null) {
/*     */             return;
/*     */           }
/*     */           
/* 106 */           List<Vec3> pathLocs = new ArrayList<Vec3>();
/* 107 */           Vec3 lastPos = new Vec3(0.0D, 0.0D, 0.0D);
/*     */           
/* 109 */           for (int pointt = 0; pointt < path.size() - 1; pointt++) {
/* 110 */             BlockPos i = (BlockPos)path.get(pointt);
/* 111 */             pathLocs.add(new Vec3(i.getX() + 0.5D, i.getY(), i.getZ() + 0.5D));
/* 112 */             lastPos = new Vec3(i.getX() + 0.5D, i.getY(), i.getZ() + 0.5D);
/*     */           } 
/*     */           
/* 115 */           Iterator var14 = pathLocs.iterator();
/*     */           
/* 117 */           while (var14.hasNext()) {
/* 118 */             Vec3 item = (Vec3)var14.next();
/* 119 */             mc.thePlayer.sendQueue.getNetworkManager().sendPacket(new C03PacketPlayer.C04PacketPlayerPosition(item.xCoord, item.yCoord, item.zCoord, true));
/*     */           } 
/*     */           
/* 122 */           float[] rot = RotationUtils.getRotations(currentTarget, lastPos.xCoord, lastPos.yCoord, lastPos.zCoord);
/* 123 */           mc.thePlayer.sendQueue.getNetworkManager().sendPacket(new C03PacketPlayer.C05PacketPlayerLook(rot[0], rot[1], mc.thePlayer.onGround));
/* 124 */           if (isEntityValid(currentTarget, true)) {
/* 125 */             attack(currentTarget, false);
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 130 */       this.count = 0;
/*     */     } 
/* 132 */     this.count++;
/*     */   }
/*     */   
/*     */   public List<BlockPos> PathBlocks(Vec3 from, Vec3 to, boolean p_147447_3_, boolean p_147447_4_, boolean p_147447_5_) {
/* 136 */     List<BlockPos> result = new ArrayList<BlockPos>();
/* 137 */     if (!Double.isNaN(from.xCoord) && !Double.isNaN(from.yCoord) && !Double.isNaN(from.zCoord)) {
/* 138 */       if (!Double.isNaN(to.xCoord) && !Double.isNaN(to.yCoord) && !Double.isNaN(to.zCoord)) {
/* 139 */         int var6 = MathHelper.floor_double(to.xCoord);
/* 140 */         int var7 = MathHelper.floor_double(to.yCoord);
/* 141 */         int var8 = MathHelper.floor_double(to.zCoord);
/* 142 */         int var9 = MathHelper.floor_double(from.xCoord);
/* 143 */         int var10 = MathHelper.floor_double(from.yCoord);
/* 144 */         int var11 = MathHelper.floor_double(from.zCoord);
/* 145 */         BlockPos var12 = new BlockPos(var9, var10, var11);
/*     */         
/* 147 */         IBlockState var14 = mc.theWorld.getBlockState(var12);
/* 148 */         Block var15 = var14.getBlock();
/*     */         
/* 150 */         if ((!p_147447_4_ || var15.getCollisionBoundingBox(mc.theWorld, var12, var14) != null) && var15.canCollideCheck(var14, p_147447_3_)) {
/* 151 */           MovingObjectPosition var16 = var15.collisionRayTrace(mc.theWorld, var12, from, to);
/* 152 */           if (var16 != null) {
/* 153 */             return result;
/*     */           }
/*     */         } 
/*     */         
/* 157 */         MovingObjectPosition var16 = null;
/* 158 */         int var17 = 200;
/*     */         
/* 160 */         while (var17-- >= 0) {
/* 161 */           EnumFacing var37; if (Double.isNaN(from.xCoord) || Double.isNaN(from.yCoord) || Double.isNaN(from.zCoord)) {
/* 162 */             return null;
/*     */           }
/*     */           
/* 165 */           if (var9 == var6 && var10 == var7 && var11 == var8) {
/* 166 */             return p_147447_5_ ? result : null;
/*     */           }
/*     */           
/* 169 */           boolean var43 = true;
/* 170 */           boolean var171 = true;
/* 171 */           boolean var18 = true;
/* 172 */           double var19 = 999.0D;
/* 173 */           double var21 = 999.0D;
/* 174 */           double var23 = 999.0D;
/* 175 */           if (var6 > var9) {
/* 176 */             var19 = var9 + 1.0D;
/* 177 */           } else if (var6 < var9) {
/* 178 */             var19 = var9 + 0.0D;
/*     */           } else {
/* 180 */             var43 = false;
/*     */           } 
/*     */           
/* 183 */           if (var7 > var10) {
/* 184 */             var21 = var10 + 1.0D;
/* 185 */           } else if (var7 < var10) {
/* 186 */             var21 = var10 + 0.0D;
/*     */           } else {
/* 188 */             var171 = false;
/*     */           } 
/*     */           
/* 191 */           if (var8 > var11) {
/* 192 */             var23 = var11 + 1.0D;
/* 193 */           } else if (var8 < var11) {
/* 194 */             var23 = var11 + 0.0D;
/*     */           } else {
/* 196 */             var18 = false;
/*     */           } 
/*     */           
/* 199 */           double var25 = 999.0D;
/* 200 */           double var27 = 999.0D;
/* 201 */           double var29 = 999.0D;
/* 202 */           double var31 = to.xCoord - from.xCoord;
/* 203 */           double var33 = to.yCoord - from.yCoord;
/* 204 */           double var35 = to.zCoord - from.zCoord;
/* 205 */           if (var43) {
/* 206 */             var25 = (var19 - from.xCoord) / var31;
/*     */           }
/*     */           
/* 209 */           if (var171) {
/* 210 */             var27 = (var21 - from.yCoord) / var33;
/*     */           }
/*     */           
/* 213 */           if (var18) {
/* 214 */             var29 = (var23 - from.zCoord) / var35;
/*     */           }
/*     */           
/* 217 */           if (var25 == -0.0D) {
/* 218 */             var25 = -1.0E-4D;
/*     */           }
/*     */           
/* 221 */           if (var27 == -0.0D) {
/* 222 */             var27 = -1.0E-4D;
/*     */           }
/*     */           
/* 225 */           if (var29 == -0.0D) {
/* 226 */             var29 = -1.0E-4D;
/*     */           }
/*     */ 
/*     */           
/* 230 */           if (var25 < var27 && var25 < var29) {
/* 231 */             var37 = (var6 > var9) ? EnumFacing.WEST : EnumFacing.EAST;
/* 232 */             from = new Vec3(var19, from.yCoord + var33 * var25, from.zCoord + var35 * var25);
/* 233 */           } else if (var27 < var29) {
/* 234 */             var37 = (var7 > var10) ? EnumFacing.DOWN : EnumFacing.UP;
/* 235 */             from = new Vec3(from.xCoord + var31 * var27, var21, from.zCoord + var35 * var27);
/*     */           } else {
/* 237 */             var37 = (var8 > var11) ? EnumFacing.NORTH : EnumFacing.SOUTH;
/* 238 */             from = new Vec3(from.xCoord + var31 * var29, from.yCoord + var33 * var29, var23);
/*     */           } 
/*     */           
/* 241 */           var9 = MathHelper.floor_double(from.xCoord) - ((var37 == EnumFacing.EAST) ? 1 : 0);
/* 242 */           var10 = MathHelper.floor_double(from.yCoord) - ((var37 == EnumFacing.UP) ? 1 : 0);
/* 243 */           var11 = MathHelper.floor_double(from.zCoord) - ((var37 == EnumFacing.SOUTH) ? 1 : 0);
/* 244 */           var12 = new BlockPos(var9, var10, var11);
/* 245 */           result.add(new BlockPos(var9, var10, var11));
/* 246 */           IBlockState var38 = mc.theWorld.getBlockState(var12);
/* 247 */           Block var39 = var38.getBlock();
/* 248 */           if (!p_147447_4_ || var39.getCollisionBoundingBox(mc.theWorld, var12, var38) != null) {
/* 249 */             if (var39.canCollideCheck(var38, p_147447_3_)) {
/* 250 */               MovingObjectPosition var40 = var39.collisionRayTrace(mc.theWorld, var12, from, to);
/* 251 */               if (var40 != null) {
/* 252 */                 return result;
/*     */               }
/*     */             } 
/*     */           }
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 260 */         return p_147447_5_ ? result : null;
/*     */       } 
/* 262 */       return null;
/*     */     } 
/*     */     
/* 265 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isEntityValid(Entity entity, boolean attack) {
/* 270 */     if (!(entity instanceof EntityLivingBase)) {
/* 271 */       return false;
/*     */     }
/* 273 */     EntityLivingBase entityLiving = (EntityLivingBase)entity;
/* 274 */     if (isValidForAura(entity)) {
/* 275 */       return true;
/*     */     }
/*     */     
/* 278 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isNeedTeleport(Entity entity) {
/* 282 */     if (!mc.thePlayer.canEntityBeSeen(entity)) {
/* 283 */       return true;
/*     */     }
/* 285 */     return (mc.thePlayer.getDistanceToEntity(entity) > 3.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean needBlock() {
/* 290 */     var1 = mc.theWorld.loadedEntityList.iterator();
/*     */     
/* 292 */     while (var1.hasNext()) {
/* 293 */       Entity entity = (Entity)var1.next();
/* 294 */       if (isEntityValid(entity, false)) {
/* 295 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 299 */     return false;
/*     */   }
/*     */   
/*     */   private List<EntityLivingBase> getTargets() {
/* 303 */     ArrayList<EntityLivingBase> targets = new ArrayList<EntityLivingBase>();
/* 304 */     Iterator var3 = mc.theWorld.loadedEntityList.iterator();
/*     */     
/* 306 */     while (var3.hasNext()) {
/* 307 */       Entity entity = (Entity)var3.next();
/* 308 */       if (isEntityValid(entity, false)) {
/* 309 */         targets.add((EntityLivingBase)entity);
/*     */       }
/*     */     } 
/*     */     
/* 313 */     targets.sort(new Comparator<EntityLivingBase>() {
/*     */           public int compare(EntityLivingBase target1, EntityLivingBase target2) {
/* 315 */             return target1.getName().compareTo(target2.getName());
/*     */           }
/*     */         });
/* 318 */     return targets;
/*     */   }
/*     */   
/*     */   private void attack(EntityLivingBase entity, boolean crit) {
/* 322 */     ItemStack currentItem = mc.thePlayer.inventory.getCurrentItem();
/*     */     
/* 324 */     if (currentItem != null && currentItem.getItem().getItemUseAction(currentItem) == EnumAction.BLOCK && mc.thePlayer.isBlocking()) {
/* 325 */       boolean var10000 = true;
/*     */     } else {
/* 327 */       boolean var10000 = false;
/*     */     } 
/*     */     
/* 330 */     if (mc.thePlayer.fallDistance > 0.0F && !mc.thePlayer.onGround && !mc.thePlayer.isOnLadder() && !mc.thePlayer.isInWater() && !mc.thePlayer.isPotionActive(Potion.blindness) && mc.thePlayer.ridingEntity == null) {
/* 331 */       boolean bool = true;
/*     */     } else {
/* 333 */       boolean bool = false;
/*     */     } 
/*     */     
/* 336 */     this.attacked++;
/* 337 */     mc.thePlayer.sendQueue.getNetworkManager().sendPacket(new C02PacketUseEntity(entity, C02PacketUseEntity.Action.ATTACK));
/* 338 */     mc.thePlayer.swingItem();
/* 339 */     mc.thePlayer.onCriticalHit(entity);
/*     */   }
/*     */   
/*     */   public static boolean isValidForAura(Entity entity) {
/* 343 */     if (entity != mc.thePlayer && entity.isEntityAlive()) {
/* 344 */       if (entity.isInvisible())
/* 345 */         return false; 
/* 346 */       if (entity instanceof net.minecraft.entity.player.EntityPlayer) {
/* 347 */         return true;
/*     */       }
/*     */     } else {
/* 350 */       return false;
/*     */     } 
/* 352 */     return false;
/*     */   }
/*     */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\combat\TpHit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */