import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import spending.Category;
import spending.Payment;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PaymentTest {

    @Test
    public void createPayment(){
        //arrange
        Payment payment = new Payment();

        //act
        payment.setDescription("example payment");
        payment.setCategory(Category.GOLF);
        payment.setPrice(100);

        //assert
        assertEquals(payment.getPrice(), 100);
        assertEquals(payment.getCategory().toString(), "GOLF");
        assertEquals(payment.getDescription(), "example payment");
    }

    @Test
    public void createListOfPayments(){
        //arrange
        Payment payment1 = new Payment("example payment", Category.RESTAURANT, 100);
        Payment payment2 = new Payment("example payment", Category.GOLF, 10);
        Payment payment3 = new Payment("example payment", Category.ENTERTAINMENT, 1000);
        ArrayList<Payment> paymentArrayList= new ArrayList<Payment>();

        //act
        paymentArrayList.add(payment1);
        paymentArrayList.add(payment2);
        paymentArrayList.add(payment3);

        //assert
        assertEquals(paymentArrayList.size(), 3);
        assertEquals(paymentArrayList.get(0).getPrice(), 100);
    }

    @Test
    public void categorizePayments(){
        //arrange
        Payment payment1 = new Payment("example payment", Category.RESTAURANT, 100);
        Payment payment2 = new Payment("example payment", Category.GOLF, 10);
        Payment payment3 = new Payment("example payment", Category.ENTERTAINMENT, 1000);
        Payment payment4 = new Payment("example payment", Category.RESTAURANT, 150);
        Payment payment5 = new Payment("example payment", Category.GOLF, 10);
        Payment payment6 = new Payment("example payment", Category.ENTERTAINMENT, 50);
        ArrayList<Payment> currentMonthPayments = new ArrayList<Payment>();
        ArrayList<Payment> previousMonthPayments = new ArrayList<Payment>();
        HashMap<Category, Integer> expectedCategories = new HashMap();

        //act
        previousMonthPayments.add(payment1);
        previousMonthPayments.add(payment2);
        previousMonthPayments.add(payment3);
        currentMonthPayments.add(payment4);
        currentMonthPayments.add(payment5);
        currentMonthPayments.add(payment6);
        expectedCategories.put(Category.RESTAURANT, 150);
        Payment payment = new Payment();
        HashMap<Category, Integer> categorizedList = payment.determineCategoriesSpentMoreThisMonth(
                currentMonthPayments, previousMonthPayments);

        //assert
        assertEquals(expectedCategories, categorizedList);
    }
}
