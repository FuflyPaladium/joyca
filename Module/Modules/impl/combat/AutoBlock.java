/*    */ package me.lavache.BaseClient.Module.Modules.impl.combat;
/*    */ 
/*    */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*    */ import me.lavache.BaseClient.Eventbus.Events.EventUpdate;
/*    */ import me.lavache.BaseClient.Module.Category;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AutoBlock
/*    */   extends Module
/*    */ {
/* 14 */   public AutoBlock() { super("AutoBlock", 0, Category.COMBAT); }
/*    */ 
/*    */   
/*    */   @EventTarget
/*    */   public void onUpdate(EventUpdate e) {
/* 19 */     if (mc.gameSettings.keyBindAttack.isKeyDown() && mc.thePlayer.getCurrentEquippedItem().getItem() instanceof net.minecraft.item.ItemSword) {
/* 20 */       ItemStack sword = mc.thePlayer.getCurrentEquippedItem();
/* 21 */       sword.useItemRightClick(mc.theWorld, mc.thePlayer);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\combat\AutoBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */