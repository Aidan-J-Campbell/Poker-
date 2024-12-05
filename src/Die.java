/****************************************************************************
 *                           assignment 3 dice                              *
 *    Programmer:       Aidan Campbell                                      *
 *    Course:           CS201                                               *
 *    Date:             2/22/2024                                           *
 *    Requirement:      assignment 3 Die                                    *
 *                                                                          *
 *    Description: Make a die that gets a number of sides and roll it and   *
 *    and keep track of the numbers rolled                                  *
 *                                                                          *
 *                                                                          *
 *    COPYRIGHT: This code is copyright (C) 2023 Aidan Campbell             *
 *    and Dean Zeller.                                                      *
 *                                                                          *
 *                                                                          *
 *    Credits:  w2schools                                                   *
 ***************************************************************************/

import java.util.Random;

public class Die {
    //declare variables
    private int numSides;
    private int currentValue;
    private int sCode = 1234;

    // Set values
    public Die(int numSides) {
        this.numSides = numSides;
    }

    public Die()
    {
        this.numSides = 6;
    }

    public int getNumSides()
    {
        return numSides;
    }

    /****************************************************************************
     *                                                                          *
     *    Method:           roll()                                              *
     *    DESCRIPTION:      Roll dice and get a random int                      *
     *    PARAMETERS:       None                                                *
     *    Return value:     None                                                *
     ****************************************************************************/
    public void roll() {
        //get a random number using number of sides on the die
        Random rand = new Random();
        currentValue = rand.nextInt(numSides);
        currentValue++;

    }

    /****************************************************************************
     *                                                                          *
     *    Method:           getCurrentValue()                                   *
     *    DESCRIPTION:      returns the current value                           *
     *    PARAMETERS:       None                                                *
     *    Return value:     int currentValue                                    *
     ****************************************************************************/
    public int getCurrentValue() {
        //Returns the number rolled
        return currentValue;
    }

    /****************************************************************************
     *                                                                          *
     *    Method:           setCurrentValue()                                   *
     *    DESCRIPTION:      can change the current value                        *
     *    PARAMETERS:       None                                                *
     *    Return value:     none                                                *
     ****************************************************************************/
    public void setCurrentValue(int newValue, int sCode)
    {
        if(this.sCode != sCode)
        {
            System.out.println("Error security password wrong");
        }
        else
        {
            if (1 <= newValue && newValue <= numSides)
            {
                this.currentValue = newValue;
            }
            else
            {
                System.out.println("Number doesnt make sense 1 - number of sides on the die");
            }
        }
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           toString()                                          *
     *    DESCRIPTION:      change int to a string for easier print             *
     *    PARAMETERS:       None                                                *
     *    Return value:     String  stuff                                       *
     ****************************************************************************/
    public String toString()
    {
        String stuff ="";
        stuff += getCurrentValue();
        return stuff;
    }

}