##Cabeçalho
O código deve conter um cabeçalho no início da classe no estilo /* ... */ contendo o nome
da classe, uma breve descrição da mesma.

##Declaração de pacotes
A primeira linha não comentada é a declaração do Package e o mesmo deve seguir o
seguinte padrão: nome do pacote sem nenhum caracter especial, caso o nome do pacote
tenha duas palavras, escrevelas
juntas com a primeira letra da segunda palavra em
maiúsculo. 
Como segue o exemplo: <code>nomePacote</code>

##Declaração de classes e interfaces
As tabelas a seguir mostram as partes de uma classe e a ordem em que devem aparecer.

|Partes da declaração Classe/interface||
|-------------------------|----------------------|
|Comentário de documentação da classe/interface (/** ... */)|Documentação Javadoc|

| Declaração Classe/interface ||
| --------------------------- | ---------------------- |
|Comentários de implementação da classe/interface (/* ... */), se necessário|Este comentário deve conter qualquer informação não apropriada para o comentário da documentação|
|Variáveis de classe (static)|Primeiro as variáveis public, depois protected, depois private.|
|Variáveis de instância|Primeiro public, depois protected, depois private|
|Construtores| |
|Métodos|Esses métodos devem ser agrupados por funcionalidade

##Indentação
###Comprimento da linha
Evitar linhas com mais de 80 caracters.

###Quebra de linha
Quando uma expressão não couber em uma linha, quebrea
com os seguintes princípios
gerais:
- Quebrar depois da vírgula
- Quebrar antes do operador
- Alinhar a nova linha com o mesmo nível do início da expressão da linha anterior

##Comentários
###Da função
Deve seguir o padrão: <code>// comentário</code>
###Do bloco
Deve-se escrever na mesma linha que inicia o comentário e terminar na linha debaixo.
Exemplo:

       /* comentário
       */

##Declarações
###Número por linha
Uma declaração por linha é o recomendado, visto que essa abordagem incentiva a
comentar.
###Localização
Colocar a declaração das variáveis o mais próximo possível da sua utilização
###Inicialização
Inicializar variáveis locais onde são declaradas, exceto quando o valor inicial depende de alguns cálculos que ocorrem primeiro.
###De classes e interfaces
As seguintes regras devem ser seguidas:
- Sem espaço entre o nome do método e o parênteses que inicia a sua lista de
parâmetros .
- Abrir chaves “{“ aparece no final da mesma linha que o comando da declaração.
- Fecha chaves “}” inicia em uma linha própria recuando para combinar com a abertura de chaves da correspondente declaração.
- Quando a declaração é nula deve saltar uma linha, vir o comentário “nothing to do”, saltar outra linha e o “}” fechando alinhado à expressão.
- Métodos devem ser separados por uma linha em branco.

###Declaração simples
Cada linha deve conter apenas uma declaração.
###Declarações complexas
Declarações compostas são declarações que contem instruções entre chaves, e estas
devem utilizar colchetes até mesmo em declarações individuais, quando elas fazem
parte de uma estrutura de controle, como a instrução ifelse
ou for. Isto torna mais fácil
adicionar declarações sem acidentalmente gerar erros, devido à falta de colchetes.
###Declaração return
Uma declaração return com um valor não deve usar parênteses a menos que seja uma
expressão.
###Declaração <code>if-else</code>, <code>if-else-if-else</code>
Deve seguir a seguinte forma:

    if (condição) {
      declaração;
    } 
    else {
      declaração;
    }

Quando a declaração é nula deve saltar uma linha, vir o comentário “nothing to do”, saltar
outra linha e o “}” fechando alinhado à expressão.
###Declaração <code>for</code>
A declaração for deve seguir a seguinte forma:

    for (inicialização; condição; update) {
      declaração;
    }

Quando a declaração é nula deve saltar uma linha, vir o comentário “nothing to do”, saltar
outra linha e o “}” fechando alinhado à expressão.

###Declaração <code>while</code>
A declaração while deve seguir a seguinte forma:

    while (condição) {
      declaração;
    }

Quando a declaração é nula deve saltar uma linha, vir o comentário “nothing to do”, saltar
outra linha e o “}” fechando alinhado à expressão.

###Declaração <code>do-while</code>
A declaração do-while deve seguir a seguinte forma:
    do {
      declaração;
    } while (condição);

Quando a declaração é nula deve saltar uma linha, vir o comentário “nothing to do”, saltar
outra linha e o “}” fechando alinhado à expressão.

###Declaração switch
A declaração switch deve seguir a seguinte forma:

    switch (condição) {
      case ABC:
        declaração;
        /* passa através */
        
      case DEF:
        declaração;
      break ;
      
      case XYZ:
        declaração;
      break ;
      
      default :
        declaração;
      break ;
    }
    
Toda vez que um case passa através (não inclui a instrução break), adicione um
comentário onde a instrução break normalmente estaria. Quando a declaração é nula deve
saltar uma linha, vir o comentário “nothing to do”, saltar outra linha e o break vir alinhado à
expressão.

###Declaração <code>try-catch</code>
A declaração try-catch deve seguir a seguinte forma:
      try {
        declaração;
      } catch (ExceptionClass e) {
        declaração;
      }
###Espaço em branco 
- Deve-se usar uma linha em branco nas seguintes situções:
- Entre métodos
- Entre as variáveis locais em um método e a sua primeira declaração
- Antes de um comentário de bloco
- Entre seções lógicas dentro de um método para melhorar sua legibilidade

Devese usar espaços em branco nas seguintes situações:
- Uma palavrachaveseguida por um parentese deve ser separada por um espaço em branco. 
Exemplo:
      
      while ( true ) {
        declaração;
      }
  
**Nota :** Um espaço em branco não deve ser utilizado entre o nome do método e a
abertura do parentese. Isso ajuda a distinguir palavra chave de chamada de método.
- Um espaço em branco deve aparecer depois da vírgula em uma lista de argumentos.
- Todo operador binário exceto “.” deve ser separado de outros operadores por espaço.
Espaço em branco nunca deve separar operadores unários, como incremento (“++”) e
decremento (“”).
- As expressões em uma declaração for deve ser separada por um espaço em branco.

##Convenções dos nomes

|Tipo de Identificador |Regra para Nomeclatura |Exemplo|
|----------------------|-----------------------|-------|
|Classes e Interfaces| Os nomes de classes devem ser substantivos, com a primeira letra de cada palavra, inclusive interna, maiúscula|class Student <br>interface StudentOfLaw|
|Métodos |Métodos devem ser verbos, iniciando a palavra em minúsculo e com as palavras internas em maiúsculo.| run(); <br> getBackground();|
|Variáveis |Devem iniciar com minúscula e palavras internas em maiúsculas.| int myWidth;|
|Constantes| Devem ter todas as letras maiúsculas, e caso necessite separar por “_” |int MIN_WIDTH;|
