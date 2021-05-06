import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.Test;

public class WriteTofileDemo {
	
	//Create a new file
	String sFormatedData = createNewCSVFile();
	File log = new File("C:\\tmp\\"+sFormatedData+".csv");
	
	//Return the date string
	public String createNewCSVFile() {
		//Set the date string
		Date date = Calendar.getInstance().getTime();  
	    DateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmmss");  
	    String strDate = dateFormat.format(date);  
	    //System.out.println("Converted String: " + strDate); 
	    return strDate;
	}
	
	public void writeToFile (String p1, String p2) throws IOException, InterruptedException {
		
		


				    try{
				    if(log.exists()==false){
				            System.out.println("We had to make a new file.");
				            log.createNewFile();
				    }
				    PrintWriter out = new PrintWriter(new FileWriter(log, true));
				    
			
				    
					out.append(p1 + "," + p2 +"\n");
				    out.close();
				    }catch(IOException e){
				        System.out.println("COULD NOT LOG!!");
				    }
	}

		
	@Test
	public void testCase2 () throws IOException, InterruptedException {
		
		writeToFile("p1","p2");
	}
	


}
