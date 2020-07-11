/*    */ package me.lavache.BaseClient.Module.Modules.impl.player;
/*    */ 
/*    */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*    */ import me.lavache.BaseClient.Eventbus.Events.EventUpdate;
/*    */ import me.lavache.BaseClient.Module.Category;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ import me.lavache.BaseClient.Utils.MovementUtils;
/*    */ 
/*    */ 
/*    */ public class NoVoid
/*    */   extends Module
/*    */ {
/* 13 */   public NoVoid() { super("NoVoid", 0, Category.PLAYER); }
/*    */ 
/*    */   
/*    */   @EventTarget
/* 17 */   public void onUpdate(EventUpdate e) { if (!mc.thePlayer.onGround) MovementUtils.isFalling();  }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\player\NoVoid.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */