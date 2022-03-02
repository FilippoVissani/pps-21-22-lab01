import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;

    @BeforeEach
    void beforeEach(){
        circularList = new CircularListImpl();
    }

    @Test
    void testAddElement(){
        fillList(100);
    }

    @Test
    void testSizeEmptyList(){
        int expectedSize = 0;
        Assertions.assertEquals(expectedSize, circularList.size());
    }
    
    @Test
    void testSizeNotEmptyList(){
        int expectedSize = 100;
        fillList(expectedSize);
        Assertions.assertEquals(expectedSize, circularList.size());
    }

    @Test
    void testIsEmpty(){
        boolean expectedIsEmpty = true;
        Assertions.assertEquals(expectedIsEmpty, circularList.isEmpty());
    }

    @Test
    void testIsNotEmpty(){
        boolean expectedIsEmpty = false;
        fillList(100);
        Assertions.assertEquals(expectedIsEmpty, circularList.isEmpty());
    }

    @Test
    void testNextNotOutOfBound(){
        int expectedValue = 2;
        fillList(3);
        Assertions.assertEquals(expectedValue, nextNTimes(3).get());
    }

    @Test
    void testNextOutOfBound(){
        int expectedValue = 0;
        fillList(3);
        Assertions.assertEquals(expectedValue, nextNTimes(4).get());
    }

    @Test
    void testPreviousNotOutOfBound(){
        int expectedValue = 0;
        fillList(3);
        nextNTimes(2);
        Assertions.assertEquals(expectedValue, previousNTimes(2).get());
    }

    @Test
    void testPreviousOutOfBound(){
        int expectedValue = 2;
        fillList(3);
        Assertions.assertEquals(expectedValue, previousNTimes(1).get());
    }

    @Test
    void testReset(){
        int expectedValue = 0;
        fillList(100);
        nextNTimes(50);
        circularList.reset();
        Assertions.assertEquals(expectedValue, nextNTimes(1).get());
    }

    private void fillList(int size){
        for (int i = 0; i < size; i++){
            circularList.add(i % 3);
        }
    }

    private Optional<Integer> nextNTimes(int step){
        for (int i = 0; i < step - 1; i++){
            circularList.next();
        }
        return circularList.next();
    }

    private Optional<Integer> previousNTimes(int step){
        for (int i = 0; i < step - 1; i++){
            circularList.previous();
        }
        return circularList.previous();
    }
}
