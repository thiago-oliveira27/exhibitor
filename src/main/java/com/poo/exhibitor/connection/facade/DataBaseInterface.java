package com.poo.exhibitor.connection.facade;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DataBaseInterface {
	
	void connect();
	void disconnect();
	ResultSet executeQuery(String query,Long id);

}
