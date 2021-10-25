import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StudentFunctions implements StudentStreamFunction {

  public Stream<Student> findSecondAndThirdTopStudentForGivenCourse(Stream<Student> studentStream, String name){
    //TODO YOUR CODE HERE
    Student[] s = studentStream.filter((i) -> i.getCoursesResults().containsKey(name))
            .sorted((a,b) -> Double.compare(a.getCoursesResults().get(name), b.getCoursesResults().get(name)))
            .toArray(Student[]::new);
    return Stream.of(s[s.length-2],s[s.length-3]);
  }

  public Object[] computeAverageForStudentInSection(Stream<Student> studentStream, int section){
    //TODO YOUR CODE HERE
    return studentStream.filter((i) -> i.getSection() == section)
            .map( (i) -> new Object[]{
                            String.format("Student %s %s", i.getFirstName(), i.getLastName()),
                            i.getCoursesResults().values().stream().reduce(0.0,(a,b)->(a+b))/i.getCoursesResults().size()
                    }
            ).sorted( (a,b)-> (int) ((Double) b[1] - (Double) a[1])).toArray();
  }

  public int getNumberOfSuccessfulStudents(Stream<Student> studentStream){
    //TODO YOUR CODE HERE
    int number = (int)studentStream.filter((i) -> i.getCoursesResults().values().stream().allMatch((j) -> j > 10.0)).count();
    return number;
  }

  public Student findLastInLexicographicOrder(Stream<Student> studentStream){
    //TODO YOUR CODE HERE
    Student[] s = studentStream.sorted((a,b) -> a.compareTo(b)).toArray(Student[]::new);
    return s[s.length-1];
  }

  public double getFullSum(Stream<Student> studentStream){
    //TODO YOUR CODE HERE
    return studentStream.map((i) -> i.getCoursesResults().values().stream().reduce(0.0,Double::sum)).reduce(0.0,Double::sum);
  }

}
