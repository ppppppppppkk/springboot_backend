package example.day10._1example;

public class User1Thread extends Thread{

    //1.필드, 유저1객체 가지고 있는 계산기
    private Calculator calculator;

    public User1Thread(){
        //setName : Thread 클래스로부터 상속받은 함수 (작업스레드)
        setName("User1Thread");
    }

    public void setCalculator(Calculator calculator){
        this.calculator = calculator;
    }

    @Override
    public void run() {
        calculator.setMemory(100);
    }





}
