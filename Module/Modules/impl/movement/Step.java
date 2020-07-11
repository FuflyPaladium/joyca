/*    */ package me.lavache.BaseClient.Module.Modules.impl.movement;
/*    */ 
/*    */ import de.Hero.settings.Setting;
/*    */ import java.util.ArrayList;
/*    */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*    */ import me.lavache.BaseClient.Eventbus.Events.EventUpdate;
/*    */ import me.lavache.BaseClient.Main;
/*    */ import me.lavache.BaseClient.Module.Category;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Step
/*    */   extends Module
/*    */ {
/* 17 */   public Step() { super("Step", 0, Category.MOVEMENT); }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setup() {
/* 22 */     ArrayList<String> options = new ArrayList<String>();
/* 23 */     Main.instance.setmgr.rSetting(new Setting("Step Height", this, 1.0D, 1.0D, 3.0D, true));
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public void onUpdate(EventUpdate e) {
/* 28 */     if (mc.thePlayer.isCollidedHorizontally) {
/* 29 */       mc.thePlayer.stepHeight = (float)Main.instance.setmgr.getSettingByName("Step Height").getValDouble();
/*    */     } else {
/* 31 */       mc.thePlayer.stepHeight = 0.5F;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\movement\Step.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */