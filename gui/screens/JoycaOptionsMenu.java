/*    */ package me.lavache.BaseClient.gui.screens;
/*    */ 
/*    */ import me.lavache.BaseClient.Utils.Anims.Translate;
/*    */ import me.lavache.BaseClient.Utils.RenderUtils;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.client.gui.ScaledResolution;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JoycaOptionsMenu
/*    */   extends GuiScreen
/*    */ {
/* 16 */   private static Minecraft mc = Minecraft.getMinecraft();
/* 17 */   Translate ts = new Translate(0.0F, 0.0F);
/*    */ 
/*    */   
/*    */   public void initGui() {}
/*    */ 
/*    */   
/* 23 */   public void updateScreen() { super.updateScreen(); }
/*    */   
/*    */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 26 */     drawBackground(mouseX, mouseY);
/* 27 */     drawTitle();
/* 28 */     drawIntroduction();
/*    */   }
/*    */   
/*    */   private void drawTitle() {
/* 32 */     ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
/* 33 */     RenderUtils.drawImage(new ResourceLocation("textures/joyca/title.png"), sr.getScaledWidth() / 2 + 20, sr.getScaledHeight() / 2 - 270, 400, 200);
/*    */   }
/*    */   
/*    */   private void drawIntroduction() {
/* 37 */     ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
/*    */     
/* 39 */     this.ts.interpolate(sr.getScaledWidth(), 0.0F, 1.5D);
/* 40 */     Gui.drawRect(this.ts.getX(), 0.0D, sr.getScaledWidth(), sr.getScaledHeight(), -1);
/* 41 */     Gui.drawRect((this.ts.getX() + 50.0F), 0.0D, sr.getScaledWidth(), sr.getScaledHeight(), -13619409);
/*    */   }
/*    */   
/*    */   private void drawBackground(int mouseX, int mouseY) {
/* 45 */     ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
/* 46 */     RenderUtils.drawImage(new ResourceLocation("textures/joyca/optionsBackground.png"), mouseX / 40 - 50, mouseY / 40 - 50, sr.getScaledWidth() + 50, sr.getScaledHeight() + 50);
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\gui\screens\JoycaOptionsMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */