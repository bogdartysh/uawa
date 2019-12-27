FROM clojure:lein-2.7.1-alpine

ADD gorilla /app/
ADD ПочатковийКод /app/

EXPOSE 9090


WORKDIR /app


ENTRYPOINT ["/app/docker-entrypoint-gorilla.sh"]
