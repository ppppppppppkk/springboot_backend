package example.day07.트리컬렉션;

import java.util.Locale;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {

        //1. TreeSet 컬렉션 생성
        TreeSet<Integer> scores = new TreeSet<>();

        //2. TreeSet 컬렉션 객체에 객체 추가
        scores.add(87);
        scores.add(98);
        scores.add(75);
        scores.add(95);
        scores.add(80);
        System.out.println("scores = " + scores);


        //3. 순회
        for( Integer i : scores){
            System.out.println("i = " + i);
        }
        System.out.println("================");
        scores.forEach(i -> System.out.println("i = " + i));

        //4. HashSet 보다 추가적인 메소드 제공
        System.out.println("===========================");
        System.out.println("가장 낮은 점수 : " + scores.first());
        System.out.println("가장 높은 점수 : " + scores.last());
        System.out.println("95점 아래 점수 :" + scores.lower(95));
        System.out.println("95점 위의 점수 : " + scores.higher(95));
        System.out.println("95점 이거나 바로 아래 점수 : "+ scores.floor(95));
        System.out.println("85점 이거나 바로 위의 점수 : "+ scores.ceiling(85));

        //5. 내림차순
        System.out.println("==============================");
        NavigableSet<Integer> descending = scores.descendingSet();
        System.out.println("descending = " + descending);

        //6. 범위 검색 ( 80 <= )
        System.out.println("sccores.tailSet(80,true)"+scores.tailSet(80,true));

        //(80<= < 90)
        System.out.println("scores ="+ scores.subSet(80,true,90,false));






    }
}
