move(X,Y) :- Y is X - 1, X > Y, X =< 2 * Y.
win(X) :- X=:=2.
win(X) :- move(X,Y), not(win(Y)).