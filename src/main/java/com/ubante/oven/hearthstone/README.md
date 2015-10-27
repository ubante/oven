# Simulating Arena records

When each player plays precisely one game, then things look good:

```


```

This mostly works when four players each play two games but notice the duplications.  In parenthesis is the star rating,
Elo rating, number of wins and number of losses.  For example ```2-1118-3-0``` means 2 stars, an Elo of 1118, 3
wins and 0 losses.

```
opp1 game history:
Game #1: Elmo(0-1200-0-0) vs opp1(0-1100-0-0) --> opp1 wins
Game #1: Elmo(0-1200-0-0) vs opp1(0-1100-0-0) --> opp1 wins

opp2 game history:
Game #2: opp2(0-1250-0-0) vs opp3(0-1150-0-0) --> opp3 wins
Game #2: opp2(0-1250-0-0) vs opp3(0-1150-0-0) --> opp3 wins

opp3 game history:
Game #2: opp2(0-1250-0-0) vs opp3(0-1150-0-0) --> opp3 wins
Game #2: opp2(0-1250-0-0) vs opp3(0-1150-0-0) --> opp3 wins

Elmo game history:
Game #1: Elmo(0-1200-0-0) vs opp1(0-1100-0-0) --> opp1 wins
Game #1: Elmo(0-1200-0-0) vs opp1(0-1100-0-0) --> opp1 wins

After 2 waves:

GAME HISTORY:
Game #1: Elmo(0-1200-0-0) vs opp1(0-1100-0-0) --> opp1 wins
Game #2: opp2(0-1250-0-0) vs opp3(0-1150-0-0) --> opp3 wins
Game #3: Elmo(0-1191-0-2) vs opp1(1-1110-2-0) --> opp1 wins
Game #4: opp2(0-1241-0-2) vs opp3(1-1160-2-0) --> opp3 wins

GAME HISTORY:
Game #1: Elmo(0-1200-0-0) vs opp1(0-1100-0-0) --> opp1 wins
Game #2: opp2(0-1250-0-0) vs opp3(0-1150-0-0) --> opp3 wins
Game #3: Elmo(0-1191-0-2) vs opp1(1-1110-2-0) --> opp1 wins
Game #4: opp2(0-1241-0-2) vs opp3(1-1160-2-0) --> opp3 wins

PLAYER RECORDS:
opp1(2-1118-2-0)
Elmo(0-1184-0-2)
opp3(2-1168-2-0)
opp2(0-1234-0-2)
```

It gets worse when the four players each play three games.
  - There's still duplication, but it's not consistent.
  - Game #5 gets lost in the players' game history
  - Player records say there are six games

```
opp1 game history:
Game #1: Elmo(0-1200-0-0) vs opp1(0-1100-0-0) --> opp1 wins
Game #1: Elmo(0-1200-0-0) vs opp1(0-1100-0-0) --> opp1 wins
Game #3: Elmo(0-1191-0-2) vs opp1(1-1110-2-0) --> opp1 wins

opp2 game history:
Game #2: opp2(0-1250-0-0) vs opp3(0-1150-0-0) --> opp3 wins
Game #2: opp2(0-1250-0-0) vs opp3(0-1150-0-0) --> opp3 wins
Game #4: opp2(0-1241-0-2) vs opp3(1-1160-2-0) --> opp3 wins

opp3 game history:
Game #2: opp2(0-1250-0-0) vs opp3(0-1150-0-0) --> opp3 wins
Game #2: opp2(0-1250-0-0) vs opp3(0-1150-0-0) --> opp3 wins
Game #4: opp2(0-1241-0-2) vs opp3(1-1160-2-0) --> opp3 wins

Elmo game history:
Game #1: Elmo(0-1200-0-0) vs opp1(0-1100-0-0) --> opp1 wins
Game #1: Elmo(0-1200-0-0) vs opp1(0-1100-0-0) --> opp1 wins
Game #3: Elmo(0-1191-0-2) vs opp1(1-1110-2-0) --> opp1 wins

After 3 waves:

GAME HISTORY:
Game #1: Elmo(0-1200-0-0) vs opp1(0-1100-0-0) --> opp1 wins
Game #2: opp2(0-1250-0-0) vs opp3(0-1150-0-0) --> opp3 wins
Game #3: Elmo(0-1191-0-2) vs opp1(1-1110-2-0) --> opp1 wins
Game #4: opp2(0-1241-0-2) vs opp3(1-1160-2-0) --> opp3 wins
Game #5: opp1(2-1118-3-0) vs opp3(2-1168-3-0) --> opp3 wins

PLAYER RECORDS:
opp1(2-1113-3-0)
Elmo(0-1184-0-3)
opp3(3-1173-3-0)
opp2(0-1234-0-3)
```