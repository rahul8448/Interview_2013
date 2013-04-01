import java.util.Queue;


public class BinaryTree {
    /**
     * @param args
     */
    public Node root;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BinaryTree bt = new BinaryTree();
        bt.insert(10);
        bt.insert(11);
        bt.insert(12);
        bt.insert(8);
        bt.insert(15);
        // bt.printtVal();
        //System.out.println(bt.lookUp(0, bt.root));
        /*bt.inOrder(bt.root);
        System.out.println("................");
        bt.inOrderNonRecursive(bt.root);
        */
        bt.preOrder(bt.root);
        System.out.println("................");
        bt.postOrderNonRecursive(bt.root);
    }

    public void printtVal() {
        Queue queue = new java.util.LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = (Node) queue.poll();
            System.out.println(node.val);

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    public Node lookUp(int val, Node node) {
        if (node == null) {
            return node;
        } else {
            int tmp = node.val;

            if (tmp == val) {
                return node;
            } else if (tmp >= val) {
                return lookUp(val, node.right);
            } else {
                return lookUp(val, node.left);
            }
        }
    }

    public void postOrderNonRecursive(Node node) {
        java.util.Stack st = new java.util.Stack();
        java.util.ArrayList lt = new java.util.ArrayList();
        Node tmp = null;

        while (true) {
            while (node != null) {
                st.push(node);
                node = node.left;
            }

            if (st.isEmpty()) {
                break;
            } else {
                tmp = (Node) st.peek();

                if ((tmp.right != null) && !lt.contains(tmp.right)) {
                    node = tmp.right;

                    continue;
                }

                tmp = (Node) st.pop();
                System.out.println(tmp.val);
                lt.add(tmp);

                //node=(Node)st.peek(); 
            }
        }
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val);
    }

    public void preOrderNonRecursive(Node node) {
        java.util.Stack st = new java.util.Stack();
        Node tmp = null;

        while (true) {
            while (node != null) {
                System.out.println(node.val);
                st.push(node.right);
                node = node.left;
            }

            if (st.isEmpty()) {
                break;
            } else {
                tmp = (Node) st.pop();
                node = tmp;
            }
        }
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    public Node insert(int val) {
        if (root == null) {
            root = new Node(val);

            return root;
        } else {
            Node node = insertVal(val, root);

            return node;
        }
    }

    private Node insertVal(int val, Node temp) {
        if (temp == null) {
            temp = new Node(val);

            return temp;
        }

        Node node = null;

        if (val > temp.val) {
            temp.right = insertVal(val, temp.right);
        } else if (val <= temp.val) {
            temp.left = insertVal(val, temp.left);
        }

        return temp;
    }

    public class Node {
        public Node right;
        public Node left;
        public int val;

        public Node(int val) {
            this.val = val;
        }
    }
}
