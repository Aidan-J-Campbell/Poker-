/****************************************************************************
 *                           assignment 5 Hand                              *
 *    Programmer:       Aidan Campbell                                      *
 *    Course:           CS201                                               *
 *    Date:             3/13/2024                                           *
 *    Requirement:      assignment 5                                        *
 *                                                                          *
 *    Description: List of Cards                                            *
 *                                                                          *
 *    COPYRIGHT: This code is copyright (C) 2023 Aidan Campbell             *
 *    and Dean Zeller.                                                      *
 *                                                                          *
 *                                                                          *
 *    Credits:  help with syntax and little stuff from ChatGPT              *
 ***************************************************************************/
import java.util.*;

public class Hand
{
    ArrayList<Card> Hand = new ArrayList<Card>();
    /****************************************************************************
     *                                                                          *
     *    Method:           add()                                               *
     *    DESCRIPTION:      Add a Card to the hand array                        *
     *    PARAMETERS:       Card c                                              *
     *    Return value:     None                                                *
     ****************************************************************************/
    public void add(Card c)
    {
        Hand.add(c);
    }
    public void clear()
    {
        Hand.clear();
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           getRanks()                                          *
     *    DESCRIPTION:      returns the current Hand in a list                  *
     *    PARAMETERS:       None                                                *
     *    Return value:     Array<INT> currentValue                             *
     ****************************************************************************/
    public ArrayList<Integer> GetRanks()
    {
        ArrayList<Integer> currentRanks = new ArrayList<>();
        for (Card i : Hand)
        {
            currentRanks.add(i.getRank());
        }
        return currentRanks;
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           getRank()                                           *
     *    DESCRIPTION:      returns a specific card in Hand list                *
     *    PARAMETERS:       int n                                               *
     *    Return value:     int Rank                                            *
     ****************************************************************************/
    public int getRank(int n)
    {
        ArrayList<Integer> currentRanks = new ArrayList<>();
        for (Card i : Hand)
        {
            currentRanks.add(i.getRank());
        }
        if(n >= 0 && n < currentRanks.size())
        {
            return currentRanks.get(n);
        }
        else
        {
            System.out.println("Not in the list");
            return -1;
        }
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           getSuits()                                          *
     *    DESCRIPTION:      returns the current Suits in a Hand                 *
     *    PARAMETERS:       None                                                *
     *    Return value:     Array<Char> currentValue                            *
     ****************************************************************************/
    public ArrayList<Character> GetSuits()
    {
        ArrayList<Character> currentSuits = new ArrayList<>();
        for (Card i : Hand)
        {
            currentSuits.add(i.getSuit());
        }
        return currentSuits;
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           getsuit()                                           *
     *    DESCRIPTION:      returns a specific suit in Hand list                *
     *    PARAMETERS:       int n                                               *
     *    Return value:     int Rank                                            *
     ****************************************************************************/
    public char getSuits(int n)
    {
        ArrayList<Character> CurrentSuits = new ArrayList<>();
        for (Card i : Hand)
        {
            CurrentSuits.add(i.getSuit());
        }
        if(n >= 0 && n < CurrentSuits.size())
        {
            return CurrentSuits.get(n);
        }
        else
        {
            System.out.println("Not in the list F is printed to show error");
            return 'F';
        }
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           setRank()                                           *
     *    DESCRIPTION:      can change the current Rank                         *
     *    PARAMETERS:       int n, int value, int sCode                         *
     *    Return value:     none                                                *
     ****************************************************************************/
    public void setRank(int n, int value, int sCode)
    {
        if (n >= 0 && n < Hand.size() )
        {
            if (sCode == 1234)
            {
                if (1 <= value && value <= 14 )
                {
                    Hand.get(n).setRank(value,sCode);
                }
                else
                {
                    System.out.println("Value not a Rank in cards");
                }
            }
            else
            {
                System.out.println("Security code wrong");
            }
        }
        else
        {
            System.out.println("Number given is not a card in the Hand");
        }
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           setSuit()                                           *
     *    DESCRIPTION:      can change the current Suit                         *
     *    PARAMETERS:       int n, char suit, int sCode                         *
     *    Return value:     none                                                *
     ****************************************************************************/
    public void setSuit(int n, char suit, int sCode)
    {
        char[] charArray = new char[]{ 'S','H','D','C','s','h','d','c' };
        if (n >= 0 && n < Hand.size())
        {
            if (sCode == 1234)
            {
                //This boolean was helped with the use of chatgpt
                boolean found = false;
                for (int i = 0; i < charArray.length; i++)
                {
                    if (suit == charArray[i])
                    {
                        Hand.get(n).setSuit(suit, sCode);
                        found = true;
                        break; // Once the suit is found, no need to continue the loop
                    }
                }
                if (!found)
                {
                    System.out.println("Value not a Suit in cards");
                }
            }
            else
            {
                System.out.println("Security code wrong");
            }
        }
        else
        {
            System.out.println("Number given is not a card in the Hand");
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
        for (Card i : Hand)
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
        System.out.printf(" %-10s  %-10s  %-10s \n", "Piece", "Rank", "Suit");
        int Piece = 1;
        for (Card i : Hand)
        {
            System.out.printf(" %-10d  %-10s  %-10s \n", Piece++, i.getRank(), i.getSuit());
        }
    }
    /***********************************************************************
     * Method: countRank                                                   *
     * Game(s): Poker                                                      *
     * Parameters: int n                                                   *
     * Return Type: int                                                    *
     *  returns the number of cards that match given rank                  *
     * Test Cases:                                                         *
     * 8 2                                                                 *
     * 5 1                                                                 *
     * 0 0                                                                 *
     **********************************************************************/
    public int countRank(int n)
    {
        int count = 0;
        for (Card i : Hand)
        {
            if (n == i.getRank())
            {
                count++;
            }
        }
        return count;
    }
    /***********************************************************************
     * Method: countSuit                                                   *
     * Game(s): Poker                                                      *
     * Parameters: int n                                                   *
     * Return Type: int                                                    *
     *  returns the number of cards that match given Suit                  *
     * Test Cases:                                                         *
     * 'c' 1                                                               *
     * 's' 1                                                               *
     * 'f' 1                                                               *
     **********************************************************************/
    public int countSuit(char n)
    {
        int count = 0;
        for (Card i : Hand)
        {
            if (n == i.getSuit())
            {
                count++;
            }
        }
        return count;
    }
    /***********************************************************************
     * Method: HighestCard                                                 *
     * Game(s): Poker                                                      *
     * Parameters:                                                         *
     * Return Type: int                                                    *
     *  returns the highest number of card                                 *
     * Test Cases:                                                         *
     * 5 8 9 9                                                             *
     * 5 8 8 8                                                             *
     * 14 13 12 14                                                         *
     **********************************************************************/
    public int HighestCard()
    {
        Card Highest = Hand.getFirst();
        for (int i =1; i <= Hand.size() -1; i++)
        {
            Card one = Hand.get(i);
            if (Highest.getRank() < one.getRank())
            {
                Highest = one;
            }
        }
        return Highest.getRank();
    }
    /***********************************************************************
     * Method: Lowest Card                                                 *
     * Game(s): Poker                                                      *
     * Parameters:                                                         *
     * Return Type: int                                                    *
     *  returns the Lowest number of card                                  *
     * Test Cases:                                                         *
     * 5 8 9 5                                                             *
     * 5 8 8 5                                                             *
     * 14 13 12 12                                                         *
     **********************************************************************/
    public int LowestCard()
    {
        Card Lowest = Hand.getFirst();
        for (int i =1; i <= Hand.size() -1; i++)
        {
            Card one = Hand.get(i);
            if (Lowest.getRank() > one.getRank())
            {
                Lowest = one;
            }
        }
        return Lowest.getRank();
    }
    /***********************************************************************
     * Method: Two  Kind                                                   *
     * Game(s): Poker                                                      *
     * Parameters:                                                         *
     * Return Type: boolean                                                *
     *  returns true or false if there are 2 of the same rank              *
     * Test Cases:                                                         *
     * 13 3 3 4 12 True                                                    *
     * 13 3 3 2 12 False                                                   *
     * 13 3 9 8 7 False                                                    *
     **********************************************************************/
    public boolean TwoKind()
    {
        sortHandByRank();
        int Amount = 0;
        for (int i = 0; i < Hand.size(); i++)
        {
            Amount = 0;
            Card Lowest = Hand.get(i);
            for (int j = 0; j < Hand.size()-1; j++)
            {
                Card Next = Hand.get(i);
                if (Lowest.getRank() == Hand.get(j).getRank() && Lowest.getRank() == Hand.get(j + 1).getRank())
                {
                    return true;
                }
            }

        }
        return false;
    }
    /***********************************************************************
     * Method: Two kind sum                                                *
     * Game(s): Poker                                                      *
     * Parameters:                                                         *
     * Return Type: int                                                    *
     *  returns the sum of the two kind                                    *
     * Test Cases:                                                         *
     * 13 3 3 4 12 6                                                       *
     * 13 3 3 2 12 False                                                   *
     * 13 3 3 3 3 False //It's a 4 kind                                    *
     **********************************************************************/
    public int TwoKindSum()
    {
        sortHandByRank();
        int sum = 0;
        int Amount = 0;
        for (int i = 0; i < Hand.size(); i++)
        {
            Amount = 0;
            Card Lowest = Hand.get(i);
            for (int j = 0; j < Hand.size()-1; j++)
            {
                Card Next = Hand.get(i);
                if (Lowest.getRank() == Hand.get(j).getRank() && Lowest.getRank() == Hand.get(j + 1).getRank())
                {
                    if (Lowest.getRank() == 1)
                    {
                        sum = 14 * 2;
                    }
                    else
                    {
                        sum = Lowest.getRank() * 2;
                    }
                    return sum;
                }
            }

        }
        return sum;
    }
    /***********************************************************************
     * Method: Two pair                                                    *
     * Game(s): Poker                                                      *
     * Parameters:                                                         *
     * Return Type: boolean                                                *
     *  returns true or false if there are 2 pairs of the same rank        *
     * Test Cases:                                                         *
     * 13 3 3 12 12 True                                                   *
     * 13 3 3 2 12 False                                                   *
     * 13 3 3 3 3 False                                                    *
     *                                                                     *
     *   Credit: I did mine, but I got chat to just simplify it,           *
     *   so it was confusing amd was easily readable                       *
     **********************************************************************/
    public boolean TwoPair()
    {
        sortHandByRank();
        int numPairs = 0;
        for (int i = 0; i < Hand.size() - 1; i++)
        {
            Card current = Hand.get(i);
            Card next = Hand.get(i + 1);
            if (current.getRank() == next.getRank())
            {
                numPairs++;
                i++;
            }
        }
        return numPairs >= 2;
    }
    /***********************************************************************
     * Method: TwoPairSUM                                                  *
     * Game(s): Poker                                                      *
     * Parameters:                                                         *
     * Return Type: boolean                                                *
     *  returns sums if there are 2 pairs of the same rank                 *
     * Test Cases:                                                         *
     * 13 3 4 11 2 == 0                                                    *
     * 13 3 3 2 13 == 6                                                    *
     * 13 3 4 5 6 == 0                                                     *
     *                                                                     *
     *   Credit: I did mine, but I got chat to just simplify it,           *
     *   so it was confusing amd was easily readable                       *
     **********************************************************************/
    public int TwoPairSum()
    {
        sortHandByRank();
        int numPairs = 0;
        int sumOne = 0;
        int sumTwo = 0;
        int sumThree = 0;
        for (int i = 0; i < Hand.size() - 1; i++)
        {

            Card current = Hand.get(i);
            Card next = Hand.get(i + 1);
            if (current.getRank() == next.getRank())
            {
                numPairs++;
                if (numPairs == 1)
                {
                    sumOne = current.getRank() + next.getRank();
                }
                if (numPairs == 2)
                {
                    sumTwo = current.getRank() + next.getRank();
                }
                if (numPairs == 3)
                {
                    sumThree = current.getRank() + next.getRank();
                }
            }
        }


        if (numPairs >= 2)
        {
            if(sumOne == 2)
            {
                return sumOne * 14;
            }
            else if (sumTwo == 2)
            {
                return sumTwo * 14;
            }
            else if (sumThree == 2)
            {
                return sumThree * 14;
            }
            else if (sumOne >= sumTwo && sumOne >= sumThree)
            {
                return sumOne;
            }
            else if (sumTwo >= sumOne && sumTwo >= sumThree)
            {
                return sumTwo;
            }
            else
            {
                return sumThree;
            }
        }
        return 0;
    }
    /***********************************************************************
     * Method: TwoPairSumDraw                                              *
     * Game(s): Poker                                                      *
     * Parameters:                                                         *
     * Return Type: boolean                                                *
     *  returns true or false if there are 2 pairs of the same rank        *
     * Test Cases:                                                         *
     * 13 3 3 12 12 True                                                   *
     * 13 3 3 2 12 False                                                   *
     * 13 3 3 3 3 False                                                    *
     *                                                                     *
     *   Credit: I did mine, but I got chat to just simplify it,           *
     *   so it was confusing amd was easily readable                       *
     **********************************************************************/
    public int TwoPairSumDraw()
    {
        sortHandByRank();
        int numPairs = 0;
        int sumOne = 0;
        int sumTwo = 0;
        int sumThree = 0;
        for (int i = 0; i < Hand.size() - 1; i++)
        {

            Card current = Hand.get(i);
            Card next = Hand.get(i + 1);
            if (current.getRank() == next.getRank())
            {
                numPairs++;
                if (numPairs == 1)
                {
                    sumOne = current.getRank() + next.getRank();
                }
                if (numPairs == 2)
                {
                    sumTwo = current.getRank() + next.getRank();
                }
                if (numPairs == 3)
                {
                    sumThree = current.getRank() + next.getRank();
                }
            }
        }


        if (numPairs >= 2)
        {
            if (sumOne <= sumTwo && sumOne >= sumThree)
            {
                return sumOne;
            }
            else if (sumTwo <= sumOne && sumTwo >= sumThree)
            {
                return sumTwo;
            }
            else
            {
                return sumThree;
            }
        }
        return 0;
    }
    /***********************************************************************
     * Method: ThreeKind                                                   *
     * Game(s): Poker                                                      *
     * Parameters:                                                         *
     * Return Type: boolean                                                *
     *  returns true or false if there are 3 of the same rank              *
     * Test Cases:                                                         *
     * 13 3 3 3 12 True                                                    *
     * 13 3 3 2 12 False                                                   *
     * 13 3 3 3 3 False                                                    *
     **********************************************************************/
    public boolean ThreeKind()
    {
        for (int i = 0; i < Hand.size(); i++)
        {
            int Amount = 0;
            Card Lowest = Hand.get(i);
            for (Card j : Hand)
            {
                if (Lowest.getRank() == j.getRank())
                {
                    Amount++;
                }
            }

            if(Amount >= 3)
            {
                return true;
            }
        }
       return false;
    }
    /***********************************************************************
     * Method: ThreeKindSum                                                *
     * Game(s): Poker                                                      *
     * Parameters:                                                         *
     * Return Type: int                                                    *
     *  returns int of the 3 cards of the same rank                        *
     * Test Cases:                                                         *
     * 13 3 3 3 12 == 9                                                    *
     * 13 3 3 2 12 == 0                                                    *
     * 13 1 1 1 6 == 3 which wins                                          *
     **********************************************************************/
    public int ThreeKindSum()
    {
        int sum = 0;
        for (int i = 0; i < Hand.size(); i++)
        {
            int Amount = 0;
            Card Lowest = Hand.get(i);
            for (Card j : Hand)
            {
                if (Lowest.getRank() == j.getRank() )
                {
                    Amount++;
                    if (Amount >= 3)
                    {
                        if (Lowest.getRank() == 1)
                        {
                            sum = 14 * 3;
                        }
                        else
                        {
                            if (Lowest.getRank() * 3>= sum)
                            {
                                sum = Lowest.getRank() * 3;
                            }
                        }
                    }
                }
            }
        }
        return sum;
    }
    /***********************************************************************
     * Method: FourKind                                                   *
     * Game(s): Poker                                                      *
     * Parameters:                                                         *
     * Return Type: boolean                                                *
     *  returns true or false if there are 4 of the same rank              *
     * Test Cases:                                                         *
     * 13 3 3 3 12 False                                                   *
     * 13 3 3 2 12 False                                                   *
     * 13 3 3 3 3 True                                                     *
     **********************************************************************/
    public boolean FourKind()
    {
        for (int i = 0; i < Hand.size(); i++)
        {
            int Amount = 0;
            Card Lowest = Hand.get(i);
            for (Card j : Hand)
            {
                if (Lowest.getRank() == j.getRank())
                {
                    Amount++;
                }
            }
            if(Amount >= 4)
            {
                return true;
            }
        }
        return false;
    }
    /***********************************************************************
     * Method: FourKindSum                                                 *
     * Game(s): Poker                                                      *
     * Parameters:                                                         *
     * Return Type: int                                                    *
     *  returns int of the 4 cards of the same rank                        *
     * Test Cases:                                                         *
     * 13 3 3 3 3 == 12                                                    *
     * 13 3 3 2 12 == 0                                                    *
     * 13 1 1 1 1 == 4 which wins                                          *
     **********************************************************************/
    public int FourKindSum()
    {
        int sum = 0;
        for (int i = 0; i < Hand.size(); i++)
        {
            int Amount = 0;
            Card Lowest = Hand.get(i);
            for (Card j : Hand)
            {
                if (Lowest.getRank() == j.getRank() )
                {
                    Amount++;
                    if (Amount >= 4)
                    {
                        if (Lowest.getRank() == 1)
                        {
                            sum = 14 * 4;
                        }
                        else
                        {
                            if (Lowest.getRank() * 4>= sum)
                            {
                                sum = Lowest.getRank() * 4;
                            }
                        }
                    }
                }
            }
        }
        return sum;
    }
    /***********************************************************************
     * Method: FullHouse                                                   *
     * Game(s): Poker                                                      *
     * Parameters:                                                         *
     * Return Type: boolean                                                *
     *  returns true if there is a 3 of one kind and 2 of another          *
     * Test Cases:                                                         *
     * 13 3 3 3 12 False                                                   *
     * 12 3 3 12 12 True                                                   *
     * 3 3 3 8 8 True                                                      *
     **********************************************************************/
    public boolean FullHouse() {
        sortHandByRank();

        int three = 0;
        int stop=0;
        int TwoOrThree = 0;

        // Check for three of a kind and a pair
        for (int i = 0; i < Hand.size() - 2; i++)
        {
            if (Hand.get(i).getRank() == Hand.get(i + 1).getRank() && Hand.get(i + 1).getRank() == Hand.get(i + 2).getRank()) {
                three = 3;
                stop = Hand.get(i).getRank();

            }
            else if (Hand.get(i).getRank() == Hand.get(i + 1).getRank() && Hand.get(i).getRank() != stop)
            {
                TwoOrThree = 2;
            }
        }
        if (three + TwoOrThree == 5)
        {
            return true;
        }
        return false;
    }

    /***********************************************************************
     * Method: FullHouseSum                                                *
     * Game(s): Poker                                                      *
     * Parameters:                                                         *
     * Return Type: int                                                    *
     *  returns int of the 3 cards of the same rank                        *
     * Test Cases:                                                         *
     * 2 2 3 3 3 == 9                                                      *
     * 13 3 3 2 12 == 0                                                    *
     * 13 13 1 1 1 == 42 which wins                                        *
     **********************************************************************/
    public int FullHouseSum()
    {
        int sum = 0;
        sortHandByRank();
        int three = 0;
        int two = 0;
        for (int i = 0; i < Hand.size() - 2; i++)
        {
            if (Hand.get(i).getRank() == Hand.get(i + 1).getRank() && Hand.get(i + 1).getRank() == Hand.get(i + 2).getRank())
            {
                three = 3;
                if (Hand.get(i).getRank() ==1)
                {
                    sum = 14;
                }
                if (Hand.get(i).getRank() > sum)
                {
                    sum = Hand.get(i).getRank();
                }


            }
            else if (Hand.get(i).getRank() == Hand.get(i + 1).getRank())
            {
                two = 2;
            }
        }
        if (three + two == 5)
        {
            return sum * 3;
        }
        return sum;
    }
    /***********************************************************************
     * Method: Straight                                                    *
     * Game(s): Poker                                                      *
     * Parameters:                                                         *
     * Return Type: boolean                                                *
     *  returns true or false if there are 5 straight numbers              *
     * Test Cases:                                                         *
     * 1 2 3 4 5 True                                                      *
     * 13 3 3 2 12 False                                                   *
     * 1 2 3 13 14 false                                                   *
     **********************************************************************/
    public boolean Straight()
    {
        //Check to see if there is a straight
        int check = 1;
        //Sort
        sortHandByRank();
        //Run through cards to check for back to back
        for (int i = 0; i < Hand.size()-1; i++)
        {
            int First = 0;
            int second = 0;
                Card before = Hand.get(i);
                Card after = Hand.get(i+1);
                First = before.getRank();
                second= after.getRank();
                if( second == First+1)
                {
                    check++;
                }
                else if(second == First)
                {
                    check = check;
                }
                else
                {
                    check = 1;
                }
                //If it gets to 4 in a row check to see if its 14 after if not checks to see if 1 appears at the beginning to sub in
            if (check == 4)
            {
                int cont = after.getRank();
                if (cont == 13)
                {
                    int ace =  Hand.get(0).getRank();
                    if (ace == 1)
                    {
                        check++;
                    }
                }
            }
            if(check >= 5)
            {
                return true;
            }
        }
        return false;
    }
    /***********************************************************************
     * Method: StraightSum                                                 *
     * Game(s): Poker                                                      *
     * Parameters:                                                         *
     * Return Type: boolean                                                *
     *  returns true or false if there are 5 straight numbers              *
     * Test Cases:                                                         *
     * 1 2 3 4 5 ==  14 doesn't count first one but doesn't matter         *
     * 13 3 3 2 12 == 0                                                    *
     * 1 2 3 13 14 == 0                                                    *
     **********************************************************************/
    public int StraightSum()
    {
        int sum = 0;
        int check = 1;
        sortHandByRank();

        for (int i = 0; i < Hand.size() - 1; i++)
        {
            int first = Hand.get(i).getRank();
            int second = Hand.get(i + 1).getRank();

            if (second == first + 1)
            {
                check++;
                sum += second;
            }
            else if (second != first)
            {
                check = 1;
                sum =0;
            }

            // Check for Ace (rank 1) at the end of a straight
            if (check == 4 && second == 13 && Hand.get(0).getRank() == 1)
            {
                sum += 14;
                check++;
            }

            if (check >= 5)
            {
                return sum;
            }
        }
        return sum;
    }
    /***********************************************************************
     * Method: Flush                                                       *
     * Game(s): Poker                                                      *
     * Parameters:                                                         *
     * Return Type: boolean                                                *
     *  returns true or false if there are 5 of the same suit              *
     * Test Cases:                                                         *
     * D D D D D True                                                      *
     * D D S D H False                                                     *
     * S S S S S True                                                      *
     **********************************************************************/
    public boolean Flush()
    {
        for (int i = 0; i < Hand.size(); i++)
        {
            int Amount = 0;
            Card Lowest = Hand.get(i);
            for (Card j : Hand)
            {
                if (Lowest.getSuit() == j.getSuit())
                {
                    Amount++;
                }
            }
            if(Amount >= 5)
            {
                return true;
            }
        }
        return false;
    }
    /***********************************************************************
     * Method: StraightFlush                                               *
     * Game(s): Poker                                                      *
     * Parameters:                                                         *
     * Return Type: boolean                                                *
     *  returns true or false if there are 5 straight numbers with all     *
     *  the same suits                                                     *
     * Test Cases:                                                         *
     * 1D 2D 3D 4D 5D True                                                 *
     * 13S 3S 3H 2S 12C False                                              *
     * 1S 3S 2S 4S 5S True                                                 *
     **********************************************************************/
    public boolean StraightFlush()
    {
        int heartsCount = 0;
        int spadesCount = 0;
        int diamondsCount = 0;
        int clubsCount = 0;
        for (Card card : Hand)
        {
            if (card.getSuit() == 'C')
            {
                clubsCount++;
            }
            else if (card.getSuit() == 'D')
            {
                diamondsCount++;
            }
            else if (card.getSuit() == 'S')
            {
                spadesCount++;
            }
            else
            {
                heartsCount++;
            }
        }
        if (clubsCount >= 5)
        {
            //I didn't know how to do this part chat helped teach me this
            Hand.removeIf(card -> card.getSuit() != 'C');
        }
        else if (diamondsCount >= 5)
        {
            Hand.removeIf(card -> card.getSuit() != 'D');
        }
        else if (spadesCount >= 5)
        {
            Hand.removeIf(card -> card.getSuit() != 'S');
        }
        else if (heartsCount >= 5)
        {
            Hand.removeIf(card -> card.getSuit() != 'H');
        }

        int consecutiveCount = 1;
        sortHandByRank();
        for (int i = 0; i < Hand.size() - 1; i++)
        {
            int currentRank = Hand.get(i).getRank();
            int nextRank = Hand.get(i + 1).getRank();
            if (nextRank == currentRank + 1)
            {
                consecutiveCount++;
            }
            else if (currentRank == nextRank)
            {
                //do nothing
            }
            else if (nextRank != currentRank)
            {
                consecutiveCount = 1;
            }
            if (consecutiveCount >= 5)
            {
                return true;
            }
        }
        return false;
    }
    /***********************************************************************
     * Method: StraightFlushSum                                            *
     * Game(s): Poker                                                      *
     * Parameters:                                                         *
     * Return Type: boolean                                                *
     *  returns true or false if there are 5 straight numbers              *
     * Test Cases:                                                         *
     * 1 2 3 4 5 ==  14 doesn't count first one but doesn't matter         *
     * 13 3 3 2 12 == 0                                                    *
     * 1 2 3 13 14 == 0                                                    *
     **********************************************************************/
    public int StraightFlushSum()
    {
        int sum = 0;
        int check = 1;
        int Amount = 1;
        sortHandByRank();

        for (int i = 0; i < Hand.size() - 1; i++)
        {
            int first = Hand.get(i).getRank();
            int second = Hand.get(i + 1).getRank();
            char firstSuit = Hand.get(i).getSuit();
            char secondSuit = Hand.get(i + 1).getSuit();

            if (second == first + 1)
            {
                check++;
                sum += second;
                if (secondSuit == firstSuit)
                {
                    Amount++;
                }
                if (secondSuit != firstSuit)
                {
                    Amount = 1;
                }
            }
            else if (second != first)
            {
                check = 1;
                sum =0;
                Amount = 1;
            }
            if (check >= 5 && Amount >= 5)
            {
                return sum;
            }
        }
        return sum;
    }
    /***********************************************************************
     * Method: RoyalFlush                                                  *
     * Game(s): Poker                                                      *
     * Parameters:                                                         *
     * Return Type: boolean                                                *
     *  returns true or false if there are 5 straight numbers with all     *
     *  the same suits                                                     *
     * Test Cases:                                                         *
     * 10D 11D 12D 13D 14D True                                            *
     * 13S 3S 3H 2S 12C False                                              *
     * 1S 3S 2S 4S 5S True                                                 *
     * Credit: this  part helped by ChatGPT with some                      *
     * modifications due to being a broken code but idea was given         *
     **********************************************************************/
    public boolean RoyalFlush()
    {
        sortHandByRank();
        int check = 1;
        int startIndex = 0;
        for (int i = 0; i < Hand.size(); i++)
        {
            if (Hand.get(i).getRank() == 10)
            {
                startIndex = i;
                i = Hand.size();
            }
        }
        for (int i = startIndex; i < Hand.size() - 1; i++)
        {
            int First = 0;
            int second = 0;
            Card before = Hand.get(i);
            Card after = Hand.get(i+1);
            First = before.getRank();
            second= after.getRank();

            if (second == First + 1)
            {
                check++;
            }
            else if (second == First)
            {
                check += 0;
            } else
            {
                check = 1;
            }
            //If it gets to 4 in a row check to see if its 14 after if not checks to see if 1 appears at the beginning to sub in
            if (check == 4)
            {
                int cont = after.getRank();
                if (cont != 14)
                {
                    int ace =  Hand.getFirst().getRank();
                    if (ace == 1)
                    {
                        check++;
                    }
                }
            }


            if (check >= 5)
            {
                for (int k = startIndex; k < Hand.size(); k++)
                {
                    int Amount = 0;
                    Card Lowest = Hand.get(k);
                    for (int j = startIndex; j < Hand.size(); j++)
                    {
                        Card Next = Hand.get(j);
                        if (Lowest.getSuit() == Next.getSuit())
                        {
                            Amount++;
                        }
                        if (Amount == 4)
                        {
                            if (Hand.get(0).getRank() == 1)
                            {
                                char let = Hand.get(0).getSuit();
                                if (let == Lowest.getSuit())
                                {
                                    Amount++;
                                }
                            }
                            if (Hand.get(1).getRank() == 1)
                            {
                                char let = Hand.get(1).getSuit();
                                if (let == Lowest.getSuit())
                                {
                                    Amount++;
                                }
                            }
                            if (Hand.get(2).getRank() == 1)
                            {
                                char let = Hand.get(2).getSuit();
                                if (let == Lowest.getSuit())
                                {
                                    Amount++;
                                }
                            }
                        }
                    }

                    if (Amount >= 5)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    /***********************************************************************
     * Method: SortHandByRank                                              *
     * Game(s): Poker                                                      *
     * Parameters:                                                         *
     * Return Type: none                                                   *
     *  sort by rank                                                       *
     *  Credit: CHATGPT taught me about this method and override part      *
     **********************************************************************/
    public void sortHandByRank()
    {
        Hand.sort(new Comparator<Card>()
        {
            @Override
            public int compare(Card card1, Card card2) {
                return Integer.compare(card1.getRank(), card2.getRank());
            }
        });
    }
}
