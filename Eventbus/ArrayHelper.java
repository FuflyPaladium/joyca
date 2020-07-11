/*     */ package me.lavache.BaseClient.Eventbus;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ArrayHelper<T>
/*     */   extends Object
/*     */   implements Iterable<T>
/*     */ {
/*     */   private T[] elements;
/*     */   
/*  16 */   public ArrayHelper(Object[] array) { this.elements = array; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  21 */   public ArrayHelper() { this.elements = new Object[0]; }
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(T t) {
/*  26 */     if (t != null) {
/*  27 */       Object[] array = new Object[size() + 1];
/*     */       
/*  29 */       for (int i = 0; i < array.length; i++) {
/*  30 */         if (i < size()) {
/*  31 */           array[i] = get(i);
/*     */         } else {
/*  33 */           array[i] = t;
/*     */         } 
/*     */       } 
/*     */       
/*  37 */       set(array);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(T t) {
/*     */     Object[] array;
/*  45 */     for (int lenght = array = array().length, i = 0; i < lenght; i++) {
/*  46 */       T entry = (T)array[i];
/*  47 */       if (entry.equals(t)) {
/*  48 */         return true;
/*     */       }
/*     */     } 
/*     */     
/*  52 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(T t) {
/*  57 */     if (contains(t)) {
/*  58 */       Object[] array = new Object[size() - 1];
/*  59 */       boolean b = true;
/*     */       
/*  61 */       for (int i = 0; i < size(); i++) {
/*  62 */         if (b && get(i).equals(t)) {
/*  63 */           b = false;
/*     */         } else {
/*  65 */           array[b ? i : (i - 1)] = get(i);
/*     */         } 
/*     */       } 
/*     */       
/*  69 */       set(array);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  75 */   public T[] array() { return (T[])this.elements; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  80 */   public int size() { return array().length; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  85 */   public void set(Object[] array) { this.elements = array; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  90 */   public T get(int index) { return (T)array()[index]; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  95 */   public void clear() { this.elements = new Object[0]; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 100 */   public boolean isEmpty() { return (size() == 0); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<T> iterator() {
/* 106 */     return new Iterator<T>()
/*     */       {
/* 108 */         private int index = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 113 */         public boolean hasNext() { return (this.index < ArrayHelper.this.size() && ArrayHelper.this.get(this.index) != null); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 119 */         public T next() { return (T)ArrayHelper.this.get(this.index++); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 125 */         public void remove() { ArrayHelper.this.remove(ArrayHelper.this.get(this.index)); }
/*     */       };
/*     */   }
/*     */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Eventbus\ArrayHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */