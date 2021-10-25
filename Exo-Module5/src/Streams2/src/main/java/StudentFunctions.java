import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StudentFunctions implements StudentStreamFunction {

  public Student findFirst(Stream<Student> studentsStream, Map<String, Predicate<?>> conditions){
    Student[] s = findAll(studentsStream,conditions);
    if(s.length == 0){
      return null;
    }
    return s[0];
  }

  public Student[] findAll(Stream<Student> studentsStream, Map<String, Predicate<?>> conditions){
      //TODO YOUR CODE HERE
    if(conditions.containsKey("firstName")){
      Predicate<String> predicFirst = (Predicate<String>) conditions.get("firstName");
      studentsStream = studentsStream.filter((i) -> predicFirst.test(i.getFirstName()));
    }
    if(conditions.containsKey("lastName")){
      Predicate<String> predictLast = (Predicate<String>) conditions.get("lastName");
      studentsStream = studentsStream.filter((i) -> predictLast.test(i.getLastName()));
    }
    if(conditions.containsKey("section")){
      Predicate<Integer> predictSection = (Predicate<Integer>) conditions.get("section");
      studentsStream = studentsStream.filter((i) -> predictSection.test(i.getSection()));
    }
    if(conditions.containsKey("courses_results")){
      Predicate<Map<String,Double>> predictResult = (Predicate<Map<String,Double>>) conditions.get("courses_results");
      studentsStream = studentsStream.filter((i) -> predictResult.test(i.getCourses_results()));
    }
    return studentsStream.toArray(Student[]::new);
  }

  public boolean exists(Stream<Student> studentsStream,
                        Map<String, Predicate<?>> conditions,
                        int n)
  {
      //TODO YOUR CODE HERE
    Student[] s = findAll(studentsStream,conditions);
    if(s.length >= n){
      return true;
    }
    return false;
  }

  public Student[] filterThenSort(Stream<Student> studentsStream,
                                  Map<String, Predicate<?>> conditions,
                                  Comparator<Student> comparator)
  {
      //TODO YOUR CODE HERE
    Stream<Student> filter = Stream.of(findAll(studentsStream, conditions));
    Stream<Student> sort = filter.sorted(comparator);
    return sort.toArray(Student[]::new);
  }

  //TODO YOUR CODE HERE

}
