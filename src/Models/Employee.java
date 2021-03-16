package Models;

public class Employee {
    private String employeeName;
    private byte employeeAge;
    private String employeeAddress;

    public Employee() {
    }

    public Employee(String employeeName, byte employeeAge, String employeeAddress) {
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(byte employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employeeName='" + employeeName + '\'' +
                ",\temployeeAge=" + employeeAge +
                ",\temployeeAddress='" + employeeAddress + '\'' +
                '}';
    }
}
