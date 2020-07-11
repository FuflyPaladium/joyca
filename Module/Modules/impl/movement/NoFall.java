/*    */ package me.lavache.BaseClient.Module.Modules.impl.movement;
/*    */ 
/*    */ import de.Hero.settings.Setting;
/*    */ import java.util.ArrayList;
/*    */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*    */ import me.lavache.BaseClient.Eventbus.Events.EventUpdate;
/*    */ import me.lavache.BaseClient.Main;
/*    */ import me.lavache.BaseClient.Module.Category;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ import me.lavache.BaseClient.Utils.MovementUtils;
/*    */ import net.minecraft.network.play.client.C03PacketPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NoFall
/*    */   extends Module
/*    */ {
/* 21 */   public NoFall() { super("NoFall", 0, Category.MOVEMENT); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setup() {
/* 27 */     ArrayList<String> options = new ArrayList<String>();
/* 28 */     options.add("Vanilla");
/* 29 */     options.add("DamageReducor");
/* 30 */     options.add("Catch");
/* 31 */     Main.instance.setmgr.rSetting(new Setting("NOFALL_MODE", this, "Vanilla", options));
/*    */   }
/*    */ 
/*    */   
/*    */   public void onDisable() {
/* 36 */     super.onDisable();
/* 37 */     mc.thePlayer.capabilities.isFlying = false;
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public void onUpdate(EventUpdate e) {
/* 42 */     if (Main.instance.setmgr.getSettingByName("NOFALL_MODE").getValString().equalsIgnoreCase("Vanilla") && 
/* 43 */       mc.thePlayer.fallDistance > 2.0F) {
/* 44 */       mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
/* 45 */       mc.thePlayer.onGround = true;
/*    */     } 
/*    */     
/* 48 */     if (Main.instance.setmgr.getSettingByName("NOFALL_MODE").getValString().equalsIgnoreCase("DamageReducor")) {
/* 49 */       if (mc.thePlayer.fallDistance > 4.0F && !mc.thePlayer.onGround && !mc.thePlayer.isCollidedVertically) {
/* 50 */         mc.timer.timerSpeed = 0.4F;
/* 51 */         MovementUtils.setSpeed(0.0D);
/* 52 */         mc.thePlayer.motionY = 0.0D;
/* 53 */         mc.thePlayer.fallDistance = 0.0F;
/* 54 */         mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer());
/*    */       } else {
/* 56 */         mc.timer.timerSpeed = 1.0F;
/*    */       } 
/*    */     }
/* 59 */     if (Main.instance.setmgr.getSettingByName("NOFALL_MODE").getValString().equalsIgnoreCase("Catch")) {
/* 60 */       mc.thePlayer.onGround = true;
/* 61 */       mc.thePlayer.capabilities.isFlying = true;
/* 62 */       MovementUtils.Damage();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\movement\NoFall.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */