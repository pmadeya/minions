package project3.cmpt276.ca.minions;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;



public class MinionOptionActivity extends MinionActivity {

    private Spinner sp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minion_option);
        makeBoardSpinnerBar();
        addListenerToBoardSpinner();



        Button doneBtn = (Button)findViewById(R.id.btnBackHome);
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(MinionOptionActivity.this, MinionMenuActivity.class);
                //intent.putExtra("rowValueInt", rowNumInteger);
                //intent.putExtra("colValueInt", colNumInteger);

                startActivity(intent);
            }
        });




    }

    private void makeBoardSpinnerBar(){
        sp1 = (Spinner) findViewById(R.id.board_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> boardSizes = ArrayAdapter.createFromResource(this,
                R.array.sizeOfBoard, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        boardSizes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        sp1.setAdapter(boardSizes);

    }


    private void addListenerToBoardSpinner(){
        sp1=(Spinner) findViewById(R.id.board_spinner);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String itemU3=parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_minion_option, menu);
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
