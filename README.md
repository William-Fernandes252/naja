# Naja

Compiler and tools for the Naja language.

## Dependencies

The project is based on Java 21, and its build and distribution is managed with Maven.
In order to contribute, or compile the project locally, make sure you have

- OpenJDK `21.*`
- Apache Maven `3.8.*`

installed on your machine.

## Generating parser and lexer source files from the grammar definition

We use [ANTLR4](https://www.antlr.org/) to implement the Naja compiler. Its syntax, alongside with its lexical rules are defined on the ANTLR [grammar](./core/src/main/antlr4/NajaGrammar.g4), and the compiler logic (parsing, code generation etc) is implemented by the [com.example.core.lib](./core/src/main/java/com/example/core/lib) package.

The building process leverages the [ANTLR4 Maven plugin](https://www.antlr.org/api/maven-plugin/latest/usage.html) to process the grammar definition and create the compiler core implementation. After making changes to the grammar, run

```bash
mvn antlr4:antlr4 -f core/pom.xml
```

to generate updated source files.

## Contributors

- Thiago Fernandes (11202130847)
- Vitor Marques (11201722723)
- William Fernandes (11202020043)

[Video on YouTube](https://youtu.be/vJZVrc6aKe4)
