/*    */ package me.lavache.BaseClient.Utils.fileManagers;
/*    */ 
/*    */ import me.lavache.BaseClient.Main;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ import net.skidworld.libs.Filer;
/*    */ 
/*    */ public class FileManager
/*    */ {
/*  9 */   public static FileManager fileManagerInstance = new FileManager();
/*    */   
/* 11 */   private Filer modsFile = new Filer("modules", Main.instance.name);
/* 12 */   private Filer friendsFile = new Filer("friends", Main.instance.name);
/*    */   
/*    */   public FileManager() {
/*    */     try {
/* 16 */       loadModules();
/* 17 */     } catch (Exception e) {
/* 18 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void saveModules() {
/* 23 */     this.modsFile.clear();
/* 24 */     for (Module m : Main.instance.moduleManager.getModules()) {
/* 25 */       String line = String.valueOf(m.getDisplayName()) + ":" + m.getKey();
/* 26 */       this.modsFile.write(line);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void loadModules() {
/* 31 */     for (String str : this.modsFile.read()) {
/* 32 */       for (Module m : Main.instance.moduleManager.getModules()) {
/* 33 */         String[] mInfos = str.split(":");
/* 34 */         String mName = mInfos[0];
/* 35 */         int mKey = Integer.parseInt(mInfos[1]);
/* 36 */         if (m.getName().equalsIgnoreCase(mName))
/* 37 */           m.setKey(mKey); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Utils\fileManagers\FileManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */