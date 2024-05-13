import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static int departmentCount;
    public static Department[] departments;
    public static void main(String[] args) {
        createDepartment();
           int choise;
            while(true){
                menu();
                choise = scanner.nextInt();
                scanner.nextLine();
                switch(choise){
                    case 1:addEmployeeWithDepNo();
                    break;
                    case 2: showAllEmploye();
                    break;
                    case 3: showEmployeeWithdepNo();
                    break;
                    case 4: searchForAllEmployee();
                    break;
                    case 5:  coiseDepartmentForSearch();
                    break;
                }
            }
    }

    public static void createDepartment() {
        System.out.println("Department sayi daxil et:");
        departmentCount = scanner.nextInt();
        scanner.nextLine();
        departments = new Department[departmentCount];
        for (int i = 0; i < departmentCount; i++) {
            System.out.println("Department nomresi daxil et ");
            int departmentNo = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Department adi daxil et ");
            String name = scanner.nextLine();
            System.out.println("Employee sayi daxil et ");
            int empCount = scanner.nextInt();
            scanner.nextLine();

            Employee[] employees = new Employee[empCount];
             for(int j=0; j< empCount; j++){
                 System.out.println("Salary daxil et:");
                 int salary = scanner.nextInt();
                 scanner.nextLine();
                 System.out.println("Experience daxil et:");
                 int experience = scanner.nextInt();
                 scanner.nextLine();
                 System.out.println("Employe id daxil et:");
                 int employeeId = scanner.nextInt();
                 scanner.nextLine();
                  System.out.println("Employee adi daxil et :");
                  String empName= scanner.nextLine();
                 employees[i]= new Employee(salary, experience, employeeId,empName );
                 break;
             }
            departments[i] = new Department(departmentNo, name,empCount, employees);
             break;
        }

    }

    public static void searchForAllEmployee() {
        System.out.println("Employee adi daxil et:");
        String empName = scanner.nextLine();

        boolean employeeFound = false;

        for (Department department : departments) {
            Employee[] employees = department.employees;
            for (Employee employee : employees) {
                if (empName.equals(employee.name)) {
                    System.out.println(empName + " adinda ishci tapildi");
                    employeeFound = true;
                }
            }
        }
        if (!employeeFound) {
            System.out.println("Hec bir ishci adi  tapilmadi");
        }
    }

    public static void addEmployeeWithDepNo() {
        boolean foundDep = false;
        System.out.println("Department nomresi daxil et:");
        int depNo = scanner.nextInt();
        scanner.nextLine();
        for (Department department : departments) {
            if (depNo == department.departamentNo) {
                foundDep = true;
                if (department.employeeCount < department.employees.length) {
                    System.out.println("Ishci adi daxil et:");
                    String empName = scanner.nextLine();
                    System.out.println("Salary daxil et:");
                    int salary = scanner.nextInt();
                    System.out.println("Experience daxil et:");
                    int experience = scanner.nextInt();
                    System.out.println("Employe id daxil et:");
                    int employeeId = scanner.nextInt();
                    scanner.nextLine();
                    Employee newEmployee = new Employee(salary, experience, employeeId, empName);
                    department.employees[department.employeeCount] = newEmployee;
                    department.employeeCount++;
                    System.out.println("Ishci elave olundu.");
                    break;
                } else {
                    System.out.println("Limiti kecdi. Ishci elave edile bilmedi.");
                }
                break;
            }
        }
        if (!foundDep) {
            System.out.println("Department tapilmadi");
        }
    }


    public static void showAllEmploye() {
         for(Department department : departments){
             Employee[] employees = department.employees;
             for (Employee employee : employees) {
                 System.out.println(employee);
                 break;
             }
             break;
         }
    }

    public static void coiseDepartmentForSearch() {
        System.out.println("Department adi daxil et:");
        String depName = scanner.nextLine();
        boolean inDepNameEmployeeFound = false;
        for (Department department : departments) {
                if(depName.equals(department.name)){
                    inDepNameEmployeeFound= true;
                    searchForAllEmployee();
                }
                break;
        }
        if (!inDepNameEmployeeFound) {
            System.out.println("Hec bir ishci adi  tapilmadi");
        }
    }
    public static void showEmployeeWithdepNo() {
        for(Department department : departments){
            System.out.println("Department nomresi daxil et:");
            int depNo= scanner.nextInt();
            scanner.nextLine();
            Employee[] employees = department.employees;
            if(depNo == department.departamentNo){
                for (Employee employee : employees) {
                    System.out.println(employee);
                    break;
                }
            }
            break;
        }
    }
    public static void menu() {
        System.out.println("1.Deparatament nomresi ile departamente isci elave et.");
        System.out.println("2.Departamentden isci sil (departamentNo- ya gore).");
        System.out.println("3.Butun iscileri gor.");
        System.out.println("4.DeparamentNo-ya esasen iscileri gor.");
        System.out.println("5.Butun iscilerde axtaris et (name-e gore)");
        System.out.println("6.Secilen Deparatamentdeki iscilerde axtaris et.");
    }
}