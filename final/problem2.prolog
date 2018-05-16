reverse([],Z,Z).
reverse([H|T],Z,A) :- reverse(T,Z,[H|A]).
inverseCycle([X]).
inverseCycle([H|T]) :- reverse([T], X, []).
                     
