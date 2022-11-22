# L12GR05 - BERZERK

## GAME DESCRIPTION
> 
> This project is based on the creation of a 2D Atari arcade game called Berzerk. The game consists of different enemies that have different types of movements and characteristics depending on their type and a player that carries a gun to kill the monsters so that he can proceed to the following levels
> The player has an energy attribute that decreases every time he takes a hit. When his energy gets to 0, the game ends.
> After each monster killed, the player's score increases and after the game is over he can enter a LeaderBoard.
> 
&nbsp;

### GROUP COMPOSITION:
> 
> **This project was developed by:**
> - > Mansur (up202102355@up.pt)
> - > Ian Beltrão (up202102360@up.pt)
> - > Rafael Teixeira (up202108831@up.pt)
> 
&nbsp;

## IMPLEMENTED FEATURES
> 
>
> - > Menu - When the game is initialized, a menu containing the options Play, Leader Board, Instructions and Exit is displayed
> - > Pause - It's possible to pause the game. When the game is paused, a menu containing the options Continue, New game, Exit and Exit to Menu is displayed
> - > Enemies - There are 2 types of enemies in the game: Monster and King
> - > King movementation - King has an inteligent movementation (finds the shortest way to hero by dodging walls)
> - > Map creation - We are able to use custom made maps with the support of a wall and enemies tracking system
> - > External font - We can use our own font in the game
> - > Energy counting - The player has an ammount of energy that decreases every time he has contact with an enemy
> - > Game Over - When the player's energy gets to 0, a Game Over screen containing the options Menu, See Leader Board and Add name to leader Board is displayed
> - > Characters - We designed the characters manually
> - > Instructions - In the menu the player has the option to se an instructions screen
> 
&nbsp;

## **FEATURES PLANEADAS**
> 
> **We pretend to implement:**
> 
> - > A scoring system. With each elimination the player's score increases
> - > A ranking system. When the player is eliminated, if he acquires a New High Record, he will be able to write his name on the LeaderBoard and acquire a position on it
> - > Diferent type of weapons
> - > Diferent type of enemies
> - > Destroy bullets that collide
> - > A new game objective in which the player must obligatorily obtain a key and eliminate all enemies before being able to open the doors to other levels
> - > Insert a logo and buttons designs created manually
> - > Insert a sound system. We've already added the .wav files to the repository but haven't implemented them yet
>
&nbsp;

## CHARACTERS 
> <pre>       HERO                                                 KING                                         MONSTER       </pre>       
>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Characters/HERO.png)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
> ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Characters/KING.png)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
> ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Characters/MONSTER.png)
> 
&nbsp;

## GAME 
> <pre>                                                           MENU                                                              </pre>      
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Menu.png)
> <pre>                                                          PAUSE MENU                                                        </pre>      
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/PauseMenu.png)
> <pre>                                                          LEADERBOARD                                                        </pre>      
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/LeaderBoard.png)
> <pre>                                                         INSTRUCTIONS                                                        </pre>      
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Instructions.png)
> 
&nbsp;

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
&nbsp;

### CODE SMELLS E SUGESTÕES DE REFACTORING
> 
>_(Descrever 3 a 5 code smells que identificamos na nossa implementação atual e sugerir formas de como o código pode ser refactured de forma a removê-las. Cada uma deve ser descrita na sua subsecção própria)_ </br>
> 
> **Exemplo de implementação:** </br>
>> #### DATA CLASS
> -The `PlatformSegment` class is a **Data Class**, as it contains only fields, and no behavior. > - This is problematic because […].
> -A way to improve the code would be to move the `isPlatformSegmentSolid()` method to the `PlatformSegment` class, as this logic is purely concerned with the `PlatformSegment` class.
> 
&nbsp;

### TESTING
![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/CodeCoverage.png) </br>
___
_(Link to mutation testing report.)_
___
&nbsp;

### SELF-EVALUATION
> 
> Mansur: </br>
>  Ian: </br>
> Rafael: </br>
> 
