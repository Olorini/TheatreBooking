import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class MenuTest {

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void checkHallMapOutput() {
		Hall hall = new Hall(5, 5);
		Menu.showHallMap(hall);
		String seatsMap = "Cinema:\n" +
				"  1 2 3 4 5\n" +
				"1 S S S S S\n" +
				"2 S S S S S\n" +
				"3 S S S S S\n" +
				"4 S S S S S\n" +
				"5 S S S S S\n".trim();
		Assert.assertEquals(seatsMap, systemOutRule.getLog().trim().replace("\r",""));
	}

	@Test
	public void checkActionsOutput() {
		Menu.showActions();
		String actions = "1. Show the seats\n" +
				"2. Buy a ticket\n" +
				"3. Statistics\n" +
				"0. Exit".trim();
		Assert.assertEquals(actions, systemOutRule.getLog().trim().replace("\r",""));
	}

	@Test
	public void checkPriceOutput() {
		Hall hall = new Hall(5, 5);
		PriceList priceList = new PriceList(hall);
		Statistics statistics = new Statistics(5, 5);

		Menu.getPrice(priceList, statistics, hall, new Scanner(System.in), 1, 1);
		String price = "Ticket price: $10".trim();
		Assert.assertEquals(price, systemOutRule.getLog().trim().replace("\r",""));
	}

	@Test
	public void checkIsNotExistSeatPriceOutput() {
		Hall hall = new Hall(5, 5);
		PriceList priceList = new PriceList(hall);
		Statistics statistics = new Statistics(5, 5);

		final String testString = "7\n2\n3\n5\n";
		ByteArrayInputStream testIn = new ByteArrayInputStream(testString.getBytes());

		Menu.showPrice(hall, priceList, statistics, new Scanner(testIn));
		String price = "Enter a row number:\n" +
				"Enter a seat number in that row:\n" +
				"Wrong input!\n" +
				"Enter a row number:\n" +
				"Enter a seat number in that row:\n" +
				"Ticket price: $10\n".trim();
		Assert.assertEquals(price, systemOutRule.getLog().trim().replace("\r",""));
	}


}
