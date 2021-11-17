package projectExample;

import java.util.Arrays;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.*;

public class SmartStore { // 해결할 것 : 1. 신규 저장 초기화 2. -1 입력시 처음으로 돌리는것 3. 등급별로 고객 등급리스트 출력 4. 입력받는 곳이 너무 많음
							// 5. 멤버쉽 등급값 리턴 하기
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
		Customer[] customers = new Customer[100]; // 고객 정보
		// ArrayList<Customer> customers = new ArrayList<>(); 이건 아직 내가 구현못함 어려움;

		for (int i = 0; i < customers.length; i++) {
			customers[i] = new Customer();
		}
		while (true) {
			mainMenu(); // 첫화면 메뉴
			System.out.print("◇ 입력 : ");
			int mainMenuChoice = input.nextInt();
			System.out.println();
			if (mainMenuChoice >= 1 || mainMenuChoice <= 3) {
				if (mainMenuChoice == 1) { // 고객정보

					while (true) {

						customersMunu(); // 고객 정보 메뉴
						System.out.print("◇ 입력 : ");
						int custoMenuChoice = input.nextInt();

						if (custoMenuChoice >= 1 || custoMenuChoice <= 5) {
							if (custoMenuChoice == 1) { // 고객 정보 입력
								System.out.print("\n◇ 신규 고객 수 : "); // 문제점 : 신규 고객이 입력될때마다 이전 고객 데이터 삭제됨
								int newCustNum = input.nextInt();

								for (int i = 0; i < newCustNum; i++) {

									customers[count].customerNumber = count + 1;
									System.out.printf("\n□□□□□ %1d 고객 입력 □□□□□\n", customers[count].customerNumber);
									System.out.print("◇ 이름 : "); // 예시를 보여주고 입력 : 란을 따로 설정하는게 좋을 듯
									customers[count].name = input.next();
									System.out.println("◇ 생년월일 : ex) 880101 (생년월일은 6자리로 기재해주세요.)");
									System.out.print("◇ 입력 : "); // 생년월일로 변경
									customers[count].dob = input.next();
									System.out.println("◇ 연락처 : ex) 0123456780 ('-' 없이 개지해주세요.)");
									System.out.print("◇ 입력 : "); // 폰번호 String 으로 변경
									customers[count].phoneNumber = input.next();
									System.out.println("◇ 성별을 입력하세요"); // 1. 남성 2. 여성 선택으로 변경
									System.out.println("◇ 1. 남성 \n◇ 2. 여성 ");
									System.out.print("◇ 입력 : ");
									int choiceGender = input.nextInt();
									if (choiceGender > 0 && choiceGender < 3) {
										if (choiceGender == 1) {
											System.out.println("◇ 남성 등록 ◇");
											customers[count].gender = "남성";
										} else if (choiceGender == 2) {
											System.out.println("◇ 여성 등록 ◇");
											customers[count].gender = "여성";
										}
									} else {
										System.out.println("◇ 잘못된 선택입니다.");
									}

									System.out.print("◇ 구매액 : "); // 구매가격에 , 자리수 입력 변경 계획
									price = input.nextInt();
									customers[count].price = price;
									for (int j = 0; j < customers.length; j++) {
										if (price > guest.minPrice && price <= guest.maxPrice) {
											customers[i].nameMember = "Guest"; // print 출력은 되는데 ...
										} else if (price > bronze.minPrice && price <= bronze.maxPrice) {
											customers[i].nameMember = "Bronze";
										} else if (price > silver.minPrice && price <= silver.maxPrice) {
											customers[i].nameMember = "Silver";
										} else if (price > gold.minPrice && price <= gold.maxPrice) {
											customers[i].nameMember = "Gold";
										} else {
											customers[i].nameMember = "미지정";
										}
									}

									System.out.println("\n◇ 저장하시겠습니까? 1. YES 2. NO");
									System.out.print("◇ 입력 : ");
									int save = input.nextInt();
									if (save == 1 || save == 2) {
										if (save != 1) {
											System.out.println("◇ 취소되었습니다.");
											// count 를 안함으로써 다음 고객 입력시 위에 덮어씌움 그렇게 저장하는 방식..
										} else {
											System.out.println("◇ 저장되었습니다.");
											count++;
										}
									} else {
										System.out.println("\n잘못된 입력입니다.");
									}
								}
							} else if (custoMenuChoice == 2) { // 고객 정보 변경 메뉴
								System.out.print("◇ 고객 이름을 입력하세요 : ");
								String searchName = input.next();
								for (int i = 0; i < 1; i++) {
									int editCus = Arrays.asList(customers[i].name).indexOf(searchName); // 아.. 인덱스는 아는데
									System.out.println(customers[editCus]);

									System.out.println("\n□□□□□ 고객 정보 변경 □□□□□"); // 정보를 변경할 부분을 지정으로 변경 계획
									System.out.print("◇ 0. 나가기◇\n◇ 변경할 사항을 선택하세요 : ");
									int changeDate = input.nextInt();
									if (changeDate >= 0 || changeDate <= 5) {
										if (changeDate == 1) {
											System.out.print("◇ 고객 이름 변경 : ");
											customers[editCus].name = input.next();
										} else if (changeDate == 2) {
											System.out.print("◇ 고객 나이 변경 : ");
											customers[editCus].dob = input.next();
										} else if (changeDate == 3) {
											System.out.println("◇ 성별을 변경하세요"); // 1. 남성 2. 여성 선택으로 변경
											System.out.println("◇ 1. 남성 \n◇ 2. 여성 ");
											System.out.print("◇ 입력 : ");
											int choiceGender = input.nextInt();
											if (choiceGender > 0 && choiceGender < 3) {
												if (choiceGender == 1) {
													System.out.println("◇ 남성 변경 ◇");
													customers[editCus].gender = "남성";
												} else if (choiceGender == 2) {
													System.out.println("◇ 여성 변경 ◇");
													customers[editCus].gender = "여성";
												}
											} else {
												System.out.println("◇ 잘못된 선택입니다.");
												continue;
											}
										} else if (changeDate == 4) {
											System.out.print("◇ 연락처 변경 : ");
											customers[editCus].phoneNumber = input.next();
										} else if (changeDate == 5) {
											System.out.print("◇ 고객 구매액 변경 : "); // 구매가격에 , 자리수 입력 변경 계획
											customers[editCus].price = input.nextInt();
										} else if (changeDate == 6) {
											System.out.println("\n변경이 불가능합니다.");
											continue;
										} else if (changeDate == 0) {
											break;
										} else {
											System.out.println("\n잘못된 입력입니다.");
										}
									}
								}
							}

							else if (custoMenuChoice == 3) { // 고객 정보 보기 메뉴
								for (int i = 0; i < customers.length; i++) {
									if (price > guest.minPrice && price <= guest.maxPrice) {
										customers[i].nameMember = "Guest"; // print 출력은 되는데 ...
									} else if (price > bronze.minPrice && price <= bronze.maxPrice) {
										customers[i].nameMember = "Bronze";
									} else if (price > silver.minPrice && price <= silver.maxPrice) {
										customers[i].nameMember = "Silver";
									} else if (price > gold.minPrice && price <= gold.maxPrice) {
										customers[i].nameMember = "Gold";
									}
								}
								System.out.print("□□□□□□ 검색 □□□□□□\n◇ 1. 고객번호 검색\n◇ 2. 이름 검색\n◇ 3. 연락처 검색\n◇ 입력 : ");
								int searchCust = input.nextInt();
								if (searchCust >= 1 || searchCust <= 3) {
									if (searchCust == 1) {
										System.out.print("◇ 고객번호를 입력하세요 : "); // 고객 정보 검색 고객번호 외 이름, 핸폰번호, 멤버쉽 등급
										int userDatanum = input.nextInt();
										System.out.println("□□□□□ 고객 정보 □□□□□");
										System.out.println(customers[userDatanum - 1]);
										System.out.println();
									} else if (searchCust == 2) {
										System.out.print("◇ 고객이름을 입력하세요 : ");
										String searchName = input.next();
										for (int i = 0; i < 1; i++) {
											i = Arrays.asList(customers[i].name).indexOf(searchName); // 아.. 인덱스는 아는데
																										// 출력은...어케하지...
											System.out.println(customers[i]); // 나름 성공함..;;
										}
									} else if (searchCust == 3) {
										System.out.print("◇ 고객 연락처 입력하세요 : ");
										String searchName = input.next();
										for (int i = 0; i < 1; i++) {
											i = Arrays.asList(customers[i].phoneNumber).indexOf(searchName); // 아.. 인덱스는
																												// 아는데
											// 출력은...어케하지...
											System.out.println(customers[i]); // 나름 성공함..;;
										}
									}

								} else {
									System.out.println("◇ 잘못된 입력입니다.");
									continue;
								}
							} else if (custoMenuChoice == 4) {
								for (int i = 0; i < customers.length; i++) {
									if (price > guest.minPrice && price <= guest.maxPrice) {
										customers[i].nameMember = "Guest"; // print 출력은 되는데 ...
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
										System.out.println("□□□□□□ Guest □□□□□□");
										System.out.print("◇ 출력 갯수 : ");
										int pirintMem = input.nextInt();
										for (int i = 0; i < pirintMem; i++) {
											Arrays.asList(customers[i].nameMember).indexOf("Guest");
											System.out.println(customers[i]);
											continue;
										}
									} else if (viewMemRank == 2) {
										System.out.println("□□□□□□ Bronze □□□□□□");
										System.out.print("◇ 출력 갯수 : ");
										int pirintMem = input.nextInt();
										for (int i = 0; i < pirintMem; i++) {
											Arrays.asList(customers[i].nameMember).indexOf("Bronze");
											System.out.println(customers[i]);
											continue;
										}
									} else if (viewMemRank == 3) {
										System.out.println("□□□□□□ Silver □□□□□□");
										System.out.print("◇ 출력 갯수 : ");
										int pirintMem = input.nextInt();
										for (int i = 0; i < pirintMem; i++) {
											Arrays.asList(customers[i].nameMember).indexOf("Silver");
											System.out.println(customers[i]);
											continue;
										}
									} else if (viewMemRank == 4) {
										System.out.println("□□□□□□ Gold □□□□□□");
										System.out.print("◇ 출력 갯수 : ");
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
								System.out.println("\n잘못된 입력입니다.");
								continue;
							}
						}
					}
				}
				if (mainMenuChoice == 2) { // 멤버쉽 관리 // @@@@문제점 : 등급액 변경시 적용이 안됨

					while (true) {
						membershipMenu();
						System.out.print("◇ 입력 : ");
						int memMenu = input.nextInt();

						if (memMenu == 1) { // 멤버쉽 등급 설정 //문제점 : 대대적인 수정 필요 너무 같은 작업이 많음 사용자가 쓰기 불편함
							membershiprank();
							int rankMenu = input.nextInt(); // 구매액만 있으면 될듯

							if (rankMenu == 1) { // 게스트 등급
								membershipSubMunu();
								int choiceGuest = input.nextInt();
								if (choiceGuest == 1) { // 게스트 등급 등록
									System.out.println("□□□ 등급 Guest 등록 □□□\n");
									System.out.print("◇ Guest 등급 최소값 : ");
									guest.minPrice = input.nextInt();
									System.out.print("◇ Guest 등급 최대값 : ");
									guest.maxPrice = input.nextInt();
									System.out.println(guest);
								} else if (choiceGuest == 2) { // 게스트 등급 부분 변경 부분
									System.out.println("□□□ 등급 Guest 변경 □□□\n");
									System.out.println(guest);
									System.out.println("◇ 1. 최소값 변경\n◇ 2. 최대값 변경");
									System.out.print("◇ 입력 : ");
									int subchoiGuest = input.nextInt();
									if (subchoiGuest > 0 && subchoiGuest < 3) {
										if (subchoiGuest == 1) { // 게스트 부분 선택 변경 부분
											System.out.println("◇ 변경 전 : " + guest.minPrice);
											System.out.print("◇ 최소값 변경 : ");
											guest.minPrice = input.nextInt();
											System.out.println(guest);
										} else if (subchoiGuest == 2) {
											System.out.println("◇ 변경 전 : " + guest.maxPrice);
											System.out.print("◇ 최대값 변경 : ");
											guest.maxPrice = input.nextInt();
											System.out.println(guest);
										}
									}
								} else {
									System.out.println("◇ 잘못된 입력입니다");
								}
							} else if (rankMenu == 2) { // 브론즈 등급
								membershipSubMunu();
								int choiceBronze = input.nextInt();
								if (choiceBronze == 1) { // 브론즈 등급 등록
									System.out.println("□□□ 등급 Bronze □□□\n");
									System.out.print("◇ Bronze 등급 최소값 : ");
									bronze.minPrice = input.nextInt();
									System.out.print("◇ Bronze 등급 최대값 : ");
									bronze.maxPrice = input.nextInt();
								} else if (choiceBronze == 2) { // 브론즈 등급 변경 부분
									System.out.println("□□□ 등급 Bronze 변경 □□□\n");
									System.out.println("◇ 1. 최소값 변경\n◇ 2. 최대값 변경");
									System.out.print("◇ 입력 : ");
									int subchoiBronze = input.nextInt();
									if (subchoiBronze > 0 && subchoiBronze < 3) {
										if (subchoiBronze == 1) { // 브론즈 등급 부분 변경 선택 부분
											System.out.print("◇ 최소값 변경 : ");
											bronze.minPrice = input.nextInt();
											System.out.println(bronze);
										} else if (subchoiBronze == 2) {
											System.out.print("◇ 최대값 변경 : ");
											bronze.maxPrice = input.nextInt();
											System.out.println(bronze);
										}
									}
								} else {
									System.out.println("◇ 잘못된 입력입니다");
								}
							} else if (rankMenu == 3) { // 실버 등급
								membershipSubMunu();
								int choiceSilver = input.nextInt();
								if (choiceSilver == 1) { // 실버 등급 등록 부분
									System.out.println("□□□ 등급 Silver □□□\n");
									System.out.print("◇ Silver 등급 최소값 : ");
									silver.minPrice = input.nextInt();
									System.out.print("◇ Silver 등급 최대값 : ");
									silver.maxPrice = input.nextInt();
								} else if (choiceSilver == 2) { // 실버 등급 변경 부분
									System.out.println("□□□ 등급 Bronze 변경 □□□\n");
									System.out.println("◇ 1. 최소값 변경\n◇ 2. 최대값 변경");
									System.out.print("◇ 입력 : ");
									int subchoiSilver = input.nextInt();
									if (subchoiSilver > 0 && subchoiSilver < 3) {
										if (subchoiSilver == 1) { // 실버 등급 부분 변경 선택 부분
											System.out.print("◇ 최소값 변경 : ");
											silver.minPrice = input.nextInt();
											System.out.println(silver);
										} else if (subchoiSilver == 2) {
											System.out.print("◇ 최대값 변경 : ");
											silver.maxPrice = input.nextInt();
											System.out.println(silver);
										}
									}
								} else {
									System.out.println("◇ 잘못된 입력입니다");
								}
							} else if (rankMenu == 4) { // 골드 등급
								membershipSubMunu();
								int choiceGold = input.nextInt();
								if (choiceGold == 1) {
									System.out.println("□□□ 등급 Gold □□□\n");
									System.out.print("◇ Gold 등급 최소값 : ");
									gold.minPrice = input.nextInt();
									System.out.print("◇ Gold 등급 최대값 : ");
									gold.maxPrice = input.nextInt();
								} else if (choiceGold == 2) { // 골드 등급 변경 부분
									System.out.println("□□□ 등급 Gold 변경 □□□\n");
									System.out.println("◇ 1. 최소값 변경\n◇ 2. 최대값 변경");
									System.out.print("◇ 입력 : ");
									int subchoiGold = input.nextInt();
									if (subchoiGold > 0 && subchoiGold < 3) {
										if (subchoiGold == 1) { // 골드 등급 부분 변경 선택 부분
											System.out.print("◇ 최소값 변경 : ");
											gold.minPrice = input.nextInt();
											System.out.println(gold);
										} else if (subchoiGold == 2) {
											System.out.print("◇ 최대값 변경 : ");
											gold.maxPrice = input.nextInt();
											System.out.println(gold);
										}
									}
								} else {
									System.out.println("◇ 잘못된 입력입니다");
								}
							} else if (rankMenu == 5) { // 나가기
								break;
							}
						} else if (memMenu == 2) { // 멤버쉽 등급 보기 고객 등급도 봐야되는데 어찌해야하나...
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
						} else if (memMenu == 3) { // 멤버쉽 나가기
							break;
						}
					}
				}
				if (mainMenuChoice == 3) { // 프로그램 종료
					System.out.println("◇ 프로그램을 종료하시겠습니까 ? ");
					System.out.println("◇ 1. 종료\n◇ 2. 취소");
					int programoff = input.nextInt();
					if (programoff > 0 && programoff < 3) {
						if (programoff == 1) {
							System.out.println("◇ 프로그램 종료 ◇");
							break;

						}
					}
				} else {
					System.out.println(" 잘못된 입력입니다.");
					System.out.println();
					continue;
				}
			}
		}
	}

	public static void mainMenu() {
		System.out.println("\n□□□□□□ 메뉴 □□□□□□" + "\n◇ 1. 고객 정보 관리 " + "\n◇ 2. 멤버쉽  관리  " + "\n◇ 3. 프로그램 종료  "
				+ "\n□□□□□□□□□□□□□□□□□");
	}

	public static void customersMunu() {
		System.out.println("\n□□□□□ 고객 정보 □□□□□" + "\n◇ 1. 신규 고객 입력" + "\n◇ 2. 고객 정보 변경" + "\n◇ 3. 고객 정보 보기"
				+ "\n◇ 4. 고객 등급 보기" + "\n◇ 5. 나가기" + "\n□□□□□□□□□□□□□□□□□□");
	}

	public static void membershipMenu() {
		System.out.println(
				"\n□□□□ 멤버쉽 정보 □□□□" + "\n◇ 1. 멤버쉽 등급 입력" + "\n◇ 2. 멤버쉽 등급 보기" + "\n◇ 3. 나가기" + "\n□□□□□□□□□□□□□□□□□□");
	}

	public static void membershiprank() {
		System.out.print("\n□□□ 멤버쉽 등급 □□□" + "\n 1. [Guest  설정]" + "\n 2. [Bronze 설정]" + "\n 3. [Silver 설정]"
				+ "\n 4. [Gold   설정]" + "\n 5. [설정   나가기]" + "\n□□□□□□□□□□□□□□□□□□" + "\n◇ 입력 : ");
	}

	public static void membershipview() {
		System.out.print("\n□□□□ 멤버쉽 등급 □□□□" + "\n 1. [Guest  보기]" + "\n 2. [Bronze 보기]" + "\n 3. [Silver 보기]"
				+ "\n 4. [Gold   보기]" + "\n 5. [      나가기]" + "\n□□□□□□□□□□□□□□□□□□" + "\n◇ 입력 : ");
	}

	public static void membershipSubMunu() {
		System.out.print("\n□□□ 멤버쉽 등급 □□□" + "\n◇ 1. 등급 등록" + "\n◇ 2. 등급 변경" + "\n□□□□□□□□□□□□□□□□□□" + "\n◇ 입력 : ");

	}

	public static void viewCustList() {
		System.out.print("\n□□□ 고객 등급 보기 □□□" + "\n 1. [Guest  고객]" + "\n 2. [Bronze 고객]" + "\n 3. [Silver 고객]"
				+ "\n 4. [Gold   고객]" + "\n 5. [      나가기]" + "\n□□□□□□□□□□□□□□□□□□" + "\n◇ 입력 : ");
	}

	
	

}
