package com.gaurav1112.DesignPattern.TicTacToe;

import java.util.*;

public class TicTacToeGame {

    Deque<Player> players;
    Board gameBoard;

    TicTacToeGame(){
        intializeGame();
    }
    public void intializeGame(){
        players = new LinkedList<>();
        PeiceX cross = new PeiceX(PeiceType.X);
        Player p1 = new Player("p1", cross);
        PeiceO naught = new PeiceO(PeiceType.O);
        Player p2 = new Player("p2", naught);
        players.add(p1);
        players.add(p2);
        gameBoard = new Board(3);
    }

    public String startGame() {
        boolean isWinner = true;
        while (isWinner) {
            Player pTurn = players.removeFirst();
            List<Pair<Integer, Integer>> freeSpace = gameBoard.getFreeCells();
            gameBoard.printBoard();
            if (freeSpace.isEmpty()) {
                isWinner = false;
                continue;
            }
            System.out.println("Player: " + pTurn.getId() + "Enter the row and col: ");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            String[] values = s.split(" ");
            int inputRow = Integer.valueOf(values[0]);
            int inputCol = Integer.valueOf(values[1]);
            boolean pieceAdd = gameBoard.addPeice(inputRow, inputCol, pTurn.getPeice());
            if (!pieceAdd) {
                System.out.println("Incorrect position .. Try again!!!");
                players.addFirst(pTurn);
                continue;
            }
            players.addLast(pTurn);
            boolean winner = isThereWinner(inputRow, inputCol, pTurn.getPeice().pType);
            if (winner) {
                gameBoard.printBoard();
                System.out.println("Winner is: "+ pTurn.id);
                return pTurn.getId();
            }
        }
        return "Tie";
    }

    private boolean isThereWinner(int inputRow, int inputCol, PeiceType pType) {

        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        for (int i=0; i< gameBoard.size; i++){
            if (gameBoard.board[inputRow][i] == null || gameBoard.board[inputRow][i].pType != pType)
                rowMatch = false;
            if(gameBoard.board[i][inputCol] == null || gameBoard.board[i][inputCol].pType != pType)
                colMatch = false;
        }

        for (int i=0, j=0; i<gameBoard.size ; i++, j++){
            if(gameBoard.board[i][j] == null || gameBoard.board[i][j].pType != pType)
                diagonalMatch = false;
        }

        for (int i=0, j=gameBoard.size-1; i< gameBoard.size; i++, j--){
            if(gameBoard.board[i][j] == null || gameBoard.board[i][j].pType != pType)
                antiDiagonalMatch = false;
        }
        return rowMatch || colMatch || diagonalMatch || antiDiagonalMatch;
    }


}
