Feature: Play the Phase 1 version of the game with one human and one random AI player.
  
  The user should be able to play the Phase 1 version of the game against a random AI player.


  Scenario: The user runs the program in "phase1" mode with an AI opponent.
    When the program is run as "phase1" with argument "--ai"
    Then the game log should be accurate