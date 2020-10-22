package dominointerface;

import java.util.*;

// This is the tester class that makes sure that all the players have input the correct position and
// its making sure that all the shuffles are completed. This tester class was provided by the instructer of the course.

public class Tester {

    public static void main(String[] args) {

        Random rand = new Random(System.currentTimeMillis());

        boolean p1Passed = false;
        boolean p2Passed = false;
        int turnOrder = 0;
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        Board board = new Board();
        Pack newPack = new Pack();
        Domino playedDom;

        //Determine which player goes first 0 = player1 or 1 = player2
        turnOrder = rand.nextInt(2);

        if (turnOrder == 0) {
            System.out.println("Player1 goes first.");
            System.out.println();
        } else {
            System.out.println("Player2 goes first.");
            System.out.println();
        }

        //Shuffle the dominos based on the java collections shuffle funcion
        newPack.shuffle();

        //Deal 10 dominos to each player
        newPack.dealHand(player2, 10);
        newPack.dealHand(player1, 10);

        //Print the player's starting hands
        System.out.println("Player1's initial hand:");
        printHand(player1);
        System.out.println("Player2's initial hand:");
        printHand(player2);

        //Place First Domino
        Domino firstDom = Pack.pack.remove(0);
        board.addDominoTop(firstDom);

        //Print the initial board
        System.out.println();
        System.out.println("The Initial Board: ");
        board.printBoardHorz();
        System.out.println();

        //Play the game
        while (true) {

            System.out.println();
            System.out.println();
            if (turnOrder == 0) {

                turnOrder++;
                p1Passed = false;
                System.out.println("Player1's Turn: ");
                System.out.println();
                System.out.println("Player1's hand at the start of this turn:");
                printHand(player1);
                System.out.println();
                System.out.println("Board at the start of this turn:");
                board.printBoardHorz();
                System.out.println();

                if (player1.hasPlay(board.dominos.get(0).side2)) {
                    playedDom = player1.makePlayTop(board.dominos.get(0).side2);
                    board.addDominoTop(playedDom);
                    System.out.print("Player 1 has played: ");
                    playedDom.printHorizontal();
                    System.out.println();
                } else if (player1.hasPlay(board.dominos.get(board.dominos.size() - 1).side1)) {
                    playedDom = player1.makePlayBot(board.dominos.get(board.dominos.size() - 1).side1);
                    board.addDominoBot(playedDom);
                    System.out.print("Player 1 has played: ");
                    playedDom.printHorizontal();
                    System.out.println();
                } else if (!Pack.pack.isEmpty()) {
                    newPack.dealHand(player1, 1);
                    System.out.print("Player1 has drawn: ");
                    player1.hand.get(player1.hand.size()-1).printHorizontal();
                    System.out.println();
                } else {
                    p1Passed = true;
                    System.out.println("Player1 cannot play or draw, they pass.");
                }

                if (player1.isHandEmpty()) {
                    System.out.println();
                    System.out.println("Player1's hand is empty, they win.");
                    System.out.println("Final Board: ");
                    board.printBoardHorz();
                    System.out.println();
                    System.out.println("Player2 had: " + player2.hand.size() + " pieces left, they were: ");
                    printHand(player2);
                    break;
                }

                if (p1Passed && p2Passed) {
                    System.out.println();
                    System.out.println("Neither Player can play, the game is a tie.");
                    System.out.println("Final Board: ");
                    board.printBoardHorz();
                    System.out.println();
                    System.out.println("Player1 had: " + player1.hand.size() + " pieces left, they were: ");
                    printHand(player1);
                    System.out.println();
                    System.out.println("Player2 had: " + player2.hand.size() + " pieces left, they were: ");
                    printHand(player2);
                    break;

                }

            } else if (turnOrder == 1) {
                turnOrder--;
                p2Passed = false;
                System.out.println("Player2's Turn: ");
                System.out.println();
                System.out.println("Player2's hand at the start of this turn:");
                printHand(player2);
                System.out.println();
                System.out.println("Board at the start of this turn:");
                board.printBoardHorz();
                System.out.println();

                if (player2.hasPlay(board.dominos.get(0).side2)) {
                    playedDom = player2.makePlayTop(board.dominos.get(0).side2);
                    board.addDominoTop(playedDom);
                    System.out.print("Player 2 has played: ");
                    playedDom.printHorizontal();
                    System.out.println();
                } else if (player2.hasPlay(board.dominos.get(board.dominos.size() - 1).side1)) {
                    playedDom = player2.makePlayBot(board.dominos.get(board.dominos.size() - 1).side1);
                    board.addDominoBot(playedDom);
                    System.out.print("Player 2 has played: ");
                    playedDom.printHorizontal();
                    System.out.println();
                } else if (!Pack.pack.isEmpty()) {
                    newPack.dealHand(player2, 1);
                    System.out.print("Player2 has drawn: ");
                    player2.hand.get(player2.hand.size()-1).printHorizontal();
                    System.out.println();
                } else {
                    p2Passed = true;
                    System.out.println("Player2 cannot play or draw, they pass.");

                }

                if (player2.isHandEmpty()) {
                    System.out.println();
                    System.out.println("Player2's hand is empty, they win.");
                    System.out.println("Final Board: ");
                    board.printBoardHorz();
                    System.out.println();
                    System.out.println("Player1 had: " + player1.hand.size() + " pieces left, they were: ");
                    printHand(player1);
                    break;
                }

                if (p1Passed && p2Passed) {
                    System.out.println();
                    System.out.println("Neither Player can play, the game is a tie.");
                    System.out.println("Final Board: ");
                    board.printBoardHorz();
                    System.out.println();
                    System.out.println("Player1 had: " + player1.hand.size() + " pieces left, they were: ");
                    printHand(player1);
                    System.out.println();
                    System.out.println("Player2 had: " + player2.hand.size() + " pieces left, they were: ");
                    printHand(player2);
                    break;
                }
            }

            System.out.println();
            if (turnOrder == 1) {
                System.out.println("Player1's hand after this round.");
                printHand(player1);
            } else {
                System.out.println("Player2's hand after this round.");
                printHand(player2);
            }

            System.out.println();
            System.out.println("The new board: ");
            board.printBoardHorz();
            System.out.println();

        }

    }

    public static void printHand(Player name) {

        for (int i = 0; i < name.hand.size(); i++) {
            name.hand.get(i).printHorizontal();
        }
        System.out.println();
    }

}
