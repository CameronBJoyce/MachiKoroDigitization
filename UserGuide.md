# Machi WoCo User Guide
This is the user guide for playing Machi Woco.
## Contents
  * [Phase 1](#phase-1)
    + [Game Objective](#game-objective)
    + [Game Play](#game-play)
        - [Start Game](#start-game)
        - [Each Round](#each-round)
             - [Dice Roll](#dice-roll)
             - [Menu](#menu)        
             - [View](#view)    
             - [Purchase](#purchase)
             - [Construct](#construct)
             - [End Turn](#end-turn)
        - [AI-strategy](#ai-strategy)
    + [Winner](#winner)
  * [Phase 2](#phase-2)
    + [Game Objective P2](#game-objective-P2)
    + [Game Play P2](#game-play-P2)
        - [Start Game](#start-game-P2)
        - [Each Round](#each-round-P2)
        - [Gameplay Differences P2](#gameplay-differences-P2)
            - [Dice Roll P2](#dice-roll-P2)
            - [Purchase P2](#purchase-P2)
    + [Winner P2](#winner-P2)
* [Phase 3](#phase-3)
    + [Game Objective P3](#game-objective-P3)
    + [Game Play P3](#game-play-P3)
        - [Start Game](#start-game-P3)
        - [Each Round](#each-round-P3)
        - [Gameplay Differences P3](#gameplay-differences-P3)
            - [Dice Roll P3](#dice-roll-P3)
    + [Winner P3](#winner-P3)
* [Phase 4](#phase-4)
    + [Game Objective P4](#game-objective-P4)
    + [Game Play P4](#game-play-P4)
        - [Start Game](#start-game-P4)
        - [Each Round](#each-round-P4)
        - [Gameplay Differences P4](#gameplay-differences-P4)
            - [Dice Roll P4](#dice-roll-P4)
    + [Winner P4](#winner-P4)
* [Phase 5](#phase-5)
    + [Game Objective P5](#game-objective-P5)
    + [Game Play P5](#game-play-P5)
        - [Start Game](#start-game-P5)
        - [Each Round](#each-round-P5)
        - [Gameplay Differences P5](#gameplay-differences-P5)
            - [Dice Roll P5](#dice-roll-P5)
    + [Winner P5](#winner-P5)
* [Phase 6](#phase-6)
    + [Game Objective P6](#game-objective-P6)
    + [Game Play P6](#game-play-P6)
        - [Start Game](#start-game-P6)
        - [Each Round](#each-round-P6)
        - [5-5-2 Market](#5-5-2-market)
        - [Strategic AI](#strategic-AI)
            - [Roll Logic](#roll-logic)
            - [AI Purchase Logic - TS *not* Constructed](#ai-purchase-logic---train-station-not-constructed)
            - [AI Purchase Logic - TS *is* Constructed](#ai-purchase-logic---train-station-is-constructed)
            - [AI Purchase Logic - No Purchase](#ai-purchase-logic---no-purchase)
            - [AI Purchase Logic - Purchase By Color](#ai-purchase-logic---purchase-by-color)
            - [AI TV Station Logic](#ai-tv-station-logic)
    + [Winner P6](#winner-P6)


  
# Phase 1

## Game Objective

For this version of the game, the objective is to be the first player to build City Hall.

## Game Play

### Start Game
In this version of the game, there will be two players: player 1 and player 2.
When a new game starts, player 1 will go first.

### Each Round
At the beginning of each player's turn, you will first see a display of the current game state similar to this:

    ******************************************
                      MARKET                  
    ------------------------------------------
    Wheat Field        BW (1)  [1]      #6
    Ranch              BC (1)  [2]      #6
    Forest             BG (3)  [5]      #6

                 Player 1* [YOU]              
    ------------------------------------------
                    (4 coins)                 
    Wheat Field        BW (1)  [1]      #1
    ..........................................
    City Hall          NT (7)  [ ]
    
                     Player 2                 
    ------------------------------------------
                    (4 coins)                 
    Wheat Field        BW (1)  [1]      #1
    ..........................................
    City Hall          NT (7)  [ ]
    
    ******************************************
    
Market contains the establishments available to all players to purchase.
Each market entry contains these information(in such order): 
* name of the establishment
* two characters representing color and icon
* the cost in parentheses
* the activation range
* the number available, starting with a single space and the hashtag/pound symbol

 
Each player entry also contains similar information about the establishments and landmarks with the exception that in landmarks `[ ]` indicates whether that landmark has been constructed or not as opposed to the activation range in establishments, separated by `..........................................`
#### Dice Roll
At this point of the game, a player can only roll one dice .
That dice will be rolled immediately and automatically following the display of the current game state.

For example, `Player 1 rolled [5] = 5` means player 1 rolled a 5.


#### Menu
After the dice rolls, you will be prompted to purchase or construct items as you wish. A menu similar to this will be displayed to you.
    
    Player 1 would you like to purchase an 
    establishment or construct a landmark? (5
     coins
    (To view details of an item, type 'view'  
    followed by the item number. For example, 
    to view item 6, type 'view 6'.)           
    ==========================================
    ---------        PURCHASE        ---------
     1. Wheat Field        BW (1)  [1]      #6
     2. Ranch              BC (1)  [2]      #6
     3. Forest             BG (3)  [5]      #6
    ---------         CANCEL         ---------
    99. Do nothing                            
    ==========================================
    Choose a number to purchase or construct: 


You can check your account balance on the top of this prompt. 

#### View
If you are unsure about the effects of any establishments that you are able to purchase, you can type `view N` where N is the item number you see on the menu.

For example, in the menu displayed above, if you type `view 1` you can see detailed informaion about wheat field

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
    
 #### Purchase
 If you desire to purchase an establishment, enter the item number corresponding to the item numbers displayed to you. For example, by typing `2`, you will purchase a ranch establishment. After which your turn ends.
 
 #### Construct
 If you choose not to purchase an establishment, you can construct a landmark if one is available in your menu.
 
 #### End turn
 Any invalid input (i.e. item numbers out of index or any phrases other than `view N`) will cause the console to prompt you again. Your turn will not end until a valid input is made.
 
 A turn ends after the player made a choice about the improvement on their landmarks and establishments.
 
 ### AI strategy
If a Player is an AI,  decisions will be made uniformly among the choices provided to it. The choices include all the establishments and landmarks it can purchase or construct, or do nothing each round.


 ### Winner
In this feature of the game, the winner will be player who constructed City Hall first. After which the game will immediately end.



# Phase 2

## Game Objective P2

For this version of the game, the objective is to be the first player to build City Hall and Train Station.

## Game Play P2

### Start Game P2
In this version of the game, there will be 2-3 players: 1 human player (player 1) and 1-2 AI player(s).
When a new game starts, player 1 will go first.

### Each Round P2
At the beginning of each player's turn, you will first see a display of the current game state similar to this:

    ******************************************
                      MARKET                  
    ------------------------------------------
    Wheat Field        BW (1)  [1]      #6
    Ranch              BC (1)  [2]      #6
    Bakery             GB (1)  [2-3]    #6
    Convenience Store  GB (2)  [4]      #6
    Forest             BG (3)  [5]      #6
    Mine               BG (6)  [9]      #6
    Apple Orchard      BW (3)  [10]     #6
    
                 Player 1* [YOU]              
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #1
    ..........................................
    City Hall          NT (7)  [ ]
    Train Station      NT (4)  [ ]
    
                     Player 2                 
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #1
    ..........................................
    City Hall          NT (7)  [ ]
    Train Station      NT (4)  [ ]
    
                     Player 3                 
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #1
    ..........................................
    City Hall          NT (7)  [ ]
    Train Station      NT (4)  [ ]
    
    ******************************************
    
The Establishments Bakery, Convenience Store, Mine, and Apple Orchard have been added.

### Gameplay Differences P2

#### Dice Roll P2
At this point of the game, a player can roll two die if they have constructed the Train Station landmark.
Otherwise, only one die will be rolled.
These die will be rolled immediately and automatically following the display of the current game state.

Once the AI constructs the Train Station, on subsequent moves, it will randomly select 1 or 2 die to roll. 

For example, `Player 1 rolled [5] = 5` means player 1 rolled a 5.
`Player 2 rolled [5][6] = 11` means player 2 rolled an 11.

 #### Purchase P2
If a Player is an AI, purchasing decisions will be made at random. If an AI player has the funds necessary a purchase can be made, but they also have the choice to skip and move on to the next player.
 
 ### Winner P2
In this feature of the game, the winner will be the player who constructed City Hall and Train Station first. After which the game will immediately end.



# Phase 3

## Game Objective P3

For this version of the game, the objective is to be the first player to build City Hall, Train Station, and Shopping Mall.

## Game Play P3

### Start Game P3
In this version of the game, there will be 2-3 players: 1 human player (player 1) and 1-2 AI player(s). The starting Establishments
for each Player remain the same.
When a new game starts, player 1 will go first.

### Each Round P3
At the beginning of each player's turn, you will first see a display of the current game state similar to this:

    ******************************************
                      MARKET                  
    ------------------------------------------
    Wheat Field        BW (1)  [1]      #6
    Ranch              BC (1)  [2]      #6
    Bakery             GB (1)  [2-3]    #6
    Convenience Store  GB (2)  [4]      #6
    Forest             BG (3)  [5]      #6
    Cheese Factory     GF (5)  [7]      #6
    Furniture Factory  GF (3)  [8]      #6
    Mine               BG (6)  [9]      #6
    Apple Orchard      BW (3)  [10]     #6
    Farmers Market     GO (2)  [11-12]  #6
    
                 Player 1* [YOU]              
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #1
    ..........................................
    Train Station      NT (4)  [ ]
    City Hall          NT (7)  [ ]
    Shopping Mall      NT (10) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #1
    ..........................................
    Train Station      NT (4)  [ ]
    City Hall          NT (7)  [ ]
    Shopping Mall      NT (10) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #1
    ..........................................
    Train Station      NT (4)  [ ]
    City Hall          NT (7)  [ ]
    Shopping Mall      NT (10) [ ]
    
    ******************************************
    
The Establishments Cheese Factory, Furniture Factory, and Farmers Market have been added.
The Shopping Mall landmark has been added.

### Gameplay Differences P3

#### Dice Roll P3
The three new Establishments all carry out the same base function. Each card - when activated - receives a specified 
amount of coins based on how many cards of a given icon the Player owns.

The Shopping Mall landmark allows the Player to earn +1 coin for every Cup or Bread establishments that are activated
on a given turn.
 
 ### Winner P3
In this feature of the game, the winner will be the player who constructed City Hall, Train Station, and Shopping Mall first. After which the game will immediately end.



# Phase 4

## Game Objective P4

For this version of the game, the objective is to be the first player to build Train Station, Shopping Mall, and Amusement Park landmarks.

## Game Play P4

### Start Game P4
In this version of the game, there will be 2-4 players: 1 human player (player 1) and 1-3 AI player(s). The starting Establishments
for each Player remain the same.
When a new game starts, player 1 will go first.

### Each Round P4
At the beginning of each player's turn, you will first see a display of the current game state similar to this:

    ******************************************
                      MARKET                  
    ------------------------------------------
    Wheat Field        BW (1)  [1]      #6
    Ranch              BC (1)  [2]      #6
    Bakery             GB (1)  [2-3]    #6
    Cafe               RU (2)  [3]      #6
    Convenience Store  GB (2)  [4]      #6
    Forest             BG (3)  [5]      #6
    Cheese Factory     GF (5)  [7]      #6
    Furniture Factory  GF (3)  [8]      #6
    Mine               BG (6)  [9]      #6
    Family Restaurant  RU (3)  [9-10]   #6
    Apple Orchard      BW (3)  [10]     #6
    Farmers Market     GO (2)  [11-12]  #6
    
                 Player 1* [YOU]              
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    
                     Player 2                 
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    
                     Player 3                 
    ------------------------------------------
                    (3 coins)                 
    Wheat Field        BW (1)  [1]      #1
    Bakery             GB (1)  [2-3]    #1
    ..........................................
    Train Station      NT (4)  [ ]
    Shopping Mall      NT (10) [ ]
    Amusement Park     NT (16) [ ]
    
    ******************************************
    
The Establishments Cafe and Family Restaurant have been added.
The City Hall landmark has been removed, and the Amusement Park landmark has been added.

### Gameplay Differences P4

#### Dice Roll P4
The two new Establishments all carry out the same base function. Each card - when activated - takes a specified number of coins
from the Player who conducted the roll and gives this total to any Player(s) who own a Cafe or Family Restaurant.

The Amusement Park landmark allows the Player to take another turn if they roll doubles. This requires the construction of the 
Train Station landmark.
 
 ### Winner P4
In this feature of the game, the winner will be the player who constructed Train Station, Shopping Mall, and Amusement Park first. After which the game will immediately end.


# Phase 5

## Game Objective P5

For this version of the game, the objective is to be the first player to build the Train Station, Shopping Mall, Amusement Park, and Radio Tower landmarks.

## Game Play P5

### Start Game P5
In this version of the game, there will be 2-4 players: 1 human player (player 1) and 1-3 AI player(s). The starting Establishments
for each Player remain the same.
When a new game starts, player 1 will go first.

### Each Round P5
At the beginning of each player's turn, you will first see a display of the current game state similar to this:

    ******************************************
                    MARKET
    ------------------------------------------
    Wheat Field        BW (1)  [1]      #6
    Ranch              BC (1)  [2]      #6
    Bakery             GB (1)  [2-3]    #6
    Cafe               RU (2)  [3]      #6
    Convenience Store  GB (2)  [4]      #6
    Forest             BG (3)  [5]      #6
    Stadium            PT (6)  [6]      #3
    TV Station         PT (7)  [6]      #3
    Business Complex   PT (8)  [6]      #3
    Cheese Factory     GF (5)  [7]      #6
    Furniture Factory  GF (3)  [8]      #6
    Mine               BG (6)  [9]      #6
    Family Restaurant  RU (3)  [9-10]   #6
    Apple Orchard      BW (3)  [10]     #6
    Farmers Market     GO (2)  [11-12]  #6

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
    
The Purple Establishments Stadium, TV Station, and Business Complex have been added.
The Radio Tower landmark has been added.

### Gameplay Differences P5

#### Dice Roll P5
The three new Establishments offer some new actions available to Players - as long as the card is activated on that Player's turn. Stadium allows the Player to take 2 coins from each opponent when activated on their turn, TV Station lets the current Player target another Player and then take 5 coins from them, and Business Complex lets the current Player exchange one of their non-purple cards for another selected opponent's non-purple card. 

The Radio Tower landmark allows the Player to choose to re-roll the dice once per turn.
 
 ### Winner P5
In this feature of the game, the winner will be the player who constructed Train Station, Shopping Mall, Amusement Park, and Radio Tower first. After which the game will immediately end.


# Phase 6

## Game Objective P6

For this version of the game, the objective remains the same as in Phase 5.

## Game Play P6

### Start Game P6
In this version of the game, there will be 2-4 players: 1 human player (player 1) and 1-3 AI player(s). One of these AI Players will be considered a "strategic AI," meaning that it will always act through prioritized decisions in an effort to win the game. The starting Establishments for each Player remain the same. When a new game starts, player 1 will go first.

### Each Round P6
At the beginning of each player's turn, you will first see a display of the current game state similar to this:

    ******************************************
                    MARKET
    ------------------------------------------
    Wheat Field        BW (1)  [1]      #3
    Ranch              BC (1)  [2]      #2
    Bakery             GB (1)  [2-3]    #1
    Cafe               RU (2)  [3]      #1
    Convenience Store  GB (2)  [4]      #2
    Stadium            PT (6)  [6]      #2
    TV Station         PT (7)  [6]      #1
    Cheese Factory     GF (5)  [7]      #1
    Furniture Factory  GF (3)  [8]      #1
    Mine               BG (6)  [9]      #3
    Family Restaurant  RU (3)  [9-10]   #3
    Apple Orchard      BW (3)  [10]     #2

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

### 5-5-2 Market
Notice that the number of Establishments available in the market are staggered, and that all Establishments are not currently listed. This is because the Phase 6 version of the game uses a different market than all previous Phases: the 5-5-2 market. This Hybrid Supply variant uses 3 decks: Deck 1 contains all Establishments with activation numbers 6 and under, Deck 2 contains all Establishments with activation numbers 7 and above, and Deck 3 contains all major establishments (Purple cards). The three decks are shuffled face down and drawn until we have 5 unique cards from Decks 1 & 2, and 2 unique cards from Deck 3. Duplicates are stacked. This format continues throughout the game, as there should always be 12 unique cards visible.

### Strategic AI
The last new addition to Phase 6 is the introduction of the Strategic AI. This Strategic AI operates in its best interest to win the game, making prioritized decisions rather than random selections.

#### Roll Logic
We've implemented a few preferred actions for the AI when it comes to dice rolls. First off, the AI should choose to roll 2 die if it has any Establishments with an activation above 6. Additionally, the AI should choose to reroll (with the Radio Tower landmark constructed) if their first roll would result in less than 2 coins received.

#### AI Purchase Logic - Train Station *not* Constructed
The Strategic AI will be faced with numerous purchasing decisions throughout the playthrough of the game. The first part of the logic will center around checking whether or not Train Station has been constructed. If it hasn't been constructed and the AI has 4 or more coins they should follow a prioritized set of purchasing options based on which selection is available: first, they would purchase the train station, or secondarily purchase Ranch, Forest, or Wheat in that order (Ranch is the lowest cost, Forest has a higher activation than Wheat, and we already own one wheat to begin with). If none of those 4 purchasing options are made, the AI should look to purchase the Convenience Store followed by the Cafe. The Convenience Store has a higher activation and provides the AI with more coins upon activation. If for some reason none of these are valid options, it will select the first card available for purchase.

#### AI Purchase Logic - Train Station *is* Constructed
Much like the logic involved when the Train Statin is not constructed, this portion of purchasing logic also follows a prioritized set of purchasing options. The primary option is to purchase a Landmark if the AI has the coins, looking to buy the most expensive available (we believe that the more expensive landmarks serve a better purpose than any that are cheaper). Next, the AI should look to purchase the Furniture Factory IF they own more than two Establishments with the Gear icon. The next prioritized purchase is similar, as the AI should purchase the Cheese Factory IF they have more than two Ranch cards. We don't believe that cards with such specific targets should be bought unless the AI has a decent number of these targets already owned in order to quickly stack coins upon activation. If there has yet to been a purchase made, the AI should then look to purchase the Mine followed by the Forest. Both of these contain Gear icons (setting the AI up nicely upon the purchase of a Furniture Factory), and the Mine should be purchased first due to its large payout.

#### AI Purchase Logic - No Purchase
If none of the aformentioned purchases have been made by the Strategic AI, the next prioritized move is to do nothing if the AI has more than 2 landmarks constructed and has more than 18 coins. At this point, we feel as if the best strategy for the AI is to sit back and build up his coins even more in order to quickly put them in a position to win. Buying more establishments at this point seems wasteful in our opinion and with only one more Landmark to go, it would be better to save up in an effort to win the game upon the next roll.

#### AI Purchase Logic - Purchase By Color
At this point in the AI's purchasing dilemma, we have narrowed down their choices to simply purchasing an Establishment based off color. We believe that certain colors are more useful than others and therefore have priority. We expect the AI to look for colored cards in the following order, purchasing the most expensive Establishment available that meets this criteria: Purple, Blue, Red, Green. We believe that this ranking goes in order from the greatest payout/reward to the least greatest, and that these prioritized cards give the AI the best chance at winning.

#### AI TV Station Logic
Upon TV Station's activation for the Strategic AI, the AI should target the player with the highest coin count. Not only does this Player more than likely have the required amount of coins (5), but they are also most likely in the lead or right there near the top. 

 
### Winner P6
In this feature of the game, the winner will be the player who constructed Train Station, Shopping Mall, Amusement Park, and Radio Tower first. After which the game will immediately end.