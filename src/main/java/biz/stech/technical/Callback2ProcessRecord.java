package biz.stech.technical;

import biz.stech.base.Connection;
import biz.stech.db.relational.Record;

@FunctionalInterface
public interface Callback2ProcessRecord {
	public boolean processRecord(Connection aConn, Record aRecord) throws Exception;
	
}
