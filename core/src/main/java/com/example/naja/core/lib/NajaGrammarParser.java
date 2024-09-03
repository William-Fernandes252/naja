// Generated from NajaGrammar.g4 by ANTLR 4.13.2
package com.example.naja.core.lib;

    import java.util.ArrayList;
    import java.util.HashMap;
    import com.example.naja.types.*;
    import com.example.naja.core.exceptions.*;


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
		OP=10, OP_AT=11, ID=12, NUM=13, TEXTO=14, WS=15, AP=16, FP=17, VIRG=18, 
		PV=19, DP=20;
	public static final int
		RULE_programa = 0, RULE_comando = 1, RULE_cmdAttrib = 2, RULE_cmdLeitura = 3, 
		RULE_cmdEscrita = 4, RULE_declaravar = 5, RULE_expr = 6, RULE_termo = 7, 
		RULE_exprl = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "comando", "cmdAttrib", "cmdLeitura", "cmdEscrita", "declaravar", 
			"expr", "termo", "exprl"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'inicio'", "'fim'", "'fimprog'", "'leia'", "'escreva'", 
			"'declare'", "'number'", "'text'", null, "':='", null, null, null, null, 
			"'('", "')'", "','", "';'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "OP", "OP_AT", 
			"ID", "NUM", "TEXTO", "WS", "AP", "FP", "VIRG", "PV", "DP"
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

	    public void updateType(){
	      for (Var v: currentDec){
	        v.setType(currentType);
	        symbolTable.put(v.getId(), v);
	      }
	    }


	    public void exibirVar(){
	        for (String id: symbolTable.keySet()){
	            System.out.println(symbolTable.get(id));
	        }
	    }

	    public boolean isDeclared(String id){
	      return symbolTable.get(id) != null;
	    }

	public NajaGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
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
			setState(18);
			match(T__0);
			setState(20); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(19);
				declaravar();
				}
				}
				setState(22); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__6 );
			setState(24);
			match(T__1);
			setState(26); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(25);
				comando();
				}
				}
				setState(28); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4192L) != 0) );
			setState(30);
			match(T__2);
			setState(31);
			match(T__3);
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
		enterRule(_localctx, 2, RULE_comando);
		try {
			setState(36);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				cmdAttrib();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
				cmdLeitura();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(35);
				cmdEscrita();
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
		enterRule(_localctx, 4, RULE_cmdAttrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                    throw new NajaSemanticException("Undeclared Varible: " +_input.LT(-1).getText());
			                  }
			                  symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                  leftType = symbolTable.get(_input.LT(-1).getText()).getType();
			                
			setState(40);
			match(OP_AT);
			setState(41);
			expr();
			setState(42);
			match(PV);

			                System.out.println("left side expression type = " + leftType );
			                System.out.println("right side expression type = " + rightType) ;
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
		enterRule(_localctx, 6, RULE_cmdLeitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(T__4);
			setState(46);
			match(AP);
			setState(47);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                    throw new NajaSemanticException("Undeclared Varible: " +_input.LT(-1).getText());
			                      }
			                      symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                    
			setState(49);
			match(FP);
			setState(50);
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
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
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
		enterRule(_localctx, 8, RULE_cmdEscrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(T__5);
			setState(53);
			match(AP);
			{
			setState(54);
			termo();
			}
			setState(55);
			match(FP);
			setState(56);
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
		enterRule(_localctx, 10, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(T__6);
			currentDec.clear();
			setState(61);
			match(ID);
			 currentDec.add(new Var(_input.LT(-1).getText()));
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRG) {
				{
				{
				setState(63);
				match(VIRG);
				setState(64);
				match(ID);
				 currentDec.add(new Var(_input.LT(-1).getText()));
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71);
			match(DP);
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				{
				setState(72);
				match(T__7);
				currentType = Types.NUMBER;
				}
				break;
			case T__8:
				{
				setState(74);
				match(T__8);
				currentType = Types.TEXT;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			updateType();
			setState(79);
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
		enterRule(_localctx, 12, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			termo();
			setState(82);
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
		public TerminalNode ID() { return getToken(NajaGrammarParser.ID, 0); }
		public TerminalNode NUM() { return getToken(NajaGrammarParser.NUM, 0); }
		public TerminalNode TEXTO() { return getToken(NajaGrammarParser.TEXTO, 0); }
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
		enterRule(_localctx, 14, RULE_termo);
		try {
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				match(ID);
				 if (!isDeclared(_input.LT(-1).getText())) {
				                    throw new NajaSemanticException("Undeclared Varible: " +_input.LT(-1).getText());
				                  }
				                  if (!symbolTable.get(_input.LT(-1).getText()).isInitialized()){
				                    throw new NajaSemanticException("Varible: " +_input.LT(-1).getText() + " has no value assigned ");
				                  }
				                  if (rightType == null){
				                    rightType = symbolTable.get(_input.LT(-1).getText()).getType();
				                }
				                  else{
				                    if (symbolTable.get(_input.LT(-1).getText()).getType().getValue() > rightType.getValue()){
				                      rightType = symbolTable.get(_input.LT(-1).getText()).getType();
				                    }
				                  }
				              
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
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
				setState(88);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprlContext extends ParserRuleContext {
		public List<TerminalNode> OP() { return getTokens(NajaGrammarParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(NajaGrammarParser.OP, i);
		}
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
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
		enterRule(_localctx, 16, RULE_exprl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(92);
				match(OP);
				setState(93);
				termo();
				}
				}
				setState(98);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0014d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0001\u0000\u0001\u0000\u0004\u0000\u0015\b\u0000\u000b\u0000"+
		"\f\u0000\u0016\u0001\u0000\u0001\u0000\u0004\u0000\u001b\b\u0000\u000b"+
		"\u0000\f\u0000\u001c\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001%\b\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0005\u0005C\b\u0005\n\u0005\f\u0005F\t\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005M\b"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007[\b\u0007\u0001\b\u0001\b\u0005\b_\b\b\n\b\f\bb\t\b"+
		"\u0001\b\u0000\u0000\t\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0000"+
		"\u0000c\u0000\u0012\u0001\u0000\u0000\u0000\u0002$\u0001\u0000\u0000\u0000"+
		"\u0004&\u0001\u0000\u0000\u0000\u0006-\u0001\u0000\u0000\u0000\b4\u0001"+
		"\u0000\u0000\u0000\n;\u0001\u0000\u0000\u0000\fQ\u0001\u0000\u0000\u0000"+
		"\u000eZ\u0001\u0000\u0000\u0000\u0010`\u0001\u0000\u0000\u0000\u0012\u0014"+
		"\u0005\u0001\u0000\u0000\u0013\u0015\u0003\n\u0005\u0000\u0014\u0013\u0001"+
		"\u0000\u0000\u0000\u0015\u0016\u0001\u0000\u0000\u0000\u0016\u0014\u0001"+
		"\u0000\u0000\u0000\u0016\u0017\u0001\u0000\u0000\u0000\u0017\u0018\u0001"+
		"\u0000\u0000\u0000\u0018\u001a\u0005\u0002\u0000\u0000\u0019\u001b\u0003"+
		"\u0002\u0001\u0000\u001a\u0019\u0001\u0000\u0000\u0000\u001b\u001c\u0001"+
		"\u0000\u0000\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001c\u001d\u0001"+
		"\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e\u001f\u0005"+
		"\u0003\u0000\u0000\u001f \u0005\u0004\u0000\u0000 \u0001\u0001\u0000\u0000"+
		"\u0000!%\u0003\u0004\u0002\u0000\"%\u0003\u0006\u0003\u0000#%\u0003\b"+
		"\u0004\u0000$!\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000$#\u0001"+
		"\u0000\u0000\u0000%\u0003\u0001\u0000\u0000\u0000&\'\u0005\f\u0000\u0000"+
		"\'(\u0006\u0002\uffff\uffff\u0000()\u0005\u000b\u0000\u0000)*\u0003\f"+
		"\u0006\u0000*+\u0005\u0013\u0000\u0000+,\u0006\u0002\uffff\uffff\u0000"+
		",\u0005\u0001\u0000\u0000\u0000-.\u0005\u0005\u0000\u0000./\u0005\u0010"+
		"\u0000\u0000/0\u0005\f\u0000\u000001\u0006\u0003\uffff\uffff\u000012\u0005"+
		"\u0011\u0000\u000023\u0005\u0013\u0000\u00003\u0007\u0001\u0000\u0000"+
		"\u000045\u0005\u0006\u0000\u000056\u0005\u0010\u0000\u000067\u0003\u000e"+
		"\u0007\u000078\u0005\u0011\u0000\u000089\u0005\u0013\u0000\u00009:\u0006"+
		"\u0004\uffff\uffff\u0000:\t\u0001\u0000\u0000\u0000;<\u0005\u0007\u0000"+
		"\u0000<=\u0006\u0005\uffff\uffff\u0000=>\u0005\f\u0000\u0000>D\u0006\u0005"+
		"\uffff\uffff\u0000?@\u0005\u0012\u0000\u0000@A\u0005\f\u0000\u0000AC\u0006"+
		"\u0005\uffff\uffff\u0000B?\u0001\u0000\u0000\u0000CF\u0001\u0000\u0000"+
		"\u0000DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EG\u0001\u0000"+
		"\u0000\u0000FD\u0001\u0000\u0000\u0000GL\u0005\u0014\u0000\u0000HI\u0005"+
		"\b\u0000\u0000IM\u0006\u0005\uffff\uffff\u0000JK\u0005\t\u0000\u0000K"+
		"M\u0006\u0005\uffff\uffff\u0000LH\u0001\u0000\u0000\u0000LJ\u0001\u0000"+
		"\u0000\u0000MN\u0001\u0000\u0000\u0000NO\u0006\u0005\uffff\uffff\u0000"+
		"OP\u0005\u0013\u0000\u0000P\u000b\u0001\u0000\u0000\u0000QR\u0003\u000e"+
		"\u0007\u0000RS\u0003\u0010\b\u0000S\r\u0001\u0000\u0000\u0000TU\u0005"+
		"\f\u0000\u0000U[\u0006\u0007\uffff\uffff\u0000VW\u0005\r\u0000\u0000W"+
		"[\u0006\u0007\uffff\uffff\u0000XY\u0005\u000e\u0000\u0000Y[\u0006\u0007"+
		"\uffff\uffff\u0000ZT\u0001\u0000\u0000\u0000ZV\u0001\u0000\u0000\u0000"+
		"ZX\u0001\u0000\u0000\u0000[\u000f\u0001\u0000\u0000\u0000\\]\u0005\n\u0000"+
		"\u0000]_\u0003\u000e\u0007\u0000^\\\u0001\u0000\u0000\u0000_b\u0001\u0000"+
		"\u0000\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000a\u0011"+
		"\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000\u0007\u0016\u001c$"+
		"DLZ`";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}