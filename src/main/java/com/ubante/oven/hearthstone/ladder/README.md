# Introduction

Let's simulate a season of 1000 players.  I'd like to see how high MMR ratings can go.

# Approach

As in the ArenaSimulator, I'll create a GameGenerator thread, and a lot of player threads.  Since this is ladder, the 
ratings will differ than in Arena.  And a player can play forever if desired.

I'll need to improve the game-matching.  And logging to make it easier to filter printlns.