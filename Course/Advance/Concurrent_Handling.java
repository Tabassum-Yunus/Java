package Week12;

import java.util.concurrent.ExecutorService;    //Interface, to allow exexute tasks on threads asynchronously
import java.util.concurrent.Executors;          // Class, providses Utility methods for ExecutorService
import java.util.concurrent.TimeUnit;
import java.util.HashMap;
import java.util.Map;

class BankAccount {
    private int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized void deposit(double amount) {
        if (amount > 0)
            balance += amount;
        else
            System.out.println("Please Insert valid amount.");
    }

    public synchronized void withdraw(double amount) {
        if (amount > 0 && balance >= amount) 
            balance -= amount;
        else
            System.out.println("Sorry, Balance is not sufficient."); 
    }
}

class AccountManager {
    private final Map<Integer, BankAccount> accounts = new HashMap<>();

    public synchronized void addAccount(BankAccount account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public void deposit(int accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            synchronized (account) {
                account.deposit(amount);
            }
        }
    }

    public synchronized void withdraw(int accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
            if (account != null){
                account.withdraw(amount); 
            } 
 
    }

    public synchronized void printBalances() {
        System.out.print(Thread.currentThread().getName()+"\n");
        
        accounts.forEach((accountNumber, account) -> {
            System.out.println(" Account: "+accountNumber+", Balance: "+account.getBalance());
        });

//        for(Map.Entry<Integer, BankAccount> entry : accounts.entrySet()){
//            System.out.println(" Account: "+entry.getKey()+", Balance: "+entry.getValue());
//        }
    }
}

public class Concurrent_Handling {

    public static void main(String[] args) throws InterruptedException {
        final AccountManager manager = new AccountManager();

        BankAccount account1 = new BankAccount(1, 1000);
        BankAccount account2 = new BankAccount(2, 2000);

        manager.addAccount(account1);
        manager.addAccount(account2);

        ExecutorService executor = Executors.newFixedThreadPool(3);     // Creates a thread pool

       
        //executor.execute(() -> manager.withdraw(1, 200));             
        
        executor.execute(new Runnable() {               // Anonymous class, to execute a new thread in a ppooled thread
            @Override
            public void run() {
                manager.deposit(1, 200);
                manager.printBalances();
            }
        });
        
        executor.execute(() ->{
            manager.withdraw(2, 500);   // Lambda expression, to execute a new thread in a ppooled thread
              manager.printBalances();
        });
        
        executor.execute(() ->{
            manager.withdraw(1, 300);
            manager.printBalances();
        });
        
        executor.execute(() -> {
            manager.deposit(2, 400);
            manager.printBalances();
        });
        
        

        executor.shutdown();
        
        //executor.close();
        
        //executor.execute(() -> manager.withdraw(2, 700));         // Exception (RejectedExecutionException)
        
        executor.awaitTermination(1, TimeUnit.MINUTES);

        // Print final balances
        System.out.println("");
        manager.printBalances();
    }
}

