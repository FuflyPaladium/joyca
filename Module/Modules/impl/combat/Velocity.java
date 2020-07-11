/*    */ package me.lavache.BaseClient.Module.Modules.impl.combat;
/*    */ 
/*    */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*    */ import me.lavache.BaseClient.Eventbus.Events.EventAntiKB;
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
/*    */ public class Velocity
/*    */   extends Module
/*    */ {
/* 23 */   public Velocity() { super("Velocity", 0, Category.COMBAT); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 28 */   public void onDisable() { super.onDisable(); }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 34 */   public void onEnable() { super.onEnable(); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @EventTarget
/* 40 */   public void onVelocity(EventAntiKB event) { event.setCancelled(true); }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\combat\Velocity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */