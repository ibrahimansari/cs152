#lang slideshow

(define (draw w h)
  (cc-superimpose (colorize (filled-rectangle w h) "blue") (rectangle w h))
  )

(define (draw1 w h)
  (cc-superimpose (rectangle w h))
  )


(define a 1664525)
(define b 1013904223)
(define m 4294967296)

(define (next x)
  (modulo (+ (* a x) b) m)
  )

(define (divm n)
  (/ n m)
  )

(define (randoms s l)
  (if (= l 0) 
    empty
    (cons (divm s) (randoms (next s) (- l 1)))))

(define (mult x y) (* x y))
(define (sub x y) (- x y))

(define (mondrian width height rands)
  (letrec (
           [drawing (rectangle width height)]
           [results (list drawing rands)]
           (wide-enough (lambda (w r) (and (> w 50) (> (/ w width) (* 0.5 r)))))
           (tall-enough (lambda (h r) (and (> h 50) (> (/ h height) (* 0.5 r)))))
           (big-enough (lambda (w h r) (and (wide-enough w r) (tall-enough h r))))
           (split-wide (lambda(w h rands draw)
                         (let* (
                                [w1 (* w (first rands))]
                                [h1 h]
                                [draw1 (rectangle w1 h1)]
                                [draw2 (rectangle (- w w1) h1)]
                                [drawAll (cc-superimpose (hc-append draw1 draw2) draw)]
                                )
                           (display 1)
                         (mondrian-helper w1 h1 (rest rands) drawAll)
                           (mondrian-helper (- w w1) h1 (rest(rest rands)) drawAll)
                         )))
           (split-tall (lambda(w h rands draw)
                         (let* (
                                [h1 (* h (first rands))]
                                [w1 w]
                                [draw1 (rectangle w1 h1)]
                                [draw2 (rectangle w1 (- h h1))]
                                [drawAll (cc-superimpose (vc-append draw1 draw2) draw)]
                                )
                           (display 2)
                           (mondrian-helper w1 h1 (rest rands) drawAll)
                           (mondrian-helper w1 (- h h1) (rest(rest rands)) drawAll)
                         )))
           (split-big (lambda(w h rands draw)
                         (let* (
                                [h1 (* h (first rands))]
                                [w1 (* w (first (rest rands)))]
                                [draw1 (rectangle w1 h1)]
                                [draw2 (rectangle w1 (- h h1))]
                                [draw3 (rectangle (- w w1) h1)]
                                [draw4 (rectangle (- w w1) (- h h1))]
                                [drawAll (cc-superimpose (hc-append (vc-append draw1 draw2)
                                                                   (vc-append draw3 draw4)
                                                                   ) draw)]
                                )
                           (display 0)
                           (mondrian-helper w1 h1 (rest rands) drawAll)
                           (mondrian-helper w1 (- h h1) (rest(rest rands)) drawAll)
                           (mondrian-helper (- w w1) h1 (rest(rest(rest rands))) drawAll)
                           (mondrian-helper (- w w1) (- h h1) (rest(rest(rest rands))) drawAll)
                         )))
           (mondrian-helper (lambda (w h rands draw)
                              (if (< (length rands) 4)
                                  draw
                                  (if(big-enough w h (first rands))
                                     (split-big w h rands draw)
                                     (if(wide-enough w (first rands))
                                        (split-wide w h rands draw)
                                        (if(tall-enough h (first rands))
                                           (split-tall w h rands draw)
                                           (mondrian-helper w h (rest rands) draw)
                                           )
                                        )
                                     )
                                  )
                              )))
    (mondrian-helper width height rands drawing)
    ))