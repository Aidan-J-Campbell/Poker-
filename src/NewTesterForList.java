/****************************************************************************
 *                           assignment 5 dice                              *
 *    Programmer:       Aidan Campbell                                      *
 *    Course:           CS201                                               *
 *    Date:             3/13/2024                                           *
 *    Requirement:      assignment 5                                        *
 *                                                                          *
 *    Description: Tester for all sub programs                              *
 *                                                                          *
 *    COPYRIGHT: This code is copyright (C) 2023 Aidan Campbell             *
 *    and Dean Zeller.                                                      *
 *                                                                          *
 *                                                                          *
 *    Credits:  ChatGPT and W3Schools                                       *
 *                                                                          *
 *                                                                          *
 ***************************************************************************/
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class NewTesterForList {
    public static void main(String[] args) {
        //Dice Test
        int testvalue;

        //Create list for Dies
        Dice List = new Dice();

        //create and Add die to Dice list
        Die Second = new Die(6);
        Die Third = new Die(10);
        Die Four = new Die(12);
        List.add(Second);
        List.add(Third);
        List.add(Four);
        List.roll();

        //get current values printed
        System.out.println("Current values of all dice after rolling:");
        ArrayList<Integer> currentValues = List.GetCurrentValues();
        for (int value : currentValues) {
            System.out.print(value + " ");
        }
        System.out.println("");

        //Roll just the middle die
        List.roll(1);
        currentValues = List.GetCurrentValues();
        for (int value : currentValues) {
            System.out.print(value + " ");
        }

        //Get current value of just one thing test
        System.out.println("");
        testvalue = List.getCurrentValue(1);
        System.out.println(testvalue);

        //Change a value
        List.setCurrentValue(1, 4, 1234);
        List.setCurrentValue(5, 4, 1234);
        List.setCurrentValue(1, 43, 1234);
        List.setCurrentValue(1, 4, 12343);
        currentValues = List.GetCurrentValues();
        for (int value : currentValues) {
            System.out.print(value + " ");
        }

        //Tostring test
        System.out.println("");
        System.out.println(List);
        List.printSummary();
        System.out.println("End of Dice testing \n");


        //Hand Testing 2/4
        //Set up
        Hand Set = new Hand();
        Card FirstUp = new Card(5, 'c');
        Card SecondUp = new Card(8, 's');
        Card ThirdUp = new Card(8, 's');
        //Add them in
        Set.add(FirstUp);
        Set.add(SecondUp);
        Set.add(ThirdUp);
        //Print the ranks
        System.out.println("Current Cards Ranks:");
        ArrayList<Integer> CardRanks = Set.GetRanks();
        for (int Deck : CardRanks) {
            System.out.print(Deck + " ");
        }
        System.out.println("");
        //Get the suits and print them
        System.out.println("Current Cards Suits:");
        ArrayList<Character> CardSuits = Set.GetSuits();
        for (char Deck : CardSuits) {
            System.out.print(Deck + " ");
        }
        System.out.println("");
        //Test on the single get rank
        int TestGetRank;
        TestGetRank = Set.getRank(1);
        System.out.println("Test for single rank");
        System.out.println(TestGetRank);
        //Test just for single suit
        char TestChar;
        TestChar = Set.getSuits(1);
        System.out.println("Test for single Suit");
        System.out.println(TestChar);
        //test for set rank
        Set.setRank(1, 4, 1234);
        Set.setRank(15, 4, 1234);
        Set.setRank(1, 43, 1234);
        Set.setRank(1, 4, 12343);
        CardRanks = Set.GetRanks();
        for (int value : CardRanks) {
            System.out.print(value + " ");
        }
        System.out.println("");
        //Test for the set suit
        Set.setSuit(1, 'd', 1234);
        Set.setRank(15, 'c', 1234);
        Set.setRank(1, 'E', 1234);
        Set.setRank(1, 4, 12343);
        CardSuits = Set.GetSuits();
        for (char value : CardSuits) {
            System.out.print(value + " ");
        }
        //Test for print summary and toString
        System.out.println("");
        System.out.println(Set);
        Set.printSummary();
        System.out.println("End of Hand testing \n");

        //Side Testing 3/4
        //Set up
        Side STest = new Side();
        //German numbers for fun
        //Make pieces and add them to A array
        Piece ein = new Piece("Red", 6);
        Piece zwei = new Piece("Green", 10);
        Piece drei = new Piece("Pink", 12);
        STest.add(ein);
        STest.add(zwei);
        STest.add(drei);
        System.out.println("Current Pieces Colors:");
        ArrayList<String> Colors = STest.getColors();
        for (String Piece : Colors) {
            System.out.print(Piece + " ");
        }
        System.out.println("");
        //Test on the single get rank
        String TestSingleColor;
        TestSingleColor = STest.getColor(1);
        System.out.println("Test for single color");
        System.out.println(TestSingleColor);
        System.out.println("Current Pieces Colors:");
        ArrayList<Integer> Location = STest.getLocations();
        for (int i : Location) {
            System.out.print(i + " ");
        }
        System.out.println("");
        int TestLocations;
        TestLocations = STest.getlocation(1);
        System.out.println("Test for single location");
        System.out.println(TestLocations);
        STest.setColor(1, "Blue", 1234);
        STest.setColor(1, "Blue", 1235);
        STest.setColor(7, "Blue", 1234);
        STest.setLocation(1, 22, 1234);
        Colors = STest.getColors();
        for (String value : Colors) {
            System.out.print(value + " ");
        }
        System.out.println("");
        Location = STest.getLocations();
        for (int value : Location) {
            System.out.print(value + " ");
        }
        System.out.println("");
        System.out.println(STest);
        STest.printSummary();
        System.out.println("End of Dice testing \n");

        //Testing for question 4/4
        //Set up
        Quiz QuizList = new Quiz();
        //German numbers for fun
        //Make pieces and add them to A array
        Question QuestionOne = new Question("What color is the white house?", "white");
        Question QuestionTwo = new Question("Is batman a bat?", "no");
        Question QuestionThree = new Question("Is water wet?", "yes");
        QuizList.add(QuestionOne);
        QuizList.add(QuestionTwo);
        QuizList.add(QuestionThree);
        System.out.println("Current Quiz Content:");
        ArrayList<String> Quizziz = QuizList.getContents();
        for (String i : Quizziz) {
            System.out.print(i + " ");
        }
        System.out.println("");

        //Test on the single get rank
        String TestSingle;
        TestSingle = QuizList.getContent(1);
        System.out.println("Test for single content");
        System.out.println(TestSingle);
        System.out.println("Current Answers:");
        ArrayList<String> Answer = QuizList.getCorrectAnswers();
        for (String i : Answer)
        {
            System.out.print(i + " ");
        }
        System.out.println("");

        String SpecificAns;
       SpecificAns= QuizList.getCorrectAns(1);
        System.out.println("Test for single Answer");
        System.out.println(SpecificAns);
        QuizList.setContent(1,"Whats the dog doing",1234);
        QuizList.setContent(1,"Blue",1235);
        QuizList.setContent(7,"Blue",1234);
        QuizList.setCorrectAns(1,"nothing",1234);
        QuizList.setCorrectAns(1,"Blue",1235);
        QuizList.setCorrectAns(7,"Blue",1234);
        Quizziz = QuizList.getContents();
        for (String value : Quizziz)
        {
            System.out.print(value + " ");
        }
        System.out.println("");
        Answer = QuizList.getCorrectAnswers();
        for (String value : Answer)
        {
            System.out.print(value + " ");
        }
        System.out.println("");
        System.out.println(QuizList);
        QuizList.printSummary();
        System.out.println("End of testing \n");

    }
}
