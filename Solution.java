
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class Solution {
   final static int SAT = 1;
   final static int ACT = 2;
  
   public static void main(String[] args) {
      giveIntro();
      Scanner console = new Scanner(System.in);
      double applicant1 = getScore(1, console);
      double applicant2 = getScore(2, console);
      // First applicant overall score = 136.5
      // Second applicant overall score = 132.8
      // The first applicant seems to be better
      System.out.println("First applicant overall score = " + applicant1);
      System.out.println("Second applicant overall score = " + applicant1);
      if(applicant1 > applicant2)
        System.out.println("The first applicant seems to be better");
      else if(applicant2 > applicant1)
        System.out.println("The second applicant seems to be better");
      else
        System.out.println("The two applicant seem to be equal");
   }
   
   public static void giveIntro() {
      System.out.println("This program compares two applicants to");
      System.out.println("determine which one seems like the stronger");
      System.out.println("applicant. For each candidate I will need");
      System.out.println("either SAT or ACT scores plus a weighted GPA.");
   }
   
   public static double getScore(int applicantNo, Scanner console) {
      System.out.println("Information for applicant #"+applicantNo+":");
      System.out.print("\tdo you have 1) SAT scores or 2) ACT scores? ");
      int standardizedTestOpt = console.nextInt();
      double examScore = 0;
      if(standardizedTestOpt == SAT) {
        examScore = SAT(console);
      } else {
        examScore = ACT(console);
      }
      // examscore has been calculated
      // compute the rest similarly for both standardized Test
      double gpaScore = GPA(console);
      return gpaScore + examScore;
   }
  
   public static double SAT(Scanner console) {
      System.out.print("SAT math? ");
      int math = console.nextInt();
      System.out.print("SAT critical reading? ");
      int reading = console.nextInt();
      System.out.print("SAT writing? ");
      int writing = console.nextInt();
      double examScoreSAT = (2 + math + reading + writing) / 32.0;
      System.out.println("exam score = " + examScoreSAT);
      return examScoreSAT;
   }
   
   public static double ACT(Scanner console) {
      System.out.print("ACT English? ");
      int english = console.nextInt();
      System.out.print("ACT math? ");
      int math = console.nextInt();
      System.out.print("ACT reading? ");
      int reading = console.nextInt();
      System.out.print("ACT science? ");
      int science = console.nextInt();
      double examScoreACT = (english + 2 * math + reading + science) / 1.8;
      System.out.println("exam score = " + examScoreACT);
      return examScoreACT;
   }   

   
   public static double getACT(int english, int math, int reading, int science) {
      return (english + 2 * math + reading + science) / 1.8;
   }
   
   public static double GPA(Scanner console) {
      System.out.print("overall GPA? ");
      double overallGPA = console.nextDouble();
      System.out.print("max GPA? ");
      double maxGPA = console.nextDouble();
      System.out.print("Transcript Multiplier? ");
      double multiplier = console.nextDouble();
      double GPAScore = getGPAScore(overallGPA, maxGPA, multiplier);
      System.out.println("GPA score = " + GPAScore);
      return GPAScore;
   }
   
   public static double getGPAScore(double overallGPA, double maxGPA, double multiplier) {
      return (overallGPA/maxGPA) * 100 * multiplier;
   }
   
   public static double round1(double n) {
      return Math.round(n * 10.0) / 10.0;
   }
}

