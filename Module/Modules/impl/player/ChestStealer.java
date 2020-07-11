/*    */ package me.lavache.BaseClient.Module.Modules.impl.player;
/*    */ 
/*    */ import de.Hero.settings.Setting;
/*    */ import java.util.ArrayList;
/*    */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*    */ import me.lavache.BaseClient.Eventbus.Events.EventUpdate;
/*    */ import me.lavache.BaseClient.Main;
/*    */ import me.lavache.BaseClient.Module.Category;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ import me.lavache.BaseClient.Utils.TimeHelper;
/*    */ import net.minecraft.inventory.ContainerChest;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChestStealer
/*    */   extends Module
/*    */ {
/* 20 */   TimeHelper timer = new TimeHelper();
/* 21 */   int i = 0;
/*    */ 
/*    */ 
/*    */   
/* 25 */   public ChestStealer() { super("ChestStealer", 47, Category.PLAYER); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setup() {
/* 31 */     ArrayList<String> options = new ArrayList<String>();
/* 32 */     Main.instance.setmgr.rSetting(new Setting("ChestStealer Delay", this, 30.0D, 0.0D, 3000.0D, true));
/*    */   }
/*    */   @EventTarget
/*    */   public void onUpdate(EventUpdate e) {
/* 36 */     if (mc.currentScreen instanceof net.minecraft.client.gui.inventory.GuiChest) {
/* 37 */       ContainerChest chest = (ContainerChest)mc.thePlayer.openContainer;
/* 38 */       if (isChestEmpty(chest) || isInventoryFull())
/* 39 */         mc.thePlayer.closeScreen(); 
/* 40 */       mc.timer.timerSpeed = 0.7F;
/* 41 */       for (int index = 0; index < chest.getLowerChestInventory().getSizeInventory(); index++) {
/* 42 */         ItemStack stack = chest.getLowerChestInventory().getStackInSlot(index);
/* 43 */         if (stack != null && TimeHelper.delayOver((int)Main.instance.setmgr.getSettingByName("ChestStealer Delay").getValDouble())) {
/* 44 */           mc.playerController.windowClick(chest.windowId, index, 0, 1, mc.thePlayer);
/* 45 */           TimeHelper.reset();
/*    */         } 
/*    */       } 
/* 48 */       mc.timer.timerSpeed = 1.0F;
/*    */     } 
/*    */   }
/*    */   
/*    */   private boolean isChestEmpty(ContainerChest chest) {
/* 53 */     for (int index = 0; index <= chest.getLowerChestInventory().getSizeInventory(); index++) {
/* 54 */       ItemStack stack = chest.getLowerChestInventory().getStackInSlot(index);
/* 55 */       if (stack != null) {
/* 56 */         return false;
/*    */       }
/*    */     } 
/* 59 */     return true;
/*    */   }
/*    */   
/*    */   public boolean isInventoryFull() {
/* 63 */     for (int index = 9; index <= 44; index++) {
/* 64 */       ItemStack stack = mc.thePlayer.inventoryContainer.getSlot(index).getStack();
/* 65 */       if (stack == null) {
/* 66 */         return false;
/*    */       }
/*    */     } 
/* 69 */     return true;
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\player\ChestStealer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */