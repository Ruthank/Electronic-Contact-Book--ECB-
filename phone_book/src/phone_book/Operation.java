//package phone_book;
//
//public abstract class Operation {
//	public static People transferToPeople(String content) {
//		People people = new People();
//		//to do
//		return people;
//	}
//	
//}

package phone_book;
public abstract class Operation {
	
	
	public static People transferToPeople(String content) {
		People people = new People();
		String[] infoList = content.split(";");
		
		for (String eachInfo : infoList) {
			eachInfo = eachInfo.trim();
			String list[] = splitByFirstSpace(eachInfo);
			//System.out.println(list[0] + list[1]);
			fitInfoOfPeople(list[0], list[1], people);
		}
		return people;
	}
	
	
	public static String[] splitByTab(String content) {
		return content.trim().split("\\t");
	}
	
	//split a string by first space
	public static String[] splitByFirstSpace(String content) {
		content = content.trim();
		String[] list = new String[2];
		for (int i = 0; i < content.length(); i++) {
			if (content.charAt(i) == ' ') {
				list[0] = content.substring(0, i);
				list[1] = content.substring(i+1, content.length());
				break;
			}
		}
		return list;
	}
	
	public static void fitInfoOfPeople(String infoName, String infoText, People people) {
		switch(infoName) {
		case "name": people.setName(infoText); break;
		case "birthday": people.setBirthday(infoText); break;
		case "phone": people.setPhone(infoText); break;
		case "address": people.setAddress(infoText); break;
		case "email": people.setEmail(infoText); break;
		}
	}
	
}

