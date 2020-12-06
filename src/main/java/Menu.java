import errors.NoSuchSeatException;

import java.util.Scanner;

public class Menu {

	public static void showActions() {
		System.out.println("1. Show the seats");
		System.out.println("2. Buy a ticket");
		System.out.println("3. Statistics");
		System.out.println("0. Exit");
	}

	public static void showHallMap(Hall hall) {
		char[][] location = hall.getLocation();
		System.out.println("Cinema:");
		for (int i = 0; i <= hall.getRowsNumber(); i++) {
			for (int j = 0; j <= hall.getSeatsNumber(); j++) {
				System.out.print(location[i][j]);
				if (j != hall.getSeatsNumber()) {
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
	}

	public static void showPrice(Hall hall,
	                             PriceList priceList,
	                             Statistics statistics,
	                             Scanner scanner) {
		System.out.println("Enter a row number:");
		int row = scanner.nextInt();
		System.out.println("Enter a seat number in that row:");
		int seat = scanner.nextInt();
		getPrice(priceList, statistics, hall, scanner, seat, row);
	}

	public static void getPrice(PriceList priceList,
	                            Statistics statistics,
	                            Hall hall,
	                            Scanner scanner,
	                            int seat,
	                            int row) {
		try {
			int price = priceList.getPrice(row, seat);
			statistics.incrementSoldTicketNum();
			statistics.addSoldTicketNum(price);
			System.out.printf("Ticket price: $%d\n", price);
			hall.markAsSold(row, seat);
		} catch (NoSuchSeatException e) {
			System.out.println(e.getMessage());
			showPrice(hall, priceList, statistics, scanner);
		}
	}

	public static void showStatistics(Statistics statistics) {
		System.out.println(statistics.getSoldTicketNumData());
		System.out.println(statistics.getPercentageData());
		System.out.println(statistics.getSoldTicketPriceData());
		System.out.println(statistics.getTotalPriceData());
	}

}
