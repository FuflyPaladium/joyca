/*    */ package me.lavache.BaseClient.Eventbus.Events;
/*    */ 
/*    */ import me.lavache.BaseClient.Eventbus.Event;
/*    */ 
/*    */ public class Event3D
/*    */   extends Event {
/*    */   private float partialTicks;
/*    */   
/*  9 */   public Event3D(float partialTicks) { this.partialTicks = partialTicks; }
/*    */ 
/*    */ 
/*    */   
/* 13 */   public float getPartialTicks() { return this.partialTicks; }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Eventbus\Events\Event3D.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */