#lang slideshow
(provide mondrian)

(define(save-pict picture filename) (send (pict->bitmap picture) save-file filename 'png)
 (test5) (mondrian 100 90 '(
0 ; 100x90 - split? Both
0.8 ; split width => w1 = 60, w2 = 40   
0.6 ; split height => h1 = 48, h2 = 42
1 ; 60x48 - split? w/width = .6, h < 50 => Vertical
0.5 ; split w1 = 30, w2 = 30
1 ; 30x48 - split? w, h < 50 => No
0.08 ; red 
1 ; 30x48 - split? w, h < 50 => No
0.3 ; white
1 ; 40x48 - split? w, h < 50 => No
0.1 ; blue
1 ; 60x42 - split? w/width = .6, h < 50 => Vertical
0.3 ; split w1 = 26, w2 = 34
1 ; 26x42 - split? w, h < 50 => No
0.3 ; white
1 ; 34x42 - split? w, h < 50 => No
0.2 ; yellow
1 ; 40x42 - split? w, h < 50 => No
0.3 ; white
0.5 ; first unconsumed value
)))

