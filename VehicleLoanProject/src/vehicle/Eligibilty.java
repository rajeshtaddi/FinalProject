package vehicle;
import java.util.Scanner;

import dao.LoanDAO;
import dao.LoanDAOImplementation;

public

class Eligibilty{
	
	Application fillApplication(Customer obj) {
		Application app=new Application();
		//app.name=obj.getName();
		System.out.println("-----------------------");
		System.out.println("Filling Application");
		Scanner scann =new Scanner(System.in);
		app.setName(obj.getName());
		System.out.println("Enter the Age :");
		int ageOfCustomer=scann.nextInt();
		scann.nextLine();
		app.setAge(ageOfCustomer);
		System.out.println("Enter the Gender :");
		String genderOfCustomer=scann.nextLine();
		app.setGender(genderOfCustomer);
		System.out.println("Enter your Yearly Salary :");
		int salary=scann.nextInt();
		app.setYearlySalary(salary);
		System.out.println("Enter the Number of Existing EMIs :");
		int emi=scann.nextInt();
		app.setExistingEMIs(emi);
		app.setApplicationId(app);
		
		return app;
	}
	boolean checkEligibility(Loan objLoan) {
		LoanDAO loanDaoObj=new LoanDAOImplementation();
		int cibilScore=objLoan.getCreditScore();
		if(objLoan.getAge()<=21&&objLoan.getAge()>=60) {
			System.out.println("Age must be between 21 and 60:");
			String report="Age must be between 21 and 60";
			objLoan.setReport(report);
			loanDaoObj.insertLoanApplication(objLoan);
			return false;
		}
		else if(cibilScore<600) {
			System.out.println("Credit score must be above a certain threshold:");
			String report="Credit score must be above a certain threshold";
			objLoan.setReport(report);
			loanDaoObj.insertLoanApplication(objLoan);
			return false;
		}
		
		else if(objLoan.getSalary()<80000) {
			System.out.println("Your Salary is too Low for this Type of Loan :");
			String report="Your Salary is too Low for this Type of Loan";
			objLoan.setReport(report);
			loanDaoObj.insertLoanApplication(objLoan);
			return false;
		}
		else
		{
			objLoan.setLoanGranted(true);
			String report="Loan is Granted";
			objLoan.setReport(report);
			loanDaoObj.insertLoanApplication(objLoan);
			return true;
		}
	}
}