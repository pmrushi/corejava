import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MethodReferenceSortTest {
    public static void main(String[] args) {
        List<Employee> emp = new ArrayList<Employee>();
        emp.add(new Employee(25, "Raja", "Ramesh"));
        emp.add(new Employee(30, "Sai", "Adithya"));
        emp.add(new Employee(28, "Jai", "Dev"));
        emp.add(new Employee(23, "Ravi", "Chandra"));
        emp.add(new Employee(35, "Chaitanya", "Krishna"));

        // using method reference
        emp.stream().sorted(
                Comparator.comparing(Employee::getFirstName)
                .thenComparing(Employee::getLastName)
        )
                .forEach(System.out::println);
    }
}

// Employee class
class Employee {
    int age;
    String firstName;
    String lastName;
    public Employee(int age, String firstName, String lastName) {
        super();
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return "Employee [age=" + age + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}