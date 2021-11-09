package BaiTapHuongDoiTuong;

import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class Person {
	private String birthday;
	private String gender; // girl = true, boy = false
	private String blood_type;
	/**
	 * @param birthday
	 * @param gender
	 * @param blood_type
	 */
	public Person() {
		super();
	}
	public Person(String birthday, String gender, String blood_type) {
		super();
		this.birthday = birthday;
		this.gender = gender;
		this.blood_type = blood_type;
	}
	public void InputPerson() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("birthday(DD/MM/YYYY)= ");
		this.birthday = scanner.nextLine();
		System.out.print("blood type= ");
		this.blood_type = scanner.next();
		System.out.print("gender(true is girl / false is boy)= ");
		this.gender = scanner.next();
		
		//scanner.close();
	}
	public String getBirthday() {
		final String BIRTHDAY_PARTTERN = "\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}";
		if (Pattern.matches(BIRTHDAY_PARTTERN, birthday)) {
			return birthday;
		} else {
			return "invalid !";
		}
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String isGender() {
		boolean isGender = Boolean.parseBoolean(gender);
		if (!isGender) {
			gender = "nam";
		} else {
			gender = "nữ";
		} 
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBlood_type() {
		return blood_type;
	}
	public void setBlood_type(String blood_type) {
		this.blood_type = blood_type;
	}
}
