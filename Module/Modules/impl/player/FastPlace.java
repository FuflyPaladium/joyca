/*    */ package me.lavache.BaseClient.Module.Modules.impl.player;
/*    */ 
/*    */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*    */ import me.lavache.BaseClient.Eventbus.Events.EventUpdate;
/*    */ import me.lavache.BaseClient.Module.Category;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FastPlace
/*    */   extends Module
/*    */ {
/* 13 */   public FastPlace() { super("FastPlace", 0, Category.PLAYER); }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onDisable() {
/* 18 */     super.onDisable();
/* 19 */     mc.rightClickDelayTimer = 1;
/*    */   }
/*    */ 
/*    */   
/*    */   @EventTarget
/* 24 */   public void onUpdate(EventUpdate e) { mc.rightClickDelayTimer = 0; }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\player\FastPlace.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */