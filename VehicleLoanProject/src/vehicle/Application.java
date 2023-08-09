package vehicle;

import java.util.Scanner;

public class Application{
	//static int id=100;
	private int applicationId;
	private String name;
	private int age;
	private String gender;
	private int yearlySalary;
	private int existingEMIs;
	public void setApplicationId(Application obj) {
	double x=Math.random();
	x=x*1000000;
	this.applicationId=(int) x;
    }
    public int getApplicationId() {
	return applicationId;
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getYearlySalary() {
		return yearlySalary;
	}
	public void setYearlySalary(int yearlySalary) {
		this.yearlySalary = yearlySalary;
	}
	public int getExistingEMIs() {
		return existingEMIs;
	}
	public void setExistingEMIs(int existingEMI) {
		this.existingEMIs = existingEMI;
	}
	@Override
	public String toString() {
		return "Application [name=" + name + ", applicationId=" + applicationId +", age=" + age + ", gender=" + gender + ", yearlySalary=" + yearlySalary
				+ ", existingEMIs=" + existingEMIs + "]";
	}
	
	Loan applyForLoan(Application application,Customer cust) {
		System.out.println("--------Applying for the Vehicle Loan-------");
		Scanner scanner =new Scanner(System.in);
		Loan obj=new Loan();
		obj.setName(application.getName());	
		obj.setUserId(cust.getUserName());
		obj.setPassWord(cust.getPassWord());
		obj.setAge(application.getAge());
		obj.setSalary(application.getYearlySalary());
		obj.setApplicationId(application.getApplicationId());
		System.out.println("Enter the Vehicle Type :");
		String vehicle=scanner.nextLine();
		obj.setVehicleModel(vehicle);
		System.out.println("Enter the Road price of the Vehicle :");
		double price=scanner.nextDouble();
		obj.setPrice(price);
		System.out.println("Enter the Credit Score :");
		int  cibilScore=scanner.nextInt();
		obj.setCreditScore(cibilScore);
		System.out.println("Enter the DownPayment :");
		double downPayment=scanner.nextDouble();
		obj.setDownPayment(downPayment);
		System.out.println("Enter the Tensure of Loan in Years :");
		double tensure=scanner.nextDouble();
		obj.setTentureOfLoan(tensure);
		//obj.setPrincipalAmount(price, downPayment);
		System.out.println(obj);
		return obj;
	}
	
}