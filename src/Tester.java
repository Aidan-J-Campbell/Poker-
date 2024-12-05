/****************************************************************************
 *                           assignment 5 dice                              *
 *    Programmer:       Aidan Campbell                                      *
 *    Course:           CS201                                               *
 *    Date:             3/12/2024                                           *
 *    Requirement:      assignment 5                                        *
 *                                                                          *
 *    Description: Tester for all sub programs                              *
 *                                                                          *
 *    COPYRIGHT: This code is copyright (C) 2023 Aidan Campbell             *
 *    and Dean Zeller.                                                      *
 *                                                                          *
 *                                                                          *
 *    Credits:  W2schools                                                   *
 *                                                                          *
 *                                                                          *
 ***************************************************************************/
import java.util.Random;
import java.util.Scanner;
public class Tester
{
    public static void main(String[] args)
    {
        //Die test
        Die test = new Die(6);
        for (int i = 0; i < 10; i++) {
            test.roll();
            System.out.print(test + " ");
        }
        System.out.println("");
        test.setCurrentValue(5,1234);









        //Card test sends random 1-14 in for rank and suit is just S right now for spades
        Random rand = new Random();
        int random;
        random = rand.nextInt(14);
        random++;
        Card game = new Card(random, 'c');
        System.out.println();
        System.out.println(game);
        //set to test an error just to show off the error that's all
        game.setRank(13,1234);
        game.setSuit('e',1234);

        //piece test
        Piece object = new Piece("Red", random);
        System.out.println(object.getColor() + " " + object.getLocation() + " " + object);

        // Question test

        Question check = new Question("Who just won the SuperBowl", "chiefs");
        System.out.println(check);
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter Who won");
        String Answer = myObj.nextLine();
        check.setUserResp(Answer);
        if (check.isCorrect("chiefs", Answer))
        {
            System.out.println("Correct");
        }
        else
        {
            System.out.println("Wrong");
        }






    }

}

