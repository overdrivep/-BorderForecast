package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateCheckLogicTestTest {

	@Test
	final void testTestGetDay() {
		DateCheckLogicTest dc = new DateCheckLogicTest();
		assertEquals(2, dc.testGetDay());
	}

}
