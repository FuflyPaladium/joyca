/*    */ package me.lavache.BaseClient.Utils;
/*    */ 
/*    */ import java.awt.Color;
/*    */ 
/*    */ public class RainbowUtils
/*    */ {
/*    */   public static Color effect(long offset, float brightness, int speed) {
/*  8 */     float hue = (float)(System.nanoTime() + offset * speed) / 1.0E9F % 1.0F;
/*  9 */     long color = Long.parseLong(Integer.toHexString(Integer.valueOf(Color.HSBtoRGB(hue, brightness, 1.0F)).intValue()), 16);
/* 10 */     Color c = new Color((int)color);
/* 11 */     return new Color(c.getRed() / 255.0F, c.getGreen() / 255.0F, c.getBlue() / 255.0F, c.getAlpha() / 255.0F);
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Utils\RainbowUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */