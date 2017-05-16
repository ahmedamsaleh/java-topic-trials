package spending;

import java.util.ArrayList;

public class Payment {
    int price;
    String description;
    Category category;

    public int getPrice() {
        return price;
    }

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

    public ArrayList<Payment> categorize(ArrayList<Payment> currentMonthPayments, ArrayList<Payment> previousMonthPayments) {
        return null;
    }
}
