// Generated from NajaGrammar.g4 by ANTLR 4.13.2
package com.example.naja.core.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import com.example.naja.core.types.*;
import com.example.naja.core.exceptions.*;
import com.example.naja.core.ast.*;
import com.example.naja.core.runtime.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class NajaGrammarLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "SUM_OP", 
			"SUBTRACTION_OP", "MULTIPLICATION_OP", "DIVISION_OP", "ASSIGNMENT_OP", 
			"COMPARISON_OP", "ID", "NUM", "TEXT", "WHITE_SPACE", "LEFT_PAREN", "RIGHT_PAREN", 
			"COMMA", "SEMICOLON", "COLON"
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


	private HashMap <String,Var> symbolTable = new HashMap<String, Var>();
	private ArrayList <Var> currentDec = new ArrayList<Var>();
	private Types currentType;
	private Types leftType = null , rightType = null;
	private Program program = new Program();
	private String expressionStr = "";
	private String assignmentStr = "";
	private IfCommand currentIfCommand;
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


	public NajaGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "NajaGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u001f\u00e1\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d"+
		"\u0002\u001e\u0007\u001e\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u00b5\b\u0015\u0001\u0016"+
		"\u0001\u0016\u0005\u0016\u00b9\b\u0016\n\u0016\f\u0016\u00bc\t\u0016\u0001"+
		"\u0017\u0004\u0017\u00bf\b\u0017\u000b\u0017\f\u0017\u00c0\u0001\u0017"+
		"\u0001\u0017\u0004\u0017\u00c5\b\u0017\u000b\u0017\f\u0017\u00c6\u0003"+
		"\u0017\u00c9\b\u0017\u0001\u0018\u0001\u0018\u0005\u0018\u00cd\b\u0018"+
		"\n\u0018\f\u0018\u00d0\t\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001e\u0001"+
		"\u001e\u0000\u0000\u001f\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"+
		"\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'"+
		"\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d"+
		";\u001e=\u001f\u0001\u0000\u0006\u0002\u0000<<>>\u0001\u0000az\u0003\u0000"+
		"09AZaz\u0001\u000009\u0005\u0000  ,.09AZaz\u0003\u0000\t\n\r\r  \u00e9"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000"+
		"\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/"+
		"\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000"+
		"\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000"+
		"\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000="+
		"\u0001\u0000\u0000\u0000\u0001?\u0001\u0000\u0000\u0000\u0003G\u0001\u0000"+
		"\u0000\u0000\u0005M\u0001\u0000\u0000\u0000\u0007Q\u0001\u0000\u0000\u0000"+
		"\t\\\u0001\u0000\u0000\u0000\u000bd\u0001\u0000\u0000\u0000\rk\u0001\u0000"+
		"\u0000\u0000\u000fp\u0001\u0000\u0000\u0000\u0011u\u0001\u0000\u0000\u0000"+
		"\u0013{\u0001\u0000\u0000\u0000\u0015~\u0001\u0000\u0000\u0000\u0017\u0083"+
		"\u0001\u0000\u0000\u0000\u0019\u0088\u0001\u0000\u0000\u0000\u001b\u008e"+
		"\u0001\u0000\u0000\u0000\u001d\u0094\u0001\u0000\u0000\u0000\u001f\u0097"+
		"\u0001\u0000\u0000\u0000!\u00a0\u0001\u0000\u0000\u0000#\u00a2\u0001\u0000"+
		"\u0000\u0000%\u00a4\u0001\u0000\u0000\u0000\'\u00a6\u0001\u0000\u0000"+
		"\u0000)\u00a8\u0001\u0000\u0000\u0000+\u00b4\u0001\u0000\u0000\u0000-"+
		"\u00b6\u0001\u0000\u0000\u0000/\u00be\u0001\u0000\u0000\u00001\u00ca\u0001"+
		"\u0000\u0000\u00003\u00d3\u0001\u0000\u0000\u00005\u00d7\u0001\u0000\u0000"+
		"\u00007\u00d9\u0001\u0000\u0000\u00009\u00db\u0001\u0000\u0000\u0000;"+
		"\u00dd\u0001\u0000\u0000\u0000=\u00df\u0001\u0000\u0000\u0000?@\u0005"+
		"p\u0000\u0000@A\u0005r\u0000\u0000AB\u0005o\u0000\u0000BC\u0005g\u0000"+
		"\u0000CD\u0005r\u0000\u0000DE\u0005a\u0000\u0000EF\u0005m\u0000\u0000"+
		"F\u0002\u0001\u0000\u0000\u0000GH\u0005b\u0000\u0000HI\u0005e\u0000\u0000"+
		"IJ\u0005g\u0000\u0000JK\u0005i\u0000\u0000KL\u0005n\u0000\u0000L\u0004"+
		"\u0001\u0000\u0000\u0000MN\u0005e\u0000\u0000NO\u0005n\u0000\u0000OP\u0005"+
		"d\u0000\u0000P\u0006\u0001\u0000\u0000\u0000QR\u0005e\u0000\u0000RS\u0005"+
		"n\u0000\u0000ST\u0005d\u0000\u0000TU\u0005p\u0000\u0000UV\u0005r\u0000"+
		"\u0000VW\u0005o\u0000\u0000WX\u0005g\u0000\u0000XY\u0005r\u0000\u0000"+
		"YZ\u0005a\u0000\u0000Z[\u0005m\u0000\u0000[\b\u0001\u0000\u0000\u0000"+
		"\\]\u0005d\u0000\u0000]^\u0005e\u0000\u0000^_\u0005c\u0000\u0000_`\u0005"+
		"l\u0000\u0000`a\u0005a\u0000\u0000ab\u0005r\u0000\u0000bc\u0005e\u0000"+
		"\u0000c\n\u0001\u0000\u0000\u0000de\u0005n\u0000\u0000ef\u0005u\u0000"+
		"\u0000fg\u0005m\u0000\u0000gh\u0005b\u0000\u0000hi\u0005e\u0000\u0000"+
		"ij\u0005r\u0000\u0000j\f\u0001\u0000\u0000\u0000kl\u0005t\u0000\u0000"+
		"lm\u0005e\u0000\u0000mn\u0005x\u0000\u0000no\u0005t\u0000\u0000o\u000e"+
		"\u0001\u0000\u0000\u0000pq\u0005r\u0000\u0000qr\u0005e\u0000\u0000rs\u0005"+
		"a\u0000\u0000st\u0005d\u0000\u0000t\u0010\u0001\u0000\u0000\u0000uv\u0005"+
		"w\u0000\u0000vw\u0005r\u0000\u0000wx\u0005i\u0000\u0000xy\u0005t\u0000"+
		"\u0000yz\u0005e\u0000\u0000z\u0012\u0001\u0000\u0000\u0000{|\u0005i\u0000"+
		"\u0000|}\u0005f\u0000\u0000}\u0014\u0001\u0000\u0000\u0000~\u007f\u0005"+
		"t\u0000\u0000\u007f\u0080\u0005h\u0000\u0000\u0080\u0081\u0005e\u0000"+
		"\u0000\u0081\u0082\u0005n\u0000\u0000\u0082\u0016\u0001\u0000\u0000\u0000"+
		"\u0083\u0084\u0005e\u0000\u0000\u0084\u0085\u0005l\u0000\u0000\u0085\u0086"+
		"\u0005s\u0000\u0000\u0086\u0087\u0005e\u0000\u0000\u0087\u0018\u0001\u0000"+
		"\u0000\u0000\u0088\u0089\u0005e\u0000\u0000\u0089\u008a\u0005n\u0000\u0000"+
		"\u008a\u008b\u0005d\u0000\u0000\u008b\u008c\u0005i\u0000\u0000\u008c\u008d"+
		"\u0005f\u0000\u0000\u008d\u001a\u0001\u0000\u0000\u0000\u008e\u008f\u0005"+
		"w\u0000\u0000\u008f\u0090\u0005h\u0000\u0000\u0090\u0091\u0005i\u0000"+
		"\u0000\u0091\u0092\u0005l\u0000\u0000\u0092\u0093\u0005e\u0000\u0000\u0093"+
		"\u001c\u0001\u0000\u0000\u0000\u0094\u0095\u0005d\u0000\u0000\u0095\u0096"+
		"\u0005o\u0000\u0000\u0096\u001e\u0001\u0000\u0000\u0000\u0097\u0098\u0005"+
		"e\u0000\u0000\u0098\u0099\u0005n\u0000\u0000\u0099\u009a\u0005d\u0000"+
		"\u0000\u009a\u009b\u0005w\u0000\u0000\u009b\u009c\u0005h\u0000\u0000\u009c"+
		"\u009d\u0005i\u0000\u0000\u009d\u009e\u0005l\u0000\u0000\u009e\u009f\u0005"+
		"e\u0000\u0000\u009f \u0001\u0000\u0000\u0000\u00a0\u00a1\u0005+\u0000"+
		"\u0000\u00a1\"\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005-\u0000\u0000"+
		"\u00a3$\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005*\u0000\u0000\u00a5&"+
		"\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005/\u0000\u0000\u00a7(\u0001\u0000"+
		"\u0000\u0000\u00a8\u00a9\u0005:\u0000\u0000\u00a9\u00aa\u0005=\u0000\u0000"+
		"\u00aa*\u0001\u0000\u0000\u0000\u00ab\u00b5\u0007\u0000\u0000\u0000\u00ac"+
		"\u00ad\u0005>\u0000\u0000\u00ad\u00b5\u0005=\u0000\u0000\u00ae\u00af\u0005"+
		"<\u0000\u0000\u00af\u00b5\u0005=\u0000\u0000\u00b0\u00b1\u0005<\u0000"+
		"\u0000\u00b1\u00b5\u0005>\u0000\u0000\u00b2\u00b3\u0005=\u0000\u0000\u00b3"+
		"\u00b5\u0005=\u0000\u0000\u00b4\u00ab\u0001\u0000\u0000\u0000\u00b4\u00ac"+
		"\u0001\u0000\u0000\u0000\u00b4\u00ae\u0001\u0000\u0000\u0000\u00b4\u00b0"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b5,\u0001"+
		"\u0000\u0000\u0000\u00b6\u00ba\u0007\u0001\u0000\u0000\u00b7\u00b9\u0007"+
		"\u0002\u0000\u0000\u00b8\u00b7\u0001\u0000\u0000\u0000\u00b9\u00bc\u0001"+
		"\u0000\u0000\u0000\u00ba\u00b8\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001"+
		"\u0000\u0000\u0000\u00bb.\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000"+
		"\u0000\u0000\u00bd\u00bf\u0007\u0003\u0000\u0000\u00be\u00bd\u0001\u0000"+
		"\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u00be\u0001\u0000"+
		"\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1\u00c8\u0001\u0000"+
		"\u0000\u0000\u00c2\u00c4\u0005.\u0000\u0000\u00c3\u00c5\u0007\u0003\u0000"+
		"\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000"+
		"\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000"+
		"\u0000\u00c7\u00c9\u0001\u0000\u0000\u0000\u00c8\u00c2\u0001\u0000\u0000"+
		"\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c90\u0001\u0000\u0000\u0000"+
		"\u00ca\u00ce\u0005\"\u0000\u0000\u00cb\u00cd\u0007\u0004\u0000\u0000\u00cc"+
		"\u00cb\u0001\u0000\u0000\u0000\u00cd\u00d0\u0001\u0000\u0000\u0000\u00ce"+
		"\u00cc\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d1\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d1"+
		"\u00d2\u0005\"\u0000\u0000\u00d22\u0001\u0000\u0000\u0000\u00d3\u00d4"+
		"\u0007\u0005\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d6"+
		"\u0006\u0019\u0000\u0000\u00d64\u0001\u0000\u0000\u0000\u00d7\u00d8\u0005"+
		"(\u0000\u0000\u00d86\u0001\u0000\u0000\u0000\u00d9\u00da\u0005)\u0000"+
		"\u0000\u00da8\u0001\u0000\u0000\u0000\u00db\u00dc\u0005,\u0000\u0000\u00dc"+
		":\u0001\u0000\u0000\u0000\u00dd\u00de\u0005;\u0000\u0000\u00de<\u0001"+
		"\u0000\u0000\u0000\u00df\u00e0\u0005:\u0000\u0000\u00e0>\u0001\u0000\u0000"+
		"\u0000\t\u0000\u00b4\u00b8\u00ba\u00c0\u00c6\u00c8\u00cc\u00ce\u0001\u0006"+
		"\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}