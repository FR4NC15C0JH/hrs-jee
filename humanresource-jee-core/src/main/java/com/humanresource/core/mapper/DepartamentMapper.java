package com.humanresource.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.humanresource.core.model.Departament;
import com.humanresource.core.model.dto.DepartamentDTO;

@Mapper(componentModel = "cdi", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartamentMapper extends BaseMapper<Departament, DepartamentDTO>{

}
