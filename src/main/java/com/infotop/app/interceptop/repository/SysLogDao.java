package com.infotop.app.interceptop.repository;

import com.infotop.app.interceptop.entity.SysLog;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SysLogDao extends PagingAndSortingRepository<SysLog, Long>, JpaSpecificationExecutor<SysLog>  {

}