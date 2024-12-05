/****************************************************************************
 *                          Assignment 3                                    *
 *    Programmer:       Aidan Campbell                                      *
 *    Course:           CS201                                               *
 *    Date:             2/22/2024                                           *
 *    Requirement:      Assignment 3 Piece                                   *
 *                                                                          *
 *    Description: Get a board game piece color and location                *
 *                                                                          *
 *    COPYRIGHT: This code is copyright (C) 2023 Aidan Campbell             *
 *    and Dean Zeller.                                                      *
 *                                                                          *
 *    Credits:  None                                                        *
 ***************************************************************************/
public class Piece
{
    private String color;
    private int location;
    private char symbol;
    private int sCode = 1234;

    public Piece(String color, int location, char symbol)
    {
        this.color = color;
        this.location = location;
        this.symbol = symbol;
    }
    public Piece(String color)
    {
        this.color = color;
        this.location = 0;
        this.symbol = this.color.charAt(0);
    }
    public Piece(String color, int location)
    {
        this.color = color;
        this.location = location;
        this.symbol = color.charAt(0);
    }
    /****************************************************************************
     *    Method:           getcolor()                                          *
     *    DESCRIPTION:      returns the color                                   *
     *    PARAMETERS:       None                                                *
     *    Return value:     String color                                        *
     ****************************************************************************/
    public String getColor()
    {
        return color;
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           setColor()                                          *
     *    DESCRIPTION:      can change the current color                        *
     *    PARAMETERS:       None                                                *
     *    Return value:     none                                                *
     ****************************************************************************/
    public void setColor(String color, int sCode)
    {
        if(this.sCode != sCode)
        {
            System.out.println("Error security password wrong");
        }
        else
        {
            this.color = color;
        }

    }
    /****************************************************************************
     *    Method:           getLocation()                                       *
     *    DESCRIPTION:      returns the locations                               *
     *    PARAMETERS:       None                                                *
     *    Return value:     int location                                        *
     ****************************************************************************/
    public int getLocation()
    {
        return location;
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           setLocation()                                       *
     *    DESCRIPTION:      can change the current location                     *
     *    PARAMETERS:       None                                                *
     *    Return value:     none                                                *
     ****************************************************************************/
    public void setLocation(int location, int sCode)
    {
        if(this.sCode != sCode)
        {
            System.out.println("Error security password wrong");
        }
        else
        {
            this.location = location;
        }

    }
    /****************************************************************************
     *    Method:           getsymbol()                                         *
     *    DESCRIPTION:      returns the locations                               *
     *    PARAMETERS:       None                                                *
     *    Return value:     int location                                        *
     ****************************************************************************/
    public char getsymbol()
    {
        return symbol;
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           setSymbol()                                         *
     *    DESCRIPTION:      can change the current location                     *
     *    PARAMETERS:       None                                                *
     *    Return value:     none                                                *
     ****************************************************************************/
    public void setSymbol(char symbol, int sCode)
    {
        if(this.sCode != sCode)
        {
            System.out.println("Error security password wrong");
        }
        else
        {
            this.symbol = symbol;
        }
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           toString()                                          *
     *    DESCRIPTION:      change chars symbol to a string                     *
     *    PARAMETERS:       None                                                *
     *    Return value:     String  stuff                                       *
     ****************************************************************************/
    public String toString()
    {
        String stuff ="";
        stuff += getColor() + " " + getLocation();
        return stuff;
    }
}

