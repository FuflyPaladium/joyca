/*    */ package me.lavache.BaseClient.Eventbus;
/*    */ 
/*    */ import java.lang.reflect.Method;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Data
/*    */ {
/*    */   public final Object source;
/*    */   public final Method target;
/*    */   public final byte priority;
/*    */   
/*    */   Data(Object source, Method target, byte priority) {
/* 18 */     this.source = source;
/* 19 */     this.target = target;
/* 20 */     this.priority = priority;
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Eventbus\Data.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */