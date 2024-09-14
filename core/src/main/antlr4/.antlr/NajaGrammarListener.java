// Generated from /home/thiago/Repositories/Personal/naja/core/src/main/antlr4/NajaGrammar.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NajaGrammarParser}.
 */
public interface NajaGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NajaGrammarParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(NajaGrammarParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(NajaGrammarParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link NajaGrammarParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaravar(NajaGrammarParser.DeclaravarContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaravar(NajaGrammarParser.DeclaravarContext ctx);
	/**
	 * Enter a parse tree produced by {@link NajaGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(NajaGrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(NajaGrammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NajaGrammarParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(NajaGrammarParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(NajaGrammarParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link NajaGrammarParser#exprl}.
	 * @param ctx the parse tree
	 */
	void enterExprl(NajaGrammarParser.ExprlContext ctx);
	/**
	 * Exit a parse tree produced by {@link NajaGrammarParser#exprl}.
	 * @param ctx the parse tree
	 */
	void exitExprl(NajaGrammarParser.ExprlContext ctx);
}