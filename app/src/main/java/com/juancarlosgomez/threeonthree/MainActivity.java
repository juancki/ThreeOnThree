package com.juancarlosgomez.threeonthree;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity {
    private JButton btns[][];
    private Button button;
    private Button flatButtons[];
    private LinearLayout[] linearLayout;
    private Game game;
    private boolean gameStarted;
    private int currentFlat;


    public static void drawMove(Position position, Player player) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (gameStarted) {
            setCurrentFlat(currentFlat);
            drawFrame();
        } else {
            game = new Game(3);
            Player p1 = new Player(new Cube());
            Player p2 = new Player(new Cube());
            p1.setClick(new Click(ClickColor.Black, ClickForm.Blade));
            p1.setName("Hola");
            p2.setClick(new Click(ClickColor.Black, ClickForm.Circle));
            p2.setName("Mundo");
            game.addPlayer(p1);
            game.addPlayer(p2);
            createFrame();
            setCurrentFlat(1);
            gameStarted = true;
        }
    }

    private void setCurrentFlat(int i) {
        if (i > 0 && i <= game.dimension) {
            currentFlat = i;
            for (int j = 0; j < flatButtons.length; j++) {
                if (j == i - 1) {
                    flatButtons[j].setTextColor(Color.BLACK);
                } else
                    flatButtons[j].setTextColor(Color.GRAY);
            }
            drawFrame();
        } else {
            setCurrentFlat(1);
        }

    }

    private void drawFrame() {
        resetGrid();
        for (int i = 0; i < game.dimension; i++) {
            for (int j = 0; j < game.dimension; j++) {
                try {
                    ClickForm cf = (ClickForm) game.getClick(new Position(i, j, currentFlat - 1)).getClickForm();
                    switch (cf) {
                        case Triangle:
                            btns[i][j].setText("∆");
                            break;
                        case Square:
                            btns[i][j].setText("▢");
                            break;
                        case Blade:
                            btns[i][j].setText("X");
                            break;
                        case Circle:
                            btns[i][j].setText("○");
                            break;
                    }
                } catch (Exception e) {

                }
            }
        }

    }

    public void setFirstFlat(View view) {
        setCurrentFlat(1);

    }

    public void setSecondFlat(View view) {
        setCurrentFlat(2);

    }

    public void setThirdFlat(View view) {
        setCurrentFlat(3);

    }

    private void setPosition(JButton jButton) {
        int i = jButton.getAbscissa();
        int j = jButton.getOrdered();
        ClickForm cf = game.getPlayer().getClick().getClickForm();
        if(game.setMove(new Position(i,j,currentFlat-1),game.getPlayer())){
            switch (cf) {
                case Triangle:
                    btns[i][j].setText("∆");
                    break;
                case Square:
                    btns[i][j].setText("▢");
                    break;
                case Blade:
                    btns[i][j].setText("X");
                    break;
                case Circle:
                    btns[i][j].setText("○");
                    break;
            }
            game.incTurn();
        }
    }

    private void resetGrid() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                btns[i][j].setText("");
            }
        }
    }

    public void resetGame(View view) {
        game = new Game(game.dimension);
        resetGrid();
        setCurrentFlat(1);
    }

    public void createFrame() {
        button = (Button) findViewById(R.id.button);
        linearLayout = new LinearLayout[3];
        linearLayout[0] = (LinearLayout) findViewById(R.id.linearLayout1);
        linearLayout[1] = (LinearLayout) findViewById(R.id.linearLayout2);
        linearLayout[2] = (LinearLayout) findViewById(R.id.linearLayout3);
        flatButtons = new Button[3];
        flatButtons[0] = (Button) findViewById(R.id.firstFlat);
        flatButtons[1] = (Button) findViewById(R.id.secondFlat);
        flatButtons[2] = (Button) findViewById(R.id.thirdFlat);

        String s = "btn";
        btns = new JButton[3][3];
        for (int i = 0; i < linearLayout.length; i++) {
            for (int j = 0; j < 3; j++) {
                btns[i][j] = new JButton(button.getContext(), i, j);
                btns[i][j].setText(s + i + "" + j);
                btns[i][j].setVisibility(View.VISIBLE);
                btns[i][j].setEnabled(true);
                btns[i][j].setClickable(true);
                btns[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        JButton btn = (JButton) v;
                        setPosition(btn);
                    }
                });
                linearLayout[i].addView(btns[i][j]);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
