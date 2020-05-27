package phone_book;

import java.util.ArrayList;
import java.util.Iterator;

public class Delete extends Operation{
	static void delete(People content,ArrayList<People>book) {
		
		//System.out.println(content);
		if (content.getBirthday() != null && content.getName() != null) {
			book.removeIf(x -> (content.getName().equals(x.getName()))
					&& content.getBirthday().equals(x.getBirthday()));
			//System.out.println(context);
		} else if (content.getName() != null){
			book.removeIf(x -> (content.getName().equals(x.getName())));
			//System.out.println(context);
		} else if (content.getBirthday() != null) {
			book.removeIf(x -> (content.getBirthday().equals(x.getBirthday())));
		}
//		
//		Iterator<People> iterator = book.iterator();	
//		while(iterator.hasNext()) {
//			if (context.getBirthday())
//		}
	}
}
