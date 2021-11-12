import java.util.ArrayList;

public class Staff extends Visitable {
    private ArrayList<Person>  persons;

    public Staff() {
        persons = new ArrayList<Person>();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    @Override
    public void accept(Visitor visitor) {
        for (Person person: persons) {
            person.accept(visitor);
        }
    }
}
