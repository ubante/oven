# Introduction

I need some stuff to help plan Drobo expansions.

The main thing is something that will backup the Drobo to two different external drives.  Currently, I barely fit in
an 8TB drive.  That drive replaced my two 5TB drive solution.  I put one of the 5TB drives in the Drobo so now have
the 8TB and other 5TB drives to split the Drobo.

This program should accept a list of directories to keep together.  The program should check that directory set
will fit on the largest drive.  If not, then error.  Else, make sure that the external drives are sufficient.  If not,
error.  Else, copy the directory set to the larger drive.  Then fit the rest of the Drobo across the remaining drives.