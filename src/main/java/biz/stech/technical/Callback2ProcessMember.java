package biz.stech.technical;

import biz.stech.base.Connection;
import biz.stech.db.object.Clasz;

@FunctionalInterface
public interface Callback2ProcessMember<Ty extends Clasz<?>> {
	public boolean processClasz(Connection aConn, Ty aClasz) throws Exception;
}

