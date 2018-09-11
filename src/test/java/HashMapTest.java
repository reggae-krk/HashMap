import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {

    @Test
    void testAdd() {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.add("first", 1);
        hashMap.add("second", 2);
        int firstNumber = hashMap.getValue("first");
        int secondNumber = hashMap.getValue("second");

        assertEquals(1, firstNumber);
        assertEquals(2, secondNumber);
    }

    @Test
    void testRemove() {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.add("first", 1);
        hashMap.add("second", 2);

        hashMap.remove("first");

        assertThrows(IllegalArgumentException.class, () -> hashMap.getValue("first"));
    }

    @Test
    void testClearAll() {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.add("first", 1);
        hashMap.add("second", 2);

        hashMap.clearAll();

        assertThrows(NullPointerException.class, () -> hashMap.getValue("first"));
        assertThrows(NullPointerException.class, () -> hashMap.getValue("second"));
    }

    @Test
    void testAddNullKey() {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.add(null, 0);

        int valueFromNull = hashMap.getValue(null);

        assertEquals(0, valueFromNull);
    }

    @Test
    void testAddFewNullKeys() {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.add(null, 0);
        hashMap.add(null, 1);

        int valueFromNull = hashMap.getValue(null);

        assertEquals(1, valueFromNull);
    }
}