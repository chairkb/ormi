package biz.stech.technical;

import biz.stech.base.Connection;
import biz.stech.db.object.Clasz;

@FunctionalInterface
public interface Callback2ProcessClasz {
	public boolean processClasz(Connection aConn, Clasz<?> aClasz) throws Exception;
}

