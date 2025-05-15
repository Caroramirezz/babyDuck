// Generated from BabyDuck.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BabyDuckParser}.
 */
public interface BabyDuckListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BabyDuckParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(BabyDuckParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyDuckParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(BabyDuckParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyDuckParser#vars}.
	 * @param ctx the parse tree
	 */
	void enterVars(BabyDuckParser.VarsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyDuckParser#vars}.
	 * @param ctx the parse tree
	 */
	void exitVars(BabyDuckParser.VarsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyDuckParser#listaIds}.
	 * @param ctx the parse tree
	 */
	void enterListaIds(BabyDuckParser.ListaIdsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyDuckParser#listaIds}.
	 * @param ctx the parse tree
	 */
	void exitListaIds(BabyDuckParser.ListaIdsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyDuckParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(BabyDuckParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyDuckParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(BabyDuckParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyDuckParser#funcs}.
	 * @param ctx the parse tree
	 */
	void enterFuncs(BabyDuckParser.FuncsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyDuckParser#funcs}.
	 * @param ctx the parse tree
	 */
	void exitFuncs(BabyDuckParser.FuncsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyDuckParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(BabyDuckParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyDuckParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(BabyDuckParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyDuckParser#statement_list}.
	 * @param ctx the parse tree
	 */
	void enterStatement_list(BabyDuckParser.Statement_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyDuckParser#statement_list}.
	 * @param ctx the parse tree
	 */
	void exitStatement_list(BabyDuckParser.Statement_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyDuckParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(BabyDuckParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyDuckParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(BabyDuckParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyDuckParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign_stmt(BabyDuckParser.Assign_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyDuckParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign_stmt(BabyDuckParser.Assign_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyDuckParser#print_stmt}.
	 * @param ctx the parse tree
	 */
	void enterPrint_stmt(BabyDuckParser.Print_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyDuckParser#print_stmt}.
	 * @param ctx the parse tree
	 */
	void exitPrint_stmt(BabyDuckParser.Print_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyDuckParser#print_list}.
	 * @param ctx the parse tree
	 */
	void enterPrint_list(BabyDuckParser.Print_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyDuckParser#print_list}.
	 * @param ctx the parse tree
	 */
	void exitPrint_list(BabyDuckParser.Print_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyDuckParser#condition_stmt}.
	 * @param ctx the parse tree
	 */
	void enterCondition_stmt(BabyDuckParser.Condition_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyDuckParser#condition_stmt}.
	 * @param ctx the parse tree
	 */
	void exitCondition_stmt(BabyDuckParser.Condition_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyDuckParser#cycle_stmt}.
	 * @param ctx the parse tree
	 */
	void enterCycle_stmt(BabyDuckParser.Cycle_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyDuckParser#cycle_stmt}.
	 * @param ctx the parse tree
	 */
	void exitCycle_stmt(BabyDuckParser.Cycle_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyDuckParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(BabyDuckParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyDuckParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(BabyDuckParser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyDuckParser#oprel}.
	 * @param ctx the parse tree
	 */
	void enterOprel(BabyDuckParser.OprelContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyDuckParser#oprel}.
	 * @param ctx the parse tree
	 */
	void exitOprel(BabyDuckParser.OprelContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyDuckParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(BabyDuckParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyDuckParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(BabyDuckParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyDuckParser#exp_tail}.
	 * @param ctx the parse tree
	 */
	void enterExp_tail(BabyDuckParser.Exp_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyDuckParser#exp_tail}.
	 * @param ctx the parse tree
	 */
	void exitExp_tail(BabyDuckParser.Exp_tailContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyDuckParser#termino}.
	 * @param ctx the parse tree
	 */
	void enterTermino(BabyDuckParser.TerminoContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyDuckParser#termino}.
	 * @param ctx the parse tree
	 */
	void exitTermino(BabyDuckParser.TerminoContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyDuckParser#termino_tail}.
	 * @param ctx the parse tree
	 */
	void enterTermino_tail(BabyDuckParser.Termino_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyDuckParser#termino_tail}.
	 * @param ctx the parse tree
	 */
	void exitTermino_tail(BabyDuckParser.Termino_tailContext ctx);
	/**
	 * Enter a parse tree produced by {@link BabyDuckParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(BabyDuckParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BabyDuckParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(BabyDuckParser.FactorContext ctx);
}