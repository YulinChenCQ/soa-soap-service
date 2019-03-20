package com.soa.restservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.soa.restservice.entity.BillDetailInfo;
import com.soa.restservice.entity.QueryCondition;

@Mapper
public interface BillDetailInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(BillDetailInfo record);

    int insertSelective(BillDetailInfo record);

    BillDetailInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BillDetailInfo record);

    int updateByPrimaryKey(BillDetailInfo record);
    
    /**
	 * 根据条件查询发票明细表数据
	 * @param condition
	 * @return
	 */
	List<BillDetailInfo> selectByCondition(QueryCondition condition);
}