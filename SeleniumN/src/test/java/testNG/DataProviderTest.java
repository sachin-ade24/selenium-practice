package testNG;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	//DP -- Test Data
	@DataProvider
	public Object[][] getTestData() {
		return new Object[][] {
			{4, 5,  9},
			{3, 4,  7},
			{-4,-4,-8},
			{0, 3,  3}
		};
	}
	
	//Test Case with different test data -- data driven test approach: Parameterization 
	@Test(dataProvider = "getTestData")
	public void additionTest(int num1, int num2, int expectedSum) {
		int actualSum = add(num1, num2);
		Assert.assertEquals(actualSum, expectedSum);
	}
	
	//Function
	public int add(int num1, int num2) {
		int sum = num1 + num2;
		return sum;
	}
	
}
