# Introduction

Let's simulate a season of 1000 players.  I'd like to see how high MMR ratings can go.

# Approach

As in the ArenaSimulator, I'll create a GameGenerator thread, and a lot of player threads.  Since this is ladder, the 
ratings will differ than in Arena.  And a player can play forever if desired.

I'll need to improve the game-matching.  And logging to make it easier to filter printlns.

# Current Output
```
Starting 5 player threads.

Thread   GG: Starting the season game generator.
Thread   GG: Starting the ladder game generator thread.
Thread  lp1: Starting the ladder player thread.
Thread  lp2: Starting the ladder player thread.
Thread  lp5: Starting the ladder player thread.
Thread  lp3: Starting the ladder player thread.
Thread  lp4: Starting the ladder player thread.
Thread  lp1: entering game #1
Thread  lp4: entering game #1
Thread  lp3: entering game #1
Thread  lp5: entering game #1
Thread  lp2: entering game #1
Thread   GG: Exiting because there has been just one player in queue for 60 seconds

Process finished with exit code 0
```



