package phone_book;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Input {
	private String phoneBookPath;
	private String instructionPath;
	public Input() {
		phoneBookPath = "";
		instructionPath = "";
	}
	public Input(String phoneBookPath,String instructionPath) {
		this.phoneBookPath = phoneBookPath;
		this.instructionPath = instructionPath;
	}
	public String getPhoneBookPath() {
		return phoneBookPath;
	}
	public void setPhoneBookPath(String phoneBookPath) {
		this.phoneBookPath = phoneBookPath;
	}
	public String getInstructionPath() {
		return instructionPath;
	}
	public void setInstructionPath(String instructionPath) {
		this.instructionPath = instructionPath;
	}
	
	public ArrayList<People> inputPhoneBook() {
		ArrayList<People>phoneBook = new ArrayList<People>();
		try {
			FileReader File = new FileReader(phoneBookPath);
			BufferedReader Input = new BufferedReader(File);
			String line = "";
			int flag = 0;
			int addressflag = 0;
			StringBuffer address = new StringBuffer();
			People people = new People();
			
			while((line = Input.readLine()) !=null) {
				if(line.equals("")) {
					if(flag == 1) {//got a completed message
						if(addressflag == 1) {
							Operation.fitInfoOfPeople("address", address.toString(), people);
							addressflag = 0;
						}
						phoneBook.add(people);
						people = new People();
						flag = 0;
					}
				}else {
					line.trim();
					String[] Content = line.split("	");//tab	
					if(!Content[0].trim().equals("")&&!Content[0].trim().equals("address")) {
						flag = 1;
						Operation.fitInfoOfPeople(Content[0].trim(), Content[1].trim(), people);							
						if(addressflag == 1){
							Operation.fitInfoOfPeople("address", address.toString().trim(), people);
							addressflag = 0;
						}
					}
					else if(Content[0].trim().equals("address")){
						flag = 1;
						addressflag = 1;
						address = new StringBuffer(Content[1]);
					}else if(Content[0].equals("")){
						address.append(Content[1]);
					}
				}
			}
			
			if(flag == 1) {
				if(addressflag == 1) {
					Operation.fitInfoOfPeople("address", address.toString(), people);
				}
				phoneBook.add(people);
				flag = 0;
			}
			File.close();
			Input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return phoneBook;
	}
	
	public ArrayList<String> inputInstruction(){
		ArrayList<String>Instruction = new ArrayList<String>();
		try {
			FileReader File = new FileReader(instructionPath);
			BufferedReader Input = new BufferedReader(File);
			String line = "";
			while((line = Input.readLine()) != null) {
				Instruction.add(line);
			}
			File.close();
			Input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return Instruction;
	}
}
