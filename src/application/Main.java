package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Main {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		Department department = new Department(0, departmentName);

		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.nextLine();
		System.out.print("Base Salary: ");
		Double baseSalary = sc.nextDouble();
		sc.nextLine();

		System.out.print("How many contracts to this worker? ");
		Integer quantityContracts = sc.nextInt();
		sc.nextLine();

		Worker worker = new Worker(0, name, WorkerLevel.valueOf(level), baseSalary, department);

		for (int i = 0; i < quantityContracts; i++) {
			System.out.printf("Enter Contract #%d data: %n", (i + 1));

			System.out.print("Date: ");
			Date date = sdf.parse(sc.nextLine());

			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();
			sc.nextLine();

			System.out.print("Duration (hours) : ");
			Integer hours = sc.nextInt();
			sc.nextLine();


			worker.addContract(new HourContract(0, date, valuePerHour, hours));
		}

		System.out.println("");
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthYear = sc.nextLine();
		System.out.println("");

		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		
		Integer year = Integer.parseInt(monthYear.substring(3));
		Integer month = Integer.parseInt(monthYear.substring(0, 2));
		System.out.printf("Income for %s: %.2f%n", monthYear, worker.income(year, month));
		
		System.out.println("----------------------");
		System.out.println(departmentName);
		System.out.println(department);
		System.out.println(worker);

		sc.close();
	}

}
