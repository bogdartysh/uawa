(ns uawa.jdbc)
(use 'uawa.core)
(потребуй '[clojure.java.jdbc :as j])
(функція запитай [джерело sql-запит] (j/query джерело sql-запит))
(функція виконай [джерело sql-запит] (j/execute! джерело sql-запит))

;; Приклад
;; (постійна БД {:classname "oracle.jdbc.OracleDriver"  ; має бути у доступним
;;           :subprotocol "oracle"
;;           :subname "thin:@host:1521/schema" 
;;           :user "login"
;;           :password "password"})
;;(запитай БД "  select 1 +1 as sum     from dual")