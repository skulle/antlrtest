package com.example;

import com.example.g4.ArithmeticBaseVisitor;
import com.example.g4.ArithmeticParser;
import com.example.g4.ArithmeticParser.GROUPContext;
import com.example.g4.ArithmeticParser.INTEGERContext;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class ArithmeticVisitor extends ArithmeticBaseVisitor<Integer> {

    private Map<String, BinaryOperator<Integer>> operatorMap;

    ArithmeticVisitor() {
        createOperationMap();
    }

    private void createOperationMap(){
        operatorMap = new HashMap<>();
        operatorMap.put("+", Integer::sum);
        operatorMap.put("-", (x, y) -> x - y);
        operatorMap.put("*", (x, y) -> x * y);
        operatorMap.put("/", (x, y) -> x / y);
    }

    private Integer eval(String op, Integer left, Integer right){
        return operatorMap.get(op).apply(left, right);
    }

    @Override
    public Integer visitDOTOP(ArithmeticParser.DOTOPContext ctx) {
        String op = ctx.dotop().getText();
        Integer left = visit(ctx.expr(0));
        Integer right = visit(ctx.expr(1));

        return eval(op, left, right);
    }

    @Override
    public Integer visitDASHOP(ArithmeticParser.DASHOPContext ctx) {
        String op = ctx.dashop().getText();
        Integer left = visit(ctx.expr(0));
        Integer right = visit(ctx.expr(1));

        return eval(op, left, right);
    }

    @Override
    public Integer visitGROUP(GROUPContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Integer visitINTEGER(INTEGERContext ctx) {
        return Integer.valueOf(ctx.NUMBER().getText());
    }
}
