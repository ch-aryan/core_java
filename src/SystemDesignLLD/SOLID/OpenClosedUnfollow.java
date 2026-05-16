package SystemDesignLLD.SOLID;
//one way of example is this. voilating
class DataBaseStorage{
    public void save(String type){
        if(type.equals("sql")){
            System.out.println("saving to sql");
        }else if(type.equals("mongo")){
            System.out.println("saving to mong");
        }else{
            System.out.println("etc... this violates the ocp");
        }
    }
}
//another can be this.
class DbStorage{
    public void dbsaveSql(){
        System.out.printf("ss");
    }

    public void dbsaveMongo(){
        System.out.println("voilates");
    }
}

public class OpenClosedUnfollow {
    public static void main(String[] args) {

    }
}
/*
❌ Problem

Every time we add a new storage type:

Redis
PostgreSQL
Cloud Storage

we must modify this class.

Need Redis support?
→ Open DatabaseStorage
→ Add new if-else block
→ Risk introducing bugs

This violates OCP.
 */