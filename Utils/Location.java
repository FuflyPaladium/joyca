/*     */ package me.lavache.BaseClient.Utils;
/*     */ 
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.util.BlockPos;
/*     */ 
/*     */ public class Location {
/*   8 */   static Minecraft mc = Minecraft.getMinecraft();
/*     */   
/*     */   private double x;
/*     */   private double y;
/*     */   private double z;
/*     */   private float yaw;
/*     */   private float pitch;
/*     */   
/*     */   public Location(double x, double y, double z, float yaw, float pitch) {
/*  17 */     this.x = x;
/*  18 */     this.y = y;
/*  19 */     this.z = z;
/*  20 */     this.yaw = yaw;
/*  21 */     this.pitch = pitch;
/*     */   }
/*     */   
/*     */   public Location(double x, double y, double z) {
/*  25 */     this.x = x;
/*  26 */     this.y = y;
/*  27 */     this.z = z;
/*  28 */     this.yaw = 0.0F;
/*  29 */     this.pitch = 0.0F;
/*     */   }
/*     */   
/*     */   public Location(BlockPos pos) {
/*  33 */     this.x = pos.getX();
/*  34 */     this.y = pos.getY();
/*  35 */     this.z = pos.getZ();
/*  36 */     this.yaw = 0.0F;
/*  37 */     this.pitch = 0.0F;
/*     */   }
/*     */   
/*     */   public Location(int x, int y, int z) {
/*  41 */     this.x = x;
/*  42 */     this.y = y;
/*  43 */     this.z = z;
/*  44 */     this.yaw = 0.0F;
/*  45 */     this.pitch = 0.0F;
/*     */   }
/*     */   
/*     */   public Location add(int x, int y, int z) {
/*  49 */     this.x += x;
/*  50 */     this.y += y;
/*  51 */     this.z += z;
/*  52 */     return this;
/*     */   }
/*     */   
/*     */   public Location add(double x, double y, double z) {
/*  56 */     this.x += x;
/*  57 */     this.y += y;
/*  58 */     this.z += z;
/*  59 */     return this;
/*     */   }
/*     */   
/*     */   public Location subtract(int x, int y, int z) {
/*  63 */     this.x -= x;
/*  64 */     this.y -= y;
/*  65 */     this.z -= z;
/*  66 */     return this;
/*     */   }
/*     */   
/*     */   public Location subtract(double x, double y, double z) {
/*  70 */     this.x -= x;
/*  71 */     this.y -= y;
/*  72 */     this.z -= z;
/*  73 */     return this;
/*     */   }
/*     */ 
/*     */   
/*  77 */   public Block getBlock() { return mc.theWorld.getBlockState(toBlockPos()).getBlock(); }
/*     */ 
/*     */ 
/*     */   
/*  81 */   public double getX() { return this.x; }
/*     */ 
/*     */   
/*     */   public Location setX(double x) {
/*  85 */     this.x = x;
/*  86 */     return this;
/*     */   }
/*     */ 
/*     */   
/*  90 */   public double getY() { return this.y; }
/*     */ 
/*     */   
/*     */   public Location setY(double y) {
/*  94 */     this.y = y;
/*  95 */     return this;
/*     */   }
/*     */ 
/*     */   
/*  99 */   public double getZ() { return this.z; }
/*     */ 
/*     */   
/*     */   public Location setZ(double z) {
/* 103 */     this.z = z;
/* 104 */     return this;
/*     */   }
/*     */ 
/*     */   
/* 108 */   public float getYaw() { return this.yaw; }
/*     */ 
/*     */   
/*     */   public Location setYaw(float yaw) {
/* 112 */     this.yaw = yaw;
/* 113 */     return this;
/*     */   }
/*     */ 
/*     */   
/* 117 */   public float getPitch() { return this.pitch; }
/*     */ 
/*     */   
/*     */   public Location setPitch(float pitch) {
/* 121 */     this.pitch = pitch;
/* 122 */     return this;
/*     */   }
/*     */ 
/*     */   
/* 126 */   public static Location fromBlockPos(BlockPos blockPos) { return new Location(blockPos.getX(), blockPos.getY(), blockPos.getZ()); }
/*     */ 
/*     */ 
/*     */   
/* 130 */   public BlockPos toBlockPos() { return new BlockPos(getX(), getY(), getZ()); }
/*     */ 
/*     */   
/*     */   public double distanceTo(Location loc) {
/* 134 */     double dx = loc.x - this.x;
/* 135 */     double dz = loc.z - this.z;
/* 136 */     double dy = loc.y - this.y;
/* 137 */     return Math.sqrt(dx * dx + dy * dy + dz * dz);
/*     */   }
/*     */   
/*     */   public double distanceToY(Location loc) {
/* 141 */     double dy = loc.y - this.y;
/* 142 */     return Math.sqrt(dy * dy);
/*     */   }
/*     */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Utils\Location.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */