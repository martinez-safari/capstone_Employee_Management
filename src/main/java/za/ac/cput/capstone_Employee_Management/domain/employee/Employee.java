package za.ac.cput.capstone_Employee_Management.domain.employee;
/*
Employee.java
AUTHOR Farai Malone Chawora
Student Number 220145547
Date April 9 2022
 */

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name="Employee")
public class Employee implements Serializable {
    @Id@NotNull@Column(name="employee_ID")
    private String employeeId;
    @Column(name="first_Name")
    private String firstName;
    @Column(name = "middle_Name")
    private String middleName;
    @Column(name = "last_Name")
    private String lastName;

    @OneToMany(mappedBy = "employee",cascade =CascadeType.ALL,orphanRemoval = true)
    private Set<EmployeeContactType> employeeContactType =new HashSet<>();

    protected Employee() {
    }
    private Employee(Builder builder){
        this.firstName= builder.firstName;
        this.middleName=builder.middleName;
        this.lastName= builder.lastName;
        this.employeeId= builder.employeeId;

    }

    public String getEmployeeId() {
        return employeeId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getMiddleName() {
        return middleName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static class Builder {
        private String firstName;
        private String middleName;
        private String lastName;
        private String employeeId;

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;

        }
        public Builder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;

        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder copy(Employee employee) {
            this.firstName = employee.firstName;
            this.middleName = employee.middleName;
            this.lastName = employee.lastName;
            this.employeeId = employee.employeeId;
            return this;

        }

        public Employee build() {
            return new Employee(this);
        }
    }
}

