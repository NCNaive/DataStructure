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
		Person user = new Person();//创建用户
		ArrayList<Goods> store = new ArrayList<>();//商店
		ArrayList<Goods> car = new ArrayList<>();// 购物车
		BufferedReader A = new BufferedReader(new FileReader("data.txt"));
		String read;
		while ((read = A.readLine()) != null) {
			String[] m = read.split(",");
			Goods a = new Goods(Integer.parseInt(m[0]), m[1], Double.parseDouble(m[2]), Integer.parseInt(m[3]), m[4]);
			store.add(a);
		}//从文件中读取信息初始化商店
		File datawallet = new File("datawallet.txt");
		BufferedReader F = new BufferedReader(new FileReader(datawallet));
		user.setPassword(F.readLine());
		user.setWallet(Double.parseDouble(F.readLine()));
		F.close();//从文件中读取信息初始化个人信息
		File carorgin = new File("car.txt");
		carorgin.createNewFile();
		BufferedReader C = new BufferedReader(new FileReader(carorgin));
		String read3;//从文件中读取信息初始化购物车
		while ((read3 = C.readLine()) != null) {
			String[] m = read3.split(",");
			Goods a = new Goods(Integer.parseInt(m[0]), m[1], Double.parseDouble(m[2]), Integer.parseInt(m[3]),
					m[4]);
			car.add(a);
		}//从文件中读取信息初始化商店
		System.out.println("请输入账户");
		String logincount = sc.next();
		System.out.println("请输入密码");
		String loginpassword = sc.next();//输入账户密码登录
		if (logincount.equals(user.getCount()) && loginpassword.equals(user.getPassword())) {
			System.out.println("--------------欢迎进入商店-------------------");
			System.out.println("序号   名字   价格   数量");
			data(store);//将商店信息打印输出在控制台
			a: while (true) {
				System.out.println("请您选择如下命令进行操作：");
				System.out.println("1 查看个人信息");
				System.out.println("2 修改密码");
				System.out.println("3 查询购物车中未结账的商品");
				System.out.println("4 向购物车中添加商品");
				System.out.println("5 删除购物车中的商品");
				System.out.println("6 下单与结账");
				System.out.println("7 按类查找商品");
				System.out.println("8 充值账户");
				System.out.println("9 退出登录");
				System.out.println("请输入您的命令：");
				int order = sc.nextInt();//输入相关功能的序号执行相关功能

				switch (order) {
				case 1:// 查询个人信息；
					user.show();
					break;
				case 2:// 修改密码
					updatepassword(user, sc);
					break;
				case 3:// 查询购物车中未结账商品
					dispay(car);
					break;
				case 4:
					// 向加购物车中添加商品
					addToCart(store, car, sc);
					break;
				case 5:
					// 删除购物车中的商品
					deletepay(car, sc);
					break;
				case 6:
					// 下单与结账
					pay(car, sc, user);
					break;

				case 7:
					// 按类查找商品
					classification(sc, store);
					break;
				case 8:
					// 充值账户
					recharge(user, sc);
					break;
				case 9:
					//退出登录
					System.out.println("退出成功，欢迎下次登录");
					break a;

				default:
					//意外处理
					System.out.println("没有该项操作");
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
			B.close();//将最终的商店信息保存起来

			BufferedWriter D = new BufferedWriter(new FileWriter("car.txt"));
			String read4;
			for (int i = 0; i < car.size(); i++) {
				read4 = car.get(i).code + "," + car.get(i).name + "," + car.get(i).price + "," + car.get(i).number + ","
						+ car.get(i).type;
				D.write(read4);
				D.newLine();
			}
			C.close();
			D.close();//将用户最终的购物车数据保存起来

			BufferedWriter E = new BufferedWriter(new FileWriter("datawallet.txt"));
			String read5 = user.getPassword();
			String read6 = String.valueOf(user.getWallet());
			E.write(read5);
			E.newLine();
			E.write(read6);
			E.close();//将最终的个人信息数据保存在文件中

		}

		else {
			System.out.println("账户或密码输入不正确，您没有权限进入");

		}

	}
	
	
//功能2：修改密码
	private static void updatepassword(Person user, Scanner sc) {
		System.out.println("请输入您当前密码");
		String orginpassword;
		String updatepassword;

		orginpassword = sc.next();
		if (user.getPassword().equals(orginpassword)) {
			System.out.println("请输入你的新密码");
			updatepassword = sc.next();
			user.setPassword(updatepassword);
			System.out.println("修改密码成功");

		} else {

			System.out.println("原密码不正确，您无权修改密码");

		}

	}
//功能：按商品的分类查找
	private static void classification(Scanner sc, List<Goods> store) {
		System.out.println("目前的商品分类有:1.饮品、2.零食、3.水果、4.杂货");
		System.out.println("请输入要查找的商品类的编号");
		int m = sc.nextInt();
		if (m == 1) {
			for (int i = 0; i < store.size(); i++) {
				if (store.get(i).type.equals("饮品"))
					System.out.println(store.get(i).toString());

			}

		} else if (m == 2) {
			for (int i = 0; i < store.size(); i++) {
				if (store.get(i).type.equals("零食"))
					System.out.println(store.get(i).toString());

			}

		} else if (m == 3) {
			for (int i = 0; i < store.size(); i++) {
				if (store.get(i).type.equals("水果"))
					System.out.println(store.get(i).toString());

			}
		} else if (m == 4) {
			for (int i = 0; i < store.size(); i++) {
				if (store.get(i).type.equals("杂货"))
					System.out.println(store.get(i).toString());

			}

		} else {
			System.out.println("没有要查询的编号");
		}
	}

	public static void data(List store) {
		for (int i = 0; i < store.size(); i++) {
			System.out.println(store.get(i).toString());
		}
	}//打印商店信息
	
	
	//功能：展示购物车商品
	public static void dispay(List car) {

		if (car.size() == 0) {
			System.out.println("------------空空如也-------------");
		} else {
			System.out.println("序号   名字   价格   数量");
			for (int s = 0; s < car.size(); s++) {
				System.out.println(car.get(s).toString());
			}
		}
	}
	//功能：像购物车中添加商品
	public static void addToCart(List<Goods> store, List<Goods> car, Scanner sc) {
		System.out.println("请输入您要购买的商品编号");
		int addid = sc.nextInt();
		System.out.println("请输入购买的商品数量");
		int addNumber = sc.nextInt();
		if ((addid >= 0 && addid <= 11) && store.get(addid).number >= addNumber) {
			System.out.println("添加成功");
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
			System.out.println("--------新商店信息-------");
			System.out.println("序号   名字   价格   数量");
			data(store);
		} else {
			System.out.println("添加失败");
		}
	}
	//功能：删除购物车中商品
	public static void deletepay(List<Goods> car, Scanner sc) {
		System.out.println("请输入您要删除的商品编号");
		int decreaseid = sc.nextInt();
		System.out.println("请输入要删除的商品数量");
		int decreaseNumber = sc.nextInt();
		for (int i = 0; i < car.size(); i++) {
			if (car.get(i).code == decreaseid && car.get(i).number >= decreaseNumber) {
				System.out.println("删除相应数量成功");
				car.get(i).number -= decreaseNumber;
				if (car.get(i).number == 0) {
					car.remove(i);
				}
			}
		}

	}
	//功能：付款
	public static void pay(List<Goods> car, Scanner sc, Person user) {
		double sum = 0;
		int pay;
		for (int i = 0; i < car.size(); i++) {
			sum += car.get(i).price * car.get(i).number;
		}
		if (sum == 0) {
			System.out.println("-----------------空空如也----------------");
		} else {
			System.out.println("您购物购物车中需要支付的商品总价为" + sum);
			System.out.println("是否要全部买下: 是请输入 1 不是请输入 2");
			pay = sc.nextInt();
			if (pay == 1 && user.getWallet() > sum) {
				System.out.println("购买成功");
				user.setWallet(user.getWallet() - sum);
				System.out.print("您的账户余额为: ");
				System.out.printf("%.3f", user.getWallet());
				car.clear();

			} else if (pay == 2) {
				int indexof = 0;// 对应商品编号对应的集合下标
				System.out.println("请输入您要支付的商品编号");
				int m = sc.nextInt();
				System.out.println("请输入要支付的商品数量");
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
					System.out.println("支付失败,编号输入错误");
				} else {
					if (user.getWallet() >= car.get(indexof).price * n) {
						System.out.println("支付成功");
						user.setWallet(user.getWallet() - car.get(indexof).price * n);
						System.out.print("您的账户余额为: ");
						System.out.printf("%.3f", user.getWallet());
						System.out.println("");
						for (int i = 0; i < car.size(); i++) {
							if (car.get(i).code == m && car.get(i).number >= n) {
								System.out.println("购物车中已帮您删除您所买的商品数");
								car.get(i).number -= n;
								if (car.get(i).number == 0) {
									car.remove(i);
								}
							}
						}

					} else {
						System.out.println("购买失败,余额不足");
					}
				}
			} else {
				System.out.println("编号输入错误");
			}

		}
	}
	//功能：充值账户
	public static void recharge(Person user, Scanner sc) {
		double recharge = 0;
		System.out.println("请输入您要充值的钱数");
		recharge = sc.nextDouble();
		user.setWallet(user.getWallet() + recharge);
		System.out.println("充值成功 您的账号余额为" + user.getWallet());
	}

}
