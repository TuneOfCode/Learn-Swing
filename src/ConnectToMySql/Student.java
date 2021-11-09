package ConnectToMySql;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Student extends Person implements Tax{
	private String name, studentID, phone, email;
	private double income;
	private int startTime, endTime;
	public Student() {
		super();
	}
	public Student(String birthday, String gender, 
		String blood_type, String name, String studentID, String phone, String email, double income, int startTime, int endTime) {
		super(birthday, gender, blood_type);
		this.name = name;
		this.studentID = studentID;
		this.phone = phone;
		this.email = email;
		this.income = income;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public void Input() {
		Scanner scanner = new Scanner(System.in);
			System.out.print("studentID= ");
			studentID = scanner.nextLine();
			System.out.print("name= ");
			name = scanner.nextLine();
			System.out.print("phone= ");
			phone = scanner.nextLine();
			System.out.print("email= ");
			email = scanner.nextLine();
			this.InputPerson();
			System.out.println();
		//scanner.close();
	}
	public void Output() {
		System.out.println("studentID is " + this.getStudentID());
		System.out.println("name is " + this.getName());
		System.out.println("phone is " + this.getPhone());
		System.out.println("email is " + this.getEmail());
		System.out.println("birthday is " + this.getBirthday());
		System.out.println("gender is " + this.isGender());
		System.out.println("blood type is " + this.getBlood_type());
		//System.out.println("Tax is " + this.payTax(11000000, 1, 6) + " VND");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getPhone() {
		// check format phone number VietNam
//		final String PHONE_PATTERN = 
//				"^(84|0[3|5|7|8|9])+([0-9]{8})\\b$";
//		if (Pattern.matches(PHONE_PATTERN, phone)) {
//			return phone;
//		} else {
//			return "invalid !";
//		}
		return phone;
		
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		// check format email
//		final String EMAIL_PATTERN = 
//				"^[\\w+][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
//		if (Pattern.matches(EMAIL_PATTERN,email)) {
//			return email;
//		} else {
//			return "invalid !";
//		}
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	@Override
	public double payTax(double income, int start_time, int end_time) {
		this.income = income;
		this.startTime = start_time;
		this.endTime = end_time;
		double TaxPercent = (income > (11 * Math.pow(10, 6))) ? (0.5 / 100) : 0;
		double TaxStudent = income * TaxPercent * Math.abs(end_time - start_time); 
		return TaxStudent;
	}
	
}