(define (mysqrt x)
  (define (square x) (* x x))
  (define (average x y) (/ (+ x y) 2))
  (define (good-enough? guess x)
    (< (abs (- (square guess) x)) 0.001))
  (define (improve guess x)
    (average guess (/ x guess)))
  (define (sqrt-iter guess x)
    (if (good-enough? guess x)
        guess
        (sqrt-iter (improve guess x) x)))
  (sqrt-iter 1.0 x))

; exercise 1.8
(define (cubic-root x)
  (define (good-enough? guess x)
    (< (abs (- (* guess guess guess) x)) 0.001))
  (define (improve guess x)
    (/ (+ (/ x (* guess guess)) guess guess) 3)
  )
  (define (cubert-iter guess x)
    (if (good-enough? guess x)
        guess
        (cubert-iter (improve guess x) x)))
  (cubert-iter 1.0 x))

(cubic-root 3)