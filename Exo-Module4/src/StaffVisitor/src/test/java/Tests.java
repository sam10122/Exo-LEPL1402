import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.RunWith;

public class Tests {

    @Test
    public void test1(){
        Staff staff = new Staff();
        staff.addPerson(new Worker("Joe", 35, 15000));
        staff.addPerson(new Worker("Karin", 42, 18000));
        staff.addPerson(new Manager("Mark", 40, 24000));

        {
            MeanSalaryVisitor v = new MeanSalaryVisitor();
            staff.accept(v);
            assertEquals(19000, v.getResult(), 0.001);
        }

        {
            MaxWorkerSalaryVisitor v = new MaxWorkerSalaryVisitor();
            staff.accept(v);
            assertEquals(18000, v.getResult(), 0.001);
        }

        {
            MinManagerAgeVisitor v = new MinManagerAgeVisitor();
            staff.accept(v);
            assertEquals(40, v.getResult());
        }
    }
    
}
