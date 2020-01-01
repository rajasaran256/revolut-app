package hello;

import java.util.HashMap;

interface BirthdayService {
	
	public static HashMap<String, String> userBirthdayMap = new HashMap<String, String>(25); 
	
	/**
	 * @param userName
	 * @return
	 * @throws Exception 
	 */
	public String getUserBirthday(String userName) throws Exception;
	
	/**
	 * Create or update username with their birthday details
	 * 
	 * @param userName
	 * @param dateOfBirth
	 * @throws Exception 
	 */
	public void createOrUpdateUserBirthday(String userName,String dob) throws Exception;

}
