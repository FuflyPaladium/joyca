/*    */ package me.lavache.BaseClient.Module.Modules.impl.misc;
/*    */ 
/*    */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*    */ import me.lavache.BaseClient.Eventbus.Events.EventUpdate;
/*    */ import me.lavache.BaseClient.Module.Category;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ import me.lavache.BaseClient.Utils.MovementUtils;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Teleport
/*    */   extends Module
/*    */ {
/*    */   public MovingObjectPosition objectMouseOver;
/*    */   
/* 21 */   public Teleport() { super("Teleport", 0, Category.MISC); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @EventTarget
/*    */   public void onUpdate(EventUpdate e) {
/* 28 */     if (mc.gameSettings.keyBindSneak.isPressed()) {
/* 29 */       MovementUtils.Damage();
/* 30 */       mc.timer.timerSpeed = 0.2F;
/* 31 */       int x = (int)mc.thePlayer.posX;
/* 32 */       int y = (int)mc.thePlayer.posY;
/* 33 */       int z = (int)mc.thePlayer.posZ;
/*    */       
/* 35 */       findBlinkPath((x + 10), y, z);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/* 40 */   private static double curX = (Minecraft.getMinecraft()).thePlayer.posX;
/* 41 */   private static double curY = (Minecraft.getMinecraft()).thePlayer.posY;
/* 42 */   private static double curZ = (Minecraft.getMinecraft()).thePlayer.posZ;
/*    */ 
/*    */   
/*    */   public static String[] findBlinkPath(double tpX, double tpY, double tpZ) {
/* 46 */     String[] pos = new String[2];
/* 47 */     curX = (Minecraft.getMinecraft()).thePlayer.posX;
/* 48 */     curY = (Minecraft.getMinecraft()).thePlayer.posY;
/* 49 */     curZ = (Minecraft.getMinecraft()).thePlayer.posZ;
/* 50 */     double distance = Math.abs(curX - tpX) + Math.abs(curY - tpY) + Math.abs(curZ - tpZ);
/*    */     
/* 52 */     for (int count = 0; distance > 0.0D; count++) {
/* 53 */       distance = Math.abs(curX - tpX) + Math.abs(curY - tpY) + Math.abs(curZ - tpZ);
/*    */       
/* 55 */       double diffX = curX - tpX;
/* 56 */       double diffY = curY - tpY;
/* 57 */       double diffZ = curZ - tpZ;
/* 58 */       double offset = ((count & true) == 0) ? 0.4D : 0.1D;
/*    */       
/* 60 */       double minX = Math.min(Math.abs(diffX), offset);
/* 61 */       if (diffX < 0.0D) curX += minX; 
/* 62 */       if (diffX > 0.0D) curX -= minX;
/*    */       
/* 64 */       double minY = Math.min(Math.abs(diffY), 0.25D);
/* 65 */       if (diffY < 0.0D) curY += minY; 
/* 66 */       if (diffY > 0.0D) curY -= minY;
/*    */       
/* 68 */       double minZ = Math.min(Math.abs(diffZ), offset);
/* 69 */       if (diffZ < 0.0D) curZ += minZ; 
/* 70 */       if (diffZ > 0.0D) curZ -= minZ;
/*    */     
/*    */     } 
/* 73 */     pos[0] = Double.toString(curX);
/* 74 */     pos[1] = Double.toString(curY);
/* 75 */     pos[2] = Double.toString(curZ);
/* 76 */     return pos;
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\misc\Teleport.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */