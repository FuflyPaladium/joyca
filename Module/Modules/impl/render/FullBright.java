/*    */ package me.lavache.BaseClient.Module.Modules.impl.render;
/*    */ 
/*    */ import de.Hero.settings.Setting;
/*    */ import java.util.ArrayList;
/*    */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*    */ import me.lavache.BaseClient.Eventbus.Events.EventUpdate;
/*    */ import me.lavache.BaseClient.Main;
/*    */ import me.lavache.BaseClient.Module.Category;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ import net.minecraft.potion.Potion;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FullBright
/*    */   extends Module
/*    */ {
/* 20 */   public FullBright() { super("FullBright", 0, Category.RENDER); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setup() {
/* 26 */     ArrayList<String> options = new ArrayList<String>();
/* 27 */     options.add("Gamma");
/* 28 */     options.add("Night Vision");
/* 29 */     Main.instance.setmgr.rSetting(new Setting("FULLBRIGHT_MODE", this, "Gamma", options));
/*    */   }
/*    */ 
/*    */   
/*    */   public void onEnable() {
/* 34 */     super.onEnable();
/* 35 */     if (Main.instance.setmgr.getSettingByName("FULLBRIGHT_MODE").getValString().equalsIgnoreCase("Gamma"))
/* 36 */       mc.gameSettings.gammaSetting = 20.0F; 
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public void onUpdate(EventUpdate e) {
/* 41 */     if (Main.instance.setmgr.getSettingByName("FULLBRIGHT_MODE").getValString().equalsIgnoreCase("Night Vision")) {
/* 42 */       mc.thePlayer.addPotionEffect(new PotionEffect(Potion.nightVision.id, 860, 10));
/*    */     }
/*    */   }
/*    */   
/*    */   public void onDisable() {
/* 47 */     super.onDisable();
/* 48 */     if (Main.instance.setmgr.getSettingByName("FULLBRIGHT_MODE").getValString().equalsIgnoreCase("Night Vision"))
/* 49 */       mc.thePlayer.clearActivePotions(); 
/* 50 */     if (Main.instance.setmgr.getSettingByName("FULLBRIGHT_MODE").getValString().equalsIgnoreCase("Gamma"))
/* 51 */       mc.gameSettings.gammaSetting = 1.0F; 
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\render\FullBright.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */