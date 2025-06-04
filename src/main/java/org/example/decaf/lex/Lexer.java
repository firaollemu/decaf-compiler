package org.example.decaf.lex;


import java.util.List;
import java.util.ArrayList;

public class Lexer {
    private final String source;
    private final int sourceLen = source.length();
    private final List<Token> tokens;

    private int start;
    private int current;
    private int line;

    public Lexer(String source) {
        this.source = source;
        this.tokens = new ArrayList<>(); // stores all the token values
        this.start = 0;
        this.current = 0;
        this.line = 1;
    }

    // public APIs
    public List<Token> scanTokens() {
        while (!isAtEnd()) {
            start = current;
            scanToken();
        }
        tokens.add(TokenType.EOF)
        return tokens;
    }

    private void scanToken() {
        currChar = advance()

        switch (currChar) {
            case ' ':
            case '\t':
            case '\r':
                break; // all of those cases go the break statement
            case '\n':
                current++;
            case '(':
                addToken(TokenType.LEFT_PARENTHESIS);
                break;
            case ')':
                addToken(TokenType.RIGHT_PARENTHESIS);
            case '{':
                addToken(TokenType.LEFT_BRACE);
            case '}':
                addToken(TokenType.RIGHT_BRACE);
            case ';':
                addToken(TokenType.SEMICOLON);
            case '+':
                addToken(TokenType.PLUS);
            case '-':
                addToken(TokenType.MINUS);
            case '*':
                addToken(TokenType.STAR);
            case '/':
                addToken(TokenType.SLASH);
            case '%':
                addToken(TokenType.MODULO);


        }

    }
    private boolean isAtEnd() {
        return current == sourceLen;
    }

    private char advance() {
       return source.charAt(current++);
    }

    private boolean isDigit(char c) {
        // digit -> [0, 9]
        return false;
    }

    private boolean isAlpha(char c) {
        // alpha -> letters/underscore
        return false;
    }
    private void number() {

    }

    private void identifier() {
        // takes: letters/digits. checks keyword vs. identifier
    }

    private TokenType keywordOrIdentifier(String text) {
        return TokenType.IDENTIFIER;
    }
}