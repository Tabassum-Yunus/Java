import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collection;
import java.util.List;
class DataProcessor<T> {
    private ArrayList<T> list = new ArrayList<>();
    public void addElement(T element) {
        list.add(element);
    }
    public boolean removeElement(T element) {
        return list.remove(element);
    }
    public void displayElements() {
        System.out.println(list);
    }
    public void combineCollections(Collection<? extends T> newElements) {   // Combine collections using wildcard generics
        list.addAll(newElements);
    }
}

// Extending DataProcessor to work with HashMap
class DataProcessorWithMap<K, T> extends DataProcessor<T> {
    private HashMap<K, T> map = new HashMap<>();
    public void addElement(K key, T element) {
        map.put(key, element);
    }
    public boolean removeElementByKey(K key) {
        if (map.containsKey(key)) {
            map.remove(key);
            return true;
        }
        return false;
    }
    public T getElementByKey(K key) {
        return map.get(key);
    }
    @Override
    public void displayElements() {
        System.out.println(map);
    }
}
class User {
    String user;
    User(String user) {
        this.user = user;
    }
    @Override
    public String toString() {
        return user;
    }
}
public class Generic_Collection {
    public static void main(String[] args) {
        System.out.println("\nInteger Example");
        DataProcessor<Integer> intProcessor = new DataProcessor<>();
        intProcessor.addElement(10);
        intProcessor.addElement(20);
        intProcessor.displayElements();
        intProcessor.removeElement(10);
        intProcessor.addElement(30);
        intProcessor.addElement(40);
        intProcessor.displayElements();

        System.out.println("\nString Example");
        DataProcessor<String> stringProcessor = new DataProcessor<>();
        stringProcessor.addElement("Hello");
        stringProcessor.addElement("World");
        stringProcessor.displayElements();
        stringProcessor.removeElement("Hello");
        stringProcessor.displayElements();

        System.out.println("\nMap Example");
        DataProcessorWithMap<Integer, String> mapProcessor = new DataProcessorWithMap<>();
        mapProcessor.addElement(1, "Denny");
        mapProcessor.addElement(2, "Cookie");
        mapProcessor.displayElements();
        mapProcessor.removeElementByKey(2);
        mapProcessor.displayElements();

        System.out.println("\nCustom user Example");
        DataProcessor<User> userProcessor = new DataProcessor<>();
        User user1 = new User("Oreo");
        User user2 = new User("Jerry");
        userProcessor.addElement(user1);
        userProcessor.addElement(user2);
        userProcessor.displayElements();
        userProcessor.removeElement(user2);
        userProcessor.displayElements();

        List<User> newUsers = new ArrayList<>();
        newUsers.add(new User("Charlie"));
        newUsers.add(new User("Diana"));

        userProcessor.combineCollections(newUsers);
        userProcessor.displayElements();
    }
}
