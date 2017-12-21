/*
 * @(#)QueryParser.java   14/10/14
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
package edu.telecomstet.cep.query.parser;

//~--- non-JDK imports --------------------------------------------------------


import edu.telecomstet.cep.dictionary.optimised.DictionaryOpImpl;
import edu.telecomstet.cep.query.helpers.QueryDescriptor;
import edu.telecomstet.cep.query.sources.SparqlLexer;
import edu.telecomstet.cep.query.sources.StreamingSparql;
import java.io.FileNotFoundException;
import java.text.ParseException;
import javax.xml.datatype.DatatypeConfigurationException;
//import org.antlr.runtime.RecognitionException;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 *
 * @author sydgillani
 */
public interface QueryParser
 {
    public static QueryDescriptor parse(String query, DictionaryOpImpl dict, String kbFile)
            throws  ParseException, DatatypeConfigurationException, FileNotFoundException {
        SparqlLexer       lexer       = new SparqlLexer(new ANTLRInputStream(query));
        CommonTokenStream tokens      = new CommonTokenStream(lexer);
        StreamingSparql   parser      = new StreamingSparql(tokens);
        QueryHelperImpl   queryHelper = new QueryHelperImpl(parser, dict, kbFile);

        return queryHelper.queryDescriptor();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
