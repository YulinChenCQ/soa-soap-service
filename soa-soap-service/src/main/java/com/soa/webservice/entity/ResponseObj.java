
/**
 * <一句话功能描述>
 * <p>webservice 返回对象实体类
 * @author 陈宇林
 * @version [版本号, 2019年3月13日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
package com.soa.webservice.entity;

public class ResponseObj {

	/**
	 * 状态代码
	 *  0->失败
	 *  1->成功
	 */
	private int code;
	
	/**
	 * 返回信息，例如：
	 * success
	 */
	private String msg;

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResponseObj [code=" + code + ", msg=" + msg + "]";
	}

}
