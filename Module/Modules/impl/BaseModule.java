/*    */ package me.lavache.BaseClient.Module.Modules.impl;
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
/*    */ public class BaseModule
/*    */   extends Module
/*    */ {
/* 17 */   public BaseModule() { super("BaseModule", 0, Category.COMBAT); }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setup() {
/* 22 */     ArrayList<String> options = new ArrayList<String>();
/* 23 */     options.add("1MODE");
/* 24 */     options.add("2MODE");
/*    */     
/* 26 */     Main.instance.setmgr.rSetting(new Setting("BASE_MODE", this, "1MODE", options));
/* 27 */     Main.instance.setmgr.rSetting(new Setting("Slider", this, 10.0D, 1.0D, 20.0D, true));
/* 28 */     Main.instance.setmgr.rSetting(new Setting("Boolean", this, false));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 33 */   public void onEnable() { super.onEnable(); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 38 */   public void onDisable() { super.onDisable(); }
/*    */ 
/*    */   
/*    */   @EventTarget
/*    */   public void onUpdate(EventUpdate e) {
/* 43 */     if (mc.thePlayer.ticksExisted % 100 == 0) {
/* 44 */       String oof = mc.currentScreen.getClass().getName();
/* 45 */       mc.thePlayer.sendChatMessage(oof);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\BaseModule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */