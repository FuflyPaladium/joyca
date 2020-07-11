/*    */ package me.lavache.BaseClient.Eventbus.Events;
/*    */ 
/*    */ import me.lavache.BaseClient.Eventbus.Event;
/*    */ 
/*    */ public class Event2D extends Event {
/*    */   private float width;
/*    */   
/*    */   public Event2D(float width, float height) {
/*  9 */     this.width = width;
/* 10 */     this.height = height;
/*    */   }
/*    */   private float height;
/*    */   
/* 14 */   public float getWidth() { return this.width; }
/*    */ 
/*    */ 
/*    */   
/* 18 */   public float getHeight() { return this.height; }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Eventbus\Events\Event2D.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */