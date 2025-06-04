package org.example.decaf.lex;

public enum TokenType {
    LEFT_PARENTHESIS,
    RIGHT_PARENTHESIS,
    LEFT_BRACE,
    RIGHT_BRACE,
    SEMICOLON,

    // Operators
    PLUS,
    MINUS,
    STAR, // *
    SLASH, // division

    MODULO,

    IDENTIFIER, // var names/function names
    INT_LITERAL,
    STRING_LITERAL

    // KEYWORDS
    IF,
    ELSE,
    RETURN,
    CLASS,

    EOF
}