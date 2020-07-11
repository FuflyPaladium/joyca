/*    */ package me.lavache.BaseClient.Module.Modules.impl.render;
/*    */ 
/*    */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*    */ import me.lavache.BaseClient.Eventbus.Events.Event2D;
/*    */ import me.lavache.BaseClient.Module.Category;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.combat.KillAura;
/*    */ import me.lavache.BaseClient.Utils.font.GlyphPageFontRenderer;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.gui.ScaledResolution;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AuraInfo
/*    */   extends Module
/*    */ {
/*    */   private static final float a = 0.0F;
/*    */   private static final float z = 20.0F;
/* 20 */   GlyphPageFontRenderer pseudo = GlyphPageFontRenderer.create("Arial", 40, false, false, false);
/*    */ 
/*    */   
/* 23 */   public AuraInfo() { super("AuraInfo", 0, Category.RENDER); }
/*    */ 
/*    */ 
/*    */   
/*    */   @EventTarget
/*    */   public void onRender2d(Event2D e) {
/* 29 */     ScaledResolution pd = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
/*    */     
/* 31 */     Gui.drawRect(60.0D, (pd.getScaledHeight() - 50), (pd.getScaledWidth() - 600), (pd.getScaledHeight() - 170), -1289674720);
/*    */   }
/*    */ 
/*    */   
/* 35 */   private static EntityPlayer getHittingPlayer() { return KillAura.currentHittingFuck; }
/*    */ 
/*    */ 
/*    */   
/* 39 */   private static String getPseudo() { return getHittingPlayer().getName(); }
/*    */ 
/*    */ 
/*    */   
/* 43 */   private static float getHealth() { return getHittingPlayer().getHealth(); }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\render\AuraInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */