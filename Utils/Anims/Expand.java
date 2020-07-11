/*    */ package me.lavache.BaseClient.Utils.Anims;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Expand
/*    */ {
/*    */   private float x;
/*    */   private float y;
/*    */   private float expandX;
/*    */   private float expandY;
/*    */   private long lastMS;
/*    */   
/*    */   public Expand(float x, float y, float expandX, float expandY) {
/* 16 */     this.x = x;
/* 17 */     this.y = y;
/* 18 */     this.expandX = expandX;
/* 19 */     this.expandY = expandY;
/*    */   }
/*    */   
/*    */   public void hardInterpolate(float targetX, float targetY, int xSpeed, int ySpeed) {
/* 23 */     long currentMS = System.currentTimeMillis();
/* 24 */     long delta = currentMS - this.lastMS;
/* 25 */     this.lastMS = currentMS;
/* 26 */     this.expandX = AnimationUtil.calculateCompensation(targetX, this.expandX, delta, xSpeed);
/* 27 */     this.expandY = AnimationUtil.calculateCompensation(targetY, this.expandY, delta, ySpeed);
/*    */   }
/*    */   
/*    */   public void interpolate(float targetX, float targetY, int xSpeed, int ySpeed) {
/* 31 */     long currentMS = System.currentTimeMillis();
/* 32 */     long delta = currentMS - this.lastMS;
/* 33 */     if (delta > 60L) {
/* 34 */       delta = 16L;
/*    */     }
/* 36 */     this.lastMS = currentMS;
/* 37 */     int deltaX = (int)(Math.abs(targetX - this.expandX) * 0.3F);
/* 38 */     int deltaY = (int)(Math.abs(targetY - this.expandY) * 0.3F);
/* 39 */     this.expandX = AnimationUtil.calculateCompensation(targetX, this.expandX, delta, deltaX);
/* 40 */     this.expandY = AnimationUtil.calculateCompensation(targetY, this.expandY, delta, deltaY);
/*    */   }
/*    */ 
/*    */   
/* 44 */   public float getExpandX() { return this.expandX; }
/*    */ 
/*    */ 
/*    */   
/* 48 */   public float getExpandY() { return this.expandY; }
/*    */ 
/*    */ 
/*    */   
/* 52 */   public void setExpandX(float expandX) { this.expandX = expandX; }
/*    */ 
/*    */ 
/*    */   
/* 56 */   public void setExpandY(float expandY) { this.expandY = expandY; }
/*    */ 
/*    */ 
/*    */   
/* 60 */   public float getX() { return this.x; }
/*    */ 
/*    */ 
/*    */   
/* 64 */   public void setX(float x) { this.x = x; }
/*    */ 
/*    */ 
/*    */   
/* 68 */   public float getY() { return this.y; }
/*    */ 
/*    */ 
/*    */   
/* 72 */   public void setY(float y) { this.y = y; }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Utils\Anims\Expand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */