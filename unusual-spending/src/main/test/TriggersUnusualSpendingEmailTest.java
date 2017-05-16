import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import spending.*;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TriggersUnusualSpendingEmailTest {
    @InjectMocks
    private TriggersUnusualSpendingEmail triggersUnusualSpendingEmail;

    @Mock
    private EmailsUserWrapper emailsUserWrapper;

    @Mock
    private FetchesUserPaymentsByMonthWrapper fetchesUserPaymentsByMonthWrapper;

    @Mock
    private Payment payment;

    @Test
    public void canaryTest() {
        assertTrue(true);
    }

    @Test
    public void collaborationTestFetchAndEmail() {
        //dummy variables
        long userId = 123;
        ArrayList<Payment> currentMonthPayments = new ArrayList<Payment>();
        ArrayList<Payment> previousMonthPayments = new ArrayList<Payment>();
        ArrayList<Category> categories = new ArrayList<Category>();
        int currentMonth = 5;
        int previousMonth = 4;
        int year = 2017;

        //arrange
        when(fetchesUserPaymentsByMonthWrapper.fetch(userId, currentMonth, year)).
                thenReturn(currentMonthPayments);
        when(fetchesUserPaymentsByMonthWrapper.fetch(userId, previousMonth, year)).
                thenReturn(previousMonthPayments);
        when(payment.determineCategoriesSpentMoreThisMonth(currentMonthPayments, previousMonthPayments)).
                thenReturn(categories);
        //act
        triggersUnusualSpendingEmail.trigger(userId);

        //assert
        verify(emailsUserWrapper).email();
    }
}
