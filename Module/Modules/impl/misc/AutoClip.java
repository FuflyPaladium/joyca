/*    */ package me.lavache.BaseClient.Module.Modules.impl.misc;
/*    */ 
/*    */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*    */ import me.lavache.BaseClient.Eventbus.Events.EventUpdate;
/*    */ import me.lavache.BaseClient.Module.Category;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ import me.lavache.BaseClient.Utils.MovementUtils;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.util.BlockPos;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AutoClip
/*    */   extends Module
/*    */ {
/* 19 */   public AutoClip() { super("AutoClip", 17, Category.MISC); }
/*    */ 
/*    */ 
/*    */   
/*    */   @EventTarget
/*    */   public void onUpdate(EventUpdate e) {
/* 25 */     BlockPos oneblockBelowPlayer = (new BlockPos(mc.thePlayer)).add(mc.thePlayer.posX, mc.thePlayer.posY - 1.0D, mc.thePlayer.posZ);
/* 26 */     BlockPos twoblockBelowPlayer = (new BlockPos(mc.thePlayer)).add(mc.thePlayer.posX, mc.thePlayer.posY - 2.0D, mc.thePlayer.posZ);
/* 27 */     BlockPos threeblockBelowPlayer = (new BlockPos(mc.thePlayer)).add(mc.thePlayer.posX, mc.thePlayer.posY - 3.0D, mc.thePlayer.posZ);
/* 28 */     BlockPos fourblockBelowPlayer = (new BlockPos(mc.thePlayer)).add(mc.thePlayer.posX, mc.thePlayer.posY - 4.0D, mc.thePlayer.posZ);
/* 29 */     BlockPos fiveblockBelowPlayer = (new BlockPos(mc.thePlayer)).add(mc.thePlayer.posX, mc.thePlayer.posY - 5.0D, mc.thePlayer.posZ);
/* 30 */     BlockPos sixblockBelowPlayer = (new BlockPos(mc.thePlayer)).add(mc.thePlayer.posX, mc.thePlayer.posY - 6.0D, mc.thePlayer.posZ);
/* 31 */     BlockPos sevenblockBelowPlayer = (new BlockPos(mc.thePlayer)).add(mc.thePlayer.posX, mc.thePlayer.posY - 7.0D, mc.thePlayer.posZ);
/* 32 */     BlockPos eigthblockBelowPlayer = (new BlockPos(mc.thePlayer)).add(mc.thePlayer.posX, mc.thePlayer.posY - 8.0D, mc.thePlayer.posZ);
/*    */     
/* 34 */     if (mc.gameSettings.keyBindSneak.isPressed()) {
/* 35 */       mc.thePlayer.motionY = -5.0D;
/*    */       
/* 37 */       if (mc.theWorld.getBlockState(oneblockBelowPlayer).getBlock() == Blocks.air) {
/* 38 */         MovementUtils.vClip(-3.0D); return;
/*    */       } 
/* 40 */       if (mc.theWorld.getBlockState(twoblockBelowPlayer).getBlock() == Blocks.air) {
/* 41 */         MovementUtils.vClip(-4.0D); return;
/*    */       } 
/* 43 */       if (mc.theWorld.getBlockState(threeblockBelowPlayer).getBlock() == Blocks.air) {
/* 44 */         MovementUtils.vClip(-5.0D); return;
/*    */       } 
/* 46 */       if (mc.theWorld.getBlockState(fourblockBelowPlayer).getBlock() == Blocks.air) {
/* 47 */         MovementUtils.vClip(-6.0D); return;
/*    */       } 
/* 49 */       if (mc.theWorld.getBlockState(fiveblockBelowPlayer).getBlock() == Blocks.air) {
/* 50 */         MovementUtils.vClip(-7.0D); return;
/*    */       } 
/* 52 */       if (mc.theWorld.getBlockState(sixblockBelowPlayer).getBlock() == Blocks.air) {
/* 53 */         MovementUtils.vClip(-8.0D); return;
/*    */       } 
/* 55 */       if (mc.theWorld.getBlockState(sevenblockBelowPlayer).getBlock() == Blocks.air) {
/* 56 */         MovementUtils.vClip(-9.0D); return;
/*    */       } 
/* 58 */       if (mc.theWorld.getBlockState(eigthblockBelowPlayer).getBlock() == Blocks.air) {
/* 59 */         MovementUtils.vClip(-10.0D);
/*    */         return;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\misc\AutoClip.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */