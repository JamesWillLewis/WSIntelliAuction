package wsintelliauction.error;

import static org.junit.Assert.*;

import org.junit.Test;

import wsintelliauction.global.ErrorLogger;


public class ErrorLoggerTest {

	@Test
	public final void test() {
		ErrorLogger.log("TEST ERROR MESSAGE 1B");
		ErrorLogger.log("TEST ERROR MESSAGE 2B");
		ErrorLogger.log("TEST ERROR MESSAGE 3B");
	}

}
