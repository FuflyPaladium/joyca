/*    */ package me.lavache.BaseClient.Utils;
/*    */ 
/*    */ import com.google.common.base.Predicates;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ import net.minecraft.util.EntitySelectors;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.util.Vec3;
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
/*    */ public class RaycastUtils
/*    */ {
/* 23 */   private static Minecraft mc = Minecraft.getMinecraft();
/*    */ 
/*    */   
/* 26 */   public static Entity raycastEntity(double range, IEntityFilter entityFilter) { return raycastEntity(range, mc.thePlayer.cameraYaw, mc.thePlayer.cameraPitch, entityFilter); }
/*    */ 
/*    */   
/*    */   private static Entity raycastEntity(double range, float yaw, float pitch, IEntityFilter entityFilter) {
/* 30 */     Entity renderViewEntity = Minecraft.getMinecraft().getRenderViewEntity();
/*    */     
/* 32 */     if (renderViewEntity != null && (Minecraft.getMinecraft()).theWorld != null) {
/* 33 */       double blockReachDistance = range;
/* 34 */       Vec3 eyePosition = renderViewEntity.getPositionEyes(1.0F);
/*    */       
/* 36 */       float yawCos = MathHelper.cos(-yaw * 0.017453292F - 3.1415927F);
/* 37 */       float yawSin = MathHelper.sin(-yaw * 0.017453292F - 3.1415927F);
/* 38 */       float pitchCos = -MathHelper.cos(-pitch * 0.017453292F);
/* 39 */       float pitchSin = MathHelper.sin(-pitch * 0.017453292F);
/*    */       
/* 41 */       Vec3 entityLook = new Vec3((yawSin * pitchCos), pitchSin, (yawCos * pitchCos));
/* 42 */       Vec3 vector = eyePosition.addVector(entityLook.xCoord * blockReachDistance, entityLook.yCoord * blockReachDistance, entityLook.zCoord * blockReachDistance);
/* 43 */       List<Entity> entityList = (Minecraft.getMinecraft()).theWorld.getEntitiesInAABBexcluding(renderViewEntity, renderViewEntity.getEntityBoundingBox().addCoord(entityLook.xCoord * blockReachDistance, entityLook.yCoord * blockReachDistance, entityLook.zCoord * blockReachDistance).expand(1.0D, 1.0D, 1.0D), Predicates.and(EntitySelectors.NOT_SPECTATING, Entity::canBeCollidedWith));
/*    */       
/* 45 */       Entity pointedEntity = null;
/*    */       
/* 47 */       for (Entity entity : entityList) {
/* 48 */         if (!entityFilter.canRaycast(entity)) {
/*    */           continue;
/*    */         }
/* 51 */         float collisionBorderSize = entity.getCollisionBorderSize();
/* 52 */         AxisAlignedBB axisAlignedBB = entity.getEntityBoundingBox().expand(collisionBorderSize, collisionBorderSize, collisionBorderSize);
/* 53 */         MovingObjectPosition movingObjectPosition = axisAlignedBB.calculateIntercept(eyePosition, vector);
/*    */         
/* 55 */         if (axisAlignedBB.isVecInside(eyePosition)) {
/* 56 */           if (blockReachDistance >= 0.0D) {
/* 57 */             pointedEntity = entity;
/* 58 */             blockReachDistance = 0.0D;
/*    */           }  continue;
/* 60 */         }  if (movingObjectPosition != null) {
/* 61 */           double eyeDistance = eyePosition.distanceTo(movingObjectPosition.hitVec);
/*    */           
/* 63 */           if (eyeDistance < blockReachDistance || blockReachDistance == 0.0D) {
/* 64 */             if (entity == renderViewEntity.ridingEntity) {
/* 65 */               if (blockReachDistance == 0.0D)
/* 66 */                 pointedEntity = entity;  continue;
/*    */             } 
/* 68 */             pointedEntity = entity;
/* 69 */             blockReachDistance = eyeDistance;
/*    */           } 
/*    */         } 
/*    */       } 
/*    */ 
/*    */       
/* 75 */       return pointedEntity;
/*    */     } 
/*    */     
/* 78 */     return null;
/*    */   }
/*    */   
/*    */   public static interface IEntityFilter {
/*    */     boolean canRaycast(Entity param1Entity);
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Utils\RaycastUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */