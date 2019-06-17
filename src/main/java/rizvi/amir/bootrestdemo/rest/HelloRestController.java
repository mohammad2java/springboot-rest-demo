package rizvi.amir.bootrestdemo.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rizvi.amir.bootrestdemo.rest.model.HelloModel;

@RestController
public class HelloRestController {

	@GetMapping(path = "/hello.text")
	public String hello() {
		return "Hello";
	}

	// produce means generating response media type (sending content-type from
	// Server)
	// consume means (sending accept header from client).
	@GetMapping(path = "/hello.json", produces = { "application/json", "application/xml" })
	public HelloModel helloJson() {
		HelloModel model = new HelloModel(101L, "amir", "java developers");
		return model;
	}

	// produce and consume example(consumes means accepted request body content
	// type)
	@PostMapping(path = "hello/changed.json", consumes = { "application/xml" })
	public HelloModel findModel(@RequestBody HelloModel request) {
		// changing name.
		request.setModelname("amir-changed");
		return request;
	}

	// response-entiy example (using String payload(body))
	@GetMapping(path = "/hello/entity.html")
	public ResponseEntity<String> getREObject() {
		ResponseEntity<String> ret = null;
		String body = "Hi This is example of ResponseEntity class";
		HttpStatus status = HttpStatus.OK;
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("custom-header", "value1");
		headers.add("custom-header", "value2");
		ret = new ResponseEntity<String>(body, headers, status);
		return ret;
	}

	// response-entiy example (using String model)
	@GetMapping(path = "/hello/entity2.html")
	public ResponseEntity<HelloModel> getREHelloModel() {
		ResponseEntity<HelloModel> ret = null;
		HttpStatus status = HttpStatus.CREATED;
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("custom-header", "value1");
		headers.add("custom-header", "value2");
		HelloModel body = new HelloModel(102L, "Meer", "Sr Java deveopers");
		ret = new ResponseEntity<>(body, headers, status);
		return ret;
	}

	// response-entiy example (using String model and static method of ResponseEntity)
	@GetMapping(path = "/hello/entity3.html")
	public ResponseEntity<HelloModel> getModel() {
		ResponseEntity<HelloModel> ret = null;
		HelloModel body = new HelloModel(103L, "Meer", "Sr Java deveopers");
		ret = ResponseEntity.accepted()
				.header("customer-header", "value1","value2")
				.body(body);
		return ret;
	}
	
	
	
	//path variable and RequestParam and @RequestHeader Annotation example
	@GetMapping(path="/test/{pv}")
	public ResponseEntity<HelloModel> getAllAnnotHits(@PathVariable("pv") String pv,@RequestParam(name="age",required=false) String age ,@RequestHeader(name="Accept") String accept) {
		ResponseEntity<HelloModel> ret =  null;
		HelloModel body = new HelloModel(104L, "Meer", "path-variable example:");
		body.setModelname(String.format("%s-%s", body.getModelname(),pv+age+accept));
		ret = ResponseEntity.accepted()
				.header("customer-header", "value1","value2")
				.body(body);
		return ret;
		
	}
	
	//localhost:8080/test/body?modelId=105&modelname=rizvi&modeldesc=rizvi-club	
	//@ModelAttribute setting model value using request-param name /query param name or form-data
	//note in Spring-boot @ModelAttribue is working bydefault with Model Parameter
	@PostMapping(path="/test/body")
	public ResponseEntity<HelloModel> getAttribue(HelloModel body) {
		ResponseEntity<HelloModel> ret =  null;
		ret = ResponseEntity.accepted()
				.header("customer-header", "value1","value2")
				.body(body);
		return ret;
		
	}
	
	
	//requestbody annotation...best for body content type.
	@PostMapping(path="/test/body/xml")
	public ResponseEntity<HelloModel> getGetRequestBody(@RequestBody HelloModel body) {
		ResponseEntity<HelloModel> ret =  null;
		ret = ResponseEntity.accepted()
				.header("customer-header", "body2","body1")
				.body(body);
		return ret;
	}
	
	//MatrixVariable
	//some issue with matrix variables.
	/* ExampleS:
	http://www.example.com/user/firstName=Sunil/lastName=Singh
	http://www.example.com/employee/Mike;salary=45000;dept=HR
	http://www.example.com/car/Audi;color=RED,BLACK,WHITE */	
	@RequestMapping(path="/test/body/matrix/")
	public ResponseEntity<Map<String,String>> getGeMatrixVariableBody(@MatrixVariable("modelname") String modelname) {
		
		ResponseEntity<Map<String,String>> ret =  null;
		Map<String,String> matdata = new HashMap<>();
		matdata.put("modelname", modelname);
		ret = ResponseEntity.accepted()
				.header("customer-header", "matrix1","matrix2")
				.body(matdata);
		return ret;
	}
	
	
	
}
