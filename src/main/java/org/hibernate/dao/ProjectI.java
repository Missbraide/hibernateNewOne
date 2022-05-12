package org.hibernate.dao;

import org.hibernate.models.Employee;
import org.hibernate.models.Project;

import java.util.List;
import java.util.Set;

public interface ProjectI {

    void addEmployeeToProject(int projectId, int employeeId);
    void createProject(Project p);

    List<Employee> getAllEmployeesInProject(Project p);
}
