package pack01.dao;

import java.sql.Connection;

import pack01.beans.JdbcBeans;

interface ConnectMake {
	abstract Connection connect();
	abstract void close(JdbcBeans jb);
}
