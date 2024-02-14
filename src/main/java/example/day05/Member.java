package example.day05;

public class Member {

    public String name;
    public int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //hashconde , equals => 메소드의 주인은 Object


    //hashCode, equals => 메소드의 주인은 Object
    //
    //toString => 메소드의 주인은 Object
    //- 객체의 (JVM) 주소를 반환
    // 오버라이딩 : 주소 반환 대신 필드(정보)로 반환


    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Member) {
            Member target = (Member) obj;
            return target.name.equals(this.name) && (target.age == this.age);

        } else {
            return false;
        }
    }


}
