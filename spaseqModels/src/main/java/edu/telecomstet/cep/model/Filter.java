/*
* @(#)Filter.java   14/10/14
*
* Copyright (c) 2014 Telecon Saint-Etienn & EMSE
*
* THE WORK (AS DEFINED BELOW) IS PROVIDED UNDER THE TERMS OF
* THIS CREATIVE COMMONS PUBLIC LICENCE ("CCPL" OR "LICENCE").
* THE WORK IS PROTECTED BY COPYRIGHT AND/OR OTHER APPLICABLE LAW.
* ANY USE OF THE WORK OTHER THAN AS AUTHORIZED UNDER THIS LICENCE OR COPYRIGHT LAW IS PROHIBITED.
* BY EXERCISING ANY RIGHTS TO THE WORK PROVIDED HERE, YOU ACCEPT AND AGREE TO BE BOUND BY THE TERMS OF THIS LICENCE.
* THE LICENSOR GRANTS YOU THE RIGHTS CONTAINED HERE IN CONSIDERATION OF YOUR ACCEPTANCE OF SUCH TERMS AND CONDITIONS.
*
*
*
*/

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package edu.telecomstet.cep.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.semanticweb.yars.nx.Literal;

import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;
import edu.telecomstet.cep.statefull.StateDependability;

/**
 *
 * @author sydgillani
 */
public class Filter {
	private String filterProjection;
	private String filterRightProjection;
	private Object filterValue;
	private Object filterMappedValue;
	private String filterOperand;
	private int filterType;
	// private ValueFactory factory;
	private boolean isFilter;
	// String filterComp; // ?
	// private boolean filterStatus;

	private DictionaryOpImpl dictImplOp;
	private boolean isfilterKB;

	private int filterDataType;

	private int stateFulness; /// 1 for true, 0 for false.

	private StateDependability d;

	public Filter(DictionaryOpImpl dictImpl) {
		// factory = ValueFactoryImpl.getInstance();
		this.dictImplOp = dictImpl;

		this.isFilter = false;

	}

	/*
	 * public boolean filterValueManipulation(String filter) throws
	 * ParseException, DatatypeConfigurationException { filter =
	 * filter.replace("'", "");
	 * 
	 * if (filter.contains("<") && filter.contains(">")) { //// A proper pattern
	 * May be? filter = filter.replace("<", ""); filter = filter.replace(">",
	 * "");
	 * 
	 * // /remove < and > this.filterValue = factory.createURI(filter);
	 * this.filterMappedValue = this.dictImpl.addResource((Resource)
	 * this.filterValue);
	 * 
	 * return true; } else { if (isInteger(filter)) { this.filterValue =
	 * factory.createLiteral(Integer.parseInt(filter)); // 0: int, 1: float, 2:
	 * decimal, 3: DataTime, 4: Double, 5: string, 6: Long, 7: georgian
	 * Calender, 8: Boolean this.filterMappedValue =
	 * this.dictImpl.addLiteral((Literal) this.filterValue); this.filterDataType
	 * = 0; return true; } else if (isDateTime(filter)) { Date datetime = new
	 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(filter);
	 * 
	 * this.filterValue = factory.createLiteral(datetime);
	 * this.filterMappedValue = this.dictImpl.addLiteral((Literal)
	 * this.filterValue); this.filterDataType = 3; return true; } else if
	 * (isFloat(filter)) { this.filterValue =
	 * factory.createLiteral(Float.parseFloat(filter)); this.filterMappedValue =
	 * this.dictImpl.addLiteral((Literal) this.filterValue); this.filterDataType
	 * = 1; return true; }
	 * 
	 * if (isDouble(filter)) { this.filterValue =
	 * factory.createLiteral(Double.parseDouble(filter)); this.filterMappedValue
	 * = this.dictImpl.addLiteral((Literal) this.filterValue);
	 * this.filterDataType = 4; return true; } else if (isLong(filter)) {
	 * this.filterValue = factory.createLiteral(Long.parseLong(filter));
	 * this.filterMappedValue = this.dictImpl.addLiteral((Literal)
	 * this.filterValue); this.filterDataType = 6; return true; } else if
	 * (isBoolean(filter)) { this.filterValue =
	 * factory.createLiteral(Boolean.parseBoolean(filter));
	 * this.filterMappedValue = this.dictImpl.addLiteral((Literal)
	 * this.filterValue); this.filterDataType = 8; return true; } else if
	 * (isXMLGregorianCalender(filter)) { this.filterValue =
	 * factory.createLiteral(DatatypeFactory.newInstance().
	 * newXMLGregorianCalendar(filter)); this.filterMappedValue =
	 * this.dictImpl.addLiteral((Literal) this.filterValue); this.filterDataType
	 * = 7; return true; } else if (filter instanceof String) { this.filterValue
	 * = factory.createLiteral(filter.toString()); this.filterMappedValue =
	 * this.dictImpl.addLiteral((Literal) this.filterValue); this.filterDataType
	 * = 5; return true; } }
	 * 
	 * return false; }
	 */

	public boolean filterValuePersistant(String s, HashMap<String, Integer> map)
			throws ParseException, DatatypeConfigurationException {

		s = s.replace("'", "");
		if (s.contains("<") && s.contains(">") && !s.contains("^^")) { //// A
																		//// proper
																		//// pattern
																		//// May
																		//// be?
			org.semanticweb.yars.nx.Resource predRes = new org.semanticweb.yars.nx.Resource(s, true);

			this.filterValue = predRes;
			this.filterMappedValue = dictImplOp.addResourcePersistant(predRes);
			return true;
		} else if (s.contains("^^")) { // if contains the data type then use the
										// datatype, otherwise consider it as a
										// string
			String[] ss = s.split("\\^");
			/// first element is the data send it for the literal creation
			// second is useless and third is the datatype
			ss[0] = ss[0].replaceAll("'", "");
			Literal nL // = new Literal(ss[0]);

					= new Literal(s, true, map);
			// System.out.println("here");
			// nL.setType(4);
			this.checkDataType(ss[2], nL, ss[0]);
			this.filterDataType = nL.getType();
			this.filterMappedValue = this.dictImplOp.addLiteralPersistant(nL);
			this.filterValue = nL;
			return true;
		} else {
			try {
				Literal nL = new Literal(s);
				this.filterDataType = nL.getType();
				this.filterMappedValue = this.dictImplOp.addLiteralPersistant(nL);
				this.filterValue = nL;
			} catch (Exception ex) {
				System.out.println(
						"Unable to parse the Filter caluse in the query, please check if the data type is given such as 'Filter(?x > '2'^^xsd:integer)'");
			}

			// nL.setType(4);
			// this.checkDataType(s, nL);

			return false;
		}

	}

	/// // 0: int, 1: float, 2: decimal, 3: DataTime, 4: Double, 5: string, 6:
	/// Long, 7:boolean
	private void checkDataType(String type, Literal L, String data) {
		if (type.equals("xsd:integer")) {
			L.setType(0);
			final int oInteger;

			/// convert it to Integer
			try {
				oInteger = Integer.parseInt(data);
				L.setValue(oInteger);

			} catch (Exception ex) {
				System.out.println("Cannot parse the integer in the Filter Clause");
			}

		} else if (type.equals("xsd:double")) {
			L.setType(4);

			final double aDouble;
			try {
				aDouble = Double.parseDouble(data);
				L.setValue(aDouble);

			} catch (Exception ex) {
				System.out.println("Cannot parse the double in the Filter Clause");
			}

		} else if (type.equals("xsd:long")) {
			L.setType(6);
		} else if (type.equals("xsd:float")) {
			L.setType(1);
		}
	}

	public String getFilterProjection() {
		return filterProjection;
	}

	public void setFilterProjection(String filterProjection) {
		this.filterProjection = filterProjection;
	}

	public String getFilterOperand() {
		return filterOperand;
	}

	public void setFilterOperand(String filterOperand) {
		this.filterOperand = filterOperand;
	}

	public int getFilterType() {
		return filterType;
	}

	public void setFilterType(int filterType) {
		this.filterType = filterType;
	}

	public boolean isIsFilter() {
		return isFilter;
	}

	public void setIsFilter(boolean isFilter) {
		this.isFilter = isFilter;
	}

	public static boolean isXMLGregorianCalender(String b) {
		try {
			DatatypeFactory.newInstance().newXMLGregorianCalendar(b);
			System.out.println(DatatypeFactory.newInstance().newXMLGregorianCalendar(b));
		} catch (Exception e) {

			// Logger.getLogger(NFAdata.class.getName()).log(Level.SEVERE, null,
			// ex);
			return false;
		}

		return true;
	}

	public static boolean isBoolean(String b) {
		try {
			boolean t = Boolean.valueOf(b);

			if (!t) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public static boolean isLong(String l) {
		try {
			Long.parseLong(l);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public static boolean isDouble(String d) {
		try {
			Double.parseDouble(d);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public static boolean isFloat(String f) {
		try {
			Float.parseFloat(f);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}

		// only got here if we didn't return false
		return true;
	}

	public static boolean isDateTime(String d) {
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(d);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public Object getFilterValue() {
		return filterValue;
	}

	public void setFilterValue(Object filterValue, HashMap<String, Integer> map)
			throws ParseException, DatatypeConfigurationException {
		this.filterValuePersistant(filterValue.toString(), map);

		// this.filterValue = filterValue;
	}

	/*
	 * public String getFilterComp() { return filterComp; }
	 * 
	 * public void setFilterComp(String filterComp) { this.filterComp =
	 * filterComp; }
	 */

	public Object getFilterMappedValue() {
		return filterMappedValue;
	}

	public void setFilterMappedValue(Object filterMappedValue) {
		this.filterMappedValue = filterMappedValue;
	}

	public String getFilterRightProjection() {
		return filterRightProjection;
	}

	public void setFilterRightProjection(String filterRightProjection) {
		this.filterRightProjection = filterRightProjection;
	}

	public boolean isIsfilterKB() {
		return isfilterKB;
	}

	public void setIsfilterKB(boolean isfilterKB) {
		this.isfilterKB = isfilterKB;
	}

	public int getFilterDataType() {
		return filterDataType;
	}

	public void setFilterDataType(int filterDataType) {
		this.filterDataType = filterDataType;
	}

	public int getStateFulness() {
		return stateFulness;
	}

	public void setStateFulness(int stateFulness) {
		this.stateFulness = stateFulness;
	}

	public StateDependability getD() {
		return d;
	}

	public void setD(StateDependability d) {
		this.d = d;
	}
}

// ~ Formatted by Jindent --- http://www.jindent.com
