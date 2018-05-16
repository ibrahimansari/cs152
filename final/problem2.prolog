reverse([],Z,Z).
reverse([H|T],Z,A) :- reverse(T,Z,[H|A]).
inverseCycle([H|T], X) :- reverse(T, X, []).
                     
