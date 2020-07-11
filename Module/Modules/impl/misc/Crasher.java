/*    */ package me.lavache.BaseClient.Module.Modules.impl.misc;
/*    */ 
/*    */ import de.Hero.settings.Setting;
/*    */ import java.util.ArrayList;
/*    */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*    */ import me.lavache.BaseClient.Eventbus.Events.EventUpdate;
/*    */ import me.lavache.BaseClient.Main;
/*    */ import me.lavache.BaseClient.Module.Category;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ import me.lavache.BaseClient.Utils.TimeHelper;
/*    */ import net.minecraft.network.play.client.C03PacketPlayer;
/*    */ 
/*    */ 
/*    */ public class Crasher
/*    */   extends Module
/*    */ {
/*    */   private TimeHelper ccCrasher;
/*    */   
/*    */   public Crasher() {
/* 20 */     super("Crasher", 0, Category.MISC);
/*    */ 
/*    */     
/* 23 */     this.ccCrasher = new TimeHelper();
/*    */   }
/*    */   
/*    */   public void setup() {
/* 27 */     ArrayList<String> options = new ArrayList<String>();
/* 28 */     options.add("Cubecraft");
/* 29 */     Main.instance.setmgr.rSetting(new Setting("CRASHER_MODE", this, "Cubecraft", options));
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public void onUpdate(EventUpdate e) {
/* 34 */     if (Main.instance.setmgr.getSettingByName("CRASHER_MODE").getValString().equalsIgnoreCase("Cubecraft")) {
/* 35 */       double x = mc.thePlayer.posX;
/* 36 */       double y = mc.thePlayer.posY;
/* 37 */       double z = mc.thePlayer.posZ;
/*    */       
/* 39 */       if (TimeHelper.delayOver(100L)) {
/* 40 */         for (int i = 0; i < 3000; i++) {
/* 41 */           mc.getNetHandler().addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(x, y + 0.09999999999999D, z, false));
/* 42 */           mc.getNetHandler().addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(x, y, z, true));
/*    */         } 
/* 44 */         mc.thePlayer.motionY = 0.0D;
/* 45 */         TimeHelper.reset();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\misc\Crasher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */