#lang racket

(define (invertCycle cycle)
  (flatten (foldr (λ (new partial) (append (list partial) (list new))) (list (list-ref cycle 0)) cycle))
  )

(define (invert permutation)
  (map (λ (x) (invertCycle x)) permutation)
  )
        
