package ru.samsung.itschool.book.cells;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;

import task.Stub;

public class CellsActivity extends AppCompatActivity {

    private final Context context = this;

    private int width = 10;
    private int height = 10;

    private Button[][] cells;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cells);
        makeCells();
        generate();
    }

    void generate() {
        int num = 1;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cells[i][j].setText(num + "");
                num++;

            }
        }
    }


    int getX(View v) {
        return Integer.parseInt(((String) v.getTag()).split(",")[1]);
    }

    int getY(View v) {
        return Integer.parseInt(((String) v.getTag()).split(",")[0]);
    }

    void makeCells() {
        cells = new Button[height][width];
        GridLayout cellsLayout = (GridLayout) findViewById(R.id.CellsLayout);
        cellsLayout.removeAllViews();
        cellsLayout.setColumnCount(width);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                cells[i][j] = (Button) inflater.inflate(R.layout.cell, cellsLayout, false);
                cells[i][j].setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Button tappedCell = (Button) v;

                        int tappedX = getX(tappedCell);
                        int tappedY = getY(tappedCell);

                        for (int x = 0; x < width; x++) {
                            cells[tappedY][x].setBackgroundColor(Color.RED);
                        }
                        for (int y = 0; y < height; y++) {
                            cells[y][tappedX].setBackgroundColor(Color.RED);
                        }
                    }
                });
                cells[i][j].setOnLongClickListener(new OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        return false;
                    }
                });
                cells[i][j].setTag(i + "," + j);
                cellsLayout.addView(cells[i][j]);
            }
        }
    }
}