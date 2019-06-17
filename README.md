Spring-boot-REST my documentation
--------------------------------
	-> Rest Api controller is know as RestController = Controller+ResponseBody which 	send all response as json(default)
	-> you want to get xml response you must add maven dependency called 	jackson-dataformat-xml and send header ACCEPT='application/xml';
	
	
	There are 2 types of header
	request header(client) and response header(server).
	
	all headers that start from ACCEPT word is known as request header.(client header)

request header(client) List
-----------------------------
	1-Accept			Media type(s) that is/are acceptable for the response.	Accept: 	text/html  (basic use for specific  media type(json,xml,text) as response from 	server)
	By default 'Accept' header value is '*/*' which means accepting all.
	2-Accept-Charset	Character sets that are acceptable.	Accept-Charset: utf-8  	(specific character of response)
	3-Accept-Datetime	Acceptable version in time.	Accept-Datetime: Thu, 31 May 2007 	20:35:00 GMT (specific datetime format of response)	
	4-Accept-Encoding	List of acceptable encodings. See HTTP 	compression.	Accept-Encoding: gzip  (specific compression type)
	5-Accept-Language  	List of acceptable human languages for 	response.	Accept-Language: en-US (basic use for I18n feature)
	6-Authorization	    Authentication credentials for HTTP 	authentication.	Authorization: Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==
	This is basically use for client-auth from client side (basic or token based)
	7-Content-Type      media-type (json,xml ,etc) for request body used in POST/PUT 	request only. Content-Type: application/x-www-form-urlencoded
	8-Content-MD5       A Base64-encoded binary MD5 sum of the content of the request 	body.  Content-MD5: Q2hlY2sgSW50ZWdyaXR5IQ==	
	9-Cookie  		    An HTTP cookie previously sent by the server with Set-Cookie 	(below).
	10-Host          	Host: en.wikipedia.org
	11-User-Agent       User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:12.0) 	Gecko/20100101 Firefox/12.0
	
	for more details please 	checkout-https://en.wikipedia.org/wiki/List_of_HTTP_header_fields




Spring useful annotation for REST:
-----------------------------------
	@RequestMapping
	@GetMapping
	@PostMapping
	@PutMapping
	 Rest Similar for all http methods

	> ResponseEntity<T> use to make customable response as body along with respose 		headers and status-code.
	->  @PathVariable use to make dynamic url 
	->  @RequestParam for query parameter
	->  @RequetHeaders for request header param.
	-> 	@ModelAttribute for query/form-field  --works without annotation in spring 		boot.
	-> @RequestBody to use request body(json/xml) as Java param object.
	
	all above annotation been used in HelloRestController.

 
 



