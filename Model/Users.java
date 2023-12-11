package Model;

public class Users {
	private String user;
	private String pass;
	private String hovaten;
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(String user, String pass, String hovaten) {
		super();
		this.user = user;
		this.pass = pass;
		this.hovaten = hovaten;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getHovaten() {
		return hovaten;
	}
	public void setHovaten(String hovaten) {
		this.hovaten = hovaten;
	}
	@Override
	public String toString() {
		return "Users [user=" + user + ", pass=" + pass + ", hovaten=" + hovaten + "]";
	}
	
	
	
}
