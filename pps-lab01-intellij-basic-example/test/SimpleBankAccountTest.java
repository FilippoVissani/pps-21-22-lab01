import lab01.example.model.SimpleBankAccount;
import org.junit.jupiter.api.BeforeEach;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest extends AbstractSimpleBankAccountTest {

    @Override
    @BeforeEach
    void beforeEach(){
        super.beforeEach();
        bankAccount = new SimpleBankAccount(INITIAL_BALANCE, accountHolder);
    }

    @Override
    int getFee() {
        return 0;
    }
}
