public class QueueUsingStack {
    java.util.Stack stk1 = new java.util.Stack();
    java.util.Stack stk2 = new java.util.Stack();

    public static void main(String[] args)
    {
    	QueueUsingStack q=new QueueUsingStack();
    	q.enQueue(11);
    	q.enQueue(12);
    	q.enQueue(13);
    	q.enQueue(14);
    	q.enQueue(15);
    	
    	System.out.println(q.deQueue());
    	System.out.println(q.deQueue());
    	System.out.println(q.deQueue());
    	System.out.println(q.deQueue());
    	System.out.println(q.deQueue());
    	System.out.println(q.deQueue());
    	
    	q.enQueue(11);
    	q.enQueue(12);
    	q.enQueue(13);
    	q.enQueue(14);
    	q.enQueue(15);
    	
    	System.out.println(q.deQueue());
    	System.out.println(q.deQueue());
    	System.out.println(q.deQueue());
    	System.out.println(q.deQueue());
    	System.out.println(q.deQueue());
    	System.out.println(q.deQueue());
    	
    	
    }
    public Object deQueue() {
        Object obj = null;

        if (stk2.isEmpty() && !stk1.isEmpty()) {
            while (!stk1.isEmpty()) {
                stk2.push(stk1.pop());
            }

            obj = stk2.pop();
        } else if (!stk2.isEmpty()) {
            obj = stk2.pop();
        }

        return obj;
    }

    public void enQueue(Object obj) {
        stk1.push(obj);
    }
}
