import java.util.LinkedList;

public class HashMap<K, V> {

    private int bucketSize = 16;
    private LinkedList<KeyValue>[] elements;

    public HashMap() {
        this.elements = new LinkedList[bucketSize];
    }

    private int getHash(K key) {
        int hash = key.hashCode() % (this.bucketSize - 1);
        return hash;
    }
}
