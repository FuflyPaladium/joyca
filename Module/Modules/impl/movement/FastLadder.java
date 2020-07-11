/*    */ package me.lavache.BaseClient.Module.Modules.impl.movement;
/*    */ 
/*    */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*    */ import me.lavache.BaseClient.Eventbus.Events.EventUpdate;
/*    */ import me.lavache.BaseClient.Module.Category;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ import me.lavache.BaseClient.Utils.MovementUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FastLadder
/*    */   extends Module
/*    */ {
/* 15 */   public FastLadder() { super("FastLadder", 0, Category.MOVEMENT); }
/*    */ 
/*    */ 
/*    */   
/*    */   @EventTarget
/*    */   public void onUpdate(EventUpdate e) {
/* 21 */     if (mc.gameSettings.keyBindForward.isKeyDown() && mc.thePlayer.isOnLadder()) {
/* 22 */       if (mc.thePlayer.ticksExisted % 3 == 0) {
/* 23 */         mc.thePlayer.motionY = 0.5D;
/* 24 */         mc.thePlayer.isOnLadder();
/*    */       } else {
/* 26 */         mc.thePlayer.motionY = 0.0D;
/*    */       } 
/*    */     }
/* 29 */     if (mc.gameSettings.keyBindSneak.isKeyDown() && mc.thePlayer.isOnLadder()) {
/* 30 */       MovementUtils.vClip(-1.0D);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 36 */   public void onDisable() { super.onDisable(); }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\movement\FastLadder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */