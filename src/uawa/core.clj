(ns uawa.core);; (use 'uawa.core);; макроси(defmacro постійна "див. defonce" [назва значення] `(let [v# (def ~назва)](when-not (.hasRoot v#) (def ~назва ~значення))))(defmacro функція "див. defn" [назви & описи] (list* `defn (with-meta назви (assoc (meta назви) :private false)) описи))(defmacro якщо "див. if"([умова то] `(if ~умова ~то nil)) ([умова то інакше] `(if ~умова ~то ~інакше)))(defmacro для "див. for" [set-expr body-expr] `(for ~set-expr body-expr))(defmacro запис "див. defrecord" [name fields & opt] `(defrecord ~name ~fields ~@opt));; умови (постійна істина true)(постійна фальш false) (функція ні? "not" [x] (not x))(функція та? "and" ([x y] (and x y)) ([x y & більше] (reduce та? (та? x y) більше)))(функція кожен? "див. every?" ([умова колекція] (every? умова колекція)))(функція або? "or" ([x y] (or x y)) ([x y & більше] (reduce або? (або? x y) більше)));; системні(функція вихід ([] (вихід 0)) ([статус] (System/exit статус)))(defn використай [& args] (use args));; колекції(функція пуста? "див. empty" [колекція] (empty колекція))(функція відфільтруй-різні "див. distinct" [колекція] (distinct колекція))(функція розмір "див count" [колекція] (count колекція))(функція фільтруй [pred] (filter pred))(функція фільтруй [pred coll] (filter pred coll))(функція перетвори "див. map" [функція] (map функція))(функція перетвори "див. map" [функція список] (map функція список))(функція перетвори "див. map" [функція с1 с2] (map функція с1 с2))(функція перетвори "див. map" [функція с1 с2 с3] (map функція с1 с2 с3))(функція перетвори "див. map" [функція с1 с2 с3 &список] (map функція с1 с2 с3 &список))(функція зменш "див. reduce" [функція колекція] (reduce функція колекція))(функція зменш "див. reduce" [функція значення колекція] (reduce функція значення колекція));; різні(функція дай-випадкове "див. rand-int" [максимальне] (rand-int максимальне))(функція друкуй "див. println" [& більше]  (binding [*print-readably* nil] (apply prn більше)))(функція менше?  ([x] true) ([x y] (. clojure.lang.Numbers (lt x y))) ([x y & more]   (if (< x y)     (if (next more)       (recur y (first more) (next more))       (< y (first more))) false)));; (якщо (менше? (дай-випадкове 3) 4) (друкуй "українська") (друкуй "ураиский русский"))