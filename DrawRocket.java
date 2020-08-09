// This program produces as output an ASCII art representation of a rocket.
// This version inclues a class constant for drawing rockets of different
// sizes.

public class DrawRocket {
   public static final int SIZE = 3; // change this to scale the rocket
   
   public static void main(String[] args) {
      drawTop();
      drawLine();
      drawTopBody();
      drawLine();
      drawBottomBody();
      drawLine();
      drawTop();
   }
   
   // outputs the top part of the rocket
   public static void drawTop() {
      for (int line = 1; line <= SIZE * 2 - 1; line++) {  
         for (int spaces = 1; spaces <= -1 * line + 2 * SIZE; spaces++) {
            System.out.print(" ");
         }
         for (int slash = 1; slash <= 1 * line; slash++) {
            System.out.print("/");
         }
         System.out.print("**");
         for (int backslash = 1; backslash <= 1 * line; backslash++) {
            System.out.print("\\");
         }
         for (int spaces = 1; spaces <= -1 * line + 2 * SIZE; spaces++) {
            System.out.print(" ");
         }
         System.out.println();
      }     
   }
   
   // outputs the top body of the rocket
   public static void drawTopBody() {
      drawTopHalf();
      drawBottomHalf();
   }
   
   // outputs the bottom body of the rocket
   public static void drawBottomBody() {
      drawBottomHalf();
      drawTopHalf();
   }

   // outputs the top half of the rocket
   public static void drawTopHalf() {
      for (int line = 1; line <= SIZE; line++) {
         System.out.print("|");
         for (int dots = 1; dots <= -1 * line + SIZE; dots++) {
            System.out.print(".");
         }
         for (int j = 1; j <= 1 * line; j++) {
            System.out.print("/\\");
         }
         for (int k = 1; k <= -2 * line + 2 * SIZE; k++) {
            System.out.print(".");
         }
         for (int j = 1; j <= 1 * line; j++) {
            System.out.print("/\\");
         }
         for (int dots = 1; dots <= -1 * line + SIZE; dots++) {
            System.out.print(".");
         }
         System.out.println("|");
       }
    }
   
   // same as top half only in reverse order
   public static void drawBottomHalf() {
      for (int line = SIZE; line >= 1; line--) {
         System.out.print("|");
         for (int dots = 1; dots <= -1 * line + SIZE; dots++) {
            System.out.print(".");
         }
         for (int j = 1; j <= 1 * line; j++) {
            System.out.print("\\/");
         }
         for (int k = 1; k <= -2 * line + 2 * SIZE; k++) {
            System.out.print(".");
         }
         for (int j = 1; j <= 1 * line; j++) {
            System.out.print("\\/");
         }
         for (int dots = 1; dots <= -1 * line + SIZE; dots++) {
            System.out.print(".");
         }
         System.out.println("|");
       }
   } 
   
   // outputs a solid line
   public static void drawLine() {
      System.out.print("+");
      for (int i = 1; i <= SIZE * 2; i++) {
         System.out.print("=*");
      }
      System.out.println("+");
   }
}
