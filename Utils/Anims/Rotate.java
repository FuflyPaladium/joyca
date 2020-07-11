/*    */ package me.lavache.BaseClient.Utils.Anims;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Rotate
/*    */ {
/*    */   private float angle;
/*    */   private long lastMS;
/*    */   
/* 12 */   public Rotate(float angle) { this.angle = angle; }
/*    */ 
/*    */   
/*    */   public void interpolate(float targetAngle, int speed) {
/* 16 */     long currentMS = System.currentTimeMillis();
/* 17 */     long delta = currentMS - this.lastMS;
/* 18 */     this.lastMS = currentMS;
/* 19 */     this.angle = AnimationUtil.calculateCompensation(targetAngle, this.angle, delta, speed);
/*    */   }
/*    */ 
/*    */   
/* 23 */   public float getAngle() { return this.angle; }
/*    */ 
/*    */ 
/*    */   
/* 27 */   public void setAngle(int angle) { this.angle = angle; }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Utils\Anims\Rotate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */