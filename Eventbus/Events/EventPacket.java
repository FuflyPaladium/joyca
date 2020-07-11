/*    */ package me.lavache.BaseClient.Eventbus.Events;
/*    */ 
/*    */ import me.lavache.BaseClient.Eventbus.Event;
/*    */ import net.minecraft.network.Packet;
/*    */ 
/*    */ public class EventPacket
/*    */   extends Event {
/*    */   private boolean sending;
/*    */   private Packet packet;
/*    */   
/*    */   public EventPacket(Packet packet, boolean sending) {
/* 12 */     this.packet = packet;
/* 13 */     this.sending = sending;
/*    */   }
/*    */ 
/*    */   
/* 17 */   public Packet getPacket() { return this.packet; }
/*    */ 
/*    */   
/* 20 */   public boolean isSending() { return this.sending; }
/*    */ 
/*    */   
/* 23 */   public void setPacket(Packet packet) { this.packet = packet; }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Eventbus\Events\EventPacket.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */