import java.util.ArrayList;
/****************************************************************************
 *                           assignment 5 Side                              *
 *    Programmer:       Aidan Campbell                                      *
 *    Course:           CS201                                               *
 *    Date:             3/13/2024                                           *
 *    Requirement:      assignment 5                                        *
 *                                                                          *
 *    Description: List of Pieces and actions with them                     *
 *                                                                          *
 *    COPYRIGHT: This code is copyright (C) 2023 Aidan Campbell             *
 *    and Dean Zeller.                                                      *
 *                                                                          *
 *                                                                          *
 *    Credits:  help with syntax and little stuff from ChatGPT              *
 *                                                                          *
 *                                                                          *
 ***************************************************************************/
public class Quiz
{
        ArrayList<Question> Main = new ArrayList<Question>();
        /****************************************************************************
         *                                                                          *
         *    Method:           add()                                               *
         *    DESCRIPTION:      Add a Die to the Dice array                         *
         *    PARAMETERS:       Question n                                          *
         *    Return value:     None                                                *
         ****************************************************************************/
        public void add(Question n)
        {
            Main.add(n);
        }
        /****************************************************************************
         *                                                                          *
         *    Method:           getContent()                                        *
         *    DESCRIPTION:      returns the current content of the quiz             *
         *    PARAMETERS:       None                                                *
         *    Return value:     Array<String> currentContents                       *
         ****************************************************************************/
        public ArrayList<String> getContents()
        {
                ArrayList<String> currentContents = new ArrayList<>();
                for (Question i : Main)
                {
                        currentContents.add(i.getContent());
                }
                return currentContents;
        }
        /****************************************************************************
         *                                                                          *
         *    Method:           getContent()                                        *
         *    DESCRIPTION:      returns a specific question in quiz list            *
         *    PARAMETERS:       int n                                               *
         *    Return value:     String question                                        *
         ****************************************************************************/
        public String getContent(int n)
        {
                ArrayList<String> currentContents = new ArrayList<>();
                for (Question i : Main)
                {
                        currentContents.add(i.getContent());
                }
                if(n >= 0 && n < currentContents.size())
                {
                        return currentContents.get(n);
                }
                else
                {
                        System.out.println("Not in the list print error to show");
                        return "Error";
                }
        }
        public ArrayList<String> getCorrectAnswers()
        {
                ArrayList<String> currentContents = new ArrayList<>();
                for (Question i : Main)
                {
                        currentContents.add(i.getCorrectAns());
                }
                return currentContents;
        }
        /****************************************************************************
         *                                                                          *
         *    Method:           getCorrectAns()                                     *
         *    DESCRIPTION:      returns a specific question in quiz list            *
         *    PARAMETERS:       int n                                               *
         *    Return value:     String question                                     *
         ****************************************************************************/
        public String getCorrectAns(int n)
        {
                ArrayList<String> currentContents = new ArrayList<>();
                for (Question i : Main)
                {
                        currentContents.add(i.getCorrectAns());
                }
                if(n >= 0 && n < currentContents.size())
                {
                        return currentContents.get(n);
                }
                else
                {
                        System.out.println("Not in the list print error to show");
                        return "Error";
                }
        }
        /****************************************************************************
         *                                                                          *
         *    Method:           setContent()                                        *
         *    DESCRIPTION:      can change the current content                      *
         *    PARAMETERS:       int n, String content, int sCode                    *
         *    Return value:     none                                                *
         ****************************************************************************/
        public void setContent(int n, String content, int sCode)
        {
                if (n >= 0 && n < Main.size())
                {
                        if (sCode == 1234)
                        {
                                Main.get(n).setContent(content,sCode);
                        }
                        else
                        {
                                System.out.println("Security code wrong");
                        }
                }
                else
                {
                        System.out.println("Number given is not a Question in the List");
                }
        }
        /****************************************************************************
         *                                                                          *
         *    Method:           setCorrectAns()                                     *
         *    DESCRIPTION:      can change the current Answer                       *
         *    PARAMETERS:       int n, String Ans, int sCode                        *
         *    Return value:     none                                                *
         ****************************************************************************/
        public void setCorrectAns(int n, String Ans, int sCode) {
                if (n >= 0 && n < Main.size()) {
                        if (sCode == 1234) {
                                Main.get(n).setCorrectAns(Ans, sCode);
                        }
                        else {
                                System.out.println("Security code wrong");
                        }
                }
                else {
                        System.out.println("Number given is not a Question in the List");}
        }
        /****************************************************************************
         *    Method:           toString()                                          *
         *    DESCRIPTION:      for easier print                                    *
         *    PARAMETERS:       None                                                *
         *    Return value:     String  NewString                                   *
         ****************************************************************************/
        public String toString() {
                ArrayList<String> NewString = new ArrayList<String>();
                for (Question i : Main)
                {
                        NewString.add(i.toString());
                }
                //Got help with this bottom return statement
                return String.join(" ", NewString);
        }
        /****************************************************************************
         *                                                                          *
         *    Method:           printSummary()                                      *
         *    DESCRIPTION:      Prints a table of info for the Quiz                 *
         *    PARAMETERS:       None                                                *
         *    Return value:     None                                                *
         ****************************************************************************/
        public void printSummary() {
                System.out.printf(" %-10s  %-40s  %-10s \n", "Piece", "Content", "Correct Answer");
                int Piece = 1;
                for (Question i : Main) {
                        System.out.printf(" %-10d  %-40s  %-10s \n", Piece++, i.getContent(), i.getCorrectAns());
                }
        }
}


