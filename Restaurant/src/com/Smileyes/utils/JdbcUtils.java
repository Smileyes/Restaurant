package com.Smileyes.utils;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	private static QueryRunner qr;
	private static ComboPooledDataSource ds;
	static {
		ds = new ComboPooledDataSource();
		qr = new QueryRunner(ds);
	}

	// 获得QueryRunner
	public static QueryRunner getQr() {
		return qr;
	}

	// 获得Database连接
	public static ComboPooledDataSource getDs() {
		return ds;
	}

}
