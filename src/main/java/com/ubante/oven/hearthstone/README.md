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
Thread   GG: Summary: loop 1326
Thread   GG: 12 win ->   3 occurences
Thread   GG: 11 win ->   1 occurences
Thread   GG: 10 win ->   2 occurences
Thread   GG:  9 win ->   3 occurences
Thread   GG:  8 win ->  10 occurences
Thread   GG:  7 win ->  12 occurences
Thread   GG:  6 win ->  16 occurences
Thread   GG:  5 win ->  30 occurences
Thread   GG:  4 win ->  36 occurences
Thread   GG:  3 win ->  66 occurences
Thread   GG:  2 win ->  94 occurences
Thread   GG:  1 win -> 119 occurences
Thread   GG:  0 win -> 108 occurences

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
Thread   GG: Summary: loop 1316
Thread   GG: 12 win ->   2 occurences
Thread   GG: 11 win ->   1 occurences
Thread   GG: 10 win ->   2 occurences
Thread   GG:  9 win ->   6 occurences
Thread   GG:  8 win ->   1 occurences
Thread   GG:  7 win ->   8 occurences
Thread   GG:  6 win ->  14 occurences
Thread   GG:  5 win ->  35 occurences
Thread   GG:  4 win ->  48 occurences
Thread   GG:  3 win ->  74 occurences
Thread   GG:  2 win ->  87 occurences
Thread   GG:  1 win -> 108 occurences
Thread   GG:  0 win -> 113 occurences
Thread ip259: Been in queue too long; done for the day.  Finished with a record of [9:7-2-9]

Process finished with exit code 0
```

# Current Output
```
Starting 500 player threads.

Thread   GG: Starting the game generator.
Thread   GG: 
Thread   GG: Summary: loop 300
Thread   GG:  0 win ->   3 occurences
Thread   GG: 
Thread   GG: Summary: loop 400
Thread   GG:  1 win ->   1 occurences
Thread   GG:  0 win ->  15 occurences
Thread   GG: 
Thread   GG: Summary: loop 500
Thread   GG:  1 win ->   9 occurences
Thread   GG:  0 win ->  23 occurences
Thread   GG: 
Thread   GG: Summary: loop 600
Thread   GG:  2 win ->   1 occurences
Thread   GG:  1 win ->  17 occurences
Thread   GG:  0 win ->  40 occurences
Thread   GG: 
Thread   GG: Summary: loop 700
Thread   GG:  3 win ->   1 occurences
Thread   GG:  2 win ->   3 occurences
Thread   GG:  1 win ->  27 occurences
Thread   GG:  0 win ->  61 occurences
Thread   GG: 
Thread   GG: Summary: loop 800
Thread   GG:  3 win ->   2 occurences
Thread   GG:  2 win ->   8 occurences
Thread   GG:  1 win ->  46 occurences
Thread   GG:  0 win ->  88 occurences
Thread   GG: 
Thread   GG: Summary: loop 900
Thread   GG:  4 win ->   2 occurences
Thread   GG:  3 win ->   6 occurences
Thread   GG:  2 win ->  24 occurences
Thread   GG:  1 win ->  71 occurences
Thread   GG:  0 win -> 104 occurences
Thread   GG: 
Thread   GG: Summary: loop 1000
Thread   GG:  4 win ->   4 occurences
Thread   GG:  3 win ->  11 occurences
Thread   GG:  2 win ->  49 occurences
Thread   GG:  1 win -> 100 occurences
Thread   GG:  0 win -> 108 occurences
Thread   GG: 
Thread   GG: Summary: loop 1100
Thread   GG:  6 win ->   3 occurences
Thread   GG:  5 win ->   2 occurences
Thread   GG:  4 win ->   6 occurences
Thread   GG:  3 win ->  33 occurences
Thread   GG:  2 win ->  71 occurences
Thread   GG:  1 win -> 117 occurences
Thread   GG:  0 win -> 108 occurences
Thread   GG: 
Thread   GG: Summary: loop 1200
Thread   GG:  6 win ->   4 occurences
Thread   GG:  5 win ->  10 occurences
Thread   GG:  4 win ->  19 occurences
Thread   GG:  3 win ->  51 occurences
Thread   GG:  2 win ->  92 occurences
Thread   GG:  1 win -> 119 occurences
Thread   GG:  0 win -> 108 occurences
Thread   GG: 
Thread   GG: Summary: loop 1300
Thread   GG: 12 win ->   1 occurences
Thread   GG:  9 win ->   1 occurences
Thread   GG:  8 win ->   4 occurences
Thread   GG:  7 win ->   8 occurences
Thread   GG:  6 win ->  13 occurences
Thread   GG:  5 win ->  27 occurences
Thread   GG:  4 win ->  36 occurences
Thread   GG:  3 win ->  66 occurences
Thread   GG:  2 win ->  94 occurences
Thread   GG:  1 win -> 119 occurences
Thread   GG:  0 win -> 108 occurences
Thread   GG: Exiting because there is no one in queue.
Thread   GG: 
Thread   GG: 
Thread   GG: ----- FINAL -----
Thread   GG: 
Thread   GG: Summary: loop 1326
Thread   GG: 12 win ->   3 occurences
Thread   GG: 11 win ->   1 occurences
Thread   GG: 10 win ->   2 occurences
Thread   GG:  9 win ->   3 occurences
Thread   GG:  8 win ->  10 occurences
Thread   GG:  7 win ->  12 occurences
Thread   GG:  6 win ->  16 occurences
Thread   GG:  5 win ->  30 occurences
Thread   GG:  4 win ->  36 occurences
Thread   GG:  3 win ->  66 occurences
Thread   GG:  2 win ->  94 occurences
Thread   GG:  1 win -> 119 occurences
Thread   GG:  0 win -> 108 occurences

Process finished with exit code 0
```

# Last Output
```
Starting 500 player threads.

Thread   GG: Starting the game generator.
Thread   GG: 
Thread   GG: Summary: loop 300
Thread   GG:  0 win ->   1 occurences
Thread   GG: 
Thread   GG: Summary: loop 400
Thread   GG:  1 win ->   1 occurences
Thread   GG:  0 win ->   8 occurences
Thread   GG: 
Thread   GG: Summary: loop 500
Thread   GG:  2 win ->   2 occurences
Thread   GG:  1 win ->   4 occurences
Thread   GG:  0 win ->  22 occurences
Thread   GG: 
Thread   GG: Summary: loop 600
Thread   GG:  2 win ->   5 occurences
Thread   GG:  1 win ->  13 occurences
Thread   GG:  0 win ->  34 occurences
Thread   GG: 
Thread   GG: Summary: loop 700
Thread   GG:  3 win ->   1 occurences
Thread   GG:  2 win ->   8 occurences
Thread   GG:  1 win ->  25 occurences
Thread   GG:  0 win ->  46 occurences
Thread   GG: 
Thread   GG: Summary: loop 800
Thread   GG:  3 win ->   2 occurences
Thread   GG:  2 win ->  18 occurences
Thread   GG:  1 win ->  43 occurences
Thread   GG:  0 win ->  71 occurences
Thread   GG: 
Thread   GG: Summary: loop 900
Thread   GG:  4 win ->   2 occurences
Thread   GG:  3 win ->   5 occurences
Thread   GG:  2 win ->  29 occurences
Thread   GG:  1 win ->  75 occurences
Thread   GG:  0 win ->  90 occurences
Thread   GG: 
Thread   GG: Summary: loop 1000
Thread   GG:  4 win ->   6 occurences
Thread   GG:  3 win ->  12 occurences
Thread   GG:  2 win ->  50 occurences
Thread   GG:  1 win -> 102 occurences
Thread   GG:  0 win -> 100 occurences
Thread   GG: 
Thread   GG: Summary: loop 1100
Thread   GG:  5 win ->   1 occurences
Thread   GG:  4 win ->  13 occurences
Thread   GG:  3 win ->  27 occurences
Thread   GG:  2 win ->  77 occurences
Thread   GG:  1 win -> 120 occurences
Thread   GG:  0 win -> 100 occurences
Thread   GG: 
Thread   GG: Summary: loop 1200
Thread   GG:  6 win ->   2 occurences
Thread   GG:  5 win ->   3 occurences
Thread   GG:  4 win ->  37 occurences
Thread   GG:  3 win ->  50 occurences
Thread   GG:  2 win -> 103 occurences
Thread   GG:  1 win -> 124 occurences
Thread   GG:  0 win -> 100 occurences
Thread   GG: Exiting because there is no one in queue.
Thread   GG: 
Thread   GG: 
Thread   GG: ----- FINAL -----
Thread   GG: 
Thread   GG: Summary: loop 1299
Thread   GG: 12 win ->   1 occurences
Thread   GG:  9 win ->   3 occurences
Thread   GG:  8 win ->   6 occurences
Thread   GG:  7 win ->  11 occurences
Thread   GG:  6 win ->  19 occurences
Thread   GG:  5 win ->  18 occurences
Thread   GG:  4 win ->  55 occurences
Thread   GG:  3 win ->  59 occurences
Thread   GG:  2 win -> 104 occurences
Thread   GG:  1 win -> 124 occurences
Thread   GG:  0 win -> 100 occurences

Process finished with exit code 0

```

# Previous Output
```
Starting 500 player threads.

Thread   GG: Starting the game generator.
Thread   GG: 
Thread   GG: Summary: loop 300
Thread   GG:  1 win ->   2 occurences
Thread   GG: 
Thread   GG: 
Thread   GG: Summary: loop 400
Thread   GG:  1 win ->   2 occurences
Thread   GG:  0 win ->  15 occurences
Thread   GG: 
Thread   GG: 
Thread   GG: Summary: loop 500
Thread   GG:  1 win ->   8 occurences
Thread   GG:  0 win ->  21 occurences
Thread   GG: 
Thread   GG: 
Thread   GG: Summary: loop 600
Thread   GG:  2 win ->   1 occurences
Thread   GG:  1 win ->  13 occurences
Thread   GG:  0 win ->  44 occurences
Thread   GG: 
Thread   GG: 
Thread   GG: Summary: loop 700
Thread   GG:  2 win ->   2 occurences
Thread   GG:  1 win ->  24 occurences
Thread   GG:  0 win ->  57 occurences
Thread   GG: 
Thread   GG: 
Thread   GG: Summary: loop 800
Thread   GG:  3 win ->   1 occurences
Thread   GG:  2 win ->   7 occurences
Thread   GG:  1 win ->  44 occurences
Thread   GG:  0 win ->  87 occurences
Thread   GG: 
Thread   GG: 
Thread   GG: Summary: loop 900
Thread   GG:  5 win ->   1 occurences
Thread   GG:  3 win ->  11 occurences
Thread   GG:  2 win ->  15 occurences
Thread   GG:  1 win ->  66 occurences
Thread   GG:  0 win ->  98 occurences
Thread   GG: 
Thread   GG: 
Thread   GG: Summary: loop 1000
Thread   GG:  5 win ->   1 occurences
Thread   GG:  4 win ->   2 occurences
Thread   GG:  3 win ->  18 occurences
Thread   GG:  2 win ->  28 occurences
Thread   GG:  1 win ->  95 occurences
Thread   GG:  0 win -> 105 occurences
Thread   GG: 
Thread   GG: 
Thread   GG: Summary: loop 1100
Thread   GG:  6 win ->   1 occurences
Thread   GG:  5 win ->   2 occurences
Thread   GG:  4 win ->   6 occurences
Thread   GG:  3 win ->  43 occurences
Thread   GG:  2 win ->  48 occurences
Thread   GG:  1 win -> 107 occurences
Thread   GG:  0 win -> 105 occurences
Thread   GG: 
Thread   GG: 
Thread   GG: Summary: loop 1200
Thread   GG:  6 win ->   1 occurences
Thread   GG:  5 win ->   7 occurences
Thread   GG:  4 win ->  21 occurences
Thread   GG:  3 win ->  67 occurences
Thread   GG:  2 win ->  67 occurences
Thread   GG:  1 win -> 109 occurences
Thread   GG:  0 win -> 105 occurences
Thread   GG: 
Thread   GG: 
Thread   GG: Summary: loop 1300
Thread   GG:  7 win ->   4 occurences
Thread   GG:  6 win ->   8 occurences
Thread   GG:  5 win ->  24 occurences
Thread   GG:  4 win ->  52 occurences
Thread   GG:  3 win ->  82 occurences
Thread   GG:  2 win ->  72 occurences
Thread   GG:  1 win -> 109 occurences
Thread   GG:  0 win -> 105 occurences
Thread   GG: 
```
