package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vehicle.*;

public class LoanDAOImplementation implements LoanDAO{
	Connection conn;
	public LoanDAOImplementation() {
		try {
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			conn = 	DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertLoanApplication(Loan loan) {
		try {
			PreparedStatement pst = 
					conn.prepareStatement("INSERT INTO LOAN VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, loan.getName());
			pst.setString(2,loan.getUserId());
			pst.setString(3,loan.getPassWord());
			pst.setInt(4, loan.getAge());
			pst.setDouble(5,loan.getSalary());
			pst.setInt(6,loan.getCreditScore());
			pst.setString(7, loan.getVehicleModel());
			pst.setDouble(8,loan.getPrice());
			pst.setDouble(9,loan.getTentureOfLoan());
			pst.setDouble(10, loan.getInterestRate());
			pst.setDouble(11,loan.getDownPayment());
			pst.setBoolean(12,loan.getLoanGranted());
			pst.setString(13,loan.getReport());
			pst.setInt(14,loan.getApplicationId());
			
			int rows = pst.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Loan selectLoanApplication(int appId) {
		
		Loan loanObj=null;
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM LOAN WHERE APPLICATION_ID="+ appId);
			//Loan loanObj = new Loan();
			if(result.next()) {
				loanObj=new Loan();
				loanObj.setName(result.getString(1));
				loanObj.setUserId(result.getString(2));
				loanObj.setPassWord(result.getString(3));
				loanObj.setAge(result.getInt(4));
				loanObj.setSalary(result.getDouble(5));
				loanObj.setCreditScore(result.getInt(6));
				loanObj.setVehicleModel(result.getString(7));
				loanObj.setPrice(result.getDouble(8));
				loanObj.setTentureOfLoan(result.getDouble(9));
				loanObj.setIntrestRate(result.getFloat(10));
				loanObj.setDownPayment(result.getDouble(11));
				loanObj.setLoanGranted(result.getBoolean(12));
				loanObj.setReport(result.getString(13));
				loanObj.setApplicationId(result.getInt(14));
				return loanObj;
				
			}// TODO Auto-generated method stub
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public List<Loan> selectLoanApplications(){
		List<Loan> loanList = new ArrayList<Loan>();
		try {
			
			 
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery("SELECT * FROM LOAN");
			
			
			while(result.next()) {
				Loan loanObj = new Loan(); //blank object
				loanObj.setName(result.getString(1));
				loanObj.setUserId(result.getString(2));
				loanObj.setPassWord(result.getString(3));
				loanObj.setAge(result.getInt(4));
				loanObj.setSalary(result.getDouble(5));
				loanObj.setCreditScore(result.getInt(6));
				loanObj.setVehicleModel(result.getString(7));
				loanObj.setPrice(result.getDouble(8));
				loanObj.setTentureOfLoan(result.getDouble(9));
				loanObj.setIntrestRate(result.getFloat(10));
				loanObj.setDownPayment(result.getDouble(11));
				loanObj.setLoanGranted(result.getBoolean(12));
				loanObj.setReport(result.getString(13));
				loanObj.setApplicationId(result.getInt(14));
				loanList.add(loanObj); // add this object to the LIST 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loanList;
	}

	@Override
	public void updateLoanApplication(Loan loan) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst = 
					conn.prepareStatement("UPDATE LOAN set name=?, username=?,password=?,");
			
			
			pst.setString(1, loan.getName()); 
			pst.setString(2,loan.getUserId()); 
			pst.setString(3,loan.getPassWord()); 
			pst.setInt(4, loan.getAge());
			pst.setDouble(5,loan.getSalary());
			pst.setInt(6, loan.getCreditScore());
			pst.setString(7, loan.getVehicleModel());
			pst.setDouble(8,loan.getPrice());
			pst.setDouble(9,loan.getTentureOfLoan());
			pst.setDouble(10,loan.getInterestRate());
			pst.setDouble(11,loan.getDownPayment());
			pst.setBoolean(12,loan.getLoanGranted());
			pst.setString(13,loan.getReport());
			pst.setInt(14,loan.getApplicationId());
			

		
			int rows = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void deleteLoanApplication(Loan loan) {
		// TODO Auto-generated method stub
		
	}
	

}