
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
    
    private StockDemo stockDemo;
    

    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();
        
        stock = new StockList();
        //StockDemo demo = new StockDemo();
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
         if(choice.equals("quit"))
        {
            System.out.println("You have quit the app and it did not save");
            return true;
         }
        else if(choice.equals("add"))
        {runAdd();
        }
        else if(choice.equals("remove"))
        {
            runRemove();
        }
        else if(choice.equals("print"))
        {
            stock.print();
        }
        else if(choice.equals("buy"))
        {   
            runBuy();
        }
        else if(choice.equals("sell"))
        {
            runSell();
        }
        else if(choice.equals("search"))
        {
            String phrase = reader.getString("Please enter name of Product > ");
            stock.findProducts(phrase);
        }
        else if(choice.equals("lowstock"))
        {
            runLowstock();
        }
        else if(choice.equals("re-stock"))
        {
            runRestock();
        }
        else if(choice.equals("print"))
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
        int amount = reader.getInt("Please enter the max quanity to show (between 1 and 5)> ");
        int quantity = reader.getInt("Please enter the amount to buy (between 1 and 10) for each > ");
        if(1 <= amount && amount <= 5 && 1 <= quantity && quantity <= 10)
        {
            stock.reStock(amount,quantity); 
        }
         else
        {
            System.out.println("Invalid input you will go back to main menu");
        }
    }
     
    /**
     * User inputs amount then it prints out all stock with less then amount
     * Then ask if you want to restock all those stocks (buy 10)
     */
    private void runLowstock()
    {
        int amount = reader.getInt("Please enter the max quanity to show (between 1 and 5)> ");
        if(1 <= amount && amount <= 5)
        {
            stock.lowStock(amount);
            String yorn = reader.getString("would you like to restock all of these (buy 10) (Y/N) > ");
            if(yorn.equals("y"))
             {
                stock.reStock(amount,10);
            }
            else if(yorn.equals("n"))
            {
                System.out.println("You will go back to main menu");
            }
            else
            {
                System.out.println("Invalid input you will go back to main menu");
            }
        }
         else
        {
            System.out.println("Invalid input you will go back to main menu");
        }
    }
    
     /**
     * User inputs ID and amount, then the program sells product with given id by amount
     */
    private void runSell()
     {
        int id = reader.getInt("Please enter ID of product > ");
        int amount = reader.getInt("Please enter amount of product to sell (between 1 and 10)> ");
        if(1 <= amount && amount <= 10)
        {
            stock.sellProduct(id,amount);
            System.out.println("you have sold Product with ID " +id+" "+amount+ " times");
        }
        else
        {
            System.out.println("Invalid input you will go back to main menu");
        }
    }
    
     /**
     * User inputs ID and amount, then the program buys product with given id by amount
     */
    private void runBuy()
    {
        int id = reader.getInt("Please enter ID of product > ");
        int amount = reader.getInt("Please enter amount of Product to buy (between 1 and 10)> ");
        if(1 <= amount && amount <= 10)
        {
             stock.buyProduct(id,amount);
            System.out.println("you have brought product with ID " +id+" "+amount+ " times");
        }
        else
        {
            System.out.println("Invalid input you will go back to main menu");
        }
    }
    
    /**
     * User inputs ID and name, then the program adds a product to the list with given ID and name
     */
    private void runAdd()
    {
        int id = reader.getInt("Please enter ID of product > ");
        Product find= stock.findProduct(id);
        if(find == null)
        {
            String name = reader.getString("Please enter name of product > ");
            Product product = new Product(id, name);
            stock.add(product);
            System.out.println("Product " +product.getName()+ " with ID " +product.getID()+ " has been added");
        }
        else
        {
            System.out.println("Sorry this ID has already got a product assigned to it");
        }
    }
    
    /**
     * User inputs ID , then the program removes that product from the list with given ID 
     */
    private void runRemove()
    {
        int id = reader.getInt("Please enter ID of product > ");
        stock.remove(id);
    }
}
    
    
    
    