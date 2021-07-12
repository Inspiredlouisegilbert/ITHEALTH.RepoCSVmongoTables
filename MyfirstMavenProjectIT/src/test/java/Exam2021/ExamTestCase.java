package Exam2021;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;
public class ExamTestCase {
	HomePage home = new HomePage();
	ProductItemPage item= new ProductItemPage();
	SearchResultsPage results= new SearchResultsPage();
	@Test
	public void Test() {
		home.EnterSearchItem("solar");
		home.ClickSearch();
		results.selectItem(1);
	}
}
