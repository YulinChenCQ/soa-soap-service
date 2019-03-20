
/**
 * <一句话功能描述>
 * <p>查询条件实体类
 * @author 陈宇林
 * @version [版本号, 2019年3月7日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package com.soa.restservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class QueryCondition {

	private String beginDate;// 开始时间

	private String endDate;// 结束时间

	private String billNumber;// 单号

	private String buyerName;// 购方名称

	private String buyerDutyParagraph;// 购方税号
	
	private int page;//页码
	
	private int pageSize;//每页数据条数
	
	
	
	
	
}
