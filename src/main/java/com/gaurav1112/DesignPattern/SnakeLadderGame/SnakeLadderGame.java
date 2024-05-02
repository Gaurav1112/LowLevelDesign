package com.gaurav1112.DesignPattern.SnakeLadderGame;

import java.util.Deque;
import java.util.LinkedList;

public class SnakeLadderGame {

    Board board;
    Deque<Player> players = new LinkedList<>();
    Dice dice;
    Player winner;

    public SnakeLadderGame(){
        initializeGame();
    }

    public void initializeGame(){
        board = new Board(10, 5, 4);
        dice = new Dice(1);
        winner =  null;
        addPlayer();
    }

    public void addPlayer(){
        Player p1 = new Player("p1", 0);
        Player p2 = new Player("p2", 0);
        players.add(p1);
        players.add(p2);
    }

    public void startGame(){
        while(winner == null){
            Player playerTurn = findPlayerTurn();
            System.out.println("Player : " + playerTurn.id + " is at position: " + playerTurn.currentPos);
            int diceNumber = dice.rollDice();
            int playerNewPos = playerTurn.currentPos  + diceNumber;
            playerNewPos = checkJumps(playerNewPos);
            playerTurn.currentPos = playerNewPos;
            System.out.println("player: " + playerTurn.id + " is at position: " + playerTurn.currentPos);

            //check wining strategy

            if (playerNewPos >= board.cells.length * board.cells.length-1) {
                winner = playerTurn;
            }
        }
        System.out.println("Winner is : "+ winner.id);
    }

    private Player findPlayerTurn(){
        Player playerTurn = players.removeFirst();
        players.addLast(playerTurn);
        return playerTurn;
    }

    private int checkJumps(int position){
        if(position > board.cells.length * board.cells.length-1)
            return position;
        Cell cell = board.getCell(position);
        if(cell.jump != null && cell.jump.start == position){
            String jumpBy = cell.jump.start < cell.jump.end ? "ladder" : "snake";
            System.out.println("jump done by: " + jumpBy);
            return cell.jump.end;
        }
        return position;
    }
}
