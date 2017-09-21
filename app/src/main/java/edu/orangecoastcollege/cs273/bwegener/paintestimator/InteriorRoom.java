package edu.orangecoastcollege.cs273.bwegener.paintestimator;

/**
 * This handles the room's length, width, height, doors, and windows,
 * as well as the calculations for the wall surface area, total surface area,
 * door and window area, and gallons of paint required.
 *
 * @author Brian Wegener
 * @version 1.0
 *
 * Created on 9/19/2017.
 */

public class InteriorRoom {

    /**
     * This the area of a door.
     */
    public static final float DOOR_AREA = 21f;

    /**
     * This is the area of a window.
     */
    public static final float WINDOW_AREA = 16f;

    /**
     * This is the square footage that one gallon of paint can cover.
     */
    public static final float SQ_FEET_PER_GALLON = 275f;

    private float mLength;
    private float mHeight;
    private float mWidth;
    private int mDoors;
    private int mWindows;

    /**
     * This gets the length from what the user has entered.
     *
     * @return the length of the room.
     */
    public float getLength() {
        return mLength;
    }

    /**
     * This sets the length when the user enters it.
     *
     * @param length this is the length that the user enters.
     */
    public void setLength(float length) {
        mLength = length;
    }

    /**
     * This gets the height from what the user has entered.
     *
     * @return the height of the room.
     */
    public float getHeight() {
        return mHeight;
    }

    /**
     * This sets the height when the user enters it.
     *
     * @param height this is the height that the user enters.
     */
    public void setHeight(float height) {
        mHeight = height;
    }

    /**
     * This gets the width from what the user has entered.
     *
     * @return the width of the room.
     */
    public float getWidth() {
        return mWidth;
    }

    /**
     * This sets the width when the user enters it.
     *
     * @param width this is width that the user enters.
     */
    public void setWidth(float width) {
        mWidth = width;
    }

    /**
     * This gets the amount of doors from what the user has entered.
     *
     * @return the amount of doors.
     */
    public int getDoors() {
        return mDoors;
    }

    /**
     * this sets the amount of doors when the user enters the amount.
     *
     * @param doors this is the amount of doors that the user enters.
     */
    public void setDoors(int doors) {
        mDoors = doors;
    }

    /**
     * This gets the amount of windows that the user has entered.
     *
     * @return the amount of windows.
     */
    public int getWindows() {
        return mWindows;
    }

    /**
     * This sets the amount of windows when the user enters the amount.
     *
     * @param windows this is the amount of windows that the user enters.
     */
    public void setWindows(int windows) {
        mWindows = windows;
    }

    /**
     * This is the calculation for the space (area) that the doors and windows occupy.
     *
     * @return area taken up by door(s) and window(s).
     */
    public float doorAndWindowArea()
    {
        return mDoors * DOOR_AREA + mWindows * WINDOW_AREA;
    }

    /**
     * This is the calculation that finds the surface area of the wall.
     *
     * @return the surface area of the wall.
     */
    public float wallSurfaceArea()
    {
        return 2 * mLength * mHeight + 2 * mWidth * mHeight + mLength * mWidth;
    }

    /**
     * This is the calculation for the total surface area of the room, subtracting the
     * space that the doors and windows occupy.
     *
     * @return the total surface area of the room.
     */
    public float totalSurfaceArea()
    {
        return wallSurfaceArea() - doorAndWindowArea();
    }

    /**
     * This gets the gallon of paints required to cover the total surface area of the room.
     *
     * @return the gallon of paints required to paint the room.
     */
    public float gallonsOfPaintRequired()
    {
        return totalSurfaceArea() / SQ_FEET_PER_GALLON;
    }
}
