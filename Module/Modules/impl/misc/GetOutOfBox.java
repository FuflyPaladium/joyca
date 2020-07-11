/*    */ package me.lavache.BaseClient.Module.Modules.impl.misc;
/*    */ 
/*    */ import me.lavache.BaseClient.Module.Category;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ import me.lavache.BaseClient.Utils.MovementUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GetOutOfBox
/*    */   extends Module
/*    */ {
/* 15 */   public GetOutOfBox() { super("GetOutOfBox", 0, Category.MISC); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void onEnable() {
/* 21 */     MovementUtils.vClip(-4.0D);
/* 22 */     toggle();
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\misc\GetOutOfBox.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */