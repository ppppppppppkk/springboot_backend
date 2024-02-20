package example.day08;

import java.awt.*;

public class 작업스레드 implements Runnable{

    //작업스레드가 최초 실행하는 함수
    @Override
    public void run() {
        for( int i = 1; i <=5; i++){
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            toolkit.beep();
            try { Thread.sleep(500);

            }catch (InterruptedException e){

            }
        }
    }
}
