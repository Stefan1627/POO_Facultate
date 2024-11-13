import java.util.Arrays;

class MyList {
    private Node head;
    private int size;

    public MyList() {
        head = new Node(null);
        size = 0;
    }

    //Adauga un obiect in lista
    public void add(Object data) {
        Node temp = new Node(data);
        Node current = head;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(temp);
        size++;
    }

    public void add(Object data, int index) {
        Node temp = new Node(data);
        Node current = head;
        for(int i = 0; i < index && current.getNext() != null; i++) {
            current = current.getNext();
        }
        temp.setNext(current.getNext());
        current.setNext(temp);
        size++;
    }

    public Object get(int index) {
        if(index < 0 && index >= this.size) {
            return null;
        } else {
            Node current = head.getNext();
            for(int i = 0; i < index; i++) {
                if(current.getNext() == null) {
                    return null;
                }
                current = current.getNext();
            }
            return current.getData();
        }
    }

    public boolean remove(int index) {
        if(index < 0 || index >= size) {
            return false;
        }
        Node current = head;
        for(int i = 0; i < index; i++) {
            if(current.getNext() == null) {
                return false;
            }
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        size--;
        return true;
    }

    public int size() {
        return size;
    }

    public String toString() {
        Node current = head.getNext();
        String result = "";
        while(current != null) {
            result += "[" + current.getData() + "] ";
            current = current.getNext();
        }
        return result;
    }


    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.next = null;
            this.data = data;
        }

        public Node(Object data, Node next) {
            this.next = next;
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}

class Graph extends MyList {
    private MyList[] adjacencyList;
    private boolean[] visited;
    private int numNodes;

    public Graph(int numNodes) {
        this.numNodes = numNodes;
        adjacencyList = new MyList[numNodes + 1];
        visited = new boolean[numNodes + 1];
        for(int i = 0; i <= numNodes; i++) {
            adjacencyList[i] = new MyList();
        }
    }

    public void add(int x, int y) {
        adjacencyList[x].add(y);
    }

    public void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");

        for (int i = 0; i < adjacencyList[start].size(); i++) {
            int neighbor = (int) adjacencyList[start].get(i);
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    @Override
    public String toString() {
        return "Graph{" +
                "adjacencyList=" + Arrays.toString(adjacencyList) +
                ", visited=" + Arrays.toString(visited) +
                ", numNodes=" + numNodes +
                '}';
    }
}

class TestGraph {
    public static void main(String args[]) {
        Graph g = new Graph(8);
        g.add(1, 2);
        g.add(1, 5);
        g.add(1, 8);
        g.add(2, 3);
        g.add(5, 6);
        g.add(4, 2);
        g.add(6, 3);
        g.add(6, 7);
        g.add(6, 8);
        g.add(3, 4);
        System.out.println(g);
        g.dfs(1);
    }
}
