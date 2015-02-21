package project3.cmpt276.ca.minions;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MinionOptionActivity extends MinionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minion_option);




        Button doneBtn = (Button)findViewById(R.id.btnBackHome);
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText rowNum = (EditText)findViewById(R.id.rowValue);
                EditText colNum = (EditText)findViewById(R.id.colValue);

                String rowNumString = rowNum.getText().toString();
                int rowNumInteger = Integer.parseInt(rowNumString);

                String colNumString = colNum.getText().toString();
                int colNumInteger = Integer.parseInt(colNumString);

                Intent intent = new Intent(MinionOptionActivity.this, MinionMenuActivity.class);
                intent.putExtra("rowValueInt", rowNumInteger);
                intent.putExtra("colValueInt", colNumInteger);

                startActivity(intent);
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
