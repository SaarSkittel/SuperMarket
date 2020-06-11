package Model;
import java.util.*;
import Model.job;
public abstract class Employee extends Person {
	
	private float MonthlyHours;
	private float HourlyWage;
	private Model.job job;
	
 	public Employee(String i_ID, String i_Name, float i_HourlyWage, job e_JobType) {
		super(i_Name,i_ID);
		this.MonthlyHours = 0;
		this.HourlyWage=i_HourlyWage;
		this.job=e_JobType;
	}
 	public Employee(Employee i_Employee) {
        super(i_Employee.getName(),i_Employee.getID());
        this.MonthlyHours = i_Employee.getMountlyHours();
        this.HourlyWage=i_Employee.getHourlyWage();
        this.job=i_Employee.getJobType();
    }
 	public Employee(String i_ID, String i_Name, float i_HourlyWage, float i_MonthlyHours, job e_JobType) {
		super(i_Name,i_ID);
		this.MonthlyHours = i_MonthlyHours;
		this.HourlyWage=i_HourlyWage;
		this.job=e_JobType;
	}
 	
	public float getMountlyHours() {
		return this.MonthlyHours;
	}
	public void setMounthlyHours(float i_MounthlyHours) {
		this.MonthlyHours=i_MounthlyHours;
	}
	public float getHourlyWage() {
		return this.HourlyWage;
	}
	public void setHourlyWage(float i_HourlyWage) {
		this.HourlyWage=i_HourlyWage;
	}
	public Model.job getJobType(){
		return this.job;
	}
	public void setJobType(Model.job i_Job) {
		this.job = i_Job;
	}
}
