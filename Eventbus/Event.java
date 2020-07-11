/*    */ package me.lavache.BaseClient.Eventbus;
/*    */ 
/*    */ import java.lang.reflect.InvocationTargetException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class Event
/*    */ {
/*    */   private boolean cancelled;
/*    */   
/*    */   public enum State
/*    */   {
/* 35 */     PRE("PRE", 0),
/*    */     
/* 37 */     POST("POST", 1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Event call() {
/* 46 */     this.cancelled = false;
/* 47 */     call(this);
/* 48 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 53 */   public boolean isCancelled() { return this.cancelled; }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 58 */   public void setCancelled(boolean cancelled) { this.cancelled = cancelled; }
/*    */ 
/*    */ 
/*    */   
/*    */   private static final void call(Event event) {
/* 63 */     ArrayHelper<Data> dataList = EventManager.get(event.getClass());
/*    */     
/* 65 */     if (dataList != null)
/* 66 */       for (Data data : dataList) {
/*    */         
/*    */         try {
/* 69 */           data.target.invoke(data.source, new Object[] { event });
/* 70 */         } catch (IllegalAccessException e) {
/* 71 */           e.printStackTrace();
/* 72 */         } catch (InvocationTargetException e) {
/* 73 */           e.printStackTrace();
/*    */         } 
/*    */       }  
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Eventbus\Event.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */