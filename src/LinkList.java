import java.util.HashMap;


class Link {
    public int data1;
    public double data2;
    public Link nextLink;

    //Link constructor
    public Link(int d1, double d2) {
        data1 = d1;
        data2 = d2;
    }

    //Print Link data
    public void printLink() {
        System.out.print("{" + data1 + ", " + data2 + "} ");
    }
}


class LinkList {
    public Link first;

    //LinkList constructor
    public LinkList() {
        first = null;
    }

    //Returns true if list is empty
    public boolean isEmpty() {
        return first == null;
    }

    //Inserts a new Link at the first of the list
    public void insert(int d1, double d2) {
        Link link = new Link(d1, d2);
        link.nextLink = first;
        first = link;
    }

    //Deletes the link at the first of the list
    public Link delete() {
        Link temp = first;
        first = first.nextLink;

        return temp;
    }

    //Prints list data
    public void printList() {
        Link currentLink = first;
        System.out.print("List: ");

        while (currentLink != null) {
            currentLink.printLink();
            currentLink = currentLink.nextLink;
        }

        System.out.println("");
    }

    public Link removeDup() {
        HashMap hm = new HashMap();
        Link curr = first;
        Link temp = first;
        Link prev = null;

        while (curr != null) {
            int val = curr.data1;

            if (hm.containsKey(val)) {
                prev.nextLink = curr.nextLink;
            } else {
                hm.put(val, 0);
                prev = curr;
            }

            curr = curr.nextLink;
        }

        first = temp;

        return temp;
    }

    public void removeNodeWithDup() {
        if (first == null) {
            return;
        }

        Link ptr1 = first;

        while (ptr1 != null) {
            int v1 = ptr1.data1;
            Link prev = ptr1;
            Link ptr2 = ptr1.nextLink;

            while (ptr2 != null) {
                int v2 = ptr2.data1;

                if (v2 == v1) {
                    prev.nextLink = ptr2.nextLink;
                } else {
                    prev = ptr2;
                }

                ptr2 = ptr2.nextLink;
            }

            ptr1 = ptr1.nextLink;
        }
    }

    public void NthElemFromLast(int nthPos) {
        if (first == null) {
            return;
        }

        Link ptr1 = first;
        Link ptr2 = first;

        while ((nthPos > 0) && (ptr2 != null)) {
            ptr2 = ptr2.nextLink;
            nthPos--;
        }

        if ((nthPos >= 0) && (ptr2 == null)) {
            System.out.println("Pos does not exist");

            return;
        }

        while (ptr2.nextLink != null) {
            ptr1 = ptr1.nextLink;
            ptr2 = ptr2.nextLink;
        }

        System.out.println(ptr1.data1);
    }

    public void deleteSpecNode(Link node) {
        if (node == null) {
            return;
        }

        Link curr = node.nextLink;
        

        while (curr.nextLink!= null) {
            node.data1 = curr.data1;
            node = curr;
            curr = curr.nextLink;
        }

        node.nextLink = null;
    }
}


class LinkListTest {
    public static void main(String[] args) {
        LinkList list = new LinkList();

        list.insert(1, 1.01);
        list.insert(2, 2.02);
        list.insert(9, 3.03);
        list.insert(4, 4.04);
        list.insert(5, 5.05);

        list.printList();

        /* while(!list.isEmpty()) {
                 Link deletedLink = list.delete();
                 System.out.print("deleted: ");
                 deletedLink.printLink();
                 System.out.println("");
         }*/

        // list.removeDup();
       // list.NthElemFromLast(6);
        list.deleteSpecNode(list.first.nextLink.nextLink);
        list.printList();

        /*list.removeNodeWithDup();
        list.printList();*/
    }
}
