// This programs finds the standardized test scores, GPAs and overall scores
// for two individuals.
// This variation includes several methods other than method main that
// provide structure and eliminate redundancy.

import java.util.*;

public class Admit {
   public static void main(String[] args) {
      giveIntro();
      Scanner console = new Scanner(System.in);
      double applicant1 = getScore(1, console);
      double applicant2 = getScore(2, console);
      reportResults(applicant1, applicant2);
   }

   // introduces the program to the user
   public static void giveIntro() {
      System.out.println("This program compares two applicants to");
      System.out.println("determine which one seems like the stronger");
      System.out.println("applicant.  For each candidate I will need");
      System.out.println("either SAT or ACT scores plus a weighted GPA.");
      System.out.println();
   }

   // reports the overall score for the calculated exam score and GPA score
   // concludes which applicant seems to be better
   public static void reportResults(double applicant1, double applicant2) {
      System.out.println("First applicant overall score  = " + round1(applicant1));
      System.out.println("Second applicant overall score = " + round1(applicant2));
      if (applicant1 > applicant2) {
         System.out.println("The first applicant seems to be better");
      } else if (applicant2 > applicant1) {
         System.out.println("The second applicant seems to be better");
      } else {
         System.out.println("The two applicants seem to be equal");
      }
   }

   // uses the provided console Scanner to prompt for one's statistics,
   // based on their test choice: SAT or ACT
   // returns the overall score for each applicant
   public static double getScore(int applicant, Scanner console) {
      System.out.println("Information for applicant #" + applicant + ":");
      System.out.print("    do you have 1) SAT scores or 2) ACT scores? ");
      int choice = console.nextInt();
      double examScore = 0;
      if (choice == 1) {
         examScore = scoreSAT(console);
      } else {
         examScore = scoreACT(console);
      }
      double scoreGPA = getGPA(console);
      System.out.println();
      return scoreGPA + examScore;
   }

   // uses the provided console Scanner to prompt for one's statistics,
   // returns the SAT score
   public static double scoreSAT(Scanner console) {
      System.out.print("    SAT math? ");
      int math = console.nextInt();
      System.out.print("    SAT critical reading? ");
      int reading = console.nextInt();
      System.out.print("    SAT writing? ");
      int writing = console.nextInt();
      double examScoreSAT = getSAT(math, reading, writing);
      System.out.println("    exam score = " + round1(examScoreSAT));
      return examScoreSAT;
   }

   // returns the SAT score for the given statistics
   public static double getSAT(int math, int reading, int writing) {
      return (2 * math + reading + writing) / 32.0;
   }

   // uses the provided console Scanner to prompt for one's statistics,
   // returns the ACT score
   public static double scoreACT(Scanner console) {
      System.out.print("    ACT English? ");
      int english = console.nextInt();
      System.out.print("    ACT math? ");
      int math = console.nextInt();
      System.out.print("    ACT reading? ");
      int reading = console.nextInt();
      System.out.print("    ACT science? ");
      int science = console.nextInt();
      double examScoreACT = getACT(english, math, reading, science);
      System.out.println("    exam score = " + round1(examScoreACT));
      return examScoreACT;
   }

   // returns the ACT score for the given statistics
   public static double getACT(int english, int math, int reading, int science) {
      return (english + 2 * math + reading + science) / 1.8;
   }

   // uses the provided console Scanner to prompt for one's statistics,
   // returns the GPA score
   public static double getGPA(Scanner console) {
      System.out.print("    overall GPA? ");
      double overallGPA = console.nextDouble();
      System.out.print("    max GPA? ");
      double maxGPA = console.nextDouble();
      System.out.print("    Transcript Multiplier? ");
      double multiplier = console.nextDouble();
      double score = getGPAScore(overallGPA, maxGPA, multiplier);
      System.out.println("    GPA score = " + round1(score));
      return score;
   }

   // returns the GPA score for the given statistics
   public static double getGPAScore(double overallGPA, double maxGPA, double multiplier) {
      return (overallGPA/maxGPA) * 100 * multiplier;
   }

   // returns the result of rounding n to 1 digit after the decimal point
   public static double round1(double n) {
      return Math.round(n * 10.0) / 10.0;
   }
}

