package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeTest {

	private Range testRange1;
	private Range testRange2;
	private Range testRange3;
	private Range testRange4;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		testRange1 = new Range(-10, -5);
		testRange2 = new Range(-1, 1);
		testRange3 = new Range(-5, 5);
		testRange4 = new Range(5, 7);
	}

	@After
	public void tearDown() throws Exception {
	}
	
//	Tests for constrain
	
	//this test covers the above upper bound case for value in the constrain method using a range of (-1, 1)
	@Test
	public void constrain_ValueAboveUpperBound_ReturnsUpperBound() {
		assertEquals("Contrain with value of 1.1 should be 1", 1, testRange2.constrain(1.1), .000000001d);
	}
	
	//this test covers the upper bound case for value in the constrain method using a range of (-1, 1)
	@Test
	public void constrain_ValueUpperBound_ReturnsUpperBound() {
		assertEquals("Contrain with value of 1 should be 1", 1, testRange2.constrain(1), .000000001d);
	}
	
	//this test covers the below upper bound case for value in the constrain method using a range of (-1, 1)
	@Test
	public void constrain_ValueBelowUpperBound_ReturnsInputValue() {
		assertEquals("Contrain with value of 0.9 should be 0.9", 0.9, testRange2.constrain(0.9), .000000001d);
	}
	
	//this test covers the between bounds case for value in the constrain method using a range of (-1, 1)
	@Test
	public void constrain_ValueBetweenBounds_ReturnsInputValue() {
		assertEquals("Contrain with value of 0 should be 0", 0, testRange2.constrain(0), .000000001d);
	}
	
	//this test covers the above lower bound case for value in the constrain method using a range of (-1, 1)
	@Test
	public void constrain_ValueAboveLowerBound_ReturnsInputValue() {
		assertEquals("Contrain with value of -0.9 should be -0.9", -0.9, testRange2.constrain(-0.9), .000000001d);
	}
	
	//this test covers the lower bound case for value in the constrain method using a range of (-1, 1)
	@Test
	public void constrain_ValueLowerBound_ReturnsLowerBound() {
		assertEquals("Contrain with value of -1 should be -1", -1, testRange2.constrain(-1), .000000001d);
	}
	
	//this test covers the below lower bound case for value in the constrain method using a range of (-1, 1)
	@Test
	public void constrain_ValueBelowLowerBound_ReturnsLowerBound() {
		assertEquals("Contrain with value of -1.1 should be -1", -1, testRange2.constrain(-1.1), .000000001d);
	}
	
//	Tests for getLength
	
	//this test covers the negative range values case for the getLength method with a range of (-10,-5)
	@Test
	public void getLength_NegativeRange_ReturnsLength() {
		assertEquals("Length should be 5", 5, testRange1.getLength(), .000000001d);
	}
	
	//this test covers the mixed range values case for the getLength method with a range of (-5,5)
	@Test
	public void getLength_MixedRange_ReturnsLength() {
		assertEquals("Length should be 10", 10, testRange3.getLength(), .000000001d);
	}
	
	//this test covers the positive range values length case for the getLength method with a range of (5,7)
	@Test
	public void getLength_PositiveRange_ReturnsLength() {
		assertEquals("Length should be 2", 2, testRange4.getLength(), .000000001d);
	}
	
//	Tests for getLowerBound
	
	//this test covers the negative range values case for the getLowerBound method with a range of (-10,-5)
	@Test
	public void getLowerBound_NegativeRange_LowerBound() {
		assertEquals("Lower Bound should be -10", -10, testRange1.getLowerBound(), .000000001d);
	}
	
	//this test covers the mixed range values case for the getLowerBound method with a range of (-5,5)
	@Test
	public void getLowerBound_MixedRange_LowerBound() {
		assertEquals("Lower Bound should be -5", -5, testRange3.getLowerBound(), .000000001d);
	}
	
	//this test covers the positive range values case for the getLowerBound method with a range of (5,7)
	@Test
	public void getLowerBound_PositiveRange_LowerBound() {
		assertEquals("Lower Bound should be 5", 5, testRange4.getLowerBound(), .000000001d);
	}
	
//	Tests for getUpperBound
	
	
	//this test covers the negative range values case for the getUpperBound method with a range of (-10, -5)
	@Test
	public void getUpperBound_NegativeRange_UpperBound() {
		assertEquals("Upper Bound should be -5", -5, testRange1.getUpperBound(), .000000001d);
	}
	
	//this test covers the mixed range values case for the getUpperBound method with a range of (-5,5)
	@Test
	public void getUpperBound_MixedRange_UpperBound() {
		assertEquals("Upper Bound should be 5", 5, testRange3.getUpperBound(), .000000001d);
	}
	
	//this test covers the positive range values case for the getUpperBound method with a range of (5,7)
	@Test
	public void getUpperBound_PositiveRange_UpperBound() {
		assertEquals("Upper Bound should be 7", 7, testRange4.getUpperBound(), .000000001d);
	}
	
//	Tests for contain
	
	//this test covers the above upper bound case for value in the contains method using a range of (-10,-5)
	@Test
	public void contains_ValueAboveUpperBound_ReturnsFalse() {
		assertFalse("Contains with value of -4.9 should be False", testRange1.contains(-4.9));
	}
	
	//this test covers the upper bound case for value in the contains method using a range of (-10,-5)
	@Test
	public void contains_ValueUpperBound_ReturnsTrue() {
		assertTrue("Contains with value of -5 should be True", testRange1.contains(-5));
	}
	
	//this test covers the below upper bound case for value in the contains method using a range of (-10,-5)
	@Test
	public void contains_ValueBelowUpperBound_ReturnsTrue() {
		assertTrue("Contains with value of -5.1 should be True", testRange1.contains(-5.1));
	}
	
	//this test covers the between bounds case for value in the contains method using a range of (-10,-5)
	@Test
	public void contains_ValueBetweenBounds_ReturnsTrue() {
		assertTrue("Contains with value of -7.5 should be True", testRange1.contains(-7.5));
	}
	
	//this test covers the above lower bound case for value in the contains method using a range of (-10,-5)
	@Test
	public void contains_ValueAboveLowerBound_ReturnsTrue() {
		assertTrue("Contains with value of -9.9 should be True", testRange1.contains(-9.9));
	}
	
	//this test covers the lower bound case for value in the contains method using a range of (-10,-5)
	@Test
	public void contains_ValueLowerBound_ReturnsTrue() {
		assertTrue("Contains with value of -10 should be True", testRange1.contains(-10));
	}
	
	//this test covers the below lower bound case for value in the contains method using a range of (-10,-5)
	@Test
	public void contains_ValueBelowLowerBound_ReturnsFalse() {
		assertFalse("Contains with value of -10.1 should be False", testRange1.contains(-10.1));
	}
	
	
	
}
