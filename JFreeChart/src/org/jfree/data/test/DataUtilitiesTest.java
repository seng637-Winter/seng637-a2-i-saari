package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jmock.Mockery;
import org.jmock.Expectations;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void calculateColumnTotalForTwoValues() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() {{
			oneOf(values).getRowCount();
			will(returnValue(2));
			oneOf(values).getValue(0,0);
			will(returnValue(7.5));
			oneOf(values).getValue(1, 0);
			will(returnValue(2.5));
		}});
		
		// exercise
		double result = DataUtilities.calculateColumnTotal(values, 0);
		
		// verify
		assertEquals(10.0, result, .000000001d);
	}

}
