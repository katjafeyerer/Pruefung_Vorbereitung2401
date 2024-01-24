package src.A01_VerketteteListen;

public class GenericStacki {
    private Node head;

    public void insert(int data){
        Node node = new Node(data);
        node.setData(data);

        if(head == null){
            head = node;
        }
        else{
            Node n = head;
            while(n.getNext() != null){
                n = n.getNext();
            }
            n.setNext(node);
        }
    }
    public void show(){
        Node n = head;
        while(n.getNext() != null){
            System.out.print(n + " ");
            n = n.getNext();
        }
        System.out.print(n);
    }
}
