package dominointerface;

import java.util.ArrayList;
import java.util.List;

/**
 * The class is used to represent a domino game player.
 */
public class Player {
	
	/* Fields */
	private static int numOfPlayers = 0; // holds the total number of players playing the domino game
	private final String name; // the name of the player
	private final int id; // the player's ID number. i.e. Player 1, Player 2, etc.
	List<Domino> hand; // The player has a hand of dominos.
	
	/**
	 * Creates a new player with a given name.
	 * <p>
	 * The player will be assigned the next available ID number. 
	 * @param name the name of the player.
	 */
	public Player(String name){
		
		/* Increase the number of players by one */
		numOfPlayers++;
		
		/* Initialize the fields */
		this.name = name;
		this.id = numOfPlayers;
		
		/* Player starts with an empty hand */
		this.hand = new ArrayList<>();
		
	}
	
	/**
	 * Gets the number of current players in the game.
	 * @return the current number of players in the game.
	 */
	public static int getNumOfPlayers() {
		return numOfPlayers;
	}
	
	/**
	 * Returns the player's name.
	 * @return the name of the player.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the player's ID.
	 * @return the ID of the player.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Returns the list of dominos in the player's hand.
	 * @return the dominos in this player's hand.
	 */
	public List<Domino> getHand(){
		return this.hand;
	}
	
	
	/**
	 * Determines if a player's hand is empty.
	 * @return true if the player has no more dominos in his/her hand.
	 */
	public boolean isHandEmpty(){
		return hand.isEmpty();
	}
	
	/**
	 * Adds a domino to the player's hand.
	 * @param domino the domino to be added to the player's hand.
	 */
	public void addDomino(Domino domino){
		this.hand.add(domino);
	}
	
	/**
	 * Removes a domino from the player's hand. It returns the removed domino.
	 * @param index the index position of the domino in the hand to be returned.
	 * @return the domino that is removed from the hand.
	 */
	public Domino removeDom(int index){
		
		/* Get the domino to be returned */
		Domino domino = hand.get(index);
		
		/* Remove it from the hand */
		hand.remove(index);
		
		/* Return the domino */
		return domino;
		
	}
	
	/** 
	 * Determine if the player has a domino in his/her hand that 
	 * can be played on the board.
     * @param side
	 * @return true if the player has a playable domino.
	 */
	public boolean hasPlay(int side){
            /* the board domino side (int) equals the hand domino side 1 or side 2 */
            /* Checked the entire hand, there were no matches */ 
		

		return hand.stream().anyMatch((domInHand) -> ( (side == domInHand.getSide1()) || (side == domInHand.getSide2()) ));
		
	}
        
        public Domino makePlayTop(int side)
        {
            for(int i = 0; i< hand.size(); i++)
            {
                if(hand.get(i).getSide1() == side)
                {
                    return hand.remove(i);
                }
                else if(hand.get(i).getSide2() == side)
                {
                    hand.get(i).flipDom();
                    return hand.remove(i);
                }
            }
            return null;
        }
        
        public Domino makePlayBot(int side)
        {
            for(int i = 0; i< hand.size(); i++)
            {
                if(hand.get(i).getSide1() == side)
                {
                    hand.get(i).flipDom();
                    return hand.remove(i);
                }
                else if(hand.get(i).getSide2() == side)
                {
                    return hand.remove(i);
                }
            }
            return null;
        }
	
	
	
	
}