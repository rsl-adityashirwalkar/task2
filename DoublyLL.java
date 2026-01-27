class node{
    node prev;
    node next;
    int data;

    node(int data) {
        prev=null;
        next=null;
        this.data=data;
    }
}

class DoublyLL {

    static node head = null;
    static node tail = null;

    static void insertAtStart(int data) {
        node temp = new node(data);
        if(head == null) {
            head = temp;
            tail = temp;
            return;
        }
        temp.next=head;
        head.prev=temp;
        head=temp;
    }

    static void insertAtEnd(int data) {
        node temp = new node(data);
        if (tail==null) {
            head=temp;
            tail=temp;
        } else {
            tail.next=temp;
            temp.prev=tail;
            tail=temp;
        }
    }

    static void deleteData(int data) {
        node temp = head;
        while(temp!=null) {
            if(temp.data==data) {
                if(temp.prev!=null) {
                    temp.prev.next=temp.next;
                } else {
                    head=temp.next;
                }
                if(temp.next!=null) {
                    temp.next.prev=temp.prev;
                } else {
                    tail=temp.prev;
                }
                System.out.println("Deleted");
                return;
            }
            temp=temp.next;
        }
        System.out.println(data+" not found in the list");
    }

    static boolean find(int data) {
        node temp=head;
        while(temp!=null) {
            if(temp.data==data) {
                return true;
            }
            temp=temp.next;
        }
        return false;
    }

    static void display() {
        node temp=head;
        if(head==null) {
            System.out.println("The list is empty");
            return;
        }
        System.out.println("The list is:");
        while(temp!=null) {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        display();
        insertAtStart(10);
        insertAtStart(20);
        insertAtEnd(30);
        insertAtEnd(40);
        display();
        System.out.println("Deleting 20");
        deleteData(20);
        System.out.println("Deleting 60");
        deleteData(60);
        display();
        System.out.println("Add 50 at the end");
        insertAtEnd(50);
        display();
        int val = 30;
        System.out.println("Searching 30");
        boolean found = find(val);
        if(found) {
            System.out.println(val+" exists in the list");
        } else {
            System.out.println(val+" does not exist in the list");
        }
        display();
    }
}