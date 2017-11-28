public class Challenges {

    public static void main(String[] args) {
        new Challenges().start();
    }

    private void start() {
        LinkedList llistInt = new LinkedList();
        llistInt.head = new Node(1);
        Node isecond = new Node(2);
        Node ithird = new Node(3);
        Node ifourth = new Node(4);
        Node ififth = new Node(5);
        Node isixth = new Node(6);

        llistInt.head.next = isecond;
        isecond.next = ithird;
        ithird.next = ifourth;
        ifourth.next = ififth;
        ififth.next = isixth;


        LinkedList llistStr = new LinkedList();
        llistStr.head = new Node("r");
        Node ssecond = new Node("a");
        Node sthird = new Node("c");
        Node sfourth = new Node("e");
        Node sfifth = new Node("c");
        Node ssixth = new Node("a");
        Node sseventh = new Node("r");

        llistStr.head.next = ssecond;
        ssecond.next = sthird;
        sthird.next = sfourth;
        sfourth.next = sfifth;
        sfifth.next = ssixth;
        ssixth.next = sseventh;
        
        
        System.out.println("Length: " + Integer.toString(llistInt.length()));
        System.out.println("Challenge 1 (k = 2): " + llistInt.getChallenge1(2));
        System.out.println("Challenge 2: " + challenge2(llistStr));

        new Challenge3().war();
    }

    private String challenge2(LinkedList llist) {
        for(int i = 0; i < llist.length(); i++) {
            if(llist.get(i) != llist.get((llist.length()-1) - i)) {
                return "not a palindrome";
            }
        }
        return "is a palindrome";
    }
    
    class LinkedList {
        Node head;

        Object getChallenge1(int i) {
            Node n = head;
            for(int x = 0; x < length() - i; x++) {
                n = n.next;
            }
            return n.data;
        }

        Object get(int i) {
            Node n = head;
            for(int x = 0; x < i; x++) {
                n = n.next;
            }
            return n.data;
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
                for (int x = 0; x < length(); x++) {
                    n = n.next;
                }
                System.out.println(n.data);
            }
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
