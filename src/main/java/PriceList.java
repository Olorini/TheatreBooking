public class PriceList {

	private final int rowsNumber;
	private final int seatsNumber;
	private final int middle;

	public PriceList(int rowsNumber, int seatsNumber) {
		this.rowsNumber = rowsNumber;
		this.seatsNumber = seatsNumber;
		this.middle = rowsNumber / 2;
	}

	public int getPrice(int row) {
		return (rowsNumber * seatsNumber >= 60 && row > middle) ? 8 : 10;
	}
}
