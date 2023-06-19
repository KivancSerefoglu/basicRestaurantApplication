package Project;

import java.util.ArrayList;

public class MenuProduct extends Product{
    private ArrayList<Product> list;

    public MenuProduct(String name, ArrayList<Product> list){
        super(name);
        this.list=list;
        setSellingPrice(calculateSellingPrice());
    }

    public double calculateExpense() {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).calculateExpense();
        }
        return sum;
    }

    private double calculateSellingPrice(){
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof MainDish){
                sum+= list.get(i).getSellingPrice()*0.9;
            }else if (list.get(i) instanceof Dessert){
                sum+= list.get(i).getSellingPrice()*0.8;
            }else{
                sum += list.get(i).getSellingPrice()*0.5;
            }
        }
        return sum;

    }


}

