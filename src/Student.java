import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Student {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        String stu = this.name + this.name;
        char[] chars = stu.toCharArray();
        int hash = 0;
        for (char aChar : chars) {
            hash = hash * 131 + aChar;
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj instanceof Student) {
            return this.name == ((Student) obj).getName() && this.age == ((Student) obj).getAge();
        }
        return false;
    }

    public static void main(String[] args) {
        Student stu1 = new Student("张三", 16);
        Student stu2 = new Student("张三", 16);
        Student stu3 = new Student("李四", 16);


        System.out.println(stu1.hashCode());
        System.out.println(stu2.hashCode());
        System.out.println(stu3.hashCode());

        HashMap<Student, Integer> hashMap = new HashMap<>();
        hashMap.put(stu1, 1);
        hashMap.put(stu2, 1);
        hashMap.put(stu3, 1);
        System.out.println(hashMap.size());
    }
}
