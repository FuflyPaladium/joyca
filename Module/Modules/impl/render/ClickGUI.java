/*    */ package me.lavache.BaseClient.Module.Modules.impl.render;
/*    */ 
/*    */ import de.Hero.settings.Setting;
/*    */ import java.util.ArrayList;
/*    */ import me.lavache.BaseClient.Main;
/*    */ import me.lavache.BaseClient.Module.Category;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ClickGUI
/*    */   extends Module
/*    */ {
/* 14 */   public ClickGUI() { super("ClickGUI", 54, Category.RENDER); }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setup() {
/* 19 */     ArrayList<String> options = new ArrayList<String>();
/* 20 */     options.add("New");
/* 21 */     options.add("JellyLike");
/* 22 */     Main.instance.setmgr.rSetting(new Setting("Design", this, "New", options));
/* 23 */     Main.instance.setmgr.rSetting(new Setting("Sound", this, false));
/* 24 */     Main.instance.setmgr.rSetting(new Setting("GuiRed", this, 255.0D, 0.0D, 255.0D, true));
/* 25 */     Main.instance.setmgr.rSetting(new Setting("GuiGreen", this, 26.0D, 0.0D, 255.0D, true));
/* 26 */     Main.instance.setmgr.rSetting(new Setting("GuiBlue", this, 42.0D, 0.0D, 255.0D, true));
/*    */   }
/*    */ 
/*    */   
/*    */   public void onEnable() {
/* 31 */     super.onEnable();
/*    */     
/* 33 */     mc.displayGuiScreen(Main.instance.clickGui);
/* 34 */     toggle();
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\render\ClickGUI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */