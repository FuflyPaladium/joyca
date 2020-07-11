/*    */ package me.lavache.BaseClient.Module.Modules.impl.combat;
/*    */ 
/*    */ import de.Hero.settings.Setting;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*    */ import me.lavache.BaseClient.Eventbus.Events.EventUpdate;
/*    */ import me.lavache.BaseClient.Main;
/*    */ import me.lavache.BaseClient.Module.Category;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.network.play.client.C02PacketUseEntity;
/*    */ import net.minecraft.network.play.client.C03PacketPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class KillAura
/*    */   extends Module
/*    */ {
/*    */   private static Entity e1;
/*    */   
/* 26 */   public KillAura() { super("KillAura", 19, Category.COMBAT); }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setup() {
/* 31 */     ArrayList<String> options = new ArrayList<String>();
/* 32 */     Main.instance.setmgr.rSetting(new Setting("KillAura Reach", this, 5.0D, 0.0D, 6.0D, true));
/* 33 */     Main.instance.setmgr.rSetting(new Setting("Delay", this, 1.0D, 1.0D, 20.0D, true));
/*    */   }
/*    */ 
/*    */   
/* 37 */   public static EntityPlayer currentHittingFuck = (EntityPlayer)e1;
/*    */   public static boolean autoblock;
/*    */   public static boolean isBlocking;
/*    */   int delay;
/*    */   int critDelay;
/*    */   
/*    */   @EventTarget
/* 44 */   public void onUpdate(EventUpdate e) { killAura(); }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void killAura() {
/* 51 */     List players = mc.theWorld.playerEntities;
/* 52 */     this.delay++;
/*    */     
/* 54 */     for (int i = 0; i < players.size(); i++) {
/* 55 */       if (players.get(i).getClass().getName() != mc.thePlayer.getName()) {
/*    */ 
/*    */         
/* 58 */         EntityPlayer entityPlayer = (EntityPlayer)players.get(i);
/*    */         
/* 60 */         if (mc.thePlayer.getDistanceToEntity(entityPlayer) > mc.thePlayer.getDistanceToEntity((Entity)players.get(i))) {
/* 61 */           entityPlayer = (EntityPlayer)players.get(i);
/*    */         }
/* 63 */         float distance = mc.thePlayer.getDistanceToEntity(entityPlayer);
/*    */         
/* 65 */         if (Main.instance.moduleManager.getModuleByName("Criticals").isToggled()) {
/* 66 */           if (distance < Main.instance.setmgr.getSettingByName("KillAura Reach").getValDouble() && mc.thePlayer.canEntityBeSeen(entityPlayer) && this.delay > (int)Main.instance.setmgr.getSettingByName("Delay").getValDouble() && entityPlayer != mc.thePlayer && !mc.thePlayer.isInWater() && !mc.thePlayer.isUsingItem() && mc.thePlayer.isCollidedVertically) {
/* 67 */             e1 = entityPlayer;
/* 68 */             this.delay = 0;
/* 69 */             this.critDelay++;
/* 70 */             mc.thePlayer.isCollidedVertically = false;
/* 71 */             mc.thePlayer.setPosition((Minecraft.getMinecraft()).thePlayer.posX, (Minecraft.getMinecraft()).thePlayer.posY + 0.05D + randomNumber(7.4785718E-5D, 0.04057186891118D), (Minecraft.getMinecraft()).thePlayer.posZ);
/* 72 */             (Minecraft.getMinecraft()).thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition((Minecraft.getMinecraft()).thePlayer.posX, (Minecraft.getMinecraft()).thePlayer.posY, (Minecraft.getMinecraft()).thePlayer.posZ, false));
/* 73 */             (Minecraft.getMinecraft()).thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition((Minecraft.getMinecraft()).thePlayer.posX, (Minecraft.getMinecraft()).thePlayer.posY, (Minecraft.getMinecraft()).thePlayer.posZ, false));
/* 74 */             (Minecraft.getMinecraft()).thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition((Minecraft.getMinecraft()).thePlayer.posX, (Minecraft.getMinecraft()).thePlayer.posY + 2.0E-14D + randomNumber(1.0E-16D, 2.0E-15D), (Minecraft.getMinecraft()).thePlayer.posZ, false));
/* 75 */             (Minecraft.getMinecraft()).thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition((Minecraft.getMinecraft()).thePlayer.posX, (Minecraft.getMinecraft()).thePlayer.posY, (Minecraft.getMinecraft()).thePlayer.posZ, false));
/* 76 */             mc.thePlayer.swingItem();
/* 77 */             mc.thePlayer.sendQueue.addToSendQueue(new C02PacketUseEntity(entityPlayer, C02PacketUseEntity.Action.ATTACK));
/*    */           }
/*    */         
/*    */         }
/* 81 */         else if (distance < Main.instance.setmgr.getSettingByName("KillAura Reach").getValDouble() && mc.thePlayer.canEntityBeSeen(entityPlayer) && this.delay > (int)Main.instance.setmgr.getSettingByName("Delay").getValDouble() && entityPlayer != mc.thePlayer && !mc.thePlayer.isInWater() && !mc.thePlayer.isUsingItem() && mc.thePlayer.isCollidedVertically) {
/* 82 */           e1 = entityPlayer;
/* 83 */           this.delay = 0;
/* 84 */           this.critDelay++;
/* 85 */           mc.thePlayer.swingItem();
/* 86 */           mc.thePlayer.sendQueue.addToSendQueue(new C02PacketUseEntity(entityPlayer, C02PacketUseEntity.Action.ATTACK));
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 94 */   private static double randomNumber(double max, double min) { return Math.random() * (max - min) + min; }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\combat\KillAura.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */