# Introduction
This will simulate N players running Hearthstone arena tournaments.  It will show how
likely it is to earn enough gold to cover the entrance fee.

## Completion types
When all players are finished, the Game Generator thread will find no one in queue and simulation will end.

```
Thread   GG: Exiting because there is no one in queue.
Thread   GG: 
Thread   GG: 
Thread   GG: ----- FINAL -----
Thread   GG: 
Thread   GG: Summary: loop 1290
Thread   GG: 12 win ->  24 occurrences ( 4.8% of 500 players)
Thread   GG: 10 win ->   6 occurrences ( 1.2% of 500 players)
Thread   GG:  9 win ->   8 occurrences ( 1.6% of 500 players)
Thread   GG:  8 win ->  10 occurrences ( 2.0% of 500 players)
Thread   GG:  7 win ->   9 occurrences ( 1.8% of 500 players)
Thread   GG:  6 win ->  12 occurrences ( 2.4% of 500 players)
Thread   GG:  5 win ->  18 occurrences ( 3.6% of 500 players)
Thread   GG:  4 win ->  26 occurrences ( 5.2% of 500 players)
Thread   GG:  3 win ->  39 occurrences ( 7.8% of 500 players)
Thread   GG:  2 win ->  53 occurrences (10.6% of 500 players)
Thread   GG:  1 win ->  73 occurrences (14.6% of 500 players)
Thread   GG:  0 win -> 222 occurrences (44.4% of 500 players)

Process finished with exit code 0
```

It is possible that only one player has not finished, ie not lost 3 games and not won 12 games.  When this happens,
that player thread will eventually end finishing the simulation.
```
Thread   GG: Exiting because there has been just one player in queue for 60 seconds
Thread   GG: 
Thread   GG: 
Thread   GG: ----- FINAL -----
Thread   GG: 
Thread   GG: Summary: loop 1300
Thread   GG: 12 win ->  26 occurrences ( 5.2% of 500 players)
Thread   GG: 10 win ->   5 occurrences ( 1.0% of 500 players)
Thread   GG:  9 win ->   4 occurrences ( 0.8% of 500 players)
Thread   GG:  8 win ->   6 occurrences ( 1.2% of 500 players)
Thread   GG:  7 win ->  12 occurrences ( 2.4% of 500 players)
Thread   GG:  6 win ->  14 occurrences ( 2.8% of 500 players)
Thread   GG:  5 win ->  24 occurrences ( 4.8% of 500 players)
Thread   GG:  4 win ->  20 occurrences ( 4.0% of 500 players)
Thread   GG:  3 win ->  49 occurrences ( 9.8% of 500 players)
Thread   GG:  2 win ->  51 occurrences (10.2% of 500 players)
Thread   GG:  1 win ->  76 occurrences (15.2% of 500 players)
Thread   GG:  0 win -> 212 occurrences (42.4% of 500 players)
Thread ip188: Been in queue too long; done for the day.  Finished with a record of [17:10-2-12]

Process finished with exit code 0
```

# Current Output
```
Starting 99 player threads with each playing 100 games.
<snip>
Thread   GG: lp88 (Rank 20) beat lp84 (Rank 17)
Thread lp18: entering game #31
Thread  lp7: entering game #24
Thread   GG: lp18 (Rank 23) beat lp7 (Rank 22)
Thread lp65: entering game #32
Thread lp52: entering game #28
Thread   GG: lp65 (Rank 25) beat lp52 (Rank 19)
Thread  lp6: entering game #31
Thread lp51: entering game #32
Thread   GG: lp6 (Rank 20) beat lp51 (Rank 19)
Thread lp60: entering game #24
Thread lp79: entering game #30
<snip>
```

# Previous Output
After adding percentages.
```
Starting 500 player threads.

Thread   GG: Starting the game generator.
Thread   GG: 
Thread   GG: Summary: loop 300
Thread   GG:  0 win ->   6 occurrences ( 1.2% of 500 players)
Thread   GG: 
Thread   GG: Summary: loop 400
Thread   GG:  1 win ->   1 occurrences ( 0.2% of 500 players)
Thread   GG:  0 win ->  25 occurrences ( 5.0% of 500 players)
Thread   GG: 
Thread   GG: Summary: loop 500
Thread   GG:  1 win ->   3 occurrences ( 0.6% of 500 players)
Thread   GG:  0 win ->  44 occurrences ( 8.8% of 500 players)
Thread   GG: 
Thread   GG: Summary: loop 600
Thread   GG:  2 win ->   1 occurrences ( 0.2% of 500 players)
Thread   GG:  1 win ->   5 occurrences ( 1.0% of 500 players)
Thread   GG:  0 win ->  72 occurrences (14.4% of 500 players)
Thread   GG: 
Thread   GG: Summary: loop 700
Thread   GG:  4 win ->   1 occurrences ( 0.2% of 500 players)
Thread   GG:  2 win ->   1 occurrences ( 0.2% of 500 players)
Thread   GG:  1 win ->   9 occurrences ( 1.8% of 500 players)
Thread   GG:  0 win -> 118 occurrences (23.6% of 500 players)
Thread   GG: 
Thread   GG: Summary: loop 800
Thread   GG:  4 win ->   1 occurrences ( 0.2% of 500 players)
Thread   GG:  3 win ->   1 occurrences ( 0.2% of 500 players)
Thread   GG:  2 win ->   3 occurrences ( 0.6% of 500 players)
Thread   GG:  1 win ->  28 occurrences ( 5.6% of 500 players)
Thread   GG:  0 win -> 167 occurrences (33.4% of 500 players)
Thread   GG: 
Thread   GG: Summary: loop 900
Thread   GG:  4 win ->   1 occurrences ( 0.2% of 500 players)
Thread   GG:  3 win ->   2 occurrences ( 0.4% of 500 players)
Thread   GG:  2 win ->   6 occurrences ( 1.2% of 500 players)
Thread   GG:  1 win ->  51 occurrences (10.2% of 500 players)
Thread   GG:  0 win -> 197 occurrences (39.4% of 500 players)
Thread   GG: 
Thread   GG: Summary: loop 1000
Thread   GG:  7 win ->   1 occurrences ( 0.2% of 500 players)
Thread   GG:  6 win ->   1 occurrences ( 0.2% of 500 players)
Thread   GG:  4 win ->   2 occurrences ( 0.4% of 500 players)
Thread   GG:  3 win ->   9 occurrences ( 1.8% of 500 players)
Thread   GG:  2 win ->  15 occurrences ( 3.0% of 500 players)
Thread   GG:  1 win ->  72 occurrences (14.4% of 500 players)
Thread   GG:  0 win -> 212 occurrences (42.4% of 500 players)
Thread   GG: 
Thread   GG: Summary: loop 1100
Thread   GG:  7 win ->   1 occurrences ( 0.2% of 500 players)
Thread   GG:  6 win ->   1 occurrences ( 0.2% of 500 players)
Thread   GG:  5 win ->   1 occurrences ( 0.2% of 500 players)
Thread   GG:  4 win ->   5 occurrences ( 1.0% of 500 players)
Thread   GG:  3 win ->  26 occurrences ( 5.2% of 500 players)
Thread   GG:  2 win ->  42 occurrences ( 8.4% of 500 players)
Thread   GG:  1 win ->  76 occurrences (15.2% of 500 players)
Thread   GG:  0 win -> 212 occurrences (42.4% of 500 players)
Thread   GG: 
Thread   GG: Summary: loop 1200
Thread   GG: 12 win ->   2 occurrences ( 0.4% of 500 players)
Thread   GG:  7 win ->   1 occurrences ( 0.2% of 500 players)
Thread   GG:  6 win ->   3 occurrences ( 0.6% of 500 players)
Thread   GG:  5 win ->  12 occurrences ( 2.4% of 500 players)
Thread   GG:  4 win ->  18 occurrences ( 3.6% of 500 players)
Thread   GG:  3 win ->  42 occurrences ( 8.4% of 500 players)
Thread   GG:  2 win ->  51 occurrences (10.2% of 500 players)
Thread   GG:  1 win ->  76 occurrences (15.2% of 500 players)
Thread   GG:  0 win -> 212 occurrences (42.4% of 500 players)
Thread   GG: Exiting because there has been just one player in queue for 60 seconds
Thread   GG: 
Thread   GG: 
Thread   GG: ----- FINAL -----
Thread   GG: 
Thread   GG: Summary: loop 1300
Thread   GG: 12 win ->  26 occurrences ( 5.2% of 500 players)
Thread   GG: 10 win ->   5 occurrences ( 1.0% of 500 players)
Thread   GG:  9 win ->   4 occurrences ( 0.8% of 500 players)
Thread   GG:  8 win ->   6 occurrences ( 1.2% of 500 players)
Thread   GG:  7 win ->  12 occurrences ( 2.4% of 500 players)
Thread   GG:  6 win ->  14 occurrences ( 2.8% of 500 players)
Thread   GG:  5 win ->  24 occurrences ( 4.8% of 500 players)
Thread   GG:  4 win ->  20 occurrences ( 4.0% of 500 players)
Thread   GG:  3 win ->  49 occurrences ( 9.8% of 500 players)
Thread   GG:  2 win ->  51 occurrences (10.2% of 500 players)
Thread   GG:  1 win ->  76 occurrences (15.2% of 500 players)
Thread   GG:  0 win -> 212 occurrences (42.4% of 500 players)
Thread ip188: Been in queue too long; done for the day.  Finished with a record of [17:10-2-12]

Process finished with exit code 0
```

# Previous Output
This is after giving the player with a better record a better chance of winning the game.
```
Starting 500 player threads.

Thread   GG: Starting the game generator.
Thread   GG: 
Thread   GG: Summary: loop 300
Thread   GG:  0 win ->   6 occurences
Thread   GG: 
Thread   GG: Summary: loop 400
Thread   GG:  0 win ->  21 occurences
Thread   GG: 
Thread   GG: Summary: loop 500
Thread   GG:  1 win ->   2 occurences
Thread   GG:  0 win ->  47 occurences
Thread   GG: 
Thread   GG: Summary: loop 600
Thread   GG:  1 win ->   5 occurences
Thread   GG:  0 win ->  71 occurences
Thread   GG: 
Thread   GG: Summary: loop 700
Thread   GG:  2 win ->   1 occurences
Thread   GG:  1 win ->  12 occurences
Thread   GG:  0 win -> 108 occurences
Thread   GG: 
Thread   GG: Summary: loop 800
Thread   GG:  2 win ->   4 occurences
Thread   GG:  1 win ->  22 occurences
Thread   GG:  0 win -> 165 occurences
Thread   GG: 
Thread   GG: Summary: loop 900
Thread   GG:  4 win ->   1 occurences
Thread   GG:  3 win ->   1 occurences
Thread   GG:  2 win ->  10 occurences
Thread   GG:  1 win ->  40 occurences
Thread   GG:  0 win -> 202 occurences
Thread   GG: 
Thread   GG: Summary: loop 1000
Thread   GG:  4 win ->   3 occurences
Thread   GG:  3 win ->   3 occurences
Thread   GG:  2 win ->  30 occurences
Thread   GG:  1 win ->  65 occurences
Thread   GG:  0 win -> 209 occurences
Thread   GG: 
Thread   GG: Summary: loop 1100
Thread   GG:  5 win ->   1 occurences
Thread   GG:  4 win ->  11 occurences
Thread   GG:  3 win ->  15 occurences
Thread   GG:  2 win ->  49 occurences
Thread   GG:  1 win ->  79 occurences
Thread   GG:  0 win -> 209 occurences
Thread   GG: 
Thread   GG: Summary: loop 1200
Thread   GG: 12 win ->   4 occurences
Thread   GG:  7 win ->   1 occurences
Thread   GG:  6 win ->   3 occurences
Thread   GG:  5 win ->  10 occurences
Thread   GG:  4 win ->  30 occurences
Thread   GG:  3 win ->  29 occurences
Thread   GG:  2 win ->  60 occurences
Thread   GG:  1 win ->  81 occurences
Thread   GG:  0 win -> 209 occurences
Thread   GG: Exiting because there is no one in queue.
Thread   GG: 
Thread   GG: 
Thread   GG: ----- FINAL -----
Thread   GG: 
Thread   GG: Summary: loop 1278
Thread   GG: 12 win ->  23 occurences
Thread   GG: 10 win ->   1 occurences
Thread   GG:  9 win ->   7 occurences
Thread   GG:  8 win ->   8 occurences
Thread   GG:  7 win ->  11 occurences
Thread   GG:  6 win ->  14 occurences
Thread   GG:  5 win ->  17 occurences
Thread   GG:  4 win ->  36 occurences
Thread   GG:  3 win ->  33 occurences
Thread   GG:  2 win ->  60 occurences
Thread   GG:  1 win ->  81 occurences
Thread   GG:  0 win -> 209 occurences

Process finished with exit code 0

```
