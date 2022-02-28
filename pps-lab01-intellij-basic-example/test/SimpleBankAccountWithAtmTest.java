import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;

class SimpleBankAccountWithAtmTest extends AbstractSimpleBankAccountTest{

    @Override
    @BeforeEach
    void beforeEach() {
        super.beforeEach();
        bankAccount = new SimpleBankAccountWithAtm(INITIAL_BALANCE, accountHolder);
    }

    @Override
    int getFee() {
        return 1;
    }
}
