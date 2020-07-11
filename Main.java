/*    */ package me.lavache.BaseClient;
/*    */ 
/*    */ import de.Hero.clickgui.ClickGUI;
/*    */ import de.Hero.settings.SettingsManager;
/*    */ import me.lavache.BaseClient.Eventbus.EventManager;
/*    */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*    */ import me.lavache.BaseClient.Eventbus.Events.EventKey;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ import me.lavache.BaseClient.Module.ModuleManager;
/*    */ import me.lavache.BaseClient.Utils.fileManagers.FileManager;
/*    */ import org.lwjgl.opengl.Display;
/*    */ 
/*    */ public class Main
/*    */ {
/* 15 */   public String name = "Joyca"; public String verssion = "0.1"; public String creator = "Noctuman";
/*    */   
/* 17 */   public static Main instance = new Main();
/*    */   
/*    */   public SettingsManager setmgr;
/* 20 */   public EventManager eventManager = new EventManager();
/*    */   public ModuleManager moduleManager;
/*    */   public ClickGUI clickGui;
/*    */   public FileManager fileManager;
/*    */   
/*    */   public void startClient() {
/* 26 */     Display.setTitle("Joyca Client -DEV");
/* 27 */     this.setmgr = new SettingsManager();
/* 28 */     EventManager.register(this);
/* 29 */     this.moduleManager = new ModuleManager();
/* 30 */     this.clickGui = new ClickGUI();
/* 31 */     this.fileManager = new FileManager();
/*    */     
/* 33 */     postInit();
/*    */   }
/*    */ 
/*    */   
/* 37 */   private void postInit() { instance.moduleManager.getModuleByName("HUD").toggle(); }
/*    */ 
/*    */   
/*    */   public void stopClient() {
/*    */     try {
/* 42 */       FileManager.fileManagerInstance.saveModules();
/* 43 */     } catch (Exception e) {
/* 44 */       e.printStackTrace();
/*    */     } 
/* 46 */     EventManager.unregister(this);
/*    */   }
/*    */ 
/*    */   
/*    */   @EventTarget
/* 51 */   public void onKey(EventKey event) { this.moduleManager.getModules().stream().filter(module -> (module.getKey() == paramEventKey.getKey())).forEach(module -> module.toggle()); }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */