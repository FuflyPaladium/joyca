/*    */ package me.lavache.BaseClient.Module.Modules.impl.movement;
/*    */ 
/*    */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*    */ import me.lavache.BaseClient.Eventbus.Events.EventUpdate;
/*    */ import me.lavache.BaseClient.Module.Category;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ import me.lavache.BaseClient.Utils.MovementUtils;
/*    */ 
/*    */ 
/*    */ public class Spider
/*    */   extends Module
/*    */ {
/* 13 */   public Spider() { super("Spider", 21, Category.MOVEMENT); }
/*    */   
/*    */   @EventTarget
/*    */   public void onUpdate(EventUpdate e) {
/* 17 */     if (mc.thePlayer.isCollidedHorizontally && mc.gameSettings.keyBindForward.isKeyDown())
/* 18 */     { mc.timer.timerSpeed = 0.4F;
/* 19 */       if (mc.thePlayer.ticksExisted % 2 == 0) {
/* 20 */         MovementUtils.vClip(1.0D);
/*    */       } else {
/* 22 */         mc.thePlayer.motionY = 0.0D;
/*    */       }  }
/* 24 */     else { mc.timer.timerSpeed = 1.0F; }
/*    */   
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\movement\Spider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */