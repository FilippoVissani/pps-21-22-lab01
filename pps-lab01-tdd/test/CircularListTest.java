import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;
    private int element;

    @BeforeEach
    void beforeEach(){
        circularList = new CircularListImpl();
        element = 0;
    }

    @Test
    void testAddElement(){
        addElementToList();
    }

    @Test
    void testSizeEmptyList(){
        int expectedSize = 0;
        Assertions.assertEquals(expectedSize, circularList.size());
    }
    
    @Test
    void testSizeNotEmptyList(){
        int expectedSize = 2;
        addElementToList();
        addElementToList();
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
        addElementToList();
        Assertions.assertEquals(expectedIsEmpty, circularList.isEmpty());
    }

    @Test
    void testNextNotOutOfBound(){
        int expectedValue = 1;
        addElementToList();
        addElementToList();
        circularList.next();
        Assertions.assertEquals(expectedValue, circularList.next().get());
    }

    @Test
    void testNextOutOfBound(){
        int expectedValue = 0;
        addElementToList();
        addElementToList();
        addElementToList();
        circularList.next();
        circularList.next();
        circularList.next();
        Assertions.assertEquals(expectedValue, circularList.next().get());
    }

    @Test
    void testPreviousNotOutOfBound(){
        int expectedValue = 1;
        addElementToList();
        addElementToList();
        addElementToList();
        circularList.next();
        circularList.next();
        Assertions.assertEquals(expectedValue, circularList.previous().get());
    }

    @Test
    void testPreviousOutOfBound(){
        int expectedValue = 2;
        addElementToList();
        addElementToList();
        addElementToList();
        Assertions.assertEquals(expectedValue, circularList.previous().get());
    }

    @Test
    void testReset(){
        int expectedValue = 0;
        addElementToList();
        addElementToList();
        addElementToList();
        circularList.next();
        circularList.next();
        circularList.reset();
        Assertions.assertEquals(expectedValue, circularList.next().get());
    }

    private void addElementToList() {
        circularList.add(element);
        element = element + 1;
    }

}
