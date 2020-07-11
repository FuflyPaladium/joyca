/*     */ package me.lavache.BaseClient.Utils;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class RotationUtils {
/*  11 */   static Minecraft mc = Minecraft.getMinecraft();
/*     */   
/*     */   public static double[] interpolate(Entity entity) {
/*  14 */     double partialTicks = mc.timer.renderPartialTicks;
/*  15 */     return new double[] { entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * partialTicks, entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * partialTicks, entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * partialTicks };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  20 */   public static boolean isWithingFOV(Entity en, float angle) { return false; }
/*     */ 
/*     */   
/*     */   public static float[] getRotationsForAura(Entity entity, double maxRange) {
/*  24 */     if (entity == null) {
/*  25 */       System.out.println("Fuck you ! Entity is nul!");
/*  26 */       return null;
/*     */     } 
/*  28 */     double diffX = entity.posX - mc.thePlayer.posX;
/*  29 */     double diffZ = entity.posZ - mc.thePlayer.posZ;
/*  30 */     Location BestPos = new Location(entity.posX, entity.posY, entity.posZ);
/*  31 */     Location myEyePos = new Location(mc.thePlayer.posX, mc.thePlayer.posY + mc.thePlayer.getEyeHeight(), mc.thePlayer.posZ);
/*     */     
/*     */     double diffY;
/*  34 */     for (diffY = entity.boundingBox.minY + 0.7D; diffY < entity.boundingBox.maxY - 0.1D; diffY += 0.1D) {
/*  35 */       if (myEyePos.distanceTo(new Location(entity.posX, diffY, entity.posZ)) < myEyePos.distanceTo(BestPos)) {
/*  36 */         BestPos = new Location(entity.posX, diffY, entity.posZ);
/*     */       }
/*     */     } 
/*     */     
/*  40 */     if (myEyePos.distanceTo(BestPos) > maxRange) {
/*  41 */       return null;
/*     */     }
/*  43 */     diffY = BestPos.getY() - mc.thePlayer.posY + mc.thePlayer.getEyeHeight();
/*  44 */     double dist = MathHelper.sqrt_double(diffX * diffX + diffZ * diffZ);
/*  45 */     float yaw = (float)(Math.atan2(diffZ, diffX) * 180.0D / Math.PI) - 90.0F;
/*  46 */     float pitch = (float)-(Math.atan2(diffY, dist) * 180.0D / Math.PI);
/*  47 */     return new float[] { yaw, pitch };
/*     */   }
/*     */ 
/*     */   
/*     */   public static float[] getRotations(Entity entity) {
/*     */     double diffY;
/*  53 */     if (entity == null) {
/*  54 */       return null;
/*     */     }
/*  56 */     double diffX = entity.posX - mc.thePlayer.posX;
/*  57 */     double diffZ = entity.posZ - mc.thePlayer.posZ;
/*     */     
/*  59 */     if (entity instanceof EntityLivingBase) {
/*  60 */       EntityLivingBase elb = (EntityLivingBase)entity;
/*  61 */       diffY = elb.posY + elb.getEyeHeight() - mc.thePlayer.posY + mc.thePlayer.getEyeHeight();
/*     */     } else {
/*  63 */       diffY = (entity.boundingBox.minY + entity.boundingBox.maxY) / 2.0D - mc.thePlayer.posY + mc.thePlayer.getEyeHeight();
/*     */     } 
/*     */     
/*  66 */     double dist = MathHelper.sqrt_double(diffX * diffX + diffZ * diffZ);
/*  67 */     float yaw = (float)(Math.atan2(diffZ, diffX) * 180.0D / Math.PI) - 90.0F;
/*  68 */     float pitch = (float)-(Math.atan2(diffY, dist) * 180.0D / Math.PI);
/*  69 */     return new float[] { yaw, pitch };
/*     */   }
/*     */ 
/*     */   
/*     */   public static float[] getRotations(EntityLivingBase ent, double Ix, double Iy, double Iz) {
/*  74 */     double x = ent.posX;
/*  75 */     double z = ent.posZ;
/*  76 */     double y = ent.posY + (ent.getEyeHeight() / 2.0F);
/*  77 */     double xDiff = x - Ix;
/*  78 */     double zDiff = z - Iz;
/*  79 */     double yDiff = y - Iy - 0.6D;
/*  80 */     double dist = MathHelper.sqrt_double(xDiff * xDiff + zDiff * zDiff);
/*  81 */     float yaw = (float)(Math.atan2(zDiff, xDiff) * 180.0D / Math.PI) - 90.0F;
/*  82 */     float pitch = (float)-(Math.atan2(yDiff, dist) * 180.0D / Math.PI);
/*  83 */     return new float[] { yaw, pitch };
/*     */   }
/*     */   
/*     */   public static float[] getAverageRotations(List<EntityLivingBase> targetList) {
/*  87 */     double posX = 0.0D;
/*  88 */     double posY = 0.0D;
/*  89 */     double posZ = 0.0D;
/*     */ 
/*     */     
/*  92 */     for (Iterator var8 = targetList.iterator(); var8.hasNext(); posZ += ent.posZ) {
/*  93 */       Entity ent = (Entity)var8.next();
/*  94 */       posX += ent.posX;
/*  95 */       posY += ent.boundingBox.maxY - 2.0D;
/*     */     } 
/*     */     
/*  98 */     posX /= targetList.size();
/*  99 */     posY /= targetList.size();
/* 100 */     posZ /= targetList.size();
/* 101 */     return new float[] { getRotationFromPosition(posX, posY, posZ)[0], getRotationFromPosition(posX, posY, posZ)[1] };
/*     */   }
/*     */   
/*     */   public static float[] getRotationFromPosition(double x, double y, double z) {
/* 105 */     Minecraft.getMinecraft();
/* 106 */     double xDiff = x - mc.thePlayer.posX;
/* 107 */     Minecraft.getMinecraft();
/* 108 */     double zDiff = z - mc.thePlayer.posZ;
/* 109 */     Minecraft.getMinecraft();
/* 110 */     double yDiff = y - mc.thePlayer.posY - 1.3D;
/* 111 */     double dist = MathHelper.sqrt_double(xDiff * xDiff + zDiff * zDiff);
/* 112 */     float yaw = (float)(Math.atan2(zDiff, xDiff) * 180.0D / Math.PI) - 90.0F;
/* 113 */     float pitch = (float)-(Math.atan2(yDiff, dist) * 180.0D / Math.PI);
/* 114 */     return new float[] { yaw, pitch };
/*     */   }
/*     */   
/*     */   public static float getTrajAngleSolutionLow(float d3, float d1, float velocity) {
/* 118 */     float g = 0.006F;
/* 119 */     float sqrt = velocity * velocity * velocity * velocity - 0.006F * (0.006F * d3 * d3 + 2.0F * d1 * velocity * velocity);
/* 120 */     return (float)Math.toDegrees(Math.atan(((velocity * velocity) - Math.sqrt(sqrt)) / (0.006F * d3)));
/*     */   }
/*     */   
/*     */   public static float getNewAngle(float angle) {
/* 124 */     angle %= 360.0F;
/* 125 */     if (angle >= 180.0F) {
/* 126 */       angle -= 360.0F;
/*     */     }
/*     */     
/* 129 */     if (angle < -180.0F) {
/* 130 */       angle += 360.0F;
/*     */     }
/*     */     
/* 133 */     return angle;
/*     */   }
/*     */   
/*     */   public static float getDistanceBetweenAngles(float angle1, float angle2) {
/* 137 */     float angle3 = Math.abs(angle1 - angle2) % 360.0F;
/* 138 */     if (angle3 > 180.0F) {
/* 139 */       angle3 = 360.0F - angle3;
/*     */     }
/*     */     
/* 142 */     return angle3;
/*     */   }
/*     */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Utils\RotationUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */