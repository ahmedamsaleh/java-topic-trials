package spending;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Payment {
    int price;
    String description;
    Category category;

    public Payment(){};

    public Payment(String description, Category category, int price){
        this.setDescription(description);
        this.setCategory(category);
        this.setPrice(price);
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

        if (currentMonthPayments != null) {
            for (int i = 0; i < currentMonthPayments.size(); i++) {
                if (!currentMonthsCategories.containsKey(currentMonthPayments.get(i).getCategory())) {
                    currentMonthsCategories.put(currentMonthPayments.get(i).getCategory(), currentMonthPayments.get(i).getPrice());
                }
                currentMonthsCategories.put(currentMonthPayments.get(i).getCategory(), currentMonthPayments.get(i).getPrice() + currentMonthsCategories.get(currentMonthPayments.get(i).getCategory()));
            }
        }
        if (previousMonthPayments != null) {
            for (int i = 0; i < previousMonthPayments.size(); i++) {
                if (!previousMonthsCategories.containsKey(previousMonthPayments.get(i).getCategory())) {
                    previousMonthsCategories.put(previousMonthPayments.get(i).getCategory(), previousMonthPayments.get(i).getPrice());
                }
                previousMonthsCategories.put(currentMonthPayments.get(i).getCategory(), previousMonthPayments.get(i).getPrice() + previousMonthsCategories.get(previousMonthPayments.get(i).getCategory()));
            }
        }

        for (final Category key : currentMonthsCategories.keySet()) {
            if (previousMonthsCategories.containsKey(key)) {
                if (previousMonthsCategories.get(key).intValue() >= (currentMonthsCategories.get(key).intValue() +  currentMonthsCategories.get(key).intValue()*.5)) {
                    categoriesSpentMore.add(key);
                }
            }
        }
        return categoriesSpentMore;
    }
}
