import errors.NoSuchSeatException;

public class PriceList {

	private final int middle;
	private final Hall hall;

	public PriceList(Hall hall) {
		this.hall = hall;
		this.middle = hall.getRowsNumber() / 2;
	}

	public int getPrice(int row, int seat) throws NoSuchSeatException {
		if (hall.isExists(row, seat) ) {
			if (!hall.wasSold(row, seat)) {
				return (hall.getRowsNumber() * hall.getSeatsNumber() >= 60 && row > middle) ? 8 : 10;
			} else {
				throw new NoSuchSeatException("That ticket has already been purchased!");
			}
		} else {
			throw new NoSuchSeatException("Wrong input!");
		}
	}
}
