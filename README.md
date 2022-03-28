# zenfeed-filters
This toy project demonstrates a major advantage of Spring Cloud Stream: **loose coupling**.

### The question we seek an answer to
What's the effort involved in migrating a monorepo of 5 Spring Boot microservices from RabbitMQ to Kafka
1. ...with Spring Cloud Stream?
1. ...without Spring Cloud Stream?

### The answer is in the MRs
- [Migrate from spring-amqp to spring-kafka #1](https://github.com/hosmanadam/zenfeed-filters/pull/1/files)
- [Migrate from spring-cloud-stream-binder-rabbit to spring-cloud-stream-binder-kafka #2](https://github.com/hosmanadam/zenfeed-filters/pull/2/files)

You may also explore the 4 different branches, they all work and do the exact same thing.

### Bear in mind
This 'product' isn't utilizing any platform-specific feature (special AMQP exchange/queue structures, log replay, etc.).  
If it did, it may be much more difficult (even impossible) to migrate in either case.

### What does it do?
It doesn't really matter, but if you need to know: this is part of an imaginary product called Zenfeed that displays only Zen posts in people's feeds, meaning no spam, no profanity, no negativity.
Messages flow through 5 microservices in the following order:
1. testing:rest-producer
1. filters:spam-filter
1. filters:profanity-filter
1. filters:negativity-filter
1. testing:logging-consumer
