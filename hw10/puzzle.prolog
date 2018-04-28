flipped(Click, Columns, [Left, Click, Right]) :- Click > 1, Click < Columns, Left is Click - 1, Right is Click + 1.
flipped(Click, Columns, [Left, Click]) :- Click > 1, Click = Columns, Left is Click - 1.
flipped(Click, Columns, [Click, Right]) :- Click = 1, Click < Columns, Right is Click + 1.
flipped(Click, Columns, [Click]) :- Columns = 1.

doFlips([], Red, Columns, Red). 
doFlips([H|T], Red, Columns, Result) :- flipped(H, Columns, X), ord_symdiff(X, Red, Y), doFlips(T, Y, Columns, Result).

allFlips(Flips, Row, Rows, Columns, [Flips | MoreFlips]) :-
    Rows > 0,
    doFlips(Flips, Row, Columns, Result),
    numlist(1, Columns, All),
    ord_symdiff(Result, All, Y),
    Rows1 is Rows - 1,
    allFlips(Y, Flips, Rows1, Columns, MoreFlips).
allFlips([], _, 0, _, []).

sublist([], _).
sublist([X|T1], [X|T2]) :- sublist(T1, T2).
sublist([X|T1], [_|T2]) :- sublist([X|T1], T2).

solution(Rows, Columns, Solution) :- numlist(1, Columns, L), sublist(Solution, L), allFlips(Solution, [], Rows, Columns, _).