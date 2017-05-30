/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.telecomstet.cep.utils;


import org.semanticweb.yars.nx.Literal;

/**
 *
 * @author sydgillani
 */
public interface LiteralComparison {
   //  public boolean literalTypeChecker(DictionaryImpl dic,Multimap<Literal,Resource> table,Long inputVal,String filterOperand);
     public boolean evaluateInteger(Literal objLiteral,Literal obj2Literal,String filterOperand);
     public boolean evaluateDateTime(Literal objLiteral,Literal obj2Literal,String filterOperand);
        public boolean evaluateDouble(Literal objLiteral,Literal obj2Literal,String filterOperand);
     public boolean evaluateFloat(Literal objLiteral,Literal obj2Literal,String filterOperand);
     public boolean evaluateLong(Literal objLiteral,Literal obj2Literal,String filterOperand);
   //   public boolean evaluateDecimal(Literal objLiteral,Literal obj2Literal,String filterOprd);
          public boolean evaluateEventType(Literal objLiteral,Literal obj2Literal,String filterOprd,int type, int order);
   //  public boolean evaluteSimpleInteger(Literal objLiteral,Literal obj2Literal,String filterOperand);
    // public boolean evaluteSimpleDateTime(Literal objLiteral,Literal obj2Literal,String filterOperand);
     // public boolean evaluteSimpleFloat(Literal objLiteral,Literal obj2Literal,String filterOperand);
      // public boolean evaluteSimpleLong(Literal objLiteral,Literal obj2Literal,String filterOperand);
     
   //   public boolean simpleLiteralTypeCheck(Rule r,RDFStatement e);
     
  
       // public Rule literalFilterType2Checker(Rule r, RuleJoins rulejoin);
     //   public Rule literalKBChecker(Multimap<Literal,Resource> _kbtable, RuleJoins rulejoin);
         // public boolean literalFilterTypeChecker(Multimap<Literal,Resource> table,Literal inputVal,String filterOpr );
          // public boolean evaluateDecimal(Literal objLiteral,Multimap<Literal, Resource> tableComp,String filterOprd);
}
