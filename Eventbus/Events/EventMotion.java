/*     */ package me.lavache.BaseClient.Eventbus.Events;
/*     */ 
/*     */ import me.lavache.BaseClient.Eventbus.Event;
/*     */ 
/*     */ public class EventMotion extends Event {
/*     */   private State type;
/*     */   public double x;
/*     */   public double y;
/*     */   public double z;
/*     */   private float yaw;
/*     */   public float pitch;
/*     */   private boolean ground;
/*     */   private boolean sprint;
/*     */   private boolean sneak;
/*     */   private boolean cancelled;
/*     */   
/*     */   public EventMotion(State type, double x, double y, double z, float yaw, float pitch, boolean ground, boolean sprint, boolean sneak) {
/*  18 */     this.type = type;
/*  19 */     this.x = x;
/*  20 */     this.y = y;
/*  21 */     this.z = z;
/*  22 */     this.yaw = yaw;
/*  23 */     this.pitch = pitch;
/*  24 */     this.ground = ground;
/*  25 */     this.sprint = sprint;
/*  26 */     this.sneak = sneak;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  31 */   public double getX() { return this.x; }
/*     */ 
/*     */ 
/*     */   
/*  35 */   public void setX(double x) { this.x = x; }
/*     */ 
/*     */ 
/*     */   
/*  39 */   public double getY() { return this.y; }
/*     */ 
/*     */ 
/*     */   
/*  43 */   public void setY(double y) { this.y = y; }
/*     */ 
/*     */ 
/*     */   
/*  47 */   public double getZ() { return this.z; }
/*     */ 
/*     */ 
/*     */   
/*  51 */   public void setZ(double z) { this.z = z; }
/*     */ 
/*     */ 
/*     */   
/*  55 */   public float getYaw() { return this.yaw; }
/*     */ 
/*     */ 
/*     */   
/*  59 */   public void setYaw(float yaw) { this.yaw = yaw; }
/*     */ 
/*     */ 
/*     */   
/*  63 */   public float getPitch() { return this.pitch; }
/*     */ 
/*     */ 
/*     */   
/*  67 */   public void setPitch(float pitch) { this.pitch = pitch; }
/*     */ 
/*     */ 
/*     */   
/*  71 */   public boolean isGround() { return this.ground; }
/*     */ 
/*     */ 
/*     */   
/*  75 */   public void setGround(boolean ground) { this.ground = ground; }
/*     */ 
/*     */ 
/*     */   
/*  79 */   public boolean isSprint() { return this.sprint; }
/*     */ 
/*     */ 
/*     */   
/*  83 */   public void setSprint(boolean sprint) { this.sprint = sprint; }
/*     */ 
/*     */ 
/*     */   
/*  87 */   public boolean isSneak() { return this.sneak; }
/*     */ 
/*     */ 
/*     */   
/*  91 */   public void setSneak(boolean sneak) { this.sneak = sneak; }
/*     */ 
/*     */ 
/*     */   
/*  95 */   public State getState() { return this.type; }
/*     */ 
/*     */ 
/*     */   
/*  99 */   public void setState(State type) { this.type = type; }
/*     */   
/*     */   public enum State
/*     */   {
/* 103 */     PRE, POST;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 108 */   public boolean isCancelled() { return this.cancelled; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 113 */   public void setCancelled(boolean cancelled) { this.cancelled = cancelled; }
/*     */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Eventbus\Events\EventMotion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */