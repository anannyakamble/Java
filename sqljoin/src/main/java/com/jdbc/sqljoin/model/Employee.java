

package com.jdbc.sqljoin.model;


public class Employee {
    private int empId;
    private String empName;
    private Integer deptId;  // Can be NULL

    // Constructors
    public Employee() {}

    public Employee(int empId, String empName, Integer deptId) {
        this.empId = empId;
        this.empName = empName;
        this.deptId = deptId;
    }

    // Getters and Setters
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;

    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
    


}
