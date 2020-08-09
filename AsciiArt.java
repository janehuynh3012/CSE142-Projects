// This program produces as output an ASCII art representation of a christmas
// tree.

public class AsciiArt {
   public static void main(String[] args) {
      dot();
      tree();
      star();
      body();
      body();
      dot();
   }
      
   // outputs the dot line
   public static void dot() { 
      for (int dots = 1; dots <= 12; dots++) {
         System.out.print(".");
      }  
      System.out.println();
   } 
  
   // outputs the tree
   public static void tree() {   
      for (int i = 1; i <= 5; i++) {
         System.out.print(">");    
         for (int spaces = 1; spaces <= -1 * i + 5; spaces++) {
            System.out.print(" ");
         }
         for (int stars = 1; stars <= 2 * i; stars++) {
            System.out.print("*");
         }
         for (int spaces = 1; spaces <= -1 * i + 5; spaces++) {
            System.out.print(" ");
         }
         System.out.println("<");
      }
   }
   
   // outputs the star line
   public static void star() {
      for (int stars = 1; stars <= 12; stars++) {
         System.out.print("*");
      }
      System.out.println();
   }
   
   // outputs the body of the tree
   public static void body() {
      System.out.print(">");
      for (int spaces = 1; spaces <= 3; spaces++) {
         System.out.print(" ");
      }
      System.out.print("****");
      for (int spaces = 1; spaces <= 3; spaces++) {
         System.out.print(" ");
      }
      System.out.println("<");
   }
}
