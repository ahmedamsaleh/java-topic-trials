import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import spending.Category;
import spending.Payment;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PaymentTest {
    @InjectMocks
    Payment payment;

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
        Payment payment1 = new Payment();
        Payment payment2 = new Payment();
        Payment payment3 = new Payment();
        payment1.setDescription("example payment");
        payment1.setCategory(Category.GOLF);
        payment1.setPrice(100);
        payment2.setDescription("example payment");
        payment2.setCategory(Category.GOLF);
        payment2.setPrice(10);
        payment3.setDescription("example payment");
        payment3.setCategory(Category.GOLF);
        payment3.setPrice(1000);
        ArrayList<Payment> paymentArrayList= new ArrayList<Payment>();

        //act
        paymentArrayList.add(payment1);
        paymentArrayList.add(payment2);
        paymentArrayList.add(payment3);

        //assert
        assertEquals(paymentArrayList.size(), 3);
        assertEquals(paymentArrayList.get(0).getPrice(), 100);
    }

}
