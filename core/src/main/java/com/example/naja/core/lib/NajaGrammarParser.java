// Generated from NajaGrammar.g4 by ANTLR 4.13.2
package com.example.naja.core.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import com.example.naja.core.types.*;
import com.example.naja.core.exceptions.*;
import com.example.naja.core.ast.*;
import com.example.naja.core.runtime.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class NajaGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, OP_SUM=17, 
		OP_SUB=18, OP_MUL=19, OP_DIV=20, OP_AT=21, OP_REL=22, ID=23, NUM=24, TEXTO=25, 
		WS=26, AP=27, FP=28, VIRG=29, PV=30, DP=31;
	public static final int
		RULE_programa = 0, RULE_declaravar = 1, RULE_comando = 2, RULE_cmdAttrib = 3, 
		RULE_cmdLeitura = 4, RULE_cmdEscrita = 5, RULE_cmdIf = 6, RULE_cmdWhile = 7, 
		RULE_expr = 8, RULE_termo = 9, RULE_termol = 10, RULE_exprl = 11, RULE_fator = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declaravar", "comando", "cmdAttrib", "cmdLeitura", "cmdEscrita", 
			"cmdIf", "cmdWhile", "expr", "termo", "termol", "exprl", "fator"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'inicio'", "'fim'", "'fimprog'", "'declare'", "'number'", 
			"'text'", "'leia'", "'escreva'", "'se'", "'entao'", "'senao'", "'fimse'", 
			"'enquanto'", "'fa\\u00E7a'", "'fimfa\\u00E7a'", "'+'", "'-'", "'*'", 
			"'/'", "':='", null, null, null, null, null, "'('", "')'", "','", "';'", 
			"':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "OP_SUM", "OP_SUB", "OP_MUL", "OP_DIV", 
			"OP_AT", "OP_REL", "ID", "NUM", "TEXTO", "WS", "AP", "FP", "VIRG", "PV", 
			"DP"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "NajaGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	private HashMap <String,Var> symbolTable = new HashMap<String, Var>();
	private ArrayList <Var> currentDec = new ArrayList<Var>();
	private Types currentType;
	private Types leftType = null , rightType = null;
	private Program program = new Program();
	private String strExpr = "";
	private String strAttr = "";
	private IfCommand currentIfCommand;
	private Stack<ArrayList<Command>> stack = new Stack<ArrayList<Command>>();
	private Stack<AbstractExpression> abeStack = new Stack<AbstractExpression>();
	private AbstractExpression topo = null;

	public void updateType() {
	    for (Var v: currentDec) {
	        v.setType(currentType);
	        symbolTable.put(v.getId(), v);
	    }
	}

	public void exibirVar() {
	    for (String id: symbolTable.keySet()) {
	        System.out.println(symbolTable.get(id));
	    }
	}

	public boolean isDeclared(String id) {
	    return symbolTable.get(id) != null;
	}

	public Program getProgram() {
	    return this.program;
	}

	public double generateValue() {
	    if (topo == null) {
	        topo = abeStack.pop();
	    }
	    return topo.evaluate();
	}

	public String generateJSON() {
	    if (topo == null) {
	        topo = abeStack.pop();
	    }
	    return topo.toJson();
	}

	public void checkUnusedVariables() {
	    for (Var var : symbolTable.values()) {
	        if (!var.isUsed()) {
	            throw new NajaSemanticException("Unused variable: " +var.getId());
	        }
	    }
	}

	public NajaGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(NajaGrammarParser.ID, 0); }
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(T__0);
			setState(27);
			match(ID);
			   
			                            program.setName(_input.LT(-1).getText()); 
			                            stack.push(new ArrayList<Command>());
			                        
			setState(30); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(29);
				declaravar();
				}
				}
				setState(32); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			setState(34);
			match(T__1);
			setState(36); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(35);
				comando();
				}
				}
				setState(38); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8406784L) != 0) );
			setState(40);
			match(T__2);
			setState(41);
			match(T__3);

			              program.setSymbolTable(symbolTable);
			              program.setCommandList(stack.pop());
			              checkUnusedVariables();
			            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaravarContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(NajaGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(NajaGrammarParser.ID, i);
		}
		public TerminalNode DP() { return getToken(NajaGrammarParser.DP, 0); }
		public TerminalNode PV() { return getToken(NajaGrammarParser.PV, 0); }
		public List<TerminalNode> VIRG() { return getTokens(NajaGrammarParser.VIRG); }
		public TerminalNode VIRG(int i) {
			return getToken(NajaGrammarParser.VIRG, i);
		}
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).enterDeclaravar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).exitDeclaravar(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(T__4);

			                    currentDec.clear();
			                
			setState(46);
			match(ID);
			 
			                    currentDec.add(new Var(_input.LT(-1).getText()));
			                
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRG) {
				{
				{
				setState(48);
				match(VIRG);
				setState(49);
				match(ID);
				 
				                    currentDec.add(new Var(_input.LT(-1).getText()));
				                
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(56);
			match(DP);
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				setState(57);
				match(T__5);

				                    currentType = Types.NUMBER;
				                
				}
				break;
			case T__6:
				{
				setState(59);
				match(T__6);

				                    currentType = Types.TEXT;
				                 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			                    updateType();
			                
			setState(64);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoContext extends ParserRuleContext {
		public CmdAttribContext cmdAttrib() {
			return getRuleContext(CmdAttribContext.class,0);
		}
		public CmdLeituraContext cmdLeitura() {
			return getRuleContext(CmdLeituraContext.class,0);
		}
		public CmdEscritaContext cmdEscrita() {
			return getRuleContext(CmdEscritaContext.class,0);
		}
		public CmdIfContext cmdIf() {
			return getRuleContext(CmdIfContext.class,0);
		}
		public CmdWhileContext cmdWhile() {
			return getRuleContext(CmdWhileContext.class,0);
		}
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).enterComando(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).exitComando(this);
		}
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_comando);
		try {
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				cmdAttrib();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				cmdLeitura();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				cmdEscrita();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				cmdIf();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 5);
				{
				setState(70);
				cmdWhile();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdAttribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(NajaGrammarParser.ID, 0); }
		public TerminalNode OP_AT() { return getToken(NajaGrammarParser.OP_AT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PV() { return getToken(NajaGrammarParser.PV, 0); }
		public CmdAttribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAttrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).enterCmdAttrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).exitCmdAttrib(this);
		}
	}

	public final CmdAttribContext cmdAttrib() throws RecognitionException {
		CmdAttribContext _localctx = new CmdAttribContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cmdAttrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(ID);
			 
			                    if (!isDeclared(_input.LT(-1).getText())) {
			                    throw new NajaSemanticException("Undeclared Variable: " +_input.LT(-1).getText());
			                  }
			                  symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                  leftType = symbolTable.get(_input.LT(-1).getText()).getType();

			                  AttCommand cmdAtt = new AttCommand();
			                  cmdAtt.setVar(symbolTable.get(_input.LT(-1).getText()));
			                  strAttr = "";

			                
			setState(75);
			match(OP_AT);
			setState(76);
			expr();

			                  cmdAtt.setExpression(strAttr);
			                  stack.peek().add(cmdAtt);
			               
			setState(78);
			match(PV);

			                    //System.out.println("left side expression type = " + leftType );
			                    //System.out.println("right side expression type = " + rightType) ;
			                    if(leftType.getValue() < rightType.getValue()){
			                        throw new NajaSemanticException("Type Mismatch on Assigment");
			                    }
			                
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdLeituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(NajaGrammarParser.AP, 0); }
		public TerminalNode ID() { return getToken(NajaGrammarParser.ID, 0); }
		public TerminalNode FP() { return getToken(NajaGrammarParser.FP, 0); }
		public TerminalNode PV() { return getToken(NajaGrammarParser.PV, 0); }
		public CmdLeituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdLeitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).enterCmdLeitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).exitCmdLeitura(this);
		}
	}

	public final CmdLeituraContext cmdLeitura() throws RecognitionException {
		CmdLeituraContext _localctx = new CmdLeituraContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cmdLeitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(T__7);
			setState(82);
			match(AP);
			setState(83);
			match(ID);
			   
			                            if (!isDeclared(_input.LT(-1).getText())) {
			                                throw new NajaSemanticException("Undeclared Variable: " +_input.LT(-1).getText());
			                            }
			                            symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                            Command cmdRead = new ReadCommand(symbolTable.get(_input.LT(-1).getText()));
			                            stack.peek().add(cmdRead);
			                        
			setState(85);
			match(FP);
			setState(86);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdEscritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(NajaGrammarParser.AP, 0); }
		public TerminalNode FP() { return getToken(NajaGrammarParser.FP, 0); }
		public TerminalNode PV() { return getToken(NajaGrammarParser.PV, 0); }
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
		}
		public CmdEscritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEscrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).enterCmdEscrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).exitCmdEscrita(this);
		}
	}

	public final CmdEscritaContext cmdEscrita() throws RecognitionException {
		CmdEscritaContext _localctx = new CmdEscritaContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmdEscrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(T__8);
			setState(89);
			match(AP);
			{
			setState(90);
			fator();
			}

			                        Command cmdWrite = new WriteCommand(_input.LT(-1).getText());
			                                stack.peek().add(cmdWrite);

			                      
			setState(92);
			match(FP);
			setState(93);
			match(PV);

			                            rightType = null;
			                        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdIfContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(NajaGrammarParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP_REL() { return getToken(NajaGrammarParser.OP_REL, 0); }
		public TerminalNode FP() { return getToken(NajaGrammarParser.FP, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public CmdIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).enterCmdIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).exitCmdIf(this);
		}
	}

	public final CmdIfContext cmdIf() throws RecognitionException {
		CmdIfContext _localctx = new CmdIfContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__9);
			   stack.push(new ArrayList<Command>());
			                    strExpr = "";
			                    currentIfCommand = new IfCommand();
			                
			setState(98);
			match(AP);
			setState(99);
			expr();
			setState(100);
			match(OP_REL);
			 
			                strExpr += _input.LT(-1).getText();
			                strAttr += _input.LT(-1).getText();
			               
			setState(102);
			expr();
			setState(103);
			match(FP);
			 
			                currentIfCommand.setExpression(strExpr); 
			              
			setState(105);
			match(T__10);
			setState(107); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(106);
				comando();
				}
				}
				setState(109); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8406784L) != 0) );

			                currentIfCommand.setTrueList(stack.pop());
			              
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(112);
				match(T__11);

				                stack.push(new ArrayList<Command>());
				              
				setState(115); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(114);
					comando();
					}
					}
					setState(117); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8406784L) != 0) );

				                currentIfCommand.setFalseList(stack.pop());
				              
				}
			}

			setState(123);
			match(T__12);

			                    stack.peek().add(currentIfCommand);
			                
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdWhileContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(NajaGrammarParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP_REL() { return getToken(NajaGrammarParser.OP_REL, 0); }
		public TerminalNode FP() { return getToken(NajaGrammarParser.FP, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public CmdWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).enterCmdWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).exitCmdWhile(this);
		}
	}

	public final CmdWhileContext cmdWhile() throws RecognitionException {
		CmdWhileContext _localctx = new CmdWhileContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdWhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__13);
			setState(127);
			match(AP);
			setState(128);
			expr();
			setState(129);
			match(OP_REL);
			setState(130);
			expr();
			setState(131);
			match(FP);
			setState(132);
			match(T__14);
			setState(134); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(133);
				comando();
				}
				}
				setState(136); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8406784L) != 0) );
			setState(138);
			match(T__15);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public ExprlContext exprl() {
			return getRuleContext(ExprlContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			termo();
			strExpr += _input.LT(-1).getText();
			                  strAttr += _input.LT(-1).getText();
			                
			setState(142);
			exprl();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermoContext extends ParserRuleContext {
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
		}
		public TermolContext termol() {
			return getRuleContext(TermolContext.class,0);
		}
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_termo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			fator();
			setState(145);
			termol();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermolContext extends ParserRuleContext {
		public List<FatorContext> fator() {
			return getRuleContexts(FatorContext.class);
		}
		public FatorContext fator(int i) {
			return getRuleContext(FatorContext.class,i);
		}
		public List<TerminalNode> OP_MUL() { return getTokens(NajaGrammarParser.OP_MUL); }
		public TerminalNode OP_MUL(int i) {
			return getToken(NajaGrammarParser.OP_MUL, i);
		}
		public List<TerminalNode> OP_DIV() { return getTokens(NajaGrammarParser.OP_DIV); }
		public TerminalNode OP_DIV(int i) {
			return getToken(NajaGrammarParser.OP_DIV, i);
		}
		public TermolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).enterTermol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).exitTermol(this);
		}
	}

	public final TermolContext termol() throws RecognitionException {
		TermolContext _localctx = new TermolContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_termol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_MUL || _la==OP_DIV) {
				{
				{
				setState(147);
				_la = _input.LA(1);
				if ( !(_la==OP_MUL || _la==OP_DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				 
				                    strExpr += _input.LT(-1).getText();
				                    strAttr += _input.LT(-1).getText();
				                
				setState(149);
				fator();
				 
				                    strExpr += _input.LT(-1).getText();
				                    strAttr += _input.LT(-1).getText();
				                
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprlContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> OP_SUM() { return getTokens(NajaGrammarParser.OP_SUM); }
		public TerminalNode OP_SUM(int i) {
			return getToken(NajaGrammarParser.OP_SUM, i);
		}
		public List<TerminalNode> OP_SUB() { return getTokens(NajaGrammarParser.OP_SUB); }
		public TerminalNode OP_SUB(int i) {
			return getToken(NajaGrammarParser.OP_SUB, i);
		}
		public ExprlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).enterExprl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).exitExprl(this);
		}
	}

	public final ExprlContext exprl() throws RecognitionException {
		ExprlContext _localctx = new ExprlContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_exprl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_SUM || _la==OP_SUB) {
				{
				{
				setState(157);
				_la = _input.LA(1);
				if ( !(_la==OP_SUM || _la==OP_SUB) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				 
				                strExpr += _input.LT(-1).getText();
				                strAttr += _input.LT(-1).getText();
				            
				setState(159);
				termo();
				 
				                 strExpr += _input.LT(-1).getText();
				                 strAttr += _input.LT(-1).getText();
				             
				}
				}
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FatorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(NajaGrammarParser.ID, 0); }
		public TerminalNode NUM() { return getToken(NajaGrammarParser.NUM, 0); }
		public TerminalNode TEXTO() { return getToken(NajaGrammarParser.TEXTO, 0); }
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).enterFator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).exitFator(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_fator);
		try {
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				match(ID);
				 
				                if (!isDeclared(_input.LT(-1).getText())) {
				                    throw new NajaSemanticException("Undeclared Variable: " +_input.LT(-1).getText());
				                  }
				                  if (!symbolTable.get(_input.LT(-1).getText()).isInitialized()){
				                    throw new NajaSemanticException("Variable: " +_input.LT(-1).getText() + " has no value assigned ");
				                  }
				                  if (rightType == null){
				                    rightType = symbolTable.get(_input.LT(-1).getText()).getType();
				                }
				                  else{
				                    if (symbolTable.get(_input.LT(-1).getText()).getType().getValue() > rightType.getValue()){
				                      rightType = symbolTable.get(_input.LT(-1).getText()).getType();
				                    }
				                  }
				                  symbolTable.get(_input.LT(-1).getText()).setUsed(true); 
				              
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				match(NUM);
				 
				                if (rightType == null) {
				                  rightType = Types.NUMBER;
				                  }
				                  else{
				                    if(rightType.getValue() < Types.NUMBER.getValue()){
				                      rightType = Types.NUMBER;
				                    }
				                  }
				                
				}
				break;
			case TEXTO:
				enterOuterAlt(_localctx, 3);
				{
				setState(171);
				match(TEXTO);
				 
				            if (rightType == null) {
				                  rightType = Types.TEXT;
				                  }
				                  else{
				                    if(rightType.getValue() < Types.TEXT.getValue()){
				                      rightType = Types.TEXT;
				                    }
				                  }
				                
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001f\u00b0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0004"+
		"\u0000\u001f\b\u0000\u000b\u0000\f\u0000 \u0001\u0000\u0001\u0000\u0004"+
		"\u0000%\b\u0000\u000b\u0000\f\u0000&\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u00014\b\u0001\n\u0001\f\u00017\t\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		">\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002H\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006l\b\u0006\u000b\u0006"+
		"\f\u0006m\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006"+
		"t\b\u0006\u000b\u0006\f\u0006u\u0001\u0006\u0001\u0006\u0003\u0006z\b"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0004"+
		"\u0007\u0087\b\u0007\u000b\u0007\f\u0007\u0088\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0005\n\u0099\b\n\n\n\f\n\u009c\t\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00a3\b\u000b"+
		"\n\u000b\f\u000b\u00a6\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0003\f\u00ae\b\f\u0001\f\u0000\u0000\r\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u0000\u0002\u0001\u0000\u0013"+
		"\u0014\u0001\u0000\u0011\u0012\u00b2\u0000\u001a\u0001\u0000\u0000\u0000"+
		"\u0002,\u0001\u0000\u0000\u0000\u0004G\u0001\u0000\u0000\u0000\u0006I"+
		"\u0001\u0000\u0000\u0000\bQ\u0001\u0000\u0000\u0000\nX\u0001\u0000\u0000"+
		"\u0000\f`\u0001\u0000\u0000\u0000\u000e~\u0001\u0000\u0000\u0000\u0010"+
		"\u008c\u0001\u0000\u0000\u0000\u0012\u0090\u0001\u0000\u0000\u0000\u0014"+
		"\u009a\u0001\u0000\u0000\u0000\u0016\u00a4\u0001\u0000\u0000\u0000\u0018"+
		"\u00ad\u0001\u0000\u0000\u0000\u001a\u001b\u0005\u0001\u0000\u0000\u001b"+
		"\u001c\u0005\u0017\u0000\u0000\u001c\u001e\u0006\u0000\uffff\uffff\u0000"+
		"\u001d\u001f\u0003\u0002\u0001\u0000\u001e\u001d\u0001\u0000\u0000\u0000"+
		"\u001f \u0001\u0000\u0000\u0000 \u001e\u0001\u0000\u0000\u0000 !\u0001"+
		"\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"$\u0005\u0002\u0000\u0000"+
		"#%\u0003\u0004\u0002\u0000$#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000"+
		"\u0000&$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'(\u0001\u0000"+
		"\u0000\u0000()\u0005\u0003\u0000\u0000)*\u0005\u0004\u0000\u0000*+\u0006"+
		"\u0000\uffff\uffff\u0000+\u0001\u0001\u0000\u0000\u0000,-\u0005\u0005"+
		"\u0000\u0000-.\u0006\u0001\uffff\uffff\u0000./\u0005\u0017\u0000\u0000"+
		"/5\u0006\u0001\uffff\uffff\u000001\u0005\u001d\u0000\u000012\u0005\u0017"+
		"\u0000\u000024\u0006\u0001\uffff\uffff\u000030\u0001\u0000\u0000\u0000"+
		"47\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000056\u0001\u0000\u0000"+
		"\u000068\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u00008=\u0005\u001f"+
		"\u0000\u00009:\u0005\u0006\u0000\u0000:>\u0006\u0001\uffff\uffff\u0000"+
		";<\u0005\u0007\u0000\u0000<>\u0006\u0001\uffff\uffff\u0000=9\u0001\u0000"+
		"\u0000\u0000=;\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?@\u0006"+
		"\u0001\uffff\uffff\u0000@A\u0005\u001e\u0000\u0000A\u0003\u0001\u0000"+
		"\u0000\u0000BH\u0003\u0006\u0003\u0000CH\u0003\b\u0004\u0000DH\u0003\n"+
		"\u0005\u0000EH\u0003\f\u0006\u0000FH\u0003\u000e\u0007\u0000GB\u0001\u0000"+
		"\u0000\u0000GC\u0001\u0000\u0000\u0000GD\u0001\u0000\u0000\u0000GE\u0001"+
		"\u0000\u0000\u0000GF\u0001\u0000\u0000\u0000H\u0005\u0001\u0000\u0000"+
		"\u0000IJ\u0005\u0017\u0000\u0000JK\u0006\u0003\uffff\uffff\u0000KL\u0005"+
		"\u0015\u0000\u0000LM\u0003\u0010\b\u0000MN\u0006\u0003\uffff\uffff\u0000"+
		"NO\u0005\u001e\u0000\u0000OP\u0006\u0003\uffff\uffff\u0000P\u0007\u0001"+
		"\u0000\u0000\u0000QR\u0005\b\u0000\u0000RS\u0005\u001b\u0000\u0000ST\u0005"+
		"\u0017\u0000\u0000TU\u0006\u0004\uffff\uffff\u0000UV\u0005\u001c\u0000"+
		"\u0000VW\u0005\u001e\u0000\u0000W\t\u0001\u0000\u0000\u0000XY\u0005\t"+
		"\u0000\u0000YZ\u0005\u001b\u0000\u0000Z[\u0003\u0018\f\u0000[\\\u0006"+
		"\u0005\uffff\uffff\u0000\\]\u0005\u001c\u0000\u0000]^\u0005\u001e\u0000"+
		"\u0000^_\u0006\u0005\uffff\uffff\u0000_\u000b\u0001\u0000\u0000\u0000"+
		"`a\u0005\n\u0000\u0000ab\u0006\u0006\uffff\uffff\u0000bc\u0005\u001b\u0000"+
		"\u0000cd\u0003\u0010\b\u0000de\u0005\u0016\u0000\u0000ef\u0006\u0006\uffff"+
		"\uffff\u0000fg\u0003\u0010\b\u0000gh\u0005\u001c\u0000\u0000hi\u0006\u0006"+
		"\uffff\uffff\u0000ik\u0005\u000b\u0000\u0000jl\u0003\u0004\u0002\u0000"+
		"kj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000"+
		"\u0000mn\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000oy\u0006\u0006"+
		"\uffff\uffff\u0000pq\u0005\f\u0000\u0000qs\u0006\u0006\uffff\uffff\u0000"+
		"rt\u0003\u0004\u0002\u0000sr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000"+
		"\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vw\u0001\u0000"+
		"\u0000\u0000wx\u0006\u0006\uffff\uffff\u0000xz\u0001\u0000\u0000\u0000"+
		"yp\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000"+
		"\u0000{|\u0005\r\u0000\u0000|}\u0006\u0006\uffff\uffff\u0000}\r\u0001"+
		"\u0000\u0000\u0000~\u007f\u0005\u000e\u0000\u0000\u007f\u0080\u0005\u001b"+
		"\u0000\u0000\u0080\u0081\u0003\u0010\b\u0000\u0081\u0082\u0005\u0016\u0000"+
		"\u0000\u0082\u0083\u0003\u0010\b\u0000\u0083\u0084\u0005\u001c\u0000\u0000"+
		"\u0084\u0086\u0005\u000f\u0000\u0000\u0085\u0087\u0003\u0004\u0002\u0000"+
		"\u0086\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000"+
		"\u0088\u0086\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000"+
		"\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u008b\u0005\u0010\u0000\u0000"+
		"\u008b\u000f\u0001\u0000\u0000\u0000\u008c\u008d\u0003\u0012\t\u0000\u008d"+
		"\u008e\u0006\b\uffff\uffff\u0000\u008e\u008f\u0003\u0016\u000b\u0000\u008f"+
		"\u0011\u0001\u0000\u0000\u0000\u0090\u0091\u0003\u0018\f\u0000\u0091\u0092"+
		"\u0003\u0014\n\u0000\u0092\u0013\u0001\u0000\u0000\u0000\u0093\u0094\u0007"+
		"\u0000\u0000\u0000\u0094\u0095\u0006\n\uffff\uffff\u0000\u0095\u0096\u0003"+
		"\u0018\f\u0000\u0096\u0097\u0006\n\uffff\uffff\u0000\u0097\u0099\u0001"+
		"\u0000\u0000\u0000\u0098\u0093\u0001\u0000\u0000\u0000\u0099\u009c\u0001"+
		"\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009a\u009b\u0001"+
		"\u0000\u0000\u0000\u009b\u0015\u0001\u0000\u0000\u0000\u009c\u009a\u0001"+
		"\u0000\u0000\u0000\u009d\u009e\u0007\u0001\u0000\u0000\u009e\u009f\u0006"+
		"\u000b\uffff\uffff\u0000\u009f\u00a0\u0003\u0012\t\u0000\u00a0\u00a1\u0006"+
		"\u000b\uffff\uffff\u0000\u00a1\u00a3\u0001\u0000\u0000\u0000\u00a2\u009d"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a6\u0001\u0000\u0000\u0000\u00a4\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u0017"+
		"\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a7\u00a8"+
		"\u0005\u0017\u0000\u0000\u00a8\u00ae\u0006\f\uffff\uffff\u0000\u00a9\u00aa"+
		"\u0005\u0018\u0000\u0000\u00aa\u00ae\u0006\f\uffff\uffff\u0000\u00ab\u00ac"+
		"\u0005\u0019\u0000\u0000\u00ac\u00ae\u0006\f\uffff\uffff\u0000\u00ad\u00a7"+
		"\u0001\u0000\u0000\u0000\u00ad\u00a9\u0001\u0000\u0000\u0000\u00ad\u00ab"+
		"\u0001\u0000\u0000\u0000\u00ae\u0019\u0001\u0000\u0000\u0000\f &5=Gmu"+
		"y\u0088\u009a\u00a4\u00ad";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}