# L12GR05 - BERSERK

## DESCRIÇÃO DO JOGO
> 
> O projeto consiste na recriação de um jogo Atari 2D conhecido como Berserk. Neste jogo, um único jogador portador de uma arma terá que enfrentrar diversos robôs ao longo de diversos níveis.
> A cada eliminação, será atribuída uma pontuação que será incrementada à pontuação total do jogador e quando este é eliminado, terá a chance de entrar numa LeaderBoard.
> 
>

### COMPOSIÇÃO DO GRUPO:
> 
> **Este projeto foi desenvolvido pelos elementos:**
> - > Mansur (up202102355@up.pt)
> - > Ian Beltrão (up202102360@up.pt)
> - > Rafael Teixeira (up202108831@up.pt)
> 

## FEATURES IMPLEMENTADAS
> 
> **Conseguimos implementar:**
>
> - > Menu - Quando o jogo é inicializado, um menu contendo as opções Play e Quit é mostrado.
> - > Pause - Durante o jogo é possível dar pause e um menu com as opções Continue, New Game, Exit, Exit to Menu é mostrado 
> - > Inimigos - Existem 2 tipos de inimigos no jogo, o Monster e o King, cada um com uma diferente adoção de movimento e inflição de dano ao jogador
> - > Movimentação King - O inimigo King possui movimentação inteligente (desvia de paredes e encontra menor caminho até o hero)
> - > Criação de mapas - Conseguimos utilizar mapas criados manualmente com o auxílio de um sistema de registo de paredes e posição de início de inimigos
> - > Fonte externa - Utilizamos uma fonte externa no jogo
> - > Contagem de energia - O jogador tem uma quantidade de energia, que diminui toda vez que entra em contacto com um monstro
> - > Game Over - Quando a energia do jogador se esgota, uma tela de Game Over é mostrada com a opção de seguir para o Menu
> 


## **FEATURES PLANEADAS**
> 
> **Pretendemos implementar:**
> 
> - > Um sistema de pontuação. A cada eliminação a pontuação do jogador aumenta
> - > Um sistema de ranking. Quando o jogador é eliminado, se adquirir um New High Record, conseguirá escrever o seu nome na LeaderBoard e adquirir uma posição na mesma
> - > Diferentes tipo de armas
> - > Diferentes tipos de enimigos
> - > Destruir balas que colidem
> - > Um novo objetivo de jogo em que o jogador necessita de obrigatoriamente obter uma chave e eliminar todos os inimigos antes de conseguir abrir as portas para os outros níveis
> - > Inserir uma logo e designs de botões criados manualmente
> 

## CHARACTERS 
![img]

## **DESIGN**
_(Colocar UML aqui)_ </br>

> **CASO A EXPLICAR:** </br> _(Exemplo: THE JUMP ACTION OF THE KANGAROOBOY SHOULD BEHAVE DIFFERENTLY DEPENDING ON ITS STATE)_

>
> ### Problema em contexto 
> > _(Descrição do contexto do design e o problema que motivou a instanciação da sua pattern. Colocar links para as linhas de código relevantes da implementação da pattern)_ </br>
> 
> >**Exemplo:** </br>
> >There was a lot of scattered conditional logic when deciding how the KangarooBoy should behave when jumping, as the jumps should be different depending on the items that came to his possession during the game (an helix will alow him to fly, driking a potion will allow him to jump double the height, etc.). This is a violation of the **Single Responsability Principle**. We could concentrate all the conditional logic in the same method to circumscribe the issue to that one method but the **Single Responsability Principle** would still be violated.
> 
> ### Pattern 
> > _(Identificar a design pattern a ser aplicada, a razão de ser aplicada e o porquê de ser uma boa implementação considerando o contexto do design e o problema enfrentado)_ </br>
> 
> >**Exemplo:** </br>
> > We have applied the **State** pattern. This pattern allows you to represent different states with different subclasses. We can switch to a different state of the application by switching to another implementation (i.e., another subclass). This pattern allowed to address the identified problems because […].
>
> ### Implementação
> >* *(Mostrar como as funções, operações e associações das patterns foram mapeadas para o design concreto das classes. Ilustrar com um diagrama UML com links para as linhas de código relevantes)* * </br>
>
> > **Exemplo:** </br>
> >  - The following figure shows how the pattern’s roles were mapped to the application classes.
> ![img](https://www.fe.up.pt/~arestivo/page/img/examples/lpoo/state.svg)
> These classes can be found in the following files:
> >    - [Character](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/Character.java)
> >    - [JumpAbilityState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/JumpAbilityState.java)
> >    - [DoubleJumpState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/DoubleJumpState.java)
> >    - [HelicopterState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/HelicopterState.java)
> >    - [IncreasedGravityState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/IncreasedGravityState.java)
> 
> 
> ### Consequências
> >(Benefícios e responsabilidades da pattern após a instanciação da pattern, comparando estas consequências com outras soluções alternativas)* * </br>
>
> >**Exemplo:** </br>
>>
> > The use of the State Pattern in the current design allows the following benefits: </br>
> > The several states that represent the character’s hability to jump become explicit in the code, instead of relying on a series of flags. </br>
> > We don’t need to have a long set of conditional if or switch statements associated with the various states; instead, polimorphism is used to activate the right behavior. </br>
> > There are now more classes and instances to manage, but still in a reasonable number. </br>
> 

### CODE SMELLS E SUGESTÕES DE REFACTORING
> 
>_(Descrever 3 a 5 code smells que identificamos na nossa implementação atual e sugerir formas de como o código pode ser refactured de forma a removê-las. Cada uma deve ser descrita na sua subsecção própria)_ </br>
> 
> **Exemplo de implementação:** </br>
>> #### DATA CLASS
> -The `PlatformSegment` class is a **Data Class**, as it contains only fields, and no behavior. > - This is problematic because […].
> -A way to improve the code would be to move the `isPlatformSegmentSolid()` method to the `PlatformSegment` class, as this logic is purely concerned with the `PlatformSegment` class.
> 

### TESTING
_(Screenshot of coverage report)_ </br>
___
_(Link to mutation testing report.)_
___

### SELF-EVALUATION
> 
> Mansur: </br>
>  Ian: </br>
> Rafael: </br>
> 
