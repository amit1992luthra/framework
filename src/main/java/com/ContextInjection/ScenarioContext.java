package com.ContextInjection;
import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
	private Map<String,Object> scenarioContext ;
	
	public ScenarioContext(){
		scenarioContext = new HashMap<String,Object>();
	}
	
	public void setScenarioContext(String key , Object value){
		scenarioContext.put(key.toString(), value);
	}
	
	public Object getScenarioContext(String key){
		return scenarioContext.get(key.toString());
	}

	public boolean isContain(String key){
		return scenarioContext.containsKey(key.toString());
	}
	
	
}
