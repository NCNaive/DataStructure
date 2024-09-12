package test;

import java.io.*;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Person user = new Person();//�����û�
		ArrayList<Goods> store = new ArrayList<>();//�̵�
		ArrayList<Goods> car = new ArrayList<>();// ���ﳵ
		BufferedReader A = new BufferedReader(new FileReader("data.txt"));
		String read;
		while ((read = A.readLine()) != null) {
			String[] m = read.split(",");
			Goods a = new Goods(Integer.parseInt(m[0]), m[1], Double.parseDouble(m[2]), Integer.parseInt(m[3]), m[4]);
			store.add(a);
		}//���ļ��ж�ȡ��Ϣ��ʼ���̵�
		File datawallet = new File("datawallet.txt");
		BufferedReader F = new BufferedReader(new FileReader(datawallet));
		user.setPassword(F.readLine());
		user.setWallet(Double.parseDouble(F.readLine()));
		F.close();//���ļ��ж�ȡ��Ϣ��ʼ��������Ϣ
		File carorgin = new File("car.txt");
		carorgin.createNewFile();
		BufferedReader C = new BufferedReader(new FileReader(carorgin));
		String read3;//���ļ��ж�ȡ��Ϣ��ʼ�����ﳵ
		while ((read3 = C.readLine()) != null) {
			String[] m = read3.split(",");
			Goods a = new Goods(Integer.parseInt(m[0]), m[1], Double.parseDouble(m[2]), Integer.parseInt(m[3]),
					m[4]);
			car.add(a);
		}//���ļ��ж�ȡ��Ϣ��ʼ���̵�
		System.out.println("�������˻�");
		String logincount = sc.next();
		System.out.println("����������");
		String loginpassword = sc.next();//�����˻������¼
		if (logincount.equals(user.getCount()) && loginpassword.equals(user.getPassword())) {
			System.out.println("--------------��ӭ�����̵�-------------------");
			System.out.println("���   ����   �۸�   ����");
			data(store);//���̵���Ϣ��ӡ����ڿ���̨
			a: while (true) {
				System.out.println("����ѡ������������в�����");
				System.out.println("1 �鿴������Ϣ");
				System.out.println("2 �޸�����");
				System.out.println("3 ��ѯ���ﳵ��δ���˵���Ʒ");
				System.out.println("4 ���ﳵ�������Ʒ");
				System.out.println("5 ɾ�����ﳵ�е���Ʒ");
				System.out.println("6 �µ������");
				System.out.println("7 ���������Ʒ");
				System.out.println("8 ��ֵ�˻�");
				System.out.println("9 �˳���¼");
				System.out.println("�������������");
				int order = sc.nextInt();//������ع��ܵ����ִ����ع���

				switch (order) {
				case 1:// ��ѯ������Ϣ��
					user.show();
					break;
				case 2:// �޸�����
					updatepassword(user, sc);
					break;
				case 3:// ��ѯ���ﳵ��δ������Ʒ
					dispay(car);
					break;
				case 4:
					// ��ӹ��ﳵ�������Ʒ
					addToCart(store, car, sc);
					break;
				case 5:
					// ɾ�����ﳵ�е���Ʒ
					deletepay(car, sc);
					break;
				case 6:
					// �µ������
					pay(car, sc, user);
					break;

				case 7:
					// ���������Ʒ
					classification(sc, store);
					break;
				case 8:
					// ��ֵ�˻�
					recharge(user, sc);
					break;
				case 9:
					//�˳���¼
					System.out.println("�˳��ɹ�����ӭ�´ε�¼");
					break a;

				default:
					//���⴦��
					System.out.println("û�и������");
					break;
				}
			}

			BufferedWriter B = new BufferedWriter(new FileWriter("data.txt"));
			String read2;
			for (int i = 0; i < store.size(); i++) {
				read2 = store.get(i).code + "," + store.get(i).name + "," + store.get(i).price + ","
						+ store.get(i).number + "," + store.get(i).type;
				B.write(read2);
				B.newLine();
			}
			A.close();
			B.close();//�����յ��̵���Ϣ��������

			BufferedWriter D = new BufferedWriter(new FileWriter("car.txt"));
			String read4;
			for (int i = 0; i < car.size(); i++) {
				read4 = car.get(i).code + "," + car.get(i).name + "," + car.get(i).price + "," + car.get(i).number + ","
						+ car.get(i).type;
				D.write(read4);
				D.newLine();
			}
			C.close();
			D.close();//���û����յĹ��ﳵ���ݱ�������

			BufferedWriter E = new BufferedWriter(new FileWriter("datawallet.txt"));
			String read5 = user.getPassword();
			String read6 = String.valueOf(user.getWallet());
			E.write(read5);
			E.newLine();
			E.write(read6);
			E.close();//�����յĸ�����Ϣ���ݱ������ļ���

		}

		else {
			System.out.println("�˻����������벻��ȷ����û��Ȩ�޽���");

		}

	}
	
	
//����2���޸�����
	private static void updatepassword(Person user, Scanner sc) {
		System.out.println("����������ǰ����");
		String orginpassword;
		String updatepassword;

		orginpassword = sc.next();
		if (user.getPassword().equals(orginpassword)) {
			System.out.println("���������������");
			updatepassword = sc.next();
			user.setPassword(updatepassword);
			System.out.println("�޸�����ɹ�");

		} else {

			System.out.println("ԭ���벻��ȷ������Ȩ�޸�����");

		}

	}
//���ܣ�����Ʒ�ķ������
	private static void classification(Scanner sc, List<Goods> store) {
		System.out.println("Ŀǰ����Ʒ������:1.��Ʒ��2.��ʳ��3.ˮ����4.�ӻ�");
		System.out.println("������Ҫ���ҵ���Ʒ��ı��");
		int m = sc.nextInt();
		if (m == 1) {
			for (int i = 0; i < store.size(); i++) {
				if (store.get(i).type.equals("��Ʒ"))
					System.out.println(store.get(i).toString());

			}

		} else if (m == 2) {
			for (int i = 0; i < store.size(); i++) {
				if (store.get(i).type.equals("��ʳ"))
					System.out.println(store.get(i).toString());

			}

		} else if (m == 3) {
			for (int i = 0; i < store.size(); i++) {
				if (store.get(i).type.equals("ˮ��"))
					System.out.println(store.get(i).toString());

			}
		} else if (m == 4) {
			for (int i = 0; i < store.size(); i++) {
				if (store.get(i).type.equals("�ӻ�"))
					System.out.println(store.get(i).toString());

			}

		} else {
			System.out.println("û��Ҫ��ѯ�ı��");
		}
	}

	public static void data(List store) {
		for (int i = 0; i < store.size(); i++) {
			System.out.println(store.get(i).toString());
		}
	}//��ӡ�̵���Ϣ
	
	
	//���ܣ�չʾ���ﳵ��Ʒ
	public static void dispay(List car) {

		if (car.size() == 0) {
			System.out.println("------------�տ���Ҳ-------------");
		} else {
			System.out.println("���   ����   �۸�   ����");
			for (int s = 0; s < car.size(); s++) {
				System.out.println(car.get(s).toString());
			}
		}
	}
	//���ܣ����ﳵ�������Ʒ
	public static void addToCart(List<Goods> store, List<Goods> car, Scanner sc) {
		System.out.println("��������Ҫ�������Ʒ���");
		int addid = sc.nextInt();
		System.out.println("�����빺�����Ʒ����");
		int addNumber = sc.nextInt();
		if ((addid >= 0 && addid <= 11) && store.get(addid).number >= addNumber) {
			System.out.println("��ӳɹ�");
			store.get(addid).number -= addNumber;
			Goods addgoods = new Goods(addid, store.get(addid).name, store.get(addid).price, addNumber,
					store.get(addid).type);
			if (car.contains(addgoods)) {
				for (int i = 0; i < car.size(); i++) {
					if (car.get(i).code == addid) {
						car.get(i).number += addNumber;
						break;
					}
				}
			} else {
				car.add(addgoods);
			}
			System.out.println("--------���̵���Ϣ-------");
			System.out.println("���   ����   �۸�   ����");
			data(store);
		} else {
			System.out.println("���ʧ��");
		}
	}
	//���ܣ�ɾ�����ﳵ����Ʒ
	public static void deletepay(List<Goods> car, Scanner sc) {
		System.out.println("��������Ҫɾ������Ʒ���");
		int decreaseid = sc.nextInt();
		System.out.println("������Ҫɾ������Ʒ����");
		int decreaseNumber = sc.nextInt();
		for (int i = 0; i < car.size(); i++) {
			if (car.get(i).code == decreaseid && car.get(i).number >= decreaseNumber) {
				System.out.println("ɾ����Ӧ�����ɹ�");
				car.get(i).number -= decreaseNumber;
				if (car.get(i).number == 0) {
					car.remove(i);
				}
			}
		}

	}
	//���ܣ�����
	public static void pay(List<Goods> car, Scanner sc, Person user) {
		double sum = 0;
		int pay;
		for (int i = 0; i < car.size(); i++) {
			sum += car.get(i).price * car.get(i).number;
		}
		if (sum == 0) {
			System.out.println("-----------------�տ���Ҳ----------------");
		} else {
			System.out.println("�����ﹺ�ﳵ����Ҫ֧������Ʒ�ܼ�Ϊ" + sum);
			System.out.println("�Ƿ�Ҫȫ������: �������� 1 ���������� 2");
			pay = sc.nextInt();
			if (pay == 1 && user.getWallet() > sum) {
				System.out.println("����ɹ�");
				user.setWallet(user.getWallet() - sum);
				System.out.print("�����˻����Ϊ: ");
				System.out.printf("%.3f", user.getWallet());
				car.clear();

			} else if (pay == 2) {
				int indexof = 0;// ��Ӧ��Ʒ��Ŷ�Ӧ�ļ����±�
				System.out.println("��������Ҫ֧������Ʒ���");
				int m = sc.nextInt();
				System.out.println("������Ҫ֧������Ʒ����");
				int n = sc.nextInt();
				boolean exit = false;
				for (int i = 0; i < car.size(); i++) {
					if (m == car.get(i).code) {
						indexof = i;
						exit = true;
						break;
					}

				}
				if (!exit) {
					System.out.println("֧��ʧ��,����������");
				} else {
					if (user.getWallet() >= car.get(indexof).price * n) {
						System.out.println("֧���ɹ�");
						user.setWallet(user.getWallet() - car.get(indexof).price * n);
						System.out.print("�����˻����Ϊ: ");
						System.out.printf("%.3f", user.getWallet());
						System.out.println("");
						for (int i = 0; i < car.size(); i++) {
							if (car.get(i).code == m && car.get(i).number >= n) {
								System.out.println("���ﳵ���Ѱ���ɾ�����������Ʒ��");
								car.get(i).number -= n;
								if (car.get(i).number == 0) {
									car.remove(i);
								}
							}
						}

					} else {
						System.out.println("����ʧ��,����");
					}
				}
			} else {
				System.out.println("����������");
			}

		}
	}
	//���ܣ���ֵ�˻�
	public static void recharge(Person user, Scanner sc) {
		double recharge = 0;
		System.out.println("��������Ҫ��ֵ��Ǯ��");
		recharge = sc.nextDouble();
		user.setWallet(user.getWallet() + recharge);
		System.out.println("��ֵ�ɹ� �����˺����Ϊ" + user.getWallet());
	}

}
