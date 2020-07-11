/*     */ package me.lavache.BaseClient.Utils;
/*     */ 
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.util.Vec3i;
/*     */ 
/*     */ 
/*     */ public class MathHelper
/*     */ {
/*  10 */   public static final float SQRT_2 = sqrt(2.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  15 */   private static final float[] SIN_TABLE = new float[65536];
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int[] multiplyDeBruijnBitPosition;
/*     */ 
/*     */ 
/*     */   
/*     */   private static final double field_181163_d;
/*     */ 
/*     */ 
/*     */   
/*     */   private static final double[] field_181164_e;
/*     */ 
/*     */   
/*     */   private static final double[] field_181165_f;
/*     */ 
/*     */ 
/*     */   
/*  34 */   public static float sin(float f) { return SIN_TABLE[(int)(f * 10430.378F) & 0xFFFF]; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  42 */   public static float cos(float value) { return SIN_TABLE[(int)(value * 10430.378F + 16384.0F) & 0xFFFF]; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  47 */   public static float sqrt(float value) { return (float)Math.sqrt(value); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  52 */   public static float sqrt(double value) { return (float)Math.sqrt(value); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int floor(float value) {
/*  60 */     int i = (int)value;
/*  61 */     return (value < i) ? (i - 1) : i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  69 */   public static int truncateDoubleToInt(double value) { return (int)value - 1024; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int floor(double value) {
/*  77 */     int i = (int)value;
/*  78 */     return (value < i) ? (i - 1) : i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long floor_long(double value) {
/*  86 */     long i = (long)value;
/*  87 */     return (value < i) ? (i - 1L) : i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  92 */   public static int func_154353_e(double value) { return (int)((value >= 0.0D) ? value : (-value + 1.0D)); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  97 */   public static float abs(float value) { return (value >= 0.0F) ? value : -value; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 105 */   public static int abs_int(int value) { return (value >= 0) ? value : -value; }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ceiling_float_int(float value) {
/* 110 */     int i = (int)value;
/* 111 */     return (value > i) ? (i + 1) : i;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int ceiling_double_int(double d) {
/* 116 */     int i = (int)d;
/* 117 */     return (d > i) ? (i + 1) : i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 126 */   public static int clamp(int i, int min, int max) { return (i < min) ? min : ((i > max) ? max : i); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 135 */   public static float clamp(float f, float min, float max) { return (f < min) ? min : ((f > max) ? max : f); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 140 */   public static double clamp(double d, double min, double max) { return (d < min) ? min : ((d > max) ? max : d); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 145 */   public static double denormalizeClamp(double d, double e, double f) { return (f < 0.0D) ? d : ((f > 1.0D) ? e : (d + (e - d) * f)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double abs_max(double d, double e) {
/* 153 */     d = (d < 0.0D) ? -d : d;
/*     */     
/* 155 */     e = (e < 0.0D) ? -e : e;
/*     */     
/* 157 */     return (d > e) ? d : e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 165 */   public static int bucketInt(int i, int j) { return (i < 0) ? (-((-i - 1) / j) - 1) : (i / j); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 170 */   public static int getRandomIntegerInRange(Random r, int i, int j) { return (i >= j) ? i : (r.nextInt(j - i + 1) + i); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 175 */   public static float randomFloatClamp(Random r, float f, float g) { return (f >= g) ? f : (r.nextFloat() * (g - f) + f); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 180 */   public static double getRandomDoubleInRange(Random r, double d, double e) { return (d >= e) ? d : (r.nextDouble() * (e - d) + d); }
/*     */ 
/*     */ 
/*     */   
/*     */   public static double average(long[] values) {
/* 185 */     long i = 0L; byte b; int k;
/*     */     long[] arrayOfLong;
/* 187 */     for (k = arrayOfLong = values.length, b = 0; b < k; ) { long j = arrayOfLong[b];
/*     */       
/* 189 */       i += j;
/*     */       b++; }
/*     */     
/* 192 */     return i / values.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 197 */   public static boolean epsilonEquals(float first, float second) { return (abs(second - first) < 1.0E-5F); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 202 */   public static int normalizeAngle(int i, int j) { return (i % j + j) % j; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float wrapAngleTo180_float(float angle) {
/* 210 */     angle %= 360.0F;
/*     */     
/* 212 */     return (angle >= 180.0F) ? (angle - 360.0F) : ((angle < -180.0F) ? (angle + 360.0F) : angle);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double wrapAngleTo180_double(double angle) {
/* 220 */     angle %= 360.0D;
/*     */     
/* 222 */     return (angle >= 180.0D) ? (angle - 360.0D) : ((angle < -180.0D) ? (angle + 360.0D) : angle);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int parseIntWithDefault(String stri, int def_val) {
/*     */     try {
/* 232 */       return Integer.parseInt(stri);
/*     */     }
/* 234 */     catch (Throwable t) {
/*     */       
/* 236 */       return def_val;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 245 */   public static int parseIntWithDefaultAndMax(String stringInt, int defaultValue, int maxComparer) { return Math.max(maxComparer, parseIntWithDefault(stringInt, defaultValue)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double parseDoubleWithDefault(String stringInt, double defaultValue) {
/*     */     try {
/* 255 */       return Double.parseDouble(stringInt);
/*     */     }
/* 257 */     catch (Throwable var4) {
/*     */       
/* 259 */       return defaultValue;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 265 */   public static double parseDoubleWithDefaultAndMax(String stringInt, double defaultValue, double p_82713_3_) { return Math.max(p_82713_3_, parseDoubleWithDefault(stringInt, defaultValue)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int roundUpToPowerOfTwo(int value) {
/* 273 */     int i = value - 1;
/* 274 */     i |= i >> 1;
/* 275 */     i |= i >> 2;
/* 276 */     i |= i >> 4;
/* 277 */     i |= i >> 8;
/* 278 */     i |= i >> 16;
/* 279 */     return i + 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 287 */   private static boolean isPowerOfTwo(int value) { return (value != 0 && (value & value - 1) == 0); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int calculateLogBaseTwoDeBruijn(int value) {
/* 297 */     value = isPowerOfTwo(value) ? value : roundUpToPowerOfTwo(value);
/* 298 */     return multiplyDeBruijnBitPosition[(int)(value * 125613361L >> 27) & 0x1F];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 307 */   public static int calculateLogBaseTwo(int value) { return calculateLogBaseTwoDeBruijn(value) - (isPowerOfTwo(value) ? 0 : 1); }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int func_154354_b(int i, int j) {
/* 312 */     if (j == 0)
/* 313 */       return 0; 
/* 314 */     if (i == 0) {
/* 315 */       return j;
/*     */     }
/*     */     
/* 318 */     if (i < 0) {
/* 319 */       j *= -1;
/*     */     }
/* 321 */     int k = i % j;
/* 322 */     return (k == 0) ? i : (i + j - k);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 328 */   public static int func_180183_b(float f, float g, float h) { return func_180181_b(floor(f * 255.0F), floor(g * 255.0F), floor(h * 255.0F)); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 333 */   public static int func_180181_b(int i, int j, int k) { return ((i << 8) + j << 8) + k; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 338 */   public static int some_bit_shifting_with_ints(int i, int j) { return i & 0xFF000000 | (int)(((i & 0xFF0000) >> 16) * ((j & 0xFF0000) >> 16) / 255.0F) << 16 | (int)(((i & 0xFF00) >> 8) * ((j & 0xFF00) >> 8) / 255.0F) << 8 | (int)(((i & 0xFF) >> 0) * ((j & 0xFF) >> 0) / 255.0F); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 343 */   public static double remove_pre_dot(double d) { return d - Math.floor(d); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 348 */   public static long getPositionRandom(Vec3i pos) { return getCoordinateRandom(pos.getX(), pos.getY(), pos.getZ()); }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long getCoordinateRandom(int x, int y, int z) {
/* 353 */     long i = (x * 3129871) ^ z * 116129781L ^ y;
/* 354 */     return i * i * 42317861L + i * 11L;
/*     */   }
/*     */ 
/*     */   
/*     */   public static UUID getRandomUuid(Random rand) {
/* 359 */     long i = rand.nextLong() & 0xFFFFFFFFFFFF0FFFL | 0x4000L;
/* 360 */     long j = rand.nextLong() & 0x3FFFFFFFFFFFFFFFL | Float.MIN_VALUE;
/* 361 */     return new UUID(i, j);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 366 */   public static double func_181160_c(double d, double e, double f) { return (d - e) / (f - e); }
/*     */ 
/*     */ 
/*     */   
/*     */   public static double func_181159_b(double d, double e) {
/* 371 */     double f = e * e + d * d;
/*     */     
/* 373 */     if (Double.isNaN(f))
/*     */     {
/* 375 */       return NaND;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 380 */     boolean f1 = (d < 0.0D), f2 = (e < 0.0D);
/*     */     
/* 382 */     if (f1)
/*     */     {
/* 384 */       d = -d;
/*     */     }
/*     */     
/* 387 */     if (f2)
/*     */     {
/* 389 */       e = -e;
/*     */     }
/*     */     
/* 392 */     boolean f3 = (d > e);
/*     */     
/* 394 */     if (f3) {
/*     */       
/* 396 */       double d1 = e;
/* 397 */       e = d;
/* 398 */       d = d1;
/*     */     } 
/*     */     
/* 401 */     double g = func_181161_i(f);
/* 402 */     e *= g;
/* 403 */     d *= g;
/* 404 */     double h = field_181163_d + d;
/* 405 */     int i = (int)Double.doubleToRawLongBits(h);
/* 406 */     double j = field_181164_e[i];
/* 407 */     double k = field_181165_f[i];
/* 408 */     double l = h - field_181163_d;
/* 409 */     double m = d * k - e * l;
/* 410 */     double n = (6.0D + m * m) * m * 0.16666666666666666D;
/* 411 */     double o = j + n;
/*     */     
/* 413 */     if (f1)
/*     */     {
/* 415 */       return -o;
/*     */     }
/* 417 */     if (f2)
/*     */     {
/* 419 */       return Math.PI - o;
/*     */     }
/* 421 */     if (f3)
/*     */     {
/* 423 */       return 1.5707963267948966D - o;
/*     */     }
/*     */ 
/*     */     
/* 427 */     return o;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double func_181161_i(double d) {
/* 434 */     double e = 0.5D * d;
/* 435 */     long i = Double.doubleToRawLongBits(d);
/* 436 */     i = 6910469410427058090L - (i >> true);
/* 437 */     d = Double.longBitsToDouble(i);
/* 438 */     return 1.5D - e * d * d;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int hsv_to_rgb(float h, float s, float v) {
/*     */     float f6, f6, f6, f6, f6, f6, f5, f5, f5, f5, f5, f5, f4, f4, f4, f4, f4, f4;
/* 444 */     int i = (int)(h * 6.0F) % 6;
/* 445 */     float f = h * 6.0F - i;
/* 446 */     float f1 = v * (1.0F - s);
/* 447 */     float f2 = v * (1.0F - f * s);
/* 448 */     float f3 = v * (1.0F - (1.0F - f) * s);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 453 */     switch (i) {
/*     */       
/*     */       case 0:
/* 456 */         f4 = v;
/* 457 */         f5 = f3;
/* 458 */         f6 = f1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 495 */         return clamp((int)(f4 * 255.0F), 0, 255) << 16 | clamp((int)(f5 * 255.0F), 0, 255) << 8 | clamp((int)(f6 * 255.0F), 0, 255);case 1: f4 = f2; f5 = v; f6 = f1; return clamp((int)(f4 * 255.0F), 0, 255) << 16 | clamp((int)(f5 * 255.0F), 0, 255) << 8 | clamp((int)(f6 * 255.0F), 0, 255);case 2: f4 = f1; f5 = v; f6 = f3; return clamp((int)(f4 * 255.0F), 0, 255) << 16 | clamp((int)(f5 * 255.0F), 0, 255) << 8 | clamp((int)(f6 * 255.0F), 0, 255);case 3: f4 = f1; f5 = f2; f6 = v; return clamp((int)(f4 * 255.0F), 0, 255) << 16 | clamp((int)(f5 * 255.0F), 0, 255) << 8 | clamp((int)(f6 * 255.0F), 0, 255);case 4: f4 = f3; f5 = f1; f6 = v; return clamp((int)(f4 * 255.0F), 0, 255) << 16 | clamp((int)(f5 * 255.0F), 0, 255) << 8 | clamp((int)(f6 * 255.0F), 0, 255);case 5: f4 = v; f5 = f1; f6 = f2; return clamp((int)(f4 * 255.0F), 0, 255) << 16 | clamp((int)(f5 * 255.0F), 0, 255) << 8 | clamp((int)(f6 * 255.0F), 0, 255);
/*     */     } 
/*     */     throw new RuntimeException("Something went wrong when converting from HSV to RGB. Input was " + h + ", " + s + ", " + v);
/*     */   }
/*     */   static  {
/* 500 */     pi_multiply_divide = 9.587379924285257E-5D;
/*     */     
/* 502 */     for (int i = 0; i < 65536; i++)
/*     */     {
/* 504 */       SIN_TABLE[i] = (float)Math.sin(i * pi_multiply_divide);
/*     */     }
/*     */     
/* 507 */     multiplyDeBruijnBitPosition = new int[] { 0, 1, 28, 2, 29, 14, 24, 3, 30, 22, 20, 15, 25, 17, 4, 8, 31, 27, 13, 23, 21, 19, 16, 7, 26, 12, 18, 6, 11, 5, 10, 9 };
/* 508 */     field_181163_d = Double.longBitsToDouble(4805340802404319232L);
/* 509 */     field_181164_e = new double[257];
/* 510 */     field_181165_f = new double[257];
/*     */     
/* 512 */     for (int j = 0; j < 257; j++) {
/*     */       
/* 514 */       double d0 = j / 256.0D;
/* 515 */       double d1 = Math.asin(d0);
/* 516 */       field_181165_f[j] = Math.cos(d1);
/* 517 */       field_181164_e[j] = d1;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Media\Documents\Joyca\Joyca.jar!\me\lavache\BaseClient\Utils\MathHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */