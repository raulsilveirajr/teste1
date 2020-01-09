package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private Integer id;
	private String name;
	private WorkerLevel level;
	private Double baseSalary;

	private Department department;
	private List<HourContract> contracts = new ArrayList<>();

	public Worker(Integer id, String name, WorkerLevel level, Double baseSalary, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
		this.contracts = contracts;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public void addContract(HourContract contract) {
		this.contracts.add(contract);
	}

	public void removeContract(HourContract contract) {
		this.contracts.remove(contract);
	}

	public Double income(Integer year, Integer month) {
		double sum = this.baseSalary;
		Calendar cal = Calendar.getInstance();
		for (HourContract hourContract : contracts) {
			cal.setTime(hourContract.getDate());
			if ((cal.get(Calendar.YEAR) == year) && ((cal.get(Calendar.MONTH)+1) == month)) {
				sum += hourContract.totalValue();
			}
		}

		return sum;
	}

	@Override
	public String toString() {
		return "Worker [id=" + id + ", name=" + name + ", level=" + level + ", baseSalary=" + baseSalary
				+ ", department=" + department + ", contracts=" + contracts + "]";
	}

}
