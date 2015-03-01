package project3.cmpt276.ca.minions;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;
import android.util.Log;


// THE MATERIAL IS DEVELOPED BASED ON DR.FRASER YOUTUBE VIDEOS
public class MinionGameActivity extends MinionActivity {



    Button buttons [][] = new Button[MinionMenuActivity.myRowValue][MinionMenuActivity.myColValue];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minion_game);

        generateBoard(MinionMenuActivity.myRowValue, MinionMenuActivity.myColValue);


    }

    private void generateBoard(int x, int y) {

        TableLayout table = (TableLayout) findViewById(R.id.gameGrid);
        for (int row = 0; row < x; row++) {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,
                    1.0f));
            table.addView(tableRow);

            for (int col = 0; col < y; col++) {
                final int FINAl_COL = col;
                final int FINAL_ROW = row;

                Button button = new Button(this);
                button.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT,
                        1.0f));

                button.setPadding(0,0,0,0);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        gridButtonClicked(FINAl_COL,FINAL_ROW);
                    }
                });


                tableRow.addView(button);
                buttons[row][col] = button;

            }
        }
    }
    private void lockButtonSizes(){
        for(int row = 0 ; row < MinionMenuActivity.myRowValue; row++){
            for (int col = 0 ;col < MinionMenuActivity.myColValue ; col++){
                Button button = buttons[row][col];

                int width = button.getWidth();
                button.setMinWidth(width);
                button.setMaxWidth(width);

                int height = button.getHeight();
                button.setMinHeight(height);
                button.setMaxHeight(height);
            }
        }


    }
//
//
    private void gridButtonClicked(int col, int row){
//
        Button button = buttons[row][col];
        lockButtonSizes();
        int newWidth = button.getWidth();
        int newHeight = button.getHeight();
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.stickman);
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap,newWidth,newHeight,true);
        Resources resource = getResources();
        button.setBackground(new BitmapDrawable(resource,scaledBitmap));


    }


}
