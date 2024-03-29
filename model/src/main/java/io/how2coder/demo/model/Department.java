package io.how2coder.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Department {

    public static final String ID_COLUMN = "id";
    public static final String NAME_COLUMN = "name";

    private Long id;
    private String name;
    private Manager manager;
    private List<Employee> employees = new ArrayList<>();

    public Department() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

}
