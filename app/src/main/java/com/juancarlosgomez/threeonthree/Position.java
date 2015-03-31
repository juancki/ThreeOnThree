package com.juancarlosgomez.threeonthree;

/**
 * Created by Juancki on 28/3/15.
 */
public class Position {
    public int i;
    public int j;
    public int k;
    private double modulo;
    private static final int MAX_NUMBER = 2;
    private static final int MIN_NUMBER = 0;
    public Position(int i, int j, int k) {
        if (i <= MAX_NUMBER && i >= MIN_NUMBER) {
            this.i = i;
        } else {
            System.out.println("Error to set position " + i);
            i = 0;
        }
        if (j <= MAX_NUMBER && j >= MIN_NUMBER) {
            this.j = j;
            
        } else{
            System.out.println("Error to se position " + j);
            j = 0;
        }
        if (k<=MAX_NUMBER&& k>=MIN_NUMBER) {
            this.k = k;
        }else{
            System.out.println("Error to set position "+ k);
            k=0;
        }
        this.setModulo();
    }
    
    public Position (){
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.modulo = 0;
    }
    /*
    This method return the addition, component by component, of a and b
     */
    public static Position add(Position a, Position b){
        Position c = new Position();
        c.i = a.i + b.i;
        c.j = a.j + b.j;
        c.k = a.k + b.k;
        c.setModulo();
        return c;
    }
    /*
    This method returns the subtract, component by component, of 'a - b'.
     */
    public static Position sub(Position a, Position b){
        Position c = new Position();
        c.i = a.i - b.i;
        c.j = a.j - b.j;
        c.k = a.k - b.k;
        c.setModulo();
        return c;
    }
    
    private void setModulo(){
        double f = 0;
        f = Math.sqrt(this.i*this.i + this.j*this.j + this.k*this.k);
        this.modulo = f;
    }
    public double getModulo(){
        setModulo();
        return modulo;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        if (i != position.i) return false;
        if (j != position.j) return false;
        if (k != position.k) return false;
        return true;
    }
}
