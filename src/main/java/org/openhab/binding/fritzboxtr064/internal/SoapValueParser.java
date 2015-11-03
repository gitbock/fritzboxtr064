package org.openhab.binding.fritzboxtr064.internal;

import javax.xml.soap.SOAPMessage;

public interface SoapValueParser {
	/***
	 * 
	 * @param sm soap message to parse
	 * @param mapping itemmap with information about all TR064 parameters
	 * @param request the raw original request which was used in itemconfig
	 * @return the value which was parsed from soap message
	 */
	String parseValueFromSoapMessage(SOAPMessage sm, ItemMap mapping, String request);

}
