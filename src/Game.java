import java.io.*;
import java.util.Scanner;

public class Game {

    private static final int EASY = 10;
    private static final int MEDIUM = 5;
    private static final int HARD = 3;

    private static final File highScoreFile = new File("score.txt");

    private static int setDifficulty(int difficulty){
        return switch (difficulty) {
            case 1 -> {
                System.out.println("You've chosen EASY!");
                yield EASY;
            }
            case 2 -> {
                System.out.println("You've chosen MEDIUM!");
                yield MEDIUM;
            }
            case 3 -> {
                System.out.println("You've chosen HARD!");
                yield HARD;
            }
            default -> {
                System.out.println("ERROR: must write a number between 1 or 3!");
                yield 0;
            }
        };
    }

    public static boolean checkGuess(int number, int guess){
        if(number == guess){
            return true;
        } else if (number < guess) {
            System.out.println("Incorrect! The number is less than "+guess);
        } else if (number > guess) {
            System.out.println("Incorrect! The number is greater than "+guess);
        }
        return false;
    }
    public static int getHighscore () {
        if(highScoreFile.exists()){
            try{
                FileReader fileReader = new FileReader(highScoreFile);
                int highScore = fileReader.read();
                fileReader.close();
                return highScore;
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }
        return 0;
    }

    public static void setHighScore (int newHighScore){

            try{
                FileWriter fileWriter = new FileWriter(highScoreFile, false);
                fileWriter.write(newHighScore);
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }

    public static void main(String[] args) {
        int number = (int) (Math.random()*(100 - 1) + 1);
        int attempts = 1;
        int guess;
        int highScore = getHighscore();
        System.out.println("Last highScore: "+highScore);
        System.out.println("Welcome to the Number Guessing Game!\n" +
                "I'm thinking of a number between 1 and 100.\n" +
                "You have 5 chances to guess the correct number.\n" +
                "\n" +
                "Please select the difficulty level:\n" +
                "1. Easy (10 chances)\n" +
                "2. Medium (5 chances)\n" +
                "3. Hard (3 chances)");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice ");
        int difficulty = setDifficulty(scanner.nextInt());
        System.out.println("Let's start the game!");

        while(attempts <= difficulty){
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            System.out.println("\n");
            if(checkGuess(number,guess)){
                System.out.println("Congratulations! You guessed the correct number in "+attempts +" attempts!");
                if(attempts < highScore || highScore == 0){
                    System.out.println("NEW HIGH SCORE!!!");
                    setHighScore(attempts);
                }
                break;
            }
            attempts++;
            if(attempts > difficulty){
                System.out.println("GAME OVER");
                System.out.println("Do you want to continue?");
                System.out.println("1. YES");
                System.out.println("2. NO");
                if(scanner.nextInt() == 1){
                    attempts = 1;
                }else{
                    break;
                }
            }
        }






    }

}
