package Project;

import java.util.ArrayList;

public class Order {
   private ArrayList<Product>orderedProducts= new ArrayList<>();


    public Order() {

    }


    public void addProduct (Product product){
       orderedProducts.add(product);
    }

    public void listOrder(){
        if (orderedProducts.size()>0){
            for (int i=0; i< orderedProducts.size(); i++){
                System.out.println(orderedProducts.get(i));
            }
        }else{
            System.out.println("You have not ordered anything yet!");
        }
    }

    public ArrayList<Product> getOrderedProducts() {
        return orderedProducts;
    }

    public double calculateTotalPrice(){
        double sum=0;
        if (orderedProducts.size()>0){
            for (int i=0; i< orderedProducts.size(); i++){
                 sum+=orderedProducts.get(i).getSellingPrice();
            }
            return sum;
        }else{
                return 0;
        }
    }
}
