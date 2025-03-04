package biz.stech.db.relational;

import biz.stech.base.DateAndTime;
import biz.stech.base.Connection;
import org.joda.time.DateTime;

public class FieldDateTime extends Field {
	private DateTime valueDateTime;

	public FieldDateTime(String aName) {
		this.setDbFieldName(aName);
		this.setDbFieldType(FieldType.DATETIME);
	}

	public FieldDateTime(String aName, DateTime aValue) {
		this(aName);
		this.setValueDateTime(aValue);
	}

	public DateTime getValueDateTime() {
		return valueDateTime;
	}

	public void setValueDateTime(DateTime valueDateTime) {
		this.setModified(true);
		this.valueDateTime = valueDateTime;
	}

	@Override
	public void setValue(Object value) {
		this.setModified(true);
		this.setValueDateTime((DateTime) value);
	}

	/*
	@Override
	public Object getValueObj() {
		return(valueDateTime);
	}
	*/

	@Override
	public Object getValueObj(Connection aConn) {
		return(valueDateTime);
	}

	@Override
	public synchronized String getValueStr() throws Exception {
		String result = "";
		if (this.getValueDateTime() != null) {
			result = DateAndTime.FormatForTimezone(this.getValueDateTime());
		}
		return(result);
	}

	@Override
	public synchronized void setValueStr(String valueStr) throws Exception {
		this.setModified(true);
		if (valueStr == null || valueStr.isEmpty() || valueStr.trim().equals("--")) {
			this.setValueDateTime(null);
		} else {
			//this.setValueDateTime(DateAndTime.StrToDateTime(valueStr, DateAndTime.FORMAT_TIMEZONE));
			this.setValueDateTime(DateAndTime.DisplayStrToDateTime(valueStr));
		}
	}

}
