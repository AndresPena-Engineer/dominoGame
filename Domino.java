package dominointerface;

/**
 * A class used to represent a single domino.
 */
public class Domino {

    /* Fields used to represent the sides of a domino.
	 * A domino has two sides associated with it. */
    protected int side1, side2;
    private boolean flipped;

    /**
     * Constructor that makes a new "double blank" domino. I.e. a domino whose
     * both sides are 0.
     */
    public Domino() {
        this.side1 = 0;
        this.side2 = 0;
        this.flipped = false;
    }

    /**
     *
     * @param side1 the integer used represent the 1st side of the domino.
     * @param side2 the integer used represent the 2nd side of the domino.
     */
    public Domino(int side1, int side2) {
        this.side1 = side1;
        this.side2 = side2;
        this.flipped = false;
    }

    /* Getters for the Domino */
    /**
     * Get's the number associated with the 1st side of the domino.
     *
     * @return the number value for the 1st side of the domino.
     */
    public int getSide1() {
        return side1;
    }

    /**
     * Get's the number associated with the 2nd side of the domino.
     *
     * @return the number value for the 2nd side of the domino.
     */
    public int getSide2() {
        return side2;
    }

    /**
     * Determines if the domino is/was flipped.
     *
     * @return true if the domino is flipped.
     */
    public boolean isFlip() {
        return flipped;
    }

    /**
     * Flips the domino's state.
     */
    public void flipDom() {

        /* Change the flip state of the domino */
        int temp = side1;
        side1 = side2;
        side2 = temp;
        flipped = !flipped;
    }

    /**
     * Prints a vertical text representation of the domino.
     */
    public void printVertical() {

        System.out.println("---");
        System.out.println(" " + side2);
        System.out.println(" -");
        System.out.println(" " + side1);
        System.out.println("---");

    }

    /**
     * Prints a horizonal text representation of the domino.
     */
    public void printHorizontal() {

        System.out.print("[" + side2 + " | " + side1 + "]");

    }

}
