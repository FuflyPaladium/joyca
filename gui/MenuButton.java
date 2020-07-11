/*    */ package me.lavache.BaseClient.gui;
/*    */ 
/*    */ import me.lavache.BaseClient.Utils.font.GlyphPageFontRenderer;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.gui.GuiOptionButton;
/*    */ 
/*    */ public class MenuButton extends GuiOptionButton {
/*  9 */   GlyphPageFontRenderer oof = GlyphPageFontRenderer.create("Arial", 40, false, false, false);
/*    */   
/*    */   private int x;
/*    */   private int y;
/*    */   private int x1;
/*    */   private int y1;
/*    */   private String text;
/*    */   
/*    */   public MenuButton(int par1, int par2, int par3, int par4, int par5, String par6Str) {
/* 18 */     super(par1, par2, par3, par4, par5, par6Str);
/* 19 */     this.x = par2;
/* 20 */     this.y = par3;
/* 21 */     this.x1 = par4;
/* 22 */     this.y1 = par5;
/* 23 */     this.text = par6Str;
/*    */   }
/*    */ 
/*    */   
/* 27 */   public MenuButton(int i, int j, int k, String stringParams) { this(i, j, k, 200, 20, stringParams); }
/*    */ 
/*    */   
/*    */   public void drawButton(Minecraft mc, int mouseX, int mouseY) {
/* 31 */     boolean isOverButton = (mouseX >= this.x - 25 && mouseX <= this.x + this.x1 + 25 && mouseY >= this.y && mouseY <= this.y + this.y1);
/* 32 */     if (this.visible)
/* 33 */       if (isOverButton) {
/* 34 */         Gui.drawRect((this.xPosition - 25), this.yPosition, (this.xPosition + this.width + 28), (this.yPosition + this.height), -4242107);
/* 35 */         this.oof.drawString(this.displayString, (this.xPosition + this.width / 2 - this.oof.getStringWidth(this.displayString) / 2), (this.yPosition + this.height / 2 - 12), -1, false);
/*    */       } else {
/* 37 */         Gui.drawRect((this.xPosition - 25), this.yPosition, (this.xPosition + this.width + 28), (this.yPosition + this.height), -6736330);
/* 38 */         this.oof.drawString(this.displayString, (this.xPosition + this.width / 2 - this.oof.getStringWidth(this.displayString) / 2), (this.yPosition + this.height / 2 - 12), -1, false);
/*    */       }  
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\gui\MenuButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */