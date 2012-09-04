package com.uct.cs.wsintelliauction.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.uct.cs.wsintelliauction.server.backend.Driver;

public class ServerTest {

	@Test
	public final void testMain() {
		Driver.main(new String[]{"arg1","arg2","arg3"});
	}

}
