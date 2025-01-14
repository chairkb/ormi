package biz.stech.technical;

import biz.stech.base.Connection;

@FunctionalInterface
public interface Callback2ProcessMemberFreeType {
	public boolean processClasz(Connection aConn, Object aClasz) throws Exception;
}

