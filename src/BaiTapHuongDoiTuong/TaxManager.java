package BaiTapHuongDoiTuong;

import java.util.ArrayList;
import java.util.Scanner;

public class TaxManager {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		/* ========== STUDENT ========== */
		ArrayList<Student> students = new ArrayList<>();
		System.out.print("A number of students are ");
		int n_students = scanner.nextInt();
		double TaxStudent = 0;
		for (int i=0; i<n_students;i++) {
			System.out.println("Enter student information " + (i+1) + ": ");
			Student student = new Student();
			student.Input();
			students.add(student);
		}
		
		for (int i=0; i<students.size(); i++) {
			System.out.print("income of " + students.get(i).getStudentID() + "= ");
			Double incomeStudent = scanner.nextDouble();
			System.out.print("start time of " + students.get(i).getStudentID() + "= ");
			int start_time = scanner.nextInt();
			System.out.print("end time of " + students.get(i).getStudentID() + "= ");
			int end_time = scanner.nextInt();
			TaxStudent = students.get(i).payTax(incomeStudent, start_time, end_time);
			System.out.println("\n========== " + students.get(i).getStudentID() + " ==========");
			//System.out.println("\nStudent information " + (i+1) + " is ");
			students.get(i).Output();
			System.out.println("Tax of " + students.get(i).getStudentID() + " is " + (long) Math.floor(TaxStudent) + " VND");
			System.out.println();
		}
		System.out.println();
		
		/* ========== WORKER ========== */
		ArrayList<Worker> workers = new ArrayList<>();
		System.out.print("A number workers are ");
		int n_workers = scanner.nextInt();
		double TaxWorker = 0;
		for (int i=0; i<n_workers;i++) {
			System.out.println("Enter worker information " + (i+1) + ": ");
			Worker worker = new Worker();
			worker.Input();
			workers.add(worker);
		}
		
		for (int i=0; i<workers.size(); i++) {
			System.out.print("income of " + workers.get(i).getCitizenID() + "= ");
			Double incomeWorker = scanner.nextDouble();
			System.out.print("start time of " + workers.get(i).getCitizenID() + "= ");
			int start_time = scanner.nextInt();
			System.out.print("end time of " + workers.get(i).getCitizenID() + "= ");
			int end_time = scanner.nextInt();
			TaxWorker = workers.get(i).payTax(incomeWorker, start_time, end_time);
			System.out.println("\n========== " + workers.get(i).getCitizenID() + " ==========");
			//System.out.println("\nWorker information " + (i+1) + " is ");
			workers.get(i).Output();
			System.out.println("Tax of " + workers.get(i).getCitizenID() + " is " + (long) Math.floor(TaxWorker) + " VND");
			System.out.println();
		}
		System.out.println();
		
		/* ========== BUSINESS PERSON ========== */
		ArrayList<BusinessPerson> businessPersons = new ArrayList<>();
		System.out.print("A number business person are ");
		int n_bp = scanner.nextInt();
		double TaxBusinessPerson = 0;
		for (int i=0; i<n_bp;i++) {
			System.out.println("Enter Business Person information " + (i+1) + ": ");
			BusinessPerson businessPerson = new BusinessPerson();
			businessPerson.Input();
			businessPersons.add(businessPerson);
		}
		
		for (int i=0; i<businessPersons.size(); i++) {
			System.out.print("income of " + businessPersons.get(i).getCitizenID() + "= ");
			Double incomeBusinessPerson = scanner.nextDouble();
			System.out.print("start time of " + businessPersons.get(i).getCitizenID() + "= ");
			int start_time = scanner.nextInt();
			System.out.print("end time of " + businessPersons.get(i).getCitizenID() + "= ");
			int end_time = scanner.nextInt();
			TaxBusinessPerson = businessPersons.get(i).payTax(incomeBusinessPerson, start_time, end_time);
			System.out.println("\n========== " + businessPersons.get(i).getCitizenID() + " ==========");
			//System.out.println("\nBusiness Person information " + (i+1) + " is ");
			businessPersons.get(i).Output();
			System.out.println("Tax of " + businessPersons.get(i).getCitizenID() + " is " + (long) Math.floor(TaxBusinessPerson) + " VND");
			System.out.println();
		}
		System.out.println();
		scanner.close();
	}
}
