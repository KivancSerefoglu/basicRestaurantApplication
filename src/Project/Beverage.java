package Project;

public class Beverage extends Product{

    public Beverage(String name, double sellingPrice, double purchasePrice){
        super(name, sellingPrice, purchasePrice);
    }

    public double calculateExpense() {
        return getPurchasePrice();
    }
}
