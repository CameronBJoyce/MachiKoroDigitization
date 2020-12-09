Feature: Play the Phase 2 version of the game with one human and one or two random AI players.
  
  The user should be able to play the Phase 2 version of the game against random AI players.


  Scenario: The user runs the program in "phase2" mode with one AI opponent.
    When the program is run as "phase2" with argument "2"
    Then the game log should be accurate

  Scenario: The user runs the program in "phase2" mode with two AI opponents.
    When the program is run as "phase2" with argument "3"
    Then the game log should be accurate
