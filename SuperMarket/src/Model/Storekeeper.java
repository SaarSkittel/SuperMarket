package Model;

public class Storekeeper extends Employee{
	private static Model.job i_StorekeeperJob =job.Storekeeper;
	public Storekeeper(String i_Name,String i_ID, float i_HourlyWage) {
		super(i_Name, i_ID, i_HourlyWage,i_StorekeeperJob);
	
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
		return super.getMountlyHours();
	}
	public void setMounthlyHours(float i_MounthlyHours) {
		super.setMounthlyHours(i_MounthlyHours);
	}
	public float getHourlyWage() {
		return super.getHourlyWage();
	}
	public void setHourlyWage(float i_HourlyWage) {
		super.setHourlyWage(i_HourlyWage);
	}
	public Model.job getJobType(){
		return super.getJobType();
	}
}
