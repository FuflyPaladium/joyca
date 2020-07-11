/*     */ package me.lavache.BaseClient.Utils.font;
/*     */ 
/*     */ import java.awt.Font;
/*     */ import java.util.Locale;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class GlyphPageFontRenderer {
/*     */   public Random fontRandom;
/*     */   private float posX;
/*     */   private float posY;
/*     */   private int[] colorCode;
/*     */   private float red;
/*     */   private float blue;
/*     */   private float green;
/*     */   private float alpha;
/*     */   private int textColor;
/*     */   private boolean randomStyle;
/*     */   private boolean boldStyle;
/*     */   private boolean italicStyle;
/*     */   private boolean underlineStyle;
/*     */   private boolean strikethroughStyle;
/*     */   private GlyphPage regularGlyphPage;
/*     */   private GlyphPage boldGlyphPage;
/*     */   private GlyphPage italicGlyphPage;
/*     */   private GlyphPage boldItalicGlyphPage;
/*     */   
/*     */   public GlyphPageFontRenderer(GlyphPage regularGlyphPage, GlyphPage boldGlyphPage, GlyphPage italicGlyphPage, GlyphPage boldItalicGlyphPage) {
/*  33 */     this.fontRandom = new Random();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  46 */     this.colorCode = new int[32];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  92 */     this.regularGlyphPage = regularGlyphPage;
/*  93 */     this.boldGlyphPage = boldGlyphPage;
/*  94 */     this.italicGlyphPage = italicGlyphPage;
/*  95 */     this.boldItalicGlyphPage = boldItalicGlyphPage;
/*     */     
/*  97 */     for (int i = 0; i < 32; i++) {
/*  98 */       int j = (i >> 3 & true) * 85;
/*  99 */       int k = (i >> 2 & true) * 170 + j;
/* 100 */       int l = (i >> 1 & true) * 170 + j;
/* 101 */       int i1 = (i & true) * 170 + j;
/*     */       
/* 103 */       if (i == 6) {
/* 104 */         k += 85;
/*     */       }
/*     */ 
/*     */       
/* 108 */       if (i >= 16) {
/* 109 */         k /= 4;
/* 110 */         l /= 4;
/* 111 */         i1 /= 4;
/*     */       } 
/*     */       
/* 114 */       this.colorCode[i] = (k & 0xFF) << 16 | (l & 0xFF) << 8 | i1 & 0xFF;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static GlyphPageFontRenderer create(String fontName, int size, boolean bold, boolean italic, boolean boldItalic) {
/* 120 */     char[] chars = new char[256];
/*     */     
/* 122 */     for (int i = 0; i < chars.length; i++) {
/* 123 */       chars[i] = (char)i;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 128 */     GlyphPage regularPage = new GlyphPage(new Font(fontName, 0, size), true, true);
/*     */     
/* 130 */     regularPage.generateGlyphPage(chars);
/* 131 */     regularPage.setupTexture();
/*     */     
/* 133 */     GlyphPage boldPage = regularPage;
/* 134 */     GlyphPage italicPage = regularPage;
/* 135 */     GlyphPage boldItalicPage = regularPage;
/*     */     
/* 137 */     if (bold) {
/* 138 */       boldPage = new GlyphPage(new Font(fontName, 1, size), true, true);
/*     */       
/* 140 */       boldPage.generateGlyphPage(chars);
/* 141 */       boldPage.setupTexture();
/*     */     } 
/*     */     
/* 144 */     if (italic) {
/* 145 */       italicPage = new GlyphPage(new Font(fontName, 2, size), true, true);
/*     */       
/* 147 */       italicPage.generateGlyphPage(chars);
/* 148 */       italicPage.setupTexture();
/*     */     } 
/*     */     
/* 151 */     if (boldItalic) {
/* 152 */       boldItalicPage = new GlyphPage(new Font(fontName, 3, size), true, true);
/*     */       
/* 154 */       boldItalicPage.generateGlyphPage(chars);
/* 155 */       boldItalicPage.setupTexture();
/*     */     } 
/*     */     
/* 158 */     return new GlyphPageFontRenderer(regularPage, boldPage, italicPage, boldItalicPage);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int drawString(String text, float x, float y, int color, boolean dropShadow) {
/*     */     int i;
/* 166 */     GlStateManager.enableAlpha();
/* 167 */     resetStyles();
/*     */ 
/*     */     
/* 170 */     if (dropShadow) {
/* 171 */       i = renderString(text, x + 1.0F, y + 1.0F, color, true);
/* 172 */       i = Math.max(i, renderString(text, x, y, color, false));
/*     */     } else {
/* 174 */       i = renderString(text, x, y, color, false);
/*     */     } 
/*     */     
/* 177 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int renderString(String text, float x, float y, int color, boolean dropShadow) {
/* 184 */     if (text == null) {
/* 185 */       return 0;
/*     */     }
/*     */     
/* 188 */     if ((color & 0xFC000000) == 0) {
/* 189 */       color |= 0xFF000000;
/*     */     }
/*     */     
/* 192 */     if (dropShadow) {
/* 193 */       color = (color & 0xFCFCFC) >> 2 | color & 0xFF000000;
/*     */     }
/*     */     
/* 196 */     this.red = (color >> 16 & 0xFF) / 255.0F;
/* 197 */     this.blue = (color >> 8 & 0xFF) / 255.0F;
/* 198 */     this.green = (color & 0xFF) / 255.0F;
/* 199 */     this.alpha = (color >> 24 & 0xFF) / 255.0F;
/* 200 */     GlStateManager.color(this.red, this.blue, this.green, this.alpha);
/* 201 */     this.posX = x * 2.0F;
/* 202 */     this.posY = y * 2.0F;
/* 203 */     renderStringAtPos(text, dropShadow);
/* 204 */     return (int)(this.posX / 4.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void renderStringAtPos(String text, boolean shadow) {
/* 212 */     GlyphPage glyphPage = getCurrentGlyphPage();
/*     */     
/* 214 */     GL11.glPushMatrix();
/*     */     
/* 216 */     GL11.glScaled(0.5D, 0.5D, 0.5D);
/*     */     
/* 218 */     GlStateManager.enableBlend();
/* 219 */     GlStateManager.blendFunc(770, 771);
/* 220 */     GlStateManager.enableTexture2D();
/*     */     
/* 222 */     glyphPage.bindTexture();
/*     */     
/* 224 */     GL11.glTexParameteri(3553, 10240, 9729);
/*     */     
/* 226 */     for (int i = 0; i < text.length(); i++) {
/* 227 */       char c0 = text.charAt(i);
/*     */       
/* 229 */       if (c0 == '§' && i + 1 < text.length()) {
/* 230 */         int i1 = "0123456789abcdefklmnor".indexOf(text.toLowerCase(Locale.ENGLISH).charAt(i + 1));
/*     */         
/* 232 */         if (i1 < 16) {
/* 233 */           this.randomStyle = false;
/* 234 */           this.boldStyle = false;
/* 235 */           this.strikethroughStyle = false;
/* 236 */           this.underlineStyle = false;
/* 237 */           this.italicStyle = false;
/*     */           
/* 239 */           if (i1 < 0) {
/* 240 */             i1 = 15;
/*     */           }
/*     */           
/* 243 */           if (shadow) {
/* 244 */             i1 += 16;
/*     */           }
/*     */           
/* 247 */           int j1 = this.colorCode[i1];
/* 248 */           this.textColor = j1;
/*     */           
/* 250 */           GlStateManager.color((j1 >> 16) / 255.0F, (j1 >> 8 & 0xFF) / 255.0F, (j1 & 0xFF) / 255.0F, this.alpha);
/* 251 */         } else if (i1 == 16) {
/* 252 */           this.randomStyle = true;
/* 253 */         } else if (i1 == 17) {
/* 254 */           this.boldStyle = true;
/* 255 */         } else if (i1 == 18) {
/* 256 */           this.strikethroughStyle = true;
/* 257 */         } else if (i1 == 19) {
/* 258 */           this.underlineStyle = true;
/* 259 */         } else if (i1 == 20) {
/* 260 */           this.italicStyle = true;
/*     */         } else {
/* 262 */           this.randomStyle = false;
/* 263 */           this.boldStyle = false;
/* 264 */           this.strikethroughStyle = false;
/* 265 */           this.underlineStyle = false;
/* 266 */           this.italicStyle = false;
/*     */           
/* 268 */           GlStateManager.color(this.red, this.blue, this.green, this.alpha);
/*     */         } 
/*     */         
/* 271 */         i++;
/*     */       } else {
/* 273 */         glyphPage = getCurrentGlyphPage();
/*     */         
/* 275 */         glyphPage.bindTexture();
/*     */         
/* 277 */         float f = glyphPage.drawChar(c0, this.posX, this.posY);
/*     */         
/* 279 */         doDraw(f, glyphPage);
/*     */       } 
/*     */     } 
/*     */     
/* 283 */     glyphPage.unbindTexture();
/*     */     
/* 285 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void doDraw(float f, GlyphPage glyphPage) {
/* 289 */     if (this.strikethroughStyle) {
/* 290 */       Tessellator tessellator = Tessellator.getInstance();
/* 291 */       WorldRenderer worldrenderer = tessellator.getWorldRenderer();
/* 292 */       GlStateManager.disableTexture2D();
/* 293 */       worldrenderer.begin(7, DefaultVertexFormats.POSITION);
/* 294 */       worldrenderer.pos(this.posX, (this.posY + (glyphPage.getMaxFontHeight() / 2)), 0.0D).endVertex();
/* 295 */       worldrenderer.pos((this.posX + f), (this.posY + (glyphPage.getMaxFontHeight() / 2)), 0.0D).endVertex();
/* 296 */       worldrenderer.pos((this.posX + f), (this.posY + (glyphPage.getMaxFontHeight() / 2) - 1.0F), 0.0D).endVertex();
/* 297 */       worldrenderer.pos(this.posX, (this.posY + (glyphPage.getMaxFontHeight() / 2) - 1.0F), 0.0D).endVertex();
/* 298 */       tessellator.draw();
/* 299 */       GlStateManager.enableTexture2D();
/*     */     } 
/*     */     
/* 302 */     if (this.underlineStyle) {
/* 303 */       Tessellator tessellator1 = Tessellator.getInstance();
/* 304 */       WorldRenderer worldrenderer1 = tessellator1.getWorldRenderer();
/* 305 */       GlStateManager.disableTexture2D();
/* 306 */       worldrenderer1.begin(7, DefaultVertexFormats.POSITION);
/* 307 */       int l = this.underlineStyle ? -1 : 0;
/* 308 */       worldrenderer1.pos((this.posX + l), (this.posY + glyphPage.getMaxFontHeight()), 0.0D).endVertex();
/* 309 */       worldrenderer1.pos((this.posX + f), (this.posY + glyphPage.getMaxFontHeight()), 0.0D).endVertex();
/* 310 */       worldrenderer1.pos((this.posX + f), (this.posY + glyphPage.getMaxFontHeight() - 1.0F), 0.0D).endVertex();
/* 311 */       worldrenderer1.pos((this.posX + l), (this.posY + glyphPage.getMaxFontHeight() - 1.0F), 0.0D).endVertex();
/* 312 */       tessellator1.draw();
/* 313 */       GlStateManager.enableTexture2D();
/*     */     } 
/*     */     
/* 316 */     this.posX += f;
/*     */   }
/*     */ 
/*     */   
/*     */   private GlyphPage getCurrentGlyphPage() {
/* 321 */     if (this.boldStyle && this.italicStyle)
/* 322 */       return this.boldItalicGlyphPage; 
/* 323 */     if (this.boldStyle)
/* 324 */       return this.boldGlyphPage; 
/* 325 */     if (this.italicStyle) {
/* 326 */       return this.italicGlyphPage;
/*     */     }
/* 328 */     return this.regularGlyphPage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void resetStyles() {
/* 335 */     this.randomStyle = false;
/* 336 */     this.boldStyle = false;
/* 337 */     this.italicStyle = false;
/* 338 */     this.underlineStyle = false;
/* 339 */     this.strikethroughStyle = false;
/*     */   }
/*     */ 
/*     */   
/* 343 */   public int getFontHeight() { return this.regularGlyphPage.getMaxFontHeight() / 2; }
/*     */ 
/*     */   
/*     */   public int getStringWidth(String text) {
/* 347 */     if (text == null) {
/* 348 */       return 0;
/*     */     }
/* 350 */     int width = 0;
/*     */ 
/*     */ 
/*     */     
/* 354 */     int size = text.length();
/*     */     
/* 356 */     boolean on = false;
/*     */     
/* 358 */     for (int i = 0; i < size; i++) {
/* 359 */       char character = text.charAt(i);
/*     */       
/* 361 */       if (character == '§') {
/* 362 */         on = true;
/* 363 */       } else if (on && character >= '0' && character <= 'r') {
/* 364 */         int colorIndex = "0123456789abcdefklmnor".indexOf(character);
/* 365 */         if (colorIndex < 16) {
/* 366 */           this.boldStyle = false;
/* 367 */           this.italicStyle = false;
/* 368 */         } else if (colorIndex == 17) {
/* 369 */           this.boldStyle = true;
/* 370 */         } else if (colorIndex == 20) {
/* 371 */           this.italicStyle = true;
/* 372 */         } else if (colorIndex == 21) {
/* 373 */           this.boldStyle = false;
/* 374 */           this.italicStyle = false;
/*     */         } 
/* 376 */         i++;
/* 377 */         on = false;
/*     */       } else {
/* 379 */         if (on) i--;
/*     */         
/* 381 */         character = text.charAt(i);
/*     */         
/* 383 */         GlyphPage currentPage = getCurrentGlyphPage();
/*     */         
/* 385 */         width = (int)(width + currentPage.getWidth(character) - 8.0F);
/*     */       } 
/*     */     } 
/*     */     
/* 389 */     return width / 2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 396 */   public String trimStringToWidth(String text, int width) { return trimStringToWidth(text, width, false); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String trimStringToWidth(String text, int maxWidth, boolean reverse) {
/* 403 */     StringBuilder stringbuilder = new StringBuilder();
/*     */     
/* 405 */     boolean on = false;
/*     */     
/* 407 */     int j = reverse ? (text.length() - 1) : 0;
/* 408 */     int k = reverse ? -1 : 1;
/* 409 */     int width = 0;
/*     */ 
/*     */ 
/*     */     
/* 413 */     for (int i = j; i >= 0 && i < text.length() && i < maxWidth; i += k) {
/* 414 */       char character = text.charAt(i);
/*     */       
/* 416 */       if (character == '§') {
/* 417 */         on = true;
/* 418 */       } else if (on && character >= '0' && character <= 'r') {
/* 419 */         int colorIndex = "0123456789abcdefklmnor".indexOf(character);
/* 420 */         if (colorIndex < 16) {
/* 421 */           this.boldStyle = false;
/* 422 */           this.italicStyle = false;
/* 423 */         } else if (colorIndex == 17) {
/* 424 */           this.boldStyle = true;
/* 425 */         } else if (colorIndex == 20) {
/* 426 */           this.italicStyle = true;
/* 427 */         } else if (colorIndex == 21) {
/* 428 */           this.boldStyle = false;
/* 429 */           this.italicStyle = false;
/*     */         } 
/* 431 */         i++;
/* 432 */         on = false;
/*     */       } else {
/* 434 */         if (on) i--;
/*     */         
/* 436 */         character = text.charAt(i);
/*     */         
/* 438 */         GlyphPage currentPage = getCurrentGlyphPage();
/*     */         
/* 440 */         width = (int)(width + (currentPage.getWidth(character) - 8.0F) / 2.0F);
/*     */       } 
/*     */       
/* 443 */       if (i > width) {
/*     */         break;
/*     */       }
/*     */       
/* 447 */       if (reverse) {
/* 448 */         stringbuilder.insert(0, character);
/*     */       } else {
/* 450 */         stringbuilder.append(character);
/*     */       } 
/*     */     } 
/*     */     
/* 454 */     return stringbuilder.toString();
/*     */   }
/*     */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Utils\font\GlyphPageFontRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */