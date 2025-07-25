package pgrm;

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int score = 0;
        int maxtry = 5;
        String playAgain;

        System.out.println("Welcome to Number Guessing Game!");

        do {
            int number = rand.nextInt(100) + 1;
            boolean guessed = false;

            System.out.println("\nGuess a number between 1 and 100");

            for (int i = 1; i <= maxtry; i++) 
            {
                System.out.print("Try " + i + ": ");
                int guess = sc.nextInt();

                if (guess == number) 
                {
                    System.out.println("Correct! You guessed it!");
                    guessed = true;
                    score++;
                    break;
                } 
                else if (guess < number) 
                {
                    System.out.println("Too low!");
                } 
                else 
                {
                    System.out.println("Too high!");
                }
            }

            if (!guessed) 
            {
                System.out.println("You lost! The number was: " + number);
            }

            System.out.print("Wanna try again? (y/n): ");
            playAgain = sc.next();

        } while (playAgain.equalsIgnoreCase("y"));

        System.out.println("GAME OVER! Your score: " + score);
        System.out.println("________________________________");
        sc.close();
    }
}
