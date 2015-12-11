# Introduction

This package will read a file like:
```
Thing1 Thing2 Thing2_value
```

```
A 9
A B 1
A C 2
A D 3
A E 4
B F 3
B G 2
C H 4
B I 5
D K 3
D J 2
D K 3
```

The first line in the file is the root thing.  We'll create a digraph between each Thing where the Thing1 is the parent 
of Thing2.  Assume each Thing has a unique name.

Once that graph is created, we'll output a CSV that can be used to make a Treemap in Google Sheets.

# Current output
```
Doing it.
---- Found the root: A

--- P (3)
--- Q (2)
--- R (3)
--- S (9)
-- F (3 | 20)
--- T (8)
--- U (2)
--- V (0)
--- W (4)
-- G (2 | 16)
-- I (5)
- B (1 | 42)
--- X (2)
--- Y (4)
--- Z (6)
-- H (4 | 16)
- C (2 | 18)
-- K (3)
-- J (2)
-- K (3)
- D (3 | 11)
-- L (4)
-- M (5)
-- N (6)
-- O (8)
- E (4 | 27)
A (7 | 105)
```
# Previous output

```
Doing it.
---- Found the root: A

A
- B (1)
-- F (3)
--- P (3)
--- Q (2)
--- R (3)
--- S (9)
-- G (2)
--- T (8)
--- U (2)
--- V (0)
--- W (4)
-- I (5)
- C (2)
-- H (4)
--- X (2)
--- Y (4)
--- Z (6)
- D (3)
-- K (3)
-- J (2)
-- K (3)
- E (4)
-- L (4)
-- M (5)
-- N (6)
-- O (8)
```

# Previouser output

```
Doing it.
working on: A 7
Found the root: A
working on: A B 1
Adding thing: B
working on: A C 2
Adding thing: C
working on: A D 3
Adding thing: D
working on: A E 4
Adding thing: E
working on: B F 3
Adding thing: F
working on: B G 2
Adding thing: G
working on: C H 4
Adding thing: H
working on: B I 5
Adding thing: I
working on: D K 3
Adding thing: K
working on: D J 2
Adding thing: J
working on: D K 3
Adding thing: K
working on: E L 4
Adding thing: L
working on: E M 5
Adding thing: M
working on: E N 6
Adding thing: N
working on: E O 8
Adding thing: O
working on: F P 3
Adding thing: P
working on: F Q 2
Adding thing: Q
working on: F R 3
Adding thing: R
working on: F S 9
Adding thing: S
working on: G T 8
Adding thing: T
working on: G U 2
Adding thing: U
working on: G V 0
Adding thing: V
working on: G W 4
Adding thing: W
working on: H X 2
Adding thing: X
working on: H Y 4
Adding thing: Y
working on: H Z 6
Adding thing: Z
```


