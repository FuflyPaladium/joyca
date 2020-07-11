/*    */ package me.lavache.BaseClient.Module.Modules.impl.misc;
/*    */ 
/*    */ import de.Hero.settings.Setting;
/*    */ import java.util.ArrayList;
/*    */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*    */ import me.lavache.BaseClient.Eventbus.Events.EventPacket;
/*    */ import me.lavache.BaseClient.Eventbus.Events.EventUpdate;
/*    */ import me.lavache.BaseClient.Main;
/*    */ import me.lavache.BaseClient.Module.Category;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ import me.lavache.BaseClient.Utils.TimeHelper;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.play.client.C00PacketKeepAlive;
/*    */ import net.minecraft.network.play.client.C03PacketPlayer;
/*    */ import net.minecraft.network.play.server.S00PacketKeepAlive;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Disabler
/*    */   extends Module
/*    */ {
/*    */   private boolean erisium;
/*    */   private int lastAliveKey;
/*    */   private TimeHelper erisiumTimer;
/*    */   private TimeHelper sentinelTimer;
/*    */   
/* 33 */   public Disabler() { super("Disabler", 0, Category.MISC); }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setup() {
/* 38 */     ArrayList<String> options = new ArrayList<String>();
/* 39 */     options.add("Rinaorc");
/* 40 */     options.add("Erisium");
/* 41 */     options.add("Sentinel");
/* 42 */     Main.instance.setmgr.rSetting(new Setting("DISABLER_MODE", this, "Rinaorc", options));
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public void onUpdate(EventUpdate e) {
/* 47 */     if (Main.instance.setmgr.getSettingByName("DISABLER_MODE").getValString().equalsIgnoreCase("Rinaorc"))
/* 48 */       mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C05PacketPlayerLook(Float.MAX_VALUE, Float.MAX_VALUE, mc.thePlayer.onGround)); 
/* 49 */     if (Main.instance.setmgr.getSettingByName("DISABLER_MODE").getValString().equalsIgnoreCase("Erisium")) {
/* 50 */       if (mc.thePlayer.ticksExisted <= 1)
/* 51 */         this.erisium = false; 
/* 52 */       if (this.erisium && TimeHelper.delayOver(1500L)) {
/* 53 */         this.erisium = !this.erisium;
/* 54 */         mc.thePlayer.sendQueue.getNetworkManager().sendPacket(new C00PacketKeepAlive(this.lastAliveKey));
/*    */       } 
/*    */     } 
/* 57 */     if (Main.instance.setmgr.getSettingByName("DISABLER_MODE").getValString().equalsIgnoreCase("Sentinel")) {
/* 58 */       mc.getNetHandler().addToSendQueue(new C03PacketPlayer(true));
/* 59 */       mc.timer.timerSpeed = 0.1F;
/*    */     } 
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public void onPacket(EventPacket ep) {
/* 65 */     Packet p = ep.getPacket();
/* 66 */     if (Main.instance.setmgr.getSettingByName("DISABLER_MODE").getValString().equalsIgnoreCase("Erisium")) {
/* 67 */       if (p instanceof S00PacketKeepAlive) {
/* 68 */         S00PacketKeepAlive packet = (S00PacketKeepAlive)p;
/* 69 */         int KEY = packet.func_149134_c();
/* 70 */         TimeHelper.reset();
/* 71 */         this.erisium = true;
/* 72 */         this.lastAliveKey = KEY;
/*    */       } 
/* 74 */       if (p instanceof C00PacketKeepAlive)
/* 75 */         ep.setCancelled(true); 
/*    */     } 
/* 77 */     Main.instance.setmgr.getSettingByName("DISABLER_MODE").getValString().equalsIgnoreCase("Sentinel");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onEnable() {
/* 83 */     this.erisium = false;
/* 84 */     TimeHelper.reset();
/* 85 */     super.onEnable();
/*    */   }
/*    */ 
/*    */   
/*    */   public void onDisable() {
/* 90 */     mc.timer.timerSpeed = 1.0F;
/* 91 */     super.onDisable();
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\misc\Disabler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */