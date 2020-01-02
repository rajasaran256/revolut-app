package hello;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BirthdayServiceImpl implements BirthdayService {

	private static Logger logger = LoggerFactory.getLogger(BirthdayServiceImpl.class);

	@Value("${file.path}")
	private String filePath;

	@Override
	public String getUserBirthday(String userName) throws Exception {

		FileInputStream fis;
		ObjectInputStream inputObjectStream = null;
		HashMap<String, String> userBirthdayMap = null;

		fis = new FileInputStream(filePath);
		inputObjectStream = new ObjectInputStream(fis);

		Object object = inputObjectStream.readObject();

		logger.debug("Username read operation from the object file is successfull");

		userBirthdayMap = (HashMap<String, String>) object;

		return userBirthdayMap.get(userName);
	}

	@Override
	public void createOrUpdateUserBirthday(String userName, String dateOfBirth) throws Exception {

		userBirthdayMap.put(userName, dateOfBirth);
		FileOutputStream outputFile = null;
		ObjectOutputStream outputStream = null;

		outputFile = new FileOutputStream(filePath);
		outputStream = new ObjectOutputStream(outputFile);
		outputStream.writeObject(userBirthdayMap);

		logger.debug("Username write operation to the object file is successfull");

	}

}
