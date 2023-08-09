package vehicle;
import dao.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer{
	
	
	private String name;
	private String userName;
	private String passWord;
	public Customer(){}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public static void takeInput() {
		Scanner scan =new Scanner(System.in);
		System.out.println("             ");
		System.out.println("---------------WELCOME FOR VEHICLE LOAN SYSTEM-------------");
		System.out.println("             ");
		System.out.println("Enter 1 for new user to SignUp :");
		System.out.println("Enter 2 for existing user to LogIn:");
		Customer cust=new Customer();
		int option=scan.nextInt();
		if(option==1) {
			Scanner scanner =new Scanner(System.in);
			System.out.println("---------CREATE ACCOUNT--------");
			System.out.println("Enter the Name to Register :");
			String nameOfCustomer=scanner.nextLine();
			System.out.println("Enter the UserName :");
			String newUserName=scanner.nextLine();
			System.out.println("Enter the new PassWord :");
			String newPassWord=scanner.nextLine();
			System.out.println("Account is created and You Loged In Succesfully");
			cust.name=nameOfCustomer;
			cust.passWord=newPassWord;
			cust.userName=newUserName;
			Eligibilty obj1=new Eligibilty();
			Application obj2=obj1.fillApplication(cust);
			System.out.println(obj2.toString());
			Loan obj=obj2.applyForLoan(obj2,cust);
			System.out.println("-----------Processing your Eiligibility-----------");
			if(obj1.checkEligibility(obj)==true) {
				System.out.println("Loan is Granted");
				double emi=obj.CalculateEMI(obj);
				System.out.println("EMI was :"+emi);
				takeInput();
			}
			else {
				System.out.println("Loan is not granted ");
				takeInput();
			}
		}
		else if(option==2) {
		
			System.out.println("----------LOG IN-------------");
			Scanner scanner =new Scanner(System.in);
			System.out.println("Enter the UserName :");
			String userName=scanner.nextLine();
			System.out.println("Enter the PassWord :");
			String passWord=scanner.nextLine();
			System.out.println("Enter the Application Id :");
			int appId=scanner.nextInt();
			LoanDAO loanDaoObj1=new LoanDAOImplementation();
			Loan loanUserCheck=loanDaoObj1.selectLoanApplication(appId);
			if(loanUserCheck==null) {
				System.out.println("You Entered wrong UserId and Password :");
				takeInput();
			}
			else
			{
				String nameOfUser=loanUserCheck.getName();
				System.out.println(nameOfUser+" you Logged In Succesful :");
				System.out.println("--------------------------");
				String status=loanUserCheck.getReport();
				System.out.println("Status of your Application :"+status);
                if(loanUserCheck.getLoanGranted()==false) {
                	System.out.println("You can Update Again your Details to get Loan :");
                	cust.setName(nameOfUser);
                	cust.setUserName(userName);
                	cust.setPassWord(passWord);
                	Eligibilty obj1=new Eligibilty();
        			Application obj2=obj1.fillApplication(cust);
        			System.out.println(obj2.toString());
        			Loan obj=obj2.applyForLoan(obj2,cust);
        			System.out.println("-----------Processing your Eiligibility-----------");
        			if(obj1.checkEligibility(obj)==true) {
        				System.out.println("Loan is Granted");
        				double emi=obj.CalculateEMI(obj);
        				System.out.println("EMI was :"+emi);
        				takeInput();
        			}
        			else {
        				System.out.println("Loan is not granted ");
        				takeInput();
        			}
                	
                }
			}
			
			
		}
		else {
			System.out.println("You Entered the Incorrect Option...!");
			System.out.println("Please Enter the Correct Option :");
			takeInput();
		}
	}
	
}