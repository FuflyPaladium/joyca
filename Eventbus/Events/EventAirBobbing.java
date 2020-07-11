/*    */ package me.lavache.BaseClient.Eventbus.Events;
/*    */ 
/*    */ import me.lavache.BaseClient.Eventbus.Event;
/*    */ 
/*    */ public class EventAirBobbing
/*    */   extends Event {
/*    */   private boolean cancelled;
/*    */   
/*  9 */   public void setCancelled(boolean cancelled) { this.cancelled = cancelled; }
/*    */ 
/*    */ 
/*    */   
/* 13 */   public boolean isCancelled() { return this.cancelled; }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Eventbus\Events\EventAirBobbing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */