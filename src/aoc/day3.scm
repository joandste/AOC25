(define input (read-port-to-string (open-input-file "input")))

(define parsed-input (map string->list (split-many input "\n")))

(define (concat-integers a b)
  (string->int (string-append (int->string a)
			      (int->string b))))

(define (get-battery coll acc)
  (if (empty? (cdr coll)) acc
    (let ((check (concat-integers (car coll)
				  (apply max (cdr coll)))))
      (get-battery (cdr coll)
		   (if (< acc check) check acc)))))



(displayln (reduce + 0 (map (λ (coll) (get-battery (map char->number coll) 0)) parsed-input)))
