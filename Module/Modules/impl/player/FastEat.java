/*    */ package me.lavache.BaseClient.Module.Modules.impl.player;
/*    */ 
/*    */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*    */ import me.lavache.BaseClient.Eventbus.Events.EventUpdate;
/*    */ import me.lavache.BaseClient.Main;
/*    */ import me.lavache.BaseClient.Module.Category;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ import me.lavache.BaseClient.Utils.InvUtils;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FastEat
/*    */   extends Module
/*    */ {
/* 16 */   public FastEat() { super("FastEat", 0, Category.PLAYER); }
/*    */   
/*    */   @EventTarget
/*    */   public void onUpdate(EventUpdate e) {
/* 20 */     int inUseItem = mc.thePlayer.inventory.currentItem;
/* 21 */     Item inUseItemStack = InvUtils.getItemInInventory(inUseItem).getItem();
/*    */     
/* 23 */     if (inUseItemStack instanceof net.minecraft.item.ItemFood && mc.thePlayer.isEating()) {
/* 24 */       mc.timer.timerSpeed = 2.0F;
/*    */     }
/* 26 */     else if (!Main.instance.moduleManager.getModuleByName("Speed").isToggled() || !Main.instance.moduleManager.getModuleByName("Fly").isToggled()) {
/* 27 */       mc.timer.timerSpeed = 1.0F;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void onDisable() {
/* 32 */     super.onDisable();
/* 33 */     mc.timer.timerSpeed = 1.0F;
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\player\FastEat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */