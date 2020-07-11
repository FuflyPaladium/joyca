/*     */ package me.lavache.BaseClient.Eventbus;
/*     */ 
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EventManager
/*     */ {
/*     */   public static void register(Object o) {
/*     */     byte b;
/*     */     int i;
/*     */     Method[] arrayOfMethod;
/*  19 */     for (i = arrayOfMethod = o.getClass().getDeclaredMethods().length, b = 0; b < i; ) { Method method = arrayOfMethod[b];
/*  20 */       if (!isMethodBad(method))
/*  21 */         register(method, o); 
/*     */       b++; }
/*     */   
/*     */   } public static void register(Object o, Class<? extends Event> clazz) {
/*     */     byte b;
/*     */     int i;
/*     */     Method[] arrayOfMethod;
/*  28 */     for (i = arrayOfMethod = o.getClass().getDeclaredMethods().length, b = 0; b < i; ) { Method method = arrayOfMethod[b];
/*  29 */       if (!isMethodBad(method, clazz)) {
/*  30 */         register(method, o);
/*     */       }
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   private static void register(Method method, Object o) {
/*  37 */     Class<?> clazz = method.getParameterTypes()[0];
/*  38 */     Data methodData = new Data(o, method, ((EventTarget)method.getAnnotation(EventTarget.class)).value());
/*     */     
/*  40 */     if (!methodData.target.isAccessible()) {
/*  41 */       methodData.target.setAccessible(true);
/*     */     }
/*     */     
/*  44 */     if (REGISTRY_MAP.containsKey(clazz)) {
/*  45 */       if (!((ArrayHelper)REGISTRY_MAP.get(clazz)).contains(methodData)) {
/*  46 */         ((ArrayHelper)REGISTRY_MAP.get(clazz)).add(methodData);
/*  47 */         sortListValue(clazz);
/*     */       } 
/*     */     } else {
/*  50 */       REGISTRY_MAP.put(clazz, new ArrayHelper<Data>(methodData)
/*     */           {
/*     */           
/*     */           });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void unregister(Object o) {
/*  61 */     for (ArrayHelper<Data> flexibalArray : REGISTRY_MAP.values()) {
/*  62 */       for (Data methodData : flexibalArray) {
/*  63 */         if (methodData.source.equals(o)) {
/*  64 */           flexibalArray.remove(methodData);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  69 */     cleanMap(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void unregister(Object o, Class<? extends Event> clazz) {
/*  74 */     if (REGISTRY_MAP.containsKey(clazz)) {
/*  75 */       for (Data methodData : (ArrayHelper)REGISTRY_MAP.get(clazz)) {
/*  76 */         if (methodData.source.equals(o)) {
/*  77 */           ((ArrayHelper)REGISTRY_MAP.get(clazz)).remove(methodData);
/*     */         }
/*     */       } 
/*     */       
/*  81 */       cleanMap(true);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void cleanMap(boolean b) {
/*  88 */     Iterator<Map.Entry<Class<? extends Event>, ArrayHelper<Data>>> iterator = REGISTRY_MAP.entrySet().iterator();
/*     */     
/*  90 */     while (iterator.hasNext()) {
/*  91 */       if (!b || ((ArrayHelper)((Map.Entry)iterator.next()).getValue()).isEmpty()) {
/*  92 */         iterator.remove();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void removeEnty(Class<? extends Event> clazz) {
/*  99 */     Iterator<Map.Entry<Class<? extends Event>, ArrayHelper<Data>>> iterator = REGISTRY_MAP.entrySet().iterator();
/*     */     
/* 101 */     while (iterator.hasNext()) {
/* 102 */       if (((Class)((Map.Entry)iterator.next()).getKey()).equals(clazz)) {
/* 103 */         iterator.remove();
/*     */         break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void sortListValue(Class<? extends Event> clazz) {
/* 111 */     ArrayHelper<Data> flexibleArray = new ArrayHelper<Data>(); byte b1; int i;
/*     */     byte[] arrayOfByte;
/* 113 */     for (i = arrayOfByte = Priority.VALUE_ARRAY.length, b1 = 0; b1 < i; ) { byte b = arrayOfByte[b1];
/* 114 */       for (Data methodData : (ArrayHelper)REGISTRY_MAP.get(clazz)) {
/* 115 */         if (methodData.priority == b) {
/* 116 */           flexibleArray.add(methodData);
/*     */         }
/*     */       } 
/*     */       b1++; }
/*     */     
/* 121 */     REGISTRY_MAP.put(clazz, flexibleArray);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 126 */   private static boolean isMethodBad(Method method) { return !(method.getParameterTypes().length == 1 && method.isAnnotationPresent(EventTarget.class)); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 131 */   private static boolean isMethodBad(Method method, Class<? extends Event> clazz) { return !(!isMethodBad(method) && !method.getParameterTypes()[0].equals(clazz)); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 136 */   public static ArrayHelper<Data> get(Class<? extends Event> clazz) { return (ArrayHelper)REGISTRY_MAP.get(clazz); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 141 */   public static void shutdown() { REGISTRY_MAP.clear(); }
/*     */ 
/*     */ 
/*     */   
/* 145 */   private static final Map<Class<? extends Event>, ArrayHelper<Data>> REGISTRY_MAP = new HashMap();
/*     */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Eventbus\EventManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */