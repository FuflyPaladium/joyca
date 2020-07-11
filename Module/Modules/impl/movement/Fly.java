/*     */ package me.lavache.BaseClient.Module.Modules.impl.movement;
/*     */ 
/*     */ import de.Hero.settings.Setting;
/*     */ import java.util.ArrayList;
/*     */ import me.lavache.BaseClient.Eventbus.Event;
/*     */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*     */ import me.lavache.BaseClient.Eventbus.Events.EventJump;
/*     */ import me.lavache.BaseClient.Eventbus.Events.EventPacket;
/*     */ import me.lavache.BaseClient.Eventbus.Events.EventUpdate;
/*     */ import me.lavache.BaseClient.Main;
/*     */ import me.lavache.BaseClient.Module.Category;
/*     */ import me.lavache.BaseClient.Module.Module;
/*     */ import me.lavache.BaseClient.Utils.MovementUtils;
/*     */ import me.lavache.BaseClient.Utils.TimeHelper;
/*     */ import net.minecraft.potion.Potion;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Fly
/*     */   extends Module
/*     */ {
/*     */   private TimeHelper upanddownTimer;
/*     */   private TimeHelper mineplexTimer;
/*     */   private int otherCounter;
/*     */   private int hypixelTickCount;
/*     */   private int jartexTickCount;
/*     */   private double posX;
/*     */   
/*     */   public Fly() {
/*  36 */     super("Fly", 33, Category.MOVEMENT);
/*     */ 
/*     */     
/*  39 */     this.upanddownTimer = new TimeHelper();
/*  40 */     this.mineplexTimer = new TimeHelper();
/*     */ 
/*     */     
/*  43 */     this.hypixelTickCount = 0;
/*  44 */     this.jartexTickCount = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 172 */     this.aac3glideDelay = 0;
/* 173 */     this.aac4state = 0;
/*     */   } private double posY; private double posZ; private int slot; int aac3glideDelay; int aac4state; public void setup() { ArrayList<String> options = new ArrayList<String>(); options.add("Vanilla"); options.add("CubeGlide"); options.add("CubeFlyUpAndDown"); options.add("InfiniteCubeFly"); options.add("CubeFlyVeryFast"); options.add("Premium CubeFly"); options.add("TheHive Glide"); options.add("ExtremeCraft Fly"); options.add("McCentral Fly"); options.add("RedeSky Fly");
/*     */     options.add("Hypixel Fly");
/*     */     options.add("JartexNetwork Fly");
/*     */     options.add("Mineplex Fly");
/*     */     options.add("CCTEST Fly");
/* 179 */     Main.instance.setmgr.rSetting(new Setting("FLY_MODE", this, "Vanilla", options)); } @EventTarget public void onPTDRRR(EventUpdate oof) { if (Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("Vanilla")) {
/* 180 */       if (mc.gameSettings.keyBindForward.isKeyDown())
/* 181 */         MovementUtils.setSpeed(1.0D); 
/* 182 */       if (mc.gameSettings.keyBindJump.isKeyDown())
/* 183 */         MovementUtils.vClip(1.0D); 
/* 184 */       if (mc.gameSettings.keyBindSneak.isKeyDown())
/* 185 */         MovementUtils.vClip(-1.0D); 
/* 186 */       mc.thePlayer.motionY = 0.0D;
/*     */     } 
/*     */ 
/*     */     
/* 190 */     if (Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("CubeGlide") && 
/* 191 */       mc.thePlayer.fallDistance > 0.5F) {
/* 192 */       mc.timer.timerSpeed = 0.4F;
/* 193 */       if (mc.thePlayer.ticksExisted % 1 == 0) {
/* 194 */         MovementUtils.setSpeed(2.25D);
/*     */       } else {
/* 196 */         MovementUtils.setSpeed(0.0D);
/*     */       } 
/* 198 */       mc.thePlayer.fallDistance = 0.0F;
/*     */     } 
/*     */     
/* 201 */     Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("CubeFlyUpAndDown");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 218 */     if (Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("CubeFlyVeryFast") && 
/* 219 */       oof.state == Event.State.PRE) {
/* 220 */       mc.thePlayer.onGround = true;
/* 221 */       if (mc.thePlayer.ticksExisted % 2 == 0) {
/* 222 */         mc.thePlayer.setPositionAndUpdate(MovementUtils.calcXForward(3.0D), mc.thePlayer.posY, MovementUtils.calcZForward(3.0D));
/*     */       } else {
/* 224 */         MovementUtils.disableMovements();
/*     */       } 
/* 226 */       mc.thePlayer.motionY = 0.0D;
/*     */     } 
/*     */     
/* 229 */     if (Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("InfiniteCubeFly")) {
/* 230 */       mc.timer.timerSpeed = 0.1F;
/* 231 */       mc.thePlayer.onGround = false;
/* 232 */       mc.thePlayer.jumpMovementFactor = 0.0F;
/* 233 */       if (mc.thePlayer.ticksExisted % 2 == 0) {
/* 234 */         MovementUtils.setSpeed(2.0D);
/* 235 */         mc.thePlayer.motionY = 0.20000000298023224D;
/*     */       } else {
/* 237 */         mc.thePlayer.motionY = 0.0D;
/* 238 */         MovementUtils.setSpeed(0.0D);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 243 */     if (Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("TheHive Glide")) {
/* 244 */       if (!mc.thePlayer.onGround) {
/* 245 */         this.aac3glideDelay++;
/*     */       }
/*     */       
/* 248 */       if (this.aac3glideDelay == 5) {
/* 249 */         mc.timer.timerSpeed = 0.1F;
/* 250 */         MovementUtils.setSpeed(0.30000001192092896D);
/*     */       } 
/*     */       
/* 253 */       if (this.aac3glideDelay >= 5 && !mc.thePlayer.onGround) {
/* 254 */         this.aac3glideDelay = 0;
/* 255 */         mc.thePlayer.motionY = 0.05D;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 260 */     if (Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("Premium CubeFly") && 
/* 261 */       oof.state == Event.State.PRE) {
/* 262 */       mc.timer.timerSpeed = 1.0F;
/* 263 */       this.otherCounter++;
/*     */       
/* 265 */       if (mc.thePlayer.moveForward == 0.0F && mc.thePlayer.moveStrafing == 0.0F) {
/* 266 */         mc.thePlayer.setPosition(mc.thePlayer.posX + 1.0D, mc.thePlayer.posY + 1.0D, mc.thePlayer.posZ + 1.0D);
/* 267 */         mc.thePlayer.setPosition(mc.thePlayer.prevPosX, mc.thePlayer.prevPosY, mc.thePlayer.prevPosZ);
/* 268 */         mc.thePlayer.motionX = 0.0D;
/* 269 */         mc.thePlayer.motionZ = 0.0D;
/*     */       } 
/*     */       
/* 272 */       mc.thePlayer.motionY = 0.0D;
/*     */       
/* 274 */       if (this.otherCounter == 2) {
/* 275 */         mc.thePlayer.setPosition(mc.thePlayer.posX, mc.thePlayer.posY + 1.0E-10D, mc.thePlayer.posZ);
/* 276 */         this.otherCounter = 0;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 282 */     if (Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("ExtremeCraft Fly")) {
/* 283 */       mc.thePlayer.setSprinting(false);
/* 284 */       mc.thePlayer.onGround = true;
/* 285 */       if (mc.thePlayer.ticksExisted % 2 == 0 && !mc.thePlayer.isCollidedHorizontally) {
/*     */         
/* 287 */         MovementUtils.setSpeed(1.399999976158142D);
/* 288 */         mc.thePlayer.motionY = 0.0D;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 293 */     if (Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("McCentral Fly")) {
/* 294 */       mc.thePlayer.onGround = true;
/* 295 */       mc.thePlayer.motionY = -0.0010000000474974513D;
/* 296 */       if (mc.thePlayer.ticksExisted % 3 == 0) {
/* 297 */         MovementUtils.forward(1.0D);
/*     */       }
/*     */     } 
/*     */     
/* 301 */     if (Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("RedeSky Fly")) {
/* 302 */       if (!mc.thePlayer.onGround) {
/* 303 */         mc.gameSettings.viewBobbing = true;
/* 304 */         mc.thePlayer.onGround = true;
/*     */       } 
/* 306 */       mc.thePlayer.setPosition(mc.thePlayer.posX, mc.thePlayer.posY + 1.0E-10D, mc.thePlayer.posZ);
/* 307 */       mc.thePlayer.motionY = 0.0D;
/*     */     } 
/*     */ 
/*     */     
/* 311 */     if (Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("Hypixel Fly")) {
/*     */       
/* 313 */       if (mc.timer.timerSpeed > 1.0F) {
/* 314 */         mc.timer.timerSpeed -= 0.05F;
/* 315 */       } else if (mc.timer.timerSpeed < 1.0F) {
/* 316 */         mc.timer.timerSpeed = 1.0F;
/* 317 */       }  if (this.hypixelTickCount >= 2) {
/* 318 */         this.hypixelTickCount = 0;
/* 319 */         mc.thePlayer.setPosition(mc.thePlayer.posX * 1.0D, mc.thePlayer.posY + 0.005423123132D, mc.thePlayer.posZ * 1.0D);
/*     */       } 
/* 321 */       mc.thePlayer.motionY = 0.0D;
/* 322 */       mc.thePlayer.onGround = true;
/* 323 */       this.hypixelTickCount++;
/*     */     } 
/*     */ 
/*     */     
/* 327 */     Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("JartexNetwork Fly");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 332 */     Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("Mineplex Fly");
/*     */ 
/*     */     
/* 335 */     Double spartFlyYBase = Double.valueOf(0.0D);
/* 336 */     if (Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("CCTEST Fly")) {
/* 337 */       mc.thePlayer.onGround = true;
/* 338 */       if (!mc.thePlayer.isJumping)
/* 339 */         mc.thePlayer.motionY = 0.0D; 
/* 340 */       if (mc.gameSettings.keyBindForward.isKeyDown() && 
/* 341 */         mc.thePlayer.ticksExisted % 30 == 0) {
/* 342 */         MovementUtils.forward(0.4000000059604645D);
/*     */       }
/*     */     }  }
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public void onPacket(EventPacket e) {
/* 349 */     if (Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("CubeUpAndDown Premium") && 
/* 350 */       e.getPacket() instanceof net.minecraft.network.play.server.S08PacketPlayerPosLook) {
/* 351 */       e.setCancelled(true);
/*     */     }
/* 353 */     if (Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("JartexNetwork Fly") && 
/* 354 */       e.getPacket() instanceof net.minecraft.network.play.client.C03PacketPlayer) {
/* 355 */       e.setCancelled(false);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double getBaseMoveSpeed() {
/* 366 */     double baseSpeed = 0.275D;
/* 367 */     if (mc.thePlayer.isPotionActive(Potion.moveSpeed)) {
/* 368 */       int amplifier = mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier();
/* 369 */       baseSpeed *= (1.0D + 0.2D * (amplifier + 1));
/*     */     } 
/* 371 */     return baseSpeed;
/*     */   }
/*     */   
/*     */   public void onEnable() {
/*     */     super.onEnable();
/*     */     this.posX = mc.thePlayer.posX;
/*     */     this.posY = mc.thePlayer.posY;
/*     */     this.posZ = mc.thePlayer.posZ;
/*     */     if (Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("CubeGlide"))
/*     */       MovementUtils.Damage(); 
/*     */     Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("ExtremeCraft Fly");
/*     */     Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("CubeFlyUpAndDown");
/*     */     if (Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("CubeFlyVeryFast")) {
/*     */       mc.thePlayer.motionY = 0.20000000298023224D;
/*     */       for (int i = 0; i < 50; i++)
/*     */         mc.thePlayer.setPositionAndUpdate(mc.thePlayer.posX, mc.thePlayer.posY, mc.thePlayer.posZ); 
/*     */       MovementUtils.Damage();
/*     */       mc.timer.timerSpeed = 0.4F;
/*     */     } 
/*     */     if (Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("InfiniteCubeFly"))
/*     */       MovementUtils.Damage(); 
/*     */     if (Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("Premium CubeFly")) {
/*     */       MovementUtils.Damage();
/*     */       mc.thePlayer.motionY = 0.4099999964237213D;
/*     */       mc.timer.timerSpeed = 1.55F;
/*     */     } 
/*     */     Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("JartexNetwork Fly");
/*     */     if (Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("Mineplex Fly"))
/*     */       MovementUtils.setSpeed(2.0D); 
/*     */     if (Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("Hypixel Fly"))
/*     */       mc.timer.timerSpeed = 1.5F; 
/*     */     Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("CCTEST Fly");
/*     */   }
/*     */   
/*     */   public void onDisable() {
/*     */     super.onDisable();
/*     */     if (Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("Vanilla")) {
/*     */       MovementUtils.setSpeed(0.0D);
/*     */       mc.thePlayer.motionY = -1.0D;
/*     */     } 
/*     */     if (Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("CubeGlide")) {
/*     */       MovementUtils.setSpeed(0.0D);
/*     */       mc.thePlayer.motionY = -5.0D;
/*     */     } 
/*     */     if (Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("ExtremeCraft Fly")) {
/*     */       MovementUtils.setSpeed(0.0D);
/*     */       mc.thePlayer.motionY = -1.0D;
/*     */     } 
/*     */     if (Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("CubeFlyVeryFast")) {
/*     */       mc.thePlayer.motionY = -1.0D;
/*     */       this.otherCounter = 0;
/*     */     } 
/*     */     if (Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("CubeFlyUpAndDown"))
/*     */       MovementUtils.setSpeed(0.0D); 
/*     */     if (Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("InfiniteCubeFly")) {
/*     */       MovementUtils.setSpeed(0.0D);
/*     */       mc.thePlayer.motionY = -0.800000011920929D;
/*     */     } 
/*     */     if (Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("Premium CubeFly")) {
/*     */       mc.thePlayer.motionY = -0.800000011920929D;
/*     */       this.otherCounter = 0;
/*     */     } 
/*     */     if (Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("McCentral Fly"))
/*     */       MovementUtils.setSpeed(0.0D); 
/*     */     if (Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("RedeSky Fly"))
/*     */       MovementUtils.setSpeed(0.0D); 
/*     */     Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("JartexNetwork Fly");
/*     */     Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("Mineplex Fly");
/*     */     Main.instance.setmgr.getSettingByName("FLY_MODE").getValString().equalsIgnoreCase("CCTEST Fly");
/*     */     mc.timer.timerSpeed = 1.0F;
/*     */     mc.thePlayer.capabilities.isFlying = false;
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public void onJump(EventJump e) {}
/*     */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\movement\Fly.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */