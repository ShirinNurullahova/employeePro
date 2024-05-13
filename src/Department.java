public class Department {
    int departamentNo;
    String name;
    int employeeCount;
    Employee[] employees;
    public Department(int departamentNo, String name, int employeeCount, Employee[] employees) {
        this.departamentNo = departamentNo;
        this.name = name;
        this.employeeCount = employeeCount;
        this.employees = employees;
    }
}
