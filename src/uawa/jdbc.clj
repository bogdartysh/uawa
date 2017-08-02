(ns uawa.jdbc)
(use 'uawa.core)
(потребуй '[clojure.java.jdbc :as j])
(змінна БД)
(функція запитай ([sql-запит] (запитай БД sql-запит)) ([джерело sql-запит] (j/query джерело sql-запит)))
(функція виконай ([sql-запит] (виконай БД sql-запит)) ([джерело sql-запит] (j/execute! джерело sql-запит)))

(defmacro збережи-запит "збережи результати запиту до БД" [назва запит] `(постійна ~назва (запитай БД ~запит)))

;; Приклад
;; (постійна БД {:classname "oracle.jdbc.OracleDriver"  ; має бути у доступним
;;           :subprotocol "oracle"
;;           :subname "thin:@host:1521/schema" 
;;           :user "login"
;;           :password "password"})
;;(запитай БД "  select 1 +1 as sum     from dual")