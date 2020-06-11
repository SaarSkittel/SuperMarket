package Model;

//Factory Design Pattern
public class EmployeeFactory {
	public static Employee creatEmployee(String i_Name,String i_ID, float i_HourlyWage, float i_MonthlyHours, Model.job e_JobType){
		
		Employee newEmployee = null;
		
		if (e_JobType == Model.job.Manager)
		{
			newEmployee = new Manager(i_Name, i_ID, i_HourlyWage);
		}
		else if(e_JobType == Model.job.StoreWorker)
		{
			newEmployee = new StoreWorker(i_Name, i_ID, i_HourlyWage);
		}
		else if(e_JobType == Model.job.Storekeeper)
		{
			newEmployee = new Storekeeper(i_Name, i_ID, i_HourlyWage);
		}
		
		return newEmployee;
	}
	public static <T> T as(Class<T> clazz, Object o){
	    if(clazz.isInstance(o)){
	        return clazz.cast(o);
	    }
	    return null;
	}
}
