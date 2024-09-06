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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, OP=17, 
		OP_AT=18, OP_REL=19, ID=20, NUM=21, TEXTO=22, WS=23, AP=24, FP=25, VIRG=26, 
		PV=27, DP=28;
	public static final int
		RULE_programa = 0, RULE_comando = 1, RULE_cmdWhile = 2, RULE_cmdIf = 3, 
		RULE_cmdAttrib = 4, RULE_cmdLeitura = 5, RULE_cmdEscrita = 6, RULE_declaravar = 7, 
		RULE_expr = 8, RULE_termo = 9, RULE_exprl = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "comando", "cmdWhile", "cmdIf", "cmdAttrib", "cmdLeitura", 
			"cmdEscrita", "declaravar", "expr", "termo", "exprl"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'inicio'", "'fim'", "'fimprog'", "'enquanto'", "'fa\\u00E7a'", 
			"'fimfa\\u00E7a'", "'se'", "'entao'", "'senao'", "'fimse'", "'leia'", 
			"'escreva'", "'declare'", "'number'", "'text'", null, "':='", null, null, 
			null, null, null, "'('", "')'", "','", "';'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "OP", "OP_AT", "OP_REL", "ID", "NUM", "TEXTO", 
			"WS", "AP", "FP", "VIRG", "PV", "DP"
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
	    private IfCommand currentIfCommand;
	    private Stack<ArrayList<Command>> stack = new Stack<ArrayList<Command>>();

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

	    public Program getProgram(){
	      return this.program;
	    }

	    private Stack<AbstractExpression> abeStack = new Stack<AbstractExpression>();
	    private AbstractExpression topo = null;
	    public double generateValue(){
	        if (topo == null){
	             topo = abeStack.pop();
	        }
	        return topo.evaluate();
	    }

	    public String generateJSON(){
	         if (topo == null){
	            topo = abeStack.pop();
	        }
	        return topo.toJson();

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
			setState(22);
			match(T__0);
			setState(23);
			match(ID);
			 program.setName(_input.LT(-1).getText()); 
			                            stack.push(new ArrayList<Command>());
			                          
			setState(26); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(25);
				declaravar();
				}
				}
				setState(28); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__13 );
			setState(30);
			match(T__1);
			setState(32); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(31);
				comando();
				}
				}
				setState(34); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1061152L) != 0) );
			setState(36);
			match(T__2);
			setState(37);
			match(T__3);

			              program.setSymbolTable(symbolTable);
			              program.setCommandList(stack.pop());
			            
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
		enterRule(_localctx, 2, RULE_comando);
		try {
			setState(45);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				cmdAttrib();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				cmdLeitura();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 3);
				{
				setState(42);
				cmdEscrita();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(43);
				cmdIf();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 5);
				{
				setState(44);
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
		enterRule(_localctx, 4, RULE_cmdWhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(T__4);
			setState(48);
			match(AP);
			setState(49);
			expr();
			setState(50);
			match(OP_REL);
			setState(51);
			expr();
			setState(52);
			match(FP);
			setState(53);
			match(T__5);
			setState(55); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(54);
				comando();
				}
				}
				setState(57); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1061152L) != 0) );
			setState(59);
			match(T__6);
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
		enterRule(_localctx, 6, RULE_cmdIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(T__7);
			 stack.push(new ArrayList<Command>());
			                      strExpr = "";
			                      currentIfCommand = new IfCommand();
			                    
			setState(63);
			match(AP);
			setState(64);
			expr();
			setState(65);
			match(OP_REL);
			 strExpr += _input.LT(-1).getText(); 
			setState(67);
			expr();
			setState(68);
			match(FP);
			 currentIfCommand.setExpression(strExpr); 
			setState(70);
			match(T__8);
			setState(72); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(71);
				comando();
				}
				}
				setState(74); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1061152L) != 0) );
			currentIfCommand.setTrueList(stack.pop());
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(77);
				match(T__9);
				stack.push(new ArrayList<Command>());
				setState(80); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(79);
					comando();
					}
					}
					setState(82); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1061152L) != 0) );
				}
			}

			currentIfCommand.setFalseList(stack.pop());
			setState(87);
			match(T__10);
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
		enterRule(_localctx, 8, RULE_cmdAttrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                    throw new NajaSemanticException("Undeclared Varible: " +_input.LT(-1).getText());
			                  }
			                  symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                  leftType = symbolTable.get(_input.LT(-1).getText()).getType();
			                
			setState(92);
			match(OP_AT);
			setState(93);
			expr();
			setState(94);
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
		enterRule(_localctx, 10, RULE_cmdLeitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(T__11);
			setState(98);
			match(AP);
			setState(99);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                    throw new NajaSemanticException("Undeclared Varible: " +_input.LT(-1).getText());
			                      }
			                      symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                      Command cmdRead = new ReadCommand(symbolTable.get(_input.LT(-1).getText()));
			                      stack.peek().add(cmdRead);
			                    
			setState(101);
			match(FP);
			setState(102);
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
		enterRule(_localctx, 12, RULE_cmdEscrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(T__12);
			setState(105);
			match(AP);
			{
			setState(106);
			termo();
			}
			Command cmdWrite = new WriteCommand(_input.LT(-1).getText());
			                                stack.peek().add(cmdWrite);

			                      
			setState(108);
			match(FP);
			setState(109);
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
		enterRule(_localctx, 14, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(T__13);
			currentDec.clear();
			setState(114);
			match(ID);
			 currentDec.add(new Var(_input.LT(-1).getText()));
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRG) {
				{
				{
				setState(116);
				match(VIRG);
				setState(117);
				match(ID);
				 currentDec.add(new Var(_input.LT(-1).getText()));
				}
				}
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(124);
			match(DP);
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				{
				setState(125);
				match(T__14);
				currentType = Types.NUMBER;
				}
				break;
			case T__15:
				{
				setState(127);
				match(T__15);
				currentType = Types.TEXT;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			updateType();
			setState(132);
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
		enterRule(_localctx, 16, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			termo();
			strExpr += _input.LT(-1).getText();
			                
			setState(136);
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
		enterRule(_localctx, 18, RULE_termo);
		try {
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
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
				setState(140);
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
				setState(142);
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
		enterRule(_localctx, 20, RULE_exprl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(146);
				match(OP);
				 strExpr += _input.LT(-1).getText();
				setState(148);
				termo();
				 strExpr += _input.LT(-1).getText();
				}
				}
				setState(155);
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
		"\u0004\u0001\u001c\u009d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0004\u0000\u001b\b\u0000\u000b\u0000\f\u0000"+
		"\u001c\u0001\u0000\u0001\u0000\u0004\u0000!\b\u0000\u000b\u0000\f\u0000"+
		"\"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001.\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0004\u00028\b\u0002\u000b\u0002\f\u00029\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004"+
		"\u0003I\b\u0003\u000b\u0003\f\u0003J\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0004\u0003Q\b\u0003\u000b\u0003\f\u0003R\u0003\u0003U\b"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007x\b\u0007\n\u0007"+
		"\f\u0007{\t\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007\u0082\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u0091\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u0098"+
		"\b\n\n\n\f\n\u009b\t\n\u0001\n\u0000\u0000\u000b\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0000\u0000\u00a0\u0000\u0016\u0001\u0000"+
		"\u0000\u0000\u0002-\u0001\u0000\u0000\u0000\u0004/\u0001\u0000\u0000\u0000"+
		"\u0006=\u0001\u0000\u0000\u0000\bZ\u0001\u0000\u0000\u0000\na\u0001\u0000"+
		"\u0000\u0000\fh\u0001\u0000\u0000\u0000\u000ep\u0001\u0000\u0000\u0000"+
		"\u0010\u0086\u0001\u0000\u0000\u0000\u0012\u0090\u0001\u0000\u0000\u0000"+
		"\u0014\u0099\u0001\u0000\u0000\u0000\u0016\u0017\u0005\u0001\u0000\u0000"+
		"\u0017\u0018\u0005\u0014\u0000\u0000\u0018\u001a\u0006\u0000\uffff\uffff"+
		"\u0000\u0019\u001b\u0003\u000e\u0007\u0000\u001a\u0019\u0001\u0000\u0000"+
		"\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u001a\u0001\u0000\u0000"+
		"\u0000\u001c\u001d\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000"+
		"\u0000\u001e \u0005\u0002\u0000\u0000\u001f!\u0003\u0002\u0001\u0000 "+
		"\u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\" \u0001\u0000"+
		"\u0000\u0000\"#\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$%\u0005"+
		"\u0003\u0000\u0000%&\u0005\u0004\u0000\u0000&\'\u0006\u0000\uffff\uffff"+
		"\u0000\'\u0001\u0001\u0000\u0000\u0000(.\u0003\b\u0004\u0000).\u0003\n"+
		"\u0005\u0000*.\u0003\f\u0006\u0000+.\u0003\u0006\u0003\u0000,.\u0003\u0004"+
		"\u0002\u0000-(\u0001\u0000\u0000\u0000-)\u0001\u0000\u0000\u0000-*\u0001"+
		"\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000-,\u0001\u0000\u0000\u0000"+
		".\u0003\u0001\u0000\u0000\u0000/0\u0005\u0005\u0000\u000001\u0005\u0018"+
		"\u0000\u000012\u0003\u0010\b\u000023\u0005\u0013\u0000\u000034\u0003\u0010"+
		"\b\u000045\u0005\u0019\u0000\u000057\u0005\u0006\u0000\u000068\u0003\u0002"+
		"\u0001\u000076\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u000097\u0001"+
		"\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000"+
		";<\u0005\u0007\u0000\u0000<\u0005\u0001\u0000\u0000\u0000=>\u0005\b\u0000"+
		"\u0000>?\u0006\u0003\uffff\uffff\u0000?@\u0005\u0018\u0000\u0000@A\u0003"+
		"\u0010\b\u0000AB\u0005\u0013\u0000\u0000BC\u0006\u0003\uffff\uffff\u0000"+
		"CD\u0003\u0010\b\u0000DE\u0005\u0019\u0000\u0000EF\u0006\u0003\uffff\uffff"+
		"\u0000FH\u0005\t\u0000\u0000GI\u0003\u0002\u0001\u0000HG\u0001\u0000\u0000"+
		"\u0000IJ\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000JK\u0001\u0000"+
		"\u0000\u0000KL\u0001\u0000\u0000\u0000LT\u0006\u0003\uffff\uffff\u0000"+
		"MN\u0005\n\u0000\u0000NP\u0006\u0003\uffff\uffff\u0000OQ\u0003\u0002\u0001"+
		"\u0000PO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RP\u0001\u0000"+
		"\u0000\u0000RS\u0001\u0000\u0000\u0000SU\u0001\u0000\u0000\u0000TM\u0001"+
		"\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000"+
		"VW\u0006\u0003\uffff\uffff\u0000WX\u0005\u000b\u0000\u0000XY\u0006\u0003"+
		"\uffff\uffff\u0000Y\u0007\u0001\u0000\u0000\u0000Z[\u0005\u0014\u0000"+
		"\u0000[\\\u0006\u0004\uffff\uffff\u0000\\]\u0005\u0012\u0000\u0000]^\u0003"+
		"\u0010\b\u0000^_\u0005\u001b\u0000\u0000_`\u0006\u0004\uffff\uffff\u0000"+
		"`\t\u0001\u0000\u0000\u0000ab\u0005\f\u0000\u0000bc\u0005\u0018\u0000"+
		"\u0000cd\u0005\u0014\u0000\u0000de\u0006\u0005\uffff\uffff\u0000ef\u0005"+
		"\u0019\u0000\u0000fg\u0005\u001b\u0000\u0000g\u000b\u0001\u0000\u0000"+
		"\u0000hi\u0005\r\u0000\u0000ij\u0005\u0018\u0000\u0000jk\u0003\u0012\t"+
		"\u0000kl\u0006\u0006\uffff\uffff\u0000lm\u0005\u0019\u0000\u0000mn\u0005"+
		"\u001b\u0000\u0000no\u0006\u0006\uffff\uffff\u0000o\r\u0001\u0000\u0000"+
		"\u0000pq\u0005\u000e\u0000\u0000qr\u0006\u0007\uffff\uffff\u0000rs\u0005"+
		"\u0014\u0000\u0000sy\u0006\u0007\uffff\uffff\u0000tu\u0005\u001a\u0000"+
		"\u0000uv\u0005\u0014\u0000\u0000vx\u0006\u0007\uffff\uffff\u0000wt\u0001"+
		"\u0000\u0000\u0000x{\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000"+
		"yz\u0001\u0000\u0000\u0000z|\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000"+
		"\u0000|\u0081\u0005\u001c\u0000\u0000}~\u0005\u000f\u0000\u0000~\u0082"+
		"\u0006\u0007\uffff\uffff\u0000\u007f\u0080\u0005\u0010\u0000\u0000\u0080"+
		"\u0082\u0006\u0007\uffff\uffff\u0000\u0081}\u0001\u0000\u0000\u0000\u0081"+
		"\u007f\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083"+
		"\u0084\u0006\u0007\uffff\uffff\u0000\u0084\u0085\u0005\u001b\u0000\u0000"+
		"\u0085\u000f\u0001\u0000\u0000\u0000\u0086\u0087\u0003\u0012\t\u0000\u0087"+
		"\u0088\u0006\b\uffff\uffff\u0000\u0088\u0089\u0003\u0014\n\u0000\u0089"+
		"\u0011\u0001\u0000\u0000\u0000\u008a\u008b\u0005\u0014\u0000\u0000\u008b"+
		"\u0091\u0006\t\uffff\uffff\u0000\u008c\u008d\u0005\u0015\u0000\u0000\u008d"+
		"\u0091\u0006\t\uffff\uffff\u0000\u008e\u008f\u0005\u0016\u0000\u0000\u008f"+
		"\u0091\u0006\t\uffff\uffff\u0000\u0090\u008a\u0001\u0000\u0000\u0000\u0090"+
		"\u008c\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0091"+
		"\u0013\u0001\u0000\u0000\u0000\u0092\u0093\u0005\u0011\u0000\u0000\u0093"+
		"\u0094\u0006\n\uffff\uffff\u0000\u0094\u0095\u0003\u0012\t\u0000\u0095"+
		"\u0096\u0006\n\uffff\uffff\u0000\u0096\u0098\u0001\u0000\u0000\u0000\u0097"+
		"\u0092\u0001\u0000\u0000\u0000\u0098\u009b\u0001\u0000\u0000\u0000\u0099"+
		"\u0097\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a"+
		"\u0015\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u000b"+
		"\u001c\"-9JRTy\u0081\u0090\u0099";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}