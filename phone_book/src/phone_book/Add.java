package phone_book;

import java.util.ArrayList;

public class Add extends Operation{
	static void add(People content,ArrayList<People>books) {
		int flag = 0;
		for(int i = 0; i < books.size(); i++) {
			People people = books.get(i);
			if(people.getName().equals(content.getName())&&people.getBirthday().equals(content.getBirthday())) {
				people = new People(content);
				flag = 1;
				break;
			}
		}
		if(flag == 0) {
			books.add(new People(content));
		}
	}
}
