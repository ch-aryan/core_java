package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.LINKEDLIST;
class Solution11 {
    int getKthFromLast(Node head, int k) {
        // code here
        Node curr = head;
        int count = 0;
        while(curr != null ){
            curr = curr.next;
            count++;
        }
        System.out.println(count);
        if(k>count){
            return -1;
        }
        count = count -k;

        curr = head;
        int i =0;
        while(i<count){
            curr = curr.next;
            i++;
        }
        return curr.data;
    }
}
public class getKthNodeFromLast {
    public static void main(String[] args) {
        LinkedList obj = new LinkedList();
        obj.add(1);
        obj.add(2);
        obj.add(3);
        obj.add(4);
        obj.add(5);
        obj.add(6);
        obj.add(7);
        obj.add(8);
        obj.add(9);
     obj.print();
     Solution11 meth = new Solution11();
        int kthFromLast = meth.getKthFromLast(obj.head, 2);
        System.out.println(kthFromLast);

    }
}
