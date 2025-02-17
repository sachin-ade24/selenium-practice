package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CRUDTest {
	
	//create -- get -- update -- delete
	//AAA -- Arrange -- Act -- Assertion
	//Arrange: 1. Set up the test by creating Objects, variables or other prerequisites
	//or       2. Set up the environment
	//Act: Execute the being tested
	//Assertion: Verify that the code behaved as expected
	
	public int createUser(int userId) {
		System.out.println("Create user with user id: " + userId);
		return userId;
	}
	
	public String getUserInfo(int userId) {
		return "User info with user id: " + userId;
	}
	
	public String updateUser(int userId) {
		return "Updated user info with user id: " + userId;
	}
	
	public String deleteUserInfo(int userId) {
		return "User is not found: 404 error.";
	}
	
	@Test
	public void createUserTest() {
		int userId = createUser(100);
		Assert.assertEquals(userId, 100);
	}
	
	@Test
	public void getUserTest() {
		int userId = createUser(200);
		String userInfo = getUserInfo(userId);
		Assert.assertEquals(userInfo, "User info with user id: " + userId);
	}
	
	@Test
	public void updateUserTest() {
		String updatedInfo = updateUser(100);
		String userInfo = getUserInfo(100);
		Assert.assertTrue(updatedInfo.contains(userInfo.toLowerCase()));
	}
	
	@Test
	public void deleteUserTest() {
		int userId = createUser(100);
		String userDeletedMsg = deleteUserInfo(userId);
		Assert.assertTrue(userDeletedMsg.contains("404"));
	}

}
