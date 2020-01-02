package hello;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class BirthdayServiceImpl implements BirthdayService {

	@Override
	public String getUserBirthday(String userName) throws Exception {

		FileInputStream fis;
		ObjectInputStream inputObjectStream = null;
		HashMap<String, String> userBirthdayMap = null;

		fis = new FileInputStream("birthdayObj.ser");
		inputObjectStream = new ObjectInputStream(fis);
		
		Object object = inputObjectStream.readObject();
		userBirthdayMap = (HashMap<String, String>) object;

		return userBirthdayMap.get(userName);
	}

	@Override
	public void createOrUpdateUserBirthday(String userName, String dateOfBirth) throws Exception {

		userBirthdayMap.put(userName, dateOfBirth);
		FileOutputStream outputFile = null;
		ObjectOutputStream outputStream = null;

		outputFile = new FileOutputStream("birthdayObj.ser");
		outputStream = new ObjectOutputStream(outputFile);
		outputStream.writeObject(userBirthdayMap);
		

	}

}
