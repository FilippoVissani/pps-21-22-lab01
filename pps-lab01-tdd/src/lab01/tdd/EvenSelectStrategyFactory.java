package lab01.tdd;

import java.util.Optional;

public class EvenSelectStrategyFactory extends AbstractSelectStrategyFactory {

    @Override
    public Optional<SelectStrategy> getSelectStrategy(Optional<Integer> number) {
        return Optional.of(element -> element % 2 == 0);
    }
}
