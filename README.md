# L12GR05 - BERSERK

## DESCRIÇÃO DO JOGO
> 
> O projeto consiste na recriação de um jogo Atari 2D conhecido como Berserk. Neste jogo, um único jogador portador de uma arma terá que enfrentrar diversos robôs ao longo de diversos níveis.
> A cada eliminação, será atribuída uma pontuação que será incrementada à pontuação total do jogador e quando este é eliminado, terá a chance de entrar numa LeaderBoard.
> 
&nbsp;

### COMPOSIÇÃO DO GRUPO:
> 
> **Este projeto foi desenvolvido pelos elementos:**
> - > Mansur (up202102355@up.pt)
> - > Ian Beltrão (up202102360@up.pt)
> - > Rafael Teixeira (up202108831@up.pt)
> 
&nbsp;

## FEATURES IMPLEMENTADAS
> 
> **Conseguimos implementar:**
>
> - > Menu - Quando o jogo é inicializado, um menu contendo as opções Play, Leader Board, Instruction e Exit é mostrado.
> - > Pause - Durante o jogo é possível dar pause e um menu com as opções Continue, New Game, Exit, Exit to Menu é mostrado 
> - > Inimigos - Existem 2 tipos de inimigos no jogo, o Monster e o King, cada um com uma diferente adoção de movimento e inflição de dano ao jogador
> - > Movimentação King - O inimigo King possui movimentação inteligente (desvia de paredes e encontra menor caminho até o hero)
> - > Criação de mapas - Conseguimos utilizar mapas criados manualmente com o auxílio de um sistema de registo de paredes e posição de início de inimigos
> - > Fonte externa - Utilizamos uma fonte externa no jogo
> - > Contagem de energia - O jogador tem uma quantidade de energia, que diminui toda vez que entra em contacto com um monstro
> - > Game Over - Quando a energia do jogador se esgota, uma tela de Game Over é mostrada com as opções de seguir para o Menu, ver a Leader Board ou adicionar o seu nome à LeaderBoard
> - > Personagens - Esboçamos personagens manualmente
> - > Instruções - Ao entrar no Menu, o jogador tem a hipótese de verificar os comandos do jogo
> 
&nbsp;

## CHARACTERS 
> <pre>       HERO                                      KING                                  MONSTER       </pre>       
>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Characters/HERO.png)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
> ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Characters/KING.png)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
> ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Characters/MONSTER.png)
> 
&nbsp;

# GAME
> <pre>                                                  MENU                                               </pre>      
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/f9f76b0b3150cddd306c023bdc599f1e5d6f31b4/docs/Screenshots/Menu.png)
> <pre>                                               PAUSE MENU                                            </pre>      
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/PauseMenu.png)
> <pre>                                              LEADERBOARD                                            </pre>      
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/LeaderBoard.png)
> <pre>                                              INSTRUCTIONS                                           </pre>      
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/f9f76b0b3150cddd306c023bdc599f1e5d6f31b4/docs/Screenshots/Instructions.png)
>
&nbsp;

## UML DIAGRAM
_(Colocar UML aqui)_ </br>
___
&nbsp;

## CODE COVERAGE
![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/CodeCoverage.png) </br>
___
_(Colocar link para  o relatório de mutation testing)_
___
