import errors.NoSuchSeatException;

public class Hall {

	private final char[][] location;
	private final int rowsNumber;
	private final int seatsNumber;

	public Hall(int rowsNumber, int seatsNumber) {
		this.rowsNumber = rowsNumber;
		this.seatsNumber = seatsNumber;
		this.location = new char[rowsNumber + 2][seatsNumber + 1];
		fill();
	}

	public char[][] getLocation() {
		return location;
	}

	public int getRowsNumber() {
		return rowsNumber;
	}

	public int getSeatsNumber() {
		return seatsNumber;
	}

	public boolean wasSold(int row, int seat) {
		if (isExists(row, seat)) {
			return location[row][seat] == 'B';
		} else {
			return true;
		}
	}

	public void markAsSold(int row, int seat) {
		if (isExists(row, seat)) {
			location[row][seat] = 'B';
		}
	}

	public char getCoordinateValue (int row, int seat) throws NoSuchSeatException {
		if (isExists(row, seat)) {
			return location[row][seat];
		} else {
			throw  new NoSuchSeatException("Wrong input!");
		}
	}

	public boolean isExists(int row, int seat) {
		return row <= rowsNumber && row > 0 && seat <= seatsNumber && seat > 0;
	}

	private void fill() {
		location[0][0] = ' ';
		for (int i = 1; i <= seatsNumber; i++) {
			location[0][i] = (char) (i + '0');
		}
		for (int i = 1; i <= rowsNumber + 1; i++) {
			location[i][0] = (char) (i + '0');
		}
		for (int i = 1; i <= rowsNumber; i++) {
			for (int j = 1; j <= seatsNumber; j++) {
				location[i][j] = 'S';
			}
		}
	}
}
