package example.day07.트리컬렉션;

public class Person implements Comparable<Person> {
    //implements 추상 메소드
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
      if(this.age < o.age) return -1;
      else if( this.age == o.age) return 0;
      else return 1;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
