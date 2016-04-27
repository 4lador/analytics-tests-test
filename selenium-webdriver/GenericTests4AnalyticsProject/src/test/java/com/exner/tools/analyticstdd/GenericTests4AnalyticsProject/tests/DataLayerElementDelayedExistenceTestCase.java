package com.exner.tools.analyticstdd.GenericTests4AnalyticsProject.tests;

public class DataLayerElementDelayedExistenceTestCase extends WebDriverBasedTestCase {
	private String _elementName;
	private long _milliseconds;

	public DataLayerElementDelayedExistenceTestCase(String pageURL, String elementName, long delay) {
		super(pageURL);
		_elementName = elementName;
		_milliseconds = delay;
		setName("Data Layer element" + elementName + " exists after " + delay + "ms - " + pageURL);
	}

	@Override
	protected void runTest() throws Throwable {
		// wait
		Thread.sleep(_milliseconds);

		// get the value of the dl element from the page
		Object response = _jsExecutor.executeScript(
				"if (typeof " + _elementName + " !== 'undefined') { return true } else { return false }");

		// make sure the element exists
		if (Boolean.class.isAssignableFrom(response.getClass())) {
			assertTrue("Data Layer element " + _elementName + " must exist after " + _milliseconds + "ms",
					(Boolean) response);
		} else {
			fail("Data Layer element " + _elementName + " does not exist");
		}

	}

}
