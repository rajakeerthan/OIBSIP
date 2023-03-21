import java.util.Scanner;
interface BankOperations {
    public void credentialsCheck(String Username, String password) throws Exception;
    public void credit(double amount) throws Exception;
    public void debit(double amount) throws Exception;
    public void displayBalance() throws Exception;
    public void exit();
}
class BankAccount implements BankOperations {
    private double balance;
    private String username;
    private String password;
    private static final String[] ACCOUNTS = { "lavanya", "@1224", "harshith", "2848","manoj","1657" };
    public BankAccount(String uname, String pswd) throws Exception {
        username = uname;
        password = pswd;
        credentialsCheck(username, password);
    }
    public void credentialsCheck(String uname, String pswd) throws Exception {
        boolean isValid = false;
        for (int i = 0; i < ACCOUNTS.length; i += 2) {
            if (ACCOUNTS[i].equals(uname) && ACCOUNTS[i + 1].equals(pswd)) {
                isValid = true;
                break;
            }
        }
        if (!isValid) {
            throw new Exception("credentials mismatch");
        }
    }
    public void credit(double amount) {
        balance += amount;
    }
    public void debit(double amount) throws Exception {
        if (amount > balance) {
            throw new Exception("Requested amount is unavailable");
        }
        balance -= amount;
    }
    public void displayBalance() {
        System.out.println("Current balance: " + balance);
    }
    public void exit() {
        System.out.println("Exiting the system");   
    }
}
public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        try {
            BankAccount account = new BankAccount(username, password);
            while (true){
                System.out.println("Select an option:");
                System.out.printf("1. Credit\n2.debit\n3.diaplayBalanace\n4.Exit\n");
                int k = sc.nextInt();
                switch (k) {
                case 1:
                    System.out.print("Enter amount to credit: ");
                    double creditAmount = sc.nextDouble();
                    account.credit(creditAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to debit: ");
                    double debitAmount = sc.nextDouble();
                    try {
                        account.debit(debitAmount);
                        } 
                	  catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    account.exit();
                    System.exit(0);
                }
            }
        } 
       catch (Exception e){
	        System.out.println(e);
        }
       finally{
	            System.out.println("final");
       } 
   }
}
