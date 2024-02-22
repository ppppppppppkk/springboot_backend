package example.day10._2example;

public class Example2 {
    public static void main(String[] args) {

        WordkObject wordkObject = new WordkObject();

        ThreadA threadA = new ThreadA(wordkObject);
        ThreadB threadB = new ThreadB(wordkObject);

        threadA.start();
        threadB.start();
    }
}
