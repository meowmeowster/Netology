
package ru.netology.unit;

import org.junit.jupiter.api.Test;
import ru.netology.service.CashbackHackService;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CashbackHackServiceTest {
	@Test
	void shouldReturn10IfAmountIs2000() {
		CashbackHackService service = new CashbackHackService();
		int amount = 2000;

		int actual = service.remain(amount);
		int expected = 0;

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturnZeroIfAmountLowerThan1000() {
		CashbackHackService service = new CashbackHackService();
		int amount = 900;

		int actual = service.remain(amount);
		int expected = 101;

		assertEquals(expected, actual);
	}
}