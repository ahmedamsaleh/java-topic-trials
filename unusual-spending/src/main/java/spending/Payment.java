package spending;

import java.util.ArrayList;
import java.util.HashMap;

public class Payment {
    private int price;
    private String description;
    private Category category;

    public Payment(){}

    public Payment(String description, Category category, int price){
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public int getPrice() {return price;}

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public HashMap<Category, Integer> determineCategoriesSpentMoreThisMonth(ArrayList<Payment> currentMonthPayments, ArrayList<Payment> previousMonthPayments) {
        HashMap<Category, Integer> categoriesSpentMoreMap = new HashMap();
        HashMap<Category, Integer> currentMonthsCategories = new HashMap();
        HashMap<Category, Integer> previousMonthsCategories = new HashMap();

        createCategoryMapForPayments(currentMonthPayments, currentMonthsCategories);
        createCategoryMapForPayments(previousMonthPayments, previousMonthsCategories);

        for (final Category key : currentMonthsCategories.keySet()) {
            if (previousMonthsCategories.containsKey(key)) {
                int value = previousMonthsCategories.get(key).intValue();
                if (currentMonthsCategories.get(key).intValue() >= (value +  value*.5)) {
                    categoriesSpentMoreMap.put(key, currentMonthsCategories.get(key).intValue());
                }
            }
        }
        return categoriesSpentMoreMap;
    }

    private void createCategoryMapForPayments(ArrayList<Payment> monthPayments, HashMap<Category, Integer> monthsCategories) {
        if (monthPayments != null) {
            for (Payment monthPayment : monthPayments) {
                if (!monthsCategories.containsKey(monthPayment.getCategory())) {
                    monthsCategories.put(monthPayment.getCategory(), monthPayment.getPrice());
                }else{
                    monthsCategories.put(monthPayment.getCategory(), monthPayment.getPrice() + monthsCategories.get(monthPayment.getCategory()));
                }
            }
        }
    }
}
