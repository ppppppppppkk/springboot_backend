package example.day10._1example;

public class Calculator {

    private int memory;
    //getter
    public int getMemory(){
        return memory;
    }

    //setter
    public void setMemory(int memory){
        this.memory = memory;

       try {Thread.sleep(2000);}catch (Exception e){}
        System.out.println(Thread.currentThread().getName()+" : "+ this.memory);

    }



}
