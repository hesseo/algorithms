import java.util.Scanner;

class Node{
    Node next;
    int data;

    public Node(int data) {
        this.next = null;
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}

class NodeList {
    Node front;
    Node rear;
    int cnt=0;
    public NodeList(){
        front = rear = null;
    }
    public boolean isEmpty(){
        if(front == null && rear == null){
            return true;
        }else {
            return false;
        }
    }
    public void enqueue(Node newNode){
        if(isEmpty()){
            front = newNode;
            rear = newNode;
        }else {
            rear.setNext(newNode);
            rear=newNode;
        }
        cnt++;
    }
    public Node dequeue(){
        if(isEmpty()){
            return null;
        }else{
            Node temp = front;
            front = front.getNext();
            // 노드 두 개 남으면 front와 rear은 같은 노드를 나타냄
            // 하나 남았을 때 제거할 경우 rear도 null이 됨을 나타내야 함
            if (front == null){
                rear = null;
            }
            cnt--;
            return temp;
        }
    }
    public Node peek(){
        if(front == null){
            return null;
        }else{
            return front;
        }
    }
    public int size(){
        // 매번 size 부를 때마다 O(n) 의 시간 걸리는데
        // while루프 안에서 부르니까 총 O(n^2)의 시간 복잡도
//        int cnt = 0;
//        Node temp = front;
//        while (temp != null){
//            cnt++;
//            temp=temp.getNext();
//        }
        return cnt;
    }
    public void setFront(Node front) {
        this.front = front;
    }
    public void setRear(Node rear) {
        this.rear = rear;
    }
    public Node getFront() {
        return front;
    }
    public Node getRear() {
        return rear;
    }
}
public class Q2164 {
    public static void main(String[] args) {
        // 큐 인터페이스
        // Queue<Integer>queue = new LinkedList<Integer>();
        // LinkedList를 이용해서 Queue 구현
        // 값 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // linkedList 생성
        NodeList nodeList = new NodeList();
        for (int i = 1; i <= n; i++) {
            nodeList.enqueue(new Node(i));
        }
        while (nodeList.size()>1){  // 루프가 n번 반복, size()내에서도 n번 반복이므로
            nodeList.dequeue(); // 첫번째 버리기
            nodeList.enqueue(new Node(nodeList.dequeue().getData())); // 두 번째 맨 뒤(rear)에 넣을 떄 new 안하면 next 값이 null이 아닌 어떤 노드의 주소가 들어있어서 작동 안됨
        }
        System.out.println(nodeList.dequeue().getData());
    }
}
