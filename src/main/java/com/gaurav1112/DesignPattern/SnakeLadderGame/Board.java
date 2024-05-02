package com.gaurav1112.DesignPattern.SnakeLadderGame;

import java.util.concurrent.ThreadLocalRandom;

public class Board {

    Cell[][] cells;
    Board(int size, int snakes, int ladders){
        intializeCells(size);
        addSnakesLadders(cells, snakes, ladders);
    }

    private void  intializeCells(int size){
        cells = new Cell[size][size];
        for (int i=0; i<size; i++)
            for(int j=0; j<size; j++){
                Cell obj = new Cell();
                cells[i][j] = obj;
            }
    }

    private void addSnakesLadders(Cell[][] cells, int snakes, int ladders){
        while (snakes > 0){
            int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length -1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length - 1);
            if (snakeHead <= snakeTail)
                continue;
            Jump snakeObj = new Jump();
            snakeObj.start = snakeHead;
            snakeObj.end = snakeTail;
            Cell obj = getCell(snakeHead);
            obj.jump = snakeObj;
            snakes--;
        }

        while (ladders > 0){
            int ladderHead = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length -1);
            int ladderTail = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length - 1);
            if (ladderTail < ladderHead)
                continue;
            Jump ladderobj = new Jump();
            ladderobj.start = ladderHead;
            ladderobj.end = ladderTail;
            Cell obj = getCell(ladderHead);
            obj.jump = ladderobj;
            ladders--;
        }
    }

    public Cell getCell(int ladderHead) {

        int boardRow = ladderHead / cells.length;
        int boardCol = ladderHead % cells.length;

        return cells[boardRow][boardCol];
    }
}
