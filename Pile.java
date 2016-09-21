
/**
 * Simulates a pile of marbles for a game of Nim.
 *
 * @author Noah Luddy
 * @version 1.0
 */
public class Pile
{
    // instance variables
    private int numOfMarbles;

    /**
     * Constructor for objects of class Pile
     */
    public Pile()
    {
        // initialise instance variables
        numOfMarbles = (int)((100-10)*Math.random()+10);
    }

    public int getSize() {
        return numOfMarbles;
    }

    /**
     * Removes marbles from the pile.
     * @param number of marbles
     */
    public void remove(int n)
    {
        numOfMarbles -= n;
    }
}
