Design Url Shorting system

Use cases
  - Shorting -> as much as possible
  - Redirecting -> redirect to original url

System Design
  - microservice
  - ZooKeeper/Eureka : for service registry
  - Zipkin : for tracing requests
  - Prometheus and grafana : for monitoring 
  - Admin Server
  

Global scalability:
  - Using multi instance 
  - Using DNS base on regin
  - Using Kubernetes
  

Bottlenecks:
- Database:
  - Solution:
    - Using cache for recent url requests
    - Sharding database base on first letter of website after www. 
    - Database replication - read-only database(s) for getting original url base on short link


Storage:
  - if our website one of the top 10 
    - The website receives 100M requests each month, I assume
    - 10% of requests are creating short link and 90% of requests for redirection
    - If storing a record need 1K space
    - 10M * 12 Month * 1K = 120G for a year


Pulling and Running app:
  - docker image pull momo7012/shorturl
  - docker container run -p 80:8090 -d --name shortingurl --rm momo7012/shorturl


