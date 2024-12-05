/****************************************************************************
 *                           assignment 5 Side                              *
 *    Programmer:       Aidan Campbell                                      *
 *    Course:           CS201                                               *
 *    Date:             3/13/2024                                           *
 *    Requirement:      assignment 5                                        *
 *                                                                          *
 *    Description: List of Pieces and actions with them                     *
 *                                                                          *
 *    COPYRIGHT: This code is copyright (C) 2023 Aidan Campbell             *
 *    and Dean Zeller.                                                      *
 *                                                                          *
 *                                                                          *
 *    Credits:  help with syntax and little stuff from ChatGPT              *
 *                                                                          *
 *                                                                          *
 ***************************************************************************/
import java.util.ArrayList;

public class Side
{
    ArrayList<Piece> Side = new ArrayList<Piece>();
    /****************************************************************************
     *                                                                          *
     *    Method:           add()                                               *
     *    DESCRIPTION:      Add a Die to the Dice array                         *
     *    PARAMETERS:       Piece t                                             *
     *    Return value:     None                                                *
     ****************************************************************************/
    public void add(Piece t)
    {
        Side.add(t);
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           getColors()                                         *
     *    DESCRIPTION:      returns the current color of the piece              *
     *    PARAMETERS:       None                                                *
     *    Return value:     Array<String> currentValue                          *
     ****************************************************************************/
    public ArrayList<String> getColors()
    {
        ArrayList<String> currentColors = new ArrayList<>();
        for (Piece i : Side)
        {
            currentColors.add(i.getColor());
        }
        return currentColors;
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           getColor()                                          *
     *    DESCRIPTION:      returns a specific color in piece list              *
     *    PARAMETERS:       int n                                               *
     *    Return value:     String color                                        *
     ****************************************************************************/
    public String getColor(int n)
    {
        ArrayList<String> CurrentColors = new ArrayList<>();
        for (Piece i : Side)
        {
            CurrentColors.add(i.getColor());
        }
        if(n >= 0 && n < CurrentColors.size())
        {
            return CurrentColors.get(n);
        }
        else
        {
            System.out.println("Not in the list print error to show");
            return "Error";
        }
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           getColors()                                         *
     *    DESCRIPTION:      returns the current Location of the piece           *
     *    PARAMETERS:       None                                                *
     *    Return value:     Array<Int> currentValue                             *
     ****************************************************************************/
    public ArrayList<Integer> getLocations()
    {
        ArrayList<Integer> locationGot = new ArrayList<>();
        for (Piece i : Side)
        {
            locationGot.add(i.getLocation());
        }
        return locationGot;
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           getlocation()                                         *
     *    DESCRIPTION:      returns a specific color in piece list              *
     *    PARAMETERS:       int n                                               *
     *    Return value:     int location                                        *
     ****************************************************************************/
    public Integer getlocation(int n)
    {
        ArrayList<Integer> SingleLoc = new ArrayList<>();
        for (Piece i : Side)
        {
            SingleLoc.add(i.getLocation());
        }
        if(n >= 0 && n < SingleLoc.size())
        {
            return SingleLoc.get(n);
        }
        else
        {
            System.out.println("Not in the list print -1 to show the error");
            return -1;
        }
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           setColor()                                          *
     *    DESCRIPTION:      can change the current Suit                         *
     *    PARAMETERS:       int n, String color, int sCode                      *
     *    Return value:     none                                                *
     ****************************************************************************/
    public void setColor(int n, String color, int sCode)
    {
        if (n >= 0 && n < Side.size())
        {
            if (sCode == 1234)
            {
                        Side.get(n).setColor(color, sCode);
            }
            else
            {
                System.out.println("Security code wrong");
            }
        }
        else
        {
            System.out.println("Number given is not a piece in the List");
        }
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           setLocation()                                       *
     *    DESCRIPTION:      can change the current Suit                         *
     *    PARAMETERS:       int n, int Spot, int sCode                          *
     *    Return value:     none                                                *
     ****************************************************************************/
    public void setLocation(int n, int Spot, int sCode)
    {
        if (n >= 0 && n < Side.size())
        {
            if (sCode == 1234)
            {
                Side.get(n).setLocation(Spot, sCode);
            }
            else
            {
                System.out.println("Security code wrong");
            }
        }
        else
        {
            System.out.println("Number given is not a piece in the List");
        }
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           toString()                                          *
     *    DESCRIPTION:      change int to a string for easier print             *
     *    PARAMETERS:       None                                                *
     *    Return value:     String  NewString                                   *
     ****************************************************************************/
    public String toString()
    {
        ArrayList<String> NewString = new ArrayList<String>();
        for (Piece i : Side)
        {
            NewString.add(i.toString());
        }
        //Got help with this bottom return statement
        return String.join(" ", NewString);
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           printSummary()                                      *
     *    DESCRIPTION:      Prints a table of info for the Hand                 *
     *    PARAMETERS:       None                                                *
     *    Return value:     None                                                *
     ****************************************************************************/
    public void printSummary()
    {
        System.out.printf(" %-10s  %-10s  %-10s \n", "Piece", "Color", "Location");
        int Piece = 1;
        for (Piece i : Side)
        {
            System.out.printf(" %-10d  %-10s  %-10d \n", Piece++, i.getColor(), i.getLocation());
        }
    }
}
