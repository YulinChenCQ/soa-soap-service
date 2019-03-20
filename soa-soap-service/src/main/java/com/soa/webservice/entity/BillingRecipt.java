
/**
 * <一句话功能描述>
 * <p>开票信息回执实体类
 * @author 陈宇林
 * @version [版本号, 2019年3月13日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package com.soa.webservice.entity;

import java.util.List;


import org.springframework.stereotype.Component;

@Component
public class BillingRecipt {

	
	
	private String invNo;// 发票号码（回写）

	private String prtSw;// 打印标记（回写）

	private List<Children> children;
	
	

	/**
	 * @return the children
	 */
	public List<Children> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(List<Children> children) {
		this.children = children;
	}

	/**
	 * @return the invNo
	 */
	public String getInvNo() {
		return invNo;
	}

	/**
	 * @return the prtSw
	 */
	public String getPrtSw() {
		return prtSw;
	}

	/**
	 * @param invNo
	 *            the invNo to set
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	/**
	 * @param prtSw
	 *            the prtSw to set
	 */
	public void setPrtSw(String prtSw) {
		this.prtSw = prtSw;
	}

	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BillingRecipt [invNo=" + invNo + ", prtSw=" + prtSw + ", children=" + children + "]";
	}

}
