/****************************************************************************
 *                           assignment 6                                   *
 *    Programmer:       Aidan Campbell                                      *
 *    Course:           CS201                                               *
 *    Date:             3/13/2024                                           *
 *    Requirement:      assignment 6                                        *
 *                                                                          *
 *    Description: Test on new methods                                      *
 *                                                                          *
 *    COPYRIGHT: This code is copyright (C) 2023 Aidan Campbell             *
 *    and Dean Zeller.                                                      *
 *                                                                          *
 *                                                                          *
 *    Credits:  help with syntax and little stuff from ChatGPT              *
 ***************************************************************************/
public class TetsingForMethodList
{
    public static void main(String[] args)
    {
        //Set up
        Hand New = new Hand();
        Card FirstUp = new Card(6, 'H');
        Card SecondUp = new Card(7, 'H');
        Card ThirdUp = new Card(6, 'D');
        Card FourthUp = new Card(7, 'D');
        Card FifthUp = new Card(5, 'H');
        Card SixUp = new Card(7, 'C');
        Card SevenUp = new Card(13,'C');

        //Add them in
        New.add(FirstUp);
        New.add(SecondUp);
        New.add(ThirdUp);
        New.add(FourthUp);
        New.add(FifthUp);
        New.add(SixUp);
        New.add(SevenUp);

        //Found bottom of Hand 1/10
        int count = New.countRank(11);
        int SecondCount = New.countRank(13);
        int ThirdCount = New.countRank(7);
        System.out.printf("%d,%d,%d \n", count,SecondCount,ThirdCount);
        //Found bottom of Hand 2/10
        int countSuit = New.countSuit('s');
        int SecondCountSuit = New.countSuit('c');
        int ThirdCountSuit = New.countSuit('d');
        System.out.printf("%d,%d,%d \n", countSuit,SecondCountSuit,ThirdCountSuit);
        //Found bottom of hand 3/10
        int High = New.HighestCard();
        System.out.printf("%d \n",High);
        //Found bottom of hand 4/10
        int Low = New.LowestCard();
        System.out.printf("%d \n",Low);
        System.out.println("Two Kind");
        boolean TwoKind = New.TwoKind();
        System.out.printf("%b \n",TwoKind);
        System.out.println("Two Kind sum");
        int TwoKindSum = New.TwoKindSum();
        System.out.printf("%d \n",TwoKindSum);
        //Found bottom of hand 5/10
        System.out.println("This two pairs");
        boolean pairs = New.TwoPair();
        System.out.printf("%b \n",pairs);
        System.out.println("This two pairs sum");
        int pair = New.TwoPairSum();
        System.out.printf("%d \n",pair);
        System.out.println("Three Kind sum");
        int threekindsum = New.ThreeKindSum();
        System.out.printf("%d \n",threekindsum);
        System.out.println("Three Kind");
        boolean ThreeKind = New.ThreeKind();
        System.out.printf("%b \n",ThreeKind);
        //Found bottom of hand 6/10
        System.out.println("four Kind sum");
        int foursum = New.FourKindSum();
        System.out.printf("%d \n",foursum);
        System.out.println("Four Kind");
        boolean FourKind = New.FourKind();
        System.out.printf("%b \n",FourKind);
        //Found bottom of hand 7/10
        System.out.println("full house sum");
        int fullsum = New.FullHouseSum();
        System.out.printf("%d \n",fullsum);
        System.out.println("Full House");
        boolean FullHouse = New.FullHouse();
        System.out.printf("%b \n",FullHouse);
        System.out.println("str sum");
        int strSum = New.StraightSum();
        System.out.printf("%d \n",strSum);
        System.out.println("Strt");
        boolean Str = New.Straight();
        System.out.printf("%b \n",Str);
        System.out.println("Flush");
        boolean flush = New.Flush();
        System.out.printf("%b \n",flush);
        System.out.println("flushStrSum sum");
        int FSS = New.StraightFlushSum();
        System.out.printf("%d \n",FSS);
        System.out.println("This one is str flush");
        boolean STRflush = New.StraightFlush();
        System.out.printf("%b \n",STRflush);
        System.out.println("Royal flush");
        boolean Royal = New.RoyalFlush();
        System.out.printf("%b \n",Royal);
        System.out.println("Two pair draw sum");
        int summ = New.TwoPairSumDraw();
        System.out.printf("%d \n",summ);



    }

}
