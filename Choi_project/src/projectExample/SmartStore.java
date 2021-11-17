package projectExample;

import java.util.Arrays;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.*;

public class SmartStore { // �ذ��� �� : 1. �ű� ���� �ʱ�ȭ 2. -1 �Է½� ó������ �����°� 3. ��޺��� �� ��޸���Ʈ ��� 4. �Է¹޴� ���� �ʹ� ����
							// 5. ����� ��ް� ���� �ϱ�
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		Membership guest = new Membership();
		Membership bronze = new Membership();
		Membership silver = new Membership();
		Membership gold = new Membership();

		//MembershipType[] type = new MembershipType[100];
		int price = 0;
		int count = 0;
		Customer[] customers = new Customer[100]; // �� ����
		// ArrayList<Customer> customers = new ArrayList<>(); �̰� ���� ���� �������� �����;

		for (int i = 0; i < customers.length; i++) {
			customers[i] = new Customer();
		}
		while (true) {
			mainMenu(); // ùȭ�� �޴�
			System.out.print("�� �Է� : ");
			int mainMenuChoice = input.nextInt();
			System.out.println();
			if (mainMenuChoice >= 1 || mainMenuChoice <= 3) {
				if (mainMenuChoice == 1) { // ������

					while (true) {

						customersMunu(); // �� ���� �޴�
						System.out.print("�� �Է� : ");
						int custoMenuChoice = input.nextInt();

						if (custoMenuChoice >= 1 || custoMenuChoice <= 5) {
							if (custoMenuChoice == 1) { // �� ���� �Է�
								System.out.print("\n�� �ű� �� �� : "); // ������ : �ű� ���� �Էµɶ����� ���� �� ������ ������
								int newCustNum = input.nextInt();

								for (int i = 0; i < newCustNum; i++) {

									customers[count].customerNumber = count + 1;
									System.out.printf("\n������ %1d �� �Է� ������\n", customers[count].customerNumber);
									System.out.print("�� �̸� : "); // ���ø� �����ְ� �Է� : ���� ���� �����ϴ°� ���� ��
									customers[count].name = input.next();
									System.out.println("�� ������� : ex) 880101 (��������� 6�ڸ��� �������ּ���.)");
									System.out.print("�� �Է� : "); // ������Ϸ� ����
									customers[count].dob = input.next();
									System.out.println("�� ����ó : ex) 0123456780 ('-' ���� �������ּ���.)");
									System.out.print("�� �Է� : "); // ����ȣ String ���� ����
									customers[count].phoneNumber = input.next();
									System.out.println("�� ������ �Է��ϼ���"); // 1. ���� 2. ���� �������� ����
									System.out.println("�� 1. ���� \n�� 2. ���� ");
									System.out.print("�� �Է� : ");
									int choiceGender = input.nextInt();
									if (choiceGender > 0 && choiceGender < 3) {
										if (choiceGender == 1) {
											System.out.println("�� ���� ��� ��");
											customers[count].gender = "����";
										} else if (choiceGender == 2) {
											System.out.println("�� ���� ��� ��");
											customers[count].gender = "����";
										}
									} else {
										System.out.println("�� �߸��� �����Դϴ�.");
									}

									System.out.print("�� ���ž� : "); // ���Ű��ݿ� , �ڸ��� �Է� ���� ��ȹ
									price = input.nextInt();
									customers[count].price = price;
									for (int j = 0; j < customers.length; j++) {
										if (price > guest.minPrice && price <= guest.maxPrice) {
											customers[i].nameMember = "Guest"; // print ����� �Ǵµ� ...
										} else if (price > bronze.minPrice && price <= bronze.maxPrice) {
											customers[i].nameMember = "Bronze";
										} else if (price > silver.minPrice && price <= silver.maxPrice) {
											customers[i].nameMember = "Silver";
										} else if (price > gold.minPrice && price <= gold.maxPrice) {
											customers[i].nameMember = "Gold";
										} else {
											customers[i].nameMember = "������";
										}
									}

									System.out.println("\n�� �����Ͻðڽ��ϱ�? 1. YES 2. NO");
									System.out.print("�� �Է� : ");
									int save = input.nextInt();
									if (save == 1 || save == 2) {
										if (save != 1) {
											System.out.println("�� ��ҵǾ����ϴ�.");
											// count �� �������ν� ���� �� �Է½� ���� ����� �׷��� �����ϴ� ���..
										} else {
											System.out.println("�� ����Ǿ����ϴ�.");
											count++;
										}
									} else {
										System.out.println("\n�߸��� �Է��Դϴ�.");
									}
								}
							} else if (custoMenuChoice == 2) { // �� ���� ���� �޴�
								System.out.print("�� �� �̸��� �Է��ϼ��� : ");
								String searchName = input.next();
								for (int i = 0; i < 1; i++) {
									int editCus = Arrays.asList(customers[i].name).indexOf(searchName); // ��.. �ε����� �ƴµ�
									System.out.println(customers[editCus]);

									System.out.println("\n������ �� ���� ���� ������"); // ������ ������ �κ��� �������� ���� ��ȹ
									System.out.print("�� 0. �������\n�� ������ ������ �����ϼ��� : ");
									int changeDate = input.nextInt();
									if (changeDate >= 0 || changeDate <= 5) {
										if (changeDate == 1) {
											System.out.print("�� �� �̸� ���� : ");
											customers[editCus].name = input.next();
										} else if (changeDate == 2) {
											System.out.print("�� �� ���� ���� : ");
											customers[editCus].dob = input.next();
										} else if (changeDate == 3) {
											System.out.println("�� ������ �����ϼ���"); // 1. ���� 2. ���� �������� ����
											System.out.println("�� 1. ���� \n�� 2. ���� ");
											System.out.print("�� �Է� : ");
											int choiceGender = input.nextInt();
											if (choiceGender > 0 && choiceGender < 3) {
												if (choiceGender == 1) {
													System.out.println("�� ���� ���� ��");
													customers[editCus].gender = "����";
												} else if (choiceGender == 2) {
													System.out.println("�� ���� ���� ��");
													customers[editCus].gender = "����";
												}
											} else {
												System.out.println("�� �߸��� �����Դϴ�.");
												continue;
											}
										} else if (changeDate == 4) {
											System.out.print("�� ����ó ���� : ");
											customers[editCus].phoneNumber = input.next();
										} else if (changeDate == 5) {
											System.out.print("�� �� ���ž� ���� : "); // ���Ű��ݿ� , �ڸ��� �Է� ���� ��ȹ
											customers[editCus].price = input.nextInt();
										} else if (changeDate == 6) {
											System.out.println("\n������ �Ұ����մϴ�.");
											continue;
										} else if (changeDate == 0) {
											break;
										} else {
											System.out.println("\n�߸��� �Է��Դϴ�.");
										}
									}
								}
							}

							else if (custoMenuChoice == 3) { // �� ���� ���� �޴�
								for (int i = 0; i < customers.length; i++) {
									if (price > guest.minPrice && price <= guest.maxPrice) {
										customers[i].nameMember = "Guest"; // print ����� �Ǵµ� ...
									} else if (price > bronze.minPrice && price <= bronze.maxPrice) {
										customers[i].nameMember = "Bronze";
									} else if (price > silver.minPrice && price <= silver.maxPrice) {
										customers[i].nameMember = "Silver";
									} else if (price > gold.minPrice && price <= gold.maxPrice) {
										customers[i].nameMember = "Gold";
									}
								}
								System.out.print("������� �˻� �������\n�� 1. ����ȣ �˻�\n�� 2. �̸� �˻�\n�� 3. ����ó �˻�\n�� �Է� : ");
								int searchCust = input.nextInt();
								if (searchCust >= 1 || searchCust <= 3) {
									if (searchCust == 1) {
										System.out.print("�� ����ȣ�� �Է��ϼ��� : "); // �� ���� �˻� ����ȣ �� �̸�, ������ȣ, ����� ���
										int userDatanum = input.nextInt();
										System.out.println("������ �� ���� ������");
										System.out.println(customers[userDatanum - 1]);
										System.out.println();
									} else if (searchCust == 2) {
										System.out.print("�� ���̸��� �Է��ϼ��� : ");
										String searchName = input.next();
										for (int i = 0; i < 1; i++) {
											i = Arrays.asList(customers[i].name).indexOf(searchName); // ��.. �ε����� �ƴµ�
																										// �����...��������...
											System.out.println(customers[i]); // ���� ������..;;
										}
									} else if (searchCust == 3) {
										System.out.print("�� �� ����ó �Է��ϼ��� : ");
										String searchName = input.next();
										for (int i = 0; i < 1; i++) {
											i = Arrays.asList(customers[i].phoneNumber).indexOf(searchName); // ��.. �ε�����
																												// �ƴµ�
											// �����...��������...
											System.out.println(customers[i]); // ���� ������..;;
										}
									}

								} else {
									System.out.println("�� �߸��� �Է��Դϴ�.");
									continue;
								}
							} else if (custoMenuChoice == 4) {
								for (int i = 0; i < customers.length; i++) {
									if (price > guest.minPrice && price <= guest.maxPrice) {
										customers[i].nameMember = "Guest"; // print ����� �Ǵµ� ...
									} else if (price > bronze.minPrice && price <= bronze.maxPrice) {
										customers[i].nameMember = "Bronze";
									} else if (price > silver.minPrice && price <= silver.maxPrice) {
										customers[i].nameMember = "Silver";
									} else if (price > gold.minPrice && price <= gold.maxPrice) {
										customers[i].nameMember = "Gold";
									}
								}
								viewCustList();
								int viewMemRank = input.nextInt();
								if (viewMemRank >= 1 || viewMemRank <= 5) {
									if (viewMemRank == 1) {
										System.out.println("������� Guest �������");
										System.out.print("�� ��� ���� : ");
										int pirintMem = input.nextInt();
										for (int i = 0; i < pirintMem; i++) {
											Arrays.asList(customers[i].nameMember).indexOf("Guest");
											System.out.println(customers[i]);
											continue;
										}
									} else if (viewMemRank == 2) {
										System.out.println("������� Bronze �������");
										System.out.print("�� ��� ���� : ");
										int pirintMem = input.nextInt();
										for (int i = 0; i < pirintMem; i++) {
											Arrays.asList(customers[i].nameMember).indexOf("Bronze");
											System.out.println(customers[i]);
											continue;
										}
									} else if (viewMemRank == 3) {
										System.out.println("������� Silver �������");
										System.out.print("�� ��� ���� : ");
										int pirintMem = input.nextInt();
										for (int i = 0; i < pirintMem; i++) {
											Arrays.asList(customers[i].nameMember).indexOf("Silver");
											System.out.println(customers[i]);
											continue;
										}
									} else if (viewMemRank == 4) {
										System.out.println("������� Gold �������");
										System.out.print("�� ��� ���� : ");
										int pirintMem = input.nextInt();
										for (int i = 0; i < pirintMem; i++) {
											Arrays.asList(customers[i].nameMember).indexOf("Gold");
											System.out.println(customers[i]);
											continue;
										}
									}
								}
							} else if (custoMenuChoice == 5) {
								break;

							} else {
								System.out.println("\n�߸��� �Է��Դϴ�.");
								continue;
							}
						}
					}
				}
				if (mainMenuChoice == 2) { // ����� ���� // @@@@������ : ��޾� ����� ������ �ȵ�

					while (true) {
						membershipMenu();
						System.out.print("�� �Է� : ");
						int memMenu = input.nextInt();

						if (memMenu == 1) { // ����� ��� ���� //������ : ������� ���� �ʿ� �ʹ� ���� �۾��� ���� ����ڰ� ���� ������
							membershiprank();
							int rankMenu = input.nextInt(); // ���ž׸� ������ �ɵ�

							if (rankMenu == 1) { // �Խ�Ʈ ���
								membershipSubMunu();
								int choiceGuest = input.nextInt();
								if (choiceGuest == 1) { // �Խ�Ʈ ��� ���
									System.out.println("���� ��� Guest ��� ����\n");
									System.out.print("�� Guest ��� �ּҰ� : ");
									guest.minPrice = input.nextInt();
									System.out.print("�� Guest ��� �ִ밪 : ");
									guest.maxPrice = input.nextInt();
									System.out.println(guest);
								} else if (choiceGuest == 2) { // �Խ�Ʈ ��� �κ� ���� �κ�
									System.out.println("���� ��� Guest ���� ����\n");
									System.out.println(guest);
									System.out.println("�� 1. �ּҰ� ����\n�� 2. �ִ밪 ����");
									System.out.print("�� �Է� : ");
									int subchoiGuest = input.nextInt();
									if (subchoiGuest > 0 && subchoiGuest < 3) {
										if (subchoiGuest == 1) { // �Խ�Ʈ �κ� ���� ���� �κ�
											System.out.println("�� ���� �� : " + guest.minPrice);
											System.out.print("�� �ּҰ� ���� : ");
											guest.minPrice = input.nextInt();
											System.out.println(guest);
										} else if (subchoiGuest == 2) {
											System.out.println("�� ���� �� : " + guest.maxPrice);
											System.out.print("�� �ִ밪 ���� : ");
											guest.maxPrice = input.nextInt();
											System.out.println(guest);
										}
									}
								} else {
									System.out.println("�� �߸��� �Է��Դϴ�");
								}
							} else if (rankMenu == 2) { // ����� ���
								membershipSubMunu();
								int choiceBronze = input.nextInt();
								if (choiceBronze == 1) { // ����� ��� ���
									System.out.println("���� ��� Bronze ����\n");
									System.out.print("�� Bronze ��� �ּҰ� : ");
									bronze.minPrice = input.nextInt();
									System.out.print("�� Bronze ��� �ִ밪 : ");
									bronze.maxPrice = input.nextInt();
								} else if (choiceBronze == 2) { // ����� ��� ���� �κ�
									System.out.println("���� ��� Bronze ���� ����\n");
									System.out.println("�� 1. �ּҰ� ����\n�� 2. �ִ밪 ����");
									System.out.print("�� �Է� : ");
									int subchoiBronze = input.nextInt();
									if (subchoiBronze > 0 && subchoiBronze < 3) {
										if (subchoiBronze == 1) { // ����� ��� �κ� ���� ���� �κ�
											System.out.print("�� �ּҰ� ���� : ");
											bronze.minPrice = input.nextInt();
											System.out.println(bronze);
										} else if (subchoiBronze == 2) {
											System.out.print("�� �ִ밪 ���� : ");
											bronze.maxPrice = input.nextInt();
											System.out.println(bronze);
										}
									}
								} else {
									System.out.println("�� �߸��� �Է��Դϴ�");
								}
							} else if (rankMenu == 3) { // �ǹ� ���
								membershipSubMunu();
								int choiceSilver = input.nextInt();
								if (choiceSilver == 1) { // �ǹ� ��� ��� �κ�
									System.out.println("���� ��� Silver ����\n");
									System.out.print("�� Silver ��� �ּҰ� : ");
									silver.minPrice = input.nextInt();
									System.out.print("�� Silver ��� �ִ밪 : ");
									silver.maxPrice = input.nextInt();
								} else if (choiceSilver == 2) { // �ǹ� ��� ���� �κ�
									System.out.println("���� ��� Bronze ���� ����\n");
									System.out.println("�� 1. �ּҰ� ����\n�� 2. �ִ밪 ����");
									System.out.print("�� �Է� : ");
									int subchoiSilver = input.nextInt();
									if (subchoiSilver > 0 && subchoiSilver < 3) {
										if (subchoiSilver == 1) { // �ǹ� ��� �κ� ���� ���� �κ�
											System.out.print("�� �ּҰ� ���� : ");
											silver.minPrice = input.nextInt();
											System.out.println(silver);
										} else if (subchoiSilver == 2) {
											System.out.print("�� �ִ밪 ���� : ");
											silver.maxPrice = input.nextInt();
											System.out.println(silver);
										}
									}
								} else {
									System.out.println("�� �߸��� �Է��Դϴ�");
								}
							} else if (rankMenu == 4) { // ��� ���
								membershipSubMunu();
								int choiceGold = input.nextInt();
								if (choiceGold == 1) {
									System.out.println("���� ��� Gold ����\n");
									System.out.print("�� Gold ��� �ּҰ� : ");
									gold.minPrice = input.nextInt();
									System.out.print("�� Gold ��� �ִ밪 : ");
									gold.maxPrice = input.nextInt();
								} else if (choiceGold == 2) { // ��� ��� ���� �κ�
									System.out.println("���� ��� Gold ���� ����\n");
									System.out.println("�� 1. �ּҰ� ����\n�� 2. �ִ밪 ����");
									System.out.print("�� �Է� : ");
									int subchoiGold = input.nextInt();
									if (subchoiGold > 0 && subchoiGold < 3) {
										if (subchoiGold == 1) { // ��� ��� �κ� ���� ���� �κ�
											System.out.print("�� �ּҰ� ���� : ");
											gold.minPrice = input.nextInt();
											System.out.println(gold);
										} else if (subchoiGold == 2) {
											System.out.print("�� �ִ밪 ���� : ");
											gold.maxPrice = input.nextInt();
											System.out.println(gold);
										}
									}
								} else {
									System.out.println("�� �߸��� �Է��Դϴ�");
								}
							} else if (rankMenu == 5) { // ������
								break;
							}
						} else if (memMenu == 2) { // ����� ��� ���� �� ��޵� ���ߵǴµ� �����ؾ��ϳ�...
							membershipview();
							int membershipviewMenu = input.nextInt();
							if (membershipviewMenu == 1) {
								System.out.println(guest);
							} else if (membershipviewMenu == 2) {
								System.out.println(bronze);
							} else if (membershipviewMenu == 3) {
								System.out.println(silver);
							} else if (membershipviewMenu == 4) {
								System.out.println(gold);
							} else if (membershipviewMenu == 5) {
								break;
							}
						} else if (memMenu == 3) { // ����� ������
							break;
						}
					}
				}
				if (mainMenuChoice == 3) { // ���α׷� ����
					System.out.println("�� ���α׷��� �����Ͻðڽ��ϱ� ? ");
					System.out.println("�� 1. ����\n�� 2. ���");
					int programoff = input.nextInt();
					if (programoff > 0 && programoff < 3) {
						if (programoff == 1) {
							System.out.println("�� ���α׷� ���� ��");
							break;

						}
					}
				} else {
					System.out.println(" �߸��� �Է��Դϴ�.");
					System.out.println();
					continue;
				}
			}
		}
	}

	public static void mainMenu() {
		System.out.println("\n������� �޴� �������" + "\n�� 1. �� ���� ���� " + "\n�� 2. �����  ����  " + "\n�� 3. ���α׷� ����  "
				+ "\n������������������");
	}

	public static void customersMunu() {
		System.out.println("\n������ �� ���� ������" + "\n�� 1. �ű� �� �Է�" + "\n�� 2. �� ���� ����" + "\n�� 3. �� ���� ����"
				+ "\n�� 4. �� ��� ����" + "\n�� 5. ������" + "\n�������������������");
	}

	public static void membershipMenu() {
		System.out.println(
				"\n����� ����� ���� �����" + "\n�� 1. ����� ��� �Է�" + "\n�� 2. ����� ��� ����" + "\n�� 3. ������" + "\n�������������������");
	}

	public static void membershiprank() {
		System.out.print("\n���� ����� ��� ����" + "\n 1. [Guest  ����]" + "\n 2. [Bronze ����]" + "\n 3. [Silver ����]"
				+ "\n 4. [Gold   ����]" + "\n 5. [����   ������]" + "\n�������������������" + "\n�� �Է� : ");
	}

	public static void membershipview() {
		System.out.print("\n����� ����� ��� �����" + "\n 1. [Guest  ����]" + "\n 2. [Bronze ����]" + "\n 3. [Silver ����]"
				+ "\n 4. [Gold   ����]" + "\n 5. [      ������]" + "\n�������������������" + "\n�� �Է� : ");
	}

	public static void membershipSubMunu() {
		System.out.print("\n���� ����� ��� ����" + "\n�� 1. ��� ���" + "\n�� 2. ��� ����" + "\n�������������������" + "\n�� �Է� : ");

	}

	public static void viewCustList() {
		System.out.print("\n���� �� ��� ���� ����" + "\n 1. [Guest  ��]" + "\n 2. [Bronze ��]" + "\n 3. [Silver ��]"
				+ "\n 4. [Gold   ��]" + "\n 5. [      ������]" + "\n�������������������" + "\n�� �Է� : ");
	}

	
	

}
