package GetData;

import java.io.IOException;
//import com.opencsv.exceptions.CsvValidationException;

public class GetDataMain {

	public static void main(String[] args) throws IOException, InterruptedException  {
		// TODO Auto-generated method stub
		// Create an instance of the PaymentGatewayKeywords class
		
		GetDataKeywords pgKeywords = new GetDataKeywords();
		
		// call runTest
		pgKeywords.runTestStart();
		pgKeywords.runTestGetEmailData("33333");
		
		pgKeywords.cleanup();
	}

}