package com.humanresource.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.humanresource.core.model.Job;
import com.humanresource.core.model.dto.JobDTO;

@Mapper(componentModel = "cdi", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobMapper extends BaseMapper<Job, JobDTO>{

}
