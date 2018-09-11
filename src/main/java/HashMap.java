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

    public void add(K key, V value) {
        int position;
        if (key == null) position = 0;
        else position = getHash(key);

        LinkedList<KeyValue> list = this.elements[position];
        KeyValue<K, V> keyValue = new KeyValue<>(key, value);

        if(list == null) {
            list = new LinkedList();
            this.elements[position] = list;
            list.add(keyValue);
        }
        else {
            for (KeyValue kv : list) {
                if(kv.key.equals(key)) throw new IllegalArgumentException("This key already exists in HashMap");
                else list.add(keyValue);
            }
        }
    }

    public V getValue(K key) {
        int position;
        Object value = null;
        if (key == null) position = 0;
        else position = getHash(key);

        LinkedList<KeyValue> list = this.elements[position];

        for (KeyValue kv : list) {
            if(kv.key.equals(key)) value = kv.value;
            else throw new IllegalArgumentException("There is no such key in HashMap");
        }
        return (V) value;
    }
}
