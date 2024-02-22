package example.day09;

public class Example1 {

    public static void main(String[] args) {

        Thread thread = Thread.currentThread();
        System.out.println("thread.getName() = " + thread.getName());

        //작업스레드 생성 4가지 방법
            //자식 익명 객체
        Thread threadA = new Thread(){

            @Override
            public void run() { //작업스레드가 실행할때 최초로 실행되는 함수
                System.out.println("작업스레드 A"+getName());
                super.run();
            }
        };

    }




}
