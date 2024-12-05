public class Draw
{
    /***********************************************************************
     * Method: drawAmounts                                                 *
     * Game(s): Poker                                                      *
     * Parameters: int amount/oppAmount/pot                                *
     * Return Type: void                                                   *
     * Draws the Amounts and sets them up for the game                     *
     **********************************************************************/
    public static void drawAmounts(int amount,int oppAmount,int pot)
    {
        StdDraw.setPenColor(0,155,0);
        StdDraw.filledRectangle(0, -0.3, 0.4, 0.05);
        StdDraw.filledRectangle(0, 0.3, 0.4, 0.05);

        // Draw new text
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -0.2, "Amount: " + amount);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, 0.25, "Opp Amount: " + oppAmount);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(-.7, 0, "Pot: " + pot);

        // Show updates on the canvas
        StdDraw.show();
    }
    /***********************************************************************
     * Method: User                                                        *
     * Game(s): Poker                                                      *
     * Parameters: int amount                                              *
     * Return Type: void                                                   *
     * updates user amount                                                 *
     **********************************************************************/
    public static void User(int amount)
    {
        StdDraw.setPenColor(0,155,0);
        StdDraw.filledRectangle(0, -0.2, 0.4, 0.05);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, -0.2, "Amount: " + amount);
        StdDraw.show();
    }
    /***********************************************************************
     * Method: Opp                                                         *
     * Game(s): Poker                                                      *
     * Parameters: int amount                                              *
     * Return Type: void                                                   *
     * updates Opps amount                                                 *
     **********************************************************************/
    public static void Opp(int amount)
    {
        StdDraw.setPenColor(0,155,0);
        StdDraw.filledRectangle(0, .25, 0.4, 0.05);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, .25, "Opp Amount: " + amount);
        StdDraw.show();
    }
    /***********************************************************************
     * Method: Pot                                                         *
     * Game(s): Poker                                                      *
     * Parameters: int pot                                                 *
     * Return Type: void                                                   *
     * updates the pot amount                                              *
     **********************************************************************/
    public static void Pot(int pot)
    {
        StdDraw.setPenColor(0,155,0);
        StdDraw.filledRectangle(-.7, 0, .13, 0.07);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(-.7, 0, "Pot: " + pot);
        StdDraw.show();
    }
    /***********************************************************************
     * Method: DrawCards                                                   *
     * Game(s): Poker                                                      *
     * Parameters: int rank, char suit, double x/y/NumY                    *
     * Return Type: void                                                   *
     * Draws the Amounts and sets them up for the game                     *
     **********************************************************************/
    public static void DrawCards(int rank, char suit, double x, double y, double NumY)
    {
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledRectangle(x, y, 0.08, 0.11);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(x,NumY, "" + rank);
        StdDraw.show();
            if (suit == 'S')
            {
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.text(x,y,"♠");
            }
            else if (suit == 'C')
            {
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.text(x,y,"♣");
            }
           else  if (suit == 'D')
            {
                StdDraw.setPenColor(StdDraw.DARK_GRAY);
                StdDraw.text(x,y,"♦");
            }
           else
            {
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.text(x,y,"♥");
            }
        }
    }
