/*    */ package me.lavache.BaseClient.Utils;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.network.NetworkPlayerInfo;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.scoreboard.ScorePlayerTeam;
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
/*    */ 
/*    */ public class EntityUtil
/*    */ {
/* 21 */   private static Minecraft mc = Minecraft.getMinecraft();
/*    */   
/*    */   public static boolean targetInvisible = false;
/*    */   public static boolean targetPlayer = true;
/*    */   public static boolean targetMobs = true;
/*    */   public static boolean targetAnimals = false;
/*    */   public static boolean targetDead = false;
/*    */   
/*    */   public static boolean isSelected(Entity entity, boolean canAttackCheck) {
/* 30 */     if (entity instanceof net.minecraft.entity.EntityLivingBase && (targetDead || entity.isEntityAlive()) && entity != mc.thePlayer && (
/* 31 */       targetInvisible || !entity.isInvisible())) {
/* 32 */       if (targetPlayer && entity instanceof EntityPlayer) {
/* 33 */         EntityPlayer entityPlayer = (EntityPlayer)entity;
/*    */         
/* 35 */         if (canAttackCheck && 
/* 36 */           entityPlayer.isSpectator()) {
/* 37 */           return false;
/*    */         }
/*    */         
/* 40 */         return true;
/*    */       } 
/*    */       
/* 43 */       return !((!targetMobs || !isMob(entity)) && (!targetAnimals || !isAnimal(entity)));
/*    */     } 
/*    */ 
/*    */     
/* 47 */     return false;
/*    */   }
/*    */ 
/*    */   
/* 51 */   public static boolean isAnimal(Entity entity) { return !(!(entity instanceof net.minecraft.entity.passive.EntityAnimal) && !(entity instanceof net.minecraft.entity.passive.EntitySquid) && !(entity instanceof net.minecraft.entity.monster.EntityGolem) && 
/* 52 */       !(entity instanceof net.minecraft.entity.passive.EntityBat)); }
/*    */ 
/*    */ 
/*    */   
/* 56 */   public static boolean isMob(Entity entity) { return !(!(entity instanceof net.minecraft.entity.monster.EntityMob) && !(entity instanceof net.minecraft.entity.passive.EntityVillager) && !(entity instanceof net.minecraft.entity.monster.EntitySlime) && 
/* 57 */       !(entity instanceof net.minecraft.entity.monster.EntityGhast) && !(entity instanceof net.minecraft.entity.boss.EntityDragon)); }
/*    */ 
/*    */   
/*    */   public static String getName(NetworkPlayerInfo networkPlayerInfoIn) {
/* 61 */     return (networkPlayerInfoIn.getDisplayName() != null) ? networkPlayerInfoIn.getDisplayName().getFormattedText() : 
/* 62 */       ScorePlayerTeam.formatPlayerName(networkPlayerInfoIn.getPlayerTeam(), networkPlayerInfoIn.getGameProfile().getName());
/*    */   }
/*    */   
/*    */   public static int getPing(EntityPlayer entityPlayer) {
/* 66 */     if (entityPlayer == null) {
/* 67 */       return 0;
/*    */     }
/* 69 */     NetworkPlayerInfo networkPlayerInfo = mc.getNetHandler().getPlayerInfo(entityPlayer.getUniqueID());
/*    */     
/* 71 */     return (networkPlayerInfo == null) ? 0 : networkPlayerInfo.getResponseTime();
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Utils\EntityUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */