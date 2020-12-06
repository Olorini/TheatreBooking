import org.junit.Assert;
import org.junit.Test;

public class StatisticsTest {

	@Test
	public void checkStatisticsForEmptyHall() {
		Statistics statistics = new Statistics(6, 6);
		Assert.assertEquals(statistics.getSoldTicketNumData(), "Number of purchased tickets: 0");
		Assert.assertEquals(statistics.getSoldTicketPriceData(), "Current income: $0");
		Assert.assertEquals(statistics.getTotalPriceData(), "Total income: $360");
		Assert.assertEquals(statistics.getPercentageData(), "Percentage: 0,00%");
	}

	@Test
	public void checkStatisticsForTwoSeats() {
		Statistics statistics = new Statistics(6, 6);
		statistics.incrementSoldTicketNum();
		statistics.addSoldTicketNum(10);
		statistics.incrementSoldTicketNum();
		statistics.addSoldTicketNum(10);
		Assert.assertEquals(statistics.getSoldTicketNumData(), "Number of purchased tickets: 2");
		Assert.assertEquals(statistics.getSoldTicketPriceData(), "Current income: $20");
		Assert.assertEquals(statistics.getTotalPriceData(), "Total income: $360");
		Assert.assertEquals(statistics.getPercentageData(), "Percentage: 5,56%");
	}

	@Test
	public void checkStatisticsForFullHall() {
		Statistics statistics = new Statistics(6, 6);
		for (int i = 0; i < 36; i++) {
			statistics.incrementSoldTicketNum();
			statistics.addSoldTicketNum(10);
		}
		Assert.assertEquals(statistics.getSoldTicketNumData(), "Number of purchased tickets: 36");
		Assert.assertEquals(statistics.getSoldTicketPriceData(), "Current income: $360");
		Assert.assertEquals(statistics.getTotalPriceData(), "Total income: $360");
		Assert.assertEquals(statistics.getPercentageData(), "Percentage: 100,00%");
	}
}
