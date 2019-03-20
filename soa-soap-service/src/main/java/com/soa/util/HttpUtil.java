package com.soa.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;


/**
 * HTTP工具类
 * 
 * @author PJ
 * @date 2018年12月27日 上午11:16:45
 *
 */
@Component
public class HttpUtil {

	private static HttpUtil httpUtil = null;
	private static PoolingHttpClientConnectionManager poolConnManager;

	private HttpUtil() {
		initHttpPool();
	}

	public static synchronized HttpUtil getInstance() {
		if (httpUtil == null) {
			httpUtil = new HttpUtil();
		}
		return httpUtil;
	}

	/**
	 * 初始化HTTP连接池
	 */
	private void initHttpPool() {
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
				.register("http", PlainConnectionSocketFactory.getSocketFactory()).build();

		poolConnManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
		poolConnManager.setMaxTotal(2000);
		poolConnManager.setDefaultMaxPerRoute(10);
		SocketConfig socketConfig = SocketConfig.custom().setSoTimeout(30000).build();
		poolConnManager.setDefaultSocketConfig(socketConfig);
	}

	/**
	 * 发送HTTP请求
	 * 
	 * @param url
	 * @param reqMsg
	 * @param servId
	 * @param sysId
	 * @param serialNo
	 * @return
	 * @throws Exception
	 */
	public String requestHttp(String url, String reqMsg, String servId, String sysId, String serialNo)
			throws Exception {
		// 设置超时时间
		Integer connect_timeout = 30000;
		Integer connection_request_timeout = 30000;
		Integer socket_timeout = 60000;
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(connect_timeout)
				.setConnectionRequestTimeout(connection_request_timeout).setSocketTimeout(socket_timeout)
				.setCookieSpec(CookieSpecs.STANDARD).build();

		// 创建HttpClient客户端
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(poolConnManager)
				.setDefaultRequestConfig(requestConfig).build();

		// 拼装报文体

		HttpPost httpPost = new HttpPost(url + "?servId=" + servId + "&sysId=" + sysId + "&serialNo=" + serialNo);

		System.out.println("url: " + url + "?servId=" + servId + "&sysId=" + sysId + "&serialNo=" + serialNo);
		HttpEntity he = new StringEntity(reqMsg, "UTF-8");
		httpPost.setEntity(he);

		// 发送请求
		String resMsg = "";
		try {
			CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				resMsg = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
			} else {
				throw new Exception(httpResponse.getStatusLine().toString());
			}
		} catch (Exception e) {
			throw e;
		} finally {
			httpPost.releaseConnection();
		}

		return resMsg;
	}

}
