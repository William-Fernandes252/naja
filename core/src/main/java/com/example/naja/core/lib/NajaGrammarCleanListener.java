// Generated from NajaGrammarClean.g4 by ANTLR 4.13.2
package com.example.naja.core.lib;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NajaGrammarCleanParser}.
 */
public interface NajaGrammarCleanListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NajaGrammarCleanParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(NajaGrammarCleanParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarCleanParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(NajaGrammarCleanParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link NajaGrammarCleanParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaravar(NajaGrammarCleanParser.DeclaravarContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarCleanParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaravar(NajaGrammarCleanParser.DeclaravarContext ctx);
	/**
	 * Enter a parse tree produced by {@link NajaGrammarCleanParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterComando(NajaGrammarCleanParser.ComandoContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarCleanParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitComando(NajaGrammarCleanParser.ComandoContext ctx);
	/**
	 * Enter a parse tree produced by {@link NajaGrammarCleanParser#cmdAttrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdAttrib(NajaGrammarCleanParser.CmdAttribContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarCleanParser#cmdAttrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdAttrib(NajaGrammarCleanParser.CmdAttribContext ctx);
	/**
	 * Enter a parse tree produced by {@link NajaGrammarCleanParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdLeitura(NajaGrammarCleanParser.CmdLeituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarCleanParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdLeitura(NajaGrammarCleanParser.CmdLeituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link NajaGrammarCleanParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscrita(NajaGrammarCleanParser.CmdEscritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarCleanParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscrita(NajaGrammarCleanParser.CmdEscritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link NajaGrammarCleanParser#cmdIf}.
	 * @param ctx the parse tree
	 */
	void enterCmdIf(NajaGrammarCleanParser.CmdIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarCleanParser#cmdIf}.
	 * @param ctx the parse tree
	 */
	void exitCmdIf(NajaGrammarCleanParser.CmdIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link NajaGrammarCleanParser#cmdWhile}.
	 * @param ctx the parse tree
	 */
	void enterCmdWhile(NajaGrammarCleanParser.CmdWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarCleanParser#cmdWhile}.
	 * @param ctx the parse tree
	 */
	void exitCmdWhile(NajaGrammarCleanParser.CmdWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link NajaGrammarCleanParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(NajaGrammarCleanParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarCleanParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(NajaGrammarCleanParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NajaGrammarCleanParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(NajaGrammarCleanParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarCleanParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(NajaGrammarCleanParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link NajaGrammarCleanParser#termol}.
	 * @param ctx the parse tree
	 */
	void enterTermol(NajaGrammarCleanParser.TermolContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarCleanParser#termol}.
	 * @param ctx the parse tree
	 */
	void exitTermol(NajaGrammarCleanParser.TermolContext ctx);
	/**
	 * Enter a parse tree produced by {@link NajaGrammarCleanParser#exprl}.
	 * @param ctx the parse tree
	 */
	void enterExprl(NajaGrammarCleanParser.ExprlContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarCleanParser#exprl}.
	 * @param ctx the parse tree
	 */
	void exitExprl(NajaGrammarCleanParser.ExprlContext ctx);
	/**
	 * Enter a parse tree produced by {@link NajaGrammarCleanParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(NajaGrammarCleanParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarCleanParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(NajaGrammarCleanParser.FatorContext ctx);
}