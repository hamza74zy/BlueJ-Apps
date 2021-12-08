
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Amir
 * @version 0.1
 */
public class StockApp
{
    private InputReader reader;
    
    private StockList stock;
    
    
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();
        
        stock = new StockList();
        StockDemo demo = new StockDemo();
    }

    /**
     *  Display a list of menu choices and execute
     *  the user's choice.
     */
    public void run()
    {
        boolean finished = false;
        
        while(!finished)
        {
            printHeading();
            printMenuChoices();
            
           
            String choice = reader.getString("Please enter your choice > ");
            
            finished = executeChoice(choice.toLowerCase());
        }
    }
    
    private boolean executeChoice(String choice)
    {
         if(choice.equals("quit") | choice.equals("q") | choice.equals("9"))
        {
            System.out.println("You have quit the app and it did not save");
            return true;
         }
        else if(choice.equals("add") | choice.equals("a") | choice.equals("1"))
        {runAdd();
        }
        else if(choice.equals("remove") | choice.equals("rem") | choice.equals("2"))
        {
            runRemove();
        }
        else if(choice.equals("print") | choice.equals("p") | choice.equals("8"))
        {
            stock.print();
        }
        else if(choice.equals("buy") | choice.equals("b") | choice.equals("4"))
        {   
            runBuy();
        }
        else if(choice.equals("sell") | choice.equals("5"))
        {
            runSell();
        }
        else if(choice.equals("search") | choice.equals("sea") | choice.equals("3"))
        {
            String phrase = reader.getString("Please enter name of Product > ");
            stock.findProducts(phrase);
        }
        else if(choice.equals("lowstock") | choice.equals("low stock") | choice.equals("l") | choice.equals("6"))
        {
            runLowstock();
        }
        else if(choice.equals("re-stock") | choice.equals("restock") | choice.equals("res") | choice.equals("7"))
        {
            runRestock();
        }
        else if(choice.equals("sd") | choice.equals("0"))
        {
            stockDemo = new StockDemo(stock);
        }
        else
        {
            System.out.println("Invalid input try again");
        }

        return false;
    }
   
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
         System.out.println();
        System.out.println("Add(1):        Add a new product");
        System.out.println("Remove(2):     Remove an old product");
        System.out.println("Search(3):     Search for products by what there name starts with, it will give you ID and quantity of product");
        System.out.println("Buy(4):        Buy an existing product by ID(amount between 1 and 10(you pick))");
        System.out.println("Sell(5):       Sell an existing product by ID(amount between 1 and 10(you pick))");
        System.out.println("Low Stock(6):  Print all products that have low stock(amount between 1 and 5 (you pick)),then have a option if you want to restock the low stock(will buy 10)");
        System.out.println("Re-stock(7):   Restock (amount between 1 and 10(you pick)) the products that have lowstock(amount between 1 and 5 (you pick))");
        System.out.println("Print(8):      Print all the products, this will show the name, ID and quantity of all products");
        System.out.println("Quit(9):       Quit the program");
        System.out.println();         
    }
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("********************************");
        System.out.println("  App21-04: Stock Application ");
        System.out.println("      by Amir ");
        System.out.println("********************************");
    }
    
    /**
     * User inputs amount and quantity then restocks by quanity if less then amount
     */
    private void runRestock()
    {
}