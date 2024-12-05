/****************************************************************************
 *                          Assignment 3                                    *
 *    Programmer:       Aidan Campbell                                      *
 *    Course:           CS201                                               *
 *    Date:             2/08/2024                                           *
 *    Requirement:      Assignment 3                                        *
 *                                                                          *
 *    Description: Ask a question and the user will type in their answer    *
 *                 and it will be given as wrong or correct                 *
 *                                                                          *
 *    COPYRIGHT: This code is copyright (C) 2023 Aidan Campbell             *
 *    and Dean Zeller.                                                      *
 *                                                                          *
 *    Credits:  None                                                        *
 ***************************************************************************/
public class Question
{
    private String content;
    private String userResp;
    private String correctAns;
    private int sCode = 1234;

    public Question(String content, String userResp, String correctAns)
    {
        this.content = content;
        this.userResp = userResp;
        this.correctAns = correctAns;
    }
    public Question(String content, String correctAns)
    {
        this.content = content;
        this.correctAns = correctAns;
    }
    /****************************************************************************
     *    Method:           getCorrectAns()                                     *
     *    DESCRIPTION:      returns the correct Answer                          *
     *    PARAMETERS:       None                                                *
     *    Return value:     String correctAns                                   *
     ****************************************************************************/
    public String getCorrectAns()
    {
        return correctAns;
    }
    /****************************************************************************
     *    Method:           getUserResp()                                       *
     *    DESCRIPTION:      returns the user response                           *
     *    PARAMETERS:       None                                                *
     *    Return value:     String userResp                                     *
     ****************************************************************************/
    public String getUserResp()
    {
        return userResp;
    }
    /****************************************************************************
     *    Method:           getContent()                                        *
     *    DESCRIPTION:      returns the question                                *
     *    PARAMETERS:       None                                                *
     *    Return value:     String content                                      *
     ****************************************************************************/
    public String getContent()
    {
        return content;
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           setCorrectAns()                                     *
     *    DESCRIPTION:      can change the current Answer                       *
     *    PARAMETERS:       String correctAns                                   *
     *    Return value:     none                                                *
     ****************************************************************************/
    public void setCorrectAns(String correctAns, int sCode)
    {
        if(this.sCode != sCode)
        {
            System.out.println("Error security password wrong");
        }
        else
        {
            this.correctAns = correctAns;
        }

    }
    /****************************************************************************
     *                                                                          *
     *    Method:           setUserResp()                                       *
     *    DESCRIPTION:      can change the current color                        *
     *    PARAMETERS:       String userResp                                     *
     *    Return value:     none                                                *
     ****************************************************************************/
    public void setUserResp(String userResp)
    {
            this.userResp = userResp;
    }
    public void setContent(String content, int sCode)
    {
        if(this.sCode != sCode)
        {
            System.out.println("Error security password wrong");
        }
        else
        {
            this.content = content;
        }
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           isCorrect()                                         *
     *    DESCRIPTION:      Checks to see if answer and user response are the   *
     *                      same                                                *
     *    PARAMETERS:       String correctAns, userResp                         *
     *    Return value:     Boolean either true or false                        *
     ****************************************************************************/
    public boolean isCorrect(String correctAns, String userResp)
    {
        if(correctAns.equals(userResp))
            {
                return true;
            }
            return  false;
    }
    /****************************************************************************
     *                                                                          *
     *    Method:           toString()                                          *
     *    DESCRIPTION:      tbd                                                 *
     *    PARAMETERS:       None                                                *
     *    Return value:     String  stuff                                       *
     ****************************************************************************/
    public String toString()
    {
        String stuff ="";
        stuff += getContent();
        return stuff;
    }
}