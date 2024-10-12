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


    private static class Node {
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

class Graph {
    private MyList[] adjList;  // Liste de adiacență
    private boolean[] visited; // Vector pentru a marca nodurile vizitate
    private int numNodes;      // Numărul de noduri din graf

    // Constructor care primește numărul de noduri din graf
    public Graph(int numNodes) {
        this.numNodes = numNodes;
        adjList = new MyList[numNodes + 1]; // Listele de adiacență (1-indexed)
        visited = new boolean[numNodes + 1]; // Vector de vizitare (1-indexed)

        // Inițializează fiecare listă din listele de adiacență
        for (int i = 1; i <= numNodes; i++) {
            adjList[i] = new MyList();
        }
    }

    // Adaugă arcul (x, y) în graf
    public void add(int x, int y) {
        adjList[x].add(y); // Adaugă nodul y în lista de adiacență a nodului x
    }

    // Parcurgere în adâncime (DFS)
    public void dfs(int start) {
        // Marchează nodul curent ca vizitat
        visited[start] = true;
        System.out.print(start + " "); // Afișează nodul vizitat

        // Parcurge toți vecinii nodului curent
        for (int i = 0; i < adjList[start].size(); i++) {
            int neighbor = (int) adjList[start].get(i);
            if (!visited[neighbor]) {
                dfs(neighbor); // Recursie pentru vecinii nevizitați
            }
        }
    }

    // Resetează vectorul de vizitare
    public void resetVisited() {
        for (int i = 1; i <= numNodes; i++) {
            visited[i] = false;
        }
    }

    // Metodă toString pentru a afișa graful
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= numNodes; i++) {
            sb.append(i).append(": ");
            for (int j = 0; j < adjList[i].size(); j++) {
                sb.append(adjList[i].get(j)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}





public class Prob2 {
    public static void main(String[] args) {
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
