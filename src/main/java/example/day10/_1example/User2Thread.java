package example.day10._1example;

public class User2Thread extends Thread {

    private Calculator calculator;

    public User2Thread(){
        //setName : Thread 클래스로부터 상속받은 함수 (작업스레드)
        setName("User2Thread");
    }

    public void setCalculator(Calculator calculator){
        this.calculator = calculator;
    }

    @Override
    public void run() {
        calculator.setMemory(50);
    }




}
