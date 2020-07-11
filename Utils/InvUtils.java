/*    */ package me.lavache.BaseClient.Utils;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.network.play.client.C09PacketHeldItemChange;
/*    */ 
/*    */ public class InvUtils
/*    */ {
/* 12 */   private static Minecraft mc = Minecraft.getMinecraft();
/*    */ 
/*    */ 
/*    */   
/*    */   public static int blockInHotbar;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 21 */   public static InventoryPlayer getInventory() { return mc.thePlayer.inventory; }
/*    */ 
/*    */ 
/*    */   
/* 25 */   public static ItemStack getItemInInventory(int slot) { return getInventory().getStackInSlot(slot); }
/*    */ 
/*    */   
/*    */   public static int getBlockInHotbar() {
/* 29 */     for (i = 36; i < 45; i++) {
/* 30 */       ItemStack item = mc.thePlayer.inventoryContainer.getSlot(i).getStack();
/*    */       
/* 32 */       if (item != null && item.getItem() instanceof ItemBlock) {
/* 33 */         ItemBlock block = (ItemBlock)item.getItem();
/* 34 */         Block fBlock = block.getBlock();
/*    */         
/* 36 */         if (fBlock.isFullCube() && fBlock.isFullBlock()) {
/* 37 */           return i;
/*    */         }
/*    */       } 
/*    */     } 
/* 41 */     return -1;
/*    */   }
/*    */ 
/*    */   
/* 45 */   public static void selectBlock(int slot) { mc.getNetHandler().addToSendQueue(new C09PacketHeldItemChange(slot - 36)); }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Utils\InvUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */