/*    */ package me.lavache.BaseClient.Module;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.BaseModule;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.combat.AutoArmor;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.combat.AutoBlock;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.combat.Criticals;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.combat.KillAura;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.combat.TpHit;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.combat.Velocity;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.misc.AutoClip;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.misc.AutoLoseMessage;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.misc.Crasher;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.misc.Disabler;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.misc.GetOutOfBox;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.movement.AirJump;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.movement.FastFall;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.movement.FastLadder;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.movement.Fly;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.movement.NoFall;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.movement.NoSlowDown;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.movement.Speed;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.movement.Spider;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.movement.Sprint;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.movement.Step;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.player.Blink;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.player.ChestStealer;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.player.FastEat;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.player.FastPlace;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.player.Tower;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.render.Chams;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.render.ClickGUI;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.render.Esp;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.render.FullBright;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.render.HUD;
/*    */ import me.lavache.BaseClient.Module.Modules.impl.render.NoHurtCam;
/*    */ 
/*    */ public class ModuleManager
/*    */ {
/*    */   public ModuleManager() {
/* 41 */     this.modules = new ArrayList();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 47 */     this.modules.add(new Velocity());
/* 48 */     this.modules.add(new KillAura());
/* 49 */     this.modules.add(new Criticals());
/* 50 */     this.modules.add(new AutoBlock());
/* 51 */     this.modules.add(new AutoArmor());
/* 52 */     this.modules.add(new TpHit());
/*    */     
/* 54 */     this.modules.add(new AirJump());
/* 55 */     this.modules.add(new Sprint());
/* 56 */     this.modules.add(new Speed());
/* 57 */     this.modules.add(new Fly());
/* 58 */     this.modules.add(new Step());
/* 59 */     this.modules.add(new NoFall());
/* 60 */     this.modules.add(new FastLadder());
/* 61 */     this.modules.add(new NoSlowDown());
/* 62 */     this.modules.add(new Spider());
/* 63 */     this.modules.add(new FastFall());
/*    */ 
/*    */     
/* 66 */     this.modules.add(new ChestStealer());
/* 67 */     this.modules.add(new Tower());
/* 68 */     this.modules.add(new FastPlace());
/* 69 */     this.modules.add(new FastEat());
/* 70 */     this.modules.add(new Blink());
/*    */ 
/*    */ 
/*    */     
/* 74 */     this.modules.add(new HUD());
/* 75 */     this.modules.add(new Esp());
/* 76 */     this.modules.add(new FullBright());
/* 77 */     this.modules.add(new Chams());
/* 78 */     this.modules.add(new NoHurtCam());
/*    */ 
/*    */     
/* 81 */     this.modules.add(new GetOutOfBox());
/* 82 */     this.modules.add(new AutoClip());
/* 83 */     this.modules.add(new AutoLoseMessage());
/* 84 */     this.modules.add(new Disabler());
/* 85 */     this.modules.add(new Crasher());
/*    */ 
/*    */ 
/*    */     
/* 89 */     this.modules.add(new ClickGUI());
/*    */ 
/*    */     
/* 92 */     this.modules.add(new BaseModule());
/*    */   }
/*    */   private ArrayList<Module> modules;
/*    */   
/* 96 */   public ArrayList<Module> getModules() { return this.modules; }
/*    */ 
/*    */   
/* 99 */   public Module getModuleByName(String name) { return (Module)this.modules.stream().filter(module -> module.getName().equalsIgnoreCase(paramString)).findFirst().orElse(null); }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Module\ModuleManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */