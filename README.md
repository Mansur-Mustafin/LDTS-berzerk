# L12GR05 - BERSERK

## Descrição do jogo
O projeto consiste na recriação de um jogo Atari 2D conhecido como Berserk. Neste jogo, um único jogador portador de uma arma terá que enfrentrar diversos robôs ao longo de diversos níveis.
A cada eliminação, será atribuída uma pontuação que será incrementada à pontuação total do jogador e quando este é eliminado, terá a chance de entrar numa LeaderBoard.


### Composição grupo:
Este projeto foi desenvolvido pelos elementos:
> - Mansur (up
> - Ian Beltrão (up
> - Rafael Teixeira (up202108831@up.pt)

## Feature Implementadas
Conseguimos implementar:
> - Uma movimentação dos enimigos mais fluida e automática
> - A criação de mapas feitos manualmente através de um sistema de resgisto de paredes
> - A criação de um Menu com um Start e Exit funcionáveis

## Planned Implementadas
Pretendemos implementar:
> - Um sistema de pontuação. A cada eliminação a pontuação do jogador aumenta
> - Um sistema de ranking. Quando o jogador é eliminado, se adquirir um New High Record, conseguirá escrever o seu nome na LeaderBoard e adquirir uma posição na mesma
> - Diferentes tipo de armas
> - Diferentes tipos de enimigos
> - Destruir balas que colidem
> - Um novo objetivo de jogo em que o jogador necessita de obrigatoriamente obter uma chave e eliminar todos os inimigos antes de conseguir abrir as portas para os outros níveis

## Design
### Problema em contexto 
- **(Descrição do contexto do design e o problema que motivou a instanciação da sua pattern. Colocar links para as linhas de código relevantes da implementação da pattern)**
> Exemplo: There was a lot of scattered conditional logic when deciding how the KangarooBoy should behave when jumping, as the jumps should be different depending on the items that came to his possession during the game (an helix will alow him to fly, driking a potion will allow him to jump double the height, etc.). This is a violation of the **Single Responsability Principle**. We could concentrate all the conditional logic in the same method to circumscribe the issue to that one method but the **Single Responsability Principle** would still be violated.

### A Pattern 
- **(Identificar a design pattern a ser aplicada, a razão de ser aplicada e o porquê de ser uma boa implementação considerando o contexto do design e o problema enfrentado)**
> Exemplo: We have applied the **State** pattern. This pattern allows you to represent different states with different subclasses. We can switch to a different state of the application by switching to another implementation (i.e., another subclass). This pattern allowed to address the identified problems because […].

### Implementação
- **(Mostrar como as funções, operações e associações das patterns foram mapeadas para o design concreto das classes. Ilustrar com um diagrama UML com links para as linhas de código relevantes)**
> Exemplo: The following figure shows how the pattern’s roles were mapped to the application classes.
![img](https://www.fe.up.pt/~arestivo/page/img/examples/lpoo/state.svg)
These classes can be found in the following files:
- [Character](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/Character.java)
- [JumpAbilityState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/JumpAbilityState.java)
- [DoubleJumpState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/DoubleJumpState.java)
- [HelicopterState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/HelicopterState.java)
- [IncreasedGravityState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/IncreasedGravityState.java)

### Consequências
- **(Benefícios e responsabilidades da pattern após a )**
> Exemplo: The use of the State Pattern in the current design allows the following benefits:

- The several states that represent the character’s hability to jump become explicit in the code, instead of relying on a series of flags.
- We don’t need to have a long set of conditional if or switch statements associated with the various states; instead, polimorphism is used to activate the right behavior.
- There are now more classes and instances to manage, but still in a reasonable number.
