package com.gaurav1112.DesignPattern.TicTacToe;

public class Player {

    String id;
    Peice peice;

    public Player(String id, Peice peice) {
        this.id = id;
        this.peice = peice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Peice getPeice() {
        return peice;
    }

    public void setPeice(Peice peice) {
        this.peice = peice;
    }
}
