```java
void Let::pretty_print_at(std::ostream &outPutStream, precedence_t precedenceParen, std::streampos& lastNewline) {
    // Accumulate whether Let forms need parentheses
    bool letNeedsParen = precedenceParen >= prec_let;

    // Write the first line
    if (lastNewline != std::streampos(-1)) {
        outPutStream << std::setw(outPutStream.tellp() - lastNewline.seekpos()) << " ";
    }
    outPutStream << "_let " << name_ << " = ";
    body_->pretty_print_at(outPutStream, prec_none, lastNewline);
    outPutStream << std::endl;

    // Write the second line
    outPutStream << std::setw(outPutStream.tellp() - lastNewline.seekpos()) << " ";
    outPutStream << "_in";
    lastNewline = outPutStream.tellp();
    if (letNeedsParen) {
        outPutStream << " (";
    }
    outPutStream << " ";

    // Print the body of the Let expression
    expr_->pretty_print_at(outPutStream, prec_let, lastNewline);

    if (letNeedsParen) {
        outPutStream << ")";
    }
}

void Let::pretty_print(std::ostream &outPutStream) {
    std::streampos lastNewline = -1;
    pretty_print_at(outPutStream, prec_none, lastNewline);
}

```

```java
void Let::pretty_print_at(std::ostream &outPutStream, precedence_t precedenceParen,
                           std::streampos &last_newline, int indent_depth) {
  // if let is immediately nested as the left argument of a + or * expression, or if it would have
  // needed parentheses in the surrounding context, add parentheses
  if (precedenceParen >= prec_add || (precedenceParen >= prec_mul && !rhs_->has_parens())) {
    outPutStream << "(";
  }

  // print the 'let' keyword
  outPutStream << "_let " << name_ << " = ";

  // print the let's value with no precedence restrictions
  value_->pretty_print_at(outPutStream, prec_none, last_newline, indent_depth);

  // print the 'in' keyword on a new line, indented with enough spaces
  outPutStream << "\n";
  for (int i = 0; i < indent_depth + 4; ++i) {
    outPutStream << " ";
  }
  outPutStream << "_in  ";

  // print the body of the let expression with appropriate precedence
  body_->pretty_print_at(outPutStream, prec_add, last_newline, indent_depth + 4);

  // close the parentheses if added
  if (precedenceParen >= prec_add || (precedenceParen >= prec_mul && !rhs_->has_parens())) {
    outPutStream << ")";
  }
}

void Let::pretty_print(std::ostream &outPutStream) {
  std::streampos last_newline = 0;
  pretty_print_at(outPutStream, prec_none, last_newline, 0);
}

```

