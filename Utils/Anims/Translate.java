/*    */ package me.lavache.BaseClient.Utils.Anims;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Translate
/*    */ {
/*    */   private float x;
/*    */   private float y;
/*    */   private long lastMS;
/*    */   
/*    */   public Translate(float x, float y) {
/* 13 */     this.x = x;
/* 14 */     this.y = y;
/* 15 */     this.lastMS = System.currentTimeMillis();
/*    */   }
/*    */   
/*    */   public void interpolate(float targetX, float targetY, int xSpeed, int ySpeed) {
/* 19 */     long currentMS = System.currentTimeMillis();
/* 20 */     long delta = currentMS - this.lastMS;
/* 21 */     this.lastMS = currentMS;
/* 22 */     int deltaX = (int)(Math.abs(targetX - this.x) * 0.51F);
/* 23 */     int deltaY = (int)(Math.abs(targetY - this.y) * 0.51F);
/* 24 */     this.x = AnimationUtil.calculateCompensation(targetX, this.x, delta, deltaX);
/* 25 */     this.y = AnimationUtil.calculateCompensation(targetY, this.y, delta, deltaY);
/*    */   }
/*    */   
/*    */   public void interpolate(float targetX, float targetY, double speed) {
/* 29 */     long currentMS = System.currentTimeMillis();
/* 30 */     long delta = (long)(currentMS - 16.66666D);
/* 31 */     this.lastMS = currentMS;
/* 32 */     double deltaX = 0.0D;
/* 33 */     double deltaY = 0.0D;
/* 34 */     if (speed != 0.0D) {
/* 35 */       deltaX = (Math.abs(targetX - this.x) * 0.35F) / 10.0D / speed;
/* 36 */       deltaY = (Math.abs(targetY - this.y) * 0.35F) / 10.0D / speed;
/*    */     } 
/* 38 */     this.x = AnimationUtil.calculateCompensation(targetX, this.x, delta, deltaX);
/* 39 */     this.y = AnimationUtil.calculateCompensation(targetY, this.y, delta, deltaY);
/*    */   }
/*    */ 
/*    */   
/* 43 */   public float getX() { return this.x; }
/*    */ 
/*    */ 
/*    */   
/* 47 */   public void setX(float x) { this.x = x; }
/*    */ 
/*    */ 
/*    */   
/* 51 */   public float getY() { return this.y; }
/*    */ 
/*    */ 
/*    */   
/* 55 */   public void setY(float y) { this.y = y; }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Utils\Anims\Translate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */