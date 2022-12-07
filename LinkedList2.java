public class LinkedList2 {
    public Node head;
    public Node tail;

    private int size = 0;

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item) {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
        this.size++;
    }

    public void addInHead(Node _item) {
        _item.next = null;
        _item.prev = null;
        if (this.head == null) {
            this.tail = _item;
        } else {
            _item.next = this.head;
            this.head.prev = _item;
        }
        this.head = _item;
        this.size++;
    }

    public Node find(int _value) {
        Node iter = this.head;
        while (iter != null) {
            if (iter.value == _value) {
                return iter;
            }
            iter = iter.next;
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
        Node removeItem = find(_value);
        if (removeItem != null) {
            Node next = removeItem.next;
            Node prev = removeItem.prev;
            if (this.tail == this.head) {
                clear();
                return true;
            }
            if (removeItem == this.head) {
                this.head = next;
                this.head.prev = null;
                this.size--;
                return true;
            }
            if (removeItem == this.tail) {
                this.tail = prev;
                this.tail.next = null;
                this.size--;
                return true;
            }
            prev.next = next;
            next.prev = prev;
            this.size--;
            return true;
        }
        return false;
    }

    public void removeAll(int _value) {
        Node iter = this.head;
        while (iter != null) {
            if (iter.value == _value) {
                if (this.tail == this.head) {
                    clear();
                    return;
                }
                Node prev = iter.prev;
                Node next = iter.next;
                if (iter == this.head) {
                    this.head = next;
                    this.head.prev = null;
                    iter = next;
                    this.size--;
                    continue;
                }
                if (iter == this.tail) {
                    this.tail = prev;
                    this.tail.next = null;
                    this.size--;
                    return;
                }
                prev.next = next;
                next.prev = prev;
                iter = next;
                this.size--;
                continue;
            }
            iter = iter.next;
        }
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
            addInHead(_nodeToInsert);
            return;
        }
        Node founded = find(_nodeAfter.value);
        if (founded != null) {
            _nodeToInsert.next = founded.next;
            _nodeToInsert.prev = founded;
            founded.next = _nodeToInsert;
            if (founded == this.tail) this.tail = _nodeToInsert;
            this.size++;
        }
    }
}

class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}
