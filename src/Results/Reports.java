package Results;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

	public class Reports extends TestListenerAdapter
	{
		
		private int m_count = 0;
		 
		  @Override
		  public void onTestFailure(ITestResult tr) 
		  {
		    log("Fail");
		  }
		 
		  @Override
		  public void onTestSkipped(ITestResult tr) 
		  {
		    log("SKipped");
		    
		  }
		 
		  @Override
		  public void onTestSuccess(ITestResult tr) 
		  {
		    log(tr.getName()+":Tc Passed at"+(tr.getStartMillis()-tr.getEndMillis()));
		 
		  }
		 
		  private void log(String string)
		  {
		    System.out.print(string);
		    if (++m_count % 40 == 0) 
		    {
		      System.out.println("");
		    }
		  }
	}
	
