package phone_book;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Output {
	//¿‡±»input∞…
	private String resultPath;
	private String queryPath;
	public Output() {
		resultPath = null;
		queryPath = null;
	}
	public Output(String resultPath,String queryPath) {
		this.resultPath = resultPath;
		this.queryPath = queryPath;
	}
	public String getResultPath() {
		return resultPath;
	}
	public void setResultPath(String resultPath) {
		this.resultPath = resultPath;
	}
	public String getQueryPath() {
		return queryPath;
	}
	public void setQueryPath(String queryPath) {
		this.queryPath = queryPath;
	}
	public void outputResult(ArrayList<People>books) {
		try {
			File file = new File(resultPath);
			if(!file.exists())file.createNewFile();
			FileWriter out = new FileWriter(file);
			for(int i = 0; i < books.size(); i++) {
				People people = books.get(i);
				
				if (people.getName()!=null)
					out.write("name	"+people.getName()+"\n");
				if (people.getBirthday() != null)
					out.write("birthday	"+people.getBirthday()+"\n");
				if(people.getPhone()!=null)
					out.write("phone	"+people.getPhone()+"\n");
				if(people.getEmail()!=null)
					out.write("email	"+people.getEmail()+"\n");
				if(people.getAddress()!=null)
					out.write("address	"+people.getAddress()+"\n");
				out.write("\n");
			}
			out.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void outputQuery(ArrayList<People>content,boolean flag) {
		try {
			File file = new File(queryPath);
			if(!file.exists())file.createNewFile();
			FileWriter out = new FileWriter(file,true);
//			if(flag == true)
//				out.write("------------------"+"\n");
			
			
			for(int i=0;i<content.size();i++) {
				
				if(i != 0)
					out.write("\n");
				People people = content.get(i);
				
				if (people.getName()!=null)
					out.write("name	"+people.getName()+"\n");
				if (people.getBirthday() != null)
					out.write("birthday	"+people.getBirthday()+"\n");
				if(people.getPhone()!=null)
					out.write("phone	"+people.getPhone()+"\n");
				if(people.getEmail()!=null)
					out.write("email	"+people.getEmail()+"\n");
				if(people.getAddress()!=null)
					out.write("address	"+people.getAddress()+"\n");
			}
			out.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printDashLine() throws IOException {
		File file = new File(queryPath);
		if(!file.exists())file.createNewFile();
		FileWriter out = new FileWriter(file,true);
		out.write("------------------"+"\n");
		out.close();
	}
}
