import errors.NoSuchSeatException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PriceListTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void checkRightPriceForSmallHall() throws NoSuchSeatException {
		PriceList priceList = new PriceList(new Hall(4, 4));
		Assert.assertEquals(priceList.getPrice(1, 1), 10);
		Assert.assertEquals(priceList.getPrice(2, 1), 10);
		Assert.assertEquals(priceList.getPrice(3, 1), 10);
		Assert.assertEquals(priceList.getPrice(4, 1), 10);
	}

	@Test(expected = NoSuchSeatException.class)
	public void checkWrongPriceForSmallHall() throws NoSuchSeatException {
		PriceList priceList = new PriceList(new Hall(4, 4));
		priceList.getPrice(10, 1);
	}

	@Test
	public void checkRightPriceForLargeHall() throws NoSuchSeatException {
		PriceList priceList = new PriceList(new Hall(7, 9));
		Assert.assertEquals(priceList.getPrice(1, 1), 10);
		Assert.assertEquals(priceList.getPrice(2, 1), 10);
		Assert.assertEquals(priceList.getPrice(3, 1), 10);
		Assert.assertEquals(priceList.getPrice(4, 1), 8);
		Assert.assertEquals(priceList.getPrice(5, 1), 8);
		Assert.assertEquals(priceList.getPrice(6, 1), 8);
		Assert.assertEquals(priceList.getPrice(7, 1), 8);
	}

}
