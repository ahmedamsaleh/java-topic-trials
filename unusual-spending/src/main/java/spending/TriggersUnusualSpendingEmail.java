package spending;

import java.util.ArrayList;
import java.util.Calendar;

public class TriggersUnusualSpendingEmail {
	FetchesUserPaymentsByMonthWrapper fetchesUserPaymentsByMonthWrapper;
	EmailsUserWrapper emailsUserWrapper;
	Payment payment;

	public void trigger(long userId) {
		Calendar cal = Calendar.getInstance();
		ArrayList<Payment> currentMonthPayments = fetchesUserPaymentsByMonthWrapper.fetch(
				userId, cal.get(Calendar.MONTH), cal.get(Calendar.YEAR));
		ArrayList<Payment> previousMonthPayments = fetchesUserPaymentsByMonthWrapper.fetch(
				userId, cal.get(Calendar.MONTH) - 1, cal.get(Calendar.YEAR));
		ArrayList<Category> categories =
				payment.determineCategoriesSpentMoreThisMonth(currentMonthPayments, previousMonthPayments);
		emailsUserWrapper.email();
	}

}
