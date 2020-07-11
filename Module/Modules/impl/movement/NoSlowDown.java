/*    */ package me.lavache.BaseClient.Module.Modules.impl.movement;
/*    */ 
/*    */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*    */ import me.lavache.BaseClient.Eventbus.Events.EventUpdate;
/*    */ import me.lavache.BaseClient.Module.Category;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NoSlowDown
/*    */   extends Module
/*    */ {
/* 18 */   public NoSlowDown() { super("NoWeb", 0, Category.MOVEMENT); }
/*    */ 
/*    */   
/*    */   @EventTarget
/*    */   public void onUpdate(EventUpdate e) {
/* 23 */     if (!mc.thePlayer.isInWeb)
/*    */       return; 
/* 25 */     mc.timer.timerSpeed = 0.8F;
/* 26 */     mc.thePlayer.isInWeb = false;
/*    */   }
/*    */   
/*    */   public void onDisable() {
/* 30 */     super.onDisable();
/* 31 */     mc.timer.timerSpeed = 1.0F;
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\movement\NoSlowDown.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */