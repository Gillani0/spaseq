// Generated from StreamingSparql.g4 by ANTLR 4.3

    package edu.telecomstet.cep.query.sources;


import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link StreamingSparql}.
 */
public interface StreamingSparqlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link StreamingSparql#builtInCall}.
	 * @param ctx the parse tree
	 */
	void enterBuiltInCall(@NotNull StreamingSparql.BuiltInCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#builtInCall}.
	 * @param ctx the parse tree
	 */
	void exitBuiltInCall(@NotNull StreamingSparql.BuiltInCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#groupCondition}.
	 * @param ctx the parse tree
	 */
	void enterGroupCondition(@NotNull StreamingSparql.GroupConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#groupCondition}.
	 * @param ctx the parse tree
	 */
	void exitGroupCondition(@NotNull StreamingSparql.GroupConditionContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#pathAlternative}.
	 * @param ctx the parse tree
	 */
	void enterPathAlternative(@NotNull StreamingSparql.PathAlternativeContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#pathAlternative}.
	 * @param ctx the parse tree
	 */
	void exitPathAlternative(@NotNull StreamingSparql.PathAlternativeContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#groupGraphPattern}.
	 * @param ctx the parse tree
	 */
	void enterGroupGraphPattern(@NotNull StreamingSparql.GroupGraphPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#groupGraphPattern}.
	 * @param ctx the parse tree
	 */
	void exitGroupGraphPattern(@NotNull StreamingSparql.GroupGraphPatternContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#graphPatternNotTriples}.
	 * @param ctx the parse tree
	 */
	void enterGraphPatternNotTriples(@NotNull StreamingSparql.GraphPatternNotTriplesContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#graphPatternNotTriples}.
	 * @param ctx the parse tree
	 */
	void exitGraphPatternNotTriples(@NotNull StreamingSparql.GraphPatternNotTriplesContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#nil}.
	 * @param ctx the parse tree
	 */
	void enterNil(@NotNull StreamingSparql.NilContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#nil}.
	 * @param ctx the parse tree
	 */
	void exitNil(@NotNull StreamingSparql.NilContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(@NotNull StreamingSparql.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(@NotNull StreamingSparql.PathContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#bind}.
	 * @param ctx the parse tree
	 */
	void enterBind(@NotNull StreamingSparql.BindContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#bind}.
	 * @param ctx the parse tree
	 */
	void exitBind(@NotNull StreamingSparql.BindContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#deleteClause}.
	 * @param ctx the parse tree
	 */
	void enterDeleteClause(@NotNull StreamingSparql.DeleteClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#deleteClause}.
	 * @param ctx the parse tree
	 */
	void exitDeleteClause(@NotNull StreamingSparql.DeleteClauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#inlineDataFull}.
	 * @param ctx the parse tree
	 */
	void enterInlineDataFull(@NotNull StreamingSparql.InlineDataFullContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#inlineDataFull}.
	 * @param ctx the parse tree
	 */
	void exitInlineDataFull(@NotNull StreamingSparql.InlineDataFullContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#eofRule}.
	 * @param ctx the parse tree
	 */
	void enterEofRule(@NotNull StreamingSparql.EofRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#eofRule}.
	 * @param ctx the parse tree
	 */
	void exitEofRule(@NotNull StreamingSparql.EofRuleContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(@NotNull StreamingSparql.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(@NotNull StreamingSparql.UnaryExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#numericLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNumericLiteral(@NotNull StreamingSparql.NumericLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#numericLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNumericLiteral(@NotNull StreamingSparql.NumericLiteralContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#partitionbyClause}.
	 * @param ctx the parse tree
	 */
	void enterPartitionbyClause(@NotNull StreamingSparql.PartitionbyClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#partitionbyClause}.
	 * @param ctx the parse tree
	 */
	void exitPartitionbyClause(@NotNull StreamingSparql.PartitionbyClauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#inlineDataOneVar}.
	 * @param ctx the parse tree
	 */
	void enterInlineDataOneVar(@NotNull StreamingSparql.InlineDataOneVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#inlineDataOneVar}.
	 * @param ctx the parse tree
	 */
	void exitInlineDataOneVar(@NotNull StreamingSparql.InlineDataOneVarContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#quadsDetails}.
	 * @param ctx the parse tree
	 */
	void enterQuadsDetails(@NotNull StreamingSparql.QuadsDetailsContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#quadsDetails}.
	 * @param ctx the parse tree
	 */
	void exitQuadsDetails(@NotNull StreamingSparql.QuadsDetailsContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#optionalGraphPattern}.
	 * @param ctx the parse tree
	 */
	void enterOptionalGraphPattern(@NotNull StreamingSparql.OptionalGraphPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#optionalGraphPattern}.
	 * @param ctx the parse tree
	 */
	void exitOptionalGraphPattern(@NotNull StreamingSparql.OptionalGraphPatternContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#unaryLiteralExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryLiteralExpression(@NotNull StreamingSparql.UnaryLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#unaryLiteralExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryLiteralExpression(@NotNull StreamingSparql.UnaryLiteralExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#offsetClause}.
	 * @param ctx the parse tree
	 */
	void enterOffsetClause(@NotNull StreamingSparql.OffsetClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#offsetClause}.
	 * @param ctx the parse tree
	 */
	void exitOffsetClause(@NotNull StreamingSparql.OffsetClauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#constructTemplate}.
	 * @param ctx the parse tree
	 */
	void enterConstructTemplate(@NotNull StreamingSparql.ConstructTemplateContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#constructTemplate}.
	 * @param ctx the parse tree
	 */
	void exitConstructTemplate(@NotNull StreamingSparql.ConstructTemplateContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(@NotNull StreamingSparql.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(@NotNull StreamingSparql.VarContext ctx);

	/**
	 * Enter a parse tree produced by the {@code unaryAdditiveExpression}
	 * labeled alternative in {@link StreamingSparql#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryAdditiveExpression(@NotNull StreamingSparql.UnaryAdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryAdditiveExpression}
	 * labeled alternative in {@link StreamingSparql#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryAdditiveExpression(@NotNull StreamingSparql.UnaryAdditiveExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#verb}.
	 * @param ctx the parse tree
	 */
	void enterVerb(@NotNull StreamingSparql.VerbContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#verb}.
	 * @param ctx the parse tree
	 */
	void exitVerb(@NotNull StreamingSparql.VerbContext ctx);

	/**
	 * Enter a parse tree produced by the {@code baseExpression}
	 * labeled alternative in {@link StreamingSparql#expression}.
	 * @param ctx the parse tree
	 */
	void enterBaseExpression(@NotNull StreamingSparql.BaseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code baseExpression}
	 * labeled alternative in {@link StreamingSparql#expression}.
	 * @param ctx the parse tree
	 */
	void exitBaseExpression(@NotNull StreamingSparql.BaseExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#pathOneInPropertySet}.
	 * @param ctx the parse tree
	 */
	void enterPathOneInPropertySet(@NotNull StreamingSparql.PathOneInPropertySetContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#pathOneInPropertySet}.
	 * @param ctx the parse tree
	 */
	void exitPathOneInPropertySet(@NotNull StreamingSparql.PathOneInPropertySetContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#eventJoiner}.
	 * @param ctx the parse tree
	 */
	void enterEventJoiner(@NotNull StreamingSparql.EventJoinerContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#eventJoiner}.
	 * @param ctx the parse tree
	 */
	void exitEventJoiner(@NotNull StreamingSparql.EventJoinerContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#havingCondition}.
	 * @param ctx the parse tree
	 */
	void enterHavingCondition(@NotNull StreamingSparql.HavingConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#havingCondition}.
	 * @param ctx the parse tree
	 */
	void exitHavingCondition(@NotNull StreamingSparql.HavingConditionContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#quadPattern}.
	 * @param ctx the parse tree
	 */
	void enterQuadPattern(@NotNull StreamingSparql.QuadPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#quadPattern}.
	 * @param ctx the parse tree
	 */
	void exitQuadPattern(@NotNull StreamingSparql.QuadPatternContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#groupGraphPatternSubList}.
	 * @param ctx the parse tree
	 */
	void enterGroupGraphPatternSubList(@NotNull StreamingSparql.GroupGraphPatternSubListContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#groupGraphPatternSubList}.
	 * @param ctx the parse tree
	 */
	void exitGroupGraphPatternSubList(@NotNull StreamingSparql.GroupGraphPatternSubListContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(@NotNull StreamingSparql.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(@NotNull StreamingSparql.ExpressionListContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#seqConstraints}.
	 * @param ctx the parse tree
	 */
	void enterSeqConstraints(@NotNull StreamingSparql.SeqConstraintsContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#seqConstraints}.
	 * @param ctx the parse tree
	 */
	void exitSeqConstraints(@NotNull StreamingSparql.SeqConstraintsContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#orderClause}.
	 * @param ctx the parse tree
	 */
	void enterOrderClause(@NotNull StreamingSparql.OrderClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#orderClause}.
	 * @param ctx the parse tree
	 */
	void exitOrderClause(@NotNull StreamingSparql.OrderClauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(@NotNull StreamingSparql.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(@NotNull StreamingSparql.FunctionCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#updateCommand}.
	 * @param ctx the parse tree
	 */
	void enterUpdateCommand(@NotNull StreamingSparql.UpdateCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#updateCommand}.
	 * @param ctx the parse tree
	 */
	void exitUpdateCommand(@NotNull StreamingSparql.UpdateCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#regexExpression}.
	 * @param ctx the parse tree
	 */
	void enterRegexExpression(@NotNull StreamingSparql.RegexExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#regexExpression}.
	 * @param ctx the parse tree
	 */
	void exitRegexExpression(@NotNull StreamingSparql.RegexExpressionContext ctx);

	/**
	 * Enter a parse tree produced by the {@code unaryNegationExpression}
	 * labeled alternative in {@link StreamingSparql#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryNegationExpression(@NotNull StreamingSparql.UnaryNegationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryNegationExpression}
	 * labeled alternative in {@link StreamingSparql#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryNegationExpression(@NotNull StreamingSparql.UnaryNegationExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#selectQuery}.
	 * @param ctx the parse tree
	 */
	void enterSelectQuery(@NotNull StreamingSparql.SelectQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#selectQuery}.
	 * @param ctx the parse tree
	 */
	void exitSelectQuery(@NotNull StreamingSparql.SelectQueryContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#object}.
	 * @param ctx the parse tree
	 */
	void enterObject(@NotNull StreamingSparql.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#object}.
	 * @param ctx the parse tree
	 */
	void exitObject(@NotNull StreamingSparql.ObjectContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#eventDefinition}.
	 * @param ctx the parse tree
	 */
	void enterEventDefinition(@NotNull StreamingSparql.EventDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#eventDefinition}.
	 * @param ctx the parse tree
	 */
	void exitEventDefinition(@NotNull StreamingSparql.EventDefinitionContext ctx);

	/**
	 * Enter a parse tree produced by the {@code additiveExpression}
	 * labeled alternative in {@link StreamingSparql#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(@NotNull StreamingSparql.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additiveExpression}
	 * labeled alternative in {@link StreamingSparql#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(@NotNull StreamingSparql.AdditiveExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#dataBlockValue}.
	 * @param ctx the parse tree
	 */
	void enterDataBlockValue(@NotNull StreamingSparql.DataBlockValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#dataBlockValue}.
	 * @param ctx the parse tree
	 */
	void exitDataBlockValue(@NotNull StreamingSparql.DataBlockValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#propertyListPath}.
	 * @param ctx the parse tree
	 */
	void enterPropertyListPath(@NotNull StreamingSparql.PropertyListPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#propertyListPath}.
	 * @param ctx the parse tree
	 */
	void exitPropertyListPath(@NotNull StreamingSparql.PropertyListPathContext ctx);

	/**
	 * Enter a parse tree produced by the {@code relationalExpression}
	 * labeled alternative in {@link StreamingSparql#expression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(@NotNull StreamingSparql.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalExpression}
	 * labeled alternative in {@link StreamingSparql#expression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(@NotNull StreamingSparql.RelationalExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#baseDecl}.
	 * @param ctx the parse tree
	 */
	void enterBaseDecl(@NotNull StreamingSparql.BaseDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#baseDecl}.
	 * @param ctx the parse tree
	 */
	void exitBaseDecl(@NotNull StreamingSparql.BaseDeclContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#prefixDecl}.
	 * @param ctx the parse tree
	 */
	void enterPrefixDecl(@NotNull StreamingSparql.PrefixDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#prefixDecl}.
	 * @param ctx the parse tree
	 */
	void exitPrefixDecl(@NotNull StreamingSparql.PrefixDeclContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#datasetClause}.
	 * @param ctx the parse tree
	 */
	void enterDatasetClause(@NotNull StreamingSparql.DatasetClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#datasetClause}.
	 * @param ctx the parse tree
	 */
	void exitDatasetClause(@NotNull StreamingSparql.DatasetClauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#streamsetCaluse}.
	 * @param ctx the parse tree
	 */
	void enterStreamsetCaluse(@NotNull StreamingSparql.StreamsetCaluseContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#streamsetCaluse}.
	 * @param ctx the parse tree
	 */
	void exitStreamsetCaluse(@NotNull StreamingSparql.StreamsetCaluseContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#graphOrDefault}.
	 * @param ctx the parse tree
	 */
	void enterGraphOrDefault(@NotNull StreamingSparql.GraphOrDefaultContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#graphOrDefault}.
	 * @param ctx the parse tree
	 */
	void exitGraphOrDefault(@NotNull StreamingSparql.GraphOrDefaultContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#durantionClause}.
	 * @param ctx the parse tree
	 */
	void enterDurantionClause(@NotNull StreamingSparql.DurantionClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#durantionClause}.
	 * @param ctx the parse tree
	 */
	void exitDurantionClause(@NotNull StreamingSparql.DurantionClauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#pathMod}.
	 * @param ctx the parse tree
	 */
	void enterPathMod(@NotNull StreamingSparql.PathModContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#pathMod}.
	 * @param ctx the parse tree
	 */
	void exitPathMod(@NotNull StreamingSparql.PathModContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#propertyListPathNotEmptyList}.
	 * @param ctx the parse tree
	 */
	void enterPropertyListPathNotEmptyList(@NotNull StreamingSparql.PropertyListPathNotEmptyListContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#propertyListPathNotEmptyList}.
	 * @param ctx the parse tree
	 */
	void exitPropertyListPathNotEmptyList(@NotNull StreamingSparql.PropertyListPathNotEmptyListContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#deleteWhere}.
	 * @param ctx the parse tree
	 */
	void enterDeleteWhere(@NotNull StreamingSparql.DeleteWhereContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#deleteWhere}.
	 * @param ctx the parse tree
	 */
	void exitDeleteWhere(@NotNull StreamingSparql.DeleteWhereContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#numericLiteralNegative}.
	 * @param ctx the parse tree
	 */
	void enterNumericLiteralNegative(@NotNull StreamingSparql.NumericLiteralNegativeContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#numericLiteralNegative}.
	 * @param ctx the parse tree
	 */
	void exitNumericLiteralNegative(@NotNull StreamingSparql.NumericLiteralNegativeContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#partition}.
	 * @param ctx the parse tree
	 */
	void enterPartition(@NotNull StreamingSparql.PartitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#partition}.
	 * @param ctx the parse tree
	 */
	void exitPartition(@NotNull StreamingSparql.PartitionContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#selectClause}.
	 * @param ctx the parse tree
	 */
	void enterSelectClause(@NotNull StreamingSparql.SelectClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#selectClause}.
	 * @param ctx the parse tree
	 */
	void exitSelectClause(@NotNull StreamingSparql.SelectClauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#quadData}.
	 * @param ctx the parse tree
	 */
	void enterQuadData(@NotNull StreamingSparql.QuadDataContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#quadData}.
	 * @param ctx the parse tree
	 */
	void exitQuadData(@NotNull StreamingSparql.QuadDataContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#varOrTerm}.
	 * @param ctx the parse tree
	 */
	void enterVarOrTerm(@NotNull StreamingSparql.VarOrTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#varOrTerm}.
	 * @param ctx the parse tree
	 */
	void exitVarOrTerm(@NotNull StreamingSparql.VarOrTermContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#verbPath}.
	 * @param ctx the parse tree
	 */
	void enterVerbPath(@NotNull StreamingSparql.VerbPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#verbPath}.
	 * @param ctx the parse tree
	 */
	void exitVerbPath(@NotNull StreamingSparql.VerbPathContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#groupGraphPatternSub}.
	 * @param ctx the parse tree
	 */
	void enterGroupGraphPatternSub(@NotNull StreamingSparql.GroupGraphPatternSubContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#groupGraphPatternSub}.
	 * @param ctx the parse tree
	 */
	void exitGroupGraphPatternSub(@NotNull StreamingSparql.GroupGraphPatternSubContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#eventPattList}.
	 * @param ctx the parse tree
	 */
	void enterEventPattList(@NotNull StreamingSparql.EventPattListContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#eventPattList}.
	 * @param ctx the parse tree
	 */
	void exitEventPattList(@NotNull StreamingSparql.EventPattListContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#copy}.
	 * @param ctx the parse tree
	 */
	void enterCopy(@NotNull StreamingSparql.CopyContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#copy}.
	 * @param ctx the parse tree
	 */
	void exitCopy(@NotNull StreamingSparql.CopyContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#blankNode}.
	 * @param ctx the parse tree
	 */
	void enterBlankNode(@NotNull StreamingSparql.BlankNodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#blankNode}.
	 * @param ctx the parse tree
	 */
	void exitBlankNode(@NotNull StreamingSparql.BlankNodeContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(@NotNull StreamingSparql.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(@NotNull StreamingSparql.PrimaryExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#iri}.
	 * @param ctx the parse tree
	 */
	void enterIri(@NotNull StreamingSparql.IriContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#iri}.
	 * @param ctx the parse tree
	 */
	void exitIri(@NotNull StreamingSparql.IriContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#havingClause}.
	 * @param ctx the parse tree
	 */
	void enterHavingClause(@NotNull StreamingSparql.HavingClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#havingClause}.
	 * @param ctx the parse tree
	 */
	void exitHavingClause(@NotNull StreamingSparql.HavingClauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#multipleVars}.
	 * @param ctx the parse tree
	 */
	void enterMultipleVars(@NotNull StreamingSparql.MultipleVarsContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#multipleVars}.
	 * @param ctx the parse tree
	 */
	void exitMultipleVars(@NotNull StreamingSparql.MultipleVarsContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#quads}.
	 * @param ctx the parse tree
	 */
	void enterQuads(@NotNull StreamingSparql.QuadsContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#quads}.
	 * @param ctx the parse tree
	 */
	void exitQuads(@NotNull StreamingSparql.QuadsContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#collectionPath}.
	 * @param ctx the parse tree
	 */
	void enterCollectionPath(@NotNull StreamingSparql.CollectionPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#collectionPath}.
	 * @param ctx the parse tree
	 */
	void exitCollectionPath(@NotNull StreamingSparql.CollectionPathContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#within}.
	 * @param ctx the parse tree
	 */
	void enterWithin(@NotNull StreamingSparql.WithinContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#within}.
	 * @param ctx the parse tree
	 */
	void exitWithin(@NotNull StreamingSparql.WithinContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#graphRef}.
	 * @param ctx the parse tree
	 */
	void enterGraphRef(@NotNull StreamingSparql.GraphRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#graphRef}.
	 * @param ctx the parse tree
	 */
	void exitGraphRef(@NotNull StreamingSparql.GraphRefContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#propertyList}.
	 * @param ctx the parse tree
	 */
	void enterPropertyList(@NotNull StreamingSparql.PropertyListContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#propertyList}.
	 * @param ctx the parse tree
	 */
	void exitPropertyList(@NotNull StreamingSparql.PropertyListContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#pathNegatedPropertySet}.
	 * @param ctx the parse tree
	 */
	void enterPathNegatedPropertySet(@NotNull StreamingSparql.PathNegatedPropertySetContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#pathNegatedPropertySet}.
	 * @param ctx the parse tree
	 */
	void exitPathNegatedPropertySet(@NotNull StreamingSparql.PathNegatedPropertySetContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#patternOperation}.
	 * @param ctx the parse tree
	 */
	void enterPatternOperation(@NotNull StreamingSparql.PatternOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#patternOperation}.
	 * @param ctx the parse tree
	 */
	void exitPatternOperation(@NotNull StreamingSparql.PatternOperationContext ctx);

	/**
	 * Enter a parse tree produced by the {@code multiplicativeExpression}
	 * labeled alternative in {@link StreamingSparql#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(@NotNull StreamingSparql.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicativeExpression}
	 * labeled alternative in {@link StreamingSparql#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(@NotNull StreamingSparql.MultiplicativeExpressionContext ctx);

	/**
	 * Enter a parse tree produced by the {@code conditionalAndExpression}
	 * labeled alternative in {@link StreamingSparql#expression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalAndExpression(@NotNull StreamingSparql.ConditionalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionalAndExpression}
	 * labeled alternative in {@link StreamingSparql#expression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalAndExpression(@NotNull StreamingSparql.ConditionalAndExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#serviceGraphPattern}.
	 * @param ctx the parse tree
	 */
	void enterServiceGraphPattern(@NotNull StreamingSparql.ServiceGraphPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#serviceGraphPattern}.
	 * @param ctx the parse tree
	 */
	void exitServiceGraphPattern(@NotNull StreamingSparql.ServiceGraphPatternContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#eventPattern}.
	 * @param ctx the parse tree
	 */
	void enterEventPattern(@NotNull StreamingSparql.EventPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#eventPattern}.
	 * @param ctx the parse tree
	 */
	void exitEventPattern(@NotNull StreamingSparql.EventPatternContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#verbSimple}.
	 * @param ctx the parse tree
	 */
	void enterVerbSimple(@NotNull StreamingSparql.VerbSimpleContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#verbSimple}.
	 * @param ctx the parse tree
	 */
	void exitVerbSimple(@NotNull StreamingSparql.VerbSimpleContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#filter}.
	 * @param ctx the parse tree
	 */
	void enterFilter(@NotNull StreamingSparql.FilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#filter}.
	 * @param ctx the parse tree
	 */
	void exitFilter(@NotNull StreamingSparql.FilterContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#subSelect}.
	 * @param ctx the parse tree
	 */
	void enterSubSelect(@NotNull StreamingSparql.SubSelectContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#subSelect}.
	 * @param ctx the parse tree
	 */
	void exitSubSelect(@NotNull StreamingSparql.SubSelectContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#selectVariables}.
	 * @param ctx the parse tree
	 */
	void enterSelectVariables(@NotNull StreamingSparql.SelectVariablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#selectVariables}.
	 * @param ctx the parse tree
	 */
	void exitSelectVariables(@NotNull StreamingSparql.SelectVariablesContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#subStringExpression}.
	 * @param ctx the parse tree
	 */
	void enterSubStringExpression(@NotNull StreamingSparql.SubStringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#subStringExpression}.
	 * @param ctx the parse tree
	 */
	void exitSubStringExpression(@NotNull StreamingSparql.SubStringExpressionContext ctx);

	/**
	 * Enter a parse tree produced by the {@code relationalSetExpression}
	 * labeled alternative in {@link StreamingSparql#expression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalSetExpression(@NotNull StreamingSparql.RelationalSetExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalSetExpression}
	 * labeled alternative in {@link StreamingSparql#expression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalSetExpression(@NotNull StreamingSparql.RelationalSetExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#graphNode}.
	 * @param ctx the parse tree
	 */
	void enterGraphNode(@NotNull StreamingSparql.GraphNodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#graphNode}.
	 * @param ctx the parse tree
	 */
	void exitGraphNode(@NotNull StreamingSparql.GraphNodeContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#constraint}.
	 * @param ctx the parse tree
	 */
	void enterConstraint(@NotNull StreamingSparql.ConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#constraint}.
	 * @param ctx the parse tree
	 */
	void exitConstraint(@NotNull StreamingSparql.ConstraintContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#numericLiteralUnsigned}.
	 * @param ctx the parse tree
	 */
	void enterNumericLiteralUnsigned(@NotNull StreamingSparql.NumericLiteralUnsignedContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#numericLiteralUnsigned}.
	 * @param ctx the parse tree
	 */
	void exitNumericLiteralUnsigned(@NotNull StreamingSparql.NumericLiteralUnsignedContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#usingClause}.
	 * @param ctx the parse tree
	 */
	void enterUsingClause(@NotNull StreamingSparql.UsingClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#usingClause}.
	 * @param ctx the parse tree
	 */
	void exitUsingClause(@NotNull StreamingSparql.UsingClauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#pattBlock}.
	 * @param ctx the parse tree
	 */
	void enterPattBlock(@NotNull StreamingSparql.PattBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#pattBlock}.
	 * @param ctx the parse tree
	 */
	void exitPattBlock(@NotNull StreamingSparql.PattBlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(@NotNull StreamingSparql.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(@NotNull StreamingSparql.ArgListContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#triplesTemplate}.
	 * @param ctx the parse tree
	 */
	void enterTriplesTemplate(@NotNull StreamingSparql.TriplesTemplateContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#triplesTemplate}.
	 * @param ctx the parse tree
	 */
	void exitTriplesTemplate(@NotNull StreamingSparql.TriplesTemplateContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(@NotNull StreamingSparql.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(@NotNull StreamingSparql.WhereClauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#propertyListPathNotEmpty}.
	 * @param ctx the parse tree
	 */
	void enterPropertyListPathNotEmpty(@NotNull StreamingSparql.PropertyListPathNotEmptyContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#propertyListPathNotEmpty}.
	 * @param ctx the parse tree
	 */
	void exitPropertyListPathNotEmpty(@NotNull StreamingSparql.PropertyListPathNotEmptyContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#blankNodePropertyListPath}.
	 * @param ctx the parse tree
	 */
	void enterBlankNodePropertyListPath(@NotNull StreamingSparql.BlankNodePropertyListPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#blankNodePropertyListPath}.
	 * @param ctx the parse tree
	 */
	void exitBlankNodePropertyListPath(@NotNull StreamingSparql.BlankNodePropertyListPathContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#graphNodePath}.
	 * @param ctx the parse tree
	 */
	void enterGraphNodePath(@NotNull StreamingSparql.GraphNodePathContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#graphNodePath}.
	 * @param ctx the parse tree
	 */
	void exitGraphNodePath(@NotNull StreamingSparql.GraphNodePathContext ctx);

	/**
	 * Enter a parse tree produced by the {@code unaryMultiplicativeExpression}
	 * labeled alternative in {@link StreamingSparql#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMultiplicativeExpression(@NotNull StreamingSparql.UnaryMultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMultiplicativeExpression}
	 * labeled alternative in {@link StreamingSparql#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMultiplicativeExpression(@NotNull StreamingSparql.UnaryMultiplicativeExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(@NotNull StreamingSparql.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(@NotNull StreamingSparql.IntegerContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#varOrIRI}.
	 * @param ctx the parse tree
	 */
	void enterVarOrIRI(@NotNull StreamingSparql.VarOrIRIContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#varOrIRI}.
	 * @param ctx the parse tree
	 */
	void exitVarOrIRI(@NotNull StreamingSparql.VarOrIRIContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#insertData}.
	 * @param ctx the parse tree
	 */
	void enterInsertData(@NotNull StreamingSparql.InsertDataContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#insertData}.
	 * @param ctx the parse tree
	 */
	void exitInsertData(@NotNull StreamingSparql.InsertDataContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#quadsNotTriples}.
	 * @param ctx the parse tree
	 */
	void enterQuadsNotTriples(@NotNull StreamingSparql.QuadsNotTriplesContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#quadsNotTriples}.
	 * @param ctx the parse tree
	 */
	void exitQuadsNotTriples(@NotNull StreamingSparql.QuadsNotTriplesContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#objectPath}.
	 * @param ctx the parse tree
	 */
	void enterObjectPath(@NotNull StreamingSparql.ObjectPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#objectPath}.
	 * @param ctx the parse tree
	 */
	void exitObjectPath(@NotNull StreamingSparql.ObjectPathContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#limitOffsetClauses}.
	 * @param ctx the parse tree
	 */
	void enterLimitOffsetClauses(@NotNull StreamingSparql.LimitOffsetClausesContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#limitOffsetClauses}.
	 * @param ctx the parse tree
	 */
	void exitLimitOffsetClauses(@NotNull StreamingSparql.LimitOffsetClausesContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#blankNodePropertyList}.
	 * @param ctx the parse tree
	 */
	void enterBlankNodePropertyList(@NotNull StreamingSparql.BlankNodePropertyListContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#blankNodePropertyList}.
	 * @param ctx the parse tree
	 */
	void exitBlankNodePropertyList(@NotNull StreamingSparql.BlankNodePropertyListContext ctx);

	/**
	 * Enter a parse tree produced by the {@code conditionalOrExpression}
	 * labeled alternative in {@link StreamingSparql#expression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalOrExpression(@NotNull StreamingSparql.ConditionalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionalOrExpression}
	 * labeled alternative in {@link StreamingSparql#expression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalOrExpression(@NotNull StreamingSparql.ConditionalOrExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#create}.
	 * @param ctx the parse tree
	 */
	void enterCreate(@NotNull StreamingSparql.CreateContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#create}.
	 * @param ctx the parse tree
	 */
	void exitCreate(@NotNull StreamingSparql.CreateContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#pathElt}.
	 * @param ctx the parse tree
	 */
	void enterPathElt(@NotNull StreamingSparql.PathEltContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#pathElt}.
	 * @param ctx the parse tree
	 */
	void exitPathElt(@NotNull StreamingSparql.PathEltContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#triplesNodePath}.
	 * @param ctx the parse tree
	 */
	void enterTriplesNodePath(@NotNull StreamingSparql.TriplesNodePathContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#triplesNodePath}.
	 * @param ctx the parse tree
	 */
	void exitTriplesNodePath(@NotNull StreamingSparql.TriplesNodePathContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(@NotNull StreamingSparql.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(@NotNull StreamingSparql.BooleanLiteralContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#orderCondition}.
	 * @param ctx the parse tree
	 */
	void enterOrderCondition(@NotNull StreamingSparql.OrderConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#orderCondition}.
	 * @param ctx the parse tree
	 */
	void exitOrderCondition(@NotNull StreamingSparql.OrderConditionContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#eventSelection}.
	 * @param ctx the parse tree
	 */
	void enterEventSelection(@NotNull StreamingSparql.EventSelectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#eventSelection}.
	 * @param ctx the parse tree
	 */
	void exitEventSelection(@NotNull StreamingSparql.EventSelectionContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(@NotNull StreamingSparql.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(@NotNull StreamingSparql.AddContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#dataBlockValues}.
	 * @param ctx the parse tree
	 */
	void enterDataBlockValues(@NotNull StreamingSparql.DataBlockValuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#dataBlockValues}.
	 * @param ctx the parse tree
	 */
	void exitDataBlockValues(@NotNull StreamingSparql.DataBlockValuesContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#graphRefAll}.
	 * @param ctx the parse tree
	 */
	void enterGraphRefAll(@NotNull StreamingSparql.GraphRefAllContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#graphRefAll}.
	 * @param ctx the parse tree
	 */
	void exitGraphRefAll(@NotNull StreamingSparql.GraphRefAllContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#solutionModifier}.
	 * @param ctx the parse tree
	 */
	void enterSolutionModifier(@NotNull StreamingSparql.SolutionModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#solutionModifier}.
	 * @param ctx the parse tree
	 */
	void exitSolutionModifier(@NotNull StreamingSparql.SolutionModifierContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#insertClause}.
	 * @param ctx the parse tree
	 */
	void enterInsertClause(@NotNull StreamingSparql.InsertClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#insertClause}.
	 * @param ctx the parse tree
	 */
	void exitInsertClause(@NotNull StreamingSparql.InsertClauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#pathEltOrInverse}.
	 * @param ctx the parse tree
	 */
	void enterPathEltOrInverse(@NotNull StreamingSparql.PathEltOrInverseContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#pathEltOrInverse}.
	 * @param ctx the parse tree
	 */
	void exitPathEltOrInverse(@NotNull StreamingSparql.PathEltOrInverseContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#notExistsFunction}.
	 * @param ctx the parse tree
	 */
	void enterNotExistsFunction(@NotNull StreamingSparql.NotExistsFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#notExistsFunction}.
	 * @param ctx the parse tree
	 */
	void exitNotExistsFunction(@NotNull StreamingSparql.NotExistsFunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(@NotNull StreamingSparql.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(@NotNull StreamingSparql.QueryContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#triplesSameSubject}.
	 * @param ctx the parse tree
	 */
	void enterTriplesSameSubject(@NotNull StreamingSparql.TriplesSameSubjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#triplesSameSubject}.
	 * @param ctx the parse tree
	 */
	void exitTriplesSameSubject(@NotNull StreamingSparql.TriplesSameSubjectContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#triplesNode}.
	 * @param ctx the parse tree
	 */
	void enterTriplesNode(@NotNull StreamingSparql.TriplesNodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#triplesNode}.
	 * @param ctx the parse tree
	 */
	void exitTriplesNode(@NotNull StreamingSparql.TriplesNodeContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#collection}.
	 * @param ctx the parse tree
	 */
	void enterCollection(@NotNull StreamingSparql.CollectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#collection}.
	 * @param ctx the parse tree
	 */
	void exitCollection(@NotNull StreamingSparql.CollectionContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#triplesSameSubjectPath}.
	 * @param ctx the parse tree
	 */
	void enterTriplesSameSubjectPath(@NotNull StreamingSparql.TriplesSameSubjectPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#triplesSameSubjectPath}.
	 * @param ctx the parse tree
	 */
	void exitTriplesSameSubjectPath(@NotNull StreamingSparql.TriplesSameSubjectPathContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#constructClause}.
	 * @param ctx the parse tree
	 */
	void enterConstructClause(@NotNull StreamingSparql.ConstructClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#constructClause}.
	 * @param ctx the parse tree
	 */
	void exitConstructClause(@NotNull StreamingSparql.ConstructClauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#groupClause}.
	 * @param ctx the parse tree
	 */
	void enterGroupClause(@NotNull StreamingSparql.GroupClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#groupClause}.
	 * @param ctx the parse tree
	 */
	void exitGroupClause(@NotNull StreamingSparql.GroupClauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#valuesClause}.
	 * @param ctx the parse tree
	 */
	void enterValuesClause(@NotNull StreamingSparql.ValuesClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#valuesClause}.
	 * @param ctx the parse tree
	 */
	void exitValuesClause(@NotNull StreamingSparql.ValuesClauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#iriRefOrFunction}.
	 * @param ctx the parse tree
	 */
	void enterIriRefOrFunction(@NotNull StreamingSparql.IriRefOrFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#iriRefOrFunction}.
	 * @param ctx the parse tree
	 */
	void exitIriRefOrFunction(@NotNull StreamingSparql.IriRefOrFunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#propertyListNotEmpty}.
	 * @param ctx the parse tree
	 */
	void enterPropertyListNotEmpty(@NotNull StreamingSparql.PropertyListNotEmptyContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#propertyListNotEmpty}.
	 * @param ctx the parse tree
	 */
	void exitPropertyListNotEmpty(@NotNull StreamingSparql.PropertyListNotEmptyContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#dataBlock}.
	 * @param ctx the parse tree
	 */
	void enterDataBlock(@NotNull StreamingSparql.DataBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#dataBlock}.
	 * @param ctx the parse tree
	 */
	void exitDataBlock(@NotNull StreamingSparql.DataBlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#pathSequence}.
	 * @param ctx the parse tree
	 */
	void enterPathSequence(@NotNull StreamingSparql.PathSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#pathSequence}.
	 * @param ctx the parse tree
	 */
	void exitPathSequence(@NotNull StreamingSparql.PathSequenceContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#inlineData}.
	 * @param ctx the parse tree
	 */
	void enterInlineData(@NotNull StreamingSparql.InlineDataContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#inlineData}.
	 * @param ctx the parse tree
	 */
	void exitInlineData(@NotNull StreamingSparql.InlineDataContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#drop}.
	 * @param ctx the parse tree
	 */
	void enterDrop(@NotNull StreamingSparql.DropContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#drop}.
	 * @param ctx the parse tree
	 */
	void exitDrop(@NotNull StreamingSparql.DropContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#string}.
	 * @param ctx the parse tree
	 */
	void enterString(@NotNull StreamingSparql.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#string}.
	 * @param ctx the parse tree
	 */
	void exitString(@NotNull StreamingSparql.StringContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#constructQuery}.
	 * @param ctx the parse tree
	 */
	void enterConstructQuery(@NotNull StreamingSparql.ConstructQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#constructQuery}.
	 * @param ctx the parse tree
	 */
	void exitConstructQuery(@NotNull StreamingSparql.ConstructQueryContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#groupOrUnionGraphPattern}.
	 * @param ctx the parse tree
	 */
	void enterGroupOrUnionGraphPattern(@NotNull StreamingSparql.GroupOrUnionGraphPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#groupOrUnionGraphPattern}.
	 * @param ctx the parse tree
	 */
	void exitGroupOrUnionGraphPattern(@NotNull StreamingSparql.GroupOrUnionGraphPatternContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#eventUnionOrPattern}.
	 * @param ctx the parse tree
	 */
	void enterEventUnionOrPattern(@NotNull StreamingSparql.EventUnionOrPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#eventUnionOrPattern}.
	 * @param ctx the parse tree
	 */
	void exitEventUnionOrPattern(@NotNull StreamingSparql.EventUnionOrPatternContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#prefixedName}.
	 * @param ctx the parse tree
	 */
	void enterPrefixedName(@NotNull StreamingSparql.PrefixedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#prefixedName}.
	 * @param ctx the parse tree
	 */
	void exitPrefixedName(@NotNull StreamingSparql.PrefixedNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#update}.
	 * @param ctx the parse tree
	 */
	void enterUpdate(@NotNull StreamingSparql.UpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#update}.
	 * @param ctx the parse tree
	 */
	void exitUpdate(@NotNull StreamingSparql.UpdateContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#pathPrimary}.
	 * @param ctx the parse tree
	 */
	void enterPathPrimary(@NotNull StreamingSparql.PathPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#pathPrimary}.
	 * @param ctx the parse tree
	 */
	void exitPathPrimary(@NotNull StreamingSparql.PathPrimaryContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#seqBlock}.
	 * @param ctx the parse tree
	 */
	void enterSeqBlock(@NotNull StreamingSparql.SeqBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#seqBlock}.
	 * @param ctx the parse tree
	 */
	void exitSeqBlock(@NotNull StreamingSparql.SeqBlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#askQuery}.
	 * @param ctx the parse tree
	 */
	void enterAskQuery(@NotNull StreamingSparql.AskQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#askQuery}.
	 * @param ctx the parse tree
	 */
	void exitAskQuery(@NotNull StreamingSparql.AskQueryContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#graphGraphPattern}.
	 * @param ctx the parse tree
	 */
	void enterGraphGraphPattern(@NotNull StreamingSparql.GraphGraphPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#graphGraphPattern}.
	 * @param ctx the parse tree
	 */
	void exitGraphGraphPattern(@NotNull StreamingSparql.GraphGraphPatternContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#aggregate}.
	 * @param ctx the parse tree
	 */
	void enterAggregate(@NotNull StreamingSparql.AggregateContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#aggregate}.
	 * @param ctx the parse tree
	 */
	void exitAggregate(@NotNull StreamingSparql.AggregateContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#objectListPath}.
	 * @param ctx the parse tree
	 */
	void enterObjectListPath(@NotNull StreamingSparql.ObjectListPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#objectListPath}.
	 * @param ctx the parse tree
	 */
	void exitObjectListPath(@NotNull StreamingSparql.ObjectListPathContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#graphTerm}.
	 * @param ctx the parse tree
	 */
	void enterGraphTerm(@NotNull StreamingSparql.GraphTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#graphTerm}.
	 * @param ctx the parse tree
	 */
	void exitGraphTerm(@NotNull StreamingSparql.GraphTermContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#deleteData}.
	 * @param ctx the parse tree
	 */
	void enterDeleteData(@NotNull StreamingSparql.DeleteDataContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#deleteData}.
	 * @param ctx the parse tree
	 */
	void exitDeleteData(@NotNull StreamingSparql.DeleteDataContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#load}.
	 * @param ctx the parse tree
	 */
	void enterLoad(@NotNull StreamingSparql.LoadContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#load}.
	 * @param ctx the parse tree
	 */
	void exitLoad(@NotNull StreamingSparql.LoadContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#constructTriples}.
	 * @param ctx the parse tree
	 */
	void enterConstructTriples(@NotNull StreamingSparql.ConstructTriplesContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#constructTriples}.
	 * @param ctx the parse tree
	 */
	void exitConstructTriples(@NotNull StreamingSparql.ConstructTriplesContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#describeQuery}.
	 * @param ctx the parse tree
	 */
	void enterDescribeQuery(@NotNull StreamingSparql.DescribeQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#describeQuery}.
	 * @param ctx the parse tree
	 */
	void exitDescribeQuery(@NotNull StreamingSparql.DescribeQueryContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#var3}.
	 * @param ctx the parse tree
	 */
	void enterVar3(@NotNull StreamingSparql.Var3Context ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#var3}.
	 * @param ctx the parse tree
	 */
	void exitVar3(@NotNull StreamingSparql.Var3Context ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#rdfLiteral}.
	 * @param ctx the parse tree
	 */
	void enterRdfLiteral(@NotNull StreamingSparql.RdfLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#rdfLiteral}.
	 * @param ctx the parse tree
	 */
	void exitRdfLiteral(@NotNull StreamingSparql.RdfLiteralContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#prologue}.
	 * @param ctx the parse tree
	 */
	void enterPrologue(@NotNull StreamingSparql.PrologueContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#prologue}.
	 * @param ctx the parse tree
	 */
	void exitPrologue(@NotNull StreamingSparql.PrologueContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#anon}.
	 * @param ctx the parse tree
	 */
	void enterAnon(@NotNull StreamingSparql.AnonContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#anon}.
	 * @param ctx the parse tree
	 */
	void exitAnon(@NotNull StreamingSparql.AnonContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#move}.
	 * @param ctx the parse tree
	 */
	void enterMove(@NotNull StreamingSparql.MoveContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#move}.
	 * @param ctx the parse tree
	 */
	void exitMove(@NotNull StreamingSparql.MoveContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#minusGraphPattern}.
	 * @param ctx the parse tree
	 */
	void enterMinusGraphPattern(@NotNull StreamingSparql.MinusGraphPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#minusGraphPattern}.
	 * @param ctx the parse tree
	 */
	void exitMinusGraphPattern(@NotNull StreamingSparql.MinusGraphPatternContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#existsFunction}.
	 * @param ctx the parse tree
	 */
	void enterExistsFunction(@NotNull StreamingSparql.ExistsFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#existsFunction}.
	 * @param ctx the parse tree
	 */
	void exitExistsFunction(@NotNull StreamingSparql.ExistsFunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#clear}.
	 * @param ctx the parse tree
	 */
	void enterClear(@NotNull StreamingSparql.ClearContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#clear}.
	 * @param ctx the parse tree
	 */
	void exitClear(@NotNull StreamingSparql.ClearContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#numericLiteralPositive}.
	 * @param ctx the parse tree
	 */
	void enterNumericLiteralPositive(@NotNull StreamingSparql.NumericLiteralPositiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#numericLiteralPositive}.
	 * @param ctx the parse tree
	 */
	void exitNumericLiteralPositive(@NotNull StreamingSparql.NumericLiteralPositiveContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#limitClause}.
	 * @param ctx the parse tree
	 */
	void enterLimitClause(@NotNull StreamingSparql.LimitClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#limitClause}.
	 * @param ctx the parse tree
	 */
	void exitLimitClause(@NotNull StreamingSparql.LimitClauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#objectList}.
	 * @param ctx the parse tree
	 */
	void enterObjectList(@NotNull StreamingSparql.ObjectListContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#objectList}.
	 * @param ctx the parse tree
	 */
	void exitObjectList(@NotNull StreamingSparql.ObjectListContext ctx);

	/**
	 * Enter a parse tree produced by the {@code unarySignedLiteralExpression}
	 * labeled alternative in {@link StreamingSparql#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnarySignedLiteralExpression(@NotNull StreamingSparql.UnarySignedLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unarySignedLiteralExpression}
	 * labeled alternative in {@link StreamingSparql#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnarySignedLiteralExpression(@NotNull StreamingSparql.UnarySignedLiteralExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#modify}.
	 * @param ctx the parse tree
	 */
	void enterModify(@NotNull StreamingSparql.ModifyContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#modify}.
	 * @param ctx the parse tree
	 */
	void exitModify(@NotNull StreamingSparql.ModifyContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#triplesBlock}.
	 * @param ctx the parse tree
	 */
	void enterTriplesBlock(@NotNull StreamingSparql.TriplesBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#triplesBlock}.
	 * @param ctx the parse tree
	 */
	void exitTriplesBlock(@NotNull StreamingSparql.TriplesBlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#strReplaceExpression}.
	 * @param ctx the parse tree
	 */
	void enterStrReplaceExpression(@NotNull StreamingSparql.StrReplaceExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#strReplaceExpression}.
	 * @param ctx the parse tree
	 */
	void exitStrReplaceExpression(@NotNull StreamingSparql.StrReplaceExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#window}.
	 * @param ctx the parse tree
	 */
	void enterWindow(@NotNull StreamingSparql.WindowContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#window}.
	 * @param ctx the parse tree
	 */
	void exitWindow(@NotNull StreamingSparql.WindowContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#time}.
	 * @param ctx the parse tree
	 */
	void enterTime(@NotNull StreamingSparql.TimeContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#time}.
	 * @param ctx the parse tree
	 */
	void exitTime(@NotNull StreamingSparql.TimeContext ctx);

	/**
	 * Enter a parse tree produced by {@link StreamingSparql#unitTime}.
	 * @param ctx the parse tree
	 */
	void enterUnitTime(@NotNull StreamingSparql.UnitTimeContext ctx);
	/**
	 * Exit a parse tree produced by {@link StreamingSparql#unitTime}.
	 * @param ctx the parse tree
	 */
	void exitUnitTime(@NotNull StreamingSparql.UnitTimeContext ctx);
}