package spending;

import java.util.HashMap;

public class EmailMessage {
    public String composeEmail(HashMap<Category, Integer> unusualSpendingMap) {
        String unusualSpendingString = generateUnusualSpendingString(unusualSpendingMap);
        String email = "Hello card user!\n" +
                "\n" +
                "We have detected unusually high spending on your card in these categories:\n" +
                "\n" +
                unusualSpendingString +
                "\nLove,\n" +
                "\n" +
                "The Credit Card Company";
        return email;
    }

    private String generateUnusualSpendingString(HashMap<Category, Integer> unusualSpendingMap) {
        String unusualSpendingAmounts = "* You spent ";
        for (final Category key : unusualSpendingMap.keySet()){
            unusualSpendingAmounts = unusualSpendingAmounts + "$" + unusualSpendingMap.get(key) +
                    " on " + toStringCategory(key) + "\n";
        }
        return unusualSpendingAmounts;
    }

    private String toStringCategory(Category category){
        if (category == Category.RESTAURANT){
            return "restaurants";
        }
        if (category == Category.GOLF){
            return "golf";
        }
        return "entertainment";
    }
}
