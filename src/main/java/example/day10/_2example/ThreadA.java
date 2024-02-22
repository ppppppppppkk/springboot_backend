package example.day10._2example;

public class ThreadA extends Thread{
    private WordkObject wordkObject;
    public ThreadA(WordkObject wordkObject){
        setName("ThreadA");
        this.wordkObject = wordkObject;
    }

    @Override
    public void run() {
        for(int i = 0; i<100 ; i++){
            wordkObject.methodA();
        }
    }
}
