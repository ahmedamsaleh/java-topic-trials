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

    public ArrayList<Category> determineCategoriesSpentMoreThisMonth(ArrayList<Payment> currentMonthPayments, ArrayList<Payment> previousMonthPayments) {
        ArrayList<Category> categoriesSpentMore = new ArrayList<Category>();
        HashMap<Category, Integer> currentMonthsCategories = new HashMap();
        HashMap<Category, Integer> previousMonthsCategories = new HashMap();

        createCategoryMapForPayments(currentMonthPayments, currentMonthsCategories);
        createCategoryMapForPayments(previousMonthPayments, previousMonthsCategories);

        for (final Category key : currentMonthsCategories.keySet()) {
            if (previousMonthsCategories.containsKey(key)) {
                if (previousMonthsCategories.get(key) >= (currentMonthsCategories.get(key) +  currentMonthsCategories.get(key)*.5)) {
                    categoriesSpentMore.add(key);
                }
            }
        }
        return categoriesSpentMore;
    }

    private void createCategoryMapForPayments(ArrayList<Payment> monthPayments, HashMap<Category, Integer> currentMonthsCategories) {
        if (monthPayments != null) {
            for (Payment monthPayment : monthPayments) {
                if (!currentMonthsCategories.containsKey(monthPayment.getCategory())) {
                    currentMonthsCategories.put(monthPayment.getCategory(), monthPayment.getPrice());
                }
                currentMonthsCategories.put(monthPayment.getCategory(), monthPayment.getPrice() + currentMonthsCategories.get(monthPayment.getCategory()));
            }
        }
    }
}
