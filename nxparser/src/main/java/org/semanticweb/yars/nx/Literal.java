package org.semanticweb.yars.nx;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.semanticweb.yars.nx.util.NxUtil;

/**
 * An RDF literal of any data type
 * 
 * Need to do newline escaping for (string) literals otherwise it's not valid
 * RDF any more.
 * 
 * @author Andreas Harth
 * @author Tobias Kaefer
 */
public class Literal implements Node, Serializable {

	private static Logger _log = Logger.getLogger(Literal.class.getName());

	// data in string representation
	protected String _data = null;
	// language identifier
	protected String _lang = null;
	// datatype uri
	protected Resource _dt = null;
	// the whole string including @ or ^^ etc.
	protected String _wholeString = null;
	
     private int type=10; /// // 0: int, 1: float, 2: decimal, 3: DataTime, 4: Double, 5: string, 6: Long
	
      

	protected  Object value=0;
	
	
	
	


	public static final String XSD = "http://www.w3.org/2001/XMLSchema#";

	public static final Resource STRING = new Resource(XSD + "string");

	public static final Resource BOOLEAN = new Resource(XSD + "boolean");

	public static final Resource FLOAT = new Resource(XSD + "float");

	public static final Resource DECIMAL = new Resource(XSD + "decimal");
	public static final Resource INTEGER = new Resource(XSD + "integer");
	
	public static final Resource LONG = new Resource(XSD + "long");

	public static final Resource DOUBLE = new Resource(XSD + "double");

	public static final Resource DATETIME = new Resource(XSD + "dateTime");

	private static final Pattern PATTERN = Pattern
	        .compile("(?:\"(.*)\")(?:@([a-zA-Z]+(?:-[a-zA-Z0-9]+)*)|\\^\\^(<\\S+>))?"); 

	// version number for serialization
	private static final long serialVersionUID = 8911891129019471564L;

	
	
	/**
	 * Constructor.
	 * 
	 * @param data
	 *            the escaped string representation of the (simple) literal
	 */
	public Literal(String data) {
		//this(data, null, null);  ///over here check if its integer or not, if its integer, then add it as integer, if its long, add it as lon and vice versa
		
	/*if(this.isInteger(data)){
		
		
	}else if(this.isDouble(data)){
	
	
	}else if(this.isLong(data)){
		
	}else if(this.isFloat(data)){
		
	}else{
		value=data;
		type=5;
	}*/
	
	value=this.strToObject(data);
	}

	/**
	 * Constructor.
	 * 
	 * @param data
	 *            the escaped string representation of the (simple) literal
	 * @param lang
	 *            the language tag for the literal. Nx spec demands it to be
	 *            lowercase.
	 */
	public Literal(String data, String lang) {
		this(data, lang, null);
	}

	/**
	 * Constructor.
	 * 
	 * @param data
	 *            the escaped string representation of the (simple) literal
	 * @param dt
	 *            the datatype Resource of the Literal
	 */
	public Literal(String data, Resource dt) {
		this(data, null, dt);
	}

	/**
	 * Constructor.
	 * 
	 * @param data
	 *            the escaped string representation of the (simple) literal
	 * @param lang
	 *            the language tag for the literal. Nx spec demands it to be
	 *            lowercase.
	 * @param dt
	 *            the datatype Resource of the Literal
	 */
	public Literal(String data, String lang, Resource dt) {
		this(data, lang, dt, false);
	}

	public Literal(String data, String lang, Resource dt, boolean isN3) {
		if (!isN3) {
			if (data.equals("") || data.charAt(0) != '\"'
					|| data.charAt(data.length() - 1) != '\"') {
				_log.fine("String for Literal ("
						+ data
						+ ") had no surrounding quotes. Adding some and proceeding...");
				data = '\"' + data + '\"';
			}
			if ((lang != null && !"".equals(lang)) && dt != null)
				throw new IllegalArgumentException(
						"In Nx, only one of language and datatype can be given.");
			_wholeString = data
					+ ((lang == null || "".equals(lang)) ? (dt == null) ? "" : ("^^" + dt.toN3())
							: ("@" + lang));
			if (dt != null)
				_dt = dt;
		} else
			_wholeString = data;
	}

	public Literal(String data, boolean isN3, HashMap<String, Integer> map) {
	//	this(data, null, null, isN3);
		
		String[] data2=data.split("\\^");
		///TODO:change over here
if(data2.length==3){
	
	
	///then use the function to parse the stuff
	
	if(map.containsKey(data2[2])){
		type=map.get(data2[2]);
	}else{
		 type=5;
	}
	
	
	 value=data2[0].replace("\"", "");
}else{
	 type=5;
	 value=data2[0].replace("\"", "");
}
	//	data=data2[0].replace("\"", "");
				
	/*	if(this.isInteger(data)){
			
			
		}else if(this.isDouble(data)){
		
		
		}else if(this.isLong(data)){
			
		}else if(this.isFloat(data)){
			
		}else{
			value=data;
			type=5;
		}
		*/
		
		//value=this.strToObject(data);
		
		
	}
	
	


	/**
	 * Get escaped data. For compatibility's sake, this returns the text of the
	 * literal (w/o surrounding quotes). (This method will now avoid writing 
	 * a null.)
	 * 
	 * @return a) the text of the literal, b) the full N3 form of the literal if
	 * there is a problem.
	 */
	public String getData() {
		if (_data == null) {
			Matcher m  = PATTERN.matcher(_wholeString);
			if (m.matches())
				_data = m.group(1);
			else{
				_log.warning("Something wrong with the literal-backing string. The parsing regex pattern didn't match. Check the string for correct N3 syntax. The malicious string is: "
						+ _wholeString);
				int lastIndex = _wholeString.lastIndexOf('"');
				if(lastIndex>0){
					return _wholeString.substring(1, lastIndex);
				} else{
					return _wholeString;
				}
			}
		}
		return _data;
	}

	/**
	 * Get markup escaped data.
	 * 
	 * @return String data
	 */
	public String getMarkupEscapedData() {
		return NxUtil.escapeForMarkup(getData());
	}

	/**
	 * Get unescaped data.
	 * 
	 * @return String data
	 */
	public String getUnescapedData() {
		return NxUtil.unescape(getData());
	}

	/**
	 * Get language tag.
	 * 
	 * @return a) the language tag if one is supplied b) null pointer, if there
	 *         is no such language tag, c) null pointer, if there is something
	 *         wrong with the literal-backing string
	 */
	public String getLanguageTag() {
		if (_lang == null) {
			Matcher m  = PATTERN.matcher(_wholeString);
			if (!m.matches())
				_log.warning("The parsing regex pattern didn't match, so no language tag is returned. Check the Literal for proper N3 syntax. The malicious Literal was: "
						+ _wholeString);
			else
				_lang = m.group(2);
		}
		return _lang;
	}

	/**
	 * Check whether it's a constant (literals are always).
	 * 
	 */
	public boolean isConstant() {
		return true;
	}

	/**
	 * Get data type.
	 * 
	 * @return a) the resource if one is supplied, b) null pointer, if there is
	 *         no such resource, c) null pointer, if there is something wrong
	 *         with the literal-backing string
	 */
	public Resource getDatatype() {
		if (_dt == null) {
			Matcher m  = PATTERN.matcher(_wholeString);
			if (m.matches()) {
				if (m.group(3) == null)
					return null;
				_dt = new Resource(m.group(3), true);
			} else {
				_log.warning("Something wrong with the Resource. Its String: "
						+ _wholeString
						+ " didn't match the parsing regex pattern. Probably it's no proper N3.");
			}
		}
		return _dt;
	}

//	 /**
//	 * Get object representing datatype-value of literal.
//	 *
//	 * @return datatype value or null if (i) unsupported datatype; (ii) plain literal (w/wo/ lang tag)
//	 * @throws DatatypeParseException if supported datatype with bad syntax
//	 */
//	 public Datatype<? extends Object> getDatatypeObject() throws DatatypeParseException {
//		 return DatatypeFactory.getDatatype(getUnescapedData(), getDatatype());
//	 }
	
	/**
	 * Get value as a string.
	 * 
	 */
	public String toString() {
		return NxUtil.unescape(getData());
	}

	/**
	 * Print N3 representation.
	 * 
	 */
	public String toN3() {
		return _wholeString;
	}

	@Override
	public int compareTo(Object o) {
		if (o == this)
			return 0;

		if (o instanceof Literal) {
			Literal l = (Literal) o;
			return this._wholeString.compareTo(l._wholeString);
		} else if (o instanceof Resource) {
			return Integer.MIN_VALUE / 4;
		} else if (o instanceof BNode) {
			return Integer.MIN_VALUE / 3;
		} else if (o instanceof Unbound) {
			return Integer.MIN_VALUE / 2;
		} else if (o instanceof Variable) {
			return Integer.MIN_VALUE;
		}

		throw new ClassCastException("parameter is not of type Literal but "
				+ o.getClass().getName());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Literal other = (Literal) obj;
		if (_data == null) {
			if (other._data != null)
				return false;
		} else if (!_data.equals(other._data))
			return false;
		if (_dt == null) {
			if (other._dt != null)
				return false;
		} else if (!_dt.equals(other._dt))
			return false;
		if (_lang == null) {
			if (other._lang != null)
				return false;
		} else if (!_lang.equals(other._lang))
			return false;
		if (_wholeString == null) {
			if (other._wholeString != null)
				return false;
		} else if (!_wholeString.equals(other._wholeString))
			return false;
		if (type != other.type)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_data == null) ? 0 : _data.hashCode());
		result = prime * result + ((_dt == null) ? 0 : _dt.hashCode());
		result = prime * result + ((_lang == null) ? 0 : _lang.hashCode());
		result = prime * result
				+ ((_wholeString == null) ? 0 : _wholeString.hashCode());
		result = prime * result + type;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	protected int getHashCode() {
		return hashCode();
	}

	/**
	 * Escapes strings to unicode.
	 * 
	 * @deprecated Use
	 *             {@link org.semanticweb.yars.nx.util.NxUtil#escapeForNx(String)}
	 */
	public static String escapeForNx(String lit) {
		return NxUtil.escapeForNx(lit);
	}

	/**
	 * Escapes strings for markup.
	 * 
	 * @deprecated Use
	 *             {@link org.semanticweb.yars.nx.util.NxUtil#escapeForMarkup(String)}
	 */
	public static String escapeForMarkup(String lit) {
		return NxUtil.escapeForMarkup(lit);
	}

	/**
	 * Unescape special characters in literal by removing excess backslashes.
	 * 
	 * @param str
	 *            The string to escape
	 * @deprecated Use
	 *             {@link org.semanticweb.yars.nx.util.NxUtil#unescape(String)}
	 */
	public static String unescape(String str) {
		return NxUtil.unescape(str);
	}

	/**
	 * Override readObject for backwards compatability and storing hashcode.
	 */
	private void readObject(ObjectInputStream ois)
			throws ClassNotFoundException, IOException {
		ois.defaultReadObject();
	}
	
	
	
	 private  boolean isBoolean(String b) {  
		 /// // 0: int, 1: float, 2: decimal, 3: DataTime, 4: Double, 5: string, 6: Long, 7:boolean
		 boolean cv;
	        try {
	          cv = Boolean.parseBoolean(b);
	           
	        } catch (Exception e) {
	            return false;
	        }
value=cv;
type=7;
_dt =this.BOOLEAN;
	        return true;
	    }

	    private  boolean isLong(String l) {
	    	long ll;
	        try {
	         ll=   Long.parseLong(l);
	        } catch (Exception e) {
	            return false;
	        }
           value=ll;
           type=6;
           _dt=this.LONG;
	        return true;
	    }

	     private boolean isDouble(String d) {
	    	 double dl;
	        try {
	            dl=Double.parseDouble(d);
	        } catch (Exception e) {
	            return false;
	        }
	        type=4;
            value=dl;
            _dt =this.DOUBLE;
	        return true;
	    }

	    private  boolean isFloat(String f) {
	    	float fl;
	        try {
	          fl=  Float.parseFloat(f);
	        } catch (Exception e) {
	            return false;
	        }
	        type=1;
         value=fl;
       _dt =this.FLOAT;
	        return true;
	    }

	    private boolean isInteger(String s) {
	    	  int  t;
	        try {
	            t=  Integer.parseInt(s);
	        
	        } catch (NumberFormatException e) {
	            return false;
	        }
	        type=0;
             value=t;
             _dt =this.INTEGER;
	        // only got here if we didn't return false
	        return true;
	    }

	     private  boolean isDateTime(String d) {
	    	 Date date;
	        try {
	          date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(d);
	        } catch (Exception e) {
	            return false;
	        }
	        type=3;
value=date;
_dt =this.DATETIME;
	        return true;
	    }
	     
	     
	     
	     public Object strToObject( final String str )
	     {
	    	 
	    	 
	   
	         if ( str == null || str.length() > 17 )
	         {  //out of Long range
	        	 type=5;
	             return str;
	         }
	         if ( str.equals( "" ) )
	             return ""; //ensure interned string is returned
	         if ( str.length() == 1 ){
	        	 
	        	 ///pasrse it to int and get the exception
	        	 
	        	 try {
	 	            return Integer.parseInt(str);
	 	        
	 	        } catch (NumberFormatException e) {
	 	            return str;
	 	        }
	            // return str.charAt( 0 );
	         }//return Character
	         //if starts with zero - support only "0" and "0.something"
	         if ( str.charAt( 0 ) == '0' )
	         {
	             if ( str.equals( "0" ) ){
	            	 type=0;
	                 return (int)0;
	             }
	             if ( !str.startsWith( "0." ) ) { //this may be a double
	              type=4;
	              Double var =Double.valueOf(str);
	            	 return var;    ///for Double
	             }
	         }

	         long res = 0;
	         int sign = 1;
	         for ( int i = 0; i < str.length(); ++i )
	         {
	             final char c = str.charAt( i );
	             if ( c <= '9' && c >= '0' )
	                 res = res * 10 + ( c - '0' );
	             else if ( c == '.' )
	             {
	                 //too lazy to write a proper Double parser, use JDK one
	                 try
	                 {
	                     final Double val = Double.valueOf( str );
	                     //check if value converted back to string equals to an original string
	                    // final String reverted = val.toString();
	                     type=4;
	                     return val;
	                    // if(reverted.equals( str )){
	                    //	 return str;
	                    // }else{
	                    	// return val;
	                    // }
	                     
	                   //  return (Double)( reverted.equals( str ) ? val : str);
	                 }
	                 catch ( NumberFormatException ex )
	                 {
	                     return str;
	                 }
	             }
	             else if ( c == '-' )
	             { // 0: int, 1: float, 2: decimal, 3: DataTime, 4: Double, 5: string, 6: Long, 7:boolean
	                 if ( i == 0 )
	                     sign = -1; //switch sign at first position
	                 else{
	                	 type=5;
	                     return str; //otherwise it is not numeric
	                 }
	             }
	             else if ( c == '+' )
	             {
	                 if ( i == 0 )
	                     sign = 1; //sign at first position
	                 else{
	                	 type =5;
	                     return str; //otherwise it is not numeric
	                 }
	             }
	             else {//non-numeric{
	            	 type=5;
	                 return str;
	             }
	         }
	         //cast to int if value is in int range
	         if ( res < Integer.MAX_VALUE ){
	             ///for int
	        	 type=0;
	             return ( int ) res * sign;
	             
	         }else{
	         //otherwise return Long
	            	 type=6;
	         return (long) res * Long.valueOf(sign);
	             }
	     }
	     
	     
	     
	     
	     
	     
	     
	     
	 	public String get_lang() {
	 		return _lang;
	 	}

	 	public void set_lang(String _lang) {
	 		this._lang = _lang;
	 	}

	 	public Resource get_dt() {
	 		return _dt;
	 	}

	 	public void set_dt(Resource _dt) {
	 		this._dt = _dt;
	 	}

	 	public int getType() {
	 		return type;
	 	}

	 	public void setType(int type) {
	 		this.type = type;
	 	}

	 	public Object getValue() {
	 		return value;
	 	}

	 	public void setValue(Object value) {
	 		this.value = value;
	 	}

}
