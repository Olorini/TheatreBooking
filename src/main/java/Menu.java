import java.util.Scanner;

public class Menu {

	public static void showActions() {
		System.out.println("1. Show the seats");
		System.out.println("2. Buy a ticket");
		System.out.println("3. Statistics");
		System.out.println("0. Exit");
	}

	public static void showHallMap(Hall hall) {
		System.out.println("Cinema:");
		for (int i = 0; i <= hall.getRowsNumber(); i++) {
			for (int j = 0; j <= hall.getSeatsNumber(); j++) {
				System.out.print(hall.getCoordinateValue(i, j) + " ");
			}
			System.out.print("\n");
		}
	}

	public static void showPrice(Hall hall, PriceList priceList, Scanner scanner) {
		System.out.println("Enter a row number:");
		int row = scanner.nextInt();
		System.out.println("Enter a seat number in that row:");
		int seat = scanner.nextInt();
		if (!hall.isExists(row, seat)) {
			System.out.println("Wrong input!");
			showPrice(hall, priceList, scanner);
		} else if (hall.wasSold(row, seat)) {
			System.out.println("That ticket has already been purchased");
			showPrice(hall,priceList, scanner);
		} else {
			getPrice(priceList, row);
			hall.markAsSold(row, seat);
		}
	}

	public static void getPrice(PriceList priceList, int row) {
		int price = priceList.getPrice(row);
		Statistics.incrementSoldTicketNum();
		Statistics.addSoldTicketNum(price);
		System.out.printf("Ticket price: $%d", price);
		System.out.print("\n");
	}

	public static void showStatistics(Statistics statistics) {
		System.out.println(statistics.getSoldTicketNumData());
		System.out.println(statistics.getPercentageData());
		System.out.println(statistics.getSoldTicketPriceData());
		System.out.println(statistics.getTotalPriceData());
	}

}
