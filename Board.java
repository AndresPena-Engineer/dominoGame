package dominointerface;

import java.util.LinkedList;
import java.util.List;

/**
 * Class used to represent the board on which the dominoes are placed on.
 */
public class Board {

    protected final List<Domino> dominos;  // The board contains a set of dominoes
    private int topSide, botSide; // The board has two playable sides

    /**
     * Creates an empty board.
     */
    public Board() {

        /* Make an empty list to store all the dominoes on the board */
        this.dominos = new LinkedList<>();

    }

    /**
     * Gets the list of all the dominoes on the board.
     *
     * @return a list of all the dominoes on the board.
     */
    public List<Domino> getDominos() {
        return dominos;
    }

    /**
     * Determines if the board is empty or not.
     *
     * @return true if the board is empty.
     */
    public boolean isEmpty() {
        return this.dominos.isEmpty();

    }

    /**
     * Returns the number of dominos currently on the board.
     *
     * @return the number of dominos currently on the board.
     */
    public int numDomBoard() {
        return dominos.size();
    }

    /**
     * Add a domino to the top of the board.
     * <p>
     * The user of this method must specify which side of the domino should be
     * connected to the board.
     *
     * @param addedDom the domino to be added to the board.
     * @param side1 true if side1 of the added domino is the side that matches
     * the board.
     */
    public void addDominoTop(Domino addedDom) {

        /* Add to the start of the list */
        dominos.add(0, addedDom);

        topSide = addedDom.getSide2();

    }

    /**
     * Add a domino to the bot of the board.
     * <p>
     * The user of this method must specify which side of the domino should be
     * connected to the board.
     *
     * @param addedDom the domino to be added to the board.
     * @param side1 true if side1 of the added domino is the side that matches
     * the board.
     */
    public void addDominoBot(Domino addedDom) {

        /* Add to the end of the list */
        dominos.add(addedDom);

        botSide = addedDom.getSide2();

    }

    /**
     * Prints the board vertically in a text format.
     */
    public void printBoardVert() {

        /* Print all the dominos on the board */
        dominos.forEach((dom) -> {
            dom.printVertical();
        });

        System.out.println();
    }

    /**
     * Prints the board horizontally in a text format.
     */
    public void printBoardHorz() {

        /* Print all the dominos on the board */
        dominos.forEach((dom) -> {
            dom.printHorizontal();
        });

        System.out.println();
    }

}
