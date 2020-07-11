/*     */ package me.lavache.BaseClient.AltLogin;
/*     */ 
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.util.ChatAllowedCharacters;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PasswordField
/*     */   extends Gui
/*     */ {
/*     */   private final FontRenderer fontRenderer;
/*     */   private final int xPos;
/*     */   private final int yPos;
/*     */   private final int width;
/*     */   private final int height;
/*     */   private String text;
/*     */   private int maxStringLength;
/*     */   private int cursorCounter;
/*     */   private boolean enableBackgroundDrawing;
/*     */   
/*     */   public PasswordField(FontRenderer par1FontRenderer, int par2, int par3, int par4, int par5) {
/*  31 */     this.text = "";
/*  32 */     this.maxStringLength = 50;
/*  33 */     this.enableBackgroundDrawing = true;
/*  34 */     this.canLoseFocus = true;
/*  35 */     this.isFocused = false;
/*  36 */     this.isEnabled = true;
/*  37 */     this.i = 0;
/*  38 */     this.cursorPosition = 0;
/*  39 */     this.selectionEnd = 0;
/*  40 */     this.enabledColor = 14737632;
/*  41 */     this.disabledColor = 7368816;
/*  42 */     this.b = true;
/*  43 */     this.fontRenderer = par1FontRenderer;
/*  44 */     this.xPos = par2;
/*  45 */     this.yPos = par3;
/*  46 */     this.width = par4;
/*  47 */     this.height = par5;
/*     */   }
/*     */   private boolean canLoseFocus; public boolean isFocused; private boolean isEnabled; private int i; private int cursorPosition; private int selectionEnd; private int enabledColor; private int disabledColor; private boolean b;
/*     */   
/*  51 */   public void updateCursorCounter() { this.cursorCounter++; }
/*     */ 
/*     */   
/*     */   public void setText(String par1Str) {
/*  55 */     if (par1Str.length() > this.maxStringLength) {
/*  56 */       this.text = par1Str.substring(0, this.maxStringLength);
/*     */     } else {
/*     */       
/*  59 */       this.text = par1Str;
/*     */     } 
/*  61 */     setCursorPositionEnd();
/*     */   }
/*     */ 
/*     */   
/*  65 */   public String getText() { return this.text.replaceAll(" ", ""); }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectedtext() {
/*  70 */     int var1 = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
/*  71 */     int var2 = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
/*  72 */     return this.text.substring(var1, var2);
/*     */   }
/*     */   public void writeText(String par1Str) {
/*     */     int var8;
/*  76 */     String var2 = "";
/*  77 */     String var3 = ChatAllowedCharacters.filterAllowedCharacters(par1Str);
/*  78 */     int var4 = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
/*  79 */     int var5 = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
/*  80 */     int var6 = this.maxStringLength - this.text.length() - var4 - this.selectionEnd;
/*  81 */     boolean var7 = false;
/*  82 */     if (this.text.length() > 0) {
/*  83 */       var2 = String.valueOf(String.valueOf(String.valueOf(var2))) + this.text.substring(0, var4);
/*     */     }
/*     */     
/*  86 */     if (var6 < var3.length()) {
/*  87 */       var2 = String.valueOf(String.valueOf(String.valueOf(var2))) + var3.substring(0, var6);
/*  88 */       var8 = var6;
/*     */     } else {
/*     */       
/*  91 */       var2 = String.valueOf(String.valueOf(String.valueOf(var2))) + var3;
/*  92 */       var8 = var3.length();
/*     */     } 
/*  94 */     if (this.text.length() > 0 && var5 < this.text.length()) {
/*  95 */       var2 = String.valueOf(String.valueOf(String.valueOf(var2))) + this.text.substring(var5);
/*     */     }
/*  97 */     this.text = var2.replaceAll(" ", "");
/*  98 */     cursorPos(var4 - this.selectionEnd + var8);
/*     */   }
/*     */   
/*     */   public void func_73779_a(int par1) {
/* 102 */     if (this.text.length() != 0) {
/* 103 */       if (this.selectionEnd != this.cursorPosition) {
/* 104 */         writeText("");
/*     */       } else {
/*     */         
/* 107 */         deleteFromCursor(getNthWordFromCursor(par1) - this.cursorPosition);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public void deleteFromCursor(int par1) {
/* 113 */     if (this.text.length() != 0) {
/* 114 */       if (this.selectionEnd != this.cursorPosition) {
/* 115 */         writeText("");
/*     */       } else {
/*     */         
/* 118 */         boolean var2 = (par1 < 0);
/* 119 */         int var3 = var2 ? (this.cursorPosition + par1) : this.cursorPosition;
/* 120 */         int var4 = var2 ? this.cursorPosition : (this.cursorPosition + par1);
/* 121 */         String var5 = "";
/* 122 */         if (var3 >= 0) {
/* 123 */           var5 = this.text.substring(0, var3);
/*     */         }
/* 125 */         if (var4 < this.text.length()) {
/* 126 */           var5 = String.valueOf(String.valueOf(String.valueOf(var5))) + this.text.substring(var4);
/*     */         }
/* 128 */         this.text = var5;
/* 129 */         if (var2) {
/* 130 */           cursorPos(par1);
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/* 137 */   public int getNthWordFromCursor(int par1) { return getNthWordFromPos(par1, getCursorPosition()); }
/*     */ 
/*     */ 
/*     */   
/* 141 */   public int getNthWordFromPos(int par1, int par2) { return type(par1, getCursorPosition(), true); }
/*     */ 
/*     */   
/*     */   public int type(int par1, int par2, boolean par3) {
/* 145 */     int var4 = par2;
/* 146 */     boolean var5 = (par1 < 0);
/* 147 */     for (int var6 = Math.abs(par1), var7 = 0; var7 < var6; var7++) {
/* 148 */       if (!var5) {
/* 149 */         int var8 = this.text.length();
/* 150 */         var4 = this.text.indexOf(' ', var4);
/* 151 */         if (var4 == -1) {
/* 152 */           var4 = var8;
/*     */         } else {
/*     */           
/* 155 */           while (par3 && 
/* 156 */             var4 < var8) {
/*     */ 
/*     */             
/* 159 */             if (this.text.charAt(var4) != ' ') {
/*     */               break;
/*     */             }
/* 162 */             var4++;
/*     */           } 
/*     */         } 
/*     */       } else {
/*     */         
/* 167 */         while (par3 && 
/* 168 */           var4 > 0) {
/*     */ 
/*     */           
/* 171 */           if (this.text.charAt(var4 - 1) != ' ') {
/*     */             break;
/*     */           }
/* 174 */           var4--;
/*     */         } 
/* 176 */         while (var4 > 0 && this.text.charAt(var4 - 1) != ' ') {
/* 177 */           var4--;
/*     */         }
/*     */       } 
/*     */     } 
/* 181 */     return var4;
/*     */   }
/*     */ 
/*     */   
/* 185 */   public void cursorPos(int par1) { setCursorPosition(this.selectionEnd + par1); }
/*     */ 
/*     */   
/*     */   public void setCursorPosition(int par1) {
/* 189 */     this.cursorPosition = par1;
/* 190 */     int var2 = this.text.length();
/* 191 */     if (this.cursorPosition < 0) {
/* 192 */       this.cursorPosition = 0;
/*     */     }
/* 194 */     if (this.cursorPosition > var2) {
/* 195 */       this.cursorPosition = var2;
/*     */     }
/* 197 */     func_73800_i(this.cursorPosition);
/*     */   }
/*     */ 
/*     */   
/* 201 */   public void setCursorPositionZero() { setCursorPosition(0); }
/*     */ 
/*     */ 
/*     */   
/* 205 */   public void setCursorPositionEnd() { setCursorPosition(this.text.length()); }
/*     */ 
/*     */   
/*     */   public boolean textboxKeyTyped(char par1, int par2) {
/* 209 */     if (!this.isEnabled || !this.isFocused) {
/* 210 */       return false;
/*     */     }
/* 212 */     switch (par1) {
/*     */       case '\001':
/* 214 */         setCursorPositionEnd();
/* 215 */         func_73800_i(0);
/* 216 */         return true;
/*     */       
/*     */       case '\003':
/* 219 */         GuiScreen.setClipboardString(getSelectedtext());
/* 220 */         return true;
/*     */       
/*     */       case '\026':
/* 223 */         writeText(GuiScreen.getClipboardString());
/* 224 */         return true;
/*     */       
/*     */       case '\030':
/* 227 */         GuiScreen.setClipboardString(getSelectedtext());
/* 228 */         writeText("");
/* 229 */         return true;
/*     */     } 
/*     */     
/* 232 */     switch (par2) {
/*     */       case 14:
/* 234 */         if (GuiScreen.isCtrlKeyDown()) {
/* 235 */           func_73779_a(-1);
/*     */         } else {
/*     */           
/* 238 */           deleteFromCursor(-1);
/*     */         } 
/* 240 */         return true;
/*     */       
/*     */       case 199:
/* 243 */         if (GuiScreen.isShiftKeyDown()) {
/* 244 */           func_73800_i(0);
/*     */         } else {
/*     */           
/* 247 */           setCursorPositionZero();
/*     */         } 
/* 249 */         return true;
/*     */       
/*     */       case 203:
/* 252 */         if (GuiScreen.isShiftKeyDown()) {
/* 253 */           if (GuiScreen.isCtrlKeyDown()) {
/* 254 */             func_73800_i(getNthWordFromPos(-1, getSelectionEnd()));
/*     */           } else {
/*     */             
/* 257 */             func_73800_i(getSelectionEnd() - 1);
/*     */           }
/*     */         
/* 260 */         } else if (GuiScreen.isCtrlKeyDown()) {
/* 261 */           setCursorPosition(getNthWordFromCursor(-1));
/*     */         } else {
/*     */           
/* 264 */           cursorPos(-1);
/*     */         } 
/* 266 */         return true;
/*     */       
/*     */       case 205:
/* 269 */         if (GuiScreen.isShiftKeyDown()) {
/* 270 */           if (GuiScreen.isCtrlKeyDown()) {
/* 271 */             func_73800_i(getNthWordFromPos(1, getSelectionEnd()));
/*     */           } else {
/*     */             
/* 274 */             func_73800_i(getSelectionEnd() + 1);
/*     */           }
/*     */         
/* 277 */         } else if (GuiScreen.isCtrlKeyDown()) {
/* 278 */           setCursorPosition(getNthWordFromCursor(1));
/*     */         } else {
/*     */           
/* 281 */           cursorPos(1);
/*     */         } 
/* 283 */         return true;
/*     */       
/*     */       case 207:
/* 286 */         if (GuiScreen.isShiftKeyDown()) {
/* 287 */           func_73800_i(this.text.length());
/*     */         } else {
/*     */           
/* 290 */           setCursorPositionEnd();
/*     */         } 
/* 292 */         return true;
/*     */       
/*     */       case 211:
/* 295 */         if (GuiScreen.isCtrlKeyDown()) {
/* 296 */           func_73779_a(1);
/*     */         } else {
/*     */           
/* 299 */           deleteFromCursor(1);
/*     */         } 
/* 301 */         return true;
/*     */     } 
/*     */     
/* 304 */     if (ChatAllowedCharacters.isAllowedCharacter(par1)) {
/* 305 */       writeText(Character.toString(par1));
/* 306 */       return true;
/*     */     } 
/* 308 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mouseClicked(int par1, int par2, int par3) {
/* 316 */     boolean var4 = (par1 >= this.xPos && par1 < this.xPos + this.width && par2 >= this.yPos && par2 < this.yPos + this.height);
/* 317 */     if (this.canLoseFocus) {
/* 318 */       setFocused((this.isEnabled && var4));
/*     */     }
/* 320 */     if (this.isFocused && par3 == 0) {
/* 321 */       int var5 = par1 - this.xPos;
/* 322 */       if (this.enableBackgroundDrawing) {
/* 323 */         var5 -= 4;
/*     */       }
/* 325 */       String var6 = this.fontRenderer.trimStringToWidth(this.text.substring(this.i), getWidth());
/* 326 */       setCursorPosition(this.fontRenderer.trimStringToWidth(var6, var5).length() + this.i);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void drawTextBox() {
/* 331 */     if (func_73778_q()) {
/* 332 */       if (getEnableBackgroundDrawing()) {
/* 333 */         Gui.drawRect((this.xPos - 1), (this.yPos - 1), (this.xPos + this.width + 1), (this.yPos + this.height + 1), -6250336);
/* 334 */         Gui.drawRect(this.xPos, this.yPos, (this.xPos + this.width), (this.yPos + this.height), -16777216);
/*     */       } 
/* 336 */       int var1 = this.isEnabled ? this.enabledColor : this.disabledColor;
/* 337 */       int var2 = this.cursorPosition - this.i;
/* 338 */       int var3 = this.selectionEnd - this.i;
/* 339 */       String var4 = this.fontRenderer.trimStringToWidth(this.text.substring(this.i), getWidth());
/* 340 */       boolean var5 = (var2 >= 0 && var2 <= var4.length());
/* 341 */       boolean var6 = (this.isFocused && this.cursorCounter / 6 % 2 == 0 && var5);
/* 342 */       int var7 = this.enableBackgroundDrawing ? (this.xPos + 4) : this.xPos;
/* 343 */       int var8 = this.enableBackgroundDrawing ? (this.yPos + (this.height - 8) / 2) : this.yPos;
/* 344 */       int var9 = var7;
/* 345 */       if (var3 > var4.length()) {
/* 346 */         var3 = var4.length();
/*     */       }
/* 348 */       if (var4.length() > 0) {
/* 349 */         if (var5) {
/* 350 */           var4.substring(0, var2);
/*     */         }
/* 352 */         Minecraft.getMinecraft(); var9 = Minecraft.fontRendererObj.drawStringWithShadow(this.text.replaceAll("(?s).", "*"), var7, var8, var1);
/*     */       } 
/* 354 */       boolean var10 = !(this.cursorPosition >= this.text.length() && this.text.length() < getMaxStringLength());
/* 355 */       int var11 = var9;
/* 356 */       if (!var5) {
/* 357 */         var11 = (var2 > 0) ? (var7 + this.width) : var7;
/*     */       }
/* 359 */       else if (var10) {
/* 360 */         var11 = var9 - 1;
/* 361 */         var9--;
/*     */       } 
/* 363 */       if (var4.length() > 0 && var5 && var2 < var4.length()) {
/* 364 */         Minecraft.getMinecraft(); Minecraft.fontRendererObj.drawStringWithShadow(var4.substring(var2), var9, var8, var1);
/*     */       } 
/* 366 */       if (var6) {
/* 367 */         if (var10) {
/* 368 */           Gui.drawRect(var11, (var8 - 1), (var11 + 1), (var8 + 1 + this.fontRenderer.FONT_HEIGHT), -3092272);
/*     */         } else {
/*     */           
/* 371 */           Minecraft.getMinecraft(); Minecraft.fontRendererObj.drawStringWithShadow("_", var11, var8, var1);
/*     */         } 
/*     */       }
/* 374 */       if (var3 != var2) {
/* 375 */         int var12 = var7 + this.fontRenderer.getStringWidth(var4.substring(0, var3));
/* 376 */         drawCursorVertical(var11, var8 - 1, var12 - 1, var8 + 1 + this.fontRenderer.FONT_HEIGHT);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void drawCursorVertical(int par1, int par2, int par3, int par4) {
/* 382 */     if (par1 < par3) {
/* 383 */       int var5 = par1;
/* 384 */       par1 = par3;
/* 385 */       par3 = var5;
/*     */     } 
/* 387 */     if (par2 < par4) {
/* 388 */       int var5 = par2;
/* 389 */       par2 = par4;
/* 390 */       par4 = var5;
/*     */     } 
/* 392 */     Tessellator var6 = Tessellator.getInstance();
/* 393 */     WorldRenderer var7 = var6.getWorldRenderer();
/* 394 */     GL11.glColor4f(0.0F, 0.0F, 255.0F, 255.0F);
/* 395 */     GL11.glDisable(3553);
/* 396 */     GL11.glEnable(3058);
/* 397 */     GL11.glLogicOp(5387);
/* 398 */     var7.begin(7, var7.getVertexFormat());
/* 399 */     var7.pos(par1, par4, 0.0D);
/* 400 */     var7.pos(par3, par4, 0.0D);
/* 401 */     var7.pos(par3, par2, 0.0D);
/* 402 */     var7.pos(par1, par2, 0.0D);
/* 403 */     var7.finishDrawing();
/* 404 */     GL11.glDisable(3058);
/* 405 */     GL11.glEnable(3553);
/*     */   }
/*     */   
/*     */   public void setMaxStringLength(int par1) {
/* 409 */     this.maxStringLength = par1;
/* 410 */     if (this.text.length() > par1) {
/* 411 */       this.text = this.text.substring(0, par1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/* 416 */   public int getMaxStringLength() { return this.maxStringLength; }
/*     */ 
/*     */ 
/*     */   
/* 420 */   public int getCursorPosition() { return this.cursorPosition; }
/*     */ 
/*     */ 
/*     */   
/* 424 */   public boolean getEnableBackgroundDrawing() { return this.enableBackgroundDrawing; }
/*     */ 
/*     */ 
/*     */   
/* 428 */   public void setEnableBackgroundDrawing(boolean par1) { this.enableBackgroundDrawing = par1; }
/*     */ 
/*     */ 
/*     */   
/* 432 */   public void func_73794_g(int par1) { this.enabledColor = par1; }
/*     */ 
/*     */   
/*     */   public void setFocused(boolean par1) {
/* 436 */     if (par1 && !this.isFocused) {
/* 437 */       this.cursorCounter = 0;
/*     */     }
/* 439 */     this.isFocused = par1;
/*     */   }
/*     */ 
/*     */   
/* 443 */   public boolean isFocused() { return this.isFocused; }
/*     */ 
/*     */ 
/*     */   
/* 447 */   public int getSelectionEnd() { return this.selectionEnd; }
/*     */ 
/*     */ 
/*     */   
/* 451 */   public int getWidth() { return getEnableBackgroundDrawing() ? (this.width - 8) : this.width; }
/*     */ 
/*     */   
/*     */   public void func_73800_i(int par1) {
/* 455 */     int var2 = this.text.length();
/* 456 */     if (par1 > var2) {
/* 457 */       par1 = var2;
/*     */     }
/* 459 */     if (par1 < 0) {
/* 460 */       par1 = 0;
/*     */     }
/* 462 */     this.selectionEnd = par1;
/* 463 */     if (this.fontRenderer != null) {
/* 464 */       if (this.i > var2) {
/* 465 */         this.i = var2;
/*     */       }
/* 467 */       int var3 = getWidth();
/* 468 */       String var4 = this.fontRenderer.trimStringToWidth(this.text.substring(this.i), var3);
/* 469 */       int var5 = var4.length() + this.i;
/* 470 */       if (par1 == this.i) {
/* 471 */         this.i -= this.fontRenderer.trimStringToWidth(this.text, var3, true).length();
/*     */       }
/* 473 */       if (par1 > var5) {
/* 474 */         this.i += par1 - var5;
/*     */       }
/* 476 */       else if (par1 <= this.i) {
/* 477 */         this.i -= this.i - par1;
/*     */       } 
/* 479 */       if (this.i < 0) {
/* 480 */         this.i = 0;
/*     */       }
/* 482 */       if (this.i > var2) {
/* 483 */         this.i = var2;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/* 489 */   public void setCanLoseFocus(boolean par1) { this.canLoseFocus = par1; }
/*     */ 
/*     */ 
/*     */   
/* 493 */   public boolean func_73778_q() { return this.b; }
/*     */ 
/*     */ 
/*     */   
/* 497 */   public void func_73790_e(boolean par1) { this.b = par1; }
/*     */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\AltLogin\PasswordField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */