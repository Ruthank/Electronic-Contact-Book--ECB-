package phone_book;

public abstract class PeopleBase {
private
	String Name;
	String Birthday;
public
	PeopleBase(){
		Name = null;
		Birthday = null;
	}
	PeopleBase(String Name,String Birthday){
		this.Name = Name;
		this.Birthday = Birthday;
	}
	String getName() {
		return Name;
	}
	String getBirthday() {
		return Birthday;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setBirthday(String birthday) {
		Birthday = birthday;
	}
	@Override
	public String toString() {
		return "PeopleBase [Name=" + Name + ", Birthday=" + Birthday + "]";
	}
	
//	public int compareTo(Object o) {
//		People p = (People) o;
//		if (this.getName().equals(p.getName())) 
//			return this.getBirthday().compareTo(p.getBirthday());
//		return this.getName().compareTo(p.getName());
//	}
	
	
}
