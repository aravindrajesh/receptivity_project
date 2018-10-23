The number of trips starting at A and ending at C with exactly 4 stops.
In the sample data below, there are three such trips: A to C (via B,C,D); A
to C (via D,C,D); and A to C (via D,E,B).

This is given in the problem statement
I have designed such that we get answer as 1 trip . Logically once we reach a destination we dont 
want to travel back and forth to read the number of stops.
For example:
A to C (via B,C,D) - the travel is A->B , B->C , C->D , D->C
in practical we can ingore once we reach from A->B , B->C. so the stops in this case is only 2.
For the above question following this method we get only 1 trip with exactly 4 stops.

The same logic is followed and acheived 3 trips for-The number of different routes from C to C with a distance of less than
30.
