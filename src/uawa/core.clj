(ns uawa.core)(def істина true)(def фальш false)(defn дай-антонім "not" [x] (not x))(defmacro вираз "same as defn" [назви & описи] (list* `defn (with-meta назви (assoc (meta назви) :private false)) описи))(defmacro стала "defonce" [назва значення] `(let [v# (def ~назва)](when-not (.hasRoot v#) (def ~назва ~значення))))(def дай-випадкове "rand" ([] (rand) ([n] (rand n))(defmacro вираз "same as defn" [назви & описи] (list* `defn (with-meta назви (assoc (meta назви) :private false)) описи))(defmacro стала "defonce" [назва значення] `(let [v# (def ~назва)](when-not (.hasRoot v#) (def ~назва ~значення))))(def дай-випадкове "rand" ([] (rand) ([n] (rand n))))