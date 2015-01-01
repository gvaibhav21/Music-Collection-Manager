import java.io.*;
public class tempSong
{
	public static void main(String[] args)
	{
		try
		{
			FileOutputStream o=new  FileOutputStream("songs.ser");
			ObjectOutputStream obj=new ObjectOutputStream(o);
			song s=new song();
			s.setName("Tum Hi Ho");
			s.setYear(2013);
			s.setId(1);
			s.setAlbum("Aashiqui 2");
			s.setArtist("Arijit Singh");
			s.setGenre("Romantic");
			obj.writeObject(s);
			s=new song();
			s.setName("Galliyan");
			s.setYear(2014);
			s.setId(2);
			s.setAlbum("Ek Villain");
			s.setArtist("Ankit Tiwari");
			s.setGenre("Romantic");
			obj.writeObject(s);
			s=new song();
			s.setName("Hai Dil Ye Mera");
			s.setYear(2014);
			s.setId(3);
			s.setAlbum("Hate Story 2");
			s.setArtist("Arijit Singh");
			s.setGenre("Romantic");
			obj.writeObject(s);
			obj.close();
		FileInputStream f = new FileInputStream("songs.ser");
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(f);
		while(f.available()>0)
		{	
			s=(song)ois.readObject() ; 
			System.out.println("Name:"+s.getName()+"\tYear: "+s.getYear()+"\tId: "+s.getId()+"\tAlbum: "+s.getAlbum()+"\tArtist: "+s.getArtist()+"\tGenre: "+s.getGenre());
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}