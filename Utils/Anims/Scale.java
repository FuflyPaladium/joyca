/*    */ package me.lavache.BaseClient.Utils.Anims;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Scale
/*    */ {
/*    */   private float centerX;
/*    */   private float centerY;
/*    */   private float width;
/*    */   private float height;
/*    */   private long lastMS;
/*    */   
/*    */   public Scale(float centerX, float centerY, float width, float height) {
/* 15 */     this.centerX = centerX;
/* 16 */     this.centerY = centerY;
/* 17 */     this.height = height;
/* 18 */     this.width = width;
/* 19 */     this.lastMS = System.currentTimeMillis();
/*    */   }
/*    */   
/*    */   public void interpolate(float tWidth, float tHeight, int speed) {
/* 23 */     long currentMS = System.currentTimeMillis();
/* 24 */     long delta = currentMS - this.lastMS;
/* 25 */     this.lastMS = currentMS;
/* 26 */     float diffW = this.width - tWidth;
/* 27 */     if (diffW > speed) {
/* 28 */       this.width -= (float)(speed * delta / 16L);
/* 29 */     } else if (diffW < -speed) {
/* 30 */       this.width += (float)(speed * delta / 16L);
/*    */     } else {
/* 32 */       this.width = tWidth;
/*    */     } 
/* 34 */     float diffH = this.height - tHeight;
/* 35 */     if (diffH > speed) {
/* 36 */       this.height -= (float)(speed * delta / 16L);
/* 37 */     } else if (diffH < -speed) {
/* 38 */       this.height += (float)(speed * delta / 16L);
/*    */     } else {
/* 40 */       this.height = tHeight;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/* 45 */   public float getCenterX() { return this.centerX; }
/*    */ 
/*    */ 
/*    */   
/* 49 */   public float getCenterY() { return this.centerY; }
/*    */ 
/*    */ 
/*    */   
/* 53 */   public float getWidth() { return this.width; }
/*    */ 
/*    */ 
/*    */   
/* 57 */   public float getHeight() { return this.height; }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Utils\Anims\Scale.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */