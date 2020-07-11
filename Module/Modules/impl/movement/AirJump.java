/*    */ package me.lavache.BaseClient.Module.Modules.impl.movement;
/*    */ 
/*    */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*    */ import me.lavache.BaseClient.Eventbus.Events.EventUpdate;
/*    */ import me.lavache.BaseClient.Module.Category;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ 
/*    */ 
/*    */ public class AirJump
/*    */   extends Module
/*    */ {
/* 12 */   public AirJump() { super("AirJump", 0, Category.MOVEMENT); }
/*    */ 
/*    */ 
/*    */   
/*    */   @EventTarget
/* 17 */   public void onUpdate(EventUpdate e) { mc.thePlayer.onGround = true; }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\movement\AirJump.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */