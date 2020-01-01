package hello;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BirthDay {
	
	

    @JsonFormat
      (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date birthDate;

	public String getBirthDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(birthDate);
	}

	public void setBirthDate(Date birthDate) {
		
		this.birthDate = birthDate;
	}
    
    

}
