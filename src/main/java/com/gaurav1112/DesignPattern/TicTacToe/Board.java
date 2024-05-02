package com.gaurav1112.DesignPattern.TicTacToe;

import java.util.ArrayList;
import java.util.List;

public class Board {

    int size;
    Peice[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new Peice[size][size];
    }

    public boolean addPeice(int row, int col, Peice peice){
        if (board[row][col] != null)
            return false;
        board[row][col] = peice;
        return true;
    }

    public List<Pair<Integer, Integer>> getFreeCells(){

        List<Pair<Integer, Integer>> freeSpace = new ArrayList<>();
        for (int i=0; i<size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    Pair<Integer, Integer> rowCol = new Pair<>(i, j);
                    freeSpace.add(rowCol);
                }
            }
        }
        return freeSpace;
    }

    public void printBoard() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].pType.name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();

        }
    }

}
