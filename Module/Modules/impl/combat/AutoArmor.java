/*     */ package me.lavache.BaseClient.Module.Modules.impl.combat;
/*     */ 
/*     */ import de.Hero.settings.Setting;
/*     */ import java.util.ArrayList;
/*     */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*     */ import me.lavache.BaseClient.Eventbus.Events.EventUpdate;
/*     */ import me.lavache.BaseClient.Main;
/*     */ import me.lavache.BaseClient.Module.Category;
/*     */ import me.lavache.BaseClient.Module.Module;
/*     */ import me.lavache.BaseClient.Utils.TimeHelper;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AutoArmor
/*     */   extends Module
/*     */ {
/*  22 */   TimeHelper timer = new TimeHelper();
/*     */ 
/*     */   
/*  25 */   public AutoArmor() { super("AutoArmor", 0, Category.COMBAT); }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setup() {
/*  30 */     ArrayList<String> options = new ArrayList<String>();
/*  31 */     Main.instance.setmgr.rSetting(new Setting("AutoArmor Delay", this, 30.0D, 0.0D, 3000.0D, true));
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public void onUpdate(EventUpdate e) {
/*  36 */     if (mc.currentScreen instanceof net.minecraft.client.gui.inventory.GuiInventory)
/*  37 */       for (int type = 1; type < 5; type++) {
/*  38 */         if (TimeHelper.delayOver((int)Main.instance.setmgr.getSettingByName("AutoArmor Delay").getValDouble())) {
/*  39 */           if (mc.thePlayer.inventoryContainer.getSlot(4 + type).getHasStack()) {
/*  40 */             ItemStack stack = mc.thePlayer.inventoryContainer.getSlot(4 + type).getStack();
/*  41 */             if (isBestArmor(stack, type)) {
/*     */               continue;
/*     */             }
/*  44 */             mc.playerController.windowClick(mc.thePlayer.inventoryContainer.windowId, 4 + type, 1, 4, mc.thePlayer);
/*     */           } 
/*  46 */           for (int i = 9; i < 45; i++) {
/*  47 */             if (mc.thePlayer.inventoryContainer.getSlot(i).getHasStack()) {
/*  48 */               ItemStack stack2 = mc.thePlayer.inventoryContainer.getSlot(i).getStack();
/*  49 */               if (isBestArmor(stack2, type) && getProtection(stack2) > 0.0F) {
/*  50 */                 mc.playerController.windowClick(mc.thePlayer.inventoryContainer.windowId, i, 0, 1, mc.thePlayer);
/*     */               }
/*     */             } 
/*     */           } 
/*  54 */           TimeHelper.reset();
/*     */         } 
/*     */         continue;
/*     */       }  
/*     */   }
/*     */   
/*     */   public boolean isBestArmor(ItemStack stack, int type) {
/*  61 */     String typeName = "";
/*  62 */     float protection = getProtection(stack);
/*  63 */     if (type == 1) {
/*  64 */       typeName = "Helmet";
/*     */     }
/*  66 */     else if (type == 2) {
/*  67 */       typeName = "Chestplate";
/*     */     }
/*  69 */     else if (type == 3) {
/*  70 */       typeName = "Leggings";
/*     */     }
/*  72 */     else if (type == 4) {
/*  73 */       typeName = "Boots";
/*     */     } 
/*  75 */     if (!stack.getDisplayName().contains(typeName)) {
/*  76 */       return false;
/*     */     }
/*  78 */     for (int i = 5; i < 45; i++) {
/*  79 */       if (mc.thePlayer.inventoryContainer.getSlot(i).getHasStack()) {
/*  80 */         ItemStack playerStack = mc.thePlayer.inventoryContainer.getSlot(i).getStack();
/*  81 */         if (getProtection(playerStack) > protection && playerStack.getDisplayName().contains(typeName)) {
/*  82 */           return false;
/*     */         }
/*     */       } 
/*     */     } 
/*  86 */     return true;
/*     */   }
/*     */   
/*     */   public float getProtection(ItemStack stack) {
/*  90 */     float prot = 0.0F;
/*  91 */     if (stack.getItem() instanceof ItemArmor) {
/*  92 */       ItemArmor armor = (ItemArmor)stack.getItem();
/*  93 */       prot = (float)(prot + armor.damageReduceAmount + ((100 - armor.damageReduceAmount) * EnchantmentHelper.getEnchantmentLevel(Enchantment.protection.effectId, stack)) * 0.0075D);
/*  94 */       prot = (float)(prot + EnchantmentHelper.getEnchantmentLevel(Enchantment.blastProtection.effectId, stack) / 100.0D);
/*  95 */       prot = (float)(prot + EnchantmentHelper.getEnchantmentLevel(Enchantment.fireProtection.effectId, stack) / 100.0D);
/*  96 */       prot = (float)(prot + EnchantmentHelper.getEnchantmentLevel(Enchantment.thorns.effectId, stack) / 100.0D);
/*  97 */       prot = (float)(prot + EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, stack) / 50.0D);
/*  98 */       prot = (float)(prot + EnchantmentHelper.getEnchantmentLevel(Enchantment.projectileProtection.effectId, stack) / 100.0D);
/*     */     } 
/* 100 */     return prot;
/*     */   }
/*     */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\combat\AutoArmor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */