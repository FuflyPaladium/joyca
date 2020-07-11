/*    */ package me.lavache.BaseClient.Module.Modules.impl.movement;
/*    */ 
/*    */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*    */ import me.lavache.BaseClient.Eventbus.Events.EventUpdate;
/*    */ import me.lavache.BaseClient.Module.Category;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FastFall
/*    */   extends Module
/*    */ {
/* 13 */   public FastFall() { super("FastFall", 0, Category.MOVEMENT); }
/*    */ 
/*    */   
/*    */   @EventTarget
/*    */   public void onUpdate(EventUpdate e) {
/* 18 */     if (mc.thePlayer.fallDistance > 0.5F)
/* 19 */       mc.thePlayer.motionY = -5.0D; 
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\movement\FastFall.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */