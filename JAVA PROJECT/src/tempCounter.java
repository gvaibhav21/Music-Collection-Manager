import java.io.FileWriter;
import java.io.Writer;


public class tempCounter {
	public static void main(String[] args)
	{
		try{
		Writer wr=new FileWriter("counter.txt");
		wr.write("3");
		wr.close();
		}catch(Exception e){}
		
		}
	
	
}
