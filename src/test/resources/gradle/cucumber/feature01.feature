Feature: Display the detailed view of each card on the console (Phase 0).
  
  The user should be able to see the details of each of the cards (establishments
  and landmarks) in the game, very similar to how they appear in the physical
  game.


  Scenario: The user runs the program in "phase0" mode.
    When the program is run as "phase0"
    Then I should see the detailed view of all of the cards