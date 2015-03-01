package project3.cmpt276.ca.minions;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class MinionOptionActivity extends MinionActivity {

    private Spinner sp1;
    private Spinner sp2;
    private int rowNumber;
    private int colNumber;
    private int minionsNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minion_option);

        makeBoardSpinnerBar();
        addListenerToBoardSpinner();
        makeMinionsNumBar();
        addListenerToMinionBar();



        Button doneBtn = (Button)findViewById(R.id.btnBackHome);
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String boardGrid = String.valueOf(sp1.getSelectedItem());
                if(boardGrid.equals("4x6")){
                    rowNumber = 4;
                    colNumber = 6;

                }
                else if(boardGrid.equals("3x4")){
                    rowNumber = 3;
                    colNumber = 4;
                }
                else{
                    rowNumber = 8;
                    colNumber = 12;
                }
                String NumberOfGivenMinions = sp2.getSelectedItem().toString().trim();
                if(NumberOfGivenMinions.equals("6")){
                    minionsNumber = 6;
                }
                else if(NumberOfGivenMinions.equals("10")){
                    minionsNumber = 10;
                }
                else if(NumberOfGivenMinions.equals("15")){
                    minionsNumber = 15;
                }
                else{
                    minionsNumber = 20;
                }

                if (boardGrid.equals("3x4") && (NumberOfGivenMinions.equals("15")||NumberOfGivenMinions.equals("20"))){

                    Toast.makeText(getApplicationContext(), "This Combination is not possible. Choose another one",
                            Toast.LENGTH_LONG).show();

                }
                else{
                    Intent intent = new Intent(MinionOptionActivity.this, MinionMenuActivity.class);
                    intent.putExtra("rowValueInt", rowNumber);
                    intent.putExtra("colValueInt", colNumber);
                    intent.putExtra("NumberOfMinions", minionsNumber);

                    startActivity(intent);

                }
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
   private void  makeMinionsNumBar(){
       sp2 = (Spinner) findViewById(R.id.minions_num);
// Create an ArrayAdapter using the string array and a default spinner layout
       ArrayAdapter<CharSequence> boardSizes = ArrayAdapter.createFromResource(this,
               R.array.minNum, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
       boardSizes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
       sp2.setAdapter(boardSizes);


   }

    private void addListenerToMinionBar(){
        sp2=(Spinner) findViewById(R.id.minions_num);
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
