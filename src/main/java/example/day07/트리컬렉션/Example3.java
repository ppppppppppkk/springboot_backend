package example.day07.트리컬렉션;

import com.sun.source.tree.Tree;

import java.util.TreeSet;

public class Example3 {
    public static void main(String[] args) {


        TreeSet<Person> treeSet = new TreeSet<>();

        treeSet.add( new Person("홍길동",45));
        treeSet.add( new Person("유재석",25));
        treeSet.add( new Person("강호동",31));
        System.out.println("treeSet = " + treeSet);

        String str = "유재석";
        System.out.println(" = " + str.compareTo("유재석") );
        System.out.println(" = " + str.compareTo("홍길동") );
        System.out.println(" = " + str.compareTo("강호동") );













    }
}
