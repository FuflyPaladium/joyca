/*    */ package me.lavache.BaseClient.Utils;
/*    */ 
/*    */ public class Rotation {
/*    */   private Minecraft mc;
/*    */   
/*    */   public Rotation(float y, float p) {
/*  7 */     this.mc = Minecraft.getMinecraft();
/*    */ 
/*    */ 
/*    */     
/* 11 */     this.yaw = y;
/* 12 */     this.pitch = p;
/*    */   }
/*    */   private float yaw; private float pitch;
/*    */   
/*    */   public void toPlayer(EntityPlayer player) {
/* 17 */     fixedSensitivity(this.mc.gameSettings.mouseSensitivity);
/*    */     
/* 19 */     player.rotationYaw = this.yaw;
/* 20 */     player.rotationPitch = this.pitch;
/*    */   }
/*    */   
/*    */   public void fixedSensitivity(float sens) {
/* 24 */     float f = sens * 0.6F + 0.2F;
/* 25 */     float gcd = f * f * f * 1.2F;
/*    */     
/* 27 */     this.yaw -= this.yaw % gcd;
/* 28 */     this.pitch -= this.pitch % gcd;
/*    */   }
/*    */ 
/*    */   
/* 32 */   public float getYaw() { return this.yaw; }
/*    */ 
/*    */ 
/*    */   
/* 36 */   public void setYaw(float yaw) { this.yaw = yaw; }
/*    */ 
/*    */ 
/*    */   
/* 40 */   public float getPitch() { return this.pitch; }
/*    */ 
/*    */ 
/*    */   
/* 44 */   public void setPitch(float pitch) { this.pitch = pitch; }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Utils\Rotation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */