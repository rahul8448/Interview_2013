
public class QueueUser {
    private Node first;
    private Node last;

    public static void main(String[] args)
    {
    	QueueUser qu =new QueueUser();
    	qu.enqueue(10);
    	qu.enqueue(11);
    	qu.enqueue(12);
    	qu.enqueue(13);
     
    	qu.printStack();
    	
    	qu.dequeue();
    	qu.dequeue();
    	qu.enqueue(14);
    	qu.printStack();
    }	
    public void printStack() {
        Node temp = first;

        while (temp != null) {
            System.out.println(temp.obj);
            temp = temp.next;
        }
        
        System.out.println("***************");
    }
    public void enqueue(Object obj) {
        Node node = new Node(obj);

        if (first == null) {
            first = node;
            last = first;
        } else {
            last.next = node;
            last = node;
        }
    }

    public Object dequeue() {
        if (first != null) {
            Object obj = first.obj;
            first = first.next;

            return obj;
        }

        return null;
    }

    public class Node {
        public Node next;
        public Object obj;

        public Node(Object obj) {
            this.obj = obj;
        }
    }
}
