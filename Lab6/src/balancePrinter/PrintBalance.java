package balancePrinter;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * TODO A simple class that needs to be localized
 * 
 * @author mohan. Created Mar 27, 2011.
 */
public class PrintBalance {

	/**
	 * Simple Java Method that is crying out to be localized.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

		Scanner scanInput = new Scanner(System.in);
		Date today = new Date();

		printBalance(scanInput, System.out, today, new Locale("de", "DE"), new BigDecimal(9876543.21));
		
	}

	public static void printBalance(Scanner scanInputStream, PrintStream outputStream, Date balanceDate, Locale locale, BigDecimal balance) {
		ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		
		// Greeting
		outputStream.println((messages.getString("greeting")));

		// Get User's Name
		outputStream.println((messages.getString("usernameQuestion")));
		String name = scanInputStream.nextLine();
		outputStream.println((MessageFormat.format(messages.getString("userGreeting"), name)));

		// print today's date, balance and bid goodbye
		outputStream.println((MessageFormat.format(messages.getString("dateIntro"), dateFormatter.format(balanceDate))));
		outputStream.println((MessageFormat.format(messages.getString("balanceStatement"), currencyFormatter.format(balance))));
		outputStream.println((messages.getString("farewell")));

	}
}