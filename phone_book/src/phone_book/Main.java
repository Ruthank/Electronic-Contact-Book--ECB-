package phone_book;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
	public static ArrayList<People> peopleList;
	
	public static void main(String[] args) throws IOException{
		if (args.length < 3) {
			System.out.println("ERROR");
			return;
		}
		
		Input In = new Input(args[0],args[1]);
		Output out = new Output(args[2], args[3]);
		
//		Input In = new Input("C:\\Users\\Administrator\\Desktop\\test_data\\contacts_5.txt",
//				"C:\\Users\\Administrator\\Desktop\\test_data\\instructions_5.txt");
//		Output out = new Output("C:\\Users\\Administrator\\Desktop\\test_data\\outputFile_5.txt", 
//				"C:\\Users\\Administrator\\Desktop\\test_data\\reportFile_5.txt");
	

		ArrayList<People>Books = In.inputPhoneBook();
		ArrayList<String>Instructions = In.inputInstruction();
		
		ArrayList<ArrayList<People>> results = new ArrayList<ArrayList<People>>(); //result
		
//		for (People p : Books) {
//			System.out.println(p.toString());
//		}
		
		int firstQuery = 0;
		for (String content : Instructions) {
			String list[] = Operation.splitByFirstSpace(content);
			People newPeople = new People();
			
			if (list[0].equals("add")) {
				newPeople = Operation.transferToPeople(list[1]);
				Add.add(newPeople, Books);
			} 
			else if (list[0].equals("delete")) {
				String infoList[] = list[1].split(";");
				for (String info : infoList) {
					if (info.indexOf('-') != -1) 
						Operation.fitInfoOfPeople("birthday", info.trim(), newPeople);
					//newPeople.setBirthday(info.trim());
					else Operation.fitInfoOfPeople("name", info.trim(), newPeople); 
					//newPeople.setName(info.trim());
				}
				Delete.delete(newPeople, Books);
			} 
			else if (list[0].equals("query")) {
				
//				String infoList[]= list[1].split(";");
//				for (String info : infoList) {
//					if (info.indexOf('-') != -1) {
//						newPeople.setBirthday(info.trim());
//					}
//					else {
//						Pattern p = Pattern.compile("[0-9]");
//						Matcher m = p.matcher(info);
//						if (m.find()) {
//							newPeople.setPhone(info.trim());
//						}else newPeople.setName(info.trim());
//					}
//				}
				
				newPeople = Operation.transferToPeople(list[1]);
				ArrayList<People> tmp = Query.query(newPeople, Books);
				if (!tmp.isEmpty())
					results.add( tmp );
//				System.out.println(results.size());
			}
			else if (list[0].equals("save")) {
				out.outputResult(Books);
				for (int i = 0; i < results.size(); i++) {
					ArrayList<People> al = results.get(i);
					if (al.isEmpty()) continue;
					if (firstQuery != 0) out.printDashLine();
					firstQuery = 1;
					out.outputQuery(al, i != results.size()-1);
				}
				results.clear();
			}
		}
		
//		for (People p : Books) {
//			System.out.println(p.toString());
//		}
	}
}

