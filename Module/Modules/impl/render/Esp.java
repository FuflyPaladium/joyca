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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Esp
/*    */   extends Module
/*    */ {
/* 23 */   public Esp() { super("Esp", 0, Category.RENDER); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setup() {
/* 29 */     ArrayList<String> options = new ArrayList<String>();
/* 30 */     Main.instance.setmgr.rSetting(new Setting("Players", this, true));
/* 31 */     Main.instance.setmgr.rSetting(new Setting("Mobs", this, false));
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\render\Esp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */