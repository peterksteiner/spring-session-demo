### About
This project was an experiment to find out how to use
[Spring Session](http://docs.spring.io/spring-session/docs/current/reference/html5/guides/httpsession.html)
with Spring MVC 3 and annotation driven configuration. This project is very similar to the demo app
[HttpSession with Redis](http://docs.spring.io/spring-session/docs/1.0.1.BUILD-SNAPSHOT/reference/html5/#httpsession-redis)
with header authentication.
See [HttpSession & RESTful APIs](http://docs.spring.io/spring-session/docs/1.0.1.BUILD-SNAPSHOT/reference/html5/#httpsession-rest)

### What does it do?
The domain model is a simple POJO with one attribute, for lack of a better example, is called a token.
A Controller allows one to create a token with a POST and to read back the token with a GET provided you
include the 'x-auth-token' header. The magic of Spring Session is the session is backed by Redis so
when we store the token POJO in the session, it really goes into Redis.

### How to build

    $ mvn org.apache.tomcat.maven:tomcat7-maven-plugin:run

### How to create a token

    curl -i  -X POST http://127.0.0.1:8080/spring-session-demo/token
    HTTP/1.1 201 Created
    Server: Apache-Coyote/1.1
    x-auth-token: 1a6700f0-61eb-4ea7-bc18-2275215e8184
    Content-Type: application/json;charset=UTF-8
    Transfer-Encoding: chunked
    Date: Thu, 26 Feb 2015 02:29:09 GMT

    {"tokenId":"10017"}

### How to get a token

    $ curl -i -X GET -H 'x-auth-token: 1a6700f0-61eb-4ea7-bc18-2275215e8184' http://127.0.0.1:8080/spring-session-demo/token
    HTTP/1.1 200 OK
    Server: Apache-Coyote/1.1
    Content-Type: application/json;charset=UTF-8
    Transfer-Encoding: chunked
    Date: Thu, 26 Feb 2015 02:30:46 GMT

    {"tokenId":"10017"}

### What happens if you don't supply the x-auth-token header?

    $ curl -i -X GET http://127.0.0.1:8080/spring-session-demo/token
    HTTP/1.1 404 Not Found
    Server: Apache-Coyote/1.1
    x-auth-token: baed75a7-30e5-41cc-b21f-9e87e159f37d
    Content-Type: application/json;charset=UTF-8
    Transfer-Encoding: chunked
    Date: Thu, 26 Feb 2015 02:31:57 GMT

    {"errors":[{"code":"token not in session"}]}

