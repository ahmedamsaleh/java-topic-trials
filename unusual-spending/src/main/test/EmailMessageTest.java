import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import spending.Category;
import spending.EmailMessage;
import spending.Payment;
import spending.TriggersUnusualSpendingEmail;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class EmailMessageTest {

    @Test
    public void createEmailMessage(){
        //arrange
        EmailMessage emailMessage = new EmailMessage();
        Payment payment1 = new Payment("example payment", Category.RESTAURANT, 100);
        Payment payment2 = new Payment("example payment", Category.GOLF, 10);
        Payment payment3 = new Payment("example payment", Category.ENTERTAINMENT, 1000);
        Payment payment4 = new Payment("example payment", Category.RESTAURANT, 150);
        Payment payment5 = new Payment("example payment", Category.GOLF, 10);
        Payment payment6 = new Payment("example payment", Category.ENTERTAINMENT, 50);
        ArrayList<Payment> currentMonthPayments = new ArrayList<Payment>();
        ArrayList<Payment> previousMonthPayments = new ArrayList<Payment>();
        ArrayList<Category> expectedCategories = new ArrayList<Category>();

        //act
        currentMonthPayments.add(payment1);
        currentMonthPayments.add(payment2);
        currentMonthPayments.add(payment3);
        previousMonthPayments.add(payment4);
        previousMonthPayments.add(payment5);
        previousMonthPayments.add(payment6);
        expectedCategories.add(Category.RESTAURANT);
        Payment payment = new Payment();
        HashMap<Category, Integer> categorizedList = payment.determineCategoriesSpentMoreThisMonth(
                currentMonthPayments, previousMonthPayments);
            String expectedEmail = "Hello card user!\n" +
                    "\n" +
                    "We have detected unusually high spending on your card in these categories:\n" +
                    "\n" +
                    "* You spent $150 on restaurants\n" +
                    "\n" +
                    "Love,\n" +
                    "\n" +
                    "The Credit Card Company";
            //assertEquals(expectedEmail, emailMessage.composeEmail());
    }
}
