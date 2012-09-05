package wsintelliauction.test;
import static org.junit.Assert.*;

import org.junit.Test;

import wsintelliauction.client.backend.Driver;



public class ClientTest {

	@Test
	public final void testMain() {
		Driver.main(new String[]{"arg1","arg2","arg3"});
	}

}
