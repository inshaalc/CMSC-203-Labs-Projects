public class SavingsAccount extends BankAccount 
{
	// Instance Variables
	private static double rate = 0.025;
	private int savingsNumber = 0;
	
	private String accountNumber;
	
	// Constructor
	public SavingsAccount(String name, double amount)
	{
		super(name, amount);
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}
	
	// Post Interest Method
	public void postInterest()
	{
		double monthlyRate = rate / 12;
		double oneMonthOfInterest = monthlyRate * getBalance();
		super.deposit(oneMonthOfInterest);
	}
	
	// Get Account Number Method (overrides super class method)
	@Override
	public String getAccountNumber()
	{
		return this.accountNumber;
	}
	
	// Copy Constructor
	public SavingsAccount(SavingsAccount oldAccount, double amount)
	{
		super(oldAccount, amount);
		savingsNumber = oldAccount.savingsNumber + 1;
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}
}
