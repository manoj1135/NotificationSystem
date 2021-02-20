<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Async Receiver Stub</title>
<script type="text/javascript">
	let protocol = (window.location.protocol == "http:" || window.location.protocol == "http") ? "ws" : "wss";
    let host = protocol + "://" + window.location.host + "/notifier/push";
    console.log ("Connecting to to '" + host + "' ...");
	
	var onopen = function() {
          console.log("CONNECTED to notifier channel");
    };
	
	var onmessage =  function(e) {
		console.log(e);
    	let result = JSON.parse(e.data);
    	
    	document.getElementById("messageBody").innerHTML+=getTemplateString(result);
    };
    
    let onerror = function (e) {
    	console.error("Error ",e);      
    };
	
    webSocket = new WebSocket(host);

    webSocket.onopen = onopen;
    webSocket.onmessage = onmessage;
    webSocket.onerror = onerror;
    webSocket.onclose = onclose;
    
    function getTemplateString(obj){
    	return "<tr>"+
    		"<td>"+obj["from"]+"</td>"+
    		"<td>"+obj["to"]+"</td>"+
    		"<td>"+obj["subject"]+"</td>"+
    		"<td>"+obj["message"]+"</td>"+
    	"</tr>";
    }
</script>
</head>
<body>
	<table cellpadding="2" cellspacing="2">
	<thead>
		<tr>
			<th>From</th>
			<th>To</th>
			<th>Subject</th>
			<th>Message</th>
		</tr>
	</thead>
	<tbody id="messageBody">
		
	</tbody>
	
	</table>
</body>
</html>