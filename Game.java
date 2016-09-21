
/**
 * Simulates a game of Nim
 *
 * @author Noah Luddy
 * @version 1.0
 */
public class Game
{
    private int firstTurn = (int)(2*Math.random());

    /**
     * Constructor for objects of class Game
     */
    public Game() {}

    /**
     * Plays the game.
     *
     * @param  player   The player
     * @param pile   The pile
     */
    public void playGame(Player player, Pile pile) {
        System.out.println("Welcome to the game of Nim! \nTo play, simply enter the amount of stones you wish to remove from the pile. \nThe player that has to remove the last stone loses. \nEach player can only remove up to half of the stones. Good luck!\n");

        // New if statment
        System.out.println(player.getSmart() ? "The computer is smart." : "The computer is stupid.");

        /**
         * Old if statement
        if (player.getSmart()) {
            System.out.println("The computer is smart.");
        } else {
            System.out.println("The computer is stupid.");
        }
        */

        if (firstTurn == 0) {
            player.setMode(true);
            System.out.println("You have the first move.");
        } else {
            player.setMode(false);
            System.out.println("The computer has the first move.");
        }

        System.out.println("The initial size of the pile is " + pile.getSize() + " stones.");

        while (pile.getSize() > 1) {
            player.makeMove(pile);
        }

        if (player.getMode()) {
            System.out.println("Sorry, you lost.");
        } else {
            System.out.println("Hooray! You won!");
        }
    }
}
