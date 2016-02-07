# Introduction
This will rotate a matrix.  It's not difficult, but it is a pain.

# Output
The below is for a matrix of width 8.

```
Here is the matrix:
 1  2  3  4  5  6  7  8 
 9 10 11 12 13 14 15 16 
17 18 19 20 21 22 23 24 
25 26 27 28 29 30 31 32 
33 34 35 36 37 38 39 40 
41 42 43 44 45 46 47 48 
49 50 51 52 53 54 55 56 
57 58 59 60 61 62 63 64 

Working on square layer #0
- offset=0
Row 7, column 0 (57) moved to row 0, column 0 (1)
Row 7, column 7 (64) moved to row 7, column 0 (57)
Row 0, column 7 (8) moved to row 7, column 7 (64)
Row 0, column 0 (57) moved to row 0, column 7 (8)
- offset=1
Row 6, column 0 (49) moved to row 0, column 1 (2)
Row 7, column 6 (63) moved to row 6, column 0 (49)
Row 1, column 7 (16) moved to row 7, column 6 (63)
Row 0, column 1 (49) moved to row 1, column 7 (16)
- offset=2
Row 5, column 0 (41) moved to row 0, column 2 (3)
Row 7, column 5 (62) moved to row 5, column 0 (41)
Row 2, column 7 (24) moved to row 7, column 5 (62)
Row 0, column 2 (41) moved to row 2, column 7 (24)
- offset=3
Row 4, column 0 (33) moved to row 0, column 3 (4)
Row 7, column 4 (61) moved to row 4, column 0 (33)
Row 3, column 7 (32) moved to row 7, column 4 (61)
Row 0, column 3 (33) moved to row 3, column 7 (32)
- offset=4
Row 3, column 0 (25) moved to row 0, column 4 (5)
Row 7, column 3 (60) moved to row 3, column 0 (25)
Row 4, column 7 (40) moved to row 7, column 3 (60)
Row 0, column 4 (25) moved to row 4, column 7 (40)
- offset=5
Row 2, column 0 (17) moved to row 0, column 5 (6)
Row 7, column 2 (59) moved to row 2, column 0 (17)
Row 5, column 7 (48) moved to row 7, column 2 (59)
Row 0, column 5 (17) moved to row 5, column 7 (48)
- offset=6
Row 1, column 0 (9) moved to row 0, column 6 (7)
Row 7, column 1 (58) moved to row 1, column 0 (9)
Row 6, column 7 (56) moved to row 7, column 1 (58)
Row 0, column 6 (9) moved to row 6, column 7 (56)
Working on square layer #1
- offset=0
Row 6, column 1 (50) moved to row 1, column 1 (10)
Row 6, column 6 (55) moved to row 6, column 1 (50)
Row 1, column 6 (15) moved to row 6, column 6 (55)
Row 1, column 1 (50) moved to row 1, column 6 (15)
- offset=1
Row 5, column 1 (42) moved to row 1, column 2 (11)
Row 6, column 5 (54) moved to row 5, column 1 (42)
Row 2, column 6 (23) moved to row 6, column 5 (54)
Row 1, column 2 (42) moved to row 2, column 6 (23)
- offset=2
Row 4, column 1 (34) moved to row 1, column 3 (12)
Row 6, column 4 (53) moved to row 4, column 1 (34)
Row 3, column 6 (31) moved to row 6, column 4 (53)
Row 1, column 3 (34) moved to row 3, column 6 (31)
- offset=3
Row 3, column 1 (26) moved to row 1, column 4 (13)
Row 6, column 3 (52) moved to row 3, column 1 (26)
Row 4, column 6 (39) moved to row 6, column 3 (52)
Row 1, column 4 (26) moved to row 4, column 6 (39)
- offset=4
Row 2, column 1 (18) moved to row 1, column 5 (14)
Row 6, column 2 (51) moved to row 2, column 1 (18)
Row 5, column 6 (47) moved to row 6, column 2 (51)
Row 1, column 5 (18) moved to row 5, column 6 (47)
Working on square layer #2
- offset=0
Row 5, column 2 (43) moved to row 2, column 2 (19)
Row 5, column 5 (46) moved to row 5, column 2 (43)
Row 2, column 5 (22) moved to row 5, column 5 (46)
Row 2, column 2 (43) moved to row 2, column 5 (22)
- offset=1
Row 4, column 2 (35) moved to row 2, column 3 (20)
Row 5, column 4 (45) moved to row 4, column 2 (35)
Row 3, column 5 (30) moved to row 5, column 4 (45)
Row 2, column 3 (35) moved to row 3, column 5 (30)
- offset=2
Row 3, column 2 (27) moved to row 2, column 4 (21)
Row 5, column 3 (44) moved to row 3, column 2 (27)
Row 4, column 5 (38) moved to row 5, column 3 (44)
Row 2, column 4 (27) moved to row 4, column 5 (38)
Working on square layer #3
- offset=0
Row 4, column 3 (36) moved to row 3, column 3 (28)
Row 4, column 4 (37) moved to row 4, column 3 (36)
Row 3, column 4 (29) moved to row 4, column 4 (37)
Row 3, column 3 (36) moved to row 3, column 4 (29)

Here is the matrix:
57 49 41 33 25 17  9  1 
58 50 42 34 26 18 10  2 
59 51 43 35 27 19 11  3 
60 52 44 36 28 20 12  4 
61 53 45 37 29 21 13  5 
62 54 46 38 30 22 14  6 
63 55 47 39 31 23 15  7 
64 56 48 40 32 24 16  8 
```