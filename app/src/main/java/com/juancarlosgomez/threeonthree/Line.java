package com.juancarlosgomez.threeonthree;

/**
 * Created by Juancki on 28/3/15.
 */
public class Line {
    public Position a;
    public Position b;
    public Position c;
    private boolean inLine;
    
    
    public boolean isInLine() {
        return inLine = inLine(this);
    }
    
    
    public Line(Position a, Position b, Position c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.inLine = inLine(this);
    }
    
    private static boolean inLine(Line l){
        Position one = new Position(1,1,1);
        Position x = Position.sub(l.b, l.c);
        Position w = Position.sub(l.c,l.b);
        Position y = Position.sub(l.b,l.a);
        Position r = Position.sub(l.a,l.b);
        Position z = Position.sub(l.c,l.a);
        Position s = Position.sub(l.a,l.c);
        if ( x.equals(y) || x.equals(z)  || x.equals(r) || x.equals(s)|| y.equals(z) || y.equals(w)
            || y.equals(s)|| z.equals(w) || z.equals(r)){
            return true;
        }
        return false;
    }

}
