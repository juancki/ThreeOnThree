package com.juancarlosgomez.threeonthree;

import java.util.ArrayList;

/**
 * Created by Juancki on 31/3/15.
 */
public class Game {
    private ArrayList <Player> players;
    private Player winner;
    private Click  clicks [][][];
    public static final int dimension = 3;
    private int turn;

    public void incTurn(){
        turn++;
        if((turn)%players.size() == 0)
            turn = 0;
        return;
    }


    public Game() {
        this.clicks = new Click[dimension][dimension][dimension];
        this.players = new ArrayList<>();
        turn = 0;
    }

    public Player getPlayer(){
        return players.get(turn);
    }

    /*
        Constructor with one parameter, dimension, that determinate the size of each side.
        This parameter only can be 3 or 4.
         */
    public Game(int dimension) {
        this.clicks = new Click[this.dimension][this.dimension][this.dimension];
        this.players = new ArrayList<>();
        turn = 0;
    }

    /*
        Returns true if the move was possible. Returns false otherwise.
         */
    public boolean setMove(Position position, Player player){
        boolean can = true;
        for ( int i = 0 ; i < players.size();i++){
            can = can&&! players.get(i).getCube().getState(position);
        }
        if (can){
            player.getCube().setPosition(position,true);
            this.clicks[position.k][position.i][position.j]= player.getClick();
        }
        return can;
    }
    /*
    Create a new Dimension X Dimension X Dimension game.
     */
    private void resetAll (){
        clicks = null;
        players = null;
        winner = null;
    }
    /*
    This method returns true if the addition of the player was successful.
     */
    public boolean addPlayer (Player player){
        if (players.size()<4){
            players.add(player);
            return true;
        }
        return false;
    }


    public Click getClick(Position a){
        return clicks[a.k][a.i][a.j];
    }

    public int getTurn() {
        return this.turn;
    }
}
