package com.juancarlosgomez.threeonthree;

/**
 * Created by Juancki on 30/3/15.
 */
public class Cube {
    private int dimension;
    private boolean cube[][][];
    private boolean last_cube [][][];

    public Cube(int dimension) {
        if (dimension==3||dimension==4)
            this.dimension = dimension;
        else
            dimension = 3;
        cube =new boolean [dimension][dimension][dimension];
        last_cube =new boolean [dimension][dimension][dimension];
        CLEARALL();
        last_cube = cube.clone();
    }

    public Cube() {
        dimension = 3;
        cube =new boolean [dimension][dimension][dimension];
        last_cube =new boolean [dimension][dimension][dimension];
        CLEARALL();
        last_cube = cube.clone();
    }

    /*
             this function return true if the set of the position was successful,
             and return false if the position was set before. In any case after the call
             of the method the position will be on.
             */
    public boolean setPosition(int x,int y, int z){
        if (cube[z][x][y]){
            return false;
        }
        last_cube = cube.clone();
        cube[z][x][y] = true;
        return true;
    }
    /*
        puts the boolean to the position.
     */
    public void setPosition(Position a, boolean on){
        last_cube = cube.clone();
        if(on){
            setPosition(a.i,a.j,a.k);
        } else {
            clearPosition(a.i,a.j,a.k);
        }
    }
    /*
 this function return true if the set of the position was successful,
 and return false if the position was set before. In any case after the call
 of the method the position will be on.
 */
    public boolean setPosition(Position a){
        last_cube = cube.clone();
        return setPosition(a.k,a.i,a.j);
    }
    /*
     this function return true if the clear of the position was successful,
     and return false if the position was clear before.
     */
    public boolean clearPosition(int x, int y, int z){
        if (!cube[z][x][y]){
            return false;
        }
        last_cube = cube.clone();
        cube[z][x][y] = false;
        return true;
    }

    public void CLEARALL(){
        last_cube = cube;
        for(int i = 0; i <dimension; i++ ){
            for (int j = 0; j<dimension; j++ ){
                for (int k=0; k<dimension; k++) {
                    cube[i][j][k] = false;
                }
            }
        }
    }
	/*
	For to do.
	 */
    public boolean is3inLine(){

        return false;
    }

    private boolean isLineOk(Line line){
		return line.isInLine() && (getState(line.a) && getState(line.b) && getState(line.c));
	}

    public boolean getState(Position a){
        return cube[a.k][a.i][a.j];
    }

    public boolean getState(int i, int j , int k){
        return cube[k][i][j];
    }

    private void return_LastCube(){
        this.cube  = this.last_cube.clone();
    }

    public int getDimension() {
        return dimension;
    }

    public boolean [][] get2D(int z){
        return cube[z].clone();
    }

    @Override
    public String toString(){
        String s = "";
        for(int k = 0 ; k <dimension; k ++){
            for (int i = 0; i <dimension;i++) {
                for (int j = 0; j < dimension; j++) {
                    s += cube[k][i][j];
                }
                s +='\n';
            }
            s +='\n';
        }
        return s;
    }

}
