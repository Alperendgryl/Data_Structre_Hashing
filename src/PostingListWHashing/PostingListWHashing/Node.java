package pkg2102_project2_p2.pkg6;

public class Node {

    String data;
    Node nextNode;

    public Node() {
        nextNode = null;
    }

    public Node(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    @Override
    public String toString() {
        return (data != null) ? data : null;
    }

}
