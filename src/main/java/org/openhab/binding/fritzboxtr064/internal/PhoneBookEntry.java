package org.openhab.binding.fritzboxtr064.internal;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Node;


public class PhoneBookEntry {
	
	//default logger
	private static final Logger logger = LoggerFactory.getLogger(FritzboxTr064Binding.class);
	
	// Phone numbers
	private String _privateTel;
	private String _businessTel;
	private String _mobileTel;
	private String _fax;
	
	//Phonebook Name this entry is contained in
	private String _phoneBookName;
	
	//Real Name 
	private String _name;
	
	//unique ID
	private String _uniqueid;
	
	/***
	 * Creates Entry Object by parsing the Node <contact>
	 * @param xmlNode
	 */
	public PhoneBookEntry() {
		
	}
	
	/***
	 * Parses the Object from xml node. 
	 * @param xmlNode needs to be node with <contact>...</contact>
	 * @return treu if successfully parsed
	 */
	public boolean parseFromNode(Node xmlNode) {
		boolean success = false;
		XPath xPath = XPathFactory.newInstance().newXPath();
		logger.debug(Helper.nodeToString(xmlNode));
		try {
			this._name = (String) xPath.evaluate("person/realName", xmlNode, XPathConstants.STRING);
			this._uniqueid = (String) xPath.evaluate("uniqueid", xmlNode, XPathConstants.STRING);
			this._businessTel = (String) xPath.evaluate("telephony/number[@type='work']", xmlNode, XPathConstants.STRING);
			this._privateTel = (String) xPath.evaluate("telephony/number[@type='home']", xmlNode, XPathConstants.STRING);
			this._mobileTel = (String) xPath.evaluate("telephony/number[@type='mobile']", xmlNode, XPathConstants.STRING);
			this._fax = (String) xPath.evaluate("telephony/number[@type='fax']", xmlNode, XPathConstants.STRING);
			// xpath is awesome :)
			
		} catch (XPathExpressionException e) {
			logger.error("Could not parse Phonebook Entry ", e);
		}
		//check if id could be parsed as success
		if(!this._uniqueid.isEmpty()){
			success = true;
		}
		else{
			logger.warn("Could not parse phone book entry: "+Helper.nodeToString(xmlNode));
		}
		return success;
	}
	
	


	public String get_privateTel() {
		return _privateTel;
	}

	public void set_privateTel(String _privateTel) {
		this._privateTel = _privateTel;
	}

	public String get_businessTel() {
		return _businessTel;
	}

	public void set_businessTel(String _businessTel) {
		this._businessTel = _businessTel;
	}

	public String get_mobileTel() {
		return _mobileTel;
	}

	public void set_mobileTel(String _mobileTel) {
		this._mobileTel = _mobileTel;
	}

	public String get_fax() {
		return _fax;
	}

	public void set_fax(String _fax) {
		this._fax = _fax;
	}

	public String get_phoneBookName() {
		return _phoneBookName;
	}

	public void set_phoneBookName(String _phoneBookName) {
		this._phoneBookName = _phoneBookName;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public String get_id() {
		return _uniqueid;
	}

	public void set_id(String _id) {
		this._uniqueid = _id;
	}
	

	
	
	
}
