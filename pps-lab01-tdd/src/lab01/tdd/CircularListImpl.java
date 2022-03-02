package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private static final int FIRST_INDEX = 0;
    private final List<Integer> list;
    private int currentIndex;

    public CircularListImpl() {
        list = new ArrayList<>();
        currentIndex = list.listIterator().nextIndex();
    }

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        currentIndex = list.listIterator(currentIndex).hasNext() ? currentIndex : FIRST_INDEX;
        Integer element = list.listIterator(currentIndex).next();
        currentIndex = currentIndex + 1;
        return Optional.of(element);
    }

    @Override
    public Optional<Integer> previous() {
        currentIndex = list.listIterator(currentIndex).hasPrevious() ? currentIndex : list.size();
        Integer element = list.listIterator(currentIndex).previous();
        currentIndex = currentIndex - 1;
        return Optional.of(element);
    }

    @Override
    public void reset() {
        currentIndex = FIRST_INDEX;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        return Optional.empty();
    }
}
