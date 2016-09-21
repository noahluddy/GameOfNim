
import java.util.Scanner;
/**
 * Simulates the players for a game of Nim.
 *
 * @author Noah Luddy
 * @version 1.0
 */
public class Player
{
    // instance variables
    private boolean human = false;
    private boolean smart = false;
	private Scanner myScan;

    public Player() {
        int smartInt = (int)(2*Math.random());
        if (smartInt == 0) {
            smart = true;
        } else {
            smart = false;
        }
    }

    public void setMode(boolean h)
    {
        human = h;
    }

    public boolean getMode() {
        return human;
    }


    public boolean getSmart() {
        return smart;
    }

    public void makeMove(Pile pile) {
        if (human) {
            System.out.print("Please enter the amount of stones you would like to remove: ");
            myScan = new Scanner(System.in);
            int input = myScan.nextInt();
            while (input > pile.getSize()/2) {
                System.out.print("You entered a number too big. Please enter a number up to " + pile.getSize()/2 + ": ");
                input = myScan.nextInt();
            }
            human = false;
            pile.remove(input);
        } else {
            int initialSize = pile.getSize();
            if (smart) {
                if (pile.getSize() > 63) {
                    human = true;
                    pile.remove(pile.getSize()-63);
                } else if (pile.getSize() > 31) {
                    human = true;
                    if (pile.getSize() == 63) {
                        pile.remove(1);
                    } else {
                        pile.remove(pile.getSize()-31);
                    }
                } else if (pile.getSize() > 15) {
                    human = true;
                    if (pile.getSize() == 31) {
                        pile.remove(1);
                    } else {
                        pile.remove(pile.getSize()-15);
                    }
                } else if (pile.getSize() > 7) {
                    human = true;
                    if (pile.getSize() == 15) {
                        pile.remove(1);
                    } else {
                        pile.remove(pile.getSize()-7);
                    }
                } else if (pile.getSize() > 3) {
                    human = true;
                    if (pile.getSize() == 7) {
                        pile.remove(1);
                    } else {
                        pile.remove(pile.getSize()-3);
                    }
                } else {
                    human = true;
                    pile.remove(1);
                }
            } else {
               int stones = (int)((pile.getSize()/2)*Math.random()+1);
               human = true;
               pile.remove(stones);
            }
            System.out.println("The computer removed " + (initialSize-pile.getSize()) + " stone(s).");
        }
        System.out.println("The pile now has " + pile.getSize() + " stone(s).");
        if (human) {
            System.out.println("It is now your turn.");
        } else {
            System.out.println("It is now the computer's turn.");
        }
    }
}
