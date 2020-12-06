import java.util.Locale;

public class Statistics {

	private int soldTicketNum;
	private int soldTicketPrice;

	private final int totalPrice;
	private final int rowsNum;
	private final int seatsNum;

	public Statistics(int rowsNum, int seatsNum) {
		this.rowsNum = rowsNum;
		this.seatsNum = seatsNum;
		int middle = rowsNum / 2;
		this.totalPrice =  (rowsNum * seatsNum < 60)
				? rowsNum * seatsNum * 10
				: ((rowsNum - middle) * 10 + middle * 8) * seatsNum;
	}

	public void incrementSoldTicketNum() {
		soldTicketNum ++;
	}

	public void addSoldTicketNum(int sum) {
		soldTicketPrice += sum;
	}

	public double getAllPercentage() {
		return (double) (100 * soldTicketNum) / (rowsNum * seatsNum);
	}

	public String getSoldTicketNumData() {
		return String.format(Locale.US,"Number of purchased tickets: %d", soldTicketNum);
	}

	public String getSoldTicketPriceData() {
		return String.format("Current income: $%d", soldTicketPrice);
	}

	public String getTotalPriceData() {
		return String.format("Total income: $%d", totalPrice);
	}

	public String getPercentageData() {
		return String.format("Percentage: %.2f%%", getAllPercentage());
	}
}
