import java.util.LinkedList;


public class LinkListQues {
    /**
     * @param args
     */
	
	
    public static void main(String[] args) {
        java.util.LinkedList num1 = new java.util.LinkedList();
        java.util.LinkedList num2 = new java.util.LinkedList();
        java.util.LinkedList res = new java.util.LinkedList();
        
        num1.add(1);
        num1.add(9);
        num1.add(4);
        num1.add(8);
        
        num2.add(1);
        num2.add(6);
        num2.add(2);
        
        LinkListQues lt=new LinkListQues();
        res=lt.addNum(num1, num2, 0, res);
        System.out.println(res);

    }

    public java.util.LinkedList addNum(java.util.LinkedList num1,
        java.util.LinkedList num2, int carry, java.util.LinkedList res) {
        int result = 0;

        if (((num1 == null) || num1.isEmpty()) &&
                ((num2 == null) || num2.isEmpty())) {
            return res;
        } else if ((!num1.isEmpty()) && !num2.isEmpty()) {
            int n1 = (Integer) num1.pop();
            int n2 = (Integer) num2.pop();
            result = n1 + n2 + carry;
        } else if ((!num1.isEmpty() ) && (num2.isEmpty() )) {
            int n1 = (Integer) num1.pop();
            result = carry + n1;
        } else if (( !num2.isEmpty()) && ( num1.isEmpty())) {
            int n2 = (Integer) num2.pop();
            result = carry + n2;
        }

        if (result >= 10) {
            carry = 1;
            result = result % 10;
        } else {
            carry = 0;
        }

        res.add(result);

        return addNum(num1, num2, carry, res);
    }
}
