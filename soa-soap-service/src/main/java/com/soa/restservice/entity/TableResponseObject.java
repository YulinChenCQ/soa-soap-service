
/**
 * <一句话功能描述>
 * <p>layui table对应的数据格式
 * @author 陈宇林
 * @version [版本号, 2019年3月7日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */


package com.soa.restservice.entity;

public class TableResponseObject<T> {
	
	private int code;//数据状态
	
	private  String msg;//返回消息
	
	private int count;//数据条数
	
	private T data;//数据

	/**
	 * @param code
	 * @param msg
	 * @param count
	 * @param data
	 */
	public TableResponseObject(int code, String msg, int count, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}

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
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
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

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TableResponseObject [code=" + code + ", msg=" + msg + ", count=" + count + ", data=" + data + "]";
	}
	
	

}
