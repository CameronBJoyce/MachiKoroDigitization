Feature: Play the Phase 1 version of the game with two human players.
  
  The users (two humans) should be able to play the Phase 1 version of the game.


  Scenario: The user runs the program in "phase1" mode.
    When the program is run as "phase1"
    Then the game log should be accurate