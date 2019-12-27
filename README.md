# Мова uawa
Функціональна мова програмування на базі української лексики.
# Переваги
1. спрощення підтримки розробленого продукту за рахунок легшого розуміння програмного коду
2. швидше навчання неангломовних програмістів
3. зменшення ризиків через легкість верифікації алгоритму работи
4. більшість Java бібліотек легко використовуються бо мова написана на базі JVM (clojure). 
# Приклади коду
```
(use 'uawa.core)

(ціна ціна-груші 100 грн)
(функція розрахуй-вартість [ціна-за-єдиницю кількість] (домнож ціна-за-єдиницю кількість))
(друкуй (розрахуй-вартість ціна-груші 10))
```

# Перші кроки
## docker
```
docker build -t uawa-gorilla .
docker run -p 9090:9090 -d uawa-gorilla
```
потім відкрийте адресу http://127.0.0.1:9090/worksheet.html?filename=uawa і прораньте степи (ctrl+enter)


## інші відомі авторам проекти мов програмування на базі української
1. АЛГО — український паскаль https://studopedia.org/2-108787.html
2. Навчальна алгоритмічна мова - https://uk.wikipedia.org/wiki/%D0%9D%D0%B0%D0%B2%D1%87%D0%B0%D0%BB%D1%8C%D0%BD%D0%B0_%D0%B0%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC%D1%96%D1%87%D0%BD%D0%B0_%D0%BC%D0%BE%D0%B2%D0%B0
