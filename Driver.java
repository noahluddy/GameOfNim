
/**
 * Drives the game if Nim
 *
 * @author Noah Luddy
 * @version 1.0
 */
public class Driver
{
    public static void main(String args[]) {
        System.out.println("\f");

        Pile pile = new Pile();
        Player player = new Player();
        Game newGame = new Game();
        newGame.playGame(player, pile);
    }
}
