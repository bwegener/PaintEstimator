package edu.orangecoastcollege.cs273.bwegener.paintestimator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


/**
 *
 * @author Brian Wegener
 * @version 1.0
 *
 * Created on 9/19/2017
 */
public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }

    protected void goToMain(View v)
    {
        // Construct an EXPLICIT Intent to go to HelpActivity
        // Intent: specify where to start (context) and where we're going (next Activity)
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);

    }
}
