package example.day09;

public class WorkThread extends Thread {

    public boolean work = true;

    public WorkThread(String name) {
        setName(name);//매개변수로 스레드 이름 변경

    }
        @Override
        public void run () {
            while (true) {

                try{ Thread.sleep(1000);}catch(Exception e){ }
                if (work) {
                    System.out.println(getName());
                } else {
                    System.out.println("1");
                    Thread.yield();
                    System.out.println("2");
                }
            }

        }
    }


