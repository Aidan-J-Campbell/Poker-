/****************************************************************************
 *                           Final Project                                  *
 *    Programmer:       Aidan Campbell                                      *
 *    Course:           CS201                                               *
 *    Date:             4/13/2024                                           *
 *    Requirement:      Final project                                       *
 *                                                                          *
 *    Description: Poker game                                               *
 *                                                                          *
 *    COPYRIGHT: This code is copyright (C) 2023 Aidan Campbell             *
 *    and Dean Zeller.                                                      *
 *                                                                          *
 *                                                                          *
 ***************************************************************************/

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Delayed;

public class Final
{
    public static void main(String[] args) throws InterruptedException {
        //Std drawing set up
        StdDraw.setCanvasSize(600, 600);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledRectangle(0,0,1,1);
        StdDraw.setScale(-1, 1);
        StdDraw.setPenColor(0,155,0);
        StdDraw.filledRectangle(0, 0, 0.85, 0.55);

        //Variables used
        int Amount = 500;
        int OppAmount = 500;
        int pot = 0;
        int Bet = 0;
        int potAdd;
        char[] Suits = new char[]{ 'S','H','D','C'};
        Hand Player = new Hand();
        Hand Opp = new Hand();
        Hand Table = new Hand();
        Random rand = new Random();
        int random;
        int Type;

        //Start drawing
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -.3, "Amount:" + Amount); // Display the amount on the left side
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.text(0, .3, "Opp Amount: " + OppAmount); // Display the amount on the left side
        Draw.drawAmounts(Amount, OppAmount, pot);

        while(Amount > 0 && OppAmount > 0)
        {
            //Setting up Cards
            StdDraw.setPenColor(0,155,0);
            StdDraw.filledRectangle(0, 0, 0.6, 0.11);
            StdDraw.filledRectangle(0, .4, 0.6, 0.13);

            //Reset the pot to zero
            pot =0;

            //Variable to check if user input is valid
            boolean validInput = false;

            //Variables to see who has the higher card
            boolean draw = false;
            boolean User = false;
            boolean Opps= false;

            //Setting up Cards
            random = rand.nextInt(13);
            random++;
            Type = rand.nextInt(4);
            Card FirstUser = new Card(random, Suits[Type]);
            random = rand.nextInt(13);
            random++;
            Type = rand.nextInt(4);
            Card SecondUser = new Card(random, Suits[Type]);
            random = rand.nextInt(13);
            random++;


            Type = rand.nextInt(4);
            Card TableOne = new Card(random, Suits[Type]);
            random = rand.nextInt(13);
            random++;
            Type = rand.nextInt(4);
            Card TableTwo = new Card(random, Suits[Type]);
            random = rand.nextInt(13);
            random++;
            Type = rand.nextInt(4);
            Card TableThree = new Card(random, Suits[Type]);
            random = rand.nextInt(13);
            random++;
            Type = rand.nextInt(4);
            Card TableFour = new Card(random, Suits[Type]);
            random = rand.nextInt(13);
            random++;
            Type = rand.nextInt(4);
            Card TableFive = new Card(random, Suits[Type]);
            random = rand.nextInt(13);
            random++;


            Type = rand.nextInt(4);
            Card OppOne = new Card(random, Suits[Type]);
            random = rand.nextInt(13);
            random++;
            Type = rand.nextInt(4);
            Card OppTwo = new Card(random, Suits[Type]);

            //add the cards into the right hands
            Player.add(FirstUser);
            Player.add(SecondUser);
            Table.add(TableOne);
            Table.add(TableTwo);
            Table.add(TableThree);
            Table.add(TableFour);
            Table.add(TableFive);
            Opp.add(OppOne);
            Opp.add(OppTwo);

            //Print out your total and let the player know each amount will be taken 10 dollars
            System.out.println();
            System.out.printf("Your Amount: %d \n" , Amount);
            System.out.printf("Opponent Amount: %d\n" , OppAmount);
            System.out.println("Each player gives up 10 dollars");

            // get each players buy in and if they don't have 10 take the rest of their money
            if(Amount >= 10)
            {
                Amount = Amount - 10;
                potAdd = 10;
            }
            else
            {
                potAdd = Amount;
                Amount = 0;
            }

            if(OppAmount >= 10)
            {
                OppAmount = OppAmount - 10;
                potAdd = potAdd + 10;
            }
            else
            {
                potAdd = potAdd + OppAmount;
                OppAmount = 0;
            }

            //Add buy in to the pot
            pot = pot + potAdd;

            //update the amounts in the graphics part
            Draw.Pot(pot);
            Draw.Opp(OppAmount);
            Draw.User(Amount);

            // Check to see if they have an ace and if they both do check to see who has the higher card then for the win
            if(Player.LowestCard() == 1 && Opp.LowestCard() == 1)
            {
               if(Player.HighestCard() == Opp.HighestCard())
                {
                     draw = true;
                }
                //Player has a higher card
                else if (Player.HighestCard() > Opp.HighestCard())
                {
                     User = true;
                }
                //Opp has a higher card
                else
                {
                     Opps = true;
                }

            }

            //Player has an ace so they win
            else if(Player.LowestCard() == 1 && Opp.LowestCard() != 1)
            {
                User = true;
            }

            //Opp has an ace so they win on highest hand
            else if(Player.LowestCard() != 1 && Opp.LowestCard() == 1)
            {
                Opps = true;
            }

            //Check for a high card in a draw
            else if(Player.HighestCard() == Opp.HighestCard())
            {
                if(Player.LowestCard() == Opp.LowestCard())
                {
                    draw = true;
                }
                else if(Player.LowestCard() > Opp.LowestCard())
                {
                    User = true;
                }
                else
                {
                    Opps = true;
                }
            }

            //Player has a higher card
            else if (Player.HighestCard() > Opp.HighestCard())
            {
                User = true;
            }

            //Opp has a higher card
            else
            {
                Opps = true;
            }

            //prints out user hand in the terminal
            System.out.println("Your Hand");
            System.out.printf("%d,%c\n", FirstUser.getRank(),FirstUser.getSuit());
            System.out.printf("%d,%c\n", SecondUser.getRank(),SecondUser.getSuit());

            //Prints user hand in the graphics
            Draw.DrawCards(FirstUser.getRank(), FirstUser.getSuit(),-.09,-.4,-.33);
            Draw.DrawCards(SecondUser.getRank(), SecondUser.getSuit(),0.1,-.4,-.33);

            //Get user bet type and check to see if it is vailf
            Scanner UserBet = new Scanner(System.in);
            System.out.print("Enter your Bet : ");
            Bet = 0;

            //Credits to Zeller for the idea and ChatGpt for the UserBet.next(); part
            while (!validInput || (Bet > Amount || Bet < -1))
            {
                try
                {
                    Bet = UserBet.nextInt();
                    if (Bet > Amount || Bet < -1)
                    {
                        System.out.println("Error: Bet should be in the range of -1 to your Amount left. Please try again.");
                    } else
                    {
                        validInput = true;
                    }
                }
                catch (InputMismatchException e)
                {
                    System.out.println("Error: You entered a non-integer value. Please try again.");
                    UserBet.next();
                }
            }

            //User bets certain amount of money and opponent copies player
            if (Bet > 0)
            {
                pot = pot + Bet;
                Amount = Amount - Bet;
                if (OppAmount < Bet)
                {
                    pot = pot + OppAmount;
                    OppAmount = 0;
                } else
                {
                    pot = pot + Bet;
                    OppAmount = OppAmount - Bet;
                }
            }

            //Check
            else if (Bet == 0)
            {
                pot = pot;
            }

            //Fold
            else if (Bet == -1)
            {
                OppAmount = OppAmount + pot;
                System.out.printf("Your new Amount is: %d \n\n", Amount);
                // clear Cards
                Player.clear();
                Opp.clear();
                Table.clear();
                //Jump back to the start of the loop
                continue;
            }

            //Update the pot in graphics
            Draw.Pot(pot);
            Draw.Opp(OppAmount);
            Draw.User(Amount);


            //Game begins get basic prints to show hands this is temp till std
            System.out.printf("Your Amount: %d \n" , Amount);
            System.out.printf("Opponent Amount: %d\n" , OppAmount);

            //Prints your hand and the 3 cards in the middle
            System.out.println("Your Hand");
            System.out.printf("%d,%c\n", FirstUser.getRank(),FirstUser.getSuit());
            System.out.printf("%d,%c\n", SecondUser.getRank(),SecondUser.getSuit());
            System.out.println("The first 3 cards on the table");
            System.out.printf("%d,%c\n", TableOne.getRank(),TableOne.getSuit());
            System.out.printf("%d,%c\n", TableTwo.getRank(),TableTwo.getSuit());
            System.out.printf("%d,%c\n", TableThree.getRank(),TableThree.getSuit());

            //Add the middle three cards in the graphics
            Draw.DrawCards(TableOne.getRank(), TableOne.getSuit(),-.29,0,.06);
            Draw.DrawCards(TableTwo.getRank(), TableTwo.getSuit(),-.12,0,.06);
            Draw.DrawCards(TableThree.getRank(), TableThree.getSuit(),.05,0,.06);



            // Adding the first three to the players and opp hand from table
            //Adds these so we can check for winners
            Player.add(TableOne);
            Player.add(TableTwo);
            Player.add(TableThree);
            Opp.add(TableOne);
            Opp.add(TableTwo);
            Opp.add(TableThree);

            //See user bet exactly like the last one
            System.out.println("Let's see what you want to bet!");
            System.out.println("You can fold by typing -1, Check by entering 0, and place a bet with any integer above 0!");
            System.out.print("Enter your Bet : ");
            Bet = 0;
            validInput = false;
            while (!validInput || (Bet > Amount || Bet < -1))
            {
                try
                {
                    Bet = UserBet.nextInt();
                    if (Bet > Amount || Bet < -1)
                    {
                        System.out.println("Error: Bet should be in the range of -1 to your Amount left. Please try again.");
                    } else
                    {
                        validInput = true; // Set validInput to true only when a valid input is obtained
                    }
                }
                catch (InputMismatchException e)
                {
                    System.out.println("Error: You entered a non-integer value. Please try again.");
                    // Clear the scanner buffer
                    UserBet.next();
                }
            }


            //Game time bets are in and this part is copied three times with minor changes for this too work
            //Bet money
            if (Bet > 0)
                {
                    pot = pot + Bet;
                    Amount = Amount - Bet;
                    if (OppAmount < Bet)
                    {
                        pot = pot + OppAmount;
                        OppAmount = 0;
                    } else
                    {
                        pot = pot + Bet;
                        OppAmount = OppAmount - Bet;
                    }
                    Player.add(TableFour);
                    Opp.add(TableFour);
                }

                //Check
                else if (Bet == 0)
                {
                    Player.add(TableFour);
                    Opp.add(TableFour);
                }

                //Fold
                else if (Bet == -1)
                {
                    OppAmount = OppAmount + pot;
                    System.out.printf("Your new Amount is: %d \n\n", Amount);
                    // clear Cards
                    Player.clear();
                    Opp.clear();
                    Table.clear();
                    //Jump back to the start of the loop
                    continue;
                }

            // Update the graphic again
            Draw.Pot(pot);
            Draw.Opp(OppAmount);
            Draw.User(Amount);

            // If continued print out new card shown on table
            System.out.printf("Your Amount: %d \n" , Amount);
            System.out.printf("Opponent Amount: %d\n" , OppAmount);
            System.out.println("Your Hand");
            System.out.printf("%d,%c\n", FirstUser.getRank(),FirstUser.getSuit());
            System.out.printf("%d,%c\n", SecondUser.getRank(),SecondUser.getSuit());
            System.out.println("The first 4 cards on the table");
            System.out.printf("%d,%c\n", TableOne.getRank(),TableOne.getSuit());
            System.out.printf("%d,%c\n", TableTwo.getRank(),TableTwo.getSuit());
            System.out.printf("%d,%c\n", TableThree.getRank(),TableThree.getSuit());
            System.out.printf("%d,%c\n", TableFour.getRank(),TableFive.getSuit());

            //Add the fourth card in the middle for graphics
            Draw.DrawCards(TableFour.getRank(), TableFour.getSuit(),.22,0,.06);

            //See user bet. The same way as the ones before
            System.out.println("Let's see what you want to bet for the second time!");
            System.out.println("You can fold by typing -1, Check by entering 0, and place a bet with any integer above 0!");
            System.out.print("Enter your Bet : ");
            Bet = 0;
            validInput = false;
            while (!validInput || (Bet > Amount || Bet < -1))
            {
                try
                {
                    Bet = UserBet.nextInt();
                    if (Bet > Amount || Bet < -1)
                    {
                        System.out.println("Error: Bet should be in the range of -1 to your Amount left. Please try again.");
                    } else
                    {
                        validInput = true; // Set validInput to true only when a valid input is obtained
                    }
                }
                catch (InputMismatchException e)
                {
                    System.out.println("Error: You entered a non-integer value. Please try again.");
                    // Clear the scanner buffer
                    UserBet.next();
                }
            }

            //Game time bets are in and this part is copied three times with minor changes for this too work
            //Bet money
            if (Bet > 0)
            {
                pot = pot + Bet;
                Amount = Amount - Bet;
                if (OppAmount < Bet)
                {
                    pot = pot + OppAmount;
                    OppAmount = 0;
                } else
                {
                    pot = pot + Bet;
                    OppAmount = OppAmount - Bet;
                }
                Player.add(TableFive);
                Opp.add(TableFive);
            }

            //Check
            else if (Bet == 0)
            {
                Player.add(TableFive);
                Opp.add(TableFive);
            }

            //Fold
            else if (Bet == -1)
            {
                OppAmount = OppAmount + pot;
                System.out.printf("Your new Amount is: %d \n\n", Amount);
                // clear Cards
                Player.clear();
                Opp.clear();
                Table.clear();
                //Jump back to the start of the loop
                continue;
            }

            //Update the amounts again
            Draw.Pot(pot);
            Draw.Opp(OppAmount);
            Draw.User(Amount);

            //Print out last card
            System.out.printf("Your Amount: %d \n" , Amount);
            System.out.printf("Opponent Amount: %d\n" , OppAmount);
            System.out.println("Your Hand");
            System.out.printf("%d,%c\n", FirstUser.getRank(),FirstUser.getSuit());
            System.out.printf("%d,%c\n", SecondUser.getRank(),SecondUser.getSuit());
            System.out.println("The first 5 cards on the table");
            System.out.printf("%d,%c\n", TableOne.getRank(),TableOne.getSuit());
            System.out.printf("%d,%c\n", TableTwo.getRank(),TableTwo.getSuit());
            System.out.printf("%d,%c\n", TableThree.getRank(),TableThree.getSuit());
            System.out.printf("%d,%c\n", TableFour.getRank(),TableFour.getSuit());
            System.out.printf("%d,%c\n", TableFive.getRank(),TableFive.getSuit());

            // Last card in the middle is show on graphics
            Draw.DrawCards(TableFive.getRank(), TableFive.getSuit(),.39,0,.06);

            //See user bet
            System.out.println("Let's see what you want to bet for the Last time!");
            System.out.println("You can fold by typing -1, Check by entering 0, and place a bet with any integer above 0!");
            System.out.print("Enter your Bet : ");
            Bet = 0;
            validInput = false;
            while (!validInput || (Bet > Amount || Bet < -1))
            {
                try
                {
                    Bet = UserBet.nextInt();
                    if (Bet > Amount || Bet < -1)
                    {
                        System.out.println("Error: Bet should be in the range of -1 to your Amount left. Please try again.");
                    } else
                    {
                        validInput = true; // Set validInput to true only when a valid input is obtained
                    }
                }
                catch (InputMismatchException e)
                {
                    System.out.println("Error: You entered a non-integer value. Please try again.");
                    // Clear the scanner buffer
                    UserBet.next();
                }
            }


            //Game time bets are in and this part is copied three times with minor changes for this too work
            //Bet money
            if (Bet > 0)
            {
                pot = pot + Bet;
                Amount = Amount - Bet;
                if (OppAmount < Bet)
                {
                    pot = pot + OppAmount;
                    OppAmount = 0;
                }
                else
                {
                    pot = pot + Bet;
                    OppAmount = OppAmount - Bet;
                }
            }

            //Check
            else if (Bet == 0)
            {
                pot = pot;
            }

            //Fold
            else if (Bet == -1)
            {
                OppAmount = OppAmount + pot;
                System.out.printf("Your new Amount is: %d \n\n", Amount);
                //Jump back to the start of the loop
                // clear Cards
                Player.clear();
                Opp.clear();
                Table.clear();
                continue;
            }


            //Reveal Opps cards on the graphics side
            Draw.DrawCards(OppOne.getRank(), OppOne.getSuit(),-.09,.41,.46);
            Draw.DrawCards(OppTwo.getRank(), OppTwo.getSuit(),.10,.41,.46);

            //Delay the game by 2.6 seconds os user can see the opponents cards
            Thread.sleep(2600);

            //Set color to background green
            StdDraw.setPenColor(0,155,0);



            //Long list of winning possibilities. Comments on the first couple but the rest of them there
            //are no comments due to them being the same and copied and pasted

            //Check for winner and give them money
            //Both have royal flush
            if(Player.RoyalFlush() && Opp.RoyalFlush())
            {
                //User has a higher card and both have a royal flush
                if (User)
                {
                    System.out.println("You win this hand");
                    Amount = Amount + pot;
                    System.out.println("Here was the opponents");
                    System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                    System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                    // clear Cards
                    Player.clear();
                    Opp.clear();
                    Table.clear();
                    //opp is out of money
                    if (OppAmount == 0)
                    {
                        System.out.println("You won the game");
                        System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                        pot = 0;
                    }
                    //Update graphics
                    Draw.Pot(pot);
                    Draw.Opp(OppAmount);
                    Draw.User(Amount);
                    continue;
                }

                // Opp has higher card and they both have a royal flush
                else if (Opps)
                {
                    System.out.println("You lose");
                    OppAmount = OppAmount + pot;
                    System.out.println("Here was the opponents");
                    System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                    System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                    //clear cards
                    Player.clear();
                    Opp.clear();
                    Table.clear();
                    // Player out of money
                    if (Amount == 0)
                    {
                        System.out.println("You lost the game");
                        System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                        pot = 0;
                    }
                    //graphics
                    Draw.Pot(pot);
                    Draw.Opp(OppAmount);
                    Draw.User(Amount);
                    continue;
                }
                // they both have a royal flush and same cards in their hand
                else
                {
                    System.out.println("Its a draw");
                    Amount = Amount + (pot/2);
                    OppAmount = OppAmount + (pot/2);
                    System.out.println("Here was the opponents");
                    System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                    System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                    // Clear cards
                    Player.clear();
                    Opp.clear();
                    Table.clear();
                    //graphics
                    Draw.Pot(pot);
                    Draw.Opp(OppAmount);
                    Draw.User(Amount);
                    continue;
                }
            }

            //User has a royal flush
            else if (Player.RoyalFlush() && !Opp.RoyalFlush())
            {
                System.out.println("You win this hand");
                Amount = Amount + pot;
                System.out.println("Here was the opponents");
                System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                //clear cards
                Player.clear();
                Opp.clear();
                Table.clear();
                //Opp out of money
                if (OppAmount == 0)
                {
                    System.out.println("You won the game");
                    System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                    pot = 0;
                }
                //graphics
                Draw.Pot(pot);
                Draw.Opp(OppAmount);
                Draw.User(Amount);
                continue;
            }
            //Opp has a royal flush
            else if (!Player.RoyalFlush() && Opp.RoyalFlush())
            {
                System.out.println("You lose");
                OppAmount = OppAmount + pot;
                System.out.println("Here was the opponents");
                System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                //clear cards
                Player.clear();
                Opp.clear();
                Table.clear();
                //Player out of money
                if (Amount == 0)
                {
                    System.out.println("You lost the game");
                    System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                    pot = 0;
                }
                //graphics
                Draw.Pot(pot);
                Draw.Opp(OppAmount);
                Draw.User(Amount);
                continue;
            }

            //Both have a straight flush
            else if(Player.StraightFlush() && Opp.StraightFlush())
            {
                //If both have a straight flush and they are the same
                if (Player.StraightFlushSum() == Opp.StraightFlushSum())
                {
                    //User has the higher card they win
                    if (User)
                    {
                        System.out.println("You win this hand");
                        Amount = Amount + pot;
                        System.out.println("Here was the opponents");
                        System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                        System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                        //clear cards
                        Player.clear();
                        Opp.clear();
                        Table.clear();
                        // Opp out of money
                        if (OppAmount == 0)
                        {
                            System.out.println("You won the game");
                            System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                            pot = 0;
                        }
                        //graphics
                        Draw.Pot(pot);
                        Draw.Opp(OppAmount);
                        Draw.User(Amount);
                        continue;
                    }
                    //Opp has higher card the win
                    else if (Opps)
                    {
                        System.out.println("You lose");
                        OppAmount = OppAmount + pot;
                        System.out.println("Here was the opponents");
                        System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                        System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                        // clear cards
                        Player.clear();
                        Opp.clear();
                        Table.clear();
                        // Player out of money
                        if (Amount == 0)
                        {
                            System.out.println("You lost the game");
                            System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                            pot = 0;
                        }
                        //graphics
                        Draw.Pot(pot);
                        Draw.Opp(OppAmount);
                        Draw.User(Amount);
                        continue;
                    }
                    //they both are equal resulting in draw
                    else
                    {
                        System.out.println("Its a draw");
                        Amount = Amount + (pot/2);
                        OppAmount = OppAmount + (pot/2);
                        System.out.println("Here was the opponents");
                        System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                        System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                        //clear cards
                        Player.clear();
                        Opp.clear();
                        Table.clear();
                        //graphics
                        Draw.Pot(pot);
                        Draw.Opp(OppAmount);
                        Draw.User(Amount);
                        continue;
                    }
                }
                //Player has higher card straight they win
                else if (Player.StraightFlushSum() > Opp.StraightFlushSum())
                {
                    System.out.println("You win this hand");
                    Amount = Amount + pot;
                    System.out.println("Here was the opponents");
                    System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                    System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                    //clear cards
                    Player.clear();
                    Opp.clear();
                    Table.clear();
                    // Opp is out of money
                    if (OppAmount == 0)
                    {
                        System.out.println("You won the game");
                        System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                        pot = 0;
                    }
                    //graphics
                    Draw.Pot(pot);
                    Draw.Opp(OppAmount);
                    Draw.User(Amount);
                    continue;
                }
                //Opp has a higher straight they win
                else
                {
                    System.out.println("You lose");
                    OppAmount = OppAmount + pot;
                    System.out.println("Here was the opponents");
                    System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                    System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                    // clear cards
                    Player.clear();
                    Opp.clear();
                    Table.clear();
                    // player is out of money
                    if (Amount == 0)
                    {
                        System.out.println("You lost the game");
                        System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                        pot = 0;
                    }
                    // graphics
                    Draw.Pot(pot);
                    Draw.Opp(OppAmount);
                    Draw.User(Amount);
                    continue;
                }

            }
            //Player has a straight flush and opp doesn't
            else if (Player.StraightFlush() && !Opp.StraightFlush())
            {
                System.out.println("You win this hand");
                Amount = Amount + pot;
                System.out.println("Here was the opponents");
                System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                // clear cards
                Player.clear();
                Opp.clear();
                Table.clear();
                // opp is out of money
                if (OppAmount == 0)
                {
                    System.out.println("You won the game");
                    System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                    pot = 0;
                }
                //graphics
                Draw.Pot(pot);
                Draw.Opp(OppAmount);
                Draw.User(Amount);
                continue;
            }
            //Opp has a straight flush and player doesn't
            else if (!Player.StraightFlush() && Opp.StraightFlush())
            {
                System.out.println("You lose");
                OppAmount = OppAmount + pot;
                System.out.println("Here was the opponents");
                System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                // clear cards
                Player.clear();
                Opp.clear();
                Table.clear();
                // player out of money
                if (Amount == 0)
                {
                    System.out.println("You lost the game");
                    System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                    pot = 0;
                }
                //graphics
                Draw.Pot(pot);
                Draw.Opp(OppAmount);
                Draw.User(Amount);
                continue;
            }






            //Both have a four of a kind
            else if(Player.FourKind() && Opp.FourKind())
            {
                //If sums are equal continue
                if (Player.FourKindSum() == Opp.FourKindSum())
                {
                    //User has the higher card they win
                    if (User)
                    {
                        System.out.println("You win this hand");
                        Amount = Amount + pot;
                        System.out.println("Here was the opponents");
                        System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                        System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                        // clear cards
                        Player.clear();
                        Opp.clear();
                        Table.clear();
                        // opp is out of money
                        if (OppAmount == 0)
                        {
                            System.out.println("You won the game");
                            System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                            pot = 0;
                        }
                        //graphics
                        Draw.Pot(pot);
                        Draw.Opp(OppAmount);
                        Draw.User(Amount);
                        continue;
                    }
                    //Opp has higher card the win
                    else if (Opps)
                    {
                        System.out.println("You lose");
                        OppAmount = OppAmount + pot;
                        System.out.println("Here was the opponents");
                        System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                        System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                        // clear cards
                        Player.clear();
                        Opp.clear();
                        Table.clear();
                        // player out of money
                        if (Amount == 0)
                        {
                            System.out.println("You lost the game");
                            System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                            pot = 0;
                        }
                        //graphics
                        Draw.Pot(pot);
                        Draw.Opp(OppAmount);
                        Draw.User(Amount);
                        continue;
                    }
                    //they both are equal resulting in draw
                    else
                    {
                        System.out.println("Its a draw");
                        Amount = Amount + (pot/2);
                        OppAmount = OppAmount + (pot/2);
                        System.out.println("Here was the opponents");
                        System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                        System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                        // clear cards
                        Player.clear();
                        Opp.clear();
                        Table.clear();
                        // graphics
                        Draw.Pot(pot);
                        Draw.Opp(OppAmount);
                        Draw.User(Amount);
                        continue;
                    }
                }
                //Player has higher cards for four kind they win
                else if (Player.FourKindSum() > Opp.FourKindSum())
                {
                    System.out.println("You win this hand");
                    Amount = Amount + pot;
                    System.out.println("Here was the opponents");
                    System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                    System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                    // clear cards
                    Player.clear();
                    Opp.clear();
                    Table.clear();
                    // opp is out of money
                    if (OppAmount == 0)
                    {
                        System.out.println("You won the game");
                        System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                        pot = 0;
                    }
                    //graphics
                    Draw.Pot(pot);
                    Draw.Opp(OppAmount);
                    Draw.User(Amount);
                    continue;
                }
                //Opp has a higher four kind they win
                else
                {
                    System.out.println("You lose");
                    OppAmount = OppAmount + pot;
                    System.out.println("Here was the opponents");
                    System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                    System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                    // clear cards
                    Player.clear();
                    Opp.clear();
                    Table.clear();
                    // player is out of money
                    if (Amount == 0)
                    {
                        System.out.println("You lost the game");
                        System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                        pot = 0;
                    }
                    // graphics
                    Draw.Pot(pot);
                    Draw.Opp(OppAmount);
                    Draw.User(Amount);
                    continue;
                }
            }

            //Player has a four kind
            else if (Player.FourKind() && !Opp.FourKind())
            {
                System.out.println("You win this hand");
                Amount = Amount + pot;
                System.out.println("Here was the opponents");
                System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                // clear cards
                Player.clear();
                Opp.clear();
                Table.clear();
                // opp is out of money
                if (OppAmount == 0)
                {
                    System.out.println("You won the game");
                    System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                    pot = 0;
                }
                //graphics
                Draw.Pot(pot);
                Draw.Opp(OppAmount);
                Draw.User(Amount);
                continue;
            }

            //Opp has a four kind
            else if (!Player.FourKind() && Opp.FourKind())
            {
                System.out.println("You lose");
                OppAmount = OppAmount + pot;
                System.out.println("Here was the opponents");
                System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                // clear cards
                Player.clear();
                Opp.clear();
                Table.clear();
                // player out of money
                if (Amount == 0)
                {
                    System.out.println("You lost the game");
                    System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                    pot = 0;
                }
                // graphics
                Draw.Pot(pot);
                Draw.Opp(OppAmount);
                Draw.User(Amount);
                continue;
            }




            //Both have a full house
            else if(Player.FullHouse() && Opp.FullHouse())
            {
                //If sums are equal continue three kind sum
                if (Player.FullHouseSum() == Opp.FullHouseSum())
                {
                    // checks two kind sums this one gets the high two kind
                    if (Player.TwoPairSum() == Opp.TwoPairSum())
                    {
                        // gets the low two kind
                        if (Player.TwoKindSum() == Opp.TwoKindSum())
                        {
                            //User has the higher card they win
                            if (User) {
                                System.out.println("You win this hand");
                                Amount = Amount + pot;
                                System.out.println("Here was the opponents");
                                System.out.printf("%d,%c\n", OppOne.getRank(), OppOne.getSuit());
                                System.out.printf("%d,%c\n", OppTwo.getRank(), OppTwo.getSuit());
                                Player.clear();
                                Opp.clear();
                                Table.clear();
                                if (OppAmount == 0) {
                                    System.out.println("You won the game");
                                    System.out.printf("Your Amount: %d And Opp Amount: %d", Amount, OppAmount);
                                    pot = 0;
                                }
                                Draw.Pot(pot);
                                Draw.Opp(OppAmount);
                                Draw.User(Amount);
                                continue;
                            }
                            //Opp has higher card the win
                            else if (Opps) {
                                System.out.println("You lose");
                                OppAmount = OppAmount + pot;
                                System.out.println("Here was the opponents");
                                System.out.printf("%d,%c\n", OppOne.getRank(), OppOne.getSuit());
                                System.out.printf("%d,%c\n", OppTwo.getRank(), OppTwo.getSuit());
                                Player.clear();
                                Opp.clear();
                                Table.clear();
                                if (Amount == 0) {
                                    System.out.println("You lost the game");
                                    System.out.printf("Your Amount: %d And Opp Amount: %d", Amount, OppAmount);
                                    pot = 0;
                                }
                                Draw.Pot(pot);
                                Draw.Opp(OppAmount);
                                Draw.User(Amount);
                                continue;
                            }
                            //they both are equal resulting in draw
                            else {
                                System.out.println("Its a draw");
                                Amount = Amount + (pot / 2);
                                OppAmount = OppAmount + (pot / 2);
                                System.out.println("Here was the opponents");
                                System.out.printf("%d,%c\n", OppOne.getRank(), OppOne.getSuit());
                                System.out.printf("%d,%c\n", OppTwo.getRank(), OppTwo.getSuit());
                                Player.clear();
                                Opp.clear();
                                Table.clear();
                                Draw.Pot(pot);
                                Draw.Opp(OppAmount);
                                Draw.User(Amount);
                                continue;
                            }
                        }
                    }
                    //Player has higher card straight they win
                    else if (Player.TwoKindSum() > Opp.TwoKindSum())
                    {
                        System.out.println("You win this hand");
                        Amount = Amount + pot;
                        System.out.println("Here was the opponents");
                        System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                        System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                        Player.clear();
                        Opp.clear();
                        Table.clear();
                        if (OppAmount == 0)
                        {
                            System.out.println("You won the game");
                            System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                            pot = 0;
                        }
                        Draw.Pot(pot);
                        Draw.Opp(OppAmount);
                        Draw.User(Amount);
                        continue;
                    }
                    //Opp has a higher straight they win
                    else
                    {
                        System.out.println("You lose");
                        OppAmount = OppAmount + pot;
                        System.out.println("Here was the opponents");
                        System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                        System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                        Player.clear();
                        Opp.clear();
                        Table.clear();
                        if (Amount == 0)
                        {
                            System.out.println("You lost the game");
                            System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                            pot = 0;
                        }
                        Draw.Pot(pot);
                        Draw.Opp(OppAmount);
                        Draw.User(Amount);
                        continue;
                    }
                }
                //Opp has a higher full house they win
                else
                {
                    System.out.println("You lose");
                    OppAmount = OppAmount + pot;
                    System.out.println("Here was the opponents");
                    System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                    System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                    Player.clear();
                    Opp.clear();
                    Table.clear();
                    if (Amount == 0)
                    {
                        System.out.println("You lost the game");
                        System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                        pot = 0;
                    }
                    Draw.Pot(pot);
                    Draw.Opp(OppAmount);
                    Draw.User(Amount);
                    continue;
                }
            }

            //Player has a full house
            else if (Player.FullHouse() && !Opp.FullHouse())
            {
                System.out.println("You win this hand");
                Amount = Amount + pot;
                System.out.println("Here was the opponents");
                System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                Player.clear();
                Opp.clear();
                Table.clear();
                if (OppAmount == 0)
                {
                    System.out.println("You won the game");
                    System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                    pot = 0;
                }
                Draw.Pot(pot);
                Draw.Opp(OppAmount);
                Draw.User(Amount);
                continue;
            }

            //Opp has a full house
            else if (!Player.FullHouse() && Opp.FullHouse())
            {
                System.out.println("You lose");
                OppAmount = OppAmount + pot;
                System.out.println("Here was the opponents");
                System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                Player.clear();
                Opp.clear();
                Table.clear();
                if (Amount == 0)
                {
                    System.out.println("You lost the game");
                    System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                    pot = 0;
                }
                Draw.Pot(pot);
                Draw.Opp(OppAmount);
                Draw.User(Amount);
                continue;
            }






            //Both have a flush
            else if(Player.Flush() && Opp.Flush())
            {
                // User has a higher card
                if (User)
                {
                    System.out.println("You win this hand");
                    Amount = Amount + pot;
                    System.out.println("Here was the opponents");
                    System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                    System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                    Player.clear();
                    Opp.clear();
                    Table.clear();
                    if (OppAmount == 0)
                    {
                        System.out.println("You won the game");
                        System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                        pot = 0;
                    }
                    Draw.Pot(pot);
                    Draw.Opp(OppAmount);
                    Draw.User(Amount);
                    continue;
                }
                // Opps has a higher card
                else if (Opps)
                {
                    System.out.println("You lose");
                    OppAmount = OppAmount + pot;
                    System.out.println("Here was the opponents");
                    System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                    System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                    Player.clear();
                    Opp.clear();
                    Table.clear();
                    if (Amount == 0)
                    {
                        System.out.println("You lost the game");
                        System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                        pot = 0;
                    }
                    Draw.Pot(pot);
                    Draw.Opp(OppAmount);
                    Draw.User(Amount);
                    continue;
                }
                // it's a draw
                else
                {
                    System.out.println("Its a draw");
                    Amount = Amount + (pot/2);
                    OppAmount = OppAmount + (pot/2);
                    System.out.println("Here was the opponents");
                    System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                    System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                    Player.clear();
                    Opp.clear();
                    Table.clear();
                    Draw.Pot(pot);
                    Draw.Opp(OppAmount);
                    Draw.User(Amount);
                    continue;
                }
            }
            //Player has a flush
            else if (Player.Flush() && !Opp.Flush())
            {
                System.out.println("You win this hand");
                Amount = Amount + pot;
                System.out.println("Here was the opponents");
                System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                Player.clear();
                Opp.clear();
                Table.clear();
                if (OppAmount == 0)
                {
                    System.out.println("You won the game");
                    System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                    pot = 0;
                }
                Draw.Pot(pot);
                Draw.Opp(OppAmount);
                Draw.User(Amount);
                continue;
            }
            //Opp has a flush
            else if (!Player.Flush() && Opp.Flush())
            {
                System.out.println("You lose");
                OppAmount = OppAmount + pot;
                System.out.println("Here was the opponents");
                System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                Player.clear();
                Opp.clear();
                Table.clear();
                if (Amount == 0)
                {
                    System.out.println("You lost the game");
                    System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                    pot = 0;
                }
                Draw.Pot(pot);
                Draw.Opp(OppAmount);
                Draw.User(Amount);
                continue;
            }





            //Both have a straight
            else if(Player.Straight() && Opp.Straight())
            {
                //If sums are equal continue
                if (Player.StraightSum() == Opp.StraightSum())
                {
                    //User has the higher card they win
                    if (User)
                    {
                        System.out.println("You win this hand");
                        Amount = Amount + pot;
                        System.out.println("Here was the opponents");
                        System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                        System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                        Player.clear();
                        Opp.clear();
                        Table.clear();
                        if (OppAmount == 0)
                        {
                            System.out.println("You won the game");
                            System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                            pot = 0;
                        }
                        Draw.Pot(pot);
                        Draw.Opp(OppAmount);
                        Draw.User(Amount);
                        continue;
                    }
                    //Opp has higher card the win
                    else if (Opps)
                    {
                        System.out.println("You lose");
                        OppAmount = OppAmount + pot;
                        System.out.println("Here was the opponents");
                        System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                        System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                        Player.clear();
                        Opp.clear();
                        Table.clear();
                        if (Amount == 0)
                        {
                            System.out.println("You lost the game");
                            System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                            pot = 0;
                        }
                        Draw.Pot(pot);
                        Draw.Opp(OppAmount);
                        Draw.User(Amount);
                        continue;
                    }
                    //they both are equal resulting in draw
                    else
                    {
                        System.out.println("Its a draw");
                        Amount = Amount + (pot/2);
                        OppAmount = OppAmount + (pot/2);
                        System.out.println("Here was the opponents");
                        System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                        System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                        Player.clear();
                        Opp.clear();
                        Table.clear();
                        Draw.Pot(pot);
                        Draw.Opp(OppAmount);
                        Draw.User(Amount);
                        continue;
                    }
                }
                //Player has higher card straight they win
                else if (Player.StraightSum() > Opp.StraightSum())
                {
                    System.out.println("You win this hand");
                    Amount = Amount + pot;
                    System.out.println("Here was the opponents");
                    System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                    System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                    Player.clear();
                    Opp.clear();
                    Table.clear();
                    if (OppAmount == 0)
                    {
                        System.out.println("You won the game");
                        System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                        pot = 0;
                    }
                    Draw.Pot(pot);
                    Draw.Opp(OppAmount);
                    Draw.User(Amount);
                    continue;
                }
                //Opp has a higher straight they win
                else
                {
                    System.out.println("You lose");
                    OppAmount = OppAmount + pot;
                    System.out.println("Here was the opponents");
                    System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                    System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                    Player.clear();
                    Opp.clear();
                    Table.clear();
                    if (Amount == 0)
                    {
                        System.out.println("You lost the game");
                        System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                        pot = 0;
                    }
                    Draw.Pot(pot);
                    Draw.Opp(OppAmount);
                    Draw.User(Amount);
                    continue;
                }
            }

            //Player has a straight
            else if (Player.Straight() && !Opp.Straight())
            {
                System.out.println("You win this hand");
                Amount = Amount + pot;
                System.out.println("Here was the opponents");
                System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                Player.clear();
                Opp.clear();
                Table.clear();
                if (OppAmount == 0)
                {
                    System.out.println("You won the game");
                    System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                    pot = 0;
                }
                Draw.Pot(pot);
                Draw.Opp(OppAmount);
                Draw.User(Amount);
                continue;
            }
            //Opp has a straight
            else if (!Player.Straight() && Opp.Straight())
            {
                System.out.println("You lose");
                OppAmount = OppAmount + pot;
                System.out.println("Here was the opponents");
                System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                Player.clear();
                Opp.clear();
                Table.clear();
                if (Amount == 0)
                {
                    System.out.println("You lost the game");
                    System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                    pot = 0;
                }
                Draw.Pot(pot);
                Draw.Opp(OppAmount);
                Draw.User(Amount);
                continue;
            }






            //Both have a Three of a kind
            else if(Player.ThreeKind() && Opp.ThreeKind())
            {
                //If sums are equal continue
                 if (Player.ThreeKindSum() == Opp.ThreeKindSum())
                {
                    //User has the higher card they win
                    if (User)
                    {
                        System.out.println("You win this hand");
                        Amount = Amount + pot;
                        System.out.println("Here was the opponents");
                        System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                        System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                        Player.clear();
                        Opp.clear();
                        Table.clear();
                        if (OppAmount == 0)
                        {
                            System.out.println("You won the game");
                            System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                            pot = 0;
                        }
                        Draw.Pot(pot);
                        Draw.Opp(OppAmount);
                        Draw.User(Amount);
                        continue;
                    }
                    //Opp has higher card the win
                    else if (Opps)
                    {
                        System.out.println("You lose");
                        OppAmount = OppAmount + pot;
                        System.out.println("Here was the opponents");
                        System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                        System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                        Player.clear();
                        Opp.clear();
                        Table.clear();
                        if (Amount == 0)
                        {
                            System.out.println("You lost the game");
                            System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                            pot = 0;
                        }
                        Draw.Pot(pot);
                        Draw.Opp(OppAmount);
                        Draw.User(Amount);
                        continue;
                    }
                    //they both are equal resulting in draw
                    else
                    {
                        System.out.println("Its a draw");
                        Amount = Amount + (pot/2);
                        OppAmount = OppAmount + (pot/2);
                        System.out.println("Here was the opponents");
                        System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                        System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                        Player.clear();
                        Opp.clear();
                        Table.clear();
                        Draw.Pot(pot);
                        Draw.Opp(OppAmount);
                        Draw.User(Amount);
                        continue;
                    }
                }
                //Player has higher 3 kind they win
                else if (Player.ThreeKindSum() > Opp.ThreeKindSum())
                {
                    System.out.println("You win this hand");
                    Amount = Amount + pot;
                    System.out.println("Here was the opponents");
                    System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                    System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                    Player.clear();
                    Opp.clear();
                    Table.clear();
                    if (OppAmount == 0)
                    {
                        System.out.println("You won the game");
                        System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                        pot = 0;
                    }
                    Draw.Pot(pot);
                    Draw.Opp(OppAmount);
                    Draw.User(Amount);
                    continue;
                }
                //Opp has a higher 3 kind they win
                else
                {
                    System.out.println("You lose");
                    OppAmount = OppAmount + pot;
                    System.out.println("Here was the opponents");
                    System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                    System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                    Player.clear();
                    Opp.clear();
                    Table.clear();
                    if (Amount == 0)
                    {
                        System.out.println("You lost the game");
                        System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                        pot = 0;
                    }
                    Draw.Pot(pot);
                    Draw.Opp(OppAmount);
                    Draw.User(Amount);
                    continue;
                }
            }
            //Player has a three of a kind
            else if (Player.ThreeKind() && !Opp.ThreeKind())
            {
                System.out.println("You win this hand");
                Amount = Amount + pot;
                System.out.println("Here was the opponents");
                System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                Player.clear();
                Opp.clear();
                Table.clear();
                if (OppAmount == 0)
                {
                    System.out.println("You won the game");
                    System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                    pot = 0;
                }
                Draw.Pot(pot);
                Draw.Opp(OppAmount);
                Draw.User(Amount);
                continue;
            }
            //Opp has a three of a kind
            else if (!Player.ThreeKind() && Opp.ThreeKind())
            {
                System.out.println("You lose");
                OppAmount = OppAmount + pot;
                System.out.println("Here was the opponents");
                System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                Player.clear();
                Opp.clear();
                Table.clear();
                if (Amount == 0)
                {
                    System.out.println("You lost the game");
                    System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                    pot = 0;
                }
                Draw.Pot(pot);
                Draw.Opp(OppAmount);
                Draw.User(Amount);
                continue;
            }






            //Both have two pairs
            else if(Player.TwoPair() && Opp.TwoPair())
            {
                //If sums are equal continue this looks for the highest pair
                if (Player.TwoPairSum() == Opp.TwoPairSum())
                {
                    // this takes the lowest pair
                    if (Player.TwoKindSum() == Opp.TwoKindSum())
                    {
                        //User has the higher card they win
                        if (User) {
                            System.out.println("You win this hand");
                            Amount = Amount + pot;
                            System.out.println("Here was the opponents");
                            System.out.printf("%d,%c\n", OppOne.getRank(), OppOne.getSuit());
                            System.out.printf("%d,%c\n", OppTwo.getRank(), OppTwo.getSuit());
                            Player.clear();
                            Opp.clear();
                            Table.clear();
                            if (OppAmount == 0)
                            {
                                System.out.println("You won the game");
                                System.out.printf("Your Amount: %d And Opp Amount: %d", Amount, OppAmount);
                                pot = 0;
                            }
                            Draw.Pot(pot);
                            Draw.Opp(OppAmount);
                            Draw.User(Amount);
                            continue;
                        }
                        //Opp has higher card the win
                        else if (Opps) {
                            System.out.println("You lose");
                            OppAmount = OppAmount + pot;
                            System.out.println("Here was the opponents");
                            System.out.printf("%d,%c\n", OppOne.getRank(), OppOne.getSuit());
                            System.out.printf("%d,%c\n", OppTwo.getRank(), OppTwo.getSuit());
                            Player.clear();
                            Opp.clear();
                            Table.clear();
                            if (Amount == 0) {
                                System.out.println("You lost the game");
                                System.out.printf("Your Amount: %d And Opp Amount: %d", Amount, OppAmount);
                                pot = 0;
                            }
                            Draw.Pot(pot);
                            Draw.Opp(OppAmount);
                            Draw.User(Amount);
                            continue;
                        }
                        //they both are equal resulting in draw
                        else {
                            System.out.println("Its a draw");
                            Amount = Amount + (pot / 2);
                            OppAmount = OppAmount + (pot / 2);
                            System.out.println("Here was the opponents");
                            System.out.printf("%d,%c\n", OppOne.getRank(), OppOne.getSuit());
                            System.out.printf("%d,%c\n", OppTwo.getRank(), OppTwo.getSuit());
                            Player.clear();
                            Opp.clear();
                            Table.clear();
                            Draw.Pot(pot);
                            Draw.Opp(OppAmount);
                            Draw.User(Amount);
                            continue;
                        }
                    }
                    // player and opp has same higher pair but the player has the higher lower second pair
                    else if (Player.TwoKindSum() > Opp.TwoKindSum())
                    {
                        System.out.println("You win this hand");
                        Amount = Amount + pot;
                        System.out.println("Here was the opponents");
                        System.out.printf("%d,%c\n", OppOne.getRank(), OppOne.getSuit());
                        System.out.printf("%d,%c\n", OppTwo.getRank(), OppTwo.getSuit());
                        Player.clear();
                        Opp.clear();
                        Table.clear();
                        if (OppAmount == 0) {
                            System.out.println("You won the game");
                            System.out.printf("Your Amount: %d And Opp Amount: %d", Amount, OppAmount);
                            pot = 0;
                        }
                        Draw.Pot(pot);
                        Draw.Opp(OppAmount);
                        Draw.User(Amount);
                        continue;
                    }
                    // Opp and player both have the same highest pair but opp has greater lower pair
                    else
                    {
                        System.out.println("You lose");
                        OppAmount = OppAmount + pot;
                        System.out.println("Here was the opponents");
                        System.out.printf("%d,%c\n", OppOne.getRank(), OppOne.getSuit());
                        System.out.printf("%d,%c\n", OppTwo.getRank(), OppTwo.getSuit());
                        Player.clear();
                        Opp.clear();
                        Table.clear();
                        if (Amount == 0) {
                            System.out.println("You lost the game");
                            System.out.printf("Your Amount: %d And Opp Amount: %d", Amount, OppAmount);
                            pot = 0;
                        }
                        Draw.Pot(pot);
                        Draw.Opp(OppAmount);
                        Draw.User(Amount);
                        continue;
                    }
                }
                //Player has higher two kind they win
                else if (Player.TwoPairSum() > Opp.TwoPairSum())
                {
                    System.out.println("You win this hand");
                    Amount = Amount + pot;
                    System.out.println("Here was the opponents");
                    System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                    System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                    Player.clear();
                    Opp.clear();
                    Table.clear();
                    if (OppAmount == 0)
                    {
                        System.out.println("You won the game");
                        System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                        pot = 0;
                    }
                    Draw.Pot(pot);
                    Draw.Opp(OppAmount);
                    Draw.User(Amount);
                    continue;
                }
                //Opp has a higher two kind they win
                else
                {
                    System.out.println("You lose");
                    OppAmount = OppAmount + pot;
                    System.out.println("Here was the opponents");
                    System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                    System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                    Player.clear();
                    Opp.clear();
                    Table.clear();
                    if (Amount == 0)
                    {
                        System.out.println("You lost the game");
                        System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                        pot = 0;
                    }
                    Draw.Pot(pot);
                    Draw.Opp(OppAmount);
                    Draw.User(Amount);
                    continue;
                }
            }

            //Player has a two pair
            else if (Player.TwoPair() && !Opp.TwoPair())
            {
                System.out.println("You win this hand");
                Amount = Amount + pot;
                System.out.println("Here was the opponents");
                System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                Player.clear();
                Opp.clear();
                Table.clear();
                if (OppAmount == 0)
                {
                    System.out.println("You won the game");
                    System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                    pot = 0;
                }
                Draw.Pot(pot);
                Draw.Opp(OppAmount);
                Draw.User(Amount);
                continue;
            }
            //Opp has two pairs
            else if (!Player.TwoPair() && Opp.TwoPair())
            {
                System.out.println("You lose");
                OppAmount = OppAmount + pot;
                System.out.println("Here was the opponents");
                System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                Player.clear();
                Opp.clear();
                Table.clear();
                if (Amount == 0)
                {
                    System.out.println("You lost the game");
                    System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                    pot = 0;
                }
                Draw.Pot(pot);
                Draw.Opp(OppAmount);
                Draw.User(Amount);
                continue;
            }





            //Both have a two of a kind
            else if(Player.TwoKind() && Opp.TwoKind())
            {
                //If sums are equal continue
                if (Player.TwoKindSum() == Opp.TwoKindSum())
                {
                    //User has the higher card they win
                    if (User)
                    {
                        System.out.println("You win this hand");
                        Amount = Amount + pot;
                        System.out.println("Here was the opponents");
                        System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                        System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                        Player.clear();
                        Opp.clear();
                        Table.clear();
                        if (OppAmount == 0)
                        {
                            System.out.println("You won the game");
                            System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                            pot = 0;
                        }
                        Draw.Pot(pot);
                        Draw.Opp(OppAmount);
                        Draw.User(Amount);
                        continue;
                    }
                    //Opp has higher card the win
                    else if (Opps)
                    {
                        System.out.println("You lose");
                        OppAmount = OppAmount + pot;
                        System.out.println("Here was the opponents");
                        System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                        System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                        Player.clear();
                        Opp.clear();
                        Table.clear();
                        if (Amount == 0)
                        {
                            System.out.println("You lost the game");
                            System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                            pot = 0;
                        }
                        Draw.Pot(pot);
                        Draw.Opp(OppAmount);
                        Draw.User(Amount);
                        continue;
                    }
                    //they both are equal resulting in draw
                    else
                    {
                        System.out.println("Its a draw");
                        Amount = Amount + (pot/2);
                        OppAmount = OppAmount + (pot/2);
                        System.out.println("Here was the opponents");
                        System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                        System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                        Player.clear();
                        Opp.clear();
                        Table.clear();
                        Draw.Pot(pot);
                        Draw.Opp(OppAmount);
                        Draw.User(Amount);
                        continue;
                    }
                }
                //Player has higher two kind they win
                else if (Player.TwoKindSum() > Opp.TwoKindSum())
                {
                    System.out.println("You win this hand");
                    Amount = Amount + pot;
                    System.out.println("Here was the opponents");
                    System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                    System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                    Player.clear();
                    Opp.clear();
                    Table.clear();
                    if (OppAmount == 0)
                    {
                        System.out.println("You won the game");
                        System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                        pot = 0;
                    }
                    Draw.Pot(pot);
                    Draw.Opp(OppAmount);
                    Draw.User(Amount);
                    continue;
                }
                //Opp has a higher two kind they win
                else
                {
                    System.out.println("You lose");
                    OppAmount = OppAmount + pot;
                    System.out.println("Here was the opponents");
                    System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                    System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                    Player.clear();
                    Opp.clear();
                    Table.clear();
                    if (Amount == 0)
                    {
                        System.out.println("You lost the game");
                        System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                        pot = 0;
                    }
                    Draw.Pot(pot);
                    Draw.Opp(OppAmount);
                    Draw.User(Amount);
                    continue;
                }
            }

            //Player has a two of a kind
            else if (Player.TwoKind() && !Opp.TwoKind())
            {
                System.out.println("You win this hand");
                Amount = Amount + pot;
                System.out.println("Here was the opponents");
                System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                Player.clear();
                Opp.clear();
                Table.clear();
                if (OppAmount == 0)
                {
                    System.out.println("You won the game");
                    System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                    pot = 0;
                }
                Draw.Pot(pot);
                Draw.Opp(OppAmount);
                Draw.User(Amount);
                continue;
            }
            //Opp has two of a kind
            else if (!Player.TwoKind() && Opp.TwoKind())
            {
                System.out.println("You lose");
                OppAmount = OppAmount + pot;
                System.out.println("Here was the opponents");
                System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                Player.clear();
                Opp.clear();
                Table.clear();
                if (Amount == 0)
                {
                    System.out.println("You lost the game");
                    System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                    pot = 0;
                }
                Draw.Pot(pot);
                Draw.Opp(OppAmount);
                Draw.User(Amount);
                continue;
            }





            //Both have a high card
            else if(draw)
            {
                System.out.println("Its a draw");
                Amount = Amount + (pot/2);
                OppAmount = OppAmount + (pot/2);
                System.out.println("Here was the opponents");
                System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                Player.clear();
                Opp.clear();
                Table.clear();
                Draw.Pot(pot);
                Draw.Opp(OppAmount);
                Draw.User(Amount);
                continue;
            }

            //Player has a higher card
            else if (User)
            {
                System.out.println("You win this hand");
                Amount = Amount + pot;
                System.out.println("Here was the opponents");
                System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                Player.clear();
                Opp.clear();
                Table.clear();
                if (OppAmount == 0)
                {
                    System.out.println("You won the game");
                    System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                    pot = 0;
                }
                Draw.Pot(pot);
                Draw.Opp(OppAmount);
                Draw.User(Amount);
                continue;
            }


            //Opp has a higher card
            else
            {
                System.out.println("You lose");
                OppAmount = OppAmount + pot;
                System.out.println("Here was the opponents");
                System.out.printf("%d,%c\n", OppOne.getRank(),OppOne.getSuit());
                System.out.printf("%d,%c\n", OppTwo.getRank(),OppTwo.getSuit());
                Player.clear();
                Opp.clear();
                Table.clear();
                if (Amount == 0)
                {
                    System.out.println("You lost the game");
                    System.out.printf("Your Amount: %d And Opp Amount: %d",Amount,OppAmount);
                    pot = 0;
                }
                Draw.Pot(pot);
                Draw.Opp(OppAmount);
                Draw.User(Amount);
                continue;
            }
        }
    }


}