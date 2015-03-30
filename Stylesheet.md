##Header
The code must contain a header at the start of class containing the class name and a brief description.
The header must to be in the style / * ... * /

##Declaration of packages
The first line is not commented it is the Package declaration and it must follow the
pattern: package name without any special characters, if the package name
has two words, type
together with the first letter of the second word in
capital.
As follows suit: <code> PackageName </ code>

##Declaration of classes and interfaces

|Declaration of Class / interface parts||
|-------------------------|----------------------|
|Documentation comments class / interface (/ ** ... * /)|Documentation Javadoc|

| Declaration of Class / interface ||
| --------------------------- | ---------------------- |
|Comments class / interface implementation (/ * ... * /), if necessary|This comment should contain any information not appropriate for the review of documentation|
|Class variables (static)|First the variables public, then protected, then private.|
|Instance variables|First public, then protected, then private|
|Constructors| |
|Methods|These methods should be grouped by functionality|

##indentation
###Line length
Avoiding over lines 80 caracters.

###Line break
When an expression does not fit on one line, break it with the following general principles:
- Break after the decimal point
- Break before the operator
- Align the new line with the same level of the beginning of the previous line of expression

##Comments
###Function
Should follow the pattern: <code>// comment</code>
###Block
It should be written on the same line that starts the comment and end on the line below.
example:

       /* comment
       */

##Declarations
###Number per line
One statement per line is recommended, since this approach encourages comment.
###Location
Placing the declaration of variables as close as possible to their use
###Startup
Initialize local variables which are declared, except when the initial value depends on some calculations that occur first.
###Classes and interfaces
This rules must be followed:
- No space between the method name and the parenthesis that starts its deparâmetros list.
- Key Open "{" appears at the end of the same line as the command statement.
- Close keys "}" starts on its own line retreating to match the opening of the declaration keys.
- When the statement is null should skip a line, see the comment "to nothing the" jump another line and the "}" closing aligned expression.
- Methods must be separated by a blank line.

###Simple declaration
Each line should contain only a statement.
###Complex declarations
Compound statements are statements that contain instructions in braces, and they shall even use brackets in individual statements, when they are part of a control structure, such as ifelse or for instruction. This makes it easier to add statements without accidentally generate errors due to the lack of brackets.
###Return declaration
A return statement with a value should not use parentheses unless it is an expression.
###<code>if-else</code>, <code>if-else-if-else</code> declaration
Should follow the form:

    if (condition) {
      declaration;
    } 
    else {
      declaration;
    }

**NOTE:** When the statement is null should skip a line, see the comment "nothing to do", skip another line and the "}" closing aligned expression.
### <code>for</code> declaration
Should follow the form:

    for (startup; condition; update) {
      declaration;
    }

**NOTE:** When the statement is null should skip a line, see the comment "nothing to do", skip another line and the "}" closing aligned expression.

###<code>while</code> declaration
Should follow the form:

    while (condition) {
      declaration;
    }

**NOTE:** When the statement is null should skip a line, see the comment "nothing to do", skip another line and the "}" closing aligned expression.

###<code>do-while</code> declaration
Should follow the form:
    do {
      declaration;
    } while (condition);

**NOTE:** When the statement is null should skip a line, see the comment "nothing to do", skip another line and the "}" closing aligned expression.

###<code> switch</code> declaration
Should follow the form:

    switch (condition) {
      case ABC:
        declaration;
        /* pass through */
        
      case DEF:
        declaration;
      break ;
      
      case XYZ:
        declaration;
      break ;
      
      default :
        declaration;
      break ;
    }
    
**NOTE:** When a case passes through (not including the break statement), add a comment where the break statement would normally be. When the statement is null should skip a line, see the comment "nothing to do", skip another line and the break come aligned expression.

###<code>try-catch</code> declaration
Should follow the form:

      try {
        declaration;
      } catch (ExceptionClass e) {
        declaration;
      }
      
###Blank spaces
You must use a blank line in the following situções:
- Among methods
- Among the local variables in a method and its first statement
- Before a block comment
- Between logical sections inside a method to improve readability

You should use blanks spaces in the following situations:
- A keyword followed by a parenthesis should be separated by a blank space.
example:
      
      while ( true ) {
        declaration;
      }
  
**NOTE :** A blank space should not be used between the method name and the opening parenthesis. This helps to distinguish keyword method call.
- A blank space should appear after the decimal point in an argument list.
- "." All except binary operator must be separated from other operators for space. White space should never separate unary operators such as increment ("++") and decrease ("").
- The expressions in a statement is to be separated by a blank space.

##Convention of names

|Handle Type | Rule for Naming | Example |
| ---------------------- | ----------------------- | ------ |
| Classes and Interfaces | Class names should be nouns, with the first letter of each word, including internal, capital | class Student Filmography StudentOfLaw interface |
| Methods | Methods should be verbs, starting the word in lower case and the internal word capitalized | run ();. Filmography getBackground (); |
| Variables | should start with a lower case and internal capitalized words | int myWidth;. |
| Constants | They must have all uppercase, and if you need to separate by "_" | int MIN_WIDTH; |
