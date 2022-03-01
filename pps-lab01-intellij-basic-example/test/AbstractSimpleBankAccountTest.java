import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractSimpleBankAccountTest {

    public static final int INITIAL_BALANCE = 0;
    public static final int DEPOSIT_AMOUNT = 100;
    public static final int WITHDRAW_AMOUNT = 70;

    protected BankAccount bankAccount;
    protected AccountHolder accountHolder;

    @BeforeEach
    void beforeEach(){
        String name = "Mario";
        String surname = "Rossi";
        int id = 1;
        accountHolder = new AccountHolder(name, surname, id);

    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(accountHolder.getId(), WITHDRAW_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT - WITHDRAW_AMOUNT - getFee(), bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        int userID = 2;
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(userID, WITHDRAW_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testInitialBalance() {
        int expectedBalance = 0;
        assertEquals(expectedBalance, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        int userID = 2;
        int depositAmount = 50;
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.deposit(userID, depositAmount);
        assertEquals(DEPOSIT_AMOUNT, bankAccount.getBalance());
    }

    abstract int getFee();
}
