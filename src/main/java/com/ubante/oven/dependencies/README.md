# Introduction

I want to have things depend on other things.

# Approach 1
Use a list of things as a field.

_For fun_: http://cslibrary.stanford.edu/110/BinaryTrees.html

ThingRunner produces:
```
              Name: benny
Up:  alice                    Down:  carter cathey

              Name: alice
Up:                           Down:  benny

              Name: carter
Up:  benny                    Down:

              Name: cathey
Up:  benny                    Down:

-----------------------------------
              Name: a
Up:                           Down:

              Name: a
Up:  a1                       Down:

              Name: b
Up:  b1                       Down:  b2

              Name: b1
Up:                           Down:  b

              Name: b
Up:  b1 b1a                   Down:  b2
```

