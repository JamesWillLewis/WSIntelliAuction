package com.uct.cs.wsintelliauction.test;
import static org.junit.Assert.*;

import org.junit.Test;

import com.uct.cs.wsintelliauction.client.back_end.Driver;


public class ClientTest {

	@Test
	public final void testMain() {
		Driver.main(new String[]{"arg1","arg2","arg3"});
	}

}
