package phaseOne;
import java.io.File;
import java.io.IOException;
import java.util.*;

//this class handles all the file operations
class FileOperations
{
	String path = null;
	FileOperations(String path)
	{
		this.path = path;
	}
	public boolean AddFile(String f) throws IOException
	{
		File file = new File(this.path+"\\"+f+".txt");
		if (file.createNewFile())
		{
            System.out.println("New File is created!"); 
		}
		return true;
	}
	public boolean DeleteFile(String f)throws FileNotFound
	{
		File file = new File(this.path+"\\"+f+".txt");
		if (file.delete())
		{
            System.out.println(file+": is deleted"); 
		}
		else
		{
			throw new FileNotFound("File not found!");
		}
		return true;
	}
	public boolean SearchFile(String f) throws FileNotFound
	{
		File file = new File(this.path+"\\"+f+".txt");
		if (file.exists())
		{
            System.out.println(file+": is found"); 
		}
		else
		{
			throw new FileNotFound("File not found!");
		}
		return true;
	}
	public void ArrangeFiles()
	{		
		TreeSet<String> ts = new TreeSet<String>();//used to display the file names in ascending order


		File[] files = new File(this.path).listFiles();
		for (File file : files) {
		    if (file.isFile()) {
		    	ts.add(file.getName());
		    }
		}
		System.out.println("Displaying the files in ascending order");
		System.out.println(files);
		System.out.println(ts);
		
	}
}
// this is the custom exception which handles file not found error
class FileNotFound extends Exception
{
	FileNotFound(String s){
		super(s);
	}
}

public class ApplicationMain {
	//this method has all the business level operations
	public static void businessLevelOperations(Scanner sc ,FileOperations fo)
	{
		boolean loop = true;
		System.out.println("\nBUSINESS LEVEL MENU --->");
		System.out.println("\nPlease select any one of the business level options to continue :");
        System.out.println("1. To add a new file");
        System.out.println("2. To delete an existing file");
        System.out.println("3. To search for a file");
        System.out.println("4. To return to the main options/Top-level options");
		while(loop)
		{
			System.out.println("Please select any one of the BUSINESS LEVEL MENU options to continue->");
			int choice = sc.nextInt();
			String name = null;
			switch(choice)
			{
			case 1:
				System.out.println("Enter the file name for new file creation");
				name = sc.next();
				try
				{
					fo.AddFile(name);
				}
				catch (Exception e)
				{
					System.out.println("Found an exception" +e);
				}
				break;
			case 2:
				System.out.println("Enter the file name which you want to delete");
				name = sc.next();
				try
				{
					fo.DeleteFile(name);
				}
				catch(Exception e)
				{
					System.out.println("Found an exception" +e);
				}
				break;
			case 3:
				System.out.println("Enter the file name which you want to search");
				name = sc.next();
				try
				{
					fo.SearchFile(name);
				}
				catch(Exception e)
				{
					System.out.println("Found an exception" +e);
				}
				break;
			case 4:
				System.out.println("Returning to main menu");
	        	loop = false;
	        	break;
	        default : System.out.println("Please enter a valid option\n");
	        break;
			}
		}
	}
	public static void main(String[] args)
	{
		String path = "C:\\Users\\ritwi\\Documents";
		FileOperations fo = new FileOperations(path);
		Scanner sc = new Scanner(System.in);
		System.out.println("#######################################");
		System.out.println("Welcome to Phase One Project");
        System.out.println("Developer Name: Ritwika Mukherjee ");
        System.out.println("#######################################");
        System.out.println("\nMAIN MENU --->");
    	System.out.println("\nPlease select any one of the options given below to continue :");
        System.out.println("1. To retrieve file names in ascending order");
        System.out.println("2. For business level operations");
        System.out.println("3. To close the application");
        while(true)
        {
        	System.out.println("Please select any one of the MAIN MENU options to continue->");
	        int choice = sc.nextInt();
	        switch(choice)
	        {
	        case 1:
	        	fo.ArrangeFiles();
	        	break;
	        case 2:
	        	businessLevelOperations(sc,fo);
	        	break;
	        case 3:
	        	System.out.println("Thankyou for using the Application");
	        	System.out.println("Closing the Application");
	        	System.exit(0);
	        	break;
	        default : System.out.println("Please enter a valid option\n");
	        break;
	        }
        }
        
	}

}