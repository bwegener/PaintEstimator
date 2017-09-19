package edu.orangecoastcollege.cs273.bwegener.paintestimator;

/**
 *
 *
 * Created on 9/19/2017.
 */

public class InteriorRoom {

    public static final float DOOR_AREA = 21f;
    public static final float WINDOW_AREA = 16f;
    public static final float SQ_FEET_PER_GALLON = 275f;

    private float mLength;
    private float mHeight;
    private float mWidth;
    private int mDoors;
    private int mWindows;

    public float getLength() {
        return mLength;
    }

    public void setLength(float length) {
        mLength = length;
    }

    public float getHeight() {
        return mHeight;
    }

    public void setHeight(float height) {
        mHeight = height;
    }

    public float getWidth() {
        return mWidth;
    }

    public void semWidth(float width) {
        mWidth = width;
    }

    public int getDoors() {
        return mDoors;
    }

    public void setDoors(int doors) {
        mDoors = doors;
    }

    public int getWindows() {
        return mWindows;
    }

    public void setWindows(int windows) {
        mWindows = windows;
    }

    public float doorAndWindowArea()
    {
        return mDoors * DOOR_AREA + mWindows * WINDOW_AREA;
    }

    public float wallSurfaceArea()
    {
        return 2 * mLength * mHeight + 2 * mWidth * mHeight + mLength * mWidth;
    }

    public float totalSurfaceArea()
    {
        return wallSurfaceArea() - doorAndWindowArea();
    }

    public float gallonsOfPaintRequired()
    {
        return totalSurfaceArea() / SQ_FEET_PER_GALLON;
    }
}
