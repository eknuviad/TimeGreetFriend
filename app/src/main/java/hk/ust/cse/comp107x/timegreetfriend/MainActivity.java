package hk.ust.cse.comp107x.timegreetfriend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    Button greetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get a reference to the greetButton on the UI
        greetButton = (Button) findViewById(R.id.greetButton);
        // Set the onClickListener for the greetButton to be this class.
        // This requires that the class implement the View.OnClickListener callback
        // the onClick() method
        greetButton.setOnClickListener(this);
    }

    public String getString( ) {
        //get the present hour of the day
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);

    //check the hour conditions and return appropriate greeting
        if ((hour >= 6) && (hour < 12)) {
           return  "Good Morning ";

        }
        if ((hour >= 12) && (hour < 17)) {
            return "Good Afternoon ";

        }
        if ((hour >= 17) && (hour < 21))
            return "Good Evening ";

        else
            return "Good Night ";


    }

    @Override
    public void onClick(View v) {

        // get a reference to the TextView on the UI
        TextView textMessage = (TextView) findViewById(R.id.textMessage);

        //get a reference to the EditText so that we can read in the value typed
        // by the user
        EditText editFriendName = (EditText) findViewById(R.id.editFriendName);

        // get the name of the friend typed in by the user in the EditText field
        String friendName = editFriendName.getText().toString();


        switch (v.getId()) {

            case R.id.greetButton:
                // set the string being displayed by the TextView to the greeting
                // message for the friend
                textMessage.setText(getString() + friendName + "!");
                break;

            default:
                break;
        }
    }
}
