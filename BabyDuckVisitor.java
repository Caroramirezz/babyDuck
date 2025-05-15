// Generated from BabyDuck.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BabyDuckParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BabyDuckVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BabyDuckParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(BabyDuckParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyDuckParser#vars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVars(BabyDuckParser.VarsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyDuckParser#listaIds}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaIds(BabyDuckParser.ListaIdsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyDuckParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(BabyDuckParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyDuckParser#funcs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncs(BabyDuckParser.FuncsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyDuckParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(BabyDuckParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyDuckParser#statement_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_list(BabyDuckParser.Statement_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyDuckParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(BabyDuckParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyDuckParser#assign_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_stmt(BabyDuckParser.Assign_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyDuckParser#print_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint_stmt(BabyDuckParser.Print_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyDuckParser#print_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint_list(BabyDuckParser.Print_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyDuckParser#condition_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_stmt(BabyDuckParser.Condition_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyDuckParser#cycle_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCycle_stmt(BabyDuckParser.Cycle_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyDuckParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(BabyDuckParser.ExpresionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyDuckParser#oprel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOprel(BabyDuckParser.OprelContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyDuckParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(BabyDuckParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyDuckParser#exp_tail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_tail(BabyDuckParser.Exp_tailContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyDuckParser#termino}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermino(BabyDuckParser.TerminoContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyDuckParser#termino_tail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermino_tail(BabyDuckParser.Termino_tailContext ctx);
	/**
	 * Visit a parse tree produced by {@link BabyDuckParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(BabyDuckParser.FactorContext ctx);
}