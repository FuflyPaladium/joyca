/*     */ package me.lavache.BaseClient.Module.Modules.impl.movement;
/*     */ 
/*     */ import de.Hero.settings.Setting;
/*     */ import java.util.ArrayList;
/*     */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*     */ import me.lavache.BaseClient.Eventbus.Events.EventJump;
/*     */ import me.lavache.BaseClient.Eventbus.Events.EventMotion;
/*     */ import me.lavache.BaseClient.Eventbus.Events.EventUpdate;
/*     */ import me.lavache.BaseClient.Main;
/*     */ import me.lavache.BaseClient.Module.Category;
/*     */ import me.lavache.BaseClient.Module.Module;
/*     */ import me.lavache.BaseClient.Utils.MovementUtils;
/*     */ import me.lavache.BaseClient.Utils.TimeHelper;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Speed
/*     */   extends Module
/*     */ {
/*     */   private boolean boost = true;
/*  21 */   private int speedTickCounter = 0;
/*     */   
/*  23 */   private TimeHelper spartanTimer = new TimeHelper();
/*     */ 
/*     */   
/*  26 */   public Speed() { super("Speed", 46, Category.MOVEMENT); }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setup() {
/*  31 */     ArrayList<String> options = new ArrayList<String>();
/*  32 */     options.add("Vanilla");
/*  33 */     options.add("CubeSpeed");
/*  34 */     options.add("AAC 4");
/*  35 */     options.add("Matrix");
/*  36 */     options.add("Spartan");
/*  37 */     Main.instance.setmgr.rSetting(new Setting("SPEED_MODE", this, "Vanilla", options));
/*     */   }
/*     */ 
/*     */   
/*     */   public void onDisable() {
/*  42 */     mc.timer.timerSpeed = 1.0F;
/*  43 */     if (Main.instance.setmgr.getSettingByName("SPEED_MODE").getValString().equalsIgnoreCase("CubeSpeed")) {
/*  44 */       mc.thePlayer.motionY = -1.0D;
/*  45 */       MovementUtils.setSpeed(0.0D);
/*     */     } 
/*  47 */     if (Main.instance.setmgr.getSettingByName("SPEED_MODE").getValString().equalsIgnoreCase("AAC 4"))
/*  48 */       mc.thePlayer.speedInAir = 0.02F; 
/*  49 */     super.onDisable();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onEnable() {
/*  54 */     super.onEnable();
/*  55 */     if (Main.instance.setmgr.getSettingByName("SPEED_MODE").getValString().equalsIgnoreCase("CubeSpeed")) {
/*  56 */       mc.timer.timerSpeed = 0.4F;
/*  57 */       MovementUtils.Damage();
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public void onSpeedalawkba(EventUpdate e) {
/*  63 */     if (Main.instance.setmgr.getSettingByName("SPEED_MODE").getValString().equalsIgnoreCase("Vanilla") && 
/*  64 */       MovementUtils.isMoving()) {
/*  65 */       MovementUtils.setSpeed(1.0D);
/*     */     }
/*     */     
/*  68 */     if (Main.instance.setmgr.getSettingByName("SPEED_MODE").getValString().equalsIgnoreCase("CubeSpeed")) {
/*  69 */       MovementUtils.disableMovements();
/*  70 */       mc.timer.timerSpeed = 0.4F;
/*  71 */       if (!mc.thePlayer.onGround) {
/*  72 */         if (mc.thePlayer.ticksExisted % 4 == 0) {
/*  73 */           MovementUtils.forward(1.0D);
/*  74 */           mc.thePlayer.motionY = -0.20000000298023224D;
/*     */         } 
/*     */       } else {
/*  77 */         mc.thePlayer.motionY = 0.4000000059604645D;
/*     */       } 
/*     */     } 
/*  80 */     if (Main.instance.setmgr.getSettingByName("SPEED_MODE").getValString().equalsIgnoreCase("AAC 4")) {
/*  81 */       if (mc.thePlayer.onGround) {
/*  82 */         mc.thePlayer.setSprinting(false);
/*  83 */         mc.thePlayer.jump();
/*  84 */         mc.thePlayer.speedInAir = 0.0201F;
/*  85 */         mc.timer.timerSpeed = 1.05F;
/*     */       } else {
/*  87 */         mc.thePlayer.setSprinting(true);
/*     */       } 
/*  89 */       if (mc.thePlayer.fallDistance > 0.3D && mc.thePlayer.fallDistance < 1.1F) {
/*  90 */         mc.thePlayer.speedInAir = 0.02F;
/*  91 */         mc.timer.timerSpeed = 1.5F;
/*     */       } 
/*     */     } 
/*  94 */     if (Main.instance.setmgr.getSettingByName("SPEED_MODE").getValString().equalsIgnoreCase("Matrix")) {
/*  95 */       if (mc.thePlayer.onGround) {
/*  96 */         mc.timer.timerSpeed = 1.0F;
/*  97 */         mc.thePlayer.jump();
/*  98 */         mc.thePlayer.setSprinting(false);
/*  99 */         mc.thePlayer.speedInAir = 0.02F;
/*     */       } else {
/* 101 */         mc.thePlayer.setSprinting(true);
/* 102 */         mc.thePlayer.speedInAir = 0.025F;
/*     */       } 
/* 104 */       if (mc.thePlayer.fallDistance > 0.2F) {
/* 105 */         mc.timer.timerSpeed = 1.1F;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public void onMotion(EventMotion e) {
/* 112 */     if (Main.instance.setmgr.getSettingByName("SPEED_MODE").getValString().equalsIgnoreCase("Spartan")) {
/* 113 */       if (TimeHelper.delayOver(100L)) {
/* 114 */         this.boost = !this.boost;
/* 115 */         TimeHelper.reset();
/*     */       } 
/* 117 */       if (this.boost) {
/* 118 */         mc.thePlayer.setSprinting(false);
/* 119 */         mc.timer.timerSpeed = 1.5F;
/*     */       } else {
/*     */         
/* 122 */         mc.thePlayer.setSprinting(false);
/* 123 */         mc.timer.timerSpeed = 0.9F;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public void onJumpWakbar(EventJump e) {}
/*     */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\movement\Speed.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */