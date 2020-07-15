package com.humanresource.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.humanresource.core.model.Employees;
import com.humanresource.core.model.dto.DepartamentDTO;
import com.humanresource.core.model.dto.EmployeesDTO;
import com.humanresource.core.model.dto.JobDTO;

@Mapper(componentModel = "cdi", unmappedTargetPolicy = ReportingPolicy.IGNORE,uses = {DepartamentDTO.class, JobDTO.class})
public interface EmployeesMapper extends BaseMapper<Employees, EmployeesDTO>{

}
