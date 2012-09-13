package wsintelliauction.misc;

import static org.junit.Assert.*;

import org.junit.Test;

public class RuntimeParamParserTest {

	@Test
	public final void test1() {
		String[] argument = { "-h", "-v", "-d" };
		RuntimeParamParser parser1 = new RuntimeParamParser(argument);
		assertTrue(parser1.getParam(RuntimeParamParser.DEBUG_OPTION).flagged);
		assertTrue(parser1.getParam(RuntimeParamParser.HELP_OPTION).flagged);
		assertTrue(parser1.getParam(RuntimeParamParser.VERSION_OPTION).flagged);
		assertFalse(parser1.getParam(RuntimeParamParser.MODE_OPTION).flagged);
	}

	@Test
	public final void test2() {
		String[] argument = { "-h", "-v", "-d", "-m", "mode1" };
		RuntimeParamParser parser1 = new RuntimeParamParser(argument);
		assertTrue(parser1.getParam(RuntimeParamParser.DEBUG_OPTION).flagged);
		assertTrue(parser1.getParam(RuntimeParamParser.HELP_OPTION).flagged);
		assertTrue(parser1.getParam(RuntimeParamParser.VERSION_OPTION).flagged);
		assertTrue(parser1.getParam(RuntimeParamParser.MODE_OPTION).flagged);
	}

	@Test
	public final void test3() {
		String[] argument = { "-m", "-h" };
		RuntimeParamParser parser1 = new RuntimeParamParser(argument);
		assertFalse(parser1.getParam("-m").flagged);
	}

	@Test
	public final void test4() {
		String[] argument = { "-h", "hvalue" };
		RuntimeParamParser parser1 = new RuntimeParamParser(argument);
		assertTrue(parser1.getParam("-h").flagged);
		assertFalse(parser1.getParam("-v").flagged);
	}

	@Test
	public final void test5() {
		String[] argument = { "-h", "-m", "mode1" };
		RuntimeParamParser parser1 = new RuntimeParamParser(argument);
		assertNull(parser1.getParam("-x"));
		assertTrue(parser1.getParam(RuntimeParamParser.MODE_OPTION).flagged);
		assertEquals("mode1", parser1.getParam(RuntimeParamParser.MODE_OPTION).value);
	}

}
