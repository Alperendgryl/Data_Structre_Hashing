package pkg2102_project2_p2.pkg6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class HashTable {

    Node[] table;
    int size;
    int total_item;
    LinkedList LL[] = new LinkedList[10];

    public HashTable(int size) {
        this.size = size;
        table = new Node[size];
        for (int i = 0; i < size; i++) {
            table[i] = new Node();
        }
    }

    public void nodeToHashTable(String data) {
        int ix = hash(data);
        Node newNode = new Node(data);
        for (int i = 0; i < size; i++) {
            if (table[ix].data == null) {
                table[ix] = newNode;
                total_item++;
            } else if (!table[ix].data.equalsIgnoreCase(data)) {
                ix = (ix + 1) % size;
            }
        }
    }

    public void readFiles() throws FileNotFoundException {
        File file[] = new File[10];
        String filePath;
        for (int i = 0; i < file.length; i++) {
            LL[i] = new LinkedList();
            filePath = "C:\\Users\\alper\\Desktop\\Project2_p2\\" + (i + 1) + ".txt";
            Scanner sc = new Scanner(new File(filePath));
            while (sc.hasNext()) {
                String name = sc.next();
                LL[i].add(name);
                nodeToHashTable(name);
            }
        }
    }

    public void Which_File_Contains(String search) {
        boolean exist = false;
        for (int i = 0; i < size; i++) {
            if (LL[i].contains(search)) { //hangi LL'ler bu datayı içeriyor kontrol et
                System.out.println("This word {" + search + "} has been appeared in the following text files : " + i + ".txt"); //print et
                exist = true;
            }
        }
        if (!exist) {
            System.out.println("No text files includes this word.");
        }
    }

    public boolean contains(String key) {
        int ix = hash(key);
        int start_index = ix;

        while ((table[ix] != null) && (ix + 1 != start_index)) {
            if (table[ix].equals(key)) {
                return true;
            }
            ix = (ix + 1) % size;
        }
        return false;
    }

    void Display_All() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + " : " + table[i]);
        }
    }

    public int hash(String key) {
        return (key.hashCode() & 0x7fffffff % size); //default hashCode method of java 0x7f... convert to positive
    }

    public void learnHash(String name) {
        int ix = hash(name);
        System.out.println(name + "'s hash index is : " + ix);
    }

}
