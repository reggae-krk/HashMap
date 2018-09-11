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
        else if (list != null && key == null) this.elements[0].get(0).value = value;
        else {
            for (KeyValue kv : list) {
                if(kv.key.equals(key)) throw new IllegalArgumentException("This key already exists in HashMap");
            }
            list.add(keyValue);
        }
    }

    public V getValue(K key) {
        int position;
        Object value = null;
        if (key == null) position = 0;
        else position = getHash(key);

        LinkedList<KeyValue> list = this.elements[position];

        if (key == null) return (V) this.elements[0].get(0).value;

        for (KeyValue kv : list) {
            if(kv.key.equals(key)) {
                value = kv.value;
                return (V) value;
            }
        }
        throw new IllegalArgumentException("There is no such key in HashMap");
    }

    public void remove(K key) {
        int position;
        if (key == null) position = 0;
        else position = getHash(key);

        LinkedList<KeyValue> list = this.elements[position];

        if (key == null) {
            this.elements[0] = null;
            return;
        }

        for (KeyValue kv : list) {
            if(kv.key.equals(key)) {
                list.remove(kv);
                return;
            }
        }
        throw new IllegalArgumentException("There is no such key in HashMap");
    }

    public void clearAll() {
        for(int i = 0; i < this.elements.length; i++) {
            if(this.elements[i] != null) this.elements[i] = null;
        }
    }
}
