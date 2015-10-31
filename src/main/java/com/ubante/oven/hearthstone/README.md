# Simulating Arena records

Solved the ConcurrentModificationException.  Now after 6 waves:

```
opp1 game history:
Game #1: Elmo(0-1200-0-0) vs opp1(0-1100-0-0) --> opp1 wins
Game #3: Elmo(0-1191-0-1) vs opp1(1-1110-1-0) --> opp1 wins
Game #5: Elmo(0-1184-0-2) vs opp1(2-1118-2-0) --> opp1 wins
Game #7: opp1(3-1125-3-0) vs opp3(3-1175-3-0) --> opp3 wins
Game #8: opp1(3-1119-3-1) vs opp3(4-1180-4-0) --> opp3 wins
Game #9: opp1(3-1113-3-2) vs opp3(5-1186-5-0) --> opp3 wins

opp2 game history:
Game #2: opp2(0-1250-0-0) vs opp3(0-1150-0-0) --> opp3 wins
Game #4: opp2(0-1241-0-1) vs opp3(1-1160-1-0) --> opp3 wins
Game #6: opp2(0-1234-0-2) vs opp3(2-1168-2-0) --> opp3 wins

opp3 game history:
Game #2: opp2(0-1250-0-0) vs opp3(0-1150-0-0) --> opp3 wins
Game #4: opp2(0-1241-0-1) vs opp3(1-1160-1-0) --> opp3 wins
Game #6: opp2(0-1234-0-2) vs opp3(2-1168-2-0) --> opp3 wins
Game #7: opp1(3-1125-3-0) vs opp3(3-1175-3-0) --> opp3 wins
Game #8: opp1(3-1119-3-1) vs opp3(4-1180-4-0) --> opp3 wins
Game #9: opp1(3-1113-3-2) vs opp3(5-1186-5-0) --> opp3 wins

Elmo game history:
Game #1: Elmo(0-1200-0-0) vs opp1(0-1100-0-0) --> opp1 wins
Game #3: Elmo(0-1191-0-1) vs opp1(1-1110-1-0) --> opp1 wins
Game #5: Elmo(0-1184-0-2) vs opp1(2-1118-2-0) --> opp1 wins

After 6 waves:

GAME HISTORY:
Game #1: Elmo(0-1200-0-0) vs opp1(0-1100-0-0) --> opp1 wins
Game #2: opp2(0-1250-0-0) vs opp3(0-1150-0-0) --> opp3 wins
Game #3: Elmo(0-1191-0-1) vs opp1(1-1110-1-0) --> opp1 wins
Game #4: opp2(0-1241-0-1) vs opp3(1-1160-1-0) --> opp3 wins
Game #5: Elmo(0-1184-0-2) vs opp1(2-1118-2-0) --> opp1 wins
Game #6: opp2(0-1234-0-2) vs opp3(2-1168-2-0) --> opp3 wins
Game #7: opp1(3-1125-3-0) vs opp3(3-1175-3-0) --> opp3 wins
Game #8: opp1(3-1119-3-1) vs opp3(4-1180-4-0) --> opp3 wins
Game #9: opp1(3-1113-3-2) vs opp3(5-1186-5-0) --> opp3 wins

PLAYER RECORDS:
opp1(3-1104-3-3)
Elmo(1178)
opp3(6-1193-6-0)
opp2(1228)
```

6 waves could produce 12 games but opp2 and Elmo dropped the tourney quickly resulting in 9 waves.
The PLAYER RECORDS looks wierd but otherwise, looking good.

# Next
The Player objects should decide on their own when they're ready to play instead of 
ArenaOpponentRankSimulator calling their playArena() method.

The GameGenerator should try to match players of similar ranks instead of the first two waiting players.

Get to 100+ Player threads.