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

## PLANNED FEATURES
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
> <pre>                                                           GAMEPLAY                                                           </pre>      
> 
> ![](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Gifs/Gameplay.gif)
> <pre>                                                       ENEMY INTELIGENCE                                                      </pre>      
> 
> ![](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Gifs/Inteligent%20Enemies.gif)
> <pre>                                                         TAKING DAMAGE                                                        </pre>      
> 
> ![](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Gifs/Taking%20Damage.gif)
&nbsp;

## DESIGN
_(Colocar UML aqui)_ </br>
&nbsp;

### BASIC CODE ORGANIZATION </br>
>
> ### Problem in Context
> > Without an appropriate structure, it would be very hard and confusing to change and develop the code </br>
> 
> ### Pattern 
> > We used the Model-View-Controller (MVC) pattern, allowing us to divide the application in three parts, separating the logical part from the displaying. That allows better code readability and easier bug fixing </br>
>
> ### Implementation
> > The following figure shows the implementation of this pattern: </br>
>
> > ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Patterns/MVC.png) </br>
> 
> > Packages can be found in:
> >    - [CONTROLLER](https://github.com/FEUP-LDTS-2022/project-l12gr05/tree/master/src/main/java/com/RafaelNTeixeira/projeto/controller)
> >    - [MODEL](https://github.com/FEUP-LDTS-2022/project-l12gr05/tree/master/src/main/java/com/RafaelNTeixeira/projeto/model)
> >    - [VIEWER](https://github.com/FEUP-LDTS-2022/project-l12gr05/tree/master/src/main/java/com/RafaelNTeixeira/projeto/viewer)
> 
> ### Consequences
> The use of the MVC Pattern in the current design allows the following benefits:
> > The code is more readable and easier to work with
> > It’s always the same process to add a new feature: create model, view and controller for that
>
&nbsp;
&nbsp;

### CHANGING GAME STATE </br>
>
> ### Problem in Context
> > When creating different types of menus and trying to change between them and the game we realized that our application had various states and we needed to easily switch between them
> 
> ### Pattern 
> > The best solution to this problem is applying the State Pattern. With this pattern we can separate the states in individual classes and change its behavior depending on its internal state </br>
>
> ### Implementation
> > The following figure shows how we implemented this pattern: </br>
>
> > ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Patterns/State.png) </br>
> 
> > Packages can be found in:
> >    - [AddLeaderState](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/src/main/java/com/RafaelNTeixeira/projeto/States/AddLeaderState.java)
> >    - [GameState](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/src/main/java/com/RafaelNTeixeira/projeto/States/GameState.java)
> >    - [InstructionsState](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/src/main/java/com/RafaelNTeixeira/projeto/States/InstructionsState.java)
> >    - [LeaderBoardState](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/src/main/java/com/RafaelNTeixeira/projeto/States/LeaderBoardState.java)
> >    - [LoseState](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/src/main/java/com/RafaelNTeixeira/projeto/States/LoseState.java)
> >    - [MenuState](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/src/main/java/com/RafaelNTeixeira/projeto/States/MenuState.java)
> >    - [PauseState](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/src/main/java/com/RafaelNTeixeira/projeto/States/PauseState.java)   
> >    - [State](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/src/main/java/com/RafaelNTeixeira/projeto/States/State.java)   
> 
> ### Consequences
> The use of the State Pattern in the current design allows the following benefits:
> > Organizing the code in various explicit state classes allowing better readability
> > Much easier to introduce new states to the application, without having to change several state classes
>
&nbsp;




### CREATING AND MOVING ENEMIES </br> 

>
> ### Problem in Context
> > When we decided that we wanted more than one type of enemy and that they would have different attributes and movement, we realized that we needed an efficient way to create and move them. </br>
> 
> ### Patterns 
> > The solution we found to this problem was applying two different patterns combined: Strategy pattern and Factory pattern. The combination of the two patterns allows us to easily create different types of enemies with an initial moving strategy and then depending on game conditions change their move strategy. </br>
> 
> ### Implementation
> > The following figure shows how we implemented the patterns: </br>
>
> > Factory Pattern: </br>
> > ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Patterns/Factory.png) </br>
> > Strategy Pattern: </br>
> > ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Patterns/Strategy.png) </br> 
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
