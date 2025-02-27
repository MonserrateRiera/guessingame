# Number Guessing Game

## Overview
The Number Guessing Game is a simple console-based game written in Java. The game randomly selects a number between 1 and 100, and the player must guess the correct number within a limited number of attempts. The game supports three difficulty levels: Easy, Medium, and Hard.

## Features
- Three difficulty levels:
  - Easy: 10 attempts
  - Medium: 5 attempts
  - Hard: 3 attempts
- Tracks and saves the high score in a file (`score.txt`).
- Provides hints to the player on whether the guess is too high or too low.
- Allows the player to restart the game after losing.

## How to Play
1. Run the game.
2. Choose a difficulty level:
   - 1 for Easy
   - 2 for Medium
   - 3 for Hard
3. Enter guesses until you find the correct number or run out of attempts.
4. If you guess correctly, your score (number of attempts) will be compared to the high score.
5. If your score is better than the high score, it will be saved as the new high score.
6. If you run out of attempts, you will be given the option to restart or quit.

## Installation & Running the Game
1. Make sure you have Java installed (JDK 8 or later).
2. Compile the game:
   ```sh
   javac Game.java
   ```
3. Run the game:
   ```sh
   java Game
   ```

## Files
- `Game.java` - The main source code for the game.
- `score.txt` - A file used to store the high score.

## Notes
- If the `score.txt` file does not exist, the program will create it automatically.
- The game uses a random number generator to pick the target number each time.

## Future Improvements
- Add a GUI interface.
- Allow multiple rounds without restarting the program.
- Implement a leaderboard to track multiple high scores.

## License
This project is open-source and free to use. I've found this project at <https://roadmap.sh/projects/number-guessing-game>

---
Happy guessing!

