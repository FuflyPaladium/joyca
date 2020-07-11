/*    */ package me.lavache.BaseClient.Eventbus.Events;
/*    */ 
/*    */ import me.lavache.BaseClient.Eventbus.Event;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ 
/*    */ public class EventRenderEntity extends Event {
/*    */   private EntityLivingBase entity;
/*    */   private boolean pre;
/*    */   
/*    */   public EventRenderEntity(EntityLivingBase entity, boolean pre) {
/* 11 */     this.entity = entity;
/* 12 */     this.pre = pre;
/*    */   }
/*    */ 
/*    */   
/* 16 */   public EntityLivingBase getEntity() { return this.entity; }
/*    */ 
/*    */ 
/*    */   
/* 20 */   public boolean isPre() { return this.pre; }
/*    */ 
/*    */ 
/*    */   
/* 24 */   public boolean isPost() { return !this.pre; }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Eventbus\Events\EventRenderEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */