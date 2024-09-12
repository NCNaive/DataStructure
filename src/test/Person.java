package test;


public class Person {

	private String count="120";
	private String password="123456";
	private double wallet;

	public void setPassword(String password) {
		this.password = password;
	}

	public double getWallet() {
		return wallet;
	}

	public void setWallet(double wallet) {
		this.wallet = wallet;
	}

	

	public String getCount() {
		return count;
	}

	public String getPassword() {
		return password;
	}
	public Person() {
		this.count = "2070423110";
	}

	public void show() {
		System.out.println("�˻�Ϊ" + count);
		System.out.println("����Ϊ" + password);
		System.out.println("�����˻����" + wallet);

	}

}
