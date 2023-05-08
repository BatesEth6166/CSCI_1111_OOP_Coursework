import java.util.Date;

public class Exercise97 {

	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated;
	
	 public static void main(String[] args) {
	    
	        Exercise97 account = new Exercise97(1122, 20000);
	        
	       
	        account.setAnnualInterestRate(4.5);
	        
	    
	        account.withdraw(2500);
	        
	      
	        account.deposit(3000);
	        
	      
	        System.out.println("Balance: $" + account.getBalance());
	        System.out.println("Monthly Interest: $" + account.getMonthlyInterest());
	        System.out.println("Date Created: " + account.getDateCreated());
	    }
	
	public Exercise97() {	
		id = 0;
		balance = 0.0;
		annualInterestRate = 0.0;
		dateCreated = new Date();
	}
	  public Exercise97(int id, double balance) {
	        this.id = id;
	        this.balance = balance;
	        annualInterestRate = 0;
	        dateCreated = new Date();
	    }

	  public int getId() {
	        return id;
	    }
	    
	    public void setId(int id) {
	        this.id = id;
	    }
	    

	    public double getBalance() {
	        return balance;
	    }
	    
	    public void setBalance(double balance) {
	        this.balance = balance;
	    }
	    

	    public double getAnnualInterestRate() {
	        return annualInterestRate;
	    }
	    
	    public void setAnnualInterestRate(double annualInterestRate) {
	        this.annualInterestRate = annualInterestRate;
	    }
	    

	    public Date getDateCreated() {
	        return dateCreated;
	    }
	    

	    public double getMonthlyInterestRate() {
	        double realAnnualInterestRate = 0.0;
	        realAnnualInterestRate = annualInterestRate / 100;
	    	return realAnnualInterestRate / 12;
	    }
	    

	    public double getMonthlyInterest() {
	        return balance * getMonthlyInterestRate();
	    }
	    

	    public void withdraw(double amount) {
	        balance -= amount;
	    }
	    

	    public void deposit(double amount) {
	        balance += amount;
	    }
	}

