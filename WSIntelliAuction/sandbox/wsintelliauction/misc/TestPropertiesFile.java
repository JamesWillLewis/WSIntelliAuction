package wsintelliauction.misc;

public class TestPropertiesFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Configuration.setProperty("ui", "com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		Configuration.store();
	}

}
