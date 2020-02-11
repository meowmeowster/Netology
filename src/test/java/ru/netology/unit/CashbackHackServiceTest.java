
package ru.netology.unit;

import org.junit.jupiter.api.Test;
import ru.netology.service.CashbackHackService;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CashbackHackServiceTest {
	@Test
	void shouldReturn0IfAmountIs2000() {
		CashbackHackService service = new CashbackHackService();
		int amount = 2000;

		int actual = service.remain(amount);
		int expected = 0;

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturn1IfAmountIs999() {
		CashbackHackService service = new CashbackHackService();
		int amount = 999;

		int actual = service.remain(amount);
		int expected = 1;

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturn999IfAmountIs1() {
		CashbackHackService service = new CashbackHackService();
		int amount = 1;

		int actual = service.remain(amount);
		int expected = 999;

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturn999IfAmountIs1001() {
		CashbackHackService service = new CashbackHackService();
		int amount = 1001;

		int actual = service.remain(amount);
		int expected = 999;

		assertEquals(expected, actual);
	}

	@Test
	void shouldReturn1IfAmountIs999999999() {
		CashbackHackService service = new CashbackHackService();
		int amount = 999999999;

		int actual = service.remain(amount);
		int expected = 1;

		assertEquals(expected, actual);
	}

}