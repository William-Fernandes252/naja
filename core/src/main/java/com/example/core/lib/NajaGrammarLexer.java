// Generated from NajaGrammar.g4 by ANTLR 4.3
package com.example.core.lib;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NajaGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__4=1, T__3=2, T__2=3, T__1=4, T__0=5, OP=6, ID=7, NUM=8, VIRG=9, PV=10, 
		DP=11, WS=12;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'"
	};
	public static final String[] ruleNames = {
		"T__4", "T__3", "T__2", "T__1", "T__0", "OP", "ID", "NUM", "VIRG", "PV", 
		"DP", "WS"
	};


	public NajaGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "NajaGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\16`\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\7\bE\n\b\f\b\16\bH\13\b\3"+
		"\t\6\tK\n\t\r\t\16\tL\3\t\3\t\6\tQ\n\t\r\t\16\tR\5\tU\n\t\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\r\3\r\2\2\16\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\3\2\7\5\2,-//\61\61\3\2c|\5\2\62;C\\c|\3\2\62"+
		";\5\2\13\f\17\17\"\"c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3\2\2\2\5 \3\2\2\2\7(\3\2\2\2"+
		"\t/\3\2\2\2\13\67\3\2\2\2\r@\3\2\2\2\17B\3\2\2\2\21J\3\2\2\2\23V\3\2\2"+
		"\2\25X\3\2\2\2\27Z\3\2\2\2\31\\\3\2\2\2\33\34\7v\2\2\34\35\7g\2\2\35\36"+
		"\7z\2\2\36\37\7v\2\2\37\4\3\2\2\2 !\7h\2\2!\"\7k\2\2\"#\7o\2\2#$\7r\2"+
		"\2$%\7t\2\2%&\7q\2\2&\'\7i\2\2\'\6\3\2\2\2()\7p\2\2)*\7w\2\2*+\7o\2\2"+
		"+,\7d\2\2,-\7g\2\2-.\7t\2\2.\b\3\2\2\2/\60\7f\2\2\60\61\7g\2\2\61\62\7"+
		"e\2\2\62\63\7n\2\2\63\64\7c\2\2\64\65\7t\2\2\65\66\7g\2\2\66\n\3\2\2\2"+
		"\678\7r\2\289\7t\2\29:\7q\2\2:;\7i\2\2;<\7t\2\2<=\7c\2\2=>\7o\2\2>?\7"+
		"c\2\2?\f\3\2\2\2@A\t\2\2\2A\16\3\2\2\2BF\t\3\2\2CE\t\4\2\2DC\3\2\2\2E"+
		"H\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\20\3\2\2\2HF\3\2\2\2IK\t\5\2\2JI\3\2\2"+
		"\2KL\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MT\3\2\2\2NP\7\60\2\2OQ\t\5\2\2PO\3\2"+
		"\2\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2SU\3\2\2\2TN\3\2\2\2TU\3\2\2\2U\22\3"+
		"\2\2\2VW\7.\2\2W\24\3\2\2\2XY\7=\2\2Y\26\3\2\2\2Z[\7<\2\2[\30\3\2\2\2"+
		"\\]\t\6\2\2]^\3\2\2\2^_\b\r\2\2_\32\3\2\2\2\b\2DFLRT\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}