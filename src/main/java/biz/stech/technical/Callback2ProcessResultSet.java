package biz.stech.technical;

import biz.stech.base.Connection;
import java.sql.ResultSet;

@FunctionalInterface
public interface Callback2ProcessResultSet {
	public boolean processResultSet(Connection aConn, ResultSet aResultSet) throws Exception;
}
