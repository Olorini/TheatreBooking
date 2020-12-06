import errors.NoSuchSeatException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class HallTest {

	private Hall hall;

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Before
	public void setUp() {
		this.hall = new Hall(6, 6);
	}

	@Test
	public void checkEmptyHallFill() {
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 6; j++) {
				Assert.assertTrue(hall.isExists(i, j));
			}
		}
		Assert.assertFalse(hall.isExists(1, 7));
		Assert.assertFalse(hall.isExists(0, 0));
		Assert.assertFalse(hall.isExists(7, 0));
	}

	@Test
	public void checkSeatBooking() throws NoSuchSeatException {
		hall.markAsSold(1, 1);
		Assert.assertTrue(hall.wasSold(1, 1));
		Assert.assertEquals(hall.getCoordinateValue(1, 1), 'B');
		hall.markAsSold(9, 9);
	}
}
