import java.util.Scanner;

public class project1 {
    static class Employee {
        int empNo;
        String empName;
        String joindate;
        char designationcode;
        String department;
        double basic;
        double HRA;
        double IT;
        double salary;


        public Employee(int empNo, String empName, String joindate, char designationcode, String department, double basic, double HRA, double IT) {
            this.empNo = empNo;
            this.empName = empName;
            this.joindate = joindate;
            this.designationcode = designationcode;
            this.department = department;
            this.basic = basic;
            this.HRA = HRA;
            this.IT = IT;
            this.salary = basic + HRA + EmployeeDetails.getDA(designationcode) - IT;
        }
    }

    static class DA {
        char Designationcode;
        String designation;
        double DA;


        public DA(char designationcode, String designation, double DA) {
            this.Designationcode = designationcode;
            this.designation = designation;
            this.DA = DA;
        }
    }

    public static class EmployeeDetails {

        public static double getDA(char designationCode) {
            DA[] DAs = {
                    new DA('e', "Engineer", 20000),
                    new DA('c', "Consultant", 32000),
                    new DA('k', "Clerk", 12000),
                    new DA('r', "Receptionist", 15000),
                    new DA('m', "Manager", 40000)
            };

            for (DA da : DAs) {
                if (da.Designationcode == designationCode) {
                    return da.DA;
                }
            }
            return 0;
        }

        public static void main(String[] args) {
            Employee[] employees = {
                    new Employee(1001, "Ashish", "01/04/2009", 'e', "R&D", 20000, 8000, 3000),
                    new Employee(1002, "Sushma", "23/08/2012", 'c', "PM", 30000, 12000, 9000),
                    new Employee(1003, "Rahul", "12/11/2008", 'k', "Acct", 10000, 8000, 1000),
                    new Employee(1004, "Chahat", "29/01/2013", 'r', "Front Desk", 12000, 6000, 2000),
                    new Employee(1005, "Ranjan", "16/07/2005", 'm', "Engg", 50000, 20000, 20000),
                    new Employee(1006, "Suman", "1/1/2000", 'e', "Manufacturing", 23000, 9000, 4400),
                    new Employee(1007, "Tanmay", "12/06/2006", 'c', "PM", 29000, 12000, 10000)
            };


            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Employee ID: ");
            int searchEmpId = scanner.nextInt();


            Employee foundEmployee = null;
            for (Employee employee : employees) {
                if (employee.empNo == searchEmpId) {
                    foundEmployee = employee;
                    break;
                }
            }


            if (foundEmployee != null) {
                System.out.println("Employee ID: " + foundEmployee.empNo);
                System.out.println("Employee Name: " + foundEmployee.empName);
                System.out.println("Department: " + foundEmployee.department);


                switch (foundEmployee.designationcode) {
                    case 'e':
                        System.out.println("Designation: Engineer");
                        break;
                    case 'c':
                        System.out.println("Designation: Consultant");
                        break;
                    case 'k':
                        System.out.println("Designation: Clerk");
                        break;
                    case 'r':
                        System.out.println("Designation: Receptionist");
                        break;
                    case 'm':
                        System.out.println("Designation: Manager");
                        break;
                    default:
                        System.out.println("Invalid Designation Code");
                }


                double employeeDA = getDA(foundEmployee.designationcode);
                System.out.println("Salary: $" + foundEmployee.salary);
            } else {
                System.out.println("There is no employee with empid :" + searchEmpId);
            }
        }
    }
}

