package org.qcwala1.dfsproject.qcplatform.qcinfo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.ws.rs.WebApplicationException;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, LocalDate> {

	@Override
	public String marshal(LocalDate v) throws Exception {
		System.out.println("marshalling Date: " + v.toString());
		return DateTimeFormatter.ISO_DATE.format(v);
	}

	@Override
	public LocalDate unmarshal(String v) throws Exception {
		try {
			System.out.println("Unmarshalling Date: " + v.toString());

			return LocalDate.parse(v, DateTimeFormatter.ISO_DATE);
		} catch (Exception e) {
			throw new WebApplicationException();
		}

	}

}
