public class Employee {

    int salary;
    String name;
    int experience;

    int employeeId;


    public Employee(int salary, int experience, int employeeId, String name) {
        this.salary = salary;
        this.employeeId = employeeId;
        this.experience = experience;
        this.name= name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", name=" + name +
                ", experience=" + experience +
                ", employeeId=" + employeeId +
                '}';
    }
}
