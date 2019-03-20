package com.soa.restservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.soa.restservice.entity.BillMainInfo;
import com.soa.restservice.entity.QueryCondition;

@Mapper
public interface BillMainInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(BillMainInfo record);

    int insertSelective(BillMainInfo record);

    BillMainInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BillMainInfo record);

    int updateByPrimaryKey(BillMainInfo record);
    
    /**
	 * 根据条件查询
	 * 
	 * @param condition
	 * @return
	 */
	List<BillMainInfo> selectByCondition(QueryCondition condition);
	
	/**
	 * 查询未发送的数据
	 * 并且回写金税发票号码不为空的数据
	 */
	List<BillMainInfo> selectByState(String state);
	
	/**
	 * 根据单据号修改发送状态
	 * @param record
	 * @return
	 */
	int updateStateByBillNumber(BillMainInfo record);
}