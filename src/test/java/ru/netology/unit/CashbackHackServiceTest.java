
package ru.netology.unit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.netology.service.CashbackHackService;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CashbackHackServiceTest {

	private final String exceptionMessage = "amount must be greater than zero";

	@Test
	void shouldReturn1IfAmountIs999999999() {
		CashbackHackService service = new CashbackHackService();
		int amount = 999999999;

		int actual = service.remain(amount);
		int expected = 1;

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnErrorIfAmountIs0() {
		CashbackHackService service = new CashbackHackService();
		int amount = 0;

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			service.remain(amount);
		});

		String expectedMessage = exceptionMessage;
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));

	}

	@Test
	void shouldReturnErrorIfAmountIsBelow0() {
		CashbackHackService service = new CashbackHackService();
		int amount = -100000000;
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			service.remain(amount);
		});

		String expectedMessage = exceptionMessage;
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void shouldReturnErrorIfOverflow() {
		CashbackHackService service = new CashbackHackService();
		int amount = 999999999 + 999999999 + 999999999;
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			service.remain(amount);
		});

		String expectedMessage = exceptionMessage;
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
	void shouldReturnDataAccordingToTable(String input, String expect) {
		CashbackHackService service = new CashbackHackService();
		int amount = Integer.parseInt(input);
		int expected = Integer.parseInt(expect);
		int actual = service.remain(amount);
		assertEquals(expected, actual);
	}
}