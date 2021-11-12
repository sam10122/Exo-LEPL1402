public abstract class Person extends Visitable {
    private String  name;
    private int     age;
    private float   salary;

    public Person(String name,
                  int age,
                  float salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getSalary() {
        return salary;
    }
}
