/*    */ package me.lavache.BaseClient.Module;
/*    */ 
/*    */ import me.lavache.BaseClient.Main;
/*    */ import net.minecraft.client.Minecraft;
/*    */ 
/*    */ public class Module {
/*  7 */   protected static Minecraft mc = Minecraft.getMinecraft();
/*    */   private String name;
/*    */   private String displayName;
/*    */   private int key;
/*    */   private Category category;
/*    */   private boolean toggled;
/*    */   
/*    */   public Module(String name, int key, Category category) {
/* 15 */     this.name = name;
/* 16 */     this.key = key;
/* 17 */     this.category = category;
/* 18 */     this.toggled = false;
/*    */     
/* 20 */     setup();
/*    */   }
/*    */ 
/*    */   
/* 24 */   public void onEnable() { Main.instance.eventManager.register(this); }
/*    */ 
/*    */   
/* 27 */   public void onDisable() { Main.instance.eventManager.unregister(this); }
/*    */   
/*    */   public void onToggle() {}
/*    */   
/*    */   public void toggle() {
/* 32 */     this.toggled = !this.toggled;
/* 33 */     onToggle();
/* 34 */     if (this.toggled) {
/* 35 */       onEnable();
/*    */     } else {
/* 37 */       onDisable();
/*    */     } 
/*    */   }
/* 40 */   public String getName() { return this.name; }
/*    */ 
/*    */   
/* 43 */   public void setName(String name) { this.name = name; }
/*    */ 
/*    */   
/* 46 */   public int getKey() { return this.key; }
/*    */ 
/*    */   
/* 49 */   public void setKey(int key) { this.key = key; }
/*    */ 
/*    */   
/* 52 */   public Category getCategory() { return this.category; }
/*    */ 
/*    */   
/* 55 */   public void setCategory(Category category) { this.category = category; }
/*    */ 
/*    */   
/* 58 */   public void setState(boolean state) { this.toggled = state; }
/*    */ 
/*    */   
/* 61 */   public boolean isToggled() { return this.toggled; }
/*    */ 
/*    */   
/* 64 */   public String getDisplayName() { return (this.displayName == null) ? this.name : this.displayName; }
/*    */ 
/*    */   
/* 67 */   public void setDisplayName(String displayName) { this.displayName = displayName; }
/*    */   
/*    */   public void setup() {}
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Module.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */