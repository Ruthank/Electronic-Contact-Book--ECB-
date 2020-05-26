package phone_book;

public class People extends PeopleBase{
private
	String Phone;
	String Address;
	String Email;
public
	People() {
		super();
		Phone = null;
		Address = null;
		Email = null;
	}
	People(String Name,String Birthday,String Phone,String Address,String Email){
		super(Name,Birthday);
		this.Phone = Phone;
		this.Address = Address;
		this.Email = Email;
	}
	
	People(People people){
		super(people.getName(), people.getBirthday());
		this.Phone = people.getPhone();
		this.Address = people.getAddress();
		this.Email = people.getEmail();
	}
	

	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	@Override
	public String toString() {
		
		return super.toString()+"People [Phone=" + Phone + ", Address=" + Address + ", Email=" + Email + "]";
	}
	
	
}
