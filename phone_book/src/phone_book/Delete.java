package phone_book;

import java.util.ArrayList;
import java.util.Iterator;

public class Delete extends Operation{
	static void delete(People content,ArrayList<People>book) {
		
		if (content.getBirthday() == null) {
			book.removeIf(x -> x.getName().equals(content.getName()));
			//System.out.println(context);
		} else {
			book.removeIf(x -> (x.getName().equals(content.getName())
					&& x.getBirthday().equals(content.getBirthday())));
			//System.out.println(context);
		}
//		
//		Iterator<People> iterator = book.iterator();	
//		while(iterator.hasNext()) {
//			if (context.getBirthday())
//		}
	}
}
