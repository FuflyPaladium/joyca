/*    */ package me.lavache.BaseClient.Eventbus.Events;
/*    */ 
/*    */ import me.lavache.BaseClient.Eventbus.Event;
/*    */ 
/*    */ public class EventKey
/*    */   extends Event {
/*    */   private int key;
/*    */   
/*  9 */   public EventKey(int key) { this.key = key; }
/*    */ 
/*    */ 
/*    */   
/* 13 */   public int getKey() { return this.key; }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Eventbus\Events\EventKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */