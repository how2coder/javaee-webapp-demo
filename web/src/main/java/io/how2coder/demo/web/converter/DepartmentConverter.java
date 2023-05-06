package io.how2coder.demo.web.converter;

import io.how2coder.demo.model.Department;

import java.util.Optional;
import java.util.function.Function;

public class DepartmentConverter implements WebConverter<Department> {

    private static volatile WebConverter<Department> instance;

    private DepartmentConverter() {
    }

    public static WebConverter<Department> getInstance() {
        if (instance == null) {
            synchronized (DepartmentConverter.class) {
                if (instance == null) {
                    instance = new DepartmentConverter();
                }
            }
        }
        return instance;
    }

    @Override
    public Department toObject(Function<String, Optional<String>> extractor) {
        Department department = new Department();
        extractor.apply("dep_id").map(Long::valueOf).ifPresent(department::setId);
        extractor.apply("dep_name").ifPresent(department::setName);
        return department;
    }
}
