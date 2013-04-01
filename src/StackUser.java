public class StackUser {
    private Node top;
    boolean isEmpty = false;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	
    	StackUser su=new StackUser();
    	su.push(10);
    	su.push(12);
    	su.push(11);
    	su.push(13);
    	
    	su.printStack();
    	
    	su.pop();
    	su.pop();
    	su.printStack();
    }

    public void printStack() {
        Node temp = top;

        while (temp != null) {
            System.out.println(temp.obj);
            temp = temp.next;
        }
        
        System.out.println("***************");
    }

    public void push(Object obj) {
        Node node = new Node(obj);
        node.next = top;
        top = node;
    }

    public Object pop() {
        if (top != null) {
            Object obj = top.obj;
            top = top.next;

            return obj;
        } else {
            return null;
        }
    }

    public class Node {
        public Node next;
        public Object obj;

        public Node(Object obj) {
            this.obj = obj;
        }
    }
}
