/****************************************************************************
 *                          Assignment 3                                    *
 *    Programmer:       Aidan Campbell                                      *
 *    Course:           CS201                                               *
 *    Date:             2/08/2024                                           *
 *    Requirement:      Assignment 3 Card                                   *
 *                                                                          *
 *    Description: Get a playing cards suit and rank                        *
 *                                                                          *
 *                                                                          *
 *                                                                          *
 *    COPYRIGHT: This code is copyright (C) 2023 Aidan Campbell             *
 *    and Dean Zeller.                                                      *
 *                                                                          *
 *    Credits:  None                                                        *
 ***************************************************************************/
public class Card
{
    private int Rank;
    private char Suit;
    int sCode = 1234;
    boolean setYes = false;

    public Card (int Rank,char Suit)
    {
        this.Rank = Rank;
        this.Suit = Suit;
    }
    public Card()
    {
        this.Rank = 6;
        this.Suit = 'S';
    }
    /****************************************************************************
     *    Method:           getRank()                                           *
     *    DESCRIPTION:      returns the Rank                                    *
     *    PARAMETERS:       None                                                *
     *    Return value:     int Rank                                            *
     ****************************************************************************/

    public int getRank()
    {
        return this.Rank;
    }

    /****************************************************************************
     *    Method:           getSuit()                                           *
     *    DESCRIPTION:      returns the Suit                                    *
     *    PARAMETERS:       None                                                *
     *    Return value:     char Suit                                           *
     ****************************************************************************/

    public char getSuit()
    {
        return this.Suit;
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           setRank()                                           *
     *    DESCRIPTION:      can change the current Rank                         *
     *    PARAMETERS:       None                                                *
     *    Return value:     none                                                *
     ****************************************************************************/
    public void setRank(int rank, int sCode)
    {
        if(this.sCode != sCode)
        {
            System.out.println("Error security password wrong");
        }
        else
        {
            if (1 <= rank && rank <= 14)
            {
                this.Rank = rank;
            }
            else
            {
                System.out.println("Needs to be 1-14");
            }
        }
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           setRank()                                           *
     *    DESCRIPTION:      can change the current Suit                         *
     *    PARAMETERS:       None                                                *
     *    Return value:     none                                                *
     ****************************************************************************/
    public void setSuit(char suit, int sCode)
    {
        char[] charArray = new char[]{ 'S','H','D','C','s','h','d','c' };
        if(this.sCode != sCode)
        {
            System.out.println("Error security password wrong");
        }
        else
        {
            for (int i = 0; i <= 7; i++)
            {
                if (suit == charArray[i])
                {
                        setYes = true;
                }
            }

            if (setYes == true)
            {
                this.Suit = suit;
            }
            if (setYes == false)
            {
                System.out.print("Error the suit is not one of the usable 8");
                System.out.println("");
            }

        }
    }

    /****************************************************************************
     *    Method:           getRankchar()                                       *
     *    DESCRIPTION:      returns the Rank in char form                       *
     *    PARAMETERS:       None                                                *
     *    Return value:     char Rank                                           *
     ****************************************************************************/
    public char getRankchar()
    {
        char RankChar = ' ';
        int placeholder = getRank();
        if (placeholder == 1) {
           RankChar = 'a';
         }
        if (placeholder == 10) {
            RankChar = '0';
        }
        if (placeholder == 11) {
            RankChar = 'J';
        }
        if (placeholder == 12) {
            RankChar = 'Q';
        }
        if (placeholder == 13) {
            RankChar = 'K';
        }
        if (placeholder == 14) {
            RankChar = 'A';
        }
        if (placeholder >= 2 && placeholder <= 9) {
            RankChar = (char) ('0' + placeholder);
        }
        return RankChar;
    }

    /****************************************************************************
     *    Method:           getRankString()                                     *
     *    DESCRIPTION:      returns the Rank in char form                       *
     *    PARAMETERS:       None                                                *
     *    Return value:     char Rank                                           *
     ****************************************************************************/
    public String getRankString()
    {
        String RankString = "";
        int placeholder = getRank();
        if (placeholder == 1) {
            RankString = "a";
        }
        if (placeholder == 10) {
            RankString = "0";
        }
        if (placeholder == 11) {
            RankString = "J";
        }
        if (placeholder == 12) {
            RankString = "Q";
        }
        if (placeholder == 13) {
            RankString = "K";
        }
        if (placeholder == 14) {
            RankString = "A";
        }
        if (placeholder >= 2 && placeholder <= 9) {
            RankString += placeholder;
        }
        return RankString;
    }
    /****************************************************************************
     *    Method:           getSuitString()                                     *
     *    DESCRIPTION:      returns the suit in String form                     *
     *    PARAMETERS:       None                                                *
     *    Return value:     String Rank                                         *
     ****************************************************************************/
    public String getSuitString()
    {
        String SuitString = "";
        SuitString += getSuit();
        return SuitString;
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           toString()                                          *
     *    DESCRIPTION:      change chars to a string for easier print           *
     *    PARAMETERS:       None                                                *
     *    Return value:     String  stuff                                       *
     ****************************************************************************/
    public String toString()
    {
        String stuff ="";
        stuff += getRankString();
        stuff += getSuitString();
        return stuff;
    }
}

