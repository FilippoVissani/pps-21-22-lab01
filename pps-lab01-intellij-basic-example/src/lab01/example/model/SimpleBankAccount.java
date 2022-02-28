package lab01.example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccount extends AbstractSimpleBankAccount {

    public SimpleBankAccount(final double balance, final AccountHolder holder) {
        super(balance, holder);
    }

    @Override
    protected int getFee() {
        return 0;
    }
}
