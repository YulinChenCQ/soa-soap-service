
/**
 * <一句话功能描述>
 * <p> SAP 传送发票表头实体类
 * @author 陈宇林
 * @version [版本号, 2019年3月15日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package com.soa.webservice.entity;

import java.math.BigDecimal;
import java.util.List;

public class THeader {
	
	private String REFVBELN ;//金税单据号
	
	private String DOC_DATE;//凭证日期
	
	private String KNAME1;//客户名称
	
	private String KSTCD5;//税号 5
	
	private String KSTRAS;//地址
	
	private String KBANKA;//银行
	
	private BigDecimal ZJEHJ;//净值
	
	private String VUSNAM;//用户名
	
	private List<TItem> T_ITEM;//明细信息

	/**
	 * @return the rEFVBELN
	 */
	public String getREFVBELN() {
		return REFVBELN;
	}

	/**
	 * @return the dOC_DATE
	 */
	public String getDOC_DATE() {
		return DOC_DATE;
	}

	/**
	 * @return the kNAME1
	 */
	public String getKNAME1() {
		return KNAME1;
	}

	/**
	 * @return the kSTCD5
	 */
	public String getKSTCD5() {
		return KSTCD5;
	}

	/**
	 * @return the kSTRAS
	 */
	public String getKSTRAS() {
		return KSTRAS;
	}

	/**
	 * @return the kBANKA
	 */
	public String getKBANKA() {
		return KBANKA;
	}

	/**
	 * @return the zJEHJ
	 */
	public BigDecimal getZJEHJ() {
		return ZJEHJ;
	}

	/**
	 * @return the vUSNAM
	 */
	public String getVUSNAM() {
		return VUSNAM;
	}

	/**
	 * @return the t_ITEM
	 */
	public List<TItem> getT_ITEM() {
		return T_ITEM;
	}

	/**
	 * @param rEFVBELN the rEFVBELN to set
	 */
	public void setREFVBELN(String rEFVBELN) {
		REFVBELN = rEFVBELN;
	}

	/**
	 * @param dOC_DATE the dOC_DATE to set
	 */
	public void setDOC_DATE(String dOC_DATE) {
		DOC_DATE = dOC_DATE;
	}

	/**
	 * @param kNAME1 the kNAME1 to set
	 */
	public void setKNAME1(String kNAME1) {
		KNAME1 = kNAME1;
	}

	/**
	 * @param kSTCD5 the kSTCD5 to set
	 */
	public void setKSTCD5(String kSTCD5) {
		KSTCD5 = kSTCD5;
	}

	/**
	 * @param kSTRAS the kSTRAS to set
	 */
	public void setKSTRAS(String kSTRAS) {
		KSTRAS = kSTRAS;
	}

	/**
	 * @param kBANKA the kBANKA to set
	 */
	public void setKBANKA(String kBANKA) {
		KBANKA = kBANKA;
	}

	/**
	 * @param zJEHJ the zJEHJ to set
	 */
	public void setZJEHJ(BigDecimal zJEHJ) {
		ZJEHJ = zJEHJ;
	}

	/**
	 * @param vUSNAM the vUSNAM to set
	 */
	public void setVUSNAM(String vUSNAM) {
		VUSNAM = vUSNAM;
	}

	/**
	 * @param t_ITEM the t_ITEM to set
	 */
	public void setT_ITEM(List<TItem> t_ITEM) {
		T_ITEM = t_ITEM;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "THeader [REFVBELN=" + REFVBELN + ", DOC_DATE=" + DOC_DATE + ", KNAME1=" + KNAME1 + ", KSTCD5=" + KSTCD5
				+ ", KSTRAS=" + KSTRAS + ", KBANKA=" + KBANKA + ", ZJEHJ=" + ZJEHJ + ", VUSNAM=" + VUSNAM + ", T_ITEM="
				+ T_ITEM + "]";
	}

	

	
	
	

}
