
package ru.netology.unit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.netology.service.CashbackHackService;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CashbackHackServiceTest {

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
		String expected = "amount must be greater than zero";
		try {
			service.remain(amount);
		} catch (IllegalArgumentException actual) {
			assertEquals(expected, actual.getMessage());
		}
	}

	@Test
	void shouldReturnErrorIfAmountIsBelow0() {
		CashbackHackService service = new CashbackHackService();
		int amount = -100000000;
		String expected = "amount must be greater than zero";
		try {
			service.remain(amount);
		} catch (IllegalArgumentException actual) {
			assertEquals(expected, actual.getMessage());
		}
	}

	@Test
	void shouldReturnErrorIfOverflow() {
		CashbackHackService service = new CashbackHackService();
		int amount = 999999999 + 999999999 + 999999999;
		String expected = "amount must be greater than zero";
		try {
			service.remain(amount);
		} catch (IllegalArgumentException actual) {
			assertEquals(expected, actual.getMessage());
		}
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