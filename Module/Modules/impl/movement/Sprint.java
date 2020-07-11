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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Sprint
/*    */   extends Module
/*    */ {
/* 23 */   public Sprint() { super("Sprint", 0, Category.MOVEMENT); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 28 */   public void onDisable() { super.onDisable(); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 33 */   public void onEnable() { super.onEnable(); }
/*    */ 
/*    */ 
/*    */   
/*    */   @EventTarget
/*    */   public void onUpdate(EventUpdate event) {
/* 39 */     if (mc.thePlayer.moveForward > 0.0F)
/* 40 */       mc.thePlayer.setSprinting(true); 
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\movement\Sprint.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */