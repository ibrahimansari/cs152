(define (invertCycle cycle)
  (foldl (λ (newElement partialResult) (+ newElement (* 10 partialResult))) 0 cycle)
  )

(define (invert permutation)
  (map (λ (x) (invertCycle x)) permutation)
  )
        
