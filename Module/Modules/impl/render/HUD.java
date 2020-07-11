/*    */ package me.lavache.BaseClient.Module.Modules.impl.render;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.Comparator;
/*    */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*    */ import me.lavache.BaseClient.Eventbus.Events.Event2D;
/*    */ import me.lavache.BaseClient.Main;
/*    */ import me.lavache.BaseClient.Module.Category;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ import me.lavache.BaseClient.Utils.font.GlyphPageFontRenderer;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.gui.ScaledResolution;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HUD
/*    */   extends Module
/*    */ {
/* 27 */   GlyphPageFontRenderer oof = GlyphPageFontRenderer.create("Impact", 50, false, false, false);
/* 28 */   GlyphPageFontRenderer module = GlyphPageFontRenderer.create("Liberation Mono", 30, false, false, false);
/*    */ 
/*    */   
/* 31 */   public HUD() { super("HUD", 25, Category.RENDER); }
/*    */ 
/*    */ 
/*    */   
/*    */   @EventTarget
/*    */   private void onRender(Event2D event) {
/* 37 */     GL11.glPushMatrix();
/* 38 */     GL11.glScalef(1.5F, 1.5F, 1.5F);
/* 39 */     this.oof.drawString(Main.instance.name, 2.0F, 4.0F, -1, true);
/* 40 */     GL11.glScalef(1.0F, 1.0F, 1.0F);
/* 41 */     GL11.glPopMatrix();
/* 42 */     GL11.glPushMatrix();
/* 43 */     GL11.glScalef(0.5F, 0.5F, 0.5F);
/* 44 */     this.oof.drawString("By NOctu", 10.0F, 100.0F, -1, true);
/* 45 */     GL11.glScalef(1.0F, 1.0F, 1.0F);
/* 46 */     GL11.glPopMatrix();
/*    */ 
/*    */     
/* 49 */     mc; Minecraft.fontRendererObj.drawString("", 0.0F, 0.0F, 268435455, true);
/*    */     
/* 51 */     int index = 0;
/* 52 */     int yCount = 1;
/*    */     
/* 54 */     ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
/* 55 */     ArrayList<Module> mods = Main.instance.moduleManager.getModules();
/*    */     
/* 57 */     Collections.sort(Main.instance.moduleManager.getModules(), new Comparator<Module>() {
/*    */           public int compare(Module m1, Module m2) {
/* 59 */             if (Minecraft.fontRendererObj.getStringWidth(m1.getDisplayName()) > Minecraft.fontRendererObj.getStringWidth(m2.getDisplayName())) {
/* 60 */               return -1;
/*    */             }
/* 62 */             if (Minecraft.fontRendererObj.getStringWidth(m1.getDisplayName()) < Minecraft.fontRendererObj.getStringWidth(m2.getDisplayName())) {
/* 63 */               return 1;
/*    */             }
/* 65 */             return 0;
/*    */           }
/*    */         });
/* 68 */     for (Module m : mods) {
/* 69 */       if (m.isToggled() && m.getDisplayName() != "ClickGUI") {
/* 70 */         Gui.drawRect((sr.getScaledWidth() - this.module.getStringWidth(m.getName()) - 6), yCount, sr.getScaledWidth(), (yCount + 18), -2147483648);
/* 71 */         Gui.drawRect((sr.getScaledWidth() - this.module.getStringWidth(m.getName()) - 6), yCount, (sr.getScaledWidth() - this.module.getStringWidth(m.getName())) - 2.5D, (yCount + 18), (m.getCategory()).color);
/* 72 */         this.module.drawString(m.getDisplayName(), (sr.getScaledWidth() - this.module.getStringWidth(m.getDisplayName()) - 1), (int)(yCount + 1.3D), -1, false);
/* 73 */         yCount += 18;
/* 74 */         index++;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\render\HUD.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */