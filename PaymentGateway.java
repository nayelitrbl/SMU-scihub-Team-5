package lab3;

public class PaymentGateway {
	 public boolean processPayment(String accountNumber, double amount) { 
	        // Simulate payment processing logic 
	        boolean result = false; 
	        if (amount > 0) { 
	            System.out.println("Payment Processed for: " + accountNumber + ", Amount: " + amount); 
	            result = true; 
	        } 
	        return result; 
	    } 
}
