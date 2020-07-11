/*     */ package me.lavache.BaseClient.Utils;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.Vec3;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PathUtils
/*     */ {
/*     */   private Vec3 startVec3;
/*     */   private Vec3 endVec3;
/*     */   private ArrayList<Vec3> path;
/*     */   private ArrayList<Hub> hubs;
/*     */   private ArrayList<Hub> hubsToWork;
/*     */   private double minDistanceSquared;
/*     */   private boolean nearest;
/*  36 */   private static Vec3[] flatCardinalDirections = { new Vec3(1.0D, 0.0D, 0.0D), 
/*  37 */       new Vec3(-1.0D, 0.0D, 0.0D), 
/*  38 */       new Vec3(0.0D, 0.0D, 1.0D), 
/*  39 */       new Vec3(0.0D, 0.0D, -1.0D) }; public PathUtils(Vec3 startVec3, Vec3 endVec3) { this.path = new ArrayList(); this.hubs = new ArrayList();
/*     */     this.hubsToWork = new ArrayList();
/*     */     this.minDistanceSquared = 9.0D;
/*     */     this.nearest = true;
/*  43 */     this.startVec3 = startVec3.addVector(0.0D, 0.0D, 0.0D).normalize();
/*  44 */     this.endVec3 = endVec3.addVector(0.0D, 0.0D, 0.0D).normalize(); }
/*     */ 
/*     */ 
/*     */   
/*  48 */   public ArrayList<Vec3> getPath() { return this.path; }
/*     */ 
/*     */ 
/*     */   
/*  52 */   public void compute() { compute(1000, 4); }
/*     */ 
/*     */   
/*     */   public void compute(int loops, int depth) {
/*  56 */     this.path.clear();
/*  57 */     this.hubsToWork.clear();
/*  58 */     ArrayList<Vec3> initPath = new ArrayList<Vec3>();
/*  59 */     initPath.add(this.startVec3);
/*  60 */     this.hubsToWork.add(new Hub(this.startVec3, null, initPath, this.startVec3.squareDistanceTo(this.endVec3), 0.0D, 0.0D));
/*     */     int i;
/*  62 */     label38: for (i = 0; i < loops; i++) {
/*  63 */       Collections.sort(this.hubsToWork, new CompareHub());
/*  64 */       int j = 0;
/*  65 */       if (this.hubsToWork.size() == 0) {
/*     */         break;
/*     */       }
/*  68 */       for (Hub hub : new ArrayList(this.hubsToWork)) {
/*  69 */         j++;
/*  70 */         if (j > depth) {
/*     */           break;
/*     */         }
/*  73 */         this.hubsToWork.remove(hub);
/*  74 */         this.hubs.add(hub); byte b; int k;
/*     */         Vec3[] arrayOfVec3;
/*  76 */         for (k = arrayOfVec3 = flatCardinalDirections.length, b = 0; b < k; ) { Vec3 direction = arrayOfVec3[b];
/*  77 */           Vec3 loc = hub.getLoc().add(direction).normalize();
/*  78 */           if (checkPositionValidity(loc, false) && 
/*  79 */             addHub(hub, loc, 0.0D)) {
/*     */             break label38;
/*     */           }
/*     */           
/*     */           b++; }
/*     */         
/*  85 */         Vec3 loc1 = hub.getLoc().addVector(0.0D, 1.0D, 0.0D).normalize();
/*  86 */         if (checkPositionValidity(loc1, false) && 
/*  87 */           addHub(hub, loc1, 0.0D)) {
/*     */           break label38;
/*     */         }
/*     */ 
/*     */         
/*  92 */         Vec3 loc2 = hub.getLoc().addVector(0.0D, -1.0D, 0.0D).normalize();
/*  93 */         if (checkPositionValidity(loc2, false) && 
/*  94 */           addHub(hub, loc2, 0.0D)) {
/*     */           break label38;
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 101 */     if (this.nearest) {
/* 102 */       Collections.sort(this.hubs, new CompareHub());
/* 103 */       this.path = ((Hub)this.hubs.get(0)).getPath();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/* 108 */   public static boolean checkPositionValidity(Vec3 loc, boolean checkGround) { return checkPositionValidity((int)loc.xCoord, (int)loc.yCoord, (int)loc.zCoord, checkGround); }
/*     */ 
/*     */   
/*     */   public static boolean checkPositionValidity(int x, int y, int z, boolean checkGround) {
/* 112 */     BlockPos block1 = new BlockPos(x, y, z);
/* 113 */     BlockPos block2 = new BlockPos(x, y + 1, z);
/* 114 */     BlockPos block3 = new BlockPos(x, y - 1, z);
/* 115 */     return (!isBlockSolid(block1) && !isBlockSolid(block2) && (isBlockSolid(block3) || !checkGround) && isSafeToWalkOn(block3));
/*     */   }
/*     */ 
/*     */   
/* 119 */   private static boolean isBlockSolid(BlockPos block) { return !(!AyaBlock.getBlock(new BlockPos(block.getX(), block.getY(), block.getZ())).isFullCube() && 
/* 120 */       !(AyaBlock.getBlock(new BlockPos(block.getX(), block.getY(), block.getZ())) instanceof net.minecraft.block.BlockSlab) && 
/* 121 */       !(AyaBlock.getBlock(new BlockPos(block.getX(), block.getY(), block.getZ())) instanceof net.minecraft.block.BlockStairs) && 
/* 122 */       !(AyaBlock.getBlock(new BlockPos(block.getX(), block.getY(), block.getZ())) instanceof net.minecraft.block.BlockCactus) && 
/* 123 */       !(AyaBlock.getBlock(new BlockPos(block.getX(), block.getY(), block.getZ())) instanceof net.minecraft.block.BlockChest) && 
/* 124 */       !(AyaBlock.getBlock(new BlockPos(block.getX(), block.getY(), block.getZ())) instanceof net.minecraft.block.BlockEnderChest) && 
/* 125 */       !(AyaBlock.getBlock(new BlockPos(block.getX(), block.getY(), block.getZ())) instanceof net.minecraft.block.BlockSkull) && 
/* 126 */       !(AyaBlock.getBlock(new BlockPos(block.getX(), block.getY(), block.getZ())) instanceof net.minecraft.block.BlockPane) && 
/* 127 */       !(AyaBlock.getBlock(new BlockPos(block.getX(), block.getY(), block.getZ())) instanceof net.minecraft.block.BlockFence) && 
/* 128 */       !(AyaBlock.getBlock(new BlockPos(block.getX(), block.getY(), block.getZ())) instanceof net.minecraft.block.BlockWall) && 
/* 129 */       !(AyaBlock.getBlock(new BlockPos(block.getX(), block.getY(), block.getZ())) instanceof net.minecraft.block.BlockGlass) && 
/* 130 */       !(AyaBlock.getBlock(new BlockPos(block.getX(), block.getY(), block.getZ())) instanceof net.minecraft.block.BlockPistonBase) && 
/* 131 */       !(AyaBlock.getBlock(new BlockPos(block.getX(), block.getY(), block.getZ())) instanceof net.minecraft.block.BlockPistonExtension) && 
/* 132 */       !(AyaBlock.getBlock(new BlockPos(block.getX(), block.getY(), block.getZ())) instanceof net.minecraft.block.BlockPistonMoving) && 
/* 133 */       !(AyaBlock.getBlock(new BlockPos(block.getX(), block.getY(), block.getZ())) instanceof net.minecraft.block.BlockStainedGlass) && 
/* 134 */       !(AyaBlock.getBlock(new BlockPos(block.getX(), block.getY(), block.getZ())) instanceof net.minecraft.block.BlockTrapDoor)); }
/*     */ 
/*     */ 
/*     */   
/* 138 */   private static boolean isSafeToWalkOn(BlockPos block) { return (!(AyaBlock.getBlock(new BlockPos(block.getX(), block.getY(), block.getZ())) instanceof net.minecraft.block.BlockFence) && 
/* 139 */       !(AyaBlock.getBlock(new BlockPos(block.getX(), block.getY(), block.getZ())) instanceof net.minecraft.block.BlockWall)); }
/*     */ 
/*     */   
/*     */   public Hub isHubExisting(Vec3 loc) {
/* 143 */     for (Hub hub : this.hubs) {
/* 144 */       if ((hub.getLoc()).xCoord == loc.xCoord && (hub.getLoc()).yCoord == loc.yCoord && (hub.getLoc()).zCoord == loc.zCoord) {
/* 145 */         return hub;
/*     */       }
/*     */     } 
/* 148 */     for (Hub hub : this.hubsToWork) {
/* 149 */       if ((hub.getLoc()).xCoord == loc.xCoord && (hub.getLoc()).yCoord == loc.yCoord && (hub.getLoc()).zCoord == loc.zCoord) {
/* 150 */         return hub;
/*     */       }
/*     */     } 
/* 153 */     return null;
/*     */   }
/*     */   
/*     */   public boolean addHub(Hub parent, Vec3 loc, double cost) {
/* 157 */     Hub existingHub = isHubExisting(loc);
/* 158 */     double totalCost = cost;
/* 159 */     if (parent != null) {
/* 160 */       totalCost += parent.getTotalCost();
/*     */     }
/* 162 */     if (existingHub == null) {
/* 163 */       if ((loc.xCoord == this.endVec3.xCoord && loc.yCoord == this.endVec3.yCoord && loc.zCoord == this.endVec3.zCoord) || (this.minDistanceSquared != 0.0D && loc.squareDistanceTo(this.endVec3) <= this.minDistanceSquared)) {
/* 164 */         this.path.clear();
/* 165 */         this.path = parent.getPath();
/* 166 */         this.path.add(loc);
/* 167 */         return true;
/*     */       } 
/* 169 */       ArrayList<Vec3> path = new ArrayList<Vec3>(parent.getPath());
/* 170 */       path.add(loc);
/* 171 */       this.hubsToWork.add(new Hub(loc, parent, path, loc.squareDistanceTo(this.endVec3), cost, totalCost));
/*     */     }
/* 173 */     else if (existingHub.getCost() > cost) {
/* 174 */       ArrayList<Vec3> path = new ArrayList<Vec3>(parent.getPath());
/* 175 */       path.add(loc);
/* 176 */       existingHub.setLoc(loc);
/* 177 */       existingHub.setParent(parent);
/* 178 */       existingHub.setPath(path);
/* 179 */       existingHub.setSquareDistanceToFromTarget(loc.squareDistanceTo(this.endVec3));
/* 180 */       existingHub.setCost(cost);
/* 181 */       existingHub.setTotalCost(totalCost);
/*     */     } 
/* 183 */     return false;
/*     */   }
/*     */   private class Hub { private Vec3 loc; private Hub parent; private ArrayList<Vec3> path;
/*     */     public Hub(Vec3 loc, Hub parent, ArrayList<Vec3> path, double squareDistanceToFromTarget, double cost, double totalCost) {
/* 187 */       this.loc = null;
/* 188 */       this.parent = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 195 */       this.loc = loc;
/* 196 */       this.parent = parent;
/* 197 */       this.path = path;
/* 198 */       this.squareDistanceToFromTarget = squareDistanceToFromTarget;
/* 199 */       this.cost = cost;
/* 200 */       this.totalCost = totalCost;
/*     */     }
/*     */     private double squareDistanceToFromTarget; private double cost; private double totalCost;
/*     */     
/* 204 */     public Vec3 getLoc() { return this.loc; }
/*     */ 
/*     */ 
/*     */     
/* 208 */     public Hub getParent() { return this.parent; }
/*     */ 
/*     */ 
/*     */     
/* 212 */     public ArrayList<Vec3> getPath() { return this.path; }
/*     */ 
/*     */ 
/*     */     
/* 216 */     public double getSquareDistanceToFromTarget() { return this.squareDistanceToFromTarget; }
/*     */ 
/*     */ 
/*     */     
/* 220 */     public double getCost() { return this.cost; }
/*     */ 
/*     */ 
/*     */     
/* 224 */     public void setLoc(Vec3 loc) { this.loc = loc; }
/*     */ 
/*     */ 
/*     */     
/* 228 */     public void setParent(Hub parent) { this.parent = parent; }
/*     */ 
/*     */ 
/*     */     
/* 232 */     public void setPath(ArrayList<Vec3> path) { this.path = path; }
/*     */ 
/*     */ 
/*     */     
/* 236 */     public void setSquareDistanceToFromTarget(double squareDistanceToFromTarget) { this.squareDistanceToFromTarget = squareDistanceToFromTarget; }
/*     */ 
/*     */ 
/*     */     
/* 240 */     public void setCost(double cost) { this.cost = cost; }
/*     */ 
/*     */ 
/*     */     
/* 244 */     public double getTotalCost() { return this.totalCost; }
/*     */ 
/*     */ 
/*     */     
/* 248 */     public void setTotalCost(double totalCost) { this.totalCost = totalCost; } }
/*     */ 
/*     */   
/*     */   public class CompareHub
/*     */     extends Object
/*     */     implements Comparator<Hub> {
/*     */     public int compare(PathUtils.Hub o1, PathUtils.Hub o2) {
/* 255 */       return (int)(
/* 256 */         o1.getSquareDistanceToFromTarget() + o1.getTotalCost() - o2.getSquareDistanceToFromTarget() + o2.getTotalCost());
/*     */     }
/*     */   }
/*     */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Utils\PathUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */