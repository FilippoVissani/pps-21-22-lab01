package lab01.example;

import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;

public class Main {

    public static void main(String[] args) {
        final AccountHolder accountHolder = new AccountHolder("Mario", "Rossi", 1);
        final BankAccount bankAccount = new SimpleBankAccount(0, accountHolder);

        bankAccount.deposit(accountHolder.getId(), 100);

        System.out.println("Current balance is " + bankAccount.getBalance());

        bankAccount.withdraw(accountHolder.getId(), 30);

        System.out.println("Current balance is " + bankAccount.getBalance());

        bankAccount.withdraw(accountHolder.getId(), 80);

        System.out.println("Current balance is " + bankAccount.getBalance());
    }
}
