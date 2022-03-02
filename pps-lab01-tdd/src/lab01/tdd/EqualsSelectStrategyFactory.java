package lab01.tdd;

import java.util.Optional;

public class EqualsSelectStrategyFactory extends AbstractSelectStrategyFactory {

    @Override
    public Optional<SelectStrategy> getSelectStrategy(Optional<Integer> number) {
        return number.isPresent() ? Optional.of(element -> element == number.get()) : Optional.empty();
    }
}
