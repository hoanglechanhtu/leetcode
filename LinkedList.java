class MyLinkedList {
    Node head;
    int size = 0;
    class Node {
        int val;
        Node next;
        
        Node(int val) {
            this.val = val;
        }
        
        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
    
    public MyLinkedList() {
    
    }
    
    public int get(int index) {
        Node node = getNode(index);
        if (node == null) return -1;
        else return node.val;
    }
    
    private Node getNode(int index) {
        if (index >= size) return null;
        int i = 0;
        Node cur = head;
        while(i < index) {
            cur = cur.next;
            i ++;
        }
        return cur;
    }
    
    public void addAtHead(int val) {
        size ++;
        Node node = new Node(val, head);
        head = node;
    }
    
    public void addAtTail(int val) {
        if (size == 0) {
            head = new Node(val);
            size ++;
            return;
        }
        Node cur = head;
        while(cur.next != null) {
            cur = cur.next;
        }
        
        cur.next = new Node(val);
        size ++;
        
    }
    
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index == 0) {
            addAtHead(val);
            return;
        }
        Node node = getNode(index - 1);
        Node next = node.next;
        node.next = new Node(val, next);
        size ++;
    }
    
    public void deleteAtIndex(int index) {
        if (index >= size) return;
        if (index == 0) {
            head = head.next;
            return;
        }
        Node node = getNode(index - 1);
        node.next = node.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
