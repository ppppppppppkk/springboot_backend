package example.day09;

public class Example2 {
    public static void main(String[] args) {
        //1. 스레드 객체 생성
        SumThread sumThread = new SumThread();
        //2. 스레드 실행
        sumThread.start();
            //main스레드에게 작업스레드가 끝날때 까지 기다림
        try {
            sumThread.join();   //main스레드와 sumThread스레드가 JOIN
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //3. 작업스레드 run() 메소드를 처리하기 전에 아래 실행문 처리
        System.out.println("sumThread.getSum() = " + sumThread.getSum());


        WorkThread workThreadA = new WorkThread("workThreadA");
        WorkThread workThreadB = new WorkThread("workThreadB");

        workThreadA.start();
        workThreadB.start();

        try {
            Thread.sleep(5000);
        }catch (Exception e) {
            System.out.println("workThreadB = " + workThreadB);

            workThreadA.work = false;
        }

        try {
            Thread.sleep(1000);
        }catch (Exception e) {
            System.out.println("workThreadB = " + workThreadB);

            workThreadA.work = true;
        }
    }
}
