package Project;

import java.util.ArrayList;
import java.util.Random;


public class Restaurant {
    private int i = 1;

    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();
    private Order order = new Order();

    public Restaurant() {
        initEmployees();
        initProducts();
    }

    private void initEmployees() {

        addCook("Monica", 100);

        addWaiter("Ross");
        addWaiter("Phobe");
        addWaiter("Rachel");
    }

    private void initProducts() {

        products.add(new MainDish("Pizza", 6, 2, 2));
        products.add(new MainDish("Burger", 5, 1.5, 2));

        products.add(new Beverage("Coke", 2, 0.5));
        products.add(new Beverage("Lemonade", 2, 0.3));

        products.add(new Dessert("Tiramusu", 4, 1, 1));
        products.add(new Dessert("Cake", 3, 0.5, 1));
        products.add(new Dessert("Ice Cream", 3, 0.5, 0.5));

        ArrayList<Product> HGproducts = new ArrayList<>();
        HGproducts.add(new MainDish("Pizza", 6, 2, 2));
        HGproducts.add(new Beverage("Coke", 2, 0.5));
        HGproducts.add(new Dessert("Tiramusu", 4, 1, 1));
        products.add(new MenuProduct("Hunger Games Menu", HGproducts));

        ArrayList<Product> Kidsproducts = new ArrayList<>();
        Kidsproducts.add(new MainDish("Burger", 5, 1.5, 2));
        Kidsproducts.add(new Beverage("Lemonade", 2, 0.3));
        Kidsproducts.add(new Dessert("Ice Cream", 3, 0.5, 0.5));
        products.add(new MenuProduct("Kids Menu", Kidsproducts));
    }


    public void addCook(String name, double salary) {
        Cook x = new Cook(i, name, salary);
        i += 1;
        employees.add(x);
    }

    public void addWaiter(String name) {
        Waiter x = new Waiter(i, name);
        i += 1;
        employees.add(x);
    }

    public void listEmployees() {
        for (int j = 0; j < this.i - 1; j++) {
            System.out.println(employees.get(j));
        }
    }


    public Waiter assignWaiter() {
        Random rand = new Random();
        int random = rand.nextInt(this.i - 1);
        if (employees.get(random) instanceof Waiter) {
            return (Waiter) employees.get(random);
        } else {
            return assignWaiter();
        }
    }

    public double calculateExpenses() {
        double sum1 = 0;
        double sum2 = 0;
        for (int i = 0; i < employees.size(); i++) {
            sum1 += employees.get(i).calculateExpense();
        }
        System.out.println("Employee expense: "+sum1);
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i) instanceof Waiter) {
                for (int j = 0; j < ((Waiter) employees.get(i)).getOrdersReceived().size(); j++) {
                    for (int k = 0; k < ((Waiter) employees.get(i)).getOrdersReceived().get(j).getOrderedProducts().size(); k++) {
                        sum2+= ((Waiter) employees.get(i)).getOrdersReceived().get(j)
                                .getOrderedProducts().get(k).calculateExpense();
                    }
                }
            }
        }
        System.out.println("Order expense: "+sum2);
        return sum1+sum2;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public double calculateRevenue() {
        double sum = 0;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i) instanceof Waiter) {
                for (int j = 0; j < ((Waiter) employees.get(i)).getOrdersReceived().size(); j++) {
                    sum += ((Waiter) employees.get(i)).getOrdersReceived().get(j).calculateTotalPrice();
                } } }
        return sum;
    }
}



