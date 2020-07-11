/*    */ package me.lavache.BaseClient.Utils;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.state.BlockState;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ 
/*    */ public class AyaBlock
/*    */ {
/* 12 */   private static Minecraft mc = Minecraft.getMinecraft();
/*    */ 
/*    */   
/* 15 */   public static BlockState getBlockState(BlockPos blockPos) { return (BlockState)mc.theWorld.getBlockState(blockPos); }
/*    */ 
/*    */ 
/*    */   
/* 19 */   public static Block getBlock(BlockPos blockPos) { return getBlockState(blockPos).getBlock(); }
/*    */ 
/*    */ 
/*    */   
/* 23 */   public static int getBlockId(BlockPos blockPos) { return Block.getIdFromBlock(getBlock(blockPos)); }
/*    */ 
/*    */ 
/*    */   
/* 27 */   public static double getDurability(BlockPos blockPos) { return getBlockState(blockPos).getBlock().getBlockHardness(mc.theWorld, blockPos); }
/*    */ 
/*    */   
/*    */   public static String getMaxBoundingBox(BlockPos blockPos) {
/* 31 */     double x = getBlockState(blockPos).getBlock().getBlockBoundsMaxX();
/* 32 */     double y = getBlockState(blockPos).getBlock().getBlockBoundsMaxY();
/* 33 */     double z = getBlockState(blockPos).getBlock().getBlockBoundsMaxZ();
/* 34 */     return String.valueOf(x) + " " + y + " " + z;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static float[] getBlockRotations(double x, double y, double z) {
/* 40 */     double var4 = x - mc.thePlayer.posX + 0.5D;
/* 41 */     double var5 = z - mc.thePlayer.posZ + 0.5D;
/* 42 */     double var6 = y - mc.thePlayer.posY + mc.thePlayer.getEyeHeight() - 1.0D;
/* 43 */     double var7 = MathHelper.sqrt_double(var4 * var4 + var5 * var5);
/* 44 */     float var8 = (float)(Math.atan2(var5, var4) * 180.0D / Math.PI) - 90.0F;
/* 45 */     return new float[] { var8, (float)-(Math.atan2(var6, var7) * 180.0D / Math.PI) };
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Utils\AyaBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */