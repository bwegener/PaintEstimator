package edu.orangecoastcollege.cs273.bwegener.paintestimator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.text.DecimalFormat;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 *
 * @author Brian Wegener
 * @version 1.0
 *
 * Created on 9/19/2017.
 */
public class MainActivity extends AppCompatActivity {

    DecimalFormat tenDP = new DecimalFormat("#.0");

    // Member variables for the Views
    private EditText mLengthEditText;
    private EditText mHeightEditText;
    private EditText mWidthEditText;

    private EditText mDoorsEditText;
    private EditText mWindowsEditText;

    private TextView mGallonsTextView;

    // Member variable for the Model
    private InteriorRoom mRoom = new InteriorRoom();

    // Member variable for SharedPreferences
    private SharedPreferences mPrefs;

    private void initializeViews() {
        mLengthEditText = (EditText) findViewById(R.id.lengthEditText);
        mHeightEditText = (EditText) findViewById(R.id.heightEditText);
        mWidthEditText = (EditText) findViewById(R.id.widthEditText);
        mDoorsEditText = (EditText) findViewById(R.id.doorsEditText);
        mWindowsEditText = (EditText) findViewById(R.id.windowsEditText);
        mGallonsTextView = (TextView) findViewById(R.id.gallons);
    }

    private void loadSharedPreferences() {
        mPrefs = getSharedPreferences("edu.orangecoastcollege.cs273.bwegener.PaintEstimator", MODE_PRIVATE);
        if (mPrefs != null) {
            // Load all the room information
            mRoom.setDoors(mPrefs.getInt("doors", 0));
            mDoorsEditText.setText(String.valueOf(mRoom.getDoors()));

            mRoom.setWindows(mPrefs.getInt("windows", 0));
            mWindowsEditText.setText(String.valueOf(mRoom.getWindows()));

            mRoom.setLength(mPrefs.getFloat("length", 0.0f));
            mLengthEditText.setText(String.valueOf(mRoom.getLength()));

            mRoom.setHeight(mPrefs.getFloat("height", 0.0f));
            mHeightEditText.setText(String.valueOf(mRoom.getHeight()));

            mRoom.setWidth(mPrefs.getFloat("width", 0.0f));
            mWidthEditText.setText(String.valueOf(mRoom.getWidth()));
        }
    }

    // This recalls info from the time the app previously launched
    private void saveSharedPreferences() {
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.clear();
        editor.putFloat("length", mRoom.getLength());
        editor.putFloat("height", mRoom.getHeight());
        editor.putFloat("width", mRoom.getWidth());
        editor.putInt("doors", mRoom.getDoors());
        editor.putInt("windows", mRoom.getWindows());

        // Save the changes to the SharedPreferences file
        editor.commit();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        loadSharedPreferences();
    }

    protected void computeGallons(View v) {
        // Update model first, then calculate
        mRoom.setLength(Float.parseFloat(mLengthEditText.getText().toString()));
        mRoom.setHeight(Float.parseFloat(mHeightEditText.getText().toString()));
        mRoom.setWidth(Float.parseFloat(mWidthEditText.getText().toString()));
        mRoom.setDoors(Integer.parseInt(mDoorsEditText.getText().toString()));
        mRoom.setWindows(Integer.parseInt(mWindowsEditText.getText().toString()));

        if (mRoom.totalSurfaceArea() < 1)
            mGallonsTextView.setText("Interior surface area: 0 feet\nGallons needed: 0");
        else if (mRoom.totalSurfaceArea() >= 1 && mRoom.totalSurfaceArea() < 2)
            mGallonsTextView.setText(getString(R.string.interior_surface_area) + " " + tenDP.format(mRoom.totalSurfaceArea()) +
                    " foot\n" + getString(R.string.gallons_needed) + " " + tenDP.format(mRoom.gallonsOfPaintRequired()));
        else
            mGallonsTextView.setText(getString(R.string.interior_surface_area) + " " + tenDP.format(mRoom.totalSurfaceArea()) +
                    " feet\n" + getString(R.string.gallons_needed) + " " + tenDP.format(mRoom.gallonsOfPaintRequired()));

        // This happens when the compute gallons button is clicked
        saveSharedPreferences();


    }

    protected void goToHelp(View v) {

        String paintRequired = "Estimated Paint Required: " + tenDP.format(mRoom.gallonsOfPaintRequired());

        // Construct an EXPLICIT Intent to go to HelpActivity
        // Intent: specify where to start (context) and where we're going (next Activity)
        Intent launchHelpActivity = new Intent(this, HelpActivity.class);

        launchHelpActivity.putExtra("gallons", paintRequired);

        startActivity(launchHelpActivity);
    }
}
