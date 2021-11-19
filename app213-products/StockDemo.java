//import java.util.Random;
/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class StockDemo
{
    // The stock manager.
    private StockList stock;
    
    //private Random random;

    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo()
    {
        this.stock = new StockList();
        //this.random = new Random();
        // Add at least 10 products, they must be unique to you
        // Make sure the ids are sequential numbers
        
        stock.add(new Product(101, "Samsung Galaxy S20"));
        stock.add(new Product(102, "Apple iPhone 12"));
        stock.add(new Product(103, "Google Pixel 4A"));
        stock.add(new Product(104, "Apple iPhone 13"));
        stock.add(new Product(105, "Apple iPhone 13 Pro"));
        stock.add(new Product(106, "Apple iPhone 13 Pro Max"));
        stock.add(new Product(107, "Samsung Galaxy Note 20"));
        stock.add(new Product(108, "Samsung Galaxy Note 20 Ultra"));
        stock.add(new Product(109, "Nokia 850"));
        stock.add(new Product(110, "Nokia 1100"));
        runDemo();
    }
    
    /**
     * Provide a demonstration of how the ProductList meets all
     * the user requirements by making a delivery of each product 
     * buying it in various amounts and then selling each
     * product by various amounts. Make sure all the requirements
     * have been demonstrated.
     */
    public void runDemo()
    {
        // Show details of all of the products before delivery.
        
        stock.print();

        buyProducts();
        stock.print();        

        sellProducts();
        stock.print(); 
        
    }
    
    private void buyProducts()
    {
        stock.buyProduct(101, 500);
        stock.buyProduct(102, 300);
        stock.buyProduct(103, 400);
        stock.buyProduct(104, 200);
        stock.buyProduct(105, 300);
        stock.buyProduct(106, 250);
        stock.buyProduct(107, 350);
        stock.buyProduct(108, 500);
        stock.buyProduct(109, 0);
        stock.buyProduct(110, 150);
    }

    private void sellProducts()
    {
        stock.sellProduct(101, 250);
        stock.sellProduct(102, 100);
        stock.sellProduct(103, 350);
        stock.sellProduct(104, 50);
        stock.sellProduct(105, 400);
        stock.sellProduct(106, 200);
        stock.sellProduct(107, 100);
        stock.sellProduct(108, 300);
        stock.sellProduct(109, 25);
        stock.sellProduct(110, 200);
    }   
    
}