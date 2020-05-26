package phone_book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Query extends Operation{
	static ArrayList<People> query(People content,ArrayList<People>books) {
		//to do
		ArrayList<People>res = new ArrayList<>();
		if(content.getName()!=null) {
			for(int i=0;i<books.size();i++) {
				if(books.get(i).getName()!=null&&books.get(i).getName().equals(content.getName())){
					res.add(new People(books.get(i)));
				}
			}
		}else if(content.getBirthday()!=null) {
			for(int i=0;i<books.size();i++) {
				if(books.get(i).getBirthday()!=null&&books.get(i).getBirthday().equals(content.getBirthday())) {
					res.add(new People(books.get(i)));
				}
			}
		}else if(content.getPhone()!=null) {
			for(int i=0;i<books.size();i++) {
				if(books.get(i).getPhone()!=null&&books.get(i).getPhone().equals(content.getPhone())) {
					res.add(new People(books.get(i)));
				}
			}
		}
//		System.out.println("!!!"+res.size());
		Collections.sort(res, new Comparator<People>() {

			@Override
			public int compare(People o1, People o2) {
				People p1 = (People) o1;
				People p2 = (People) o2;
				if (p1.getName().equals(p2.getName())) 
					return p1.getBirthday().compareTo(p2.getBirthday());
				return p1.getName().compareTo(p2.getName());
			}
		});
		
		return res;
	}
}
