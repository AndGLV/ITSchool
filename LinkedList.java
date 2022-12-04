public class LinkedList {
    public Node head;
    public Node tail;
    private int size = 0;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
        this.tail.next = null;
        this.size++;
    }

    public void adInHead(Node item) {
        if (item == null) return;
        item.next = null;
        if (this.head == null) {
            this.head = item;
            this.tail = item;
        } else {
            item.next = head;
            this.head = item;
        }
        this.size++;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node iter = this.head;
        while (iter != null) {
            if (iter.value == _value) {
                nodes.add(iter);
            }
            iter = iter.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        Node target = this.head;
        Node previous = this.head;
        while (target != null) {
            if (target.value == _value) {
                if (this.head == this.tail) {
                    clear();
                    return true;
                }
                previous.next = target.next;
                if (target == this.tail) this.tail = previous;
                if (target == this.head) this.head = target.next;
                this.size--;
                return true;
            }
            previous = target;
            target = target.next;
        }
        return false;
    }

    public void removeAll(int _value) {
        Node searchNode = this.head;
        Node prevNode = this.head;
        int itemDeleted = 0;
        while (searchNode != null) {
            if (searchNode.value == _value) {
                if (this.head == this.tail) {
                    clear();
                    return;
                }
                itemDeleted++;
                prevNode.next = searchNode.next;
                if (searchNode == this.tail) this.tail = prevNode;
                if (searchNode == this.head) {
                    this.head = searchNode.next;
                    prevNode = searchNode.next;
                }
                searchNode = searchNode.next;
                continue;
            }
            prevNode = searchNode;
            searchNode = searchNode.next;
        }
        this.size -= itemDeleted;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int count() {
        return this.size;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeAfter == null) {
            adInHead(_nodeToInsert);
            return;
        }
        Node founded = find(_nodeAfter.value);
        if (founded != null) {
            _nodeToInsert.next = founded.next;
            founded.next = _nodeToInsert;
            this.size++;
        }
    }
}

class Node {
    public int value;
    public Node next;

    public Node(int _value) {
        value = _value;
        next = null;
    }
}
