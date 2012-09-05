package wsintelliauction.test;

import static org.junit.Assert.*;

import org.junit.Test;

import wsintelliauction.server.backend.Driver;


public class ServerTest {

	@Test
	public final void testMain() {
		Driver.main(new String[]{"arg1","arg2","arg3"});
	}

}
