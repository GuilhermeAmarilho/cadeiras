#lang racket/gui

;Funções
(define (raiz1 a b c)
   (/ (- (sqrt (- (expt b 2) (* a(* c 4)))) b) (* a 2)))

(define (raiz2 a b c)
    (/ (- (+ (sqrt (- (expt b 2) (* a(* c 4)))) b)) (* a 2)))
    
(define (eixox a b)
     (/(* -1 b) (* 2 a)))

(define (eixoy a b c)
     (/(* -1 (- (expt b 2) (* a(* c 4)))) (* 4 a)))

(require db)
(define pgc
  (postgresql-connect
   #:user "postgres"
   #:database "projeto3"
   #:server "localhost"
   #:password "admin"
   )
 )

(require 2htdp/batch-io) 
(define frame (new frame% [label "Cálculo de bhaskara"][height 200][width 100]))

(new message% [parent frame][label "Ultimos valores inseridos"])
(define ha (new text-field% [label "A: "] [parent frame] [vert-margin 10] [horiz-margin 200]))
(define hb (new text-field% [label "B: "] [parent frame] [vert-margin 10] [horiz-margin 200]))
(define hc (new text-field% [label "C: "] [parent frame] [vert-margin 10] [horiz-margin 200]))

(define hav (query-value pgc "select v.a from valores as v order by id DESC LIMIT 1"))
(define hbv (query-value pgc "select v.b from valores as v order by id DESC LIMIT 1"))
(define hcv (query-value pgc "select v.c from valores as v order by id DESC LIMIT 1"))

(send ha set-value (number->string hav))
(send hb set-value (number->string hbv))
(send hc set-value (number->string hcv))


(new message% [parent frame][label "Calcule uma nova baskara"])
(new message% [parent frame][label "Bhaskara"])
(define a (new text-field% [label "Coeficiente A"] [parent frame] [vert-margin 10] [horiz-margin 200] ))
(define b (new text-field% [label "Coeficiente B"] [parent frame] [vert-margin 10] [horiz-margin 200]))
(define c (new text-field% [label "Coeficiente C"] [parent frame] [vert-margin 10] [horiz-margin 200]))
(define calc (new button% [parent frame]
             [label "Calcular"]
             ; Retorno do button
             [callback (lambda (button event)
                         ;Apaga o button
                         (send calc show #f)
                         ;Escreve no arquivo
                         (write-file "bhaskara.txt"
                         (~a "\nA "  (string->number (send a get-value))
                         "\nB "      (string->number (send b get-value))
                         "\nC "      (string->number (send c get-value))
                         "\neixo X " (eixox (string->number (send a get-value)) (string->number (send b get-value)))
                         "\neixo Y " (eixoy (string->number (send a get-value)) (string->number (send b get-value)) (string->number (send c get-value)))
                         "\nX1 "     (raiz1 (string->number (send a get-value)) (string->number (send b get-value)) (string->number (send c get-value)))
                         "\nX2 "     (raiz2 (string->number (send a get-value)) (string->number (send b get-value)) (string->number (send c get-value)))))
                         ;insere no banco
                         (query-exec pgc "insert into valores (a,b,c,x,y) values ($1, $2, $3, $4, $5)" (string->number (send a get-value)) (string->number (send b get-value)) (string->number (send c get-value)) (eixox (string->number (send a get-value)) (string->number (send b get-value))) (eixoy (string->number (send a get-value)) (string->number (send b get-value)) (string->number (send c get-value))))
                         ;Cria um label para a variavel
                         (define msg (new message% [parent frame][label "Cálculo realizado!"]))
                         (define Xv (new text-field% [label "X vértice: "]      [init-value ""] [parent frame] [vert-margin 10] [horiz-margin 200]))
                         (define Yv (new text-field% [label "Y vértice: "]      [init-value ""] [parent frame] [vert-margin 10] [horiz-margin 200]))
                         (define vx1 (new text-field% [label "X1:            "] [init-value ""] [parent frame] [vert-margin 10] [horiz-margin 200]))
                         (define vx2 (new text-field% [label "X2:            "] [init-value ""] [parent frame] [vert-margin 10] [horiz-margin 200]))
                         ;Define o valor da variavel
                         (send Xv set-value (number->string (eixox(string->number (send a get-value)) (string->number (send b get-value)))))
                         
                         (send Yv set-value (number->string (eixoy(string->number (send a get-value)) (string->number (send b get-value))(string->number (send c get-value)))))
                         
                         (send vx1 set-value (number->string (raiz1(string->number (send a get-value)) (string->number (send b get-value))(string->number (send c get-value)))))
                         (send vx2 set-value (number->string (raiz2(string->number (send a get-value)) (string->number (send b get-value))(string->number (send c get-value)))))
                         ; Botão fechar
                         (new button% [parent frame]
                              [label "Fechar"]
                              [callback (lambda (button event)
                                          (send frame show #f)                   
                              )])
                        )]))

(send frame show #t)

