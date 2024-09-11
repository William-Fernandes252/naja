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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, SUM_OP=17, 
		SUBTRACTION_OP=18, MULTIPLICATION_OP=19, DIVISION_OP=20, ASSIGNMENT_OP=21, 
		COMPARISON_OP=22, ID=23, NUM=24, TEXT=25, WHITE_SPACE=26, LEFT_PAREN=27, 
		RIGHT_PAREN=28, COMMA=29, SEMICOLON=30, COLON=31;
	public static final int
		RULE_program = 0, RULE_declaration = 1, RULE_command = 2, RULE_assignment = 3, 
		RULE_read = 4, RULE_write = 5, RULE_if = 6, RULE_while = 7, RULE_expression = 8, 
		RULE_term = 9, RULE_terml = 10, RULE_expressionl = 11, RULE_factor = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declaration", "command", "assignment", "read", "write", "if", 
			"while", "expression", "term", "terml", "expressionl", "factor"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'program'", "'begin'", "'end'", "'endprogram'", "'declare'", "'number'", 
			"'text'", "'read'", "'write'", "'if'", "'then'", "'else'", "'endif'", 
			"'while'", "'do'", "'endwhile'", "'+'", "'-'", "'*'", "'/'", "':='", 
			null, null, null, null, null, "'('", "')'", "','", "';'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "SUM_OP", "SUBTRACTION_OP", "MULTIPLICATION_OP", 
			"DIVISION_OP", "ASSIGNMENT_OP", "COMPARISON_OP", "ID", "NUM", "TEXT", 
			"WHITE_SPACE", "LEFT_PAREN", "RIGHT_PAREN", "COMMA", "SEMICOLON", "COLON"
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
	private String expressionStr = "";
	private String assignmentStr = "";
	private IfCommand currentIfCommand;
	private WhileCommand currentWhileCommand;
	private Stack<ArrayList<Command>> stack = new Stack<ArrayList<Command>>();
	private Stack<AbstractExpression> abeStack = new Stack<AbstractExpression>();
	private AbstractExpression top = null;

	public void updateTypes() {
	    for (Var v: currentDec) {
	        v.setType(currentType);
	        symbolTable.put(v.getId(), v);
	    }
	}

	public void showVariables() {
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
	    if (top == null) {
	        top = abeStack.pop();
	    }
	    return top.evaluate();
	}

	public String generateJSON() {
	    if (top == null) {
	        top = abeStack.pop();
	    }
	    return top.toJson();
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
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(NajaGrammarParser.ID, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
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
				declaration();
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
				command();
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
	public static class DeclarationContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(NajaGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(NajaGrammarParser.ID, i);
		}
		public TerminalNode COLON() { return getToken(NajaGrammarParser.COLON, 0); }
		public TerminalNode SEMICOLON() { return getToken(NajaGrammarParser.SEMICOLON, 0); }
		public List<TerminalNode> COMMA() { return getTokens(NajaGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(NajaGrammarParser.COMMA, i);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
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
			while (_la==COMMA) {
				{
				{
				setState(48);
				match(COMMA);
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
			match(COLON);
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

			        updateTypes();
			    
			setState(64);
			match(SEMICOLON);
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
	public static class CommandContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ReadContext read() {
			return getRuleContext(ReadContext.class,0);
		}
		public WriteContext write() {
			return getRuleContext(WriteContext.class,0);
		}
		public IfContext if_() {
			return getRuleContext(IfContext.class,0);
		}
		public WhileContext while_() {
			return getRuleContext(WhileContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).exitCommand(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_command);
		try {
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				assignment();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				read();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				write();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				if_();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 5);
				{
				setState(70);
				while_();
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
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(NajaGrammarParser.ID, 0); }
		public TerminalNode ASSIGNMENT_OP() { return getToken(NajaGrammarParser.ASSIGNMENT_OP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(NajaGrammarParser.SEMICOLON, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(ID);
			 
			        String lastTokenText = _input.LT(-1).getText();
			        if (!isDeclared(lastTokenText)) {
			            throw new NajaSemanticException("Undeclared Variable: " + lastTokenText);
			        }

			        Var symbol = symbolTable.get(lastTokenText);
			        symbol.setInitialized(true);

			        leftType = symbolTable.get(_input.LT(-1).getText()).getType();

			        AssignmentCommand assignment = new AssignmentCommand();
			        assignment.setVar(symbol);

			        assignmentStr = "";
			    
			setState(75);
			match(ASSIGNMENT_OP);
			setState(76);
			expression();

			        assignment.setExpression(assignmentStr);
			        stack.peek().add(assignment);
			    
			setState(78);
			match(SEMICOLON);

			        if (leftType.getValue() < rightType.getValue()) {
			            throw new NajaSemanticException("Type mismatch on assigment");
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
	public static class ReadContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(NajaGrammarParser.LEFT_PAREN, 0); }
		public TerminalNode ID() { return getToken(NajaGrammarParser.ID, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(NajaGrammarParser.RIGHT_PAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(NajaGrammarParser.SEMICOLON, 0); }
		public ReadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).enterRead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).exitRead(this);
		}
	}

	public final ReadContext read() throws RecognitionException {
		ReadContext _localctx = new ReadContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_read);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(T__7);
			setState(82);
			match(LEFT_PAREN);
			setState(83);
			match(ID);
			   
			        String lastTokenText = _input.LT(-1).getText();
			        if (!isDeclared(lastTokenText)) {
			            throw new NajaSemanticException("Undeclared Variable: " + lastTokenText);
			        }

			        Var symbol = symbolTable.get(lastTokenText);
			        symbol.setInitialized(true);

			        Command readCommand = new ReadCommand(symbol);
			        stack.peek().add(readCommand);
			    
			setState(85);
			match(RIGHT_PAREN);
			setState(86);
			match(SEMICOLON);
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
	public static class WriteContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(NajaGrammarParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(NajaGrammarParser.RIGHT_PAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(NajaGrammarParser.SEMICOLON, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public WriteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_write; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).enterWrite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).exitWrite(this);
		}
	}

	public final WriteContext write() throws RecognitionException {
		WriteContext _localctx = new WriteContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_write);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(T__8);
			setState(89);
			match(LEFT_PAREN);
			{
			setState(90);
			factor();
			}

			        Command cmdWrite = new WriteCommand(_input.LT(-1).getText());
			        stack.peek().add(cmdWrite);
			    
			setState(92);
			match(RIGHT_PAREN);
			setState(93);
			match(SEMICOLON);

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
	public static class IfContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(NajaGrammarParser.LEFT_PAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMPARISON_OP() { return getToken(NajaGrammarParser.COMPARISON_OP, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(NajaGrammarParser.RIGHT_PAREN, 0); }
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public IfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).exitIf(this);
		}
	}

	public final IfContext if_() throws RecognitionException {
		IfContext _localctx = new IfContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_if);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__9);

			        stack.push(new ArrayList<Command>());
			        expressionStr = "";
			        currentIfCommand = new IfCommand();
			    
			setState(98);
			match(LEFT_PAREN);
			setState(99);
			expression();
			setState(100);
			match(COMPARISON_OP);
			 
			        expressionStr += _input.LT(-1).getText();
			        assignmentStr += _input.LT(-1).getText();
			    
			setState(102);
			expression();
			setState(103);
			match(RIGHT_PAREN);
			 
			        currentIfCommand.setExpression(expressionStr); 
			    
			setState(105);
			match(T__10);
			setState(107); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(106);
				command();
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
					command();
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
	public static class WhileContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(NajaGrammarParser.LEFT_PAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMPARISON_OP() { return getToken(NajaGrammarParser.COMPARISON_OP, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(NajaGrammarParser.RIGHT_PAREN, 0); }
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public WhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).exitWhile(this);
		}
	}

	public final WhileContext while_() throws RecognitionException {
		WhileContext _localctx = new WhileContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_while);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__13);

			        stack.push(new ArrayList<Command>());
			        expressionStr = "";
			        currentWhileCommand = new WhileCommand();
			    
			setState(128);
			match(LEFT_PAREN);
			setState(129);
			expression();
			setState(130);
			match(COMPARISON_OP);

			        expressionStr += _input.LT(-1).getText();
			        assignmentStr += _input.LT(-1).getText();
			    
			setState(132);
			expression();
			setState(133);
			match(RIGHT_PAREN);

			        currentWhileCommand.setExpression(expressionStr);
			    
			setState(135);
			match(T__14);
			setState(137); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(136);
				command();
				}
				}
				setState(139); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8406784L) != 0) );

			        currentWhileCommand.setCommandList(stack.pop());
			    
			setState(142);
			match(T__15);

			        stack.peek().add(currentWhileCommand);
			    
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
	public static class ExpressionContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ExpressionlContext expressionl() {
			return getRuleContext(ExpressionlContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			term();

			        expressionStr += _input.LT(-1).getText();
			        assignmentStr += _input.LT(-1).getText();
			    
			setState(147);
			expressionl();
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
	public static class TermContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TermlContext terml() {
			return getRuleContext(TermlContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			factor();
			setState(150);
			terml();
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
	public static class TermlContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> MULTIPLICATION_OP() { return getTokens(NajaGrammarParser.MULTIPLICATION_OP); }
		public TerminalNode MULTIPLICATION_OP(int i) {
			return getToken(NajaGrammarParser.MULTIPLICATION_OP, i);
		}
		public List<TerminalNode> DIVISION_OP() { return getTokens(NajaGrammarParser.DIVISION_OP); }
		public TerminalNode DIVISION_OP(int i) {
			return getToken(NajaGrammarParser.DIVISION_OP, i);
		}
		public TermlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terml; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).enterTerml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).exitTerml(this);
		}
	}

	public final TermlContext terml() throws RecognitionException {
		TermlContext _localctx = new TermlContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_terml);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULTIPLICATION_OP || _la==DIVISION_OP) {
				{
				{
				setState(152);
				_la = _input.LA(1);
				if ( !(_la==MULTIPLICATION_OP || _la==DIVISION_OP) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				 
				        expressionStr += _input.LT(-1).getText();
				        assignmentStr += _input.LT(-1).getText();
				    
				setState(154);
				factor();
				 
				        expressionStr += _input.LT(-1).getText();
				        assignmentStr += _input.LT(-1).getText();
				    
				}
				}
				setState(161);
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
	public static class ExpressionlContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> SUM_OP() { return getTokens(NajaGrammarParser.SUM_OP); }
		public TerminalNode SUM_OP(int i) {
			return getToken(NajaGrammarParser.SUM_OP, i);
		}
		public List<TerminalNode> SUBTRACTION_OP() { return getTokens(NajaGrammarParser.SUBTRACTION_OP); }
		public TerminalNode SUBTRACTION_OP(int i) {
			return getToken(NajaGrammarParser.SUBTRACTION_OP, i);
		}
		public ExpressionlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).enterExpressionl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).exitExpressionl(this);
		}
	}

	public final ExpressionlContext expressionl() throws RecognitionException {
		ExpressionlContext _localctx = new ExpressionlContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expressionl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SUM_OP || _la==SUBTRACTION_OP) {
				{
				{
				setState(162);
				_la = _input.LA(1);
				if ( !(_la==SUM_OP || _la==SUBTRACTION_OP) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				 
				        expressionStr += _input.LT(-1).getText();
				        assignmentStr += _input.LT(-1).getText();
				    
				setState(164);
				term();
				 
				        expressionStr += _input.LT(-1).getText();
				        assignmentStr += _input.LT(-1).getText();
				    
				}
				}
				setState(171);
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
	public static class FactorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(NajaGrammarParser.ID, 0); }
		public TerminalNode NUM() { return getToken(NajaGrammarParser.NUM, 0); }
		public TerminalNode TEXT() { return getToken(NajaGrammarParser.TEXT, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NajaGrammarListener ) ((NajaGrammarListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_factor);
		try {
			setState(178);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				match(ID);
				 
				        String lastTokenText = _input.LT(-1).getText();
				        if (!isDeclared(lastTokenText)) {
				            throw new NajaSemanticException("Undeclared variable: " + lastTokenText);
				        }

				        Var symbol = symbolTable.get(lastTokenText);
				        if (!symbol.isInitialized()) {
				            throw new NajaSemanticException("Variable: " +lastTokenText + " has no value assigned ");
				        }

				        if (rightType == null){
				            rightType = symbolTable.get(lastTokenText).getType();
				        } else {
				            if (symbolTable.get(lastTokenText).getType().getValue() > rightType.getValue()){
				                rightType = symbolTable.get(lastTokenText).getType();
				            }
				        }
				        
				        symbol.setUsed(true); 
				    
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				match(NUM);
				 
				        if (rightType == null) {
				            rightType = Types.NUMBER;
				        } else {
				            if (rightType.getValue() < Types.NUMBER.getValue()) {
				                rightType = Types.NUMBER;
				            }
				        }
				    
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 3);
				{
				setState(176);
				match(TEXT);
				 
				        if (rightType == null) {
				            rightType = Types.TEXT;
				        } else {
				            if (rightType.getValue() < Types.TEXT.getValue()) {
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
		"\u0004\u0001\u001f\u00b5\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
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
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0004\u0007\u008a\b\u0007\u000b\u0007\f"+
		"\u0007\u008b\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0005\n\u009e\b\n\n\n\f\n\u00a1\t\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00a8\b\u000b\n\u000b"+
		"\f\u000b\u00ab\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0003\f\u00b3\b\f\u0001\f\u0000\u0000\r\u0000\u0002\u0004\u0006\b\n\f"+
		"\u000e\u0010\u0012\u0014\u0016\u0018\u0000\u0002\u0001\u0000\u0013\u0014"+
		"\u0001\u0000\u0011\u0012\u00b7\u0000\u001a\u0001\u0000\u0000\u0000\u0002"+
		",\u0001\u0000\u0000\u0000\u0004G\u0001\u0000\u0000\u0000\u0006I\u0001"+
		"\u0000\u0000\u0000\bQ\u0001\u0000\u0000\u0000\nX\u0001\u0000\u0000\u0000"+
		"\f`\u0001\u0000\u0000\u0000\u000e~\u0001\u0000\u0000\u0000\u0010\u0091"+
		"\u0001\u0000\u0000\u0000\u0012\u0095\u0001\u0000\u0000\u0000\u0014\u009f"+
		"\u0001\u0000\u0000\u0000\u0016\u00a9\u0001\u0000\u0000\u0000\u0018\u00b2"+
		"\u0001\u0000\u0000\u0000\u001a\u001b\u0005\u0001\u0000\u0000\u001b\u001c"+
		"\u0005\u0017\u0000\u0000\u001c\u001e\u0006\u0000\uffff\uffff\u0000\u001d"+
		"\u001f\u0003\u0002\u0001\u0000\u001e\u001d\u0001\u0000\u0000\u0000\u001f"+
		" \u0001\u0000\u0000\u0000 \u001e\u0001\u0000\u0000\u0000 !\u0001\u0000"+
		"\u0000\u0000!\"\u0001\u0000\u0000\u0000\"$\u0005\u0002\u0000\u0000#%\u0003"+
		"\u0004\u0002\u0000$#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000"+
		"&$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000"+
		"\u0000()\u0005\u0003\u0000\u0000)*\u0005\u0004\u0000\u0000*+\u0006\u0000"+
		"\uffff\uffff\u0000+\u0001\u0001\u0000\u0000\u0000,-\u0005\u0005\u0000"+
		"\u0000-.\u0006\u0001\uffff\uffff\u0000./\u0005\u0017\u0000\u0000/5\u0006"+
		"\u0001\uffff\uffff\u000001\u0005\u001d\u0000\u000012\u0005\u0017\u0000"+
		"\u000024\u0006\u0001\uffff\uffff\u000030\u0001\u0000\u0000\u000047\u0001"+
		"\u0000\u0000\u000053\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u0000"+
		"68\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u00008=\u0005\u001f\u0000"+
		"\u00009:\u0005\u0006\u0000\u0000:>\u0006\u0001\uffff\uffff\u0000;<\u0005"+
		"\u0007\u0000\u0000<>\u0006\u0001\uffff\uffff\u0000=9\u0001\u0000\u0000"+
		"\u0000=;\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?@\u0006\u0001"+
		"\uffff\uffff\u0000@A\u0005\u001e\u0000\u0000A\u0003\u0001\u0000\u0000"+
		"\u0000BH\u0003\u0006\u0003\u0000CH\u0003\b\u0004\u0000DH\u0003\n\u0005"+
		"\u0000EH\u0003\f\u0006\u0000FH\u0003\u000e\u0007\u0000GB\u0001\u0000\u0000"+
		"\u0000GC\u0001\u0000\u0000\u0000GD\u0001\u0000\u0000\u0000GE\u0001\u0000"+
		"\u0000\u0000GF\u0001\u0000\u0000\u0000H\u0005\u0001\u0000\u0000\u0000"+
		"IJ\u0005\u0017\u0000\u0000JK\u0006\u0003\uffff\uffff\u0000KL\u0005\u0015"+
		"\u0000\u0000LM\u0003\u0010\b\u0000MN\u0006\u0003\uffff\uffff\u0000NO\u0005"+
		"\u001e\u0000\u0000OP\u0006\u0003\uffff\uffff\u0000P\u0007\u0001\u0000"+
		"\u0000\u0000QR\u0005\b\u0000\u0000RS\u0005\u001b\u0000\u0000ST\u0005\u0017"+
		"\u0000\u0000TU\u0006\u0004\uffff\uffff\u0000UV\u0005\u001c\u0000\u0000"+
		"VW\u0005\u001e\u0000\u0000W\t\u0001\u0000\u0000\u0000XY\u0005\t\u0000"+
		"\u0000YZ\u0005\u001b\u0000\u0000Z[\u0003\u0018\f\u0000[\\\u0006\u0005"+
		"\uffff\uffff\u0000\\]\u0005\u001c\u0000\u0000]^\u0005\u001e\u0000\u0000"+
		"^_\u0006\u0005\uffff\uffff\u0000_\u000b\u0001\u0000\u0000\u0000`a\u0005"+
		"\n\u0000\u0000ab\u0006\u0006\uffff\uffff\u0000bc\u0005\u001b\u0000\u0000"+
		"cd\u0003\u0010\b\u0000de\u0005\u0016\u0000\u0000ef\u0006\u0006\uffff\uffff"+
		"\u0000fg\u0003\u0010\b\u0000gh\u0005\u001c\u0000\u0000hi\u0006\u0006\uffff"+
		"\uffff\u0000ik\u0005\u000b\u0000\u0000jl\u0003\u0004\u0002\u0000kj\u0001"+
		"\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000"+
		"mn\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000oy\u0006\u0006\uffff"+
		"\uffff\u0000pq\u0005\f\u0000\u0000qs\u0006\u0006\uffff\uffff\u0000rt\u0003"+
		"\u0004\u0002\u0000sr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000"+
		"us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000"+
		"\u0000wx\u0006\u0006\uffff\uffff\u0000xz\u0001\u0000\u0000\u0000yp\u0001"+
		"\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000"+
		"{|\u0005\r\u0000\u0000|}\u0006\u0006\uffff\uffff\u0000}\r\u0001\u0000"+
		"\u0000\u0000~\u007f\u0005\u000e\u0000\u0000\u007f\u0080\u0006\u0007\uffff"+
		"\uffff\u0000\u0080\u0081\u0005\u001b\u0000\u0000\u0081\u0082\u0003\u0010"+
		"\b\u0000\u0082\u0083\u0005\u0016\u0000\u0000\u0083\u0084\u0006\u0007\uffff"+
		"\uffff\u0000\u0084\u0085\u0003\u0010\b\u0000\u0085\u0086\u0005\u001c\u0000"+
		"\u0000\u0086\u0087\u0006\u0007\uffff\uffff\u0000\u0087\u0089\u0005\u000f"+
		"\u0000\u0000\u0088\u008a\u0003\u0004\u0002\u0000\u0089\u0088\u0001\u0000"+
		"\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000"+
		"\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0006\u0007\uffff\uffff\u0000\u008e\u008f\u0005"+
		"\u0010\u0000\u0000\u008f\u0090\u0006\u0007\uffff\uffff\u0000\u0090\u000f"+
		"\u0001\u0000\u0000\u0000\u0091\u0092\u0003\u0012\t\u0000\u0092\u0093\u0006"+
		"\b\uffff\uffff\u0000\u0093\u0094\u0003\u0016\u000b\u0000\u0094\u0011\u0001"+
		"\u0000\u0000\u0000\u0095\u0096\u0003\u0018\f\u0000\u0096\u0097\u0003\u0014"+
		"\n\u0000\u0097\u0013\u0001\u0000\u0000\u0000\u0098\u0099\u0007\u0000\u0000"+
		"\u0000\u0099\u009a\u0006\n\uffff\uffff\u0000\u009a\u009b\u0003\u0018\f"+
		"\u0000\u009b\u009c\u0006\n\uffff\uffff\u0000\u009c\u009e\u0001\u0000\u0000"+
		"\u0000\u009d\u0098\u0001\u0000\u0000\u0000\u009e\u00a1\u0001\u0000\u0000"+
		"\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000"+
		"\u0000\u00a0\u0015\u0001\u0000\u0000\u0000\u00a1\u009f\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a3\u0007\u0001\u0000\u0000\u00a3\u00a4\u0006\u000b\uffff"+
		"\uffff\u0000\u00a4\u00a5\u0003\u0012\t\u0000\u00a5\u00a6\u0006\u000b\uffff"+
		"\uffff\u0000\u00a6\u00a8\u0001\u0000\u0000\u0000\u00a7\u00a2\u0001\u0000"+
		"\u0000\u0000\u00a8\u00ab\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000"+
		"\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u0017\u0001\u0000"+
		"\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005\u0017"+
		"\u0000\u0000\u00ad\u00b3\u0006\f\uffff\uffff\u0000\u00ae\u00af\u0005\u0018"+
		"\u0000\u0000\u00af\u00b3\u0006\f\uffff\uffff\u0000\u00b0\u00b1\u0005\u0019"+
		"\u0000\u0000\u00b1\u00b3\u0006\f\uffff\uffff\u0000\u00b2\u00ac\u0001\u0000"+
		"\u0000\u0000\u00b2\u00ae\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000"+
		"\u0000\u0000\u00b3\u0019\u0001\u0000\u0000\u0000\f &5=Gmuy\u008b\u009f"+
		"\u00a9\u00b2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}