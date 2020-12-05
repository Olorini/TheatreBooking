import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of rows:");
		int rows = scanner.nextInt();
		System.out.println("Enter the number of seats in each row:");
		int seats = scanner.nextInt();

		Hall hall = new Hall(rows, seats);
		PriceList priceList = new PriceList(rows, seats);
		Statistics statistics = new Statistics(rows, seats);
		do {
			Menu.showActions();
			int action = scanner.nextInt();
			switch (action) {
				case 1:
					Menu.showHallMap(hall);
					break;
				case 2:
					Menu.showPrice(hall, priceList, scanner);
					break;
				case 3:
					Menu.showStatistics(statistics);
					break;
				case 0:
					return;
			}
		} while (true);
	}
}
