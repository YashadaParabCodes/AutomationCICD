package YashadaParabAutomation.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class DataReader {
	
	
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException{
		
		//Read data from json file to string
		String jsonContent=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\main\\java\\YashadaParabAutomation\\data\\purchaseOrder.json"),StandardCharsets.UTF_8);
		
		//Read data from String to HashMap using Jackson DataBind
		ObjectMapper mapper = new ObjectMapper();
		
		List <HashMap<String,String>> data= mapper.readValue(jsonContent, new TypeReference< List <HashMap<String,String>>>(){});
		return data;
	}
	

}
