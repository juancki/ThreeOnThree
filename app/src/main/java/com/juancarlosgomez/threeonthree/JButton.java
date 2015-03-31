package com.juancarlosgomez.threeonthree;

import android.content.Context;
import android.widget.Button;

/**
 * Created by Juancki on 31/3/15.
 */
public class JButton extends Button {

    private int abscissa;
    private int ordered;

    public int getAbscissa() {
        return abscissa;
    }

    public int getOrdered() {
        return ordered;
    }

    public JButton(Context context,int x, int y) {
        super(context);
        this.abscissa = x;
        this.ordered = y;
    }

    public JButton(Context context) {
        super(context);
    }
}
