package org.jfree.data.test;
import java.security.InvalidParameterException;
import static org.junit.Assert.*;
import org.jmock.Mockery;
import org.jmock.Expectations;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jfree.data.KeyedValues;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DataUtilitiesTest extends DataUtilities {
	Mockery values2DMockingContext;
	Mockery keyedValuesMockingContext; 
	double [] dataArray; 
	double [] invalidDataArray;
	Number [] expectedNumberArray;
	double [][] dataArray2D; 
	double [][] invalidDataArray2D; 
	Number [][] expected2DNumberArray;
	Values2D values;
	Values2D invalidValues; 
	KeyedValues inputValuePairs;
	KeyedValues invalidKeyedValues; 
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// setup for testing calculateColumnTotal and calculateRowTotal
		values2DMockingContext = new Mockery();
		values = values2DMockingContext.mock(Values2D.class);
		
		values2DMockingContext.checking(new Expectations() {{
			oneOf(values).getRowCount();
			will(returnValue(2));
			oneOf(values).getColumnCount(); 
			will(returnValue(2)); 
			allowing(values).getValue(0,0);
			will(returnValue(7.5));
			oneOf(values).getValue(1, 0);
			will(returnValue(2.5));
			oneOf(values).getValue(0, 1); 
			will(returnValue(6.7));
		}});
		
		invalidValues = null; 
		
		// setup for testing createNumberArray
		dataArray = new double[]{10.5, -6.7};
		expectedNumberArray = new Number[]{10.5, -6.7};
		invalidDataArray = null;
		
		// setup for testing create2DNumberArray
		dataArray2D = new double [][] {{-6.5, 15.2},{3.8, 8.4}};
		expected2DNumberArray = new Number[][] {{-6.5, 15.2},{3.8, 8.4}};
		invalidDataArray2D = null;
		
		// setup for testing getCumulativePercentages
		keyedValuesMockingContext = new Mockery();
		inputValuePairs = keyedValuesMockingContext.mock(KeyedValues.class); 
		
		keyedValuesMockingContext.checking(new Expectations() {{
			allowing(inputValuePairs).getKey(0); 
			will(returnValue(0));
			allowing(inputValuePairs).getKey(1); 
			will(returnValue(1));
			allowing(inputValuePairs).getKey(2); 
			will(returnValue(2));
			allowing(inputValuePairs).getItemCount();
			will(returnValue(3));
			allowing(inputValuePairs).getValue(0); 
			will(returnValue(5)); 
			allowing(inputValuePairs).getValue(1); 
			will(returnValue(9)); 
			allowing(inputValuePairs).getValue(2); 
			will(returnValue(2)); 
		}});
		
		invalidKeyedValues = null; 
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none(); 
	
	// testing valid input for both the data and column index parameters
	@Test
	public void calculateColumnTotal_WithTwoValues() {
		// exercise
		double result = DataUtilities.calculateColumnTotal(values, 0);
		// verify
		assertEquals(10.0, result, .000000001d);
	}
	// testing for out of bounds index input for the column index parameter 
	@Test
	public void calculateColumnTotal_WithOutOfBoundsIndex() {
		// exercise
		exceptionRule.expect(InvalidParameterException.class);
		DataUtilities.calculateColumnTotal(values, 1);
	}
	// testing invalid input for the data parameter 
	@Test
	public void calculateColumnTotal_WithNull() {
		exceptionRule.expect(InvalidParameterException.class);
		DataUtilities.calculateColumnTotal(invalidValues, 0);  
	}
	// testing valid input for both the data and row index parameters
	@Test 
	public void calculateRowTotal_WithTwoValues() {
		// exercise
		double result = DataUtilities.calculateRowTotal(values, 0); 
		// verify
		assertEquals(14.2, result,.000000001d);
	}
	// testing for out of bounds index input for the row index parameter
	@Test
	public void calculateRowTotal_WithOutOfBoundsIndex() {
		exceptionRule.expect(InvalidParameterException.class);
		DataUtilities.calculateRowTotal(values, 1);
	}
	// testing invalid input for the data parameter 
	public void calculateRowTotal_WithNull() {
		exceptionRule.expect(InvalidParameterException.class);
		DataUtilities.calculateRowTotal(invalidValues, 0);  
	}
	// test valid input for the data parameter in the createNumberArray function
	@Test
	public void createNumberArray_WithTwoValues() {
		
		Number [] result = DataUtilities.createNumberArray(dataArray);
		
		assertArrayEquals(expectedNumberArray,result); 
	}
	// testing invalid input for the data parameter in the createNumberArray function
	public void createNumberArray_WithNull() {
		exceptionRule.expect(InvalidParameterException.class);
		DataUtilities.createNumberArray(invalidDataArray); 
	}
	// test valid input for the data parameter in the createNumberArray2D function
	@Test
	public void create2DNumberArray_WithFourValues() { 
		
		Number [][] result = DataUtilities.createNumberArray2D(dataArray2D); 
		
		assertArrayEquals(expected2DNumberArray,result); 
	}
	// testing invalid input for the data parameter in the createNumberArray2D function
	public void create2DNumberArray_WithNull() {
		exceptionRule.expect(InvalidParameterException.class);
		DataUtilities.createNumberArray2D(invalidDataArray2D); 
	}
	// test valid input for the data parameter in the getCumulativePercentages function
	@Test
	public void getCumulativePercentages_WithThreeVaues() {
		
		KeyedValues result = DataUtilities.getCumulativePercentages(inputValuePairs); 
		
		assertEquals(0.3125,result.getValue(0).doubleValue(),.000000001d);
		assertEquals(0.875,result.getValue(1).doubleValue(),.000000001d);
		assertEquals(1.0,result.getValue(2).doubleValue(),.000000001d);
	}
	// testing invalid input for the data parameter in the getCumulativePercentages function
	public void getCulativePercentages_WithNull() {
		exceptionRule.expect(InvalidParameterException.class);
		DataUtilities.getCumulativePercentages(invalidKeyedValues); 
	}

}
