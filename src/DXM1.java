import java.util.Scanner;

public class DXM1 {

    public static class Node{
        Node next;
        int value;

        public Node(Node next, int value) {
            this.next = next;
            this.value = value;
        }

        public Node() {
        }
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a=sc.nextInt();
        int b=sc.nextInt();
        Node head;
        head=new Node(null,1);
        head.next=head;

        Node tail=head;
        for (int i = 1; i < n; i++) {
            Node node=new Node(null,i+1);
            tail.next=node;
            tail=node;
        }
        tail.next=head;
        int count=0;
        while (head.next.value!= head.value){
            for (int i = 1; i < ((count % 2 == 0) ? a : b); i++) {
                head=head.next;
            }
            head.next=head.next.next;
            count++;
        }
        System.out.println(head.value-1);

    }
}
