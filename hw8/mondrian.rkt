#lang slideshow
(provide mondrian)

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

(define (notempty l) (> (length l) 1))

(define (mondrian width height rands)
  (letrec (
           (wide-enough (λ (w h rands) (and (> w 50) (> (/ w width) (* 0.5 rands)))))
           (tall-enough (λ (w h rands) (and (> h 50) (> (/ h height) (* 0.5 rands)))))
           (big-enough (λ (w h rands) (and (wide-enough w h (first rands)) (tall-enough w h (first (rest rands))))))
           (not-enough (λ (w h) (and (< h 50) (< w 50))))
           (split-wide (λ (w h rands)
                         (let* (
                                [w1 (* w (first rands))]
                                [w2 (- w w1)]
                                )
                         (hc-append (mondrian-helper w1 h (rest rands))
                           (mondrian-helper w2 h (rest(rest rands)))))))
           (split-tall (lambda(w h rands)
                         (let* (
                                [h1 (* h (first rands))]
                                [h2 (- h h1)]
                                )
                         (vc-append (mondrian-helper w h1 (rest rands))
                           (mondrian-helper w h2 (rest(rest rands)))))))
           (split-both (λ (w h rands)
                         (let* (
                                [w1 (* w (first rands))]
                                [w2 (- w w1)]
                                [h1 (* h (second rands))]
                                [h2 (- h h1)]
                                )
                        (vc-append
                         (hc-append (mondrian-helper w1 h1 (rest(rest rands)))
                           (mondrian-helper w2 h1 (rest(rest(rest rands)))))
                         (hc-append (mondrian-helper w1 h2 (rest(rest(rest rands))))
                           (mondrian-helper w2 h2 (rest(rest(rest(rest(rest rands)))))))))))
           (colorizer (λ (w h rands)
                        (cond
                          [(< (first rands) .0833) (cc-superimpose (colorize (filled-rectangle w h) "red") (rectangle w h))]
                          [(and (> (first rands) .0833) (< (first rands) .1667)) (cc-superimpose (colorize (filled-rectangle w h) "blue") (rectangle w h))]
                          [(and(> (first rands) .1667) (< (first rands) .25)) (cc-superimpose (colorize (filled-rectangle w h) "yellow") (rectangle w h))]
                          [(and(> (first rands) .1667) (< (first rands) .25)) (cc-superimpose (colorize (filled-rectangle w h) "yellow") (rectangle w h))]
                          [else (cc-superimpose (colorize (filled-rectangle w h) "white") (rectangle w h))])))
           (mondrian-helper (λ (w h rands)
                              (cond
                                [(and (big-enough w h rands) (notempty rands)) (split-both w h rands)]
                                [(and (wide-enough w h (first(rest rands))) (notempty (rest rands)))(split-wide w h rands)]
                                [(and (tall-enough w h (first(rest(rest rands)))) (notempty(rest(rest rands)))) (split-tall w h rands)]
                                [else (colorizer w h (rest (rest (rest rands))))]
                                ))))
    (mondrian-helper width height rands)))