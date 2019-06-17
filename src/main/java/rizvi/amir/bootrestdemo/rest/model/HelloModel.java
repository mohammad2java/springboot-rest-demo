package rizvi.amir.bootrestdemo.rest.model;

public class HelloModel {
	
	
	private Long modelId;
	private String modelname;
	private String modeldesc;
	
	
	public HelloModel() {
		
	}
	
	public HelloModel(Long modelId, String modelname, String modeldesc) {
		super();
		this.modelId = modelId;
		this.modelname = modelname;
		this.modeldesc = modeldesc;
	}
	public Long getModelId() {
		return modelId;
	}
	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}
	public String getModelname() {
		return modelname;
	}
	public void setModelname(String modelname) {
		this.modelname = modelname;
	}
	public String getModeldesc() {
		return modeldesc;
	}
	public void setModeldesc(String modeldesc) {
		this.modeldesc = modeldesc;
	}

}
