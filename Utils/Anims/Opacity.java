/*    */ package me.lavache.BaseClient.Utils.Anims;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Opacity
/*    */ {
/*    */   private float opacity;
/*    */   private long lastMS;
/*    */   
/*    */   public Opacity(int opacity) {
/* 12 */     this.opacity = opacity;
/* 13 */     this.lastMS = System.currentTimeMillis();
/*    */   }
/*    */ 
/*    */   
/* 17 */   public void interpolate(int targetOpacity) { this.opacity = (int)AnimationUtil.calculateCompensation(targetOpacity, this.opacity, 16L, 5.0D); }
/*    */ 
/*    */   
/*    */   public void interp(float targetOpacity, double speed) {
/* 21 */     long currentMS = System.currentTimeMillis();
/* 22 */     long delta = currentMS - this.lastMS;
/* 23 */     this.lastMS = currentMS;
/* 24 */     this.opacity = AnimationUtil.calculateCompensation(targetOpacity, this.opacity, delta, speed);
/*    */   }
/*    */ 
/*    */   
/* 28 */   public float getOpacity() { return this.opacity; }
/*    */ 
/*    */ 
/*    */   
/* 32 */   public void setOpacity(float opacity) { this.opacity = opacity; }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Utils\Anims\Opacity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */