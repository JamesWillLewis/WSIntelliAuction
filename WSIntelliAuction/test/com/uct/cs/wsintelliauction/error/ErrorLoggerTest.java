package com.uct.cs.wsintelliauction.error;

import static org.junit.Assert.*;

import org.junit.Test;

import com.uct.cs.wsintelliauction.tools.ErrorLogger;

public class ErrorLoggerTest {

	@Test
	public final void test() {
		ErrorLogger.submitError("TEST ERROR MESSAGE 1B");
		ErrorLogger.submitError("TEST ERROR MESSAGE 2B");
		ErrorLogger.submitError("TEST ERROR MESSAGE 3B");
	}

}
