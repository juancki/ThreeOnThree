package com.juancarlosgomez.threeonthree;

import android.graphics.Color;

/**
 * Created by Juancki on 31/3/15.
 */
public class Click {
    public ClickForm clickForm;
    private int color;
    public ClickColor clickColor;
	public static final String DEFAULT_1 = "DEFAULT_1";
	public static final String DEFAULT_2 = "DEFAULT_2";


	public Click() {
		clickColor = ClickColor.Transparent;
		clickForm  = ClickForm.None;
	}

	public Click(String s) {
	if (s.equals(DEFAULT_1)){
			clickColor =	ClickColor.Black;
			clickForm  =	ClickForm.Blade;
		}else if (s.equals(DEFAULT_2)){
			clickColor =	ClickColor.Black;
			clickForm  =	ClickForm.Circle;
		}

	}

	public Click(ClickColor clickColor, ClickForm clickForm) {
        this.clickColor = clickColor;
        this.clickForm = clickForm;
        switch (clickColor) {
            case Black:
                this.color = Color.BLACK;
                break;
            case White:
                this.color = Color.WHITE;
                break;
            case Gray:
                this.color = Color.GRAY;
                break;
            case Red:
                this.color = Color.RED;
                break;
            case Green:
                this.color = Color.GREEN;
                break;
            case Blue:
                this.color = Color.BLUE;
                break;
            case Cyan:
                this.color = Color.CYAN;
                break;
            case Pink:
                this.color = Color.rgb(255,20,147);
                break;
        }
    }

    public ClickColor getClickColor() {
        return clickColor;
    }

    public void setClickColor(ClickColor clickColor) {
        this.clickColor = clickColor;
    }

    public ClickForm getClickForm() {
        return clickForm;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setClickForm(ClickForm clickForm) {
        this.clickForm = clickForm;
    }
}
