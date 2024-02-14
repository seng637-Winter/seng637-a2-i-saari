package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeTest {

	private Range testRange;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		testRange = new Range(-1, 1);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void constrain_AboveUpperBound_One() {
		assertEquals("Contrain with value of 1.1 should be 1", 1, testRange.constrain(1.1), .000000001d);
	}
	
	@Test
	public void constrain_UpperBound_One() {
		assertEquals("Contrain with value of 1 should be 1", 1, testRange.constrain(1), .000000001d);
	}
	
	@Test
	public void constrain_BelowUpperBound_InputValue() {
		assertEquals("Contrain with value of 0.9 should be 0.9", 0.9, testRange.constrain(0.9), .000000001d);
	}
	
	@Test
	public void constrain_Nominal_InputValue() {
		assertEquals("Contrain with value of 0 should be 0", 0, testRange.constrain(0), .000000001d);
	}
	
	@Test
	public void constrain_AboveLowerBound_InputValue() {
		assertEquals("Contrain with value of -0.9 should be -0.9", -0.9, testRange.constrain(-0.9), .000000001d);
	}
	
	@Test
	public void constrain_LowerBound_NegativeOne() {
		assertEquals("Contrain with value of -1 should be -1", -1, testRange.constrain(-1), .000000001d);
	}
	
	@Test
	public void constrain_BelowLowerBound_NegativeOne() {
		assertEquals("Contrain with value of -1.1 should be -1", -1, testRange.constrain(-1.1), .000000001d);
	}
	
	@Test
	public void getLength_ShouldBeTwo() {
		assertEquals("Length should be 2", 2, testRange.getLength(), .000000001d);
	}
	
	@Test
	public void getLowerBound_ShouldBeNegativeOne() {
		assertEquals("Lower Bound should be -1", -1, testRange.getLowerBound(), .000000001d);
	}
	
	@Test
	public void getUpperBound_ShouldBeOne() {
		assertEquals("Upper Bound should be 1", 1, testRange.getUpperBound(), .000000001d);
	}
}
