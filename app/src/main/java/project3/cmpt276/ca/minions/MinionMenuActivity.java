package project3.cmpt276.ca.minions;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MinionMenuActivity extends MinionActivity {

    private int myRowValue;
    private int myColValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minion_menu);

        chooseActivityFromMainMenu();
        Intent in = getIntent();
        myRowValue = in.getIntExtra("rowValueInt", 0);


        Intent in2 = getIntent();
        myColValue = in2.getIntExtra("colValueInt",0);


    }



    private void chooseActivityFromMainMenu() {

        Button playGame = (Button) findViewById(R.id.btnPlayGame);
        Button optionMenu = (Button) findViewById(R.id.btnOption);
        Button helpMenu = (Button) findViewById(R.id.btnHelp);

        playGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MinionMenuActivity.this, MinionGameActivity.class);
                intent.putExtra("finalRow",myRowValue);
                intent.putExtra("finalCol",myColValue);
                startActivity(intent);

            }
        });

        optionMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MinionMenuActivity.this, MinionOptionActivity.class));

            }
        });

        helpMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MinionMenuActivity.this, MinionHelpActivity.class ));
            }
        });

    }





        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_minion_menu, menu);
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
