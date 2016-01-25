package com.infotop.app.webinfo.repository;

import com.infotop.app.webinfo.entity.WebInfo;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface WebInfoDao extends PagingAndSortingRepository<WebInfo, Long>, JpaSpecificationExecutor<WebInfo>  {

}