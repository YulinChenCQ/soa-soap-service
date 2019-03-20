
/**
 * <一句话功能描述>
 * <p>SAP 传输发票明细数据实体类
 * @author 陈宇林
 * @version [版本号, 2019年3月15日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package com.soa.webservice.entity;

import java.math.BigDecimal;

public class TItem {
	
	
	private String REFVBELN ;//金税单据号
	
	private String MAKTX;//物料描述
	
	private String MSPEC;//商品规格
	
	private String MEINS;//基本计量单位
	
	private BigDecimal FKIMG;//已开票数量
	
	private BigDecimal UNITPE;//单价
	
	private BigDecimal NETWR;//净值
	
	private BigDecimal TAXRATE;//增值税税率
	
	private BigDecimal TAXAMT;//税金
	
	private String MATL_CAT_NAME;//分类编码名称

	/**
	 * @return the rEFVBELN
	 */
	public String getREFVBELN() {
		return REFVBELN;
	}

	/**
	 * @return the mAKTX
	 */
	public String getMAKTX() {
		return MAKTX;
	}

	/**
	 * @return the mSPEC
	 */
	public String getMSPEC() {
		return MSPEC;
	}

	/**
	 * @return the mEINS
	 */
	public String getMEINS() {
		return MEINS;
	}

	/**
	 * @return the fKIMG
	 */
	public BigDecimal getFKIMG() {
		return FKIMG;
	}

	/**
	 * @return the uNITPE
	 */
	public BigDecimal getUNITPE() {
		return UNITPE;
	}

	/**
	 * @return the nETWR
	 */
	public BigDecimal getNETWR() {
		return NETWR;
	}

	/**
	 * @return the tAXRATE
	 */
	public BigDecimal getTAXRATE() {
		return TAXRATE;
	}

	/**
	 * @return the tAXAMT
	 */
	public BigDecimal getTAXAMT() {
		return TAXAMT;
	}

	/**
	 * @return the mATL_CAT_NAME
	 */
	public String getMATL_CAT_NAME() {
		return MATL_CAT_NAME;
	}

	/**
	 * @param rEFVBELN the rEFVBELN to set
	 */
	public void setREFVBELN(String rEFVBELN) {
		REFVBELN = rEFVBELN;
	}

	/**
	 * @param mAKTX the mAKTX to set
	 */
	public void setMAKTX(String mAKTX) {
		MAKTX = mAKTX;
	}

	/**
	 * @param mSPEC the mSPEC to set
	 */
	public void setMSPEC(String mSPEC) {
		MSPEC = mSPEC;
	}

	/**
	 * @param mEINS the mEINS to set
	 */
	public void setMEINS(String mEINS) {
		MEINS = mEINS;
	}

	/**
	 * @param fKIMG the fKIMG to set
	 */
	public void setFKIMG(BigDecimal fKIMG) {
		FKIMG = fKIMG;
	}

	/**
	 * @param uNITPE the uNITPE to set
	 */
	public void setUNITPE(BigDecimal uNITPE) {
		UNITPE = uNITPE;
	}

	/**
	 * @param nETWR the nETWR to set
	 */
	public void setNETWR(BigDecimal nETWR) {
		NETWR = nETWR;
	}

	/**
	 * @param tAXRATE the tAXRATE to set
	 */
	public void setTAXRATE(BigDecimal tAXRATE) {
		TAXRATE = tAXRATE;
	}

	/**
	 * @param tAXAMT the tAXAMT to set
	 */
	public void setTAXAMT(BigDecimal tAXAMT) {
		TAXAMT = tAXAMT;
	}

	/**
	 * @param mATL_CAT_NAME the mATL_CAT_NAME to set
	 */
	public void setMATL_CAT_NAME(String mATL_CAT_NAME) {
		MATL_CAT_NAME = mATL_CAT_NAME;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TItem [REFVBELN=" + REFVBELN + ", MAKTX=" + MAKTX + ", MSPEC=" + MSPEC + ", MEINS=" + MEINS + ", FKIMG="
				+ FKIMG + ", UNITPE=" + UNITPE + ", NETWR=" + NETWR + ", TAXRATE=" + TAXRATE + ", TAXAMT=" + TAXAMT
				+ ", MATL_CAT_NAME=" + MATL_CAT_NAME + "]";
	}

	

	
	
	
	

}
