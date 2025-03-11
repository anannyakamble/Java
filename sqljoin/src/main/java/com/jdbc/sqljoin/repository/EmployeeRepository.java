package com.jdbc.sqljoin.repository;

import com.jdbc.sqljoin.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeRepository {
    private final JdbcTemplate jdbcTemplate;

    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // ✅ Correctly implemented getAllEmployees() method
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM Employees";

        RowMapper<Employee> rowMapper = (rs, rowNum) -> new Employee(
            rs.getInt("EmpID"),
            rs.getString("EmpName"),
            rs.getObject("DeptID") != null ? rs.getInt("DeptID") : null // Handles NULL values
    );

    return jdbcTemplate.query(sql, rowMapper);
}
}    



