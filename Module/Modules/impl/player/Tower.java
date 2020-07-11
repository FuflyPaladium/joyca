/*    */ package me.lavache.BaseClient.Module.Modules.impl.player;
/*    */ 
/*    */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*    */ import me.lavache.BaseClient.Eventbus.Events.EventUpdate;
/*    */ import me.lavache.BaseClient.Module.Category;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ import me.lavache.BaseClient.Utils.MovementUtils;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.network.play.client.C03PacketPlayer;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.util.Vec3;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Tower
/*    */   extends Module
/*    */ {
/* 21 */   public Tower() { super("Tower", 0, Category.PLAYER); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 26 */   public void onEnable() { super.onEnable(); }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onDisable() {
/* 31 */     super.onDisable();
/* 32 */     mc.timer.timerSpeed = 1.0F;
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public void onUpdate(EventUpdate event) {
/* 37 */     mc.timer.timerSpeed = 0.9F;
/* 38 */     BlockPos playerBlock = new BlockPos(mc.thePlayer.posX, (mc.thePlayer.getEntityBoundingBox()).minY, mc.thePlayer.posZ);
/* 39 */     if (!mc.thePlayer.onGround) {
/* 40 */       if (mc.theWorld.isAirBlock(playerBlock.add(0, -1, 0))) {
/* 41 */         mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C05PacketPlayerLook(mc.thePlayer.rotationYaw, 90.0F, true));
/* 42 */         if (isValidBlock(playerBlock.add(0, -2, 0))) {
/* 43 */           place(playerBlock.add(0, -1, 0), EnumFacing.UP);
/* 44 */         } else if (isValidBlock(playerBlock.add(-1, -1, 0))) {
/* 45 */           place(playerBlock.add(0, -1, 0), EnumFacing.EAST);
/* 46 */         } else if (isValidBlock(playerBlock.add(1, -1, 0))) {
/* 47 */           place(playerBlock.add(0, -1, 0), EnumFacing.WEST);
/* 48 */         } else if (isValidBlock(playerBlock.add(0, -1, -1))) {
/* 49 */           place(playerBlock.add(0, -1, 0), EnumFacing.SOUTH);
/* 50 */         } else if (isValidBlock(playerBlock.add(0, -1, 1))) {
/* 51 */           place(playerBlock.add(0, -1, 0), EnumFacing.NORTH);
/*    */         } 
/*    */       } 
/*    */     } else {
/* 55 */       MovementUtils.vClip(1.0D);
/*    */     } 
/*    */   }
/*    */   private boolean isValidBlock(BlockPos pos) {
/* 59 */     Block b = mc.theWorld.getBlockState(pos).getBlock();
/* 60 */     mc.thePlayer.setSneaking(true);
/* 61 */     return (!(b instanceof net.minecraft.block.BlockLiquid) && b.getMaterial() != Material.air);
/*    */   }
/*    */   
/*    */   public void place(BlockPos pos, EnumFacing face) {
/* 65 */     if (face == EnumFacing.UP) {
/* 66 */       pos = pos.add(0, -1, 0);
/* 67 */     } else if (face == EnumFacing.NORTH) {
/* 68 */       pos = pos.add(0, 0, 1);
/* 69 */     } else if (face == EnumFacing.SOUTH) {
/* 70 */       pos = pos.add(0, 0, -1);
/* 71 */     } else if (face == EnumFacing.EAST) {
/* 72 */       pos = pos.add(-1, 0, 0);
/* 73 */     } else if (face == EnumFacing.WEST) {
/* 74 */       pos = pos.add(1, 0, 0);
/*    */     } 
/*    */     
/* 77 */     if (mc.thePlayer.getHeldItem() != null && 
/* 78 */       mc.thePlayer.getHeldItem().getItem() instanceof net.minecraft.item.ItemBlock) {
/* 79 */       mc.thePlayer.swingItem();
/* 80 */       mc.playerController.onPlayerRightClick(mc.thePlayer, mc.theWorld, 
/* 81 */           mc.thePlayer.getHeldItem(), pos, face, new Vec3(0.1D, 0.1D, 0.1D));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\player\Tower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */