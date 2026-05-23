package com.OopsFundamental.Collections.Iterator;
interface exam<T>{

}
class hello<T> implements exam<Integer>{

}
class Aryan<T>{
    private T ref;
    public Aryan(T ref){
        this.ref = ref;
    }

    public T getRef() {
        System.out.println(ref.getClass().getName());
        return ref;
    }
}
public class CreateOwnGenericsTyep {
    public static void main(String[] args) {
    Aryan<Integer> obj  = new Aryan<>(44);
//    Aryan<Integer> obj1 = new Aryan<>("String"); compile time erro.
        Integer ref =obj.getRef();
        System.out.println(ref);

        Aryan<String> obj1 = new Aryan<>("Chil");
        System.out.println(obj1.getRef());



    }
}//we can do with interface also.
