# Introduction

Let's simulate a season of 1000 players.  I'd like to see how high MMR ratings can go.

# Approach

As in the ArenaSimulator, I'll create a GameGenerator thread, and a lot of player threads.  Since this is ladder, the 
ratings will differ than in Arena.  And a player can play forever if desired.

I'll need to improve the game-matching.  And logging to make it easier to filter printlns.

XXX in LadderPlayer, we can replace the for loop with a check to static SeasonSimulator.isSeasonOver().

# Current Output
Brownian motion is happening but I need a cleaner way to present the results.

```
int playerCount = 200; int gamesToPlay = 500;

Thread   GG: lp84 (Rank 25) beat lp71 (Rank 17)
Thread lp96: entering game #98
Thread lp188: done for the season
Thread lp84: entering game #98
Thread   GG: lp96 (Rank 17) beat lp84 (Rank 25)
Thread lp149: entering game #98
Thread lp126: done for the season
Thread lp98: entering game #98
Thread   GG: lp149 (Rank 15) beat lp98 (Rank 19)
Thread lp149: entering game #99
Thread lp140: entering game #99
Thread   GG: lp149 (Rank 15) beat lp140 (Rank 14)
Thread lp84: entering game #99
Thread lp159: entering game #99
Thread   GG: lp84 (Rank 25) beat lp159 (Rank 21)
Thread lp71: entering game #98
Thread lp96: entering game #99
Thread   GG: lp71 (Rank 17) beat lp96 (Rank 16)
Thread lp71: entering game #99
Thread lp98: entering game #99
Thread   GG: lp71 (Rank 17) beat lp98 (Rank 19)
Thread lp140: done for the season
Thread lp159: done for the season
Thread lp84: done for the season
Thread lp149: done for the season
Thread lp96: done for the season
Thread lp71: done for the season
Thread lp98: done for the season
Thread   GG: Exiting because there is no one in queue.
```

# Previous Output
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
Thread   GG: lp66 (Rank 22) beat lp79 (Rank 17)
Thread lp24: entering game #96
Thread lp66: entering game #97
Thread   GG: lp24 (Rank 16) beat lp66 (Rank 22)
Thread lp64: entering game #96
Thread lp99: entering game #97
Thread   GG: lp64 (Rank 13) beat lp99 (Rank 21)
Thread lp61: entering game #98
Thread lp80: entering game #95
Thread   GG: lp61 (Rank 24) beat lp80 (Rank 12)
Thread lp61: entering game #99
Thread lp64: entering game #97
Thread   GG: lp61 (Rank 23) beat lp64 (Rank 13)
Thread lp24: entering game #97
Thread lp26: entering game #90
Thread   GG: lp24 (Rank 16) beat lp26 (Rank 15)
Thread lp54: entering game #99
Thread lp66: entering game #98
Thread   GG: lp54 (Rank 17) beat lp66 (Rank 22)
Thread lp73: entering game #95
Thread lp24: entering game #98
Thread   GG: lp73 (Rank 17) beat lp24 (Rank 16)
Thread lp64: entering game #98
Thread lp24: entering game #99
Thread   GG: lp64 (Rank 13) beat lp24 (Rank 16)
Thread lp79: entering game #98
Thread lp80: entering game #96
Thread   GG: lp79 (Rank 17) beat lp80 (Rank 13)
```



