# Simulating Arena records
_ArenaOpponentRankSimulator has the main()._

# Latest output
Players are still playing after losing 3 games.  Also, losses are not recorded in the
__PLAYER RECORDS__.  These are probably related.

```
opp0 game history:
Game #1: opp1(0-1110-0-0) beat opp0(0-1100-0-0) 
Game #3: opp1(1-1111-1-0) beat opp0(0-1099-0-1) 
Game #5: opp1(2-1112-2-0) beat opp0(0-1098-0-2) 
Game #7: opp1(3-1114-3-0) beat opp0(0-1096-0-3) 

opp1 game history:
Game #1: opp1(0-1110-0-0) beat opp0(0-1100-0-0) 
Game #3: opp1(1-1111-1-0) beat opp0(0-1099-0-1) 
Game #5: opp1(2-1112-2-0) beat opp0(0-1098-0-2) 
Game #7: opp1(3-1114-3-0) beat opp0(0-1096-0-3) 
Game #9: opp3(4-1135-4-0) beat opp1(4-1115-4-0) 
Game #10: opp3(5-1137-5-0) beat opp1(4-1113-4-1) 
Game #11: opp3(6-1140-6-0) beat opp1(4-1111-4-2) 
Game #12: opp3(7-1143-7-0) beat opp1(4-1107-4-3) 

opp2 game history:
Game #2: opp3(0-1130-0-0) beat opp2(0-1120-0-0) 
Game #4: opp3(1-1131-1-0) beat opp2(0-1119-0-1) 
Game #6: opp3(2-1132-2-0) beat opp2(0-1118-0-2) 
Game #8: opp3(3-1134-3-0) beat opp2(0-1116-0-3) 

opp3 game history:
Game #2: opp3(0-1130-0-0) beat opp2(0-1120-0-0) 
Game #4: opp3(1-1131-1-0) beat opp2(0-1119-0-1) 
Game #6: opp3(2-1132-2-0) beat opp2(0-1118-0-2) 
Game #8: opp3(3-1134-3-0) beat opp2(0-1116-0-3) 
Game #9: opp3(4-1135-4-0) beat opp1(4-1115-4-0) 
Game #10: opp3(5-1137-5-0) beat opp1(4-1113-4-1) 
Game #11: opp3(6-1140-6-0) beat opp1(4-1111-4-2) 
Game #12: opp3(7-1143-7-0) beat opp1(4-1107-4-3) 

After 9 waves:

GAME HISTORY:
Game #1: opp1(0-1110-0-0) beat opp0(0-1100-0-0) 
Game #2: opp3(0-1130-0-0) beat opp2(0-1120-0-0) 
Game #3: opp1(1-1111-1-0) beat opp0(0-1099-0-1) 
Game #4: opp3(1-1131-1-0) beat opp2(0-1119-0-1) 
Game #5: opp1(2-1112-2-0) beat opp0(0-1098-0-2) 
Game #6: opp3(2-1132-2-0) beat opp2(0-1118-0-2) 
Game #7: opp1(3-1114-3-0) beat opp0(0-1096-0-3) 
Game #8: opp3(3-1134-3-0) beat opp2(0-1116-0-3) 
Game #9: opp3(4-1135-4-0) beat opp1(4-1115-4-0) 
Game #10: opp3(5-1137-5-0) beat opp1(4-1113-4-1) 
Game #11: opp3(6-1140-6-0) beat opp1(4-1111-4-2) 
Game #12: opp3(7-1143-7-0) beat opp1(4-1107-4-3) 

PLAYER RECORDS:
opp1(4-1107-4-3)
opp0(0-1096-0-3)
opp3(8-1146-8-0)
opp2(0-1116-0-3)
```

# Previous output

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

6 waves could produce 12 games but opp2 and Elmo dropped the tourney quickly resulting in 9 games.
The PLAYER RECORDS looks weird but otherwise, looking good.

# Next
The Player objects should decide on their own when they're ready to play instead of 
ArenaOpponentRankSimulator calling their playArena() method.

The GameGenerator should try to match players of similar ranks instead of the first two waiting players.

Get to 100+ Player threads.

Need a PlayerRating object.