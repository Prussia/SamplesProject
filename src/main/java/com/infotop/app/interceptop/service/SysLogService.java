package com.infotop.app.interceptop.service;

import java.util.List;
import java.util.Map;

import com.infotop.app.interceptop.entity.SysLog;
import com.infotop.app.interceptop.repository.SysLogDao;

import com.google.common.collect.Maps;
import com.infotop.common.log.BusinessLogger;
import com.infotop.system.account.service.ShiroDbRealm.ShiroUser;

import net.infotop.web.easyui.DataGrid;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;

/**
 * SysLogManager
 * $Id: SysLogManager.java,v 0.0.1 2015-11-03 15:57:48  $
 */
@Component
@Transactional(readOnly = true)
public class SysLogService {
	
	
	@Autowired
	private SysLogDao sysLogDao;
	
	@Autowired
	private BusinessLogger businessLogger;
	/**
	 * 保存一个SysLog，如果保存成功返回该对象的id，否则返回null
	 * @param entity
	 * @return 保存成功的对象的Id
	 */
	@Transactional(readOnly = false)
	public void save(SysLog entity){
		sysLogDao.save(entity);
		Map logData = Maps.newHashMap();
		logData.put("ID", entity.getId());
		businessLogger.log("sysLog", "SAVE", getCurrentUserName(), logData);
	}
	
	/**
	 * 根据一个ID得到SysLog
	 * 
	 * @param id
	 * @return
	 */
	public SysLog get(Long id){
		Map logData = Maps.newHashMap();
		logData.put("ID", id);
		businessLogger.log("sysLog", "GET", getCurrentUserName(), logData);
		return sysLogDao.findOne(id);
	}
	
	/**
	 * 删除一个SysLog
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = false)
    public void delete(Long id) {
        this.sysLogDao.delete(id);
		Map logData = Maps.newHashMap();
		logData.put("ID", id);
		businessLogger.log("sysLog", "DELETE", getCurrentUserName(), logData);
    }
	
	/**
	 * 批量删除SysLog
	 * @param ids
	 * @return
	 */
	@Transactional(readOnly = false)
	public void delete(List<Long> ids){
		List<SysLog> test = (List<SysLog>) this.sysLogDao.findAll(ids);
		this.sysLogDao.delete(test);
		Map logData = Maps.newHashMap();
		logData.put("IDS", ids);
		businessLogger.log("sysLog", "DELETE", getCurrentUserName(), logData);
	}
	

	/**
	 * 删除操作，支持单个删除和批量删除
	 * @param ids 要删除的记录ID
	 * @param bool true:物理删除 false:逻辑删除
	 */
	/*@Transactional(readOnly = false)
	public void delete(List<Long> ids, boolean bool) {
		List<SysLog> temp = (List<SysLog>) this.sysLogDao.findAll(ids);
		if (bool) {
			this.sysLogDao.delete(temp);
		} else {
			if (temp != null && temp.size() > 0) {
				for (SysLog obj : temp) {
					obj.setFlag(1);
					this.sysLogDao.save(obj);
				}
			}
		}
	}*/
   
   
    /**
	 * 创建分页请求.
	 */
	private PageRequest buildPageRequest(int pageNumber, int pagzSize,
			String sortType, String order) {
		Sort sort = null;
		if ("auto".equals(sortType)) {
			if ("asc".equalsIgnoreCase(order)) {
				sort = new Sort(Direction.ASC, "id");
			} else {
				sort = new Sort(Direction.DESC, "id");
			}
		} else {
			if ("asc".equalsIgnoreCase(order)) {
				sort = new Sort(Direction.ASC, sortType);
			} else {
				sort = new Sort(Direction.DESC, sortType);
			}
		}
		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}

    /**
     * 创建动态查询条件组合.
     */
    private Specification<SysLog> buildSpecification(Map<String, Object> filterParams) {
        Map<String, SearchFilter> filters = SearchFilter.parse(filterParams);
        Specification<SysLog> spec = DynamicSpecifications.bySearchFilter(filters.values(), SysLog.class);
        return spec;
    }
	
    
    public DataGrid dataGrid(Map<String, Object> searchParams, int pageNumber,
			int rows, String sortType, String order) {
		Page<SysLog> page = getAllSysLog(searchParams,
				pageNumber, rows, sortType, order);
		DataGrid dataGrid = new DataGrid();
		dataGrid.setTotal(page.getTotalElements());
		dataGrid.setRows(page.getContent());
		return dataGrid;
	}
    
    public Page<SysLog> getAllSysLog(
			Map<String, Object> filterParams, int pageNumber, int pageSize,
			String sortType, String order) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize,
				sortType, order);
		Specification<SysLog> spec = buildSpecification(filterParams);
		return sysLogDao.findAll(spec, pageRequest);
	}
    
    /**
	 * 取出Shiro中的当前用户LoginName.
	 */
	public String getCurrentUserName() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.loginName;
	}
}
