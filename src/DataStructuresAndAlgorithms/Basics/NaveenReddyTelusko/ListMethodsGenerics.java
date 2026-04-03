package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class ListMethodsGenerics {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        temp.add(3);

        ArrayList<Integer> temp1 = new ArrayList<>();
        temp1.add(4);
        temp1.add(5);
        temp1.add(6);

        ArrayList<Integer> temp2 = new ArrayList<>();
        temp2.add(7);
        temp2.add(8);
        temp2.add(9);

        ArrayList<Integer> ds = new ArrayList<>();
        ds.add(10);
        ds.add(11);
        ds.add(12);

        list.add(temp);
        list.add(temp1);
        list.add(temp2);
        list.add(new ArrayList<>(ds));

        System.out.println(list);
    }
}
