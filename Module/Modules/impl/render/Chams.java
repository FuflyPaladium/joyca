/*    */ package me.lavache.BaseClient.Module.Modules.impl.render;
/*    */ 
/*    */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*    */ import me.lavache.BaseClient.Eventbus.Events.EventRenderEntity;
/*    */ import me.lavache.BaseClient.Module.Category;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Chams
/*    */   extends Module
/*    */ {
/* 14 */   public Chams() { super("Chams", 0, Category.RENDER); }
/*    */   
/*    */   @EventTarget
/*    */   public void onRenderEntity(EventRenderEntity e) {
/* 18 */     if (e.isPre() && e.getEntity() instanceof net.minecraft.entity.player.EntityPlayer) {
/* 19 */       GL11.glEnable(32823);
/* 20 */       GL11.glPolygonOffset(1.0F, -1100000.0F);
/* 21 */     } else if (e.isPost() && e.getEntity() instanceof net.minecraft.entity.player.EntityPlayer) {
/* 22 */       GL11.glDisable(32823);
/* 23 */       GL11.glPolygonOffset(1.0F, 1100000.0F);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\render\Chams.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */