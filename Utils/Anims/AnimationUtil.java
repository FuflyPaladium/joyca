/*    */ package me.lavache.BaseClient.Utils.Anims;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AnimationUtil
/*    */ {
/*    */   public static float calculateCompensation(float target, float current, long delta, double speed) {
/*  9 */     float diff = current - target;
/* 10 */     if (delta < 1L) {
/* 11 */       delta = 1L;
/*    */     }
/* 13 */     if (delta > 1000L) {
/* 14 */       delta = 16L;
/*    */     }
/* 16 */     if (diff > speed) {
/* 17 */       double xD = (speed * delta / 16.0D < 0.5D) ? 0.5D : (speed * delta / 16.0D);
/* 18 */       current = (float)(current - xD);
/* 19 */       if (current < target) {
/* 20 */         current = target;
/*    */       }
/* 22 */     } else if (diff < -speed) {
/* 23 */       double xD = (speed * delta / 16.0D < 0.5D) ? 0.5D : (speed * delta / 16.0D);
/* 24 */       current = (float)(current + xD);
/* 25 */       if (current > target) {
/* 26 */         current = target;
/*    */       }
/*    */     } else {
/* 29 */       current = target;
/*    */     } 
/* 31 */     return current;
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Utils\Anims\AnimationUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */