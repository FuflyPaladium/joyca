/*   */ package me.lavache.BaseClient.Eventbus.Events;
/*   */ 
/*   */ import me.lavache.BaseClient.Eventbus.Event;
/*   */ 
/*   */ public class EventUpdate extends Event {
/*   */   public Event.State state;
/*   */   
/* 8 */   public EventUpdate(Event.State pre) { this.state = pre; }
/*   */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Eventbus\Events\EventUpdate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */