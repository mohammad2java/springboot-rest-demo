package rizvi.amir.bootrestdemo.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import rizvi.amir.bootrestdemo.rest.model.ChartData;

public class ProxyService {
	
	public static List<ChartData> getDummyData() {
		List<ChartData> ret = new ArrayList<>();
		ret.add(getChart("work", 10));
		ret.add(getChart("eat", 2));
		ret.add(getChart("sleep", 6));
		ret.add(getChart("timepass", 4));
		
		return ret;
	}

	
	public static List<List> getDummyDataList() {
		List<List> ret = new ArrayList<>();
		ret.add(Arrays.asList("TaskName", "TaskValue"));
		ret.add(getChartList("work", 10));
		ret.add(getChartList("eat", 2));
		ret.add(getChartList("sleep", 6));
		ret.add(getChartList("timepass", 4));
		ret.add(getChartList("learning", 5));
		
		return ret;
	}
	
	
	private static ChartData getChart(String name,int val) {
		return new ChartData(name,val);
	}
	
	private static List getChartList(String name,int val) {
		List list =new ArrayList();
		list.add(name);
		list.add(val);
		return list;
	}
}
