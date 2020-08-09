// This program processes an input file of data for a personality test and
// produces output of one's overall result and score for each dimension.

import java.io.*;
import java.util.*;
import java.awt.*;


public class Personality {
   // results constants
   public static final char[] A_DOMINANT_PERSONALITIES = {'E', 'S', 'T', 'J'};
   public static final char[] B_DOMINANT_PERSONALITIES = {'I', 'N', 'F', 'P'};
   
   // tests logistics
   public static final int NUM_QUESTIONS = 70; // total of 10 groups, each group has 7 questions
   public static final int NUM_EI_QUESTIONS = 1;
   public static final int NUM_SI_QUESTIONS = 2;
   public static final int NUM_TF_QUESTIONS = 2;
   public static final int NUM_JP_QUESTIONS = 2;
   public static final int[] NUM_QUESTIONS_PER_GROUP = { NUM_EI_QUESTIONS, NUM_SI_QUESTIONS, 
                                                      NUM_TF_QUESTIONS, NUM_JP_QUESTIONS };
   public static final int NUM_PERSONALITY_TYPES = 4;
   
   public static void main(String[] args) throws FileNotFoundException {
      Scanner sc = new Scanner(System.in);
      giveIntro();
      System.out.print("input file name? ");
      String inputFileName = sc.next();
      System.out.print("output file name? ");
      String outputFileName = sc.next();
      sc.close();
      
      Scanner input = new Scanner(new File(inputFileName));
      PrintStream output = new PrintStream(new File(outputFileName));
      
      processInput(input, output);
      
      input.close();
      output.close();
   
   }

   // introduces the program to the user
   public static void giveIntro() {
      System.out.println("This program processes a file of answers to the ");
      System.out.println("Keirsey Temperament Sorter.  It converts the ");
      System.out.println("various A and B answers for each person into ");
      System.out.println("a sequence of B-percentages and then into a ");
      System.out.println("four-letter personality type. ");
      System.out.println();
   }
   
   /**
      @param input input scanner
      @param output output stream
      
      processes the input file of different personality tests and write results for all
      participants to output stream.
   **/
   public static void processInput(Scanner input, PrintStream output) {
      while (input.hasNextLine()) {
         String personName = input.nextLine();
         String answers = input.nextLine();
         int[] score = calculateBPercentages(answers);
         String result = getPersonalityResult(score);
         output.println(personName + ": " + Arrays.toString(score) + " = " + result);
      }  
   }

   /**
      @param score an array of size NUM_PERSONALITY_TYPES, indicating the percentage of B answers 
             of each corresponding personaility question type.
      @return the personality test result (Ex: ISTJ)
   **/
   public static String getPersonalityResult(int[] score) {
      String result = "";
      for (int qType = 0; qType < NUM_PERSONALITY_TYPES; ++qType) {
         if (score[qType] > 50) { 
            result += B_DOMINANT_PERSONALITIES[qType];
         } else if (score[qType] < 50) { 
            result += A_DOMINANT_PERSONALITIES[qType];
         } else {
            result += "X";
         }
      }  
      return result;
   }

   /**
      @param answers a string of length NUM_QUESTIONS characters, respresenting answers to 
             the personality questions
      @return an array of size NUM_PERSONALITY_TYPES, indicating the percentage of B answers of each
              corresponding personaility question type.
   **/
   public static int[] calculateBPercentages(String answers) {
      int[] aAnswers = new int[NUM_PERSONALITY_TYPES];
      int[] bAnswers = new int[NUM_PERSONALITY_TYPES];
      int[] score = new int[NUM_PERSONALITY_TYPES];

      // process data
      int i = 0;
      while (i < answers.length()){
         // iterate through each question type and increment corresponding answer count
         for (int qType = 0; qType < NUM_PERSONALITY_TYPES; qType++){
            for (int j = 0; j < NUM_QUESTIONS_PER_GROUP[qType]; j++) {
               if (Character.toLowerCase(answers.charAt(i)) == 'a') {
                   aAnswers[qType]++;
               }      
               if (Character.toLowerCase(answers.charAt(i)) == 'b') {
                   bAnswers[qType]++;
               }     
               i++;
            }
         }
      }

      // calculate score
      for (int qType = 0; qType < NUM_PERSONALITY_TYPES; qType++) {
         score[qType] = (int) Math.round((double) bAnswers[qType] / (aAnswers[qType] + 
                                                  bAnswers[qType]) * 100);
      }
      return score;
   }

}
