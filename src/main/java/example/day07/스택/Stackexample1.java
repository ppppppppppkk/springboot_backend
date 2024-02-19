package example.day07.스택;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Stackexample1 {

    public static void main(String[] args) {
        // 제일 마지막에 들어온 메시지 부터 나간다
        Stack<Integer> coinBox = new Stack<>();

        coinBox.push(100);
        coinBox.push(50);
        coinBox.push(500);
        coinBox.push(10);
        System.out.println("coinBox = " + coinBox);

        coinBox.pop();
        System.out.println("coinBox = " + coinBox);

        //============================================================
        //제일 먼저들어온 메시지 부터 나간다
        Queue<String> messageQueue = new LinkedList<>();

        messageQueue.offer("안녕 홍길동");
        messageQueue.offer("안녕 신동엽");
        messageQueue.offer("안녕 강호동");
        System.out.println("messageQueue = " + messageQueue);

        messageQueue.poll();
        System.out.println("messageQueue = " + messageQueue);






    }
}
