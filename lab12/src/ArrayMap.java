import java.util.*;

public class ArrayMap<K, V> extends AbstractMap<K, V> {
    private Vector<K> keys;
    private Vector<V> values;

    public ArrayMap() {
        keys = new Vector<>();
        values = new Vector<>();
    }

    @Override
    public V put(K key, V value) {
        int index = keys.indexOf(key);
        if (index != -1) {
            V oldValue = values.get(index);
            values.set(index, value);
            return oldValue;
        } else {
            keys.add(key);
            values.add(value);
            return null;
        }
    }

    @Override
    public V get(Object key) {
        int index = keys.indexOf(key);
        return index != -1 ? values.get(index) : null;
    }

    @Override
    public Set<K> keySet() {
        return new HashSet<>(keys);
    }

    @Override
    public Collection<V> values() {
        return new ArrayList<>(values);
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> entrySet = new HashSet<>();
        for (int i = 0; i < keys.size(); i++) {
            entrySet.add(new ArrayMapEntry<>(keys.get(i), values.get(i)));
        }
        return entrySet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < keys.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(keys.get(i)).append("=").append(values.get(i));
        }
        sb.append("}");
        return sb.toString();
    }

    private static class ArrayMapEntry<K, V> implements Map.Entry<K, V> {
        private final K key;
        private V value;

        public ArrayMapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ArrayMapEntry<?, ?> that = (ArrayMapEntry<?, ?>) o;
            return Objects.equals(key, that.key) && Objects.equals(value, that.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

    public static void main(String[] args) {
        ArrayMap<String, Integer> dictionar = new ArrayMap<>();
        dictionar.put("one", 1);
        dictionar.put("two", 2);
        dictionar.put("three", 3);

        System.out.println("Dicționar: " + dictionar);

        System.out.println("Parcurgere folosind Iterator:");
        Iterator<Map.Entry<String, Integer>> iterator = dictionar.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry);
        }
    }
}

