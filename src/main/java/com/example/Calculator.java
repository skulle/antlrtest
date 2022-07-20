package com.example;

import com.example.g4.ArithmeticLexer;
import com.example.g4.ArithmeticParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Calculator {

    public Integer compute(String expression) {
        CodePointCharStream input = CharStreams.fromString(expression);
        ArithmeticParser parser = new ArithmeticParser(new CommonTokenStream(new ArithmeticLexer(input)));
        ParseTree tree = parser.start();

        ArithmeticVisitor visitor = new ArithmeticVisitor();
        return visitor.visit(tree);
    }

}
