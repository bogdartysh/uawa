FROM jupyter/minimal-notebook

LABEL maintainer = "Bogdan Artyushenko <bogdan.artyushenko+uawa@gmail.com>"
ARG NB_USER=jovyan


ENV NOTEBOOK_PATH $HOME/notebooks
ENV PORT 8888
ENV LEIN_ROOT 1
ENV CLOJUPYTER_PATH $HOME/clojupyter-$CLOJUPYTER_VERSION

USER root
RUN     apt-get update
RUN     apt-get install -y curl openjdk-8-jre 


RUN     curl -o /usr/local/bin/lein https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein \
 	&& chmod +x /usr/local/bin/lein \
 	&& lein self-install

USER $NB_USER
RUN	mkdir -p $NOTEBOOK_PATH \
	&& git clone https://github.com/clojupyter/clojupyter $CLOJUPYTER_PATH

WORKDIR $CLOJUPYTER_PATH
RUN git checkout $CLOJUPYTER_VERSION 
RUN make install

WORKDIR $NOTEBOOK_PATH
EXPOSE $PORT
VOLUME $NOTEBOOK_PATH

ADD uawa.jar $HOME/.m2/repository/uawa/uawa.jar
ADD main-uawa.clj $NOTEBOOK_PATH


EXPOSE 8888



WORKDIR $NOTEBOOK_PATH
CMD ["jupyter", "notebook", "--log-level=ERROR"]

