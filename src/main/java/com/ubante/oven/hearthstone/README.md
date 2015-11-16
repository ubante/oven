# Hearthstone

This is a card game by Blizzard that uses the context/color/universe of Warcraft.  It's a turn-based combat game that
gets compared to Magic, the Gathering.  But having played a lot of MtG, Hearthstone feels more like Pokemon.  
Admittedly, I haven't played more than a game of Pokemon, but other than there are cards, there's not much similarity
with MtG.  I've been playing Hearthstone for a couple of weeks and it seems like a good enough thing to model with some
programming.

# Packages

The main ```c.u.o.common``` package has the classes that are _common_.  

## arena

```arena``` simulates 500 players in Arena.  Using a simple way to determine the winner, after most (if not all) players
have finished their arena, the breakdown by wins are:

```
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
```

## elisestarseeker

This is a new card that came with the recent adventure.  It requires finding three cards to pull off the combo.  The
simulation shows this card needs a deck that supports card draw or tutoring.

```
 * After 1000000 iterations, we have an average of 28.42 cards to find the Monkey.
```

## hearthstonebad

One day, these junky classes may come in handy.

## ladder

This package will simulate many players in ladder.  Still in progress.

## renojackson

This is also based on a new card.  Reno Jackson encourages you to play a singleton deck.  But you don't _have_ to. 
If you don't then you'll need to be patient when playing 

```
With 0 pairs and after 10000 runs, it took an average of 15.5 cards to play Jackson with kicker.
With 1 pairs and after 10000 runs, it took an average of 18.1 cards to play Jackson with kicker.
With 2 pairs and after 10000 runs, it took an average of 19.6 cards to play Jackson with kicker.
With 3 pairs and after 10000 runs, it took an average of 20.7 cards to play Jackson with kicker.
With 4 pairs and after 10000 runs, it took an average of 21.5 cards to play Jackson with kicker.
With 5 pairs and after 10000 runs, it took an average of 22.1 cards to play Jackson with kicker.
With 6 pairs and after 10000 runs, it took an average of 22.6 cards to play Jackson with kicker.
With 7 pairs and after 10000 runs, it took an average of 23.0 cards to play Jackson with kicker.
With 8 pairs and after 10000 runs, it took an average of 23.5 cards to play Jackson with kicker.
With 9 pairs and after 10000 runs, it took an average of 23.8 cards to play Jackson with kicker.
```

_I'm sorry Reno Jackson, I am for reeeeeaaal._


