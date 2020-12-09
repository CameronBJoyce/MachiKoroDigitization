# Machi WoCo
This repository has been set up to get you started in completing your capstone project.

## Contents
  * [Project Overview](#project-overview)
    + [Prioritized Features](#prioritized-features)
    + [Grading Scheme](#grading-scheme)
  * [Project Details](#project-details)
    + [Prioritized Features](#prioritized-features-1)
    + [Definition of Done](#definition-of-done)
    + [Phases](#phases)
      - [Phase 0](#phase-0)
      - [Phase 1](#phase-1)
      - [Phase 2](#phase-2)
      - [Phase 3](#phase-3)
      - [Phase 4](#phase-4)
      - [Phase 5](#phase-5)
      - [Phase 6](#phase-6)
    + [AI Approaches](#ai-approaches)
      - [Random AI](#random-ai)
      - [Strategic AI](#strategic-ai)
    + [Interfaces](#interfaces)
      - [Console](#console)
        * [Start of Game](#start-of-game)
        * [Beginning of Turn](#beginning-of-turn)
        * [Current Game State](#current-game-state)
        * [Roll](#roll)
        * [Establishment Activation](#establishment-activation)
        * [Establishment Purchase or Landmark Construction](#establishment-purchase-or-landmark-construction)
        * [End of Turn](#end-of-turn)
        * [End of Game](#end-of-game)
        * [Human Interface Menus/Queries](#human-interface-menus-queries)
      - [Graphical Interface (GUI)](#graphical-interface--gui-)
      - [Network Implementation](#network-implementation)
  * [Technical Details](#technical-details)
    + [Prerequisites](#prerequisites)
    + [Building the Project](#building-the-project)
    + [Directory Structure](#directory-structure)
    + [IDE Setup](#ide-setup)
      - [Intellij](#intellij)
      - [Eclipse](#eclipse)
  * [Full Console Playthrough](#full-console-playthrough)


## Project Overview
-------------------
In this project, you will be creating an implementation of the board game [Machi Koro](https://boardgamegeek.com/boardgame/143884/machi-koro). The game itself is composed of a deck of cards, a pair of dice, and a set of coins. The cards come in two varieties, establishments and landmarks. Establishments are cards that activate depending on the result of the die/dice roll. Landmarks are cards that give constant benefits once they are constructed. Each player begins with specific starting cards---the *Wheat Field* and *Bakery* establishments, along with the four landmark cards (*Train Station* (4 coins), *Shopping Mall* (10 coins), *Amusement Park* (16 coins), and *Radio Tower* (22 coins)). The first player to construct all four landmarks wins the game. Consult the [detailed rules](https://www.dropbox.com/s/ehpxe4aa6n0ee98/P_MK_Rulebook_7418%20%281%29.pdf) or [the Watch It Played video](https://youtu.be/X6y02IGRE-U) to fully understand how to play.

The entire set of cards can be seen below:

![Machi Koro Cards](https://i.ibb.co/6JVfvBq/machikoro-cards.jpg)

The contents of the deck is as follows, supporting a maximum of 4 players:
* Wheat Field (6 + 4 starting)
* Ranch (6)
* Bakery (6 + 4 starting)
* Cafe (6)
* Convenience Store (6)
* Forest (6)
* Stadium (4)
* TV Station (4)
* Business Center (4)
* Cheese Factory (6)
* Furniture Factory (6)
* Mine (6)
* Family Restaurant (6)
* Apple Orchard (6)
* Farmers Market (6)
* Train Station (4)
* Shopping Mall (4)
* Amusement Park (4)
* Radio Tower (4)


### Prioritized Features
The core features for this project are as follows and will be explained in detail below:

1. Display the detailed view of each card on the console (Phase 0).
2. Play the Phase 1 console version of the game with 2 human players.
3. Play the Phase 1 console version of the game with 1 human and 1 random AI player.
4. Play the Phase 2 console version of the game with 1 human and 1 or 2 random AI players.
5. Play the Phase 3 console version of the game with 1 human and 1 or 2 random AI players.
6. Play the Phase 4 console version of the game with 1 human and 1, 2, or 3 random AI players.
7. Play the Phase 5 console version of the game with 1 human and 1, 2, or 3 random AI players.
8. Play the Phase 6 console version of the game with 1 human and 1, 2, or 3 random AI players.
9. Play the Phase 6 console version of the game with 1 human, 1 strategic AI, and 0, 1, or 2 random AI players.
10. Play the Phase 6 GUI version of the game with 1 human, 1 strategic AI, and 0, 1, or 2 random AI players.
11. Play the Phase 6 console version of the game over the network with 2 human players.
12. Play the Phase 6 version of the game (using both console and/or GUI clients) over the network with 2 human and 2 strategic AI players.

### Grading Scheme
This project is worth 50 points (50% of the total grade for the course). These points are awarded in two ways. First, each of the 4 sprints end in a sprint review, at which point I evaluate your team's work. Each sprint is worth a maximum of 10 points for each member of the team. (Except in highly unusual circumstances, all members receive the same grade for a sprint.) Second, the final 10 points are determined according to how many features you complete by the project's final deadline. That scale is as follows, determined by the final feature that your team completes:

| Feature | Points |
|---------|--------|
| 1       | 0      |
| 2       | 0      |
| 3       | 0      |
| 4       | 0      |
| 5       | 1      |
| 6       | 2      |
| 7       | 4      |
| 8       | 6      |
| 9       | 8      |
| 10      | 10     |
| 11      | 13     |
| 12      | 16     |

Note that it is possible to receive more than 10 points for this component, with any additional points counting as "bonus" toward the final course grade.


## Project Details
------------------
### Prioritized Features
1. Display the detailed view of each card on the console (Phase 0).
2. Play the Phase 1 console version of the game with 2 human players.
3. Play the Phase 1 console version of the game with 1 human and 1 random AI player.
4. Play the Phase 2 console version of the game with 1 human and 1 or 2 random AI players.
5. Play the Phase 3 console version of the game with 1 human and 1 or 2 random AI players.
6. Play the Phase 4 console version of the game with 1 human and 1, 2, or 3 random AI players.
7. Play the Phase 5 console version of the game with 1 human and 1, 2, or 3 random AI players.
8. Play the Phase 6 console version of the game with 1 human and 1, 2, or 3 random AI players.
9. Play the Phase 6 console version of the game with 1 human, 1 strategic AI, and 0, 1, or 2 random AI players.
10. Play the Phase 6 GUI version of the game with 1 human, 1 strategic AI, and 0, 1, or 2 random AI players.
11. Play the Phase 6 console version of the game over the network with 2 human players.
12. Play the Phase 6 version of the game (using both console and/or GUI clients) over the network with 2 human and 2 strategic AI players.

### Definition of Done
The *definition of done* for **any** feature is that it passes all automated acceptance tests, has a codebase that achieves at least 80% branch coverage from its unit tests, has a fully documented API, and has clear end-user documentation for using the software to play the game. This end-user documentation should be in the form of a Markdown file called "UserGuide.md".

Each of the first eight features comes with one or more automated acceptance tests. The remaining features require the product owner to certify that acceptance has been achieved by using the software manually.


### Phases
The phases referred to in the feature statements are described below. For each phase, the program should allow the first command line argument to be the phase. For Phase 1, the program should also accept an optional argument `--ai` that determines whether the opponent is another human (if `--ai` is absent) or a the random AI player (if `--ai` is present). For the remainder of the phases through Feature 8, the program should take two arguments---the phase and the number of players (which can be used to determine how many AI players should be used).

For example, to satisfy Feature 7, the program would be run as follows:

`java -jar build/libs/machiwoco.jar phase5 3`

which would run the program in Phase 5 mode with 3 players (1 human and 2 AI). In all cases, the first player is always human.


#### Phase 0
In Phase 0, there is no actual "game". Instead, the full view of the establishments (in order of activation) followed by landmarks is printed to the screen in the following format. Each line is exactly 25 characters wide. The value in angled brackets is the abbreviation for color of the card (**B**lue, **G**reen, **R**ed, **P**urple, or **N**one). The value in curly brackets is the abbreviation for the icon on the card (**W**heat, **B**read, **C**ow, **G**ear, **F**actory, Fruit **O**, Cup **U**, or **T**ower). The value in parentheses is the cost of the card. The value/range in the square brackets is the activation range of the card (if it's an establishment); otherwise, if it's a landmark, then the square brackets (bottom-right) either have a space (not constructed) or a capital X (constructed).

    .-----------------------.
    | <B>      [1]      {W} |
    |      Wheat Field      |
    |                       |
    |  Get 1 coin from the  |
    |         bank.         |
    |    (anyone's turn)    |
    |                       |
    | (1)                   |
    |_______________________|
    .-----------------------.
    | <B>      [2]      {C} |
    |         Ranch         |
    |                       |
    |  Get 1 coin from the  |
    |         bank.         |
    |    (anyone's turn)    |
    |                       |
    | (1)                   |
    |_______________________|
    .-----------------------.
    | <G>     [2-3]     {B} |
    |        Bakery         |
    |                       |
    |  Get 1 coin from the  |
    |         bank.         |
    |   (your turn only)    |
    |                       |
    | (1)                   |
    |_______________________|
    .-----------------------.
    | <R>      [3]      {U} |
    |         Cafe          |
    |                       |
    | Take 1 coin from the  |
    |    active player.     |
    |   (opponent's turn)   |
    |                       |
    | (2)                   |
    |_______________________|
    .-----------------------.
    | <G>      [4]      {B} |
    |   Convenience Store   |
    |                       |
    | Get 3 coins from the  |
    |         bank.         |
    |   (your turn only)    |
    |                       |
    | (2)                   |
    |_______________________|
    .-----------------------.
    | <B>      [5]      {G} |
    |        Forest         |
    |                       |
    |  Get 1 coin from the  |
    |         bank.         |
    |    (anyone's turn)    |
    |                       |
    | (3)                   |
    |_______________________|
    .-----------------------.
    | <P>      [6]      {T} |
    |        Stadium        |
    |                       |
    |   Take 2 coins from   |
    |    each opponent.     |
    |   (your turn only)    |
    |                       |
    | (6)                   |
    |_______________________|
    .-----------------------.
    | <P>      [6]      {T} |
    |      TV Station       |
    |                       |
    | Take 5 coins from an  |
    |       opponent.       |
    |   (your turn only)    |
    |                       |
    | (7)                   |
    |_______________________|
    .-----------------------.
    | <P>      [6]      {T} |
    |   Business Complex    |
    |                       |
    | Exchange one of your  |
    |       non-tower       |
    | establishments for 1  |
    |   an opponent owns.   |
    |   (your turn only)    |
    |                       |
    | (8)                   |
    |_______________________|
    .-----------------------.
    | <G>      [7]      {F} |
    |    Cheese Factory     |
    |                       |
    | Get 3 coins from the  |
    |   bank for each {C}   |
    |   establishment you   |
    |         own.          |
    |   (your turn only)    |
    |                       |
    | (5)                   |
    |_______________________|
    .-----------------------.
    | <G>      [8]      {F} |
    |   Furniture Factory   |
    |                       |
    | Get 3 coins from the  |
    |   bank for each {G}   |
    |   establishment you   |
    |         own.          |
    |   (your turn only)    |
    |                       |
    | (3)                   |
    |_______________________|
    .-----------------------.
    | <B>      [9]      {G} |
    |         Mine          |
    |                       |
    | Get 5 coins from the  |
    |         bank.         |
    |    (anyone's turn)    |
    |                       |
    | (6)                   |
    |_______________________|
    .-----------------------.
    | <R>    [9-10]     {U} |
    |   Family Restaurant   |
    |                       |
    | Take 2 coins from the |
    |    active player.     |
    |   (opponent's turn)   |
    |                       |
    | (3)                   |
    |_______________________|
    .-----------------------.
    | <B>     [10]      {W} |
    |     Apple Orchard     |
    |                       |
    | Get 3 coins from the  |
    |         bank.         |
    |    (anyone's turn)    |
    |                       |
    | (3)                   |
    |_______________________|
    .-----------------------.
    | <G>    [11-12]    {O} |
    |    Farmers Market     |
    |                       |
    | Get 2 coins from the  |
    |   bank for each {W}   |
    |   establishment you   |
    |         own.          |
    |   (your turn only)    |
    |                       |
    | (2)                   |
    |_______________________|
    .-----------------------.
    | <N>   LANDMARK    {T} |
    |     Train Station     |
    |                       |
    |  You may roll 1 or 2  |
    |         dice.         |
    |                       |
    | (4)               [ ] |
    |_______________________|
    .-----------------------.
    | <N>   LANDMARK    {T} |
    |     Shopping Mall     |
    |                       |
    |   Your {U} and {B}    |
    |  establishments earn  |
    |     +1 coin when      |
    |      activated.       |
    |                       |
    | (10)              [ ] |
    |_______________________|
    .-----------------------.
    | <N>   LANDMARK    {T} |
    |    Amusement Park     |
    |                       |
    | If you roll doubles,  |
    |   take another turn   |
    |    after this one.    |
    |                       |
    | (16)              [ ] |
    |_______________________|
    .-----------------------.
    | <N>   LANDMARK    {T} |
    |      Radio Tower      |
    |                       |
    |  Once per turn, you   |
    | may reroll the dice.  |
    |                       |
    | (22)              [ ] |
    |_______________________|



#### Phase 1
In the Phase 1 version of the game, the only establishments available will be the *Wheat Field*, *Ranch*, and *Forest* (all blue), and the only landmark will be a new one created solely for this purpose, the *City Hall*. The *City Hall* costs 7 coins to construct. It has no game effect, and its description should simply be "You have a city hall." All players start with a single *Wheat Field*, and there are 6 of each of the three establishments in the market. The first player to complete the *City Hall* wins the game.

#### Phase 2
The Phase 2 version of the game builds on Phase 1 by adding the *Bakery*, *Convenience Store*, *Mine*, and *Apple Orchard*. Players start with a single *Wheat Field* and *Bakery*, with 6 of each of the seven establishments in the market. It also includes the *Train Station* to go along with the *City Hall* landmark. The first player to complete both landmarks wins the game. (Note that the *Train Station* allows players to roll 1 or 2 dice, and there are establishments that require two dice to activate.)

#### Phase 3
The Phase 3 version builds on Phase 2 by adding the *Cheese Factory*, *Furniture Factory*, and *Farmers Market*. Starting cards are the same as in Phase 2, and each establishment has 6 copies in the market. It adds the *Shopping Mall* landmark in addition to the *Train Station* and *City Hall*. The first player to complete all landmarks wins the game. (Note that the *Shopping Mall* effect only applies to Bread icons in this phase, since there are no Cup icon cards yet.)

#### Phase 4
The Phase 4 version builds on Phase 3 by adding the *Cafe* and *Family Restaurant*, and (as always) there are 6 copies of each in the market. It also removes the *City Hall* from the landmarks and adds the *Amusement Park*. The first plyaer to complete all three landmarks wins the game. (Note that the *Shopping Mall* now has Cup icons to affect, and the *Amusement Park* allows an extra turn if a player rolls doubles, ie. the same value on both dice.)

#### Phase 5
The Phase 5 version builds on Phase 4 by adding the major (purple) establishments (*Stadium*, *TV Station*, and *Business Center*), as well as the *Radio Tower* landmark. This now represents the full game as presented in the rulebook. The first player to complete all four landmarks wins the game. (Note that the major establishments cannot be "stacked"---a player can only own one copy of each. Note also that the *Radio Tower* allows the player the choice to reroll once per turn.)

#### Phase 6
The Phase 6 version is identical to Phase 5, except that the market is handled as described in the "Hybrid Supply Variant" section of the rules (commonly called the "5-5-2 market"). For most players, this is the "standard" market, whereas the market we've used so far would be considered the "simple" market.


### AI Approaches
#### Random AI
The random AI player always chooses uniformly randomly among its choices. For the decision to roll one or two dice, or to reroll the dice, it has a 50% chance of choosing either. For the decision of choosing an opponent (as a target, for the *TV Station* or *Business Complex*), it has a uniform/equal chance of choosing any available opponent. For the decision to choose a building (for the *Business Complex*), it has a uniform/equal chance of choosing any of the available building options.

#### Strategic AI
The strategic AI player should make prioritized decisions about what establishments to buy and landmarks to construct, as well as which players/establishments to target. It should also have a defined strategy for when to roll 2 dice or to reroll (if those options are available). The designer must clearly communicate in documentation what the strategy in each circumstance is.


### Interfaces
#### Console
The console interface should provide the following notifications:
* the start of the game, including which player will go first
* the beginning of a player's turn, including the player's number and the current game state
* the roll generated by a player, including the die/dice rolled as well as the total
* the activation of an establishment, including the owning player and the establishment name
* the purchase of an establishment or the construction of a landmark, including the player and the property name
* the end of a player's turn, including the player's number
* the end of the game, including which player won

##### Start of Game 
The game should start with the notification "The game has started. Player *N* will go    
first." (where *N* is the starting player number).

##### Beginning of Turn
A turn should start with the notification "Turn started for Player *N*." (where *N* is the player's number).

##### Current Game State
The current game state **must** look like the following:

    ******************************************
                      MARKET                  
    ------------------------------------------
    Bakery             GB (1)  [2-3]    #5
    Cafe               RU (2)  [3]      #6
    Convenience Store  GB (2)  [4]      #5
    Forest             BG (3)  [5]      #1
    Stadium            PT (6)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #2
    Furniture Factory  GF (3)  [8]      #4
    Mine               BG (6)  [9]      #1
    Family Restaurant  RU (3)  [9-10]   #3
    Apple Orchard      BW (3)  [10]     #2
    
                 Player 1* [YOU]              
    ------------------------------------------
                    (2 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #2
    Apple Orchard      BW (3)  [10]     #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (4 coins)                 
    Wheat Field        BW (1)  [1]      #5
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #2
    Forest             BG (3)  [5]      #2
    Cheese Factory     GF (5)  [7]      #1
    Mine               BG (6)  [9]      #1
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************

It must start and end with a line of exactly 42 asterisks, followed by a line with the word "MARKET", followed by a line of exactly 42 hyphens. Then, each subsequent line should contain the following, each separated by a single space:
* name of the establishment (taking up a width of exactly 18 characters, left-aligned and space-padded)
* two characters representing the color and icon (as described in the *Phase 0* details)
* the cost in parentheses (taking up a width of exactly 4 characters, left-aligned and space-padded)
* the activation range in square brackets (taking up a width of exactly 7 characters, left-aligned and space padded)
* the number available, starting with a single space and the hashtag/pound symbol

So each market entry should be exactly 38 characters long. Also, the market entries should be sorted by activation value, where a single activation value should come before an activation that starts with the same value but has a larger upper bound. (For instance, the *Ranch* should come before the *Bakery* because it activates on 2 instead of 2-3.)

The final market entry should be followed by a blank line, after which the player entries start.

A player entry should begin with a line that contains "Player *N*" (where *N* is the player number), followed by a line of exactly 42 hyphens. The next line should contain the number of coins in parentheses. Then each subsequent line should be formatted just like those in the market, except the final value represents the number of establishments held by the player. The establishments should similarly be sorted by activation value.

Once all establishments have been listed for a player, there should be a line of exactly 42 dots/periods. Then the landmarks should be listed as follows (sorted according to price), each separated by a single space:
* name of the landmark (taking up a width of exactly 18 characters, left-aligned and space-padded)
* two characters representing the color and icon (as described in the *Phase 0* details)
* the cost in parentheses (taking up a width of exactly 4 characters, left-aligned and space-padded)
* whether it has been constructed in square brackets (taking up a width of exactly 3 characters), where a space represents "not constructed" and an X represents "constructed"

Each player entry is followed by a blank line before the next player entry begins. 

##### Roll
A roll should be notified as follows: "Player *N* rolled [3] = 3." or "Player *N* rolled [1][4] = 5." Each die value should be put in its own square brackets, with the total roll following an equals sign. For a single die roll, the value in the brackets would be the same as the total.

##### Establishment Activation
An establishment activation should be notified as follows: "Forest activated for Player *N*." using the *Forest* as an example.

##### Establishment Purchase or Landmark Construction
A purchase or construction should be notified as follows: "Player *N* purchased the Furniture Factory." using the *Furniture Factory* as an example establishment, or "Player *N* constructed the Shopping Mall." using the *Shopping Mall* as an example landmark. If the player chooses not to purchase or construct, the notification should say "Player *N* chose not to make improvements."

##### End of Turn
A turn should end with the notification "Turn ended for Player *N*."

##### End of Game
A game should end with a notification of the final game state (as described above), along with the notification "The game is over. Player *N* is the winner."
   

##### Human Interface Menus/Queries
The console interface should also provide the following menus/queries for human players:
* the menu of establishments and landmarks that a player can purchase
* the query of whether to roll 1 or 2 dice (if *Train Station* is constructed)
* the query to reroll the dice (if *Radio Tower* is constructed)
* the menu of which player to choose (if *TV Station* or *Business Complex* is activated)
* the menu of which establishment to choose (if *Business Complex* is activated)


###### Market Menu
The market menu should provide a numbered list of the market establishments and landmark options. The options should begin and end with a single line of 42 equals signs. Each subsequent line should list the option number as a two digit string, right-aligned and space-padded, followed by a dot/period, followed by a single space. The establishment entries should mimic those in the market and player inventories from the game state (18-character name, color/icon, price, activation, number available). The landmark entries should similarly be formatted as described in the game state section. The establishments should come first and be sorted by activation value, and the landmarks should come afterward and be sorted by cost. The final entry should be numbered "99" and should be the "do nothing" or "save for the next turn" option.

Most importantly, the options should **only** contain those establishments/landmarks that the player can both afford and is allowed to purchase/construct. For example, if a landmark has already been constructed by the player, it should not appear. If a major (purple) establishment has already been purchased by the player, it should not appear.

After the final 42-equals-sign line marking the end of the options, the prompt **must** be "Choose a number to purchase or construct:" The response **must** be one of the numbered options. Any other response should simply repeat the prompt.

The following is an example of such a menu:


    Player 1, would you like to purchase an   
    establishment or construct a landmark? (27 
    coins)                                    
    (To view details of an item, type 'view'  
    followed by the item number. For example, 
    to view item 6, type 'view 6'.)           
    ========================================== 
    ---------        PURCHASE        --------- 
     1. Bakery             GB (1)  [2-3]    #4 
     2. Cafe               RU (2)  [3]      #6 
     3. Convenience Store  GB (2)  [4]      #5 
     4. Forest             BG (3)  [5]      #1 
     5. Stadium            PT (6)  [6]      #1 
     6. Business Complex   PT (8)  [6]      #1 
     7. Cheese Factory     GF (5)  [7]      #2 
     8. Furniture Factory  GF (3)  [8]      #1 
     9. Mine               BG (6)  [9]      #1 
    10. Family Restaurant  RU (3)  [9-10]   #3 
    11. Apple Orchard      BW (3)  [10]     #1 
    ---------       CONSTRUCT        --------- 
    12. Radio Tower        NT (22) [ ]        
    ---------         CANCEL         --------- 
    99. Do nothing                            
    ========================================== 
    Choose a number to purchase or construct: 

###### Train Station Query
If a player has constructed the *Train Station*, they should be given the choice to roll 1 or 2 dice each turn. The prompt **must** be "Player *N*, would you like to roll 1 or 2 dice?" and the response should be either "1" or "2". Any other response should simply repeat the prompt.

###### Radio Tower Query
If a player has constructed the *Radio Tower*, they should be given the opportunity to reroll the die/dice once on their turn. The prompt **must** be "Player *N*, would you like to reroll the dice? (y/n):" and the response should be either "y" or "n". Any other response should simply repeat the prompt.

###### Choose Player Menu
If a player owns the *TV Station* or *Business Complex*, then their activations require selecting another player. In such cases, the prompt should be as follows, assuming Player 1 is the active player:

    -------     AVAILABLE PLAYERS      ------- 
    1. Player 3             (3 coins)         
    Player 1, who would you like to target?   

Since there are at most 4 players in the game, the numbered options only use one digit for the response, followed by a dot/period, followed by a space. Then the player's name/number is provided as a 20-character, left-aligned, space-padded string, followed by a space, followed by the number of coins that player has in parentheses.

For the *TV Station* only opponents who have a positive number of coins should be listed. For the *Business Complex* all opponents who have any available properties to select should be listed, regardless of their coin balances. (Note that the *Business Complex* cannot trade the purple properties, nor can it trade starting properties. So if a player **only** had a single *Wheat Field* and *Bakery* with some purple properties, they would not be a target for the *Business Complex*.)

###### Choose Establishment Menu
If a player owns the *Business Complex*, then its activation requires selecting an opponent's establishment and one of the player's establishments (both non-starting and non-purple) to swap. In such cases, the prompt should be as follows, assuming Player 1 is the active player and Player 3 has been selected as the opponent:

    -------  AVAILABLE ESTABLISHMENTS  ------- 
                     Player 3                 
     1. Wheat Field        BW (1)  [1]        
     2. Ranch              BC (1)  [2]        
     3. Bakery             GB (1)  [2-3]      
     4. Cafe               RU (2)  [3]        
     5. Convenience Store  GB (2)  [4]        
     6. Forest             BG (3)  [5]        
     7. Mine               BG (6)  [9]        
     8. Family Restaurant  RU (3)  [9-10]     
     9. Apple Orchard      BW (3)  [10]       
    10. Farmers Market     GO (2)  [11-12]    
    Player 1, select an establishment:        
    -------  AVAILABLE ESTABLISHMENTS  ------- 
                     Player 1                 
     1. Wheat Field        BW (1)  [1]        
     2. Forest             BG (3)  [5]        
     3. Furniture Factory  GF (3)  [8]        
     4. Mine               BG (6)  [9]        
     5. Apple Orchard      BW (3)  [10]       
     6. Farmers Market     GO (2)  [11-12]    
    Player 1, select an establishment:        

The establishments should be formatted as in the other menus and sorted by activation order. Only establishments that can be swapped (non-starting/non-purple) should be listed. It should never happen that such a menu is empty because that player should not have been an option as a target.


#### Graphical Interface (GUI)
The graphical interface must provide at least as much information as the console interface. It is left to the developer to determine the specifics and the layout.

#### Network Implementation
The network version of the game should allow human players to connect to a given IP (localhost in this case) and port (22020 in this case). Once two players have connected, the game begins for those players and two new players can connect to play a separate game. The game is maintained by the server, with the clients only being used to get information from the users (the menus/queries from the console version, for instance) and to get the current state/log of the game. The protocol for the communication between the clients and server is left to the designer, but it should be clearly documented as a part of the *definition of done*.


## Technical Details
--------------------
### Prerequisites
This project assumes that you have already [installed Java 8+](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) on your system. 

### Building the Project
After you have cloned the repository, you should be able to navigate to the directory containing the **gradle.build** file. There, you can build the project by running the command

`gradlew build`

Then, you can run the unit test coverage report.

`gradlew jacocoTestReport`

Then, you can run the acceptance tests. 

`gradlew cucumber`

You can even do multiple things in one statement:

`gradlew build jacocoTestReport cucumber`

When you want to get rid of all of the temporary files (like compiled class files and such), you can say

`gradlew clean`

If you want to do a full build and reporting from a clean project, you can just string it all together:

`gradlew clean build jacocoTestReport cucumber`

If you want to create the generated documentation (based on your Javadoc comments), you can say

`gradlew javadoc`

And if you want to run the application you have created, you can say

`gradlew run`

Note that the application you are directed to create requires command-line arguments when it runs (e.g., the phase information). To pass those values when running through Gradle, you would say

`gradlew run --args="phase1 2"`




### Directory Structure
The directory structure that is assumed by Gradle (it can be changed if you want, but that requires changes to the Gradle build file) is as follows:

    project root  (root directory of project)
               |
                - build.gradle  (contains the instructions for the build tasks)
               |
                - establishments  (JSON files for the establishments for all phases are here)
               |
                - gradlew  (the Unix Gradle script)
               |
                - gradlew.bat  (the Windows Gradle script)
               |
                - gradle  (all configuration and scripts for the Gradle wrapper go here)
               |
                - src  (root directory of the source code; acceptance, main, test)
                    |
                     - main  (root directory of normal source code)
                    |     |
                    |      - java  (all packages go here)
                    |           |
                    |            - edu    
                    |                |
                    |                 - wofford
                    |                         |
                    |                          - machiwoco  (source code goes here)
                    |                                 |
                    |                                  - main  (main classes go here)
                    |
                     - test  (root directory of unit and acceptance test code)
                          |
                           - java  (all packages go here)
                          |     |
                          |      - edu    
                          |     |    |
                          |     |     - wofford
                          |     |             |
                          |     |              - machiwoco  (unit test source code goes here)
                          |     |
                          |      - gradle
                          |     |       |
                          |     |        - cucumber  (cucumber step definition source code goes here)
                          |
                           - resources
                                     |
                                      - gradle
                                             |
                                              - cucumber  (cucumber feature files go here)


After you run `gradlew build`, a new **build** directory will automatically be created. This will contain all of the generated files (compiled class files, JAR files, reports, etc.). The most important things here are as follows:

**build/reports/tests/test/index.html**
: This file holds the results of all of the unit tests.

**build/libs/machiwoco.jar**
: This file is the fully bundled code for the project. You can run this by saying
  `java -jar build/libs/machiwoco.jar` from the project root.

After you run `gradlew cucumber`, a **reports/cucumber** directory will be created in the **build** directory. This will contain the reports for the acceptance tests.

**build/reports/cucumber/index.html**
: This file holds the Cucumber acceptance test results.

After you run `gradlew jacocoTestReport`, a **reports/jacoco/test/html** directory will be created in the **build** directory. This will contain the reports for the Jacoco code coverage.
  
**build/reports/jacoco/test/html/index.html**
: This file holds the unit test code coverage results from JaCoCo.

After you run `gradlew javadoc`, a **docs** directory will be created within the **build** directory. This will contain all of the generated Javadoc documentation for your source files.  

**build/docs/javadoc/index.html**
: This file is the index to the generated documentation.


### IDE Setup

#### Intellij
If you use Intellij, you can set up gradle for it as follows:

`gradlew cleanIdea idea`


#### Eclipse
If you use Eclipse, you can set up gradle for it as follows:

`gradlew cleanEclipse eclipse`



## Full Console Playthrough
---------------------------
A complete game using the console interface between a single human player and two AI players is presented below. It is provided here as a reference for both how the game is played and how the console interface should look and behave. Note that the player's responses to the prompts do not appear here because they were entered on the terminal. However, the choices that were made are clear from the subsequent output from the program.


    The game has started. Player 1 will go    
    first.                                    
    Turn started for Player 1.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #2
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Cheese Factory     GF (5)  [7]      #2
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    
                 Player 1* [YOU]              
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 1 rolled [5] = 5.                  
                                              
    Player 1, would you like to purchase an   
    establishment or construct a landmark? (3 
    coins)                                    
    (To view details of an item, type 'view'  
    followed by the item number. For example, 
    to view item 6, type 'view 6'.)           
    ========================================== 
    ---------        PURCHASE        --------- 
     1. Wheat Field        BW (1)  [1]      #2 
     2. Ranch              BC (1)  [2]      #1 
     3. Bakery             GB (1)  [2-3]    #3 
     4. Cafe               RU (2)  [3]      #1 
     5. Convenience Store  GB (2)  [4]      #2 
     6. Family Restaurant  RU (3)  [9-10]   #3 
     7. Apple Orchard      BW (3)  [10]     #1 
     8. Farmers Market     GO (2)  [11-12]  #1 
    ---------         CANCEL         --------- 
    99. Do nothing                            
    ========================================== 
    Choose a number to purchase or construct: 
    Player 1 purchased the Ranch.             
    Turn ended for Player 1.                  
    Turn started for Player 2.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #2
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Cheese Factory     GF (5)  [7]      #2
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (2 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 2*                 
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 2 rolled [6] = 6.                  
    Player 2 purchased the Apple Orchard.     
    Turn ended for Player 2.                  
    Turn started for Player 3.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #2
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Cheese Factory     GF (5)  [7]      #2
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Farmers Market     GO (2)  [11-12]  #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (2 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #1
    Apple Orchard      BW (3)  [10]     #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 3*                 
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 3 rolled [5] = 5.                  
    Player 3 purchased the Cafe.              
    Turn ended for Player 3.                  
    Turn started for Player 1.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #2
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Cheese Factory     GF (5)  [7]      #2
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Farmers Market     GO (2)  [11-12]  #1
    
                 Player 1* [YOU]              
    ------------------------------------------
                    (2 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #1
    Apple Orchard      BW (3)  [10]     #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #1
    Cafe               RU (2)  [3]      #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 1 rolled [4] = 4.                  
                                              
    Player 1, would you like to purchase an   
    establishment or construct a landmark? (2 
    coins)                                    
    (To view details of an item, type 'view'  
    followed by the item number. For example, 
    to view item 6, type 'view 6'.)           
    ========================================== 
    ---------        PURCHASE        --------- 
     1. Wheat Field        BW (1)  [1]      #2 
     2. Ranch              BC (1)  [2]      #2 
     3. Bakery             GB (1)  [2-3]    #3 
     4. Cafe               RU (2)  [3]      #1 
     5. Convenience Store  GB (2)  [4]      #2 
     6. Farmers Market     GO (2)  [11-12]  #1 
    ---------         CANCEL         --------- 
    99. Do nothing                            
    ========================================== 
    Choose a number to purchase or construct: 
    Player 1 purchased the Convenience Store. 
    Turn ended for Player 1.                  
    Turn started for Player 2.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Cheese Factory     GF (5)  [7]      #2
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Farmers Market     GO (2)  [11-12]  #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 2*                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #1
    Apple Orchard      BW (3)  [10]     #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #1
    Cafe               RU (2)  [3]      #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 2 rolled [6] = 6.                  
    Player 2 did not have enough money to make 
    improvements.                             
    Turn ended for Player 2.                  
    Turn started for Player 3.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Cheese Factory     GF (5)  [7]      #2
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Farmers Market     GO (2)  [11-12]  #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #1
    Apple Orchard      BW (3)  [10]     #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 3*                 
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #1
    Cafe               RU (2)  [3]      #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 3 rolled [6] = 6.                  
    Player 3 purchased the Bakery.            
    Turn ended for Player 3.                  
    Turn started for Player 1.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #2
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Cheese Factory     GF (5)  [7]      #2
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Farmers Market     GO (2)  [11-12]  #1
    
                 Player 1* [YOU]              
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #1
    Apple Orchard      BW (3)  [10]     #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #2
    Cafe               RU (2)  [3]      #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 1 rolled [4] = 4.                  
    Convenience Store activated for Player 1. 
                                              
    Player 1, would you like to purchase an   
    establishment or construct a landmark? (3 
    coins)                                    
    (To view details of an item, type 'view'  
    followed by the item number. For example, 
    to view item 6, type 'view 6'.)           
    ========================================== 
    ---------        PURCHASE        --------- 
     1. Wheat Field        BW (1)  [1]      #2 
     2. Ranch              BC (1)  [2]      #2 
     3. Bakery             GB (1)  [2-3]    #2 
     4. Cafe               RU (2)  [3]      #1 
     5. Convenience Store  GB (2)  [4]      #1 
     6. Furniture Factory  GF (3)  [8]      #1 
     7. Family Restaurant  RU (3)  [9-10]   #3 
     8. Farmers Market     GO (2)  [11-12]  #1 
    ---------         CANCEL         --------- 
    99. Do nothing                            
    ========================================== 
    Choose a number to purchase or construct: 
    Player 1 purchased the Wheat Field.       
    Turn ended for Player 1.                  
    Turn started for Player 2.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Wheat Field        BW (1)  [1]      #1
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #2
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Cheese Factory     GF (5)  [7]      #2
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Farmers Market     GO (2)  [11-12]  #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (2 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 2*                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #1
    Apple Orchard      BW (3)  [10]     #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #2
    Cafe               RU (2)  [3]      #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 2 rolled [4] = 4.                  
    Player 2 did not have enough money to make 
    improvements.                             
    Turn ended for Player 2.                  
    Turn started for Player 3.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Wheat Field        BW (1)  [1]      #1
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #2
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Cheese Factory     GF (5)  [7]      #2
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Farmers Market     GO (2)  [11-12]  #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (2 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #1
    Apple Orchard      BW (3)  [10]     #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 3*                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #2
    Cafe               RU (2)  [3]      #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 3 rolled [1] = 1.                  
    Wheat Field activated for Player 3.       
    Wheat Field activated for Player 1.       
    Wheat Field activated for Player 2.       
    Player 3 purchased the Ranch.             
    Turn ended for Player 3.                  
    Turn started for Player 1.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Wheat Field        BW (1)  [1]      #1
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #2
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Cheese Factory     GF (5)  [7]      #2
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Farmers Market     GO (2)  [11-12]  #1
    
                 Player 1* [YOU]              
    ------------------------------------------
                    (4 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #1
    Apple Orchard      BW (3)  [10]     #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #2
    Cafe               RU (2)  [3]      #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 1 rolled [1] = 1.                  
    Wheat Field activated for Player 1.       
    Wheat Field activated for Player 2.       
    Wheat Field activated for Player 3.       
                                              
    Player 1, would you like to purchase an   
    establishment or construct a landmark? (6 
    coins)                                    
    (To view details of an item, type 'view'  
    followed by the item number. For example, 
    to view item 6, type 'view 6'.)           
    ========================================== 
    ---------        PURCHASE        --------- 
     1. Wheat Field        BW (1)  [1]      #1 
     2. Ranch              BC (1)  [2]      #1 
     3. Bakery             GB (1)  [2-3]    #2 
     4. Cafe               RU (2)  [3]      #1 
     5. Convenience Store  GB (2)  [4]      #1 
     6. Stadium            PT (6)  [6]      #1 
     7. Cheese Factory     GF (5)  [7]      #2 
     8. Furniture Factory  GF (3)  [8]      #1 
     9. Mine               BG (6)  [9]      #4 
    10. Family Restaurant  RU (3)  [9-10]   #3 
    11. Farmers Market     GO (2)  [11-12]  #1 
    ---------       CONSTRUCT        --------- 
    12. Train Station      NT (4)  [ ]        
    ---------         CANCEL         --------- 
    99. Do nothing                            
    ========================================== 
    Choose a number to purchase or construct: 
    Player 1 purchased the Stadium.           
    Turn ended for Player 1.                  
    Turn started for Player 2.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Wheat Field        BW (1)  [1]      #1
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #2
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    TV Station         PT (7)  [6]      #2
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #2
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Farmers Market     GO (2)  [11-12]  #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Stadium            PT (6)  [6]      #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 2*                 
    ------------------------------------------
                    (2 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #1
    Apple Orchard      BW (3)  [10]     #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #1
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #2
    Cafe               RU (2)  [3]      #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 2 rolled [6] = 6.                  
    Player 2 purchased the Wheat Field.       
    Turn ended for Player 2.                  
    Turn started for Player 3.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Wheat Field        BW (1)  [1]      #1
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #2
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    TV Station         PT (7)  [6]      #2
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #2
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Farmers Market     GO (2)  [11-12]  #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Stadium            PT (6)  [6]      #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #2
    Bakery             GB (1)  [2-3]    #1
    Apple Orchard      BW (3)  [10]     #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 3*                 
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #1
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #2
    Cafe               RU (2)  [3]      #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 3 rolled [6] = 6.                  
    Player 3 purchased the Wheat Field.       
    Turn ended for Player 3.                  
    Turn started for Player 1.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #2
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #2
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #2
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #2
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Farmers Market     GO (2)  [11-12]  #1
    
                 Player 1* [YOU]              
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Stadium            PT (6)  [6]      #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #2
    Bakery             GB (1)  [2-3]    #1
    Apple Orchard      BW (3)  [10]     #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #2
    Cafe               RU (2)  [3]      #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 1 rolled [1] = 1.                  
    Wheat Field activated for Player 1.       
    Wheat Field activated for Player 2.       
    Wheat Field activated for Player 3.       
                                              
    Player 1, would you like to purchase an   
    establishment or construct a landmark? (2 
    coins)                                    
    (To view details of an item, type 'view'  
    followed by the item number. For example, 
    to view item 6, type 'view 6'.)           
    ========================================== 
    ---------        PURCHASE        --------- 
     1. Ranch              BC (1)  [2]      #2 
     2. Bakery             GB (1)  [2-3]    #2 
     3. Cafe               RU (2)  [3]      #1 
     4. Convenience Store  GB (2)  [4]      #2 
     5. Farmers Market     GO (2)  [11-12]  #1 
    ---------         CANCEL         --------- 
    99. Do nothing                            
    ========================================== 
    Choose a number to purchase or construct: 
    Player 1 purchased the Farmers Market.    
    Turn ended for Player 1.                  
    Turn started for Player 2.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #2
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #2
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #2
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #2
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Farmers Market     GO (2)  [11-12]  #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Stadium            PT (6)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 2*                 
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Bakery             GB (1)  [2-3]    #1
    Apple Orchard      BW (3)  [10]     #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (2 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #2
    Cafe               RU (2)  [3]      #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 2 rolled [3] = 3.                  
    Cafe activated for Player 3.              
    Bakery activated for Player 2.            
    Player 2 purchased the Farmers Market.    
    Turn ended for Player 2.                  
    Turn started for Player 3.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #2
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #2
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #2
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #2
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Farmers Market     GO (2)  [11-12]  #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Stadium            PT (6)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #2
    Bakery             GB (1)  [2-3]    #1
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 3*                 
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #2
    Cafe               RU (2)  [3]      #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 3 rolled [1] = 1.                  
    Wheat Field activated for Player 3.       
    Wheat Field activated for Player 1.       
    Wheat Field activated for Player 2.       
    Player 3 purchased the Ranch.             
    Turn ended for Player 3.                  
    Turn started for Player 1.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #2
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #2
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #2
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #2
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Farmers Market     GO (2)  [11-12]  #1
    
                 Player 1* [YOU]              
    ------------------------------------------
                    (2 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Stadium            PT (6)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Bakery             GB (1)  [2-3]    #1
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (4 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #2
    Cafe               RU (2)  [3]      #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 1 rolled [6] = 6.                  
    Stadium activated for Player 1.           
                                              
    Player 1, would you like to purchase an   
    establishment or construct a landmark? (6 
    coins)                                    
    (To view details of an item, type 'view'  
    followed by the item number. For example, 
    to view item 6, type 'view 6'.)           
    ========================================== 
    ---------        PURCHASE        --------- 
     1. Ranch              BC (1)  [2]      #1 
     2. Bakery             GB (1)  [2-3]    #2 
     3. Cafe               RU (2)  [3]      #1 
     4. Convenience Store  GB (2)  [4]      #2 
     5. Forest             BG (3)  [5]      #1 
     6. Cheese Factory     GF (5)  [7]      #2 
     7. Furniture Factory  GF (3)  [8]      #1 
     8. Mine               BG (6)  [9]      #4 
     9. Family Restaurant  RU (3)  [9-10]   #3 
    10. Farmers Market     GO (2)  [11-12]  #1 
    ---------       CONSTRUCT        --------- 
    11. Train Station      NT (4)  [ ]        
    ---------         CANCEL         --------- 
    99. Do nothing                            
    ========================================== 
    Choose a number to purchase or construct: 
    Player 1 purchased the Forest.            
    Turn ended for Player 1.                  
    Turn started for Player 2.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #2
    Convenience Store  GB (2)  [4]      #2
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #2
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #2
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Farmers Market     GO (2)  [11-12]  #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Stadium            PT (6)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 2*                 
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #2
    Bakery             GB (1)  [2-3]    #1
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (2 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #2
    Cafe               RU (2)  [3]      #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 2 rolled [3] = 3.                  
    Cafe activated for Player 3.              
    Bakery activated for Player 2.            
    Player 2 purchased the Ranch.             
    Turn ended for Player 2.                  
    Turn started for Player 3.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #2
    Convenience Store  GB (2)  [4]      #2
    Forest             BG (3)  [5]      #2
    TV Station         PT (7)  [6]      #2
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #2
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Farmers Market     GO (2)  [11-12]  #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Stadium            PT (6)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 3*                 
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #2
    Cafe               RU (2)  [3]      #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 3 rolled [1] = 1.                  
    Wheat Field activated for Player 3.       
    Wheat Field activated for Player 1.       
    Wheat Field activated for Player 2.       
    Player 3 constructed the Train Station.   
    Turn ended for Player 3.                  
    Turn started for Player 1.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #2
    Convenience Store  GB (2)  [4]      #2
    Forest             BG (3)  [5]      #2
    TV Station         PT (7)  [6]      #2
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #2
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Farmers Market     GO (2)  [11-12]  #1
    
                 Player 1* [YOU]              
    ------------------------------------------
                    (5 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Stadium            PT (6)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (2 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #2
    Cafe               RU (2)  [3]      #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 1 rolled [5] = 5.                  
    Forest activated for Player 1.            
                                              
    Player 1, would you like to purchase an   
    establishment or construct a landmark? (6 
    coins)                                    
    (To view details of an item, type 'view'  
    followed by the item number. For example, 
    to view item 6, type 'view 6'.)           
    ========================================== 
    ---------        PURCHASE        --------- 
     1. Ranch              BC (1)  [2]      #1 
     2. Bakery             GB (1)  [2-3]    #3 
     3. Cafe               RU (2)  [3]      #2 
     4. Convenience Store  GB (2)  [4]      #2 
     5. Forest             BG (3)  [5]      #2 
     6. Cheese Factory     GF (5)  [7]      #2 
     7. Furniture Factory  GF (3)  [8]      #1 
     8. Mine               BG (6)  [9]      #4 
     9. Family Restaurant  RU (3)  [9-10]   #3 
    10. Farmers Market     GO (2)  [11-12]  #1 
    ---------       CONSTRUCT        --------- 
    11. Train Station      NT (4)  [ ]        
    ---------         CANCEL         --------- 
    99. Do nothing                            
    ========================================== 
    Choose a number to purchase or construct: 
    Player 1 purchased the Forest.            
    Turn ended for Player 1.                  
    Turn started for Player 2.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #2
    Convenience Store  GB (2)  [4]      #2
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #2
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #2
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Farmers Market     GO (2)  [11-12]  #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #2
    Stadium            PT (6)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 2*                 
    ------------------------------------------
                    (2 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #2
    Cafe               RU (2)  [3]      #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 2 rolled [2] = 2.                  
    Ranch activated for Player 2.             
    Ranch activated for Player 3.             
    Ranch activated for Player 1.             
    Bakery activated for Player 2.            
    Player 2 constructed the Train Station.   
    Turn ended for Player 2.                  
    Turn started for Player 3.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #2
    Convenience Store  GB (2)  [4]      #2
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #2
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #2
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Farmers Market     GO (2)  [11-12]  #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (4 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #2
    Stadium            PT (6)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 3*                 
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #2
    Cafe               RU (2)  [3]      #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 3 rolled [6][1] = 7.               
    Player 3 purchased the Farmers Market.    
    Turn ended for Player 3.                  
    Turn started for Player 1.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #2
    Convenience Store  GB (2)  [4]      #2
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #2
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #3
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Apple Orchard      BW (3)  [10]     #1
    
                 Player 1* [YOU]              
    ------------------------------------------
                    (4 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #2
    Stadium            PT (6)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #2
    Cafe               RU (2)  [3]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 1 rolled [5] = 5.                  
    Forest activated for Player 1.            
                                              
    Player 1, would you like to purchase an   
    establishment or construct a landmark? (6 
    coins)                                    
    (To view details of an item, type 'view'  
    followed by the item number. For example, 
    to view item 6, type 'view 6'.)           
    ========================================== 
    ---------        PURCHASE        --------- 
     1. Ranch              BC (1)  [2]      #1 
     2. Bakery             GB (1)  [2-3]    #3 
     3. Cafe               RU (2)  [3]      #2 
     4. Convenience Store  GB (2)  [4]      #2 
     5. Forest             BG (3)  [5]      #1 
     6. Cheese Factory     GF (5)  [7]      #3 
     7. Furniture Factory  GF (3)  [8]      #1 
     8. Mine               BG (6)  [9]      #4 
     9. Family Restaurant  RU (3)  [9-10]   #3 
    10. Apple Orchard      BW (3)  [10]     #1 
    ---------       CONSTRUCT        --------- 
    11. Train Station      NT (4)  [ ]        
    ---------         CANCEL         --------- 
    99. Do nothing                            
    ========================================== 
    Choose a number to purchase or construct: 
    Player 1 purchased the Forest.            
    Turn ended for Player 1.                  
    Turn started for Player 2.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Wheat Field        BW (1)  [1]      #1
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #5
    Cafe               RU (2)  [3]      #2
    Convenience Store  GB (2)  [4]      #4
    TV Station         PT (7)  [6]      #2
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #3
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Apple Orchard      BW (3)  [10]     #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 2*                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #2
    Cafe               RU (2)  [3]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 2 rolled [3] = 3.                  
    Cafe activated for Player 3.              
    Bakery activated for Player 2.            
    Player 2 purchased the Wheat Field.       
    Turn ended for Player 2.                  
    Turn started for Player 3.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #5
    Cafe               RU (2)  [3]      #2
    Convenience Store  GB (2)  [4]      #4
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #2
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #3
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Apple Orchard      BW (3)  [10]     #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 3*                 
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #2
    Cafe               RU (2)  [3]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 3 rolled [2][3] = 5.               
    Forest activated for Player 1.            
    Player 3 purchased the Bakery.            
    Turn ended for Player 3.                  
    Turn started for Player 1.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #2
    Convenience Store  GB (2)  [4]      #4
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #2
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #3
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Apple Orchard      BW (3)  [10]     #1
    
                 Player 1* [YOU]              
    ------------------------------------------
                    (6 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 1 rolled [5] = 5.                  
    Forest activated for Player 1.            
                                              
    Player 1, would you like to purchase an   
    establishment or construct a landmark? (9 
    coins)                                    
    (To view details of an item, type 'view'  
    followed by the item number. For example, 
    to view item 6, type 'view 6'.)           
    ========================================== 
    ---------        PURCHASE        --------- 
     1. Ranch              BC (1)  [2]      #1 
     2. Bakery             GB (1)  [2-3]    #4 
     3. Cafe               RU (2)  [3]      #2 
     4. Convenience Store  GB (2)  [4]      #4 
     5. Forest             BG (3)  [5]      #1 
     6. TV Station         PT (7)  [6]      #2 
     7. Business Complex   PT (8)  [6]      #1 
     8. Cheese Factory     GF (5)  [7]      #3 
     9. Furniture Factory  GF (3)  [8]      #1 
    10. Mine               BG (6)  [9]      #4 
    11. Family Restaurant  RU (3)  [9-10]   #3 
    12. Apple Orchard      BW (3)  [10]     #1 
    ---------       CONSTRUCT        --------- 
    13. Train Station      NT (4)  [ ]        
    ---------         CANCEL         --------- 
    99. Do nothing                            
    ========================================== 
    Choose a number to purchase or construct: 
    Player 1 purchased the Business Complex.  
    Turn ended for Player 1.                  
    Turn started for Player 2.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #2
    Convenience Store  GB (2)  [4]      #4
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #2
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #3
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Apple Orchard      BW (3)  [10]     #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 2*                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 2 rolled [3] = 3.                  
    Cafe activated for Player 3.              
    Bakery activated for Player 2.            
    Player 2 purchased the Ranch.             
    Turn ended for Player 2.                  
    Turn started for Player 3.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #4
    Convenience Store  GB (2)  [4]      #4
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #2
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #3
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Apple Orchard      BW (3)  [10]     #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #1
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 3*                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 3 rolled [4] = 4.                  
    Player 3 did not have enough money to make 
    improvements.                             
    Turn ended for Player 3.                  
    Turn started for Player 1.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #4
    Convenience Store  GB (2)  [4]      #4
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #2
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #3
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Apple Orchard      BW (3)  [10]     #1
    
                 Player 1* [YOU]              
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #1
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 1 rolled [6] = 6.                  
    Stadium activated for Player 1.           
    Business Complex activated for Player 1.  
    -------     AVAILABLE PLAYERS      ------- 
    1. Player 2             (0 coins)         
    2. Player 3             (0 coins)         
    Player 1, who would you like to target?   
    -------  AVAILABLE ESTABLISHMENTS  ------- 
                     Player 2                 
     1. Wheat Field        BW (1)  [1]        
     2. Ranch              BC (1)  [2]        
     3. Apple Orchard      BW (3)  [10]       
     4. Farmers Market     GO (2)  [11-12]    
    Player 1, select an establishment:        
    -------  AVAILABLE ESTABLISHMENTS  ------- 
                     Player 1                 
     1. Wheat Field        BW (1)  [1]        
     2. Ranch              BC (1)  [2]        
     3. Convenience Store  GB (2)  [4]        
     4. Forest             BG (3)  [5]        
     5. Farmers Market     GO (2)  [11-12]    
    Player 1, select an establishment:        
                                              
    Player 1, would you like to purchase an   
    establishment or construct a landmark? (1 
    coin)                                     
    (To view details of an item, type 'view'  
    followed by the item number. For example, 
    to view item 6, type 'view 6'.)           
    ========================================== 
    ---------        PURCHASE        --------- 
     1. Ranch              BC (1)  [2]      #1 
     2. Bakery             GB (1)  [2-3]    #4 
    ---------         CANCEL         --------- 
    99. Do nothing                            
    ========================================== 
    Choose a number to purchase or construct: 
    Player 1 chose not to make improvements.  
    Turn ended for Player 1.                  
    Turn started for Player 2.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #4
    Convenience Store  GB (2)  [4]      #4
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #2
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #3
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Apple Orchard      BW (3)  [10]     #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #2
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 2*                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Apple Orchard      BW (3)  [10]     #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 2 rolled [1] = 1.                  
    Wheat Field activated for Player 2.       
    Wheat Field activated for Player 3.       
    Wheat Field activated for Player 1.       
    Player 2 purchased the Forest.            
    Turn ended for Player 2.                  
    Turn started for Player 3.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Wheat Field        BW (1)  [1]      #1
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #4
    Convenience Store  GB (2)  [4]      #4
    TV Station         PT (7)  [6]      #2
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #3
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Apple Orchard      BW (3)  [10]     #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #1
    Apple Orchard      BW (3)  [10]     #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 3*                 
    ------------------------------------------
                    (2 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 3 rolled [4] = 4.                  
    Player 3 purchased the Convenience Store. 
    Turn ended for Player 3.                  
    Turn started for Player 1.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Wheat Field        BW (1)  [1]      #1
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #4
    Convenience Store  GB (2)  [4]      #3
    TV Station         PT (7)  [6]      #2
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #3
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Apple Orchard      BW (3)  [10]     #1
    
                 Player 1* [YOU]              
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #1
    Apple Orchard      BW (3)  [10]     #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 1 rolled [1] = 1.                  
    Wheat Field activated for Player 1.       
    Wheat Field activated for Player 2.       
    Wheat Field activated for Player 3.       
                                              
    Player 1, would you like to purchase an   
    establishment or construct a landmark? (5 
    coins)                                    
    (To view details of an item, type 'view'  
    followed by the item number. For example, 
    to view item 6, type 'view 6'.)           
    ========================================== 
    ---------        PURCHASE        --------- 
     1. Wheat Field        BW (1)  [1]      #1 
     2. Ranch              BC (1)  [2]      #1 
     3. Bakery             GB (1)  [2-3]    #4 
     4. Cafe               RU (2)  [3]      #4 
     5. Convenience Store  GB (2)  [4]      #3 
     6. Cheese Factory     GF (5)  [7]      #3 
     7. Furniture Factory  GF (3)  [8]      #1 
     8. Family Restaurant  RU (3)  [9-10]   #3 
     9. Apple Orchard      BW (3)  [10]     #1 
    ---------       CONSTRUCT        --------- 
    10. Train Station      NT (4)  [ ]        
    ---------         CANCEL         --------- 
    99. Do nothing                            
    ========================================== 
    Choose a number to purchase or construct: 
    Player 1 purchased the Wheat Field.       
    Turn ended for Player 1.                  
    Turn started for Player 2.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Wheat Field        BW (1)  [1]      #1
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #4
    Convenience Store  GB (2)  [4]      #3
    TV Station         PT (7)  [6]      #2
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #3
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Apple Orchard      BW (3)  [10]     #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (4 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 2*                 
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #1
    Apple Orchard      BW (3)  [10]     #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (2 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 2 rolled [5] = 5.                  
    Forest activated for Player 2.            
    Forest activated for Player 1.            
    Player 2 purchased the Apple Orchard.     
    Turn ended for Player 2.                  
    Turn started for Player 3.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Wheat Field        BW (1)  [1]      #1
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #4
    Convenience Store  GB (2)  [4]      #3
    TV Station         PT (7)  [6]      #2
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #3
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #3
    Apple Orchard      BW (3)  [10]     #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (7 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #1
    Apple Orchard      BW (3)  [10]     #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 3*                 
    ------------------------------------------
                    (2 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 3 rolled [2] = 2.                  
    Ranch activated for Player 3.             
    Ranch activated for Player 2.             
    Bakery activated for Player 3.            
    Player 3 purchased the Mine.              
    Turn ended for Player 3.                  
    Turn started for Player 1.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Wheat Field        BW (1)  [1]      #1
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #4
    Convenience Store  GB (2)  [4]      #3
    TV Station         PT (7)  [6]      #2
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #3
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #3
    Family Restaurant  RU (3)  [9-10]   #3
    Apple Orchard      BW (3)  [10]     #1
    
                 Player 1* [YOU]              
    ------------------------------------------
                    (7 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (4 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #1
    Apple Orchard      BW (3)  [10]     #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    Mine               BG (6)  [9]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 1 rolled [3] = 3.                  
    Cafe activated for Player 3.              
    Bakery activated for Player 1.            
                                              
    Player 1, would you like to purchase an   
    establishment or construct a landmark? (7 
    coins)                                    
    (To view details of an item, type 'view'  
    followed by the item number. For example, 
    to view item 6, type 'view 6'.)           
    ========================================== 
    ---------        PURCHASE        --------- 
     1. Wheat Field        BW (1)  [1]      #1 
     2. Ranch              BC (1)  [2]      #1 
     3. Bakery             GB (1)  [2-3]    #4 
     4. Cafe               RU (2)  [3]      #4 
     5. Convenience Store  GB (2)  [4]      #3 
     6. TV Station         PT (7)  [6]      #2 
     7. Cheese Factory     GF (5)  [7]      #3 
     8. Furniture Factory  GF (3)  [8]      #1 
     9. Mine               BG (6)  [9]      #3 
    10. Family Restaurant  RU (3)  [9-10]   #3 
    11. Apple Orchard      BW (3)  [10]     #1 
    ---------       CONSTRUCT        --------- 
    12. Train Station      NT (4)  [ ]        
    ---------         CANCEL         --------- 
    99. Do nothing                            
    ========================================== 
    Choose a number to purchase or construct: 
    Player 1 purchased the TV Station.        
    Turn ended for Player 1.                  
    Turn started for Player 2.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Wheat Field        BW (1)  [1]      #1
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #4
    Convenience Store  GB (2)  [4]      #3
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #3
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #3
    Family Restaurant  RU (3)  [9-10]   #3
    Apple Orchard      BW (3)  [10]     #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 2*                 
    ------------------------------------------
                    (4 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #1
    Apple Orchard      BW (3)  [10]     #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (2 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    Mine               BG (6)  [9]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 2 rolled [6] = 6.                  
    Player 2 purchased the Apple Orchard.     
    Turn ended for Player 2.                  
    Turn started for Player 3.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Wheat Field        BW (1)  [1]      #1
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #4
    Convenience Store  GB (2)  [4]      #3
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #4
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #3
    Family Restaurant  RU (3)  [9-10]   #3
    Apple Orchard      BW (3)  [10]     #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #1
    Apple Orchard      BW (3)  [10]     #3
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 3*                 
    ------------------------------------------
                    (2 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    Mine               BG (6)  [9]      #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 3 rolled [1][2] = 3.               
    Bakery activated for Player 3.            
    Player 3 purchased the Apple Orchard.     
    Turn ended for Player 3.                  
    Turn started for Player 1.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Wheat Field        BW (1)  [1]      #1
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #4
    Convenience Store  GB (2)  [4]      #3
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #4
    Furniture Factory  GF (3)  [8]      #3
    Mine               BG (6)  [9]      #5
    Family Restaurant  RU (3)  [9-10]   #3
    Farmers Market     GO (2)  [11-12]  #1
    
                 Player 1* [YOU]              
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #1
    Apple Orchard      BW (3)  [10]     #3
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (2 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    Mine               BG (6)  [9]      #1
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 1 rolled [2] = 2.                  
    Ranch activated for Player 2.             
    Ranch activated for Player 3.             
    Bakery activated for Player 1.            
                                              
    Player 1, would you like to purchase an   
    establishment or construct a landmark? (1 
    coin)                                     
    (To view details of an item, type 'view'  
    followed by the item number. For example, 
    to view item 6, type 'view 6'.)           
    ========================================== 
    ---------        PURCHASE        --------- 
     1. Wheat Field        BW (1)  [1]      #1 
     2. Ranch              BC (1)  [2]      #1 
     3. Bakery             GB (1)  [2-3]    #4 
    ---------         CANCEL         --------- 
    99. Do nothing                            
    ========================================== 
    Choose a number to purchase or construct: 
    Player 1 purchased the Wheat Field.       
    Turn ended for Player 1.                  
    Turn started for Player 2.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #4
    Convenience Store  GB (2)  [4]      #3
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #4
    Furniture Factory  GF (3)  [8]      #3
    Mine               BG (6)  [9]      #5
    Family Restaurant  RU (3)  [9-10]   #3
    Farmers Market     GO (2)  [11-12]  #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #4
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 2*                 
    ------------------------------------------
                    (4 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #1
    Apple Orchard      BW (3)  [10]     #3
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (4 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    Mine               BG (6)  [9]      #1
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 2 rolled [6][6] = 12.              
    Player 2 purchased the Farmers Market.    
    Turn ended for Player 2.                  
    Turn started for Player 3.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #4
    Convenience Store  GB (2)  [4]      #3
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #4
    Furniture Factory  GF (3)  [8]      #5
    Mine               BG (6)  [9]      #5
    Family Restaurant  RU (3)  [9-10]   #3
    Farmers Market     GO (2)  [11-12]  #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #4
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (2 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #1
    Apple Orchard      BW (3)  [10]     #3
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 3*                 
    ------------------------------------------
                    (4 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    Mine               BG (6)  [9]      #1
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 3 rolled [6][1] = 7.               
    Player 3 purchased the Family Restaurant. 
    Turn ended for Player 3.                  
    Turn started for Player 1.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #4
    Convenience Store  GB (2)  [4]      #3
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #4
    Furniture Factory  GF (3)  [8]      #5
    Mine               BG (6)  [9]      #5
    Family Restaurant  RU (3)  [9-10]   #2
    Farmers Market     GO (2)  [11-12]  #1
    
                 Player 1* [YOU]              
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #4
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (2 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #1
    Apple Orchard      BW (3)  [10]     #3
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    Mine               BG (6)  [9]      #1
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 1 rolled [1] = 1.                  
    Wheat Field activated for Player 1.       
    Wheat Field activated for Player 2.       
    Wheat Field activated for Player 3.       
                                              
    Player 1, would you like to purchase an   
    establishment or construct a landmark? (4 
    coins)                                    
    (To view details of an item, type 'view'  
    followed by the item number. For example, 
    to view item 6, type 'view 6'.)           
    ========================================== 
    ---------        PURCHASE        --------- 
     1. Ranch              BC (1)  [2]      #1 
     2. Bakery             GB (1)  [2-3]    #4 
     3. Cafe               RU (2)  [3]      #4 
     4. Convenience Store  GB (2)  [4]      #3 
     5. Forest             BG (3)  [5]      #1 
     6. Furniture Factory  GF (3)  [8]      #5 
     7. Family Restaurant  RU (3)  [9-10]   #2 
     8. Farmers Market     GO (2)  [11-12]  #1 
    ---------       CONSTRUCT        --------- 
     9. Train Station      NT (4)  [ ]        
    ---------         CANCEL         --------- 
    99. Do nothing                            
    ========================================== 
    Choose a number to purchase or construct: 
    Player 1 constructed the Train Station.   
    Turn ended for Player 1.                  
    Turn started for Player 2.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #4
    Convenience Store  GB (2)  [4]      #3
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #4
    Furniture Factory  GF (3)  [8]      #5
    Mine               BG (6)  [9]      #5
    Family Restaurant  RU (3)  [9-10]   #2
    Farmers Market     GO (2)  [11-12]  #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #4
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 2*                 
    ------------------------------------------
                    (5 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #1
    Apple Orchard      BW (3)  [10]     #3
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    Mine               BG (6)  [9]      #1
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 2 rolled [4][6] = 10.              
    Family Restaurant activated for Player 3. 
    Apple Orchard activated for Player 2.     
    Apple Orchard activated for Player 3.     
    Player 2 constructed the Shopping Mall.   
    Turn ended for Player 2.                  
    Turn started for Player 3.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #4
    Convenience Store  GB (2)  [4]      #3
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #4
    Furniture Factory  GF (3)  [8]      #5
    Mine               BG (6)  [9]      #5
    Family Restaurant  RU (3)  [9-10]   #2
    Farmers Market     GO (2)  [11-12]  #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #4
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (2 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #1
    Apple Orchard      BW (3)  [10]     #3
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 3*                 
    ------------------------------------------
                    (8 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    Mine               BG (6)  [9]      #1
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 3 rolled [2] = 2.                  
    Ranch activated for Player 3.             
    Ranch activated for Player 2.             
    Bakery activated for Player 3.            
    Player 3 purchased the Forest.            
    Turn ended for Player 3.                  
    Turn started for Player 1.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #4
    Convenience Store  GB (2)  [4]      #3
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #4
    Furniture Factory  GF (3)  [8]      #5
    Mine               BG (6)  [9]      #5
    Family Restaurant  RU (3)  [9-10]   #2
    Farmers Market     GO (2)  [11-12]  #1
    
                 Player 1* [YOU]              
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #4
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (5 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #1
    Apple Orchard      BW (3)  [10]     #3
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (10 coins)                
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Mine               BG (6)  [9]      #1
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 1, would you like to roll 1 or 2   
    dice?                                     
    Player 1 rolled [1][6] = 7.               
    Player 1 did not have enough money to make 
    improvements.                             
    Turn ended for Player 1.                  
    Turn started for Player 2.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #4
    Convenience Store  GB (2)  [4]      #3
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #4
    Furniture Factory  GF (3)  [8]      #5
    Mine               BG (6)  [9]      #5
    Family Restaurant  RU (3)  [9-10]   #2
    Farmers Market     GO (2)  [11-12]  #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #4
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 2*                 
    ------------------------------------------
                    (5 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #1
    Apple Orchard      BW (3)  [10]     #3
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (10 coins)                
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Mine               BG (6)  [9]      #1
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 2 rolled [6][4] = 10.              
    Family Restaurant activated for Player 3. 
    Apple Orchard activated for Player 2.     
    Apple Orchard activated for Player 3.     
    Player 2 purchased the Farmers Market.    
    Turn ended for Player 2.                  
    Turn started for Player 3.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #4
    Convenience Store  GB (2)  [4]      #3
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #4
    Furniture Factory  GF (3)  [8]      #5
    Mine               BG (6)  [9]      #5
    Family Restaurant  RU (3)  [9-10]   #2
    Apple Orchard      BW (3)  [10]     #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #4
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (10 coins)                
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #1
    Apple Orchard      BW (3)  [10]     #3
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 3*                 
    ------------------------------------------
                    (15 coins)                
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Mine               BG (6)  [9]      #1
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 3 rolled [2][2] = 4.               
    Convenience Store activated for Player 3. 
    Player 3 constructed the Amusement Park.  
    Turn started for Player 3.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #4
    Convenience Store  GB (2)  [4]      #3
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #4
    Furniture Factory  GF (3)  [8]      #5
    Mine               BG (6)  [9]      #5
    Family Restaurant  RU (3)  [9-10]   #2
    Apple Orchard      BW (3)  [10]     #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #4
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (10 coins)                
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #1
    Apple Orchard      BW (3)  [10]     #3
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 3*                 
    ------------------------------------------
                    (2 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Mine               BG (6)  [9]      #1
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 3 rolled [5] = 5.                  
    Forest activated for Player 3.            
    Forest activated for Player 1.            
    Forest activated for Player 2.            
    Player 3 purchased the Bakery.            
    Turn ended for Player 3.                  
    Turn started for Player 1.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #4
    Convenience Store  GB (2)  [4]      #3
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #4
    Furniture Factory  GF (3)  [8]      #5
    Mine               BG (6)  [9]      #5
    Family Restaurant  RU (3)  [9-10]   #2
    Apple Orchard      BW (3)  [10]     #1
    
                 Player 1* [YOU]              
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #4
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (11 coins)                
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #1
    Apple Orchard      BW (3)  [10]     #3
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (2 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Mine               BG (6)  [9]      #1
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 1, would you like to roll 1 or 2   
    dice?                                     
    Player 1 rolled [6][4] = 10.              
    Family Restaurant activated for Player 3. 
    Apple Orchard activated for Player 2.     
    Apple Orchard activated for Player 3.     
                                              
    Player 1, would you like to purchase an   
    establishment or construct a landmark? (1 
    coin)                                     
    (To view details of an item, type 'view'  
    followed by the item number. For example, 
    to view item 6, type 'view 6'.)           
    ========================================== 
    ---------        PURCHASE        --------- 
     1. Ranch              BC (1)  [2]      #1 
     2. Bakery             GB (1)  [2-3]    #3 
    ---------         CANCEL         --------- 
    99. Do nothing                            
    ========================================== 
    Choose a number to purchase or construct: 
    Player 1 chose not to make improvements.  
    Turn ended for Player 1.                  
    Turn started for Player 2.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #4
    Convenience Store  GB (2)  [4]      #3
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #4
    Furniture Factory  GF (3)  [8]      #5
    Mine               BG (6)  [9]      #5
    Family Restaurant  RU (3)  [9-10]   #2
    Apple Orchard      BW (3)  [10]     #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #4
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 2*                 
    ------------------------------------------
                    (20 coins)                
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #1
    Apple Orchard      BW (3)  [10]     #3
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (7 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Mine               BG (6)  [9]      #1
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 2 rolled [1][4] = 5.               
    Forest activated for Player 2.            
    Forest activated for Player 3.            
    Forest activated for Player 1.            
    Player 2 constructed the Amusement Park.  
    Turn ended for Player 2.                  
    Turn started for Player 3.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #4
    Convenience Store  GB (2)  [4]      #3
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #4
    Furniture Factory  GF (3)  [8]      #5
    Mine               BG (6)  [9]      #5
    Family Restaurant  RU (3)  [9-10]   #2
    Apple Orchard      BW (3)  [10]     #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (4 coins)                 
    Wheat Field        BW (1)  [1]      #4
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (5 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #1
    Apple Orchard      BW (3)  [10]     #3
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
                    Player 3*                 
    ------------------------------------------
                    (8 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Mine               BG (6)  [9]      #1
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #1
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 3 rolled [4][2] = 6.               
    Player 3 purchased the Apple Orchard.     
    Turn ended for Player 3.                  
    Turn started for Player 1.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #4
    Convenience Store  GB (2)  [4]      #3
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #5
    Furniture Factory  GF (3)  [8]      #5
    Mine               BG (6)  [9]      #5
    Family Restaurant  RU (3)  [9-10]   #2
    Apple Orchard      BW (3)  [10]     #1
    
                 Player 1* [YOU]              
    ------------------------------------------
                    (4 coins)                 
    Wheat Field        BW (1)  [1]      #4
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (5 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #1
    Apple Orchard      BW (3)  [10]     #3
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (5 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Mine               BG (6)  [9]      #1
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 1, would you like to roll 1 or 2   
    dice?                                     
    Player 1 rolled [1][3] = 4.               
    Convenience Store activated for Player 1. 
                                              
    Player 1, would you like to purchase an   
    establishment or construct a landmark? (7 
    coins)                                    
    (To view details of an item, type 'view'  
    followed by the item number. For example, 
    to view item 6, type 'view 6'.)           
    ========================================== 
    ---------        PURCHASE        --------- 
     1. Ranch              BC (1)  [2]      #1 
     2. Bakery             GB (1)  [2-3]    #3 
     3. Cafe               RU (2)  [3]      #4 
     4. Convenience Store  GB (2)  [4]      #3 
     5. Forest             BG (3)  [5]      #1 
     6. Cheese Factory     GF (5)  [7]      #5 
     7. Furniture Factory  GF (3)  [8]      #5 
     8. Mine               BG (6)  [9]      #5 
     9. Family Restaurant  RU (3)  [9-10]   #2 
    10. Apple Orchard      BW (3)  [10]     #1 
    ---------         CANCEL         --------- 
    99. Do nothing                            
    ========================================== 
    Choose a number to purchase or construct: 
    Player 1 purchased the Mine.              
    Turn ended for Player 1.                  
    Turn started for Player 2.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #4
    Convenience Store  GB (2)  [4]      #3
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #5
    Furniture Factory  GF (3)  [8]      #5
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #2
    Apple Orchard      BW (3)  [10]     #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #4
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Mine               BG (6)  [9]      #1
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 2*                 
    ------------------------------------------
                    (5 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #1
    Apple Orchard      BW (3)  [10]     #3
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (5 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Mine               BG (6)  [9]      #1
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 2 rolled [5][2] = 7.               
    Player 2 purchased the Cheese Factory.    
    Turn ended for Player 2.                  
    Turn started for Player 3.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #4
    Convenience Store  GB (2)  [4]      #3
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #4
    Furniture Factory  GF (3)  [8]      #5
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #2
    Apple Orchard      BW (3)  [10]     #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #4
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Mine               BG (6)  [9]      #1
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #1
    Cheese Factory     GF (5)  [7]      #1
    Apple Orchard      BW (3)  [10]     #3
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
                    Player 3*                 
    ------------------------------------------
                    (5 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Mine               BG (6)  [9]      #1
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 3 rolled [2][4] = 6.               
    Player 3 purchased the Cafe.              
    Turn ended for Player 3.                  
    Turn started for Player 1.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #3
    Convenience Store  GB (2)  [4]      #3
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #4
    Furniture Factory  GF (3)  [8]      #5
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #2
    Apple Orchard      BW (3)  [10]     #1
    
                 Player 1* [YOU]              
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #4
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Mine               BG (6)  [9]      #1
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #1
    Cheese Factory     GF (5)  [7]      #1
    Apple Orchard      BW (3)  [10]     #3
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #2
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Mine               BG (6)  [9]      #1
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 1, would you like to roll 1 or 2   
    dice?                                     
    Player 1 rolled [3][3] = 6.               
    Stadium activated for Player 1.           
    TV Station activated for Player 1.        
    -------     AVAILABLE PLAYERS      ------- 
    1. Player 3             (1 coin)          
    Player 1, who would you like to target?   
    Business Complex activated for Player 1.  
    -------     AVAILABLE PLAYERS      ------- 
    1. Player 2             (0 coins)         
    2. Player 3             (0 coins)         
    Player 1, who would you like to target?   
    -------  AVAILABLE ESTABLISHMENTS  ------- 
                     Player 2                 
     1. Wheat Field        BW (1)  [1]        
     2. Ranch              BC (1)  [2]        
     3. Forest             BG (3)  [5]        
     4. Cheese Factory     GF (5)  [7]        
     5. Apple Orchard      BW (3)  [10]       
     6. Farmers Market     GO (2)  [11-12]    
    Player 1, select an establishment:        
    -------  AVAILABLE ESTABLISHMENTS  ------- 
                     Player 1                 
     1. Wheat Field        BW (1)  [1]        
     2. Convenience Store  GB (2)  [4]        
     3. Forest             BG (3)  [5]        
     4. Mine               BG (6)  [9]        
     5. Farmers Market     GO (2)  [11-12]    
    Player 1, select an establishment:        
                                              
    Player 1, would you like to purchase an   
    establishment or construct a landmark? (4 
    coins)                                    
    (To view details of an item, type 'view'  
    followed by the item number. For example, 
    to view item 6, type 'view 6'.)           
    ========================================== 
    ---------        PURCHASE        --------- 
     1. Ranch              BC (1)  [2]      #1 
     2. Bakery             GB (1)  [2-3]    #3 
     3. Cafe               RU (2)  [3]      #3 
     4. Convenience Store  GB (2)  [4]      #3 
     5. Forest             BG (3)  [5]      #1 
     6. Furniture Factory  GF (3)  [8]      #5 
     7. Family Restaurant  RU (3)  [9-10]   #2 
     8. Apple Orchard      BW (3)  [10]     #1 
    ---------         CANCEL         --------- 
    99. Do nothing                            
    ========================================== 
    Choose a number to purchase or construct: 
    Player 1 purchased the Apple Orchard.     
    Turn ended for Player 1.                  
    Turn started for Player 2.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #3
    Convenience Store  GB (2)  [4]      #3
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #4
    Furniture Factory  GF (3)  [8]      #6
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #4
    Farmers Market     GO (2)  [11-12]  #1
    
                  Player 1 [YOU]              
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #4
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Mine               BG (6)  [9]      #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 2*                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Cheese Factory     GF (5)  [7]      #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #2
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Mine               BG (6)  [9]      #1
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 2 rolled [1][3] = 4.               
    Convenience Store activated for Player 2. 
    Player 2 purchased the Farmers Market.    
    Turn ended for Player 2.                  
    Turn started for Player 3.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #3
    Convenience Store  GB (2)  [4]      #3
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #5
    Furniture Factory  GF (3)  [8]      #6
    Mine               BG (6)  [9]      #4
    Family Restaurant  RU (3)  [9-10]   #5
    
                  Player 1 [YOU]              
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #4
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Mine               BG (6)  [9]      #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (2 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Cheese Factory     GF (5)  [7]      #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #3
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
                    Player 3*                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #2
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Mine               BG (6)  [9]      #1
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 3 rolled [2] = 2.                  
    Ranch activated for Player 3.             
    Ranch activated for Player 2.             
    Bakery activated for Player 3.            
    Player 3 purchased the Mine.              
    Turn ended for Player 3.                  
    Turn started for Player 1.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #3
    Convenience Store  GB (2)  [4]      #3
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #5
    Furniture Factory  GF (3)  [8]      #6
    Mine               BG (6)  [9]      #3
    Family Restaurant  RU (3)  [9-10]   #5
    
                 Player 1* [YOU]              
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #4
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Mine               BG (6)  [9]      #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (5 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Cheese Factory     GF (5)  [7]      #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #3
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #2
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Mine               BG (6)  [9]      #2
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 1, would you like to roll 1 or 2   
    dice?                                     
    Player 1 rolled [6][2] = 8.               
                                              
    Player 1, would you like to purchase an   
    establishment or construct a landmark? (1 
    coin)                                     
    (To view details of an item, type 'view'  
    followed by the item number. For example, 
    to view item 6, type 'view 6'.)           
    ========================================== 
    ---------        PURCHASE        --------- 
     1. Ranch              BC (1)  [2]      #1 
     2. Bakery             GB (1)  [2-3]    #3 
    ---------         CANCEL         --------- 
    99. Do nothing                            
    ========================================== 
    Choose a number to purchase or construct: 
    Player 1 chose not to make improvements.  
    Turn ended for Player 1.                  
    Turn started for Player 2.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #3
    Convenience Store  GB (2)  [4]      #3
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #5
    Furniture Factory  GF (3)  [8]      #6
    Mine               BG (6)  [9]      #3
    Family Restaurant  RU (3)  [9-10]   #5
    
                  Player 1 [YOU]              
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #4
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Mine               BG (6)  [9]      #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                    Player 2*                 
    ------------------------------------------
                    (5 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Cheese Factory     GF (5)  [7]      #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #3
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #2
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Mine               BG (6)  [9]      #2
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 2 rolled [1][6] = 7.               
    Cheese Factory activated for Player 2.    
    Player 2 purchased the Cheese Factory.    
    Turn ended for Player 2.                  
    Turn started for Player 3.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #3
    Convenience Store  GB (2)  [4]      #3
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #4
    Furniture Factory  GF (3)  [8]      #6
    Mine               BG (6)  [9]      #3
    Family Restaurant  RU (3)  [9-10]   #5
    
                  Player 1 [YOU]              
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #4
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Mine               BG (6)  [9]      #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (9 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Cheese Factory     GF (5)  [7]      #2
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #3
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
                    Player 3*                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #2
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Mine               BG (6)  [9]      #2
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 3 rolled [1][2] = 3.               
    Bakery activated for Player 3.            
    Player 3 purchased the Furniture Factory. 
    Turn ended for Player 3.                  
    Turn started for Player 1.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #3
    Convenience Store  GB (2)  [4]      #3
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #4
    Furniture Factory  GF (3)  [8]      #5
    Mine               BG (6)  [9]      #3
    Family Restaurant  RU (3)  [9-10]   #5
    
                 Player 1* [YOU]              
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #4
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Mine               BG (6)  [9]      #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (9 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Cheese Factory     GF (5)  [7]      #2
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #3
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #2
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #2
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 1, would you like to roll 1 or 2   
    dice?                                     
    Player 1 rolled [6][5] = 11.              
    Farmers Market activated for Player 1.    
                                              
    Player 1, would you like to purchase an   
    establishment or construct a landmark? (25 
    coins)                                    
    (To view details of an item, type 'view'  
    followed by the item number. For example, 
    to view item 6, type 'view 6'.)           
    ========================================== 
    ---------        PURCHASE        --------- 
     1. Ranch              BC (1)  [2]      #1 
     2. Bakery             GB (1)  [2-3]    #3 
     3. Cafe               RU (2)  [3]      #3 
     4. Convenience Store  GB (2)  [4]      #3 
     5. Forest             BG (3)  [5]      #1 
     6. Cheese Factory     GF (5)  [7]      #4 
     7. Furniture Factory  GF (3)  [8]      #5 
     8. Mine               BG (6)  [9]      #3 
     9. Family Restaurant  RU (3)  [9-10]   #5 
    ---------       CONSTRUCT        --------- 
    10. Shopping Mall      NT (10) [ ]        
    11. Amusement Park     NT (16) [ ]        
    12. Radio Tower        NT (22) [ ]        
    ---------         CANCEL         --------- 
    99. Do nothing                            
    ========================================== 
    Choose a number to purchase or construct: 
    Player 1 constructed the Radio Tower.     
    Turn ended for Player 1.                  
    Turn started for Player 2.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #3
    Convenience Store  GB (2)  [4]      #3
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #4
    Furniture Factory  GF (3)  [8]      #5
    Mine               BG (6)  [9]      #3
    Family Restaurant  RU (3)  [9-10]   #5
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #4
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Mine               BG (6)  [9]      #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [X]
    
                    Player 2*                 
    ------------------------------------------
                    (9 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Cheese Factory     GF (5)  [7]      #2
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #3
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #2
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #2
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 2 rolled [4][5] = 9.               
    Family Restaurant activated for Player 3. 
    Mine activated for Player 3.              
    Mine activated for Player 1.              
    Player 2 purchased the Cheese Factory.    
    Turn ended for Player 2.                  
    Turn started for Player 3.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #3
    Convenience Store  GB (2)  [4]      #3
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #3
    Furniture Factory  GF (3)  [8]      #5
    Mine               BG (6)  [9]      #3
    Family Restaurant  RU (3)  [9-10]   #5
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (8 coins)                 
    Wheat Field        BW (1)  [1]      #4
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Mine               BG (6)  [9]      #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [X]
    
                     Player 2                 
    ------------------------------------------
                    (2 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Cheese Factory     GF (5)  [7]      #3
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #3
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
                    Player 3*                 
    ------------------------------------------
                    (13 coins)                
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #2
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #2
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 3 rolled [2][2] = 4.               
    Convenience Store activated for Player 3. 
    Player 3 constructed the Shopping Mall.   
    Turn started for Player 3.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #3
    Convenience Store  GB (2)  [4]      #3
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #3
    Furniture Factory  GF (3)  [8]      #5
    Mine               BG (6)  [9]      #3
    Family Restaurant  RU (3)  [9-10]   #5
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (8 coins)                 
    Wheat Field        BW (1)  [1]      #4
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Mine               BG (6)  [9]      #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [X]
    
                     Player 2                 
    ------------------------------------------
                    (2 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Cheese Factory     GF (5)  [7]      #3
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #3
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
                    Player 3*                 
    ------------------------------------------
                    (6 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #2
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #2
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 3 rolled [4][2] = 6.               
    Player 3 purchased the Convenience Store. 
    Turn ended for Player 3.                  
    Turn started for Player 1.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #3
    Convenience Store  GB (2)  [4]      #2
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #3
    Furniture Factory  GF (3)  [8]      #5
    Mine               BG (6)  [9]      #3
    Family Restaurant  RU (3)  [9-10]   #5
    
                 Player 1* [YOU]              
    ------------------------------------------
                    (8 coins)                 
    Wheat Field        BW (1)  [1]      #4
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Mine               BG (6)  [9]      #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [X]
    
                     Player 2                 
    ------------------------------------------
                    (2 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Cheese Factory     GF (5)  [7]      #3
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #3
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (4 coins)                 
    Wheat Field        BW (1)  [1]      #2
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #2
    Convenience Store  GB (2)  [4]      #2
    Forest             BG (3)  [5]      #1
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #2
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 1, would you like to roll 1 or 2   
    dice?                                     
    Player 1 rolled [1][4] = 5.               
    Player 1, would you like to reroll the    
    dice? (y/n):                              
    Player 1 used a reroll.                   
    Player 1 rolled [2][4] = 6.               
    Stadium activated for Player 1.           
    TV Station activated for Player 1.        
    -------     AVAILABLE PLAYERS      ------- 
    1. Player 3             (2 coins)         
    Player 1, who would you like to target?   
    Business Complex activated for Player 1.  
    -------     AVAILABLE PLAYERS      ------- 
    1. Player 2             (0 coins)         
    2. Player 3             (0 coins)         
    Player 1, who would you like to target?   
    -------  AVAILABLE ESTABLISHMENTS  ------- 
                     Player 3                 
     1. Wheat Field        BW (1)  [1]        
     2. Ranch              BC (1)  [2]        
     3. Bakery             GB (1)  [2-3]      
     4. Cafe               RU (2)  [3]        
     5. Convenience Store  GB (2)  [4]        
     6. Forest             BG (3)  [5]        
     7. Furniture Factory  GF (3)  [8]        
     8. Mine               BG (6)  [9]        
     9. Family Restaurant  RU (3)  [9-10]     
    10. Apple Orchard      BW (3)  [10]       
    11. Farmers Market     GO (2)  [11-12]    
    Player 1, select an establishment:        
    -------  AVAILABLE ESTABLISHMENTS  ------- 
                     Player 1                 
     1. Wheat Field        BW (1)  [1]        
     2. Forest             BG (3)  [5]        
     3. Mine               BG (6)  [9]        
     4. Apple Orchard      BW (3)  [10]       
     5. Farmers Market     GO (2)  [11-12]    
    Player 1, select an establishment:        
                                              
    Player 1, would you like to purchase an   
    establishment or construct a landmark? (14 
    coins)                                    
    (To view details of an item, type 'view'  
    followed by the item number. For example, 
    to view item 6, type 'view 6'.)           
    ========================================== 
    ---------        PURCHASE        --------- 
     1. Ranch              BC (1)  [2]      #1 
     2. Bakery             GB (1)  [2-3]    #3 
     3. Cafe               RU (2)  [3]      #3 
     4. Convenience Store  GB (2)  [4]      #2 
     5. Forest             BG (3)  [5]      #1 
     6. Cheese Factory     GF (5)  [7]      #3 
     7. Furniture Factory  GF (3)  [8]      #5 
     8. Mine               BG (6)  [9]      #3 
     9. Family Restaurant  RU (3)  [9-10]   #5 
    ---------       CONSTRUCT        --------- 
    10. Shopping Mall      NT (10) [ ]        
    ---------         CANCEL         --------- 
    99. Do nothing                            
    ========================================== 
    Choose a number to purchase or construct: 
    Player 1 purchased the Furniture Factory. 
    Turn ended for Player 1.                  
    Turn started for Player 2.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #3
    Convenience Store  GB (2)  [4]      #2
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #3
    Furniture Factory  GF (3)  [8]      #4
    Mine               BG (6)  [9]      #3
    Family Restaurant  RU (3)  [9-10]   #5
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (11 coins)                
    Wheat Field        BW (1)  [1]      #3
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Furniture Factory  GF (3)  [8]      #2
    Mine               BG (6)  [9]      #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [X]
    
                    Player 2*                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Cheese Factory     GF (5)  [7]      #3
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #3
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #2
    Convenience Store  GB (2)  [4]      #2
    Forest             BG (3)  [5]      #1
    Mine               BG (6)  [9]      #2
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 2 rolled [4][6] = 10.              
    Family Restaurant activated for Player 3. 
    Apple Orchard activated for Player 2.     
    Apple Orchard activated for Player 3.     
    Apple Orchard activated for Player 1.     
    Player 2 purchased the Cheese Factory.    
    Turn ended for Player 2.                  
    Turn started for Player 3.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #3
    Convenience Store  GB (2)  [4]      #2
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #2
    Furniture Factory  GF (3)  [8]      #4
    Mine               BG (6)  [9]      #3
    Family Restaurant  RU (3)  [9-10]   #5
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (17 coins)                
    Wheat Field        BW (1)  [1]      #3
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Furniture Factory  GF (3)  [8]      #2
    Mine               BG (6)  [9]      #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [X]
    
                     Player 2                 
    ------------------------------------------
                     (1 coin)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Cheese Factory     GF (5)  [7]      #4
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #3
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
                    Player 3*                 
    ------------------------------------------
                    (6 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #2
    Convenience Store  GB (2)  [4]      #2
    Forest             BG (3)  [5]      #1
    Mine               BG (6)  [9]      #2
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 3 rolled [3][2] = 5.               
    Forest activated for Player 3.            
    Forest activated for Player 1.            
    Forest activated for Player 2.            
    Player 3 purchased the Convenience Store. 
    Turn ended for Player 3.                  
    Turn started for Player 1.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #3
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #2
    Furniture Factory  GF (3)  [8]      #4
    Mine               BG (6)  [9]      #3
    Family Restaurant  RU (3)  [9-10]   #5
    
                 Player 1* [YOU]              
    ------------------------------------------
                    (20 coins)                
    Wheat Field        BW (1)  [1]      #3
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Furniture Factory  GF (3)  [8]      #2
    Mine               BG (6)  [9]      #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    Radio Tower        NT (22) [X]
    
                     Player 2                 
    ------------------------------------------
                    (2 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Cheese Factory     GF (5)  [7]      #4
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #3
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (5 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #2
    Convenience Store  GB (2)  [4]      #3
    Forest             BG (3)  [5]      #1
    Mine               BG (6)  [9]      #2
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 1, would you like to roll 1 or 2   
    dice?                                     
    Player 1 rolled [5][1] = 6.               
    Player 1, would you like to reroll the    
    dice? (y/n):                              
    Stadium activated for Player 1.           
    TV Station activated for Player 1.        
    -------     AVAILABLE PLAYERS      ------- 
    1. Player 3             (3 coins)         
    Player 1, who would you like to target?   
    Business Complex activated for Player 1.  
    -------     AVAILABLE PLAYERS      ------- 
    1. Player 2             (0 coins)         
    2. Player 3             (0 coins)         
    Player 1, who would you like to target?   
    -------  AVAILABLE ESTABLISHMENTS  ------- 
                     Player 3                 
     1. Wheat Field        BW (1)  [1]        
     2. Ranch              BC (1)  [2]        
     3. Bakery             GB (1)  [2-3]      
     4. Cafe               RU (2)  [3]        
     5. Convenience Store  GB (2)  [4]        
     6. Forest             BG (3)  [5]        
     7. Mine               BG (6)  [9]        
     8. Family Restaurant  RU (3)  [9-10]     
     9. Apple Orchard      BW (3)  [10]       
    10. Farmers Market     GO (2)  [11-12]    
    Player 1, select an establishment:        
    -------  AVAILABLE ESTABLISHMENTS  ------- 
                     Player 1                 
     1. Wheat Field        BW (1)  [1]        
     2. Forest             BG (3)  [5]        
     3. Furniture Factory  GF (3)  [8]        
     4. Mine               BG (6)  [9]        
     5. Apple Orchard      BW (3)  [10]       
     6. Farmers Market     GO (2)  [11-12]    
    Player 1, select an establishment:        
                                              
    Player 1, would you like to purchase an   
    establishment or construct a landmark? (27 
    coins)                                    
    (To view details of an item, type 'view'  
    followed by the item number. For example, 
    to view item 6, type 'view 6'.)           
    ========================================== 
    ---------        PURCHASE        --------- 
     1. Ranch              BC (1)  [2]      #1 
     2. Bakery             GB (1)  [2-3]    #3 
     3. Cafe               RU (2)  [3]      #3 
     4. Convenience Store  GB (2)  [4]      #1 
     5. Forest             BG (3)  [5]      #1 
     6. Cheese Factory     GF (5)  [7]      #2 
     7. Furniture Factory  GF (3)  [8]      #4 
     8. Mine               BG (6)  [9]      #3 
     9. Family Restaurant  RU (3)  [9-10]   #5 
    ---------       CONSTRUCT        --------- 
    10. Shopping Mall      NT (10) [ ]        
    11. Amusement Park     NT (16) [ ]        
    ---------         CANCEL         --------- 
    99. Do nothing                            
    ========================================== 
    Choose a number to purchase or construct: 
    Player 1 constructed the Amusement Park.  
    Turn ended for Player 1.                  
    Turn started for Player 2.                
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #3
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #2
    Furniture Factory  GF (3)  [8]      #4
    Mine               BG (6)  [9]      #3
    Family Restaurant  RU (3)  [9-10]   #5
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (11 coins)                
    Wheat Field        BW (1)  [1]      #2
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Furniture Factory  GF (3)  [8]      #2
    Mine               BG (6)  [9]      #2
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [X]
    
                    Player 2*                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Cheese Factory     GF (5)  [7]      #4
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #3
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #4
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #2
    Convenience Store  GB (2)  [4]      #3
    Forest             BG (3)  [5]      #1
    Mine               BG (6)  [9]      #1
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    Player 2 rolled [3][4] = 7.               
    Cheese Factory activated for Player 2.    
    Player 2 constructed the Radio Tower.     
    Turn ended for Player 2.                  
    ******************************************
                      MARKET                  
    ------------------------------------------
    Ranch              BC (1)  [2]      #1
    Bakery             GB (1)  [2-3]    #3
    Cafe               RU (2)  [3]      #3
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Cheese Factory     GF (5)  [7]      #2
    Furniture Factory  GF (3)  [8]      #4
    Mine               BG (6)  [9]      #3
    Family Restaurant  RU (3)  [9-10]   #5
    
                  Player 1 [YOU]              
    ------------------------------------------
                    (11 coins)                
    Wheat Field        BW (1)  [1]      #2
    Bakery             GB (1)  [2-3]    #1
    Forest             BG (3)  [5]      #3
    Stadium            PT (6)  [6]      #1
    TV Station         PT (7)  [6]      #1
    Business Complex   PT (8)  [6]      #1
    Furniture Factory  GF (3)  [8]      #2
    Mine               BG (6)  [9]      #2
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #2
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [X]
    
                    Player 2*                 
    ------------------------------------------
                    (14 coins)                
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #3
    Bakery             GB (1)  [2-3]    #1
    Convenience Store  GB (2)  [4]      #1
    Forest             BG (3)  [5]      #1
    Cheese Factory     GF (5)  [7]      #4
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #3
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [X]
    
                     Player 3                 
    ------------------------------------------
                    (0 coins)                 
    Wheat Field        BW (1)  [1]      #4
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #4
    Cafe               RU (2)  [3]      #2
    Convenience Store  GB (2)  [4]      #3
    Forest             BG (3)  [5]      #1
    Mine               BG (6)  [9]      #1
    Family Restaurant  RU (3)  [9-10]   #1
    Apple Orchard      BW (3)  [10]     #2
    Farmers Market     GO (2)  [11-12]  #1
    ..........................................
    Train Station      NT (4)  [X]
    Shopping Mall      NT (10) [X]
    Amusement Park     NT (16) [X]
    Radio Tower        NT (22) [ ]
    
    ******************************************
    The game is over. Player 2 is the winner. 


