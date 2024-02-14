package example.day05;

import ch.qos.logback.classic.joran.serializedModel.HardenedModelInputStream;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Example1 {
    public static void main(String[] args) {


        Set<String> set = new HashSet<>();
        set.add("Java");
        set.add("JDBC");
        set.add("JSP");
        set.add("Java");
        set.add("Spring");
        System.out.println("set = " + set);
        int size = set.size();
        System.out.println("size = " + size);



        //순회
            //인덱스 없으므로 일반for문 사용 x

        for(String s : set){
            System.out.println("s = " + s);
        }

        Iterator<String> rs = set.iterator();
        while (rs.hasNext()){
            System.out.println("rs.next() = " + rs.next());
        }

        //컬렉션 객체.forEach함수(반복변수명 -> 실행문)
            // -iterator 지원한 객체만 가능
        set.forEach( s -> System.out.println("s = " + s));



        //===========================================
        Set<Member> set2 = new HashSet<>();
        Member m1 = new Member("홍길동",30);
        System.out.println("m1.hashCode() = " + m1.hashCode());


        Member m2 = new Member("홍길동",30);
        System.out.println("m2.hashCode() = " + m2.hashCode());

        set2.add(m1);
        set2.add(m2);

        System.out.println("set2 = " + set2);

    }
}
