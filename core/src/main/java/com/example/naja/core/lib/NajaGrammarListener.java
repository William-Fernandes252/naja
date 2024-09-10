// Generated from NajaGrammar.g4 by ANTLR 4.13.2
package com.example.naja.core.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import com.example.naja.core.types.*;
import com.example.naja.core.exceptions.*;
import com.example.naja.core.ast.*;
import com.example.naja.core.runtime.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NajaGrammarParser}.
 */
public interface NajaGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NajaGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(NajaGrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(NajaGrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link NajaGrammarParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(NajaGrammarParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(NajaGrammarParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link NajaGrammarParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(NajaGrammarParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(NajaGrammarParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link NajaGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(NajaGrammarParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(NajaGrammarParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link NajaGrammarParser#read}.
	 * @param ctx the parse tree
	 */
	void enterRead(NajaGrammarParser.ReadContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarParser#read}.
	 * @param ctx the parse tree
	 */
	void exitRead(NajaGrammarParser.ReadContext ctx);
	/**
	 * Enter a parse tree produced by {@link NajaGrammarParser#write}.
	 * @param ctx the parse tree
	 */
	void enterWrite(NajaGrammarParser.WriteContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarParser#write}.
	 * @param ctx the parse tree
	 */
	void exitWrite(NajaGrammarParser.WriteContext ctx);
	/**
	 * Enter a parse tree produced by {@link NajaGrammarParser#if}.
	 * @param ctx the parse tree
	 */
	void enterIf(NajaGrammarParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarParser#if}.
	 * @param ctx the parse tree
	 */
	void exitIf(NajaGrammarParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by {@link NajaGrammarParser#while}.
	 * @param ctx the parse tree
	 */
	void enterWhile(NajaGrammarParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarParser#while}.
	 * @param ctx the parse tree
	 */
	void exitWhile(NajaGrammarParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link NajaGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(NajaGrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(NajaGrammarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NajaGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(NajaGrammarParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(NajaGrammarParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link NajaGrammarParser#terml}.
	 * @param ctx the parse tree
	 */
	void enterTerml(NajaGrammarParser.TermlContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarParser#terml}.
	 * @param ctx the parse tree
	 */
	void exitTerml(NajaGrammarParser.TermlContext ctx);
	/**
	 * Enter a parse tree produced by {@link NajaGrammarParser#expressionl}.
	 * @param ctx the parse tree
	 */
	void enterExpressionl(NajaGrammarParser.ExpressionlContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarParser#expressionl}.
	 * @param ctx the parse tree
	 */
	void exitExpressionl(NajaGrammarParser.ExpressionlContext ctx);
	/**
	 * Enter a parse tree produced by {@link NajaGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(NajaGrammarParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(NajaGrammarParser.FactorContext ctx);
}