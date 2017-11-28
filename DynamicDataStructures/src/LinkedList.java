class LinkedList {
    private Node head;

    Object get(int i) {
        Node n = head;
        for(int x = 0; x < i; x++) {
            n = n.next;
        }
        return n.data;
    }

    void remove(int i) {
        if(i == 0) {
            /*Node n = head.next;
            for(int x = 0; x < length() - 1; x++) {
                n.next = n.next.next;
            }*/
            head = head.next;
        } else {
            Node n = head;
            for (int x = 0; x < i - 1; x++) {
                n = n.next;
            }
            n.next = n.next.next;
        }
    }

    int length() {
        Node n = head;
        int length = 0;
        while(n != null) {
            n = n.next;
            length++;
        }
        return length;
    }

    void add(Object data) {
        if(head == null) {
            head = new Node(data);
        } else {
            Node n = head;
            for (int x = 0; x < length()-1; x++) {
                n = n.next;
            }
            n.next = new Node(data);
        }
    }
    class Node {
        Object data;
        Node next;
        Node(Object d) {
            data = d;
        }
    }
}