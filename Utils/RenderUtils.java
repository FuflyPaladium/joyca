/*    */ package me.lavache.BaseClient.Utils;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.renderer.OpenGlHelper;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RenderUtils
/*    */ {
/*    */   public static void drawImage(ResourceLocation image, int x, int y, int width, int height) {
/* 16 */     OpenGlHelper.glBlendFunc(770, 771, 1, 0);
/* 17 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 18 */     Minecraft.getMinecraft().getTextureManager().bindTexture(image);
/* 19 */     Gui.drawModalRectWithCustomSizedTexture(x, y, 0.0F, 0.0F, width, height, width, height);
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Utils\RenderUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */