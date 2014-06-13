package Results;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.examples.InCellLists;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class HtmlResults {
	
	
	File resultsFilename;
	String file_name;
	FileWriter reportmsg;
	String reporttime;
	 long filesizeInKB;
	static boolean check=true;
	public void results(String scenario,String result) throws Exception
	{
		
		
		if(check)
		{
			check = false;
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat  formatter= new SimpleDateFormat("MMM_ddHH_mm");
		reporttime = formatter.format(currentDate.getTime());
		file_name="D:/selenium-automation/ASS/src/Results/HtmlResults"+reporttime+".html";
		resultsFilename = new File(file_name);
		reportmsg = new FileWriter(file_name, true);
		long filesize = resultsFilename.length();
		filesizeInKB = filesize / 1024;
         if(filesizeInKB == 0)
          {
        	 FileInputStream fis = new FileInputStream(new File(file_name));             
         int b = fis.read();  
         if (b == -1)  

        	 reportmsg.write("<html><head><title>Results</title></head><body><center><font size=6><b>Test Execution Summary<br><center><table border =1><tr><td width=400><font size=2 face=Verdana><center>Widgte name</td><td width=100><font size=2 face=Verdana><center>Result</td><td width=100><font size=2 face=Verdana><center>Time</td>");
      //   reportmsg.write("<html><head><title>Results</title></head><body><center><font size=6><b>Test Execution Summary<br><center>");
         fis.close();
          }
		
		reportmsg.close();
		}
		
		 /*if (resultsFilename.exists())
         {
			 j++;
			 System.out.println("value of j:"+j);
			 //long filesize = resultsFilename.length();
			 System.out.println("File Path object:" +resultsFilename);
			 System.out.println("File name:"+file_name);
			 System.out.println("Report mesg obj:"+reportmsg);
             long filesizeInKB = filesize / 1024;
                 if(filesizeInKB == 0)
                  {
                                 FileInputStream fis = new FileInputStream(new File(file_name));             
                 int b = fis.read();  
                 if (b == -1)  
                 reportmsg.write("<html><head><title>Results</title></head><body><center><font size=6><b>Test Execution Summary<br><center>");
                 fis.close();
                  }*/
					  reportmsg = new FileWriter(file_name, true);
                      reportmsg.write("<table border=1><tr><td width=400><font size=2 face=Verdana>");
                      reportmsg.write(scenario);
         
                     if(result.equalsIgnoreCase("PASS"))
                         reportmsg.write("</td><td width=100 bgcolor=green><font size=2 face=Verdana color=white><center>");
                     else if (result == "FAIL")
                     {
                         reportmsg.write("</td><td width=100 bgcolor=red><font size=2 face=Verdana color=white><center>");
                         
                     }
                     else
                         reportmsg.write("</td><td width=100 bgcolor=orange><font size=2 face=Verdana color=white><center>");
         
                     reportmsg.write(result);
                     reportmsg.write("</a>");
                     reportmsg.write("</td><td width=110><font size=2 face=Verdana><center>");
                     reportmsg.write(reporttime);
                     reportmsg.write("</td></table></html>");
                      reportmsg.close();
                      
         //}
	//	 System.out.println("i= "+incremet);
}
	/*public static void main(String ar[])
	{
		HtmlResults r = new HtmlResults();
		try {
			r.results("My case","pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
}
	
	

