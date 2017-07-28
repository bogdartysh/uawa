(ns uawa.core);; (use 'uawa.core);; макроси(defmacro визначення "див. def" [символ документація значення] `(def ~символ ~документація ~значення))(defmacro змінна "див. def" [символ значення] `(def ~символ ~значення))(defmacro постійна "див. defonce" [назва значення] `(let [v# (def ~назва)](when-not (.hasRoot v#) (def ~назва ~значення))))(defmacro тип "див deftype" [назва поля  & опції] `(deftype ~назва ~поля  ~@опції))(defmacro метод [назва тип & решта] `(defmethod ~назва ~тип ~@решта))(defmacro функція "див. defn" [назви & описи] (list* `defn (with-meta назви (assoc (meta назви) :private false)) описи))(defmacro запис "див. defrecord" [name fields & opt] `(defrecord ~name ~fields ~@opt));; ( defmacro хай "див let" [звязування тіло] `(let ~звязування ~тіло)) (defmacro якщо "див. if"([умова то] `(if ~умова ~то nil)) ([умова то інакше] `(if ~умова ~то ~інакше)))(defmacro для "див. for" [set-expr body-expr] `(for ~set-expr body-expr))(функція зменш "див. reduce" ([функція колекція] (reduce функція колекція) ) ([функція початкове колекція] (reduce функція початкове колекція) ));; умови (постійна істина true)(постійна фальш false) (функція не "not" [x] (not x))(функція непарне? [n] (even? n))(функція парне? [n] (не (непарне? n)))(функція та? "and" ([x y] (and x y)) ([x y & більше] (зменш та? (та? x y) більше)))(функція кожен? "див. every?" ([умова колекція] (every? умова колекція)))(функція або? "or" ([x y] (or x y)) ([x y & більше] (зменш або? (або? x y) більше)));; колекції(функція пусто? "див. empty" [колекція] (empty? колекція))(функція відфільтруй-різні "див. distinct" [колекція] (distinct колекція))(функція розмір "див count" [колекція] (count колекція))(функція фільтруй ([pred] (filter pred)) ([pred coll] (filter pred coll)))(функція відобрази "див. map" ([функція] (map функція)) ([функція список] (map функція список)))(defmacro .отримай "див. .get" [обєкт назва-поля] `(.get ~обєкт ~назва-поля))(функція перший "див. first" [колекція] (first колекція))(функція містить? [колекція елемент] (та? (some #(= елемент %) колекція) істина))(функція вибери-ключі "див. select-keys" [колекція ключі] (select-keys колекція ключі))(функція сортуй-за "див. sort-by" ([функція-рядків колекція] (sort-by функція-рядків колекція))  ([функція-рядків компаратор колекція] (sort-by функція-рядків компаратор колекція)));; системні(функція вихід ([] (вихід 0)) ([статус] (System/exit статус)))(defn використай [& args] (use args))(функція застосуй "див. apply" [f args] (apply f args));; (функція застосуй "див. apply" [f x args] (apply f x args));; (функція застосуй "див. apply" [f x y args] (apply f x y args));; (функція застосуй "див. apply" [f x y z args] (apply f x y z args));; (функція застосуй "див. apply" [f a b c d &args] (apply f a b c d &args))(функція потребуй "див. require" [& args] (застосуй require args))(defmacro спробуй ([вираз винятоковий-вираз] `(try ~вираз ~винятоковий-вираз )) ([вираз винятоковий-вираз остаточний-вираз] `(try ~вираз ~винятоковий-вираз ~остаточний-вираз )) );; різні(функція дай-випадкове "див. rand-int" [максимальне] (rand-int максимальне))(функція друкуй "див. println" [& більше]  (binding [*print-readably* nil] (apply prn більше)))(use 'clojure.pprint)(функція друкуй-таблицю "див. print-table" ([текст]  (print-table текст)) ([заголовок текст]  (print-table заголовок текст)));; UA(запис Ціна [кількість валюта] )(постійна ₴ (java.util.Currency/getInstance "UAH"))(постійна $ (java.util.Currency/getInstance "USD"))(постійна € (java.util.Currency/getInstance "EUR"))(постійна грн ₴)(defmacro ціна "ціна у валюті" [назва кількість валюта] `(постійна ~назва (Ціна. ~кількість  ~валюта)))(метод print-method Ціна [x ^java.io.Writer w] (.write w (str (:кількість x) " " (:валюта x))))(функція домнож  [x ^clojure.lang.Numbers y] (Ціна. (* (:кількість x) y) (:валюта x)))