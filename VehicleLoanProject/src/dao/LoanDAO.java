package dao;
import java.util.List;
import vehicle.*;
public interface LoanDAO {
        public void insertLoanApplication(Loan loan);
        public Loan selectLoanApplication(int appliId);
        public List<Loan> selectLoanApplications();
        public void updateLoanApplication(Loan loan);
        public void deleteLoanApplication(Loan loan);
        
}
