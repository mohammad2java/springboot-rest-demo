package rizvi.amir.bootrestdemo.rest.model;

public class ChartData {

	private String taskName;
	private int taskVal;
	
	
	public ChartData() {
		super();
	}

	public ChartData(String taskName, int taskVal) {
		super();
		this.taskName = taskName;
		this.taskVal = taskVal;
	}
	
	
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public int getTaskVal() {
		return taskVal;
	}
	public void setTaskVal(int taskVal) {
		this.taskVal = taskVal;
	}
	
	
}
