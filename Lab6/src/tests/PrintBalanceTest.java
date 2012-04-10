package tests;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import balancePrinter.PrintBalance;

public class PrintBalanceTest {

    private PrintStream outputMock;
    private GregorianCalendar calendar;
    private Date date;
    private BigDecimal value;
    private String name;
    
	@Before
	public void setUp() {
		outputMock = createMock(PrintStream.class); 
		calendar = new GregorianCalendar();
		calendar.set(2012, 3, 9);
		date = calendar.getTime();
		value = new BigDecimal(9876543.21);
		name = "Caio";
	}

	@Test
	public void testPrintBalanceInEnglish() throws IOException {
		Locale americanLocale = new Locale("en", "US");
		
		outputMock.println("Hello World");
		outputMock.println("Please enter your name");
		outputMock.println("I am pleased to meet you " + name);
		outputMock.println("As of : Apr 9, 2012");
		outputMock.println("You owe the school $9,876,543.21");
		outputMock.println("Good Bye");
		
		replay(outputMock);
		
		PrintBalance.printBalance(new Scanner(name), outputMock, date, americanLocale, value);
		
		verify(outputMock);
	}
	
	@Test
	public void testPrintBalanceInFrench() throws IOException {
		Locale frenchLocale = new Locale("fr", "FR");
		
		outputMock.println("Bonjour tout le monde");
		outputMock.println("S'il vous plaît entrer votre nom");
		outputMock.println("Je suis heureux de vous rencontrer " + name);
		outputMock.println("Quant à : 9 avr. 2012");
		outputMock.println("Vous devez l'école 9 876 543,21 €");
		outputMock.println("Au revoir");
		
		replay(outputMock);
		
		PrintBalance.printBalance(new Scanner(name), outputMock, date, frenchLocale, value);
		
		verify(outputMock);
	}
	
	@Test
	public void testPrintBalanceInGerman() throws IOException {
		Locale germanLocale = new Locale("de", "DE");
		
		outputMock.println("Hallo Welt");
		outputMock.println("Bitte geben Sie Ihren Namen");
		outputMock.println("Ich freue mich, Sie kennen zu lernen " + name);
		outputMock.println("Ab : 09.04.2012");
		outputMock.println("Sie schulden die Schule 9.876.543,21 €");
		outputMock.println("Auf Wiedersehen");
		
		replay(outputMock);
		
		PrintBalance.printBalance(new Scanner(name), outputMock, date, germanLocale, value);
		
		verify(outputMock);
	}

}
