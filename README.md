# 프로젝트 기동 

아래와 같이 시동한다.

```
npx shadow-cljs watch app
```

실행시키면 다음과 같은 결과를 볼 수 있다.

```
shadow-cljs - HTTP server available at http://localhost:8084
shadow-cljs - server version: 2.28.21 running at http://localhost:9630
shadow-cljs - nREPL server started on port 51821
shadow-cljs - watching build :app
[:app] Configuring build.
[:app] Compiling ...
[:app] Build completed. (137 files, 136 compiled, 0 warnings, 6.46s)
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
```

위에서 첫번째 줄은 frontend 를 확인할 수 있는 URL이다.


# backend 기동

가장 간단한 방법은 emacs에서 `src/main/backend/core.clj` 파일을 열고 `M-x cider-connect-clj` 를 하는 것이다. 
이후 생성된 clojure 용 repl 에서 

```
(in-ns 'backend.core)

(start-server)
```

를 하면 서버가 기동된다.

