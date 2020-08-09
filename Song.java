// Anh Kim Huynh
// 4/9/20
// CSE142
// TA: Harshal V Desai
// Assignment #1: Song
//
// This program will produce a cummulative song in which successive verses
// build on previous verses.
public class Song {
   public static void main(String[] args) {
      verse1();
      System.out.println();
      verse2();
      System.out.println();
      verse3();
      System.out.println();
      verse4();
      System.out.println();
      verse5();
      System.out.println();
      verse6();
      System.out.println();
      verse7();
   }
   
   public static void verse1() {
      System.out.println("There was an old woman who swallowed a fly.");
      iDK();
      die();
   }
   
   public static void verse2() {
      System.out.println("There was an old woman who swallowed a spider,");
      System.out.println("That wriggled and iggled and jiggled inside her.");
      spiderFly();
      iDK();
      die();
   }
   
   public static void verse3() {
      System.out.println("There was an old woman who swallowed a bird,");
      System.out.println("How absurd to swallow a bird.");
      birdSpider();
      spiderFly();
      iDK();
      die();
   }
   
   public static void verse4() {
      System.out.println("There was an old woman who swallowed a cat,");
      System.out.println("Imagine that to swallow a cat.");
      catBird();
      birdSpider();
      spiderFly();
      iDK();
      die();
   }
   
   public static void verse5() {
      System.out.println("There was an old woman who swallowed a dog,");
      System.out.println("What a hog to swallow a dog.");
      dogCat();
      catBird();
      birdSpider();
      spiderFly();
      iDK();
      die();
   }
   
   public static void verse6() {
      System.out.println("There was an old woman who swallowed a chicken,");
      System.out.println("How ridiculous to swallow a chicken.");
      System.out.println("She swallowed the chicken to catch the dog,");
      dogCat();
      catBird();
      birdSpider();
      spiderFly();
      iDK();
      die();
   }
   
   public static void verse7() {
      System.out.println("There was an old woman who swallowed a horse,");
      System.out.println("She died of course.");
   }
   
   public static void die() {
      System.out.println("Perhaps she'll die.");
   }
   
   public static void spiderFly() {
      System.out.println("She swallowed the spider to catch the fly,");
   }
   
   public static void birdSpider() {
      System.out.println("She swallowed the bird to catch the spider,");
   }
   
   public static void catBird() {
       System.out.println("She swallowed the cat to catch the bird,");
   }
   
   public static void dogCat() {
      System.out.println("She swallowed the dog to catch the cat,");
   }
   
   public static void iDK() {
      System.out.println("I don't know why she swallowed that fly,");
   }           
}
