# L12GR05 - BERZERK

## GAME DESCRIPTION
> 
> This project is based on the creation of a 2D Atari arcade game called `Berzerk`. The game consists of different enemies that have different types of movements and characteristics depending on their type and a player that carries a gun to kill the monsters so that he can proceed to the following levels
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
> - `MENU` - When the game is initialized, a menu containing the options Play, Leader Board, Instructions and Exit is displayed
> - `PAUSE` - It's possible to pause the game. When the game is paused, a menu containing the options Continue, New game, Exit and Exit to Menu is displayed
> - `ENEMIES` - There are 2 types of enemies in the game: Monster and King
> - `KING MOVIMENTATION` - King has an inteligent movementation (finds the shortest way to hero by dodging walls)
> - `MAP CREATION` - We are able to use custom made maps with the support of a wall and enemies tracking system
> - `EXTERNAL FONT` - We can use our own font in the game
> - `HEALTH BAR` - The player has an ammount of health that decreases every time he has contact with an enemy
> - `GAME OVER` - When the player's energy gets to 0, a Game Over screen containing the options Menu, See Leader Board and Add name to leader Board is displayed
> - `CHARACTERS` - We designed the characters manually
> - `INSTRUCTIONS` - In the menu the player has the option to se an instructions screen
> 
&nbsp;
                                                                                                     |           |
## GAME ELEMENTS 
> <pre>       HERO                      KING                      MONSTER                      BULLET       </pre>       
>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Elements/HERO.png)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
> ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Elements/KING.png)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
> ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Elements/MONSTER.png)
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
> ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Elements/Bullet.png)
&nbsp;

# GAME
> <pre>                                                MENU                                                 </pre>      
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/f9f76b0b3150cddd306c023bdc599f1e5d6f31b4/docs/Screenshots/Menu.png)
> <pre>                                             PAUSE MENU                                              </pre>      
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/PauseMenu.png)
> <pre>                                            LEADERBOARD                                              </pre>      
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/LeaderBoard.png)
> <pre>                                            INSTRUCTIONS                                             </pre>      
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/Instructions.png)
>
> <pre>                                            GAMEPLAY                                             </pre>      
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Gifs/Gameplay.gif)
>
> <pre>                                        ENEMY INTELIGENCE                                            </pre>      
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Gifs/EnemyInteligence.gif)
>
> <pre>                                          TAKING DAMAGE                                              </pre>      
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Gifs/TakingDamage.gif)
>
&nbsp;

## UML DIAGRAM
![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/UML.png) </br>
___
&nbsp;

## CODE COVERAGE
![img](https://github.com/FEUP-LDTS-2022/project-l12gr05/blob/master/docs/Screenshots/CodeCoverage.png) </br>
___
_(Colocar link para  o relatório de mutation testing)_
___
