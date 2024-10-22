# Gambler Game

A very simple multiplayer strategy game.

Each round, every player submits an integer. Then
1. If there are repeated numbers, all players submitting the repeated numbers reduce 1 score.
2. If there are no repeated number, then the player(s) writing the largest and smallest number reduce 1 score.
3. When all rounds are finished, the player with lease amount of score reduced won.

If there are multiple pairs of repeated number (as in "11, 11, 15, 15, 26"), then all repeated pairs get deduction.

## How to Play?

To play the game, implement the `Strategy` interface and design your own strategy. Then, put your code under `strategies/` folder. This program will load all scripts under the `strategy/` folder and start a game automatically.