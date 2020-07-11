/*    */ package me.lavache.BaseClient.Module.Modules.impl.movement;
/*    */ 
/*    */ import de.Hero.settings.Setting;
/*    */ import java.util.ArrayList;
/*    */ import me.lavache.BaseClient.Eventbus.EventTarget;
/*    */ import me.lavache.BaseClient.Eventbus.Events.EventUpdate;
/*    */ import me.lavache.BaseClient.Main;
/*    */ import me.lavache.BaseClient.Module.Category;
/*    */ import me.lavache.BaseClient.Module.Module;
/*    */ import me.lavache.BaseClient.Utils.MovementUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HighJump
/*    */   extends Module
/*    */ {
/* 20 */   public HighJump() { super("HighJump", 0, Category.MOVEMENT); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setup() {
/* 26 */     ArrayList<String> options = new ArrayList<String>();
/* 27 */     options.add("CubeHighJump");
/* 28 */     Main.instance.setmgr.rSetting(new Setting("HIGHJUMP_MODE", this, "Vanilla", options));
/*    */   }
/*    */ 
/*    */   
/*    */   public void onEnable() {
/* 33 */     super.onEnable();
/* 34 */     MovementUtils.vClip(3.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   @EventTarget
/*    */   public void onUpdate(EventUpdate e) {}
/*    */ 
/*    */   
/*    */   public void onDisable() {
/* 43 */     super.onDisable();
/* 44 */     mc.timer.timerSpeed = 1.0F;
/*    */   }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\Modules\impl\movement\HighJump.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */