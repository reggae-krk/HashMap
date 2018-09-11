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
}