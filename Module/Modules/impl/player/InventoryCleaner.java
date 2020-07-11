/*    */ package me.lavache.BaseClient.Module.Modules.impl.player;
/*    */ 
/*    */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*    */ import me.lavache.BaseClient.Eventbus.Events.EventUpdate;
/*    */ import me.lavache.BaseClient.Module.Category;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InventoryCleaner
/*    */   extends Module
/*    */ {
/* 19 */   public InventoryCleaner() { super("InventoryCleaner", 0, Category.PLAYER); }
/*    */ 
/*    */ 
/*    */   
/*    */   @EventTarget
/* 24 */   public void onUpdate(EventUpdate e) { mc.currentScreen instanceof net.minecraft.client.gui.inventory.GuiInventory; }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\player\InventoryCleaner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */