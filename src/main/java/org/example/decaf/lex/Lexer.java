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

        if (Character.isDigit(currChar)) {
            String digits = getAllInt();
            addToken(TokenType.INT_LITERAL, digits);
            return;
        } else if (currChar == '"') {
            // dealing with a string literal
            String litral = getString();
            addToken(TokenType.STRING_LITERAL, literal);
            return;
        }

        else if (Character.isLetter(currChar) || currChar == '_') {
            // dealing with an IDENTIFIER (variable/function name)
            String identifierName = getIdentifier();
            addToken(TokenType.STRING_LITERAL, identifierName);
            return;
        } else {
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
                    break;
                case '{':
                    addToken(TokenType.LEFT_BRACE);
                    break;
                case '}':
                    addToken(TokenType.RIGHT_BRACE);
                    break;
                case ';':
                    addToken(TokenType.SEMICOLON);
                    break;
                case '+':
                    addToken(TokenType.PLUS);
                    break;
                case '-':
                    addToken(TokenType.MINUS);
                    break;
                case '*':
                    addToken(TokenType.STAR);
                    break;
                case '/':
                    addToken(TokenType.SLASH);
                    break;
                case '%':
                    addToken(TokenType.MODULO);
                    break;
                    }
                }
    }

    private String getInt() {
        int counter = current;
        String currDigits = "" + source.charAt(current);
        while (!isAtEnd() && Character.isDigit(source.charAt(counter + 1))) {
            currDigits += source.charAt(counter + 1);
            counter++;
        }
        current = counter + 1; // done with digits
    }
    private String getString() {
        String currString = '' + source.charAt(current);
        while (!isAtEnd() && peek() != '"') {
            if (peek() == '\n') {
                line++;
            }
           currString += advance();
        }
        currString += advance() // add the closing "
        return currString;
    }
    private String getIdentifier() {
        String currIdentifier = '' + source.charAt(current);

        while (Character.isDigit(source.charAt()))
            // IMPLEMENT GETIDENTIFER

    }
    private boolean isAtEnd() {
        return current == sourceLen;
    }

    private char peek() {
        if (isAtEnd()) {
            return '\0';
        }
        return source.charAt(current);
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