package pl.juhas.bnabd.dto;

import pl.juhas.bnabd.entity.Employee;

import java.util.List;

public class EmpDtoMapper {
    public static EmpDto toDto(Employee emp) {
        return new EmpDto(emp.getFirstName(), emp.getLastName());
    }

    public static List<EmpDto> listToDto(List<Employee> employees) {
        return employees.stream()
                .map(EmpDtoMapper::toDto)
                .toList();
    }
}
