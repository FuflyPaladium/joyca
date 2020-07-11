/*    */ package me.lavache.BaseClient.Module.Modules.impl.misc;
/*    */ 
/*    */ import io.netty.util.internal.ThreadLocalRandom;
/*    */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*    */ import me.lavache.BaseClient.Eventbus.Events.EventUpdate;
/*    */ import me.lavache.BaseClient.Module.Category;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ 
/*    */ 
/*    */ public class AutoLoseMessage
/*    */   extends Module
/*    */ {
/* 13 */   public AutoLoseMessage() { super("AutoLoseMessage", 0, Category.MISC); }
/*    */ 
/*    */   
/*    */   @EventTarget
/*    */   public void onUpdate(EventUpdate e) {
/* 18 */     if (mc.thePlayer.isSpectator() && !msgSent) {
/* 19 */       int randomInt = ThreadLocalRandom.current().nextInt(0, 7);
/* 20 */       if (randomInt == 1) {
/* 21 */         mc.thePlayer.sendChatMessage("Please give me cock");
/* 22 */       } else if (randomInt == 2) {
/* 23 */         mc.thePlayer.sendChatMessage("Joyca Client Best Cubecraft Client");
/* 24 */       } else if (randomInt == 3) {
/* 25 */         mc.thePlayer.sendChatMessage("Tu peux la fermer mickael stp");
/* 26 */       } else if (randomInt == 4) {
/* 27 */         mc.thePlayer.sendChatMessage("Minray à la douche");
/* 28 */       } else if (randomInt == 5) {
/* 29 */         mc.thePlayer.sendChatMessage("oof");
/* 30 */       } else if (randomInt == 6) {
/* 31 */         mc.thePlayer.sendChatMessage("gg pd");
/* 32 */       } else if (randomInt == 7) {
/* 33 */         mc.thePlayer.sendChatMessage("Dah Omikron pd");
/*    */       } 
/* 35 */       msgSent = true;
/* 36 */     } else if (msgSent && 
/* 37 */       !mc.thePlayer.isSpectator()) {
/* 38 */       msgSent = false;
/*    */     } 
/*    */   }
/*    */   
/*    */   private static boolean msgSent = false;
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\misc\AutoLoseMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */