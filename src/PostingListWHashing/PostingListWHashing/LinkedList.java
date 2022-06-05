package pkg2102_project2_p2.pkg6;

public class LinkedList {

    Node first;
    Node last;
    int size = 0;

    public LinkedList() {
        this.first = null;
        this.last = null;
    }

    public void add(String key) {
        Node newNode = new Node(key);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.nextNode = newNode;
            last = newNode;
        }
        size++;
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "LinkedList{" + "first=" + first + ", last=" + last + ", size=" + size + '}';
    }

}
