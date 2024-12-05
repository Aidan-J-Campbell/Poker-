/****************************************************************************
 *                           assignment 5 dice                              *
 *    Programmer:       Aidan Campbell                                      *
 *    Course:           CS201                                               *
 *    Date:             3/13/2024                                           *
 *    Requirement:      assignment 5                                        *
 *                                                                          *
 *    Description: List of die                                              *
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

public class Dice
{
    ArrayList<Die> Dice = new ArrayList<Die>();
    int currentValue;
    /****************************************************************************
     *                                                                          *
     *    Method:           add(Die d)                                          *
     *    DESCRIPTION:      Add a Die to the Dice array                         *
     *    PARAMETERS:       None                                                *
     *    Return value:     None                                                *
     ****************************************************************************/
    public void add(Die d)
    {
       Dice.add(d);
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           getCurrentValue()                                   *
     *    DESCRIPTION:      returns the current value in a list                 *
     *    PARAMETERS:       None                                                *
     *    Return value:     Array<INT> currentValue                             *
     ****************************************************************************/
    public ArrayList<Integer> GetCurrentValues()
    {
        ArrayList<Integer> currentValues = new ArrayList<>();
        for (Die i : Dice)
        {
            currentValues.add(i.getCurrentValue());
        }
        return currentValues;
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           getCurrentValue()                                   *
     *    DESCRIPTION:      returns a specific die in Dice list                 *
     *    PARAMETERS:       int n                                               *
     *    Return value:     int currentValue                                    *
     ****************************************************************************/
    public int getCurrentValue(int n)
    {
        ArrayList<Integer> CurrentValues = new ArrayList<>();
        for (Die i : Dice)
        {
            CurrentValues.add(i.getCurrentValue());
        }
        if(n >= 0 && n < CurrentValues.size())
        {
            return CurrentValues.get(n);
        }
        else
        {
            System.out.println("Number to get the current value is not in range. -1 printed out to show error");
            return -1;
        }
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           roll()                                              *
     *    DESCRIPTION:      Roll all Die and get a random int                   *
     *    PARAMETERS:       None                                                *
     *    Return value:     None                                                *
     ****************************************************************************/
    public void roll()
    {
        for (Die i : Dice)
        {
            i.roll();
        }
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           roll()                                              *
     *    DESCRIPTION:      Roll a die and get a random int                     *
     *    PARAMETERS:       int n                                               *
     *    Return value:     None                                                *
     ****************************************************************************/
    public void roll(int n)
    {
        if (n >= 0 && n < Dice.size())
        {
            Dice.get(n).roll();
        }
        else
        {
            System.out.println("Invalid die.");
        }
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           setCurrentValue()                                   *
     *    DESCRIPTION:      can change the current value                        *
     *    PARAMETERS:       int n, int value, int sCode                         *
     *    Return value:     none                                                *
     ****************************************************************************/
    public void setCurrentValue(int n, int value, int sCode)
    {
        if (n >= 0 && n < Dice.size() )
        {
            if (sCode == 1234)
            {
                if (1 <= value && value <= Dice.get(n).getNumSides() )
                {
                    Dice.get(n).setCurrentValue(value,sCode);
                }
                else
                {
                    System.out.println("Value not a number on die");
                }
            }
            else
            {
                System.out.println("Security code wrong");
            }
        }
        else
        {
            System.out.println("Number given is not a dice in the list");
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
        for (Die die : Dice)
        {
            NewString.add(die.toString());
        }
        //Got help with this bottom return statement
        return String.join(" ", NewString);
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           printSummary()                                      *
     *    DESCRIPTION:      Prints a table of info for the dice                 *
     *    PARAMETERS:       None                                                *
     *    Return value:     None                                                *
     ****************************************************************************/
    public void printSummary()
    {
        System.out.printf(" %-10s  %-10s  %-10s \n", "Die Number", "Num Sides", "Current Value");
        int dieNumber = 1;
        for (Die die : Dice)
        {
            System.out.printf(" %-10d  %-10d  %-10d \n", dieNumber++, die.getNumSides(), die.getCurrentValue());
        }
    }
    /***********************************************************************
     * Method: count                                                       *
     * Game(s): Die games                                                  *
     * Parameters: int n                                                   *
     * Return Type: int                                                    *
     *  returns the number of Die that match given number                  *
     * Test Cases:                                                         *
     * 1 1 1 3 3 rolled  1 was number given and 3 was returned             *
     * 2 1 3 3 3 rolled  1 was number given and 1 was returned             *
     * 1 1 1 3 3 rolled  4 was number given and 0 was returned             *
     **********************************************************************/
    public int count(int n)
    {
        int count = 0;
        for (Die i : Dice)
        {
            if (n == i.getCurrentValue())
            {
                count++;
            }
        }
        return count;
    }
    /***********************************************************************
     * Method: sum                                                         *
     * Game(s): Dice Games                                                 *
     * Parameters:                                                         *
     * Return Type: int                                                    *
     *  returns the number of dice values summed up                        *
     * Test Cases:                                                         *
     * 1 1 1 1 1 summed up is 5                                            *
     * 4 5 6  summed up is 15                                              *
     * 4 5 2  summed up is 11                                              *
     **********************************************************************/
    public int sum()
    {
        int count = 0;
        for (Die i : Dice)
        {
            count = count + i.getCurrentValue();
        }
        return count;
    }
    /***********************************************************************
     * Method: hasYahtzee                                                  *
     * Game(s): Yahtzee                                                    *
     * Parameters:                                                         *
     * Return Type: Boolean                                                *
     *  returns the true or false depending on if Yahtzee is found         *
     * Test Cases:                                                         *
     * 1 1 1 1 1 True                                                      *
     * 4 5 6 4 4 False                                                     *
     * 4 5 2 4 4 False                                                     *
     **********************************************************************/
    public boolean hasYahtzee()
    {
        for (int i = 0; i < Dice.size(); i++)
        {
            int same = 0;
            Die Lowest = Dice.get(i);
            for (Die j : Dice)
            {
                if (Lowest.getCurrentValue() == j.getCurrentValue())
                {
                    same++;
                }
            }
            if(same == 5)
            {
                return true;
            }
        }
        return false;
    }
    /***********************************************************************
     * Method: YahtzeeScore                                                *
     * Game(s): Yahtzee                                                    *
     * Parameters:                                                         *
     * Return Type: int                                                    *
     *  returns 50 if yahtzee is found                                     *
     * Test Cases:                                                         *
     * 1 1 1 1 1 50                                                        *
     * 4 5 6 4 4 0                                                         *
     * 4 5 2 4 4 0                                                         *
     **********************************************************************/
    public int YahtzeeScore()
    {
        for (int i = 0; i < Dice.size(); i++)
        {
            int same = 0;
            Die Lowest = Dice.get(i);
            for (Die j : Dice)
            {
                if (Lowest.getCurrentValue() == j.getCurrentValue())
                {
                    same++;
                }
            }
            if(same == 5)
            {
                return 50;
            }
        }
        return 0;
    }
}

