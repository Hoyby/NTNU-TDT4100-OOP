package encapsulation;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Person {

	private String firstName;
	private String lastName;
	private String email;
	private Date birthday;
	private char gender ;

	public void setName(String name) {
		if (!name.matches("([A-Za-z]{2,} +[A-Za-z]{2,})")) {
			throw new IllegalArgumentException("Both first and last name must be longer than 2 characters");
		}
		String[] namel = name.split(" ");
		this.firstName = namel[0];
		this.lastName = namel[1];
	}

	public void setEmail(String email) {
		List<String> countryCodes = Arrays.asList(
		"ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar",
		"as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be",
		"bf", "bg", "bh", "bi", "bj", "bl", "bm", "bn", "bo", "bq",
		"br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd",
		"cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr",
		"cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm",
		"do", "dz", "ec", "ee", "eg", "eh", "er", "es", "et", "fi",
		"fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf",
		"gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs",
		"gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu",
		"id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it",
		"je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn",
		"kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk",
		"lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "me",
		"mf", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq",
		"mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", "na",
		"nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu",
		"nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm",
		"pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs",
		"ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si",
		"sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st", "sv",
		"sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk",
		"tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua",
		"ug", "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi",
		"vn", "vu", "wf", "ws", "ye", "yt", "za", "zm", "zw");
		
		String lastLettersOfEmail = String.valueOf(email.charAt(email.length() - 2)) + String.valueOf(email.charAt(email.length() - 1));
		if (!email.matches(firstName.toLowerCase() +"\\."+ lastName.toLowerCase() + "(?:@[a-z0-9]+\\.[a-z]{2})")) {
			throw new IllegalArgumentException("Please enter email in the current format: \"firstname.lastname@domain.xx");
		}else if(!countryCodes.contains(lastLettersOfEmail)){
			throw new IllegalArgumentException("The country-code you entered is not valid.");
		}
		this.email = email;
	}

	public void setBirthday(Date date) {
		if (date.compareTo(new Date()) > 0) {
			throw new IllegalArgumentException("Birthday cannot be in the future");
		}
		this.birthday = date;
	}

	public void setGender(char gender) {
		if (gender != 77 && gender != 70 && gender != 0) {
			throw new IllegalArgumentException("Allowed genders: \"M/F/0\"");
		}
		this.gender = gender;
	}

	//	-----------------------------


	public String getName() {
		return firstName + " " + lastName;
	}

	public String getEmail() {
		return email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public char getGender() {
		return gender;
	}


	public Person() {
		super();
	}
	
	
	
	@Override
	public String toString() {
		return "Person [name=" + getName() + ", email=" + email + ", birthdate=" + birthday + ", gender=" + gender + "]";
	}

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setName("John Doe");
		p1.setEmail("john.doe@gba4loyc6q1uj6hdy4.ad");
		p1.setGender('M');
		System.out.println(p1.toString());
	}

}
