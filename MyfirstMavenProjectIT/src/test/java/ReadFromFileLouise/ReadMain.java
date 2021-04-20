package ReadFromFileLouise;

import java.io.IOException;
//import com.opencsv.exceptions.CsvValidationException;

public class ReadMain {

	public static void main(String[] args) throws IOException, InterruptedException  {
		// TODO Auto-generated method stub
		// Create an instance of the PaymentGatewayKeywords class
		
		ReadKeywords pgKeywords = new ReadKeywords();
		
		// call runTest
		pgKeywords.runTestStart();
		pgKeywords.runTestReadFromFile();
		pgKeywords.cleanup();
	}

}
