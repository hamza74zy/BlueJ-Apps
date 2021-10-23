 
/**
 * This class represents a course module and contains 
 * information on the module title and code.
 *
 * @author Amir Hamza
 * @version 15/10/2021
 */
public class Module
{
    // instance variables 
    private String code;
    private String title;
    private int credit;

    /**
     * Constructor for objects of class Module
     */
    public Module(String code, String title)
    {
        // initialise instance variables
        this.code = code;
        this.title = title;
        credit = 0;
    }

    /**
     * get the code
     */
    public String getCode()
    {
        return this.code;
    }
    
    
    /**
     * give the title
     */
    public String getTitle()
    {
        return this.title;
    }
    
    /**
     * set the credit
     */
    public int getCredit()
    {
        return this.credit;
    }
    
    /**
     * Print the details of the course, the list
     * of student enrolled and module
     */
    public void setCredit(int credit)
    {
        this.credit = credit;
    }
    
    /**
     * Print the details of the course, the list
     * of students enrolled and the module
     */
    public void print()
    {
        System.out.println(" Module Code: " + code + ": " 
                            + title + " Credit " + credit);
        System.out.println();
    }
}
