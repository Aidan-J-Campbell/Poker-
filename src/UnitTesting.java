/****************************************************************************
 *                           assignment 6                                   *
 *    Programmer:       Aidan Campbell                                      *
 *    Course:           CS201                                               *
 *    Date:             3/13/2024                                           *
 *    Requirement:      assignment 6                                        *
 *                                                                          *
 *    Description: Junit testing                                            *
 *                                                                          *
 *    COPYRIGHT: This code is copyright (C) 2023 Aidan Campbell             *
 *    and Dean Zeller.                                                      *
 *                                                                          *
 *                                                                          *
 *    Credits:  help with syntax and little stuff from ChatGPT              *
 ***************************************************************************/
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class UnitTesting {

    private Hand hand;
    private Dice Game;


    @Before
    public void setUp()
    {
        hand = new Hand();
        Card card1 = new Card(5, 'c');
        Card card2 = new Card(8, 's');
        Card card3 = new Card(8, 'f');
        Card card4 = new Card(8, 's');
        Card card5 = new Card(8, 'f');

        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);

        //Dice part
        Game = new Dice();
        Die one = new Die(1);
        Die Two = new Die(1);
        Die Three = new Die(1);
        Die Four = new Die(1);
        Die Five = new Die(1);
        // Roll them
        one.roll();
        Two.roll();
        Three.roll();
        Four.roll();
        Five.roll();
        //Add them in
        Game.add(one);
        Game.add(Two);
        Game.add(Three);
        Game.add(Four);
        Game.add(Five);
    }

    @Test
    public void testAddAndGetRanks()
    {


        assertEquals(0,  hand.countRank(0));
        assertEquals(2,  hand.countRank(5));
        assertEquals(3,  hand.countRank(8));
        assertEquals(1,  hand.countSuit('c'));
        assertEquals(2,  hand.countSuit('s'));
        assertEquals(2,  hand.countSuit('f'));
    }
    @Test
    public void testHighAndLow()
    {

        assertEquals(8,  hand.HighestCard());
        assertEquals(5,  hand.LowestCard());
    }

    @Test
    public void testThreeKinds()
    {
        assertTrue(hand.ThreeKind());
    }
    @Test
    public void testFourKinds()
    {
        assertTrue(hand.FourKind());
    }
    @Test
    public void testFullHouse()
    {
        assertTrue(hand.FullHouse());
    }
    @Test
    public void testCount()
    {
        assertEquals(5,Game.count(1));
    }
    @Test
    public void testSum()
    {
        assertEquals(5,Game.sum());
    }
    @Test
    public void testYahtzeeFound()
    {
        assertTrue(Game.hasYahtzee());
    }
    @Test
    public void testYahScore()
    {
        assertEquals(50,Game.YahtzeeScore());
    }
    


}


