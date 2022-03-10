# NotificationSystem
Message Notification system

Application is built on Spring boot. 
Server is REST API

Use post method to push the data ex
{
   "from": "xyz@domain.com",
    "to": "abc@domain1.com",
  	"subject": "Hello",
    "message": "Hello"
}

* Need to configure username and password in application.properties
* Server is running on port 5000 (change if required in application.properties)
* WS is exposed on the url "/notifier/push"
* Sample stub is created in index.jsp
