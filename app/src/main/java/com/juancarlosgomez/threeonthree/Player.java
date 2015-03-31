package com.juancarlosgomez.threeonthree;

import android.graphics.Color;

/**
 * Created by Juancki on 31/3/15.
 */
public class Player {
    private Cube cube;
    private Color color;
    private Click click;
    private String name;


    public Player(Cube cube) {
        this.cube = cube;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Click getClick() {
        return click;
    }

    public void setClick(Click click) {
        this.click = click;
    }

    public void setCube(Cube cube) {
        this.cube = cube;
    }

    public Cube getCube() {
        return cube;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

}
