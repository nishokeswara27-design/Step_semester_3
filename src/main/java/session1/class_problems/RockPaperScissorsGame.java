package session1.class_problems;

import java.util.Random;

public class RockPaperScissorsGame {

    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    /**
     * Determines the outcome of a single round of Rock-Paper-Scissors.
     * @param playerMove   The player's move ("Rock", "Paper", or "Scissors")
     * @param computerMove The computer's move ("Rock", "Paper", or "Scissors")
     * @return "Player Wins", "Computer Wins", or "Draw"
     */
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    /**
     * Generates a random computer move.
     */
    public static String getRandomComputerMove() {
        Random random = new Random();
        return MOVES[random.nextInt(MOVES.length)];
    }

    public static void main(String[] args) {
        String[] predefinedPlayerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        int totalRounds = 5;

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < totalRounds; i++) {
            String playerMove = predefinedPlayerMoves[i];
            String computerMove = getRandomComputerMove();
            String result = playRound(playerMove, computerMove);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.printf("Round %d — Player: %s, Computer: %s | %s%n", (i + 1), playerMove, computerMove, result);
        }

        double winPercentage = ((double) wins / totalRounds) * 100.0;
        System.out.println("--------------------------------------------------");
        System.out.printf("Final Summary (after %d rounds)%n", totalRounds);
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, winPercentage);
    }
}
