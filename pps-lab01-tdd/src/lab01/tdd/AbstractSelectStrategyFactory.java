package lab01.tdd;

import java.util.Optional;

public abstract class AbstractSelectStrategyFactory {

    public abstract Optional<SelectStrategy> getSelectStrategy(Optional<Integer> number);
}
