// Generated from NajaGrammar.g4 by ANTLR 4.3
package com.example.core.lib;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NajaGrammarParser}.
 */
public interface NajaGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NajaGrammarParser#exprl}.
	 * @param ctx the parse tree
	 */
	void enterExprl(@NotNull NajaGrammarParser.ExprlContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarParser#exprl}.
	 * @param ctx the parse tree
	 */
	void exitExprl(@NotNull NajaGrammarParser.ExprlContext ctx);

	/**
	 * Enter a parse tree produced by {@link NajaGrammarParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(@NotNull NajaGrammarParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(@NotNull NajaGrammarParser.TermoContext ctx);

	/**
	 * Enter a parse tree produced by {@link NajaGrammarParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(@NotNull NajaGrammarParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(@NotNull NajaGrammarParser.ProgramaContext ctx);

	/**
	 * Enter a parse tree produced by {@link NajaGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull NajaGrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull NajaGrammarParser.ExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link NajaGrammarParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaravar(@NotNull NajaGrammarParser.DeclaravarContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaravar(@NotNull NajaGrammarParser.DeclaravarContext ctx);
}