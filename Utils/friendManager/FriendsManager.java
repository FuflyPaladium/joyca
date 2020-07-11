/*    */ package me.lavache.BaseClient.Utils.friendManager;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ public class FriendsManager
/*    */ {
/*  8 */   private ArrayList<Friend> friends = new ArrayList();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 15 */   public void addFriend(String friend) { this.friends.add(new Friend(friend)); }
/*    */ 
/*    */   
/*    */   public boolean isFriend(String friend) {
/* 19 */     for (Friend f : getFriends()) {
/* 20 */       if (f.getFriendName() == friend)
/* 21 */         return true; 
/*    */     } 
/* 23 */     return false;
/*    */   }
/*    */ 
/*    */   
/* 27 */   public ArrayList<Friend> getFriends() { return this.friends; }
/*    */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Utils\friendManager\FriendsManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */