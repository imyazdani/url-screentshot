# Screenshot-URL
### Spring Boot with Rabbitmq
A simple spring boot project with RabbitMQ as a message queue to represent producer and consumer.<br>
Send a request to take a screenshot from a site like www.bing.com <br>
Consumer receives requests from the queue to take screenshot and save that in a folder.<br>
These screenshots are downloadable with their urlId.<br>
For take a screenshot, Send a POST request to: localhost:9090/api/url
```json
{
  "url":"https://www.bing.com/"
}
```
You've got an urlId as a response:
```json
{
  "urlId":"53c485f5b860b0f35f45a47d699b9517ed09d4337384e631601a5e245db8c3c0"
}
```
To download screenshot, Send a GET request to: `localhost:9090/api/url/{urlId}` <br>
example: <br>
`localhost:9090/api/url/53c485f5b860b0f35f45a47d699b9517ed09d4337384e631601a5e245db8c3c0`

### Requirements
- Java 17
- Spring Boot 3
- RabbitMQ