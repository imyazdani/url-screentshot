# Screenshot-URL
### Spring Boot with Rabbitmq
A simple spring boot project with RabbitMQ as a message queue to represent producer and consumer.

Send a POST request to: localhost:9090/api/url
```json
{
  "url":"https://www.bing.com/"
}
```
You've got an urlId as a response, for example: 53c485f5b860b0f35f45a47d699b9517ed09d4337384e631601a5e245db8c3c0

To download screenshot, Send a GET request to: localhost:9090/api/url/53c485f5b860b0f35f45a47d699b9517ed09d4337384e631601a5e245db8c3c0

### Requirements
- Java 17
- Spring Boot 3
- RabbitMQ
