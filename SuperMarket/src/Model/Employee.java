package Model;
import java.util.*;
import Model.job;
public abstract class Employee extends Person {
	
	private float MonthlyHours;
	private float HourlyWage;
	private Model.job job;
	
 	public Employee(String i_Name,String i_ID, float i_HourlyWage,Model.job e_JobType) {
		super(i_Name,i_ID);
		this.MonthlyHours = 0;
		this.HourlyWage=i_HourlyWage;
		this.job=e_JobType;
	}
	public String getName() {
		return super.getName();
	}
	public void setName(String i_Name) {
		super.setName(i_Name);
	}
	public String getID() {
		return super.getID();
	}
	public float getMountlyHours() {
		return this.HourlyWage;
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
	
	
	
}
