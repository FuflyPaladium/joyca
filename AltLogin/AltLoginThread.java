/*    */ package me.lavache.BaseClient.AltLogin;
/*    */ 
/*    */ import com.mojang.authlib.Agent;
/*    */ import com.mojang.authlib.exceptions.AuthenticationException;
/*    */ import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
/*    */ import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
/*    */ import java.net.Proxy;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.util.EnumChatFormatting;
/*    */ import net.minecraft.util.Session;
/*    */ 
/*    */ 
/*    */ public final class AltLoginThread
/*    */   extends Thread
/*    */ {
/*    */   private final String password;
/*    */   private String status;
/*    */   private final String username;
/* 19 */   private Minecraft mc = Minecraft.getMinecraft();
/*    */   
/*    */   public AltLoginThread(String username, String password) {
/* 22 */     super("Alt Login Thread");
/* 23 */     this.username = username;
/* 24 */     this.password = password;
/* 25 */     this.status = EnumChatFormatting.GRAY + "Waiting...";
/*    */   }
/*    */   
/*    */   private Session createSession(String username, String password) {
/* 29 */     YggdrasilAuthenticationService service = new YggdrasilAuthenticationService(Proxy.NO_PROXY, "");
/* 30 */     YggdrasilUserAuthentication auth = (YggdrasilUserAuthentication)service.createUserAuthentication(Agent.MINECRAFT);
/* 31 */     auth.setUsername(username);
/* 32 */     auth.setPassword(password);
/*    */     try {
/* 34 */       auth.logIn();
/* 35 */       return new Session(auth.getSelectedProfile().getName(), auth.getSelectedProfile().getId().toString(), auth.getAuthenticatedToken(), "mojang");
/*    */     }
/* 37 */     catch (AuthenticationException localAuthenticationException) {
/* 38 */       localAuthenticationException.printStackTrace();
/* 39 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/* 44 */   public String getStatus() { return this.status; }
/*    */ 
/*    */ 
/*    */   
/*    */   public void run() {
/* 49 */     if (this.password.equals("")) {
/* 50 */       this.mc.session = new Session(this.username, "", "", "mojang");
/* 51 */       this.status = EnumChatFormatting.GREEN + "Logged in. (" + this.username + " - offline name)";
/*    */       return;
/*    */     } 
/* 54 */     this.status = EnumChatFormatting.YELLOW + "Logging in...";
/* 55 */     Session auth = createSession(this.username, this.password);
/* 56 */     if (auth == null) {
/* 57 */       this.status = EnumChatFormatting.RED + "Login failed!";
/*    */     } else {
/*    */       
/* 60 */       this.status = EnumChatFormatting.GREEN + "Logged in. (" + auth.getUsername() + ")";
/* 61 */       this.mc.session = auth;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/* 66 */   public void setStatus(String status) { this.status = status; }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\AltLogin\AltLoginThread.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */