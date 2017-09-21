package edu.orangecoastcollege.cs273.bwegener.paintestimator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


/**
 * The Help Activity is where the help note is explained as well
 * as getting info from the main activity and displaying
 * the amount of gallons needed
 *
 * @author Brian Wegener
 * @version 1.0
 *
 * Created on 9/19/2017
 */
public class HelpActivity extends AppCompatActivity {

    private TextView mPaintRequired;

    /**
     * The onCreate for the Help Activity brings the amount of paint required
     * from the Main Activity over and displays it.
     *
     * @param savedInstanceState this is what happens every time the app is loaded.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        // Receive the Intent (from MainActivity)
        Intent intentFromMain = getIntent();
        String paintRequired = intentFromMain.getStringExtra("gallons");

        // Populate text view
        mPaintRequired = (TextView) findViewById(R.id.paintRequired);

        // Fill your TextView with data from the paint required
        mPaintRequired.setText(paintRequired);
    }

    /**
     * This allows the user to return to the Main Activity.
     *
     * @param v this calls the view from Main Activity.
     */
    protected void goToMain(View v)
    {
        // Construct an EXPLICIT Intent to go to HelpActivity
        // Intent: specify where to start (context) and where we're going (next Activity)
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);

    }
}
