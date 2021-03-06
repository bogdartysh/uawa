(ns app.core)
(use 'uawa.core)

(require '[clj-http.client :as client])
(require '[clojure.data.json :as json])

(функція друкуй-запити-за-ярликом
  "друкує запити з ярликом"
  [логін пароль хост ярлик]  
  (друкуй "шукаю завдання з ярликом "  ярлик " з хоста " хост)  
  (хай [лінка (str "https://" хост "/rest/api/2/search?jql=labels%3D" ярлик "")]
   (хай [запити  (-> (client/get лінка {:basic-auth (str логін ":" пароль)}) :body json/read-str (.отримай "issues")) ]
     (якщо (пусто? запити) (друкуй "-- не знайдено") (друкуй (відобрази #(.отримай %1 "key") запити)))
    )
  )
)

(функція -main [логін пароль хост ярлик]
  (друкуй логін)
  (друкуй-запити-за-ярликом логін пароль хост ярлик)
)
