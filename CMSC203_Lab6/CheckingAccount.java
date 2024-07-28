public class CheckingAccount extends BankAccount
{
	// Constant
	private static final double FEE = 0.15;
	
	// Constructor 1
	public CheckingAccount(String name, double amount)
	{
		super(name, amount);
		
		String originalAccountNumber = super.getAccountNumber();
		String newAccountNumber = originalAccountNumber + "-10";
		setAccountNumber(newAccountNumber);
	}
	
	// Withdraw Instance Method
	@Override
	public boolean withdraw(double amount)
	{
		double totalAmount = amount + FEE;
		
		return super.withdraw(totalAmount);
	}
}
