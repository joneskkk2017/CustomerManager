package com.jones.cm.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**   
*    
* 项目名称：CustomerMana   
* 名称：JDBCUtils   
* 描述：   
* 创建人：jones   
* 创建时间：2018年7月15日 下午12:34:56   
* @version        
*/
public class JDBCUtils {

	// 通过c3p0获得数据库的连接
	public static ComboPooledDataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		return dataSource;
	}
}
