// Generated from BabyDuck.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class BabyDuckParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PROGRAM=1, MAIN=2, END=3, VAR=4, INT=5, FLOAT=6, PRINT=7, WHILE=8, DO=9, 
		IF=10, ELSE=11, VOID=12, ASSIGN=13, PLUS=14, MINUS=15, TIMES=16, DIVIDED=17, 
		SEMICOLON=18, COLON=19, COMMA=20, LTHAN=21, GTHAN=22, LPAREN=23, RPAREN=24, 
		LCURLY=25, RCURLY=26, NEQ=27, CTE_INT=28, CTE_FLOAT=29, CTE_STRING=30, 
		ID=31, WS=32;
	public static final int
		RULE_programa = 0, RULE_vars = 1, RULE_listaIds = 2, RULE_type = 3, RULE_funcs = 4, 
		RULE_body = 5, RULE_statement_list = 6, RULE_statement = 7, RULE_assign_stmt = 8, 
		RULE_print_stmt = 9, RULE_print_list = 10, RULE_condition_stmt = 11, RULE_cycle_stmt = 12, 
		RULE_expresion = 13, RULE_oprel = 14, RULE_exp = 15, RULE_exp_tail = 16, 
		RULE_termino = 17, RULE_termino_tail = 18, RULE_factor = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "vars", "listaIds", "type", "funcs", "body", "statement_list", 
			"statement", "assign_stmt", "print_stmt", "print_list", "condition_stmt", 
			"cycle_stmt", "expresion", "oprel", "exp", "exp_tail", "termino", "termino_tail", 
			"factor"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'program'", "'main'", "'end'", "'var'", "'int'", "'float'", "'print'", 
			"'while'", "'do'", "'if'", "'else'", "'void'", "'='", "'+'", "'-'", "'*'", 
			"'/'", "';'", "':'", "','", "'<'", "'>'", "'('", "')'", "'{'", "'}'", 
			"'!='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PROGRAM", "MAIN", "END", "VAR", "INT", "FLOAT", "PRINT", "WHILE", 
			"DO", "IF", "ELSE", "VOID", "ASSIGN", "PLUS", "MINUS", "TIMES", "DIVIDED", 
			"SEMICOLON", "COLON", "COMMA", "LTHAN", "GTHAN", "LPAREN", "RPAREN", 
			"LCURLY", "RCURLY", "NEQ", "CTE_INT", "CTE_FLOAT", "CTE_STRING", "ID", 
			"WS"
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
	public String getGrammarFileName() { return "BabyDuck.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BabyDuckParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(BabyDuckParser.PROGRAM, 0); }
		public TerminalNode ID() { return getToken(BabyDuckParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(BabyDuckParser.SEMICOLON, 0); }
		public VarsContext vars() {
			return getRuleContext(VarsContext.class,0);
		}
		public FuncsContext funcs() {
			return getRuleContext(FuncsContext.class,0);
		}
		public TerminalNode MAIN() { return getToken(BabyDuckParser.MAIN, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode END() { return getToken(BabyDuckParser.END, 0); }
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyDuckVisitor ) return ((BabyDuckVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(PROGRAM);
			setState(41);
			match(ID);
			setState(42);
			match(SEMICOLON);
			setState(43);
			vars();
			setState(44);
			funcs();
			setState(45);
			match(MAIN);
			setState(46);
			body();
			setState(47);
			match(END);
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
	public static class VarsContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(BabyDuckParser.VAR, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(BabyDuckParser.ID, 0); }
		public ListaIdsContext listaIds() {
			return getRuleContext(ListaIdsContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(BabyDuckParser.SEMICOLON, 0); }
		public VarsContext vars() {
			return getRuleContext(VarsContext.class,0);
		}
		public VarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).enterVars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).exitVars(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyDuckVisitor ) return ((BabyDuckVisitor<? extends T>)visitor).visitVars(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarsContext vars() throws RecognitionException {
		VarsContext _localctx = new VarsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_vars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR) {
				{
				setState(49);
				match(VAR);
				setState(50);
				type();
				setState(51);
				match(ID);
				setState(52);
				listaIds();
				setState(53);
				match(SEMICOLON);
				setState(54);
				vars();
				}
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
	public static class ListaIdsContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(BabyDuckParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BabyDuckParser.COMMA, i);
		}
		public List<TerminalNode> ID() { return getTokens(BabyDuckParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(BabyDuckParser.ID, i);
		}
		public ListaIdsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaIds; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).enterListaIds(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).exitListaIds(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyDuckVisitor ) return ((BabyDuckVisitor<? extends T>)visitor).visitListaIds(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListaIdsContext listaIds() throws RecognitionException {
		ListaIdsContext _localctx = new ListaIdsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_listaIds);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(58);
				match(COMMA);
				setState(59);
				match(ID);
				}
				}
				setState(64);
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
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(BabyDuckParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(BabyDuckParser.FLOAT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyDuckVisitor ) return ((BabyDuckVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==FLOAT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class FuncsContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(BabyDuckParser.VOID, 0); }
		public TerminalNode ID() { return getToken(BabyDuckParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(BabyDuckParser.SEMICOLON, 0); }
		public VarsContext vars() {
			return getRuleContext(VarsContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public FuncsContext funcs() {
			return getRuleContext(FuncsContext.class,0);
		}
		public FuncsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).enterFuncs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).exitFuncs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyDuckVisitor ) return ((BabyDuckVisitor<? extends T>)visitor).visitFuncs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncsContext funcs() throws RecognitionException {
		FuncsContext _localctx = new FuncsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_funcs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VOID) {
				{
				setState(67);
				match(VOID);
				setState(68);
				match(ID);
				setState(69);
				match(SEMICOLON);
				setState(70);
				vars();
				setState(71);
				body();
				setState(72);
				funcs();
				}
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
	public static class BodyContext extends ParserRuleContext {
		public TerminalNode LCURLY() { return getToken(BabyDuckParser.LCURLY, 0); }
		public Statement_listContext statement_list() {
			return getRuleContext(Statement_listContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(BabyDuckParser.RCURLY, 0); }
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyDuckVisitor ) return ((BabyDuckVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(LCURLY);
			setState(77);
			statement_list();
			setState(78);
			match(RCURLY);
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
	public static class Statement_listContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Statement_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).enterStatement_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).exitStatement_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyDuckVisitor ) return ((BabyDuckVisitor<? extends T>)visitor).visitStatement_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_listContext statement_list() throws RecognitionException {
		Statement_listContext _localctx = new Statement_listContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statement_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2147485056L) != 0)) {
				{
				{
				setState(80);
				statement();
				}
				}
				setState(85);
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
	public static class StatementContext extends ParserRuleContext {
		public Assign_stmtContext assign_stmt() {
			return getRuleContext(Assign_stmtContext.class,0);
		}
		public Condition_stmtContext condition_stmt() {
			return getRuleContext(Condition_stmtContext.class,0);
		}
		public Cycle_stmtContext cycle_stmt() {
			return getRuleContext(Cycle_stmtContext.class,0);
		}
		public Print_stmtContext print_stmt() {
			return getRuleContext(Print_stmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyDuckVisitor ) return ((BabyDuckVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		try {
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				assign_stmt();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				condition_stmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(88);
				cycle_stmt();
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 4);
				{
				setState(89);
				print_stmt();
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
	public static class Assign_stmtContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BabyDuckParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(BabyDuckParser.ASSIGN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(BabyDuckParser.SEMICOLON, 0); }
		public Assign_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).enterAssign_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).exitAssign_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyDuckVisitor ) return ((BabyDuckVisitor<? extends T>)visitor).visitAssign_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_stmtContext assign_stmt() throws RecognitionException {
		Assign_stmtContext _localctx = new Assign_stmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assign_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(ID);
			setState(93);
			match(ASSIGN);
			setState(94);
			expresion();
			setState(95);
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
	public static class Print_stmtContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(BabyDuckParser.PRINT, 0); }
		public TerminalNode LPAREN() { return getToken(BabyDuckParser.LPAREN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BabyDuckParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(BabyDuckParser.SEMICOLON, 0); }
		public Print_listContext print_list() {
			return getRuleContext(Print_listContext.class,0);
		}
		public Print_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).enterPrint_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).exitPrint_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyDuckVisitor ) return ((BabyDuckVisitor<? extends T>)visitor).visitPrint_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Print_stmtContext print_stmt() throws RecognitionException {
		Print_stmtContext _localctx = new Print_stmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_print_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(PRINT);
			setState(98);
			match(LPAREN);
			setState(99);
			expresion();
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(100);
				print_list();
				}
				break;
			}
			setState(103);
			match(RPAREN);
			setState(104);
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
	public static class Print_listContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(BabyDuckParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BabyDuckParser.COMMA, i);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public Print_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).enterPrint_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).exitPrint_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyDuckVisitor ) return ((BabyDuckVisitor<? extends T>)visitor).visitPrint_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Print_listContext print_list() throws RecognitionException {
		Print_listContext _localctx = new Print_listContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_print_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(106);
				match(COMMA);
				setState(107);
				expresion();
				}
				}
				setState(112);
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
	public static class Condition_stmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(BabyDuckParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(BabyDuckParser.LPAREN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BabyDuckParser.RPAREN, 0); }
		public List<BodyContext> body() {
			return getRuleContexts(BodyContext.class);
		}
		public BodyContext body(int i) {
			return getRuleContext(BodyContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(BabyDuckParser.ELSE, 0); }
		public Condition_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).enterCondition_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).exitCondition_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyDuckVisitor ) return ((BabyDuckVisitor<? extends T>)visitor).visitCondition_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Condition_stmtContext condition_stmt() throws RecognitionException {
		Condition_stmtContext _localctx = new Condition_stmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_condition_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(IF);
			setState(114);
			match(LPAREN);
			setState(115);
			expresion();
			setState(116);
			match(RPAREN);
			setState(117);
			body();
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(118);
				match(ELSE);
				setState(119);
				body();
				}
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
	public static class Cycle_stmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(BabyDuckParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(BabyDuckParser.LPAREN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BabyDuckParser.RPAREN, 0); }
		public TerminalNode DO() { return getToken(BabyDuckParser.DO, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public Cycle_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cycle_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).enterCycle_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).exitCycle_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyDuckVisitor ) return ((BabyDuckVisitor<? extends T>)visitor).visitCycle_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Cycle_stmtContext cycle_stmt() throws RecognitionException {
		Cycle_stmtContext _localctx = new Cycle_stmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_cycle_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(WHILE);
			setState(123);
			match(LPAREN);
			setState(124);
			expresion();
			setState(125);
			match(RPAREN);
			setState(126);
			match(DO);
			setState(127);
			body();
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
	public static class ExpresionContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public OprelContext oprel() {
			return getRuleContext(OprelContext.class,0);
		}
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).enterExpresion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).exitExpresion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyDuckVisitor ) return ((BabyDuckVisitor<? extends T>)visitor).visitExpresion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpresionContext expresion() throws RecognitionException {
		ExpresionContext _localctx = new ExpresionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expresion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			exp();
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 140509184L) != 0)) {
				{
				setState(130);
				oprel();
				setState(131);
				exp();
				}
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
	public static class OprelContext extends ParserRuleContext {
		public TerminalNode NEQ() { return getToken(BabyDuckParser.NEQ, 0); }
		public TerminalNode LTHAN() { return getToken(BabyDuckParser.LTHAN, 0); }
		public TerminalNode GTHAN() { return getToken(BabyDuckParser.GTHAN, 0); }
		public OprelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oprel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).enterOprel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).exitOprel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyDuckVisitor ) return ((BabyDuckVisitor<? extends T>)visitor).visitOprel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OprelContext oprel() throws RecognitionException {
		OprelContext _localctx = new OprelContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_oprel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 140509184L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class ExpContext extends ParserRuleContext {
		public TerminoContext termino() {
			return getRuleContext(TerminoContext.class,0);
		}
		public Exp_tailContext exp_tail() {
			return getRuleContext(Exp_tailContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).exitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyDuckVisitor ) return ((BabyDuckVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			termino();
			setState(138);
			exp_tail();
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
	public static class Exp_tailContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(BabyDuckParser.PLUS, 0); }
		public TerminoContext termino() {
			return getRuleContext(TerminoContext.class,0);
		}
		public Exp_tailContext exp_tail() {
			return getRuleContext(Exp_tailContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(BabyDuckParser.MINUS, 0); }
		public Exp_tailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).enterExp_tail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).exitExp_tail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyDuckVisitor ) return ((BabyDuckVisitor<? extends T>)visitor).visitExp_tail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp_tailContext exp_tail() throws RecognitionException {
		Exp_tailContext _localctx = new Exp_tailContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_exp_tail);
		int _la;
		try {
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PLUS) {
					{
					setState(140);
					match(PLUS);
					setState(141);
					termino();
					setState(142);
					exp_tail();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(146);
					match(MINUS);
					setState(147);
					termino();
					setState(148);
					exp_tail();
					}
				}

				}
				break;
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
	public static class TerminoContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public Termino_tailContext termino_tail() {
			return getRuleContext(Termino_tailContext.class,0);
		}
		public TerminoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termino; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).enterTermino(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).exitTermino(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyDuckVisitor ) return ((BabyDuckVisitor<? extends T>)visitor).visitTermino(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TerminoContext termino() throws RecognitionException {
		TerminoContext _localctx = new TerminoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_termino);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			factor();
			setState(155);
			termino_tail();
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
	public static class Termino_tailContext extends ParserRuleContext {
		public TerminalNode TIMES() { return getToken(BabyDuckParser.TIMES, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public Termino_tailContext termino_tail() {
			return getRuleContext(Termino_tailContext.class,0);
		}
		public TerminalNode DIVIDED() { return getToken(BabyDuckParser.DIVIDED, 0); }
		public Termino_tailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termino_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).enterTermino_tail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).exitTermino_tail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyDuckVisitor ) return ((BabyDuckVisitor<? extends T>)visitor).visitTermino_tail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Termino_tailContext termino_tail() throws RecognitionException {
		Termino_tailContext _localctx = new Termino_tailContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_termino_tail);
		int _la;
		try {
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TIMES) {
					{
					setState(157);
					match(TIMES);
					setState(158);
					factor();
					setState(159);
					termino_tail();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DIVIDED) {
					{
					setState(163);
					match(DIVIDED);
					setState(164);
					factor();
					setState(165);
					termino_tail();
					}
				}

				}
				break;
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
		public TerminalNode LPAREN() { return getToken(BabyDuckParser.LPAREN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BabyDuckParser.RPAREN, 0); }
		public TerminalNode CTE_INT() { return getToken(BabyDuckParser.CTE_INT, 0); }
		public TerminalNode CTE_FLOAT() { return getToken(BabyDuckParser.CTE_FLOAT, 0); }
		public TerminalNode CTE_STRING() { return getToken(BabyDuckParser.CTE_STRING, 0); }
		public TerminalNode ID() { return getToken(BabyDuckParser.ID, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BabyDuckListener ) ((BabyDuckListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BabyDuckVisitor ) return ((BabyDuckVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_factor);
		try {
			setState(179);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				match(LPAREN);
				setState(172);
				expresion();
				setState(173);
				match(RPAREN);
				}
				break;
			case CTE_INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				match(CTE_INT);
				}
				break;
			case CTE_FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(176);
				match(CTE_FLOAT);
				}
				break;
			case CTE_STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(177);
				match(CTE_STRING);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(178);
				match(ID);
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
		"\u0004\u0001 \u00b6\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u00019\b\u0001\u0001\u0002\u0001\u0002\u0005\u0002=\b\u0002\n\u0002"+
		"\f\u0002@\t\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004K\b"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0005"+
		"\u0006R\b\u0006\n\u0006\f\u0006U\t\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007[\b\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0003\tf\b\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0005\nm\b\n\n\n\f\np\t\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000by\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0086\b\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0003\u0010\u0091\b\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0003\u0010\u0097\b\u0010\u0003\u0010\u0099\b\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0003\u0012\u00a2\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0003\u0012\u00a8\b\u0012\u0003\u0012\u00aa\b\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0003\u0013\u00b4\b\u0013\u0001\u0013\u0000\u0000\u0014"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&\u0000\u0002\u0001\u0000\u0005\u0006\u0002\u0000\u0015"+
		"\u0016\u001b\u001b\u00b6\u0000(\u0001\u0000\u0000\u0000\u00028\u0001\u0000"+
		"\u0000\u0000\u0004>\u0001\u0000\u0000\u0000\u0006A\u0001\u0000\u0000\u0000"+
		"\bJ\u0001\u0000\u0000\u0000\nL\u0001\u0000\u0000\u0000\fS\u0001\u0000"+
		"\u0000\u0000\u000eZ\u0001\u0000\u0000\u0000\u0010\\\u0001\u0000\u0000"+
		"\u0000\u0012a\u0001\u0000\u0000\u0000\u0014n\u0001\u0000\u0000\u0000\u0016"+
		"q\u0001\u0000\u0000\u0000\u0018z\u0001\u0000\u0000\u0000\u001a\u0081\u0001"+
		"\u0000\u0000\u0000\u001c\u0087\u0001\u0000\u0000\u0000\u001e\u0089\u0001"+
		"\u0000\u0000\u0000 \u0098\u0001\u0000\u0000\u0000\"\u009a\u0001\u0000"+
		"\u0000\u0000$\u00a9\u0001\u0000\u0000\u0000&\u00b3\u0001\u0000\u0000\u0000"+
		"()\u0005\u0001\u0000\u0000)*\u0005\u001f\u0000\u0000*+\u0005\u0012\u0000"+
		"\u0000+,\u0003\u0002\u0001\u0000,-\u0003\b\u0004\u0000-.\u0005\u0002\u0000"+
		"\u0000./\u0003\n\u0005\u0000/0\u0005\u0003\u0000\u00000\u0001\u0001\u0000"+
		"\u0000\u000012\u0005\u0004\u0000\u000023\u0003\u0006\u0003\u000034\u0005"+
		"\u001f\u0000\u000045\u0003\u0004\u0002\u000056\u0005\u0012\u0000\u0000"+
		"67\u0003\u0002\u0001\u000079\u0001\u0000\u0000\u000081\u0001\u0000\u0000"+
		"\u000089\u0001\u0000\u0000\u00009\u0003\u0001\u0000\u0000\u0000:;\u0005"+
		"\u0014\u0000\u0000;=\u0005\u001f\u0000\u0000<:\u0001\u0000\u0000\u0000"+
		"=@\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000"+
		"\u0000?\u0005\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000AB\u0007"+
		"\u0000\u0000\u0000B\u0007\u0001\u0000\u0000\u0000CD\u0005\f\u0000\u0000"+
		"DE\u0005\u001f\u0000\u0000EF\u0005\u0012\u0000\u0000FG\u0003\u0002\u0001"+
		"\u0000GH\u0003\n\u0005\u0000HI\u0003\b\u0004\u0000IK\u0001\u0000\u0000"+
		"\u0000JC\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000K\t\u0001\u0000"+
		"\u0000\u0000LM\u0005\u0019\u0000\u0000MN\u0003\f\u0006\u0000NO\u0005\u001a"+
		"\u0000\u0000O\u000b\u0001\u0000\u0000\u0000PR\u0003\u000e\u0007\u0000"+
		"QP\u0001\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000"+
		"\u0000ST\u0001\u0000\u0000\u0000T\r\u0001\u0000\u0000\u0000US\u0001\u0000"+
		"\u0000\u0000V[\u0003\u0010\b\u0000W[\u0003\u0016\u000b\u0000X[\u0003\u0018"+
		"\f\u0000Y[\u0003\u0012\t\u0000ZV\u0001\u0000\u0000\u0000ZW\u0001\u0000"+
		"\u0000\u0000ZX\u0001\u0000\u0000\u0000ZY\u0001\u0000\u0000\u0000[\u000f"+
		"\u0001\u0000\u0000\u0000\\]\u0005\u001f\u0000\u0000]^\u0005\r\u0000\u0000"+
		"^_\u0003\u001a\r\u0000_`\u0005\u0012\u0000\u0000`\u0011\u0001\u0000\u0000"+
		"\u0000ab\u0005\u0007\u0000\u0000bc\u0005\u0017\u0000\u0000ce\u0003\u001a"+
		"\r\u0000df\u0003\u0014\n\u0000ed\u0001\u0000\u0000\u0000ef\u0001\u0000"+
		"\u0000\u0000fg\u0001\u0000\u0000\u0000gh\u0005\u0018\u0000\u0000hi\u0005"+
		"\u0012\u0000\u0000i\u0013\u0001\u0000\u0000\u0000jk\u0005\u0014\u0000"+
		"\u0000km\u0003\u001a\r\u0000lj\u0001\u0000\u0000\u0000mp\u0001\u0000\u0000"+
		"\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000o\u0015\u0001"+
		"\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000qr\u0005\n\u0000\u0000rs\u0005"+
		"\u0017\u0000\u0000st\u0003\u001a\r\u0000tu\u0005\u0018\u0000\u0000ux\u0003"+
		"\n\u0005\u0000vw\u0005\u000b\u0000\u0000wy\u0003\n\u0005\u0000xv\u0001"+
		"\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000y\u0017\u0001\u0000\u0000"+
		"\u0000z{\u0005\b\u0000\u0000{|\u0005\u0017\u0000\u0000|}\u0003\u001a\r"+
		"\u0000}~\u0005\u0018\u0000\u0000~\u007f\u0005\t\u0000\u0000\u007f\u0080"+
		"\u0003\n\u0005\u0000\u0080\u0019\u0001\u0000\u0000\u0000\u0081\u0085\u0003"+
		"\u001e\u000f\u0000\u0082\u0083\u0003\u001c\u000e\u0000\u0083\u0084\u0003"+
		"\u001e\u000f\u0000\u0084\u0086\u0001\u0000\u0000\u0000\u0085\u0082\u0001"+
		"\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u001b\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0007\u0001\u0000\u0000\u0088\u001d\u0001"+
		"\u0000\u0000\u0000\u0089\u008a\u0003\"\u0011\u0000\u008a\u008b\u0003 "+
		"\u0010\u0000\u008b\u001f\u0001\u0000\u0000\u0000\u008c\u008d\u0005\u000e"+
		"\u0000\u0000\u008d\u008e\u0003\"\u0011\u0000\u008e\u008f\u0003 \u0010"+
		"\u0000\u008f\u0091\u0001\u0000\u0000\u0000\u0090\u008c\u0001\u0000\u0000"+
		"\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0099\u0001\u0000\u0000"+
		"\u0000\u0092\u0093\u0005\u000f\u0000\u0000\u0093\u0094\u0003\"\u0011\u0000"+
		"\u0094\u0095\u0003 \u0010\u0000\u0095\u0097\u0001\u0000\u0000\u0000\u0096"+
		"\u0092\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097"+
		"\u0099\u0001\u0000\u0000\u0000\u0098\u0090\u0001\u0000\u0000\u0000\u0098"+
		"\u0096\u0001\u0000\u0000\u0000\u0099!\u0001\u0000\u0000\u0000\u009a\u009b"+
		"\u0003&\u0013\u0000\u009b\u009c\u0003$\u0012\u0000\u009c#\u0001\u0000"+
		"\u0000\u0000\u009d\u009e\u0005\u0010\u0000\u0000\u009e\u009f\u0003&\u0013"+
		"\u0000\u009f\u00a0\u0003$\u0012\u0000\u00a0\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a1\u009d\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a2\u00aa\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005\u0011\u0000\u0000"+
		"\u00a4\u00a5\u0003&\u0013\u0000\u00a5\u00a6\u0003$\u0012\u0000\u00a6\u00a8"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a3\u0001\u0000\u0000\u0000\u00a7\u00a8"+
		"\u0001\u0000\u0000\u0000\u00a8\u00aa\u0001\u0000\u0000\u0000\u00a9\u00a1"+
		"\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00aa%\u0001"+
		"\u0000\u0000\u0000\u00ab\u00ac\u0005\u0017\u0000\u0000\u00ac\u00ad\u0003"+
		"\u001a\r\u0000\u00ad\u00ae\u0005\u0018\u0000\u0000\u00ae\u00b4\u0001\u0000"+
		"\u0000\u0000\u00af\u00b4\u0005\u001c\u0000\u0000\u00b0\u00b4\u0005\u001d"+
		"\u0000\u0000\u00b1\u00b4\u0005\u001e\u0000\u0000\u00b2\u00b4\u0005\u001f"+
		"\u0000\u0000\u00b3\u00ab\u0001\u0000\u0000\u0000\u00b3\u00af\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b0\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b4\'\u0001\u0000\u0000"+
		"\u0000\u00108>JSZenx\u0085\u0090\u0096\u0098\u00a1\u00a7\u00a9\u00b3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}