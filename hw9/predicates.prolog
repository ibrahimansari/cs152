last(X, [X|[]]).
last(X, [_|T]) :- last(X,T).

notlast([] , [_|[]]).
notlast([H|T1], [H|T2]) :- notlast(T1, T2).

subseq([], L).
subseq([H|T1], [H|T2]) :- subseq(T1, T2).
subseq(X, [_|T]) :- subseq(X, T).

sublist([], _).
sublist([X|T1], [X|T2]) :- sublist(T1, T2).
sublist([X|T1], [_|T2]) :- sublist([X|T1], T2).

without([], _, []).
without([H|T], S,[H|T2]) :- without(T, S, T2). 
without([H|T], H, T) :- without(T, H, [H1|T1]).

permutation([], []).
permutation([T|H], X) :- permutation(H, H1), append(L1, L2, H1), append(L1, [T], X1), append(X1, L2, X).

split([], [], []).
split([H|T], [H|L1], L2) :- split(T, L2, L1).