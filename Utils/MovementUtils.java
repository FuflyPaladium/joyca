/*     */ package me.lavache.BaseClient.Utils;
/*     */ 
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.network.play.client.C03PacketPlayer;
/*     */ import net.minecraft.stats.StatList;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class MovementUtils
/*     */ {
/*  14 */   private static Minecraft mc = Minecraft.getMinecraft();
/*     */   
/*     */   public static float getDirection(EntityLivingBase e) {
/*  17 */     float yaw = e.rotationYaw;
/*  18 */     float forward = e.moveForward;
/*  19 */     float strafe = e.moveStrafing;
/*  20 */     yaw += ((forward < 0.0F) ? '´' : false);
/*  21 */     if (strafe < 0.0F) {
/*  22 */       yaw += ((forward == 0.0F) ? 90 : ((forward < 0.0F) ? -45 : 45));
/*     */     }
/*  24 */     if (strafe > 0.0F) {
/*  25 */       yaw -= ((forward == 0.0F) ? 90 : ((forward < 0.0F) ? -45 : 45));
/*     */     }
/*  27 */     return yaw * 0.017453292F;
/*     */   }
/*     */   
/*     */   public static void setSpeed(Entity e, double speed) {
/*  31 */     e.motionX = -MathHelper.sin(getDirection()) * speed;
/*  32 */     e.motionZ = MathHelper.cos(getDirection()) * speed;
/*     */   }
/*     */ 
/*     */   
/*  36 */   public static double getSpeed(EntityLivingBase e) { return Math.sqrt(square(e.motionX) + square(e.motionZ)); }
/*     */ 
/*     */   
/*  39 */   public static float getDirection() { return getDirection(mc.thePlayer); }
/*  40 */   public static void setSpeed(double speed) { setSpeed(mc.thePlayer, speed); }
/*  41 */   public static double getSpeed() { return getSpeed(mc.thePlayer); }
/*     */ 
/*     */   
/*  44 */   public static double square(double in) { return in * in; }
/*     */ 
/*     */ 
/*     */   
/*  48 */   public static boolean isMoving() { return !((Minecraft.getMinecraft()).thePlayer.moveForward == 0.0F && (Minecraft.getMinecraft()).thePlayer.moveStrafing == 0.0F); }
/*     */ 
/*     */ 
/*     */   
/*  52 */   public static boolean ilBouge() { return !((Minecraft.getMinecraft()).thePlayer.moveForward == 0.0F && (Minecraft.getMinecraft()).thePlayer.moveStrafing == 0.0F); }
/*     */ 
/*     */   
/*     */   public static void Damage() {
/*  56 */     for (i = 0; i < 80.0D; i++) {
/*  57 */       (Minecraft.getMinecraft()).thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition((Minecraft.getMinecraft()).thePlayer.posX, (Minecraft.getMinecraft()).thePlayer.posY + 0.049D, (Minecraft.getMinecraft()).thePlayer.posZ, false));
/*  58 */       (Minecraft.getMinecraft()).thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition((Minecraft.getMinecraft()).thePlayer.posX, (Minecraft.getMinecraft()).thePlayer.posY, (Minecraft.getMinecraft()).thePlayer.posZ, false));
/*     */     } 
/*  60 */     (Minecraft.getMinecraft()).thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition((Minecraft.getMinecraft()).thePlayer.posX, (Minecraft.getMinecraft()).thePlayer.posY, (Minecraft.getMinecraft()).thePlayer.posZ, true));
/*     */   }
/*     */   
/*     */   public static void damagePlayer(int damage) {
/*  64 */     if (damage < 1)
/*  65 */       damage = 1; 
/*  66 */     if (damage > MathHelper.floor_double(mc.thePlayer.getMaxHealth())) {
/*  67 */       damage = MathHelper.floor_double(mc.thePlayer.getMaxHealth());
/*     */     }
/*  69 */     double offset = 0.0625D;
/*  70 */     if (mc.thePlayer != null && mc.getNetHandler() != null && mc.thePlayer.onGround) {
/*  71 */       for (int i = 0; i <= (3 + damage) / offset; i++) {
/*  72 */         mc.getNetHandler().addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, 
/*  73 */               mc.thePlayer.posY + offset, mc.thePlayer.posZ, false));
/*  74 */         mc.getNetHandler().addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, 
/*  75 */               mc.thePlayer.posY, mc.thePlayer.posZ, (i == (3 + damage) / offset)));
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*  81 */   public static void vClip(double d) { mc.thePlayer.setPosition(mc.thePlayer.posX, mc.thePlayer.posY + d, mc.thePlayer.posZ); }
/*     */ 
/*     */   
/*     */   public static void disableMovements() {
/*  85 */     mc.gameSettings.keyBindForward.pressed = false;
/*  86 */     mc.gameSettings.keyBindRight.pressed = false;
/*  87 */     mc.gameSettings.keyBindLeft.pressed = false;
/*  88 */     mc.gameSettings.keyBindBack.pressed = false;
/*  89 */     mc.gameSettings.keyBindJump.pressed = false;
/*     */   }
/*     */   
/*     */   public static void enableMovements() {
/*  93 */     mc.gameSettings.keyBindForward.pressed = true;
/*  94 */     mc.gameSettings.keyBindRight.pressed = true;
/*  95 */     mc.gameSettings.keyBindLeft.pressed = true;
/*  96 */     mc.gameSettings.keyBindBack.pressed = true;
/*  97 */     mc.gameSettings.keyBindJump.pressed = true;
/*     */   }
/*     */   
/*     */   public static void strafe(float speed) {
/* 101 */     if (!isMoving()) {
/*     */       return;
/*     */     }
/* 104 */     double yaw = getDirection();
/* 105 */     mc.thePlayer.motionX = -Math.sin(yaw) * speed;
/* 106 */     mc.thePlayer.motionZ = Math.cos(yaw) * speed;
/*     */   }
/*     */   
/*     */   public static void forward(double distance) {
/* 110 */     double yaw = Math.toRadians(mc.thePlayer.rotationYaw);
/* 111 */     mc.thePlayer.setPosition(mc.thePlayer.posX + -Math.sin(yaw) * distance, mc.thePlayer.posY, mc.thePlayer.posZ + Math.cos(yaw) * distance);
/*     */   }
/*     */   
/*     */   public static double calcXForward(double distance) {
/* 115 */     double yaw = Math.toRadians(mc.thePlayer.rotationYaw);
/* 116 */     return mc.thePlayer.posX + -Math.sin(yaw) * distance;
/*     */   }
/*     */   
/*     */   public static double calcZForward(double distance) {
/* 120 */     double yaw = Math.toRadians(mc.thePlayer.rotationYaw);
/* 121 */     return mc.thePlayer.posZ + Math.cos(yaw) * distance;
/*     */   }
/*     */   
/*     */   public static void fakeJump() {
/* 125 */     mc.thePlayer.isAirBorne = true;
/* 126 */     mc.thePlayer.triggerAchievement(StatList.jumpStat);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isFalling() {
/* 131 */     oneblockBelowPlayer = (new BlockPos(mc.thePlayer)).add(mc.thePlayer.posX, mc.thePlayer.posY - 1.0D, mc.thePlayer.posZ);
/* 132 */     BlockPos twoblockBelowPlayer = (new BlockPos(mc.thePlayer)).add(mc.thePlayer.posX, mc.thePlayer.posY - 2.0D, mc.thePlayer.posZ);
/* 133 */     BlockPos threeblockBelowPlayer = (new BlockPos(mc.thePlayer)).add(mc.thePlayer.posX, mc.thePlayer.posY - 3.0D, mc.thePlayer.posZ);
/* 134 */     BlockPos fourblockBelowPlayer = (new BlockPos(mc.thePlayer)).add(mc.thePlayer.posX, mc.thePlayer.posY - 4.0D, mc.thePlayer.posZ);
/* 135 */     BlockPos fiveblockBelowPlayer = (new BlockPos(mc.thePlayer)).add(mc.thePlayer.posX, mc.thePlayer.posY - 5.0D, mc.thePlayer.posZ);
/* 136 */     BlockPos sixblockBelowPlayer = (new BlockPos(mc.thePlayer)).add(mc.thePlayer.posX, mc.thePlayer.posY - 6.0D, mc.thePlayer.posZ);
/*     */     
/* 138 */     if (mc.theWorld.getBlockState(oneblockBelowPlayer).getBlock() == Blocks.air) {
/* 139 */       if (mc.theWorld.getBlockState(twoblockBelowPlayer).getBlock() == Blocks.air) {
/* 140 */         if (mc.theWorld.getBlockState(threeblockBelowPlayer).getBlock() == Blocks.air) {
/* 141 */           if (mc.theWorld.getBlockState(fourblockBelowPlayer).getBlock() == Blocks.air) {
/* 142 */             if (mc.theWorld.getBlockState(fiveblockBelowPlayer).getBlock() == Blocks.air) {
/* 143 */               if (mc.theWorld.getBlockState(sixblockBelowPlayer).getBlock() == Blocks.air) {
/* 144 */                 return true;
/*     */               }
/* 146 */               return false;
/*     */             } 
/*     */             
/* 149 */             return false;
/*     */           } 
/*     */           
/* 152 */           return false;
/*     */         } 
/*     */         
/* 155 */         return false;
/*     */       } 
/*     */       
/* 158 */       return false;
/*     */     } 
/*     */     
/* 161 */     return false;
/*     */   }
/*     */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Utils\MovementUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */