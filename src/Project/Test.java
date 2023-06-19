package Project;


import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    static Restaurant restaurant = new Restaurant();



    public static void  main(String[] args) {
        restaurant.listEmployees();
        restaurant.assignWaiter();

        Waiter w = restaurant.assignWaiter();
        Order order= new Order();
        order.listOrder();
        Product x= new MainDish("Burger", 5, 1.5, 2);
        ArrayList<Product> products = restaurant.getProducts();

        order.addProduct(products.get(3));
        order.addProduct(products.get(4));
        order.listOrder();
        w.createOrder(order);
        System.out.println(order.getOrderedProducts().size());
        System.out.println(restaurant.calculateExpenses());
        System.out.println(restaurant.calculateRevenue());




    }



}
