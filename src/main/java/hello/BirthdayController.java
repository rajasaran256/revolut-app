package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class BirthdayController {

	@Autowired
	private BirthdayService birthdayService;

	@GetMapping("/hello/{name}")
	public String getUserBirthday(@PathVariable String name) {

		String dateOfBirth;
		try {
			dateOfBirth = birthdayService.getUserBirthday(name);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Error occured while getting the username with Date of Birth details");
		}

		if (dateOfBirth == null) {
			return "User Name doesn't exists in the System";
		}

		// Convert date in to days and return the values with the user name
		int days = Utility.getBirthdaysByDateOfBirth(dateOfBirth);

		if (days == 0) {
			return "Hello, " + name + "! Happy  Birthday";
		}
		return "Hello, " + name + "! Your  Birthday is in " + days + "day(s)";
	}

	@PutMapping("/hello/{name}")
	public void createOrUpdateUserBirthday(@PathVariable String name, @RequestBody BirthDay birthday) {

		// Check the name contains only alphabets - use a regex pattern
		boolean isValidUserName = Utility.isStringOnlyAlphabet(name);

		if (isValidUserName) {

			try {
				birthdayService.createOrUpdateUserBirthday(name, birthday.getBirthDate());
			} catch (Exception e) {
				e.printStackTrace();
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
						"Error occured while storing the username with Date of Birth details");
			}

		}

		else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Username should contain only the alphabetic characters in the path variable");
		}

	}

}
