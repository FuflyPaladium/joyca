/*     */ package me.lavache.BaseClient.Utils.font;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.font.FontRenderContext;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.util.HashMap;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.texture.DynamicTexture;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class GlyphPage {
/*     */   private int imgSize;
/*     */   private int maxFontHeight;
/*     */   private Font font;
/*     */   private boolean antiAliasing;
/*     */   private boolean fractionalMetrics;
/*     */   private HashMap<Character, Glyph> glyphCharacterMap;
/*     */   private BufferedImage bufferedImage;
/*     */   private DynamicTexture loadedTexture;
/*     */   
/*     */   public GlyphPage(Font font, boolean antiAliasing, boolean fractionalMetrics) {
/*  27 */     this.maxFontHeight = -1;
/*     */ 
/*     */ 
/*     */     
/*  31 */     this.glyphCharacterMap = new HashMap();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  37 */     this.font = font;
/*  38 */     this.antiAliasing = antiAliasing;
/*  39 */     this.fractionalMetrics = fractionalMetrics;
/*     */   }
/*     */ 
/*     */   
/*     */   public void generateGlyphPage(char[] chars) {
/*  44 */     double maxWidth = -1.0D;
/*  45 */     double maxHeight = -1.0D;
/*     */     
/*  47 */     AffineTransform affineTransform = new AffineTransform();
/*  48 */     FontRenderContext fontRenderContext = new FontRenderContext(affineTransform, this.antiAliasing, this.fractionalMetrics); byte b1; int i;
/*     */     char[] arrayOfChar1;
/*  50 */     for (i = arrayOfChar1 = chars.length, b1 = 0; b1 < i; ) { char ch = arrayOfChar1[b1];
/*  51 */       Rectangle2D bounds = this.font.getStringBounds(Character.toString(ch), fontRenderContext);
/*     */       
/*  53 */       if (maxWidth < bounds.getWidth()) maxWidth = bounds.getWidth(); 
/*  54 */       if (maxHeight < bounds.getHeight()) maxHeight = bounds.getHeight();
/*     */ 
/*     */       
/*     */       b1++; }
/*     */     
/*  59 */     maxWidth += 2.0D;
/*  60 */     maxHeight += 2.0D;
/*     */     
/*  62 */     this.imgSize = (int)Math.ceil(Math.max(
/*  63 */           Math.ceil(Math.sqrt(maxWidth * maxWidth * chars.length) / maxWidth), 
/*  64 */           Math.ceil(Math.sqrt(maxHeight * maxHeight * chars.length) / maxHeight)) * 
/*  65 */         Math.max(maxWidth, maxHeight)) + 1;
/*     */     
/*  67 */     this.bufferedImage = new BufferedImage(this.imgSize, this.imgSize, 2);
/*     */     
/*  69 */     Graphics2D g = (Graphics2D)this.bufferedImage.getGraphics();
/*     */     
/*  71 */     g.setFont(this.font);
/*     */     
/*  73 */     g.setColor(new Color(255, 255, 255, 0));
/*     */     
/*  75 */     g.fillRect(0, 0, this.imgSize, this.imgSize);
/*     */     
/*  77 */     g.setColor(Color.white);
/*     */     
/*  79 */     g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, this.fractionalMetrics ? RenderingHints.VALUE_FRACTIONALMETRICS_ON : RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
/*  80 */     g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, this.antiAliasing ? RenderingHints.VALUE_ANTIALIAS_OFF : RenderingHints.VALUE_ANTIALIAS_ON);
/*  81 */     g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, this.antiAliasing ? RenderingHints.VALUE_TEXT_ANTIALIAS_ON : RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
/*     */     
/*  83 */     FontMetrics fontMetrics = g.getFontMetrics();
/*     */     
/*  85 */     int currentCharHeight = 0;
/*  86 */     int posX = 0;
/*  87 */     int posY = 1; byte b2; int j;
/*     */     char[] arrayOfChar2;
/*  89 */     for (j = arrayOfChar2 = chars.length, b2 = 0; b2 < j; ) { char ch = arrayOfChar2[b2];
/*  90 */       Glyph glyph = new Glyph();
/*     */       
/*  92 */       Rectangle2D bounds = fontMetrics.getStringBounds(Character.toString(ch), g);
/*     */       
/*  94 */       glyph.width = (bounds.getBounds()).width + 8;
/*  95 */       glyph.height = (bounds.getBounds()).height;
/*     */       
/*  97 */       if (posY + glyph.height >= this.imgSize) {
/*  98 */         throw new IllegalStateException("Not all characters will fit");
/*     */       }
/*     */       
/* 101 */       if (posX + glyph.width >= this.imgSize) {
/* 102 */         posX = 0;
/* 103 */         posY += currentCharHeight;
/* 104 */         currentCharHeight = 0;
/*     */       } 
/*     */       
/* 107 */       glyph.x = posX;
/* 108 */       glyph.y = posY;
/*     */       
/* 110 */       if (glyph.height > this.maxFontHeight) this.maxFontHeight = glyph.height;
/*     */       
/* 112 */       if (glyph.height > currentCharHeight) currentCharHeight = glyph.height;
/*     */       
/* 114 */       g.drawString(Character.toString(ch), posX + 2, posY + fontMetrics.getAscent());
/*     */       
/* 116 */       posX += glyph.width;
/*     */       
/* 118 */       this.glyphCharacterMap.put(Character.valueOf(ch), glyph);
/*     */       b2++; }
/*     */   
/*     */   }
/*     */ 
/*     */   
/* 124 */   public void setupTexture() { this.loadedTexture = new DynamicTexture(this.bufferedImage); }
/*     */ 
/*     */ 
/*     */   
/* 128 */   public void bindTexture() { GlStateManager.bindTexture(this.loadedTexture.getGlTextureId()); }
/*     */ 
/*     */ 
/*     */   
/* 132 */   public void unbindTexture() { GlStateManager.bindTexture(0); }
/*     */ 
/*     */   
/*     */   public float drawChar(char ch, float x, float y) {
/* 136 */     Glyph glyph = (Glyph)this.glyphCharacterMap.get(Character.valueOf(ch));
/*     */     
/* 138 */     if (glyph == null) throw new IllegalArgumentException("'" + ch + "' wasn't found");
/*     */     
/* 140 */     float pageX = glyph.x / this.imgSize;
/* 141 */     float pageY = glyph.y / this.imgSize;
/*     */     
/* 143 */     float pageWidth = glyph.width / this.imgSize;
/* 144 */     float pageHeight = glyph.height / this.imgSize;
/*     */     
/* 146 */     float width = glyph.width;
/* 147 */     float height = glyph.height;
/*     */     
/* 149 */     GL11.glBegin(4);
/*     */     
/* 151 */     GL11.glTexCoord2f(pageX + pageWidth, pageY);
/* 152 */     GL11.glVertex2f(x + width, y);
/*     */     
/* 154 */     GL11.glTexCoord2f(pageX, pageY);
/* 155 */     GL11.glVertex2f(x, y);
/*     */     
/* 157 */     GL11.glTexCoord2f(pageX, pageY + pageHeight);
/* 158 */     GL11.glVertex2f(x, y + height);
/*     */     
/* 160 */     GL11.glTexCoord2f(pageX, pageY + pageHeight);
/* 161 */     GL11.glVertex2f(x, y + height);
/*     */     
/* 163 */     GL11.glTexCoord2f(pageX + pageWidth, pageY + pageHeight);
/* 164 */     GL11.glVertex2f(x + width, y + height);
/*     */     
/* 166 */     GL11.glTexCoord2f(pageX + pageWidth, pageY);
/* 167 */     GL11.glVertex2f(x + width, y);
/*     */ 
/*     */     
/* 170 */     GL11.glEnd();
/*     */     
/* 172 */     return width - 8.0F;
/*     */   }
/*     */ 
/*     */   
/* 176 */   public float getWidth(char ch) { return ((Glyph)this.glyphCharacterMap.get(Character.valueOf(ch))).width; }
/*     */ 
/*     */ 
/*     */   
/* 180 */   public int getMaxFontHeight() { return this.maxFontHeight; }
/*     */ 
/*     */ 
/*     */   
/* 184 */   public boolean isAntiAliasingEnabled() { return this.antiAliasing; }
/*     */ 
/*     */ 
/*     */   
/* 188 */   public boolean isFractionalMetricsEnabled() { return this.fractionalMetrics; }
/*     */   
/*     */   static class Glyph
/*     */   {
/*     */     private int x;
/*     */     private int y;
/*     */     private int width;
/*     */     private int height;
/*     */     
/*     */     Glyph(int x, int y, int width, int height) {
/* 198 */       this.x = x;
/* 199 */       this.y = y;
/* 200 */       this.width = width;
/* 201 */       this.height = height;
/*     */     }
/*     */ 
/*     */     
/*     */     Glyph() {}
/*     */ 
/*     */     
/* 208 */     public int getX() { return this.x; }
/*     */ 
/*     */ 
/*     */     
/* 212 */     public int getY() { return this.y; }
/*     */ 
/*     */ 
/*     */     
/* 216 */     public int getWidth() { return this.width; }
/*     */ 
/*     */ 
/*     */     
/* 220 */     public int getHeight() { return this.height; }
/*     */   }
/*     */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Utils\font\GlyphPage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */