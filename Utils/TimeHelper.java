/*    */ package me.lavache.BaseClient.Utils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TimeHelper
/*    */ {
/*    */   private static long lastDelay;
/*    */   private static long lastMs;
/* 11 */   public static long average = 1L;
/*    */   
/* 13 */   private static long delay = 1L;
/*    */ 
/*    */   
/* 16 */   public static void reset() { lastMs = getCurrentTime(); }
/*    */ 
/*    */ 
/*    */   
/* 20 */   public static boolean delayOver(long l) { return (getCurrentTime() - lastMs > l); }
/*    */ 
/*    */ 
/*    */   
/* 24 */   private static long getCurrentTime() { return System.currentTimeMillis(); }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Utils\TimeHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */