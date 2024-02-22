package example.day10._2example;

public class ThreadB extends Thread{
    private WordkObject wordkObject;
    public ThreadB(WordkObject wordkObject){
        setName("ThreadB");
        this.wordkObject = wordkObject;
    }

    @Override
    public void run() {
        for(int i = 0; i<100 ; i++){
            wordkObject.methodB();
        }
    }

}
