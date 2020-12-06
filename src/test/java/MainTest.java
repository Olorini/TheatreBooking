import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class MainTest {

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void checkAllBookingAlgorithm() {
		final String testString = "6\n6\n3\n2\n1\n1\n3\n2\n1\n1\n10\n20\n4\n4\n1\n3\n0\n";
		ByteArrayInputStream testIn = new ByteArrayInputStream(testString.getBytes());

		Main.start(new Scanner(testIn));
		String stepsOutput = getOutput().trim();
		Assert.assertEquals(stepsOutput, systemOutRule.getLog().trim().replace("\r",""));
	}

	private  String getOutput() {
		StringBuilder contentBuilder = new StringBuilder();
		try (Stream<String> stream = Files.lines( Paths.get("src/test/resources/output_data.txt"), StandardCharsets.UTF_8)) {
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contentBuilder.toString();
	}
}
