/*    */ package me.lavache.BaseClient.Eventbus.Events;
/*    */ 
/*    */ import me.lavache.BaseClient.Eventbus.Event;
/*    */ 
/*    */ public class EventAntiKB
/*    */   extends Event
/*    */ {
/*    */   private boolean cancelled;
/*    */   
/* 10 */   public void setCancelled(boolean cancelled) { this.cancelled = cancelled; }
/*    */ 
/*    */ 
/*    */   
/* 14 */   public boolean isCancelled() { return this.cancelled; }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Eventbus\Events\EventAntiKB.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */