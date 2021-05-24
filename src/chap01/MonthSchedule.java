package chap01;

import java.util.Scanner;

class Day{
	private String work;
	public void set(String work) {
		this.work =work;
	}
	public void show() {
		if(work==null)
			System.out.println("없습니다.");
		else System.out.println(work+"입니다.");
	}
}
public class MonthSchedule {
	private Scanner sc;
	private Day days[];
	
	MonthSchedule(int day){
		this.days =new Day[day];
		for(int i=0; i<days.length; i++) {
			days[i]=new Day();
		}
		sc =new Scanner(System.in);
	}
	private void input() {
		System.out.print("날짜(1~30)?");
		int day =sc.nextInt();
		System.out.println("할일(빈칸없이 입력)?");
		String work = sc.next();
		day--;
		if(day <0 ||day>30) {
			System.out.println("날짜를 잘못 입력하였습니다.");
			return;
		}
		days[day].set(work);
	}
	private void view() {
		System.out.print("날짜(1~30)?");
		int day = sc.nextInt();
		day--;
		if(day<0 ||day>30) {
			System.out.println("날짜를 잘못 입력하였습니다.");
			return;
		}
		System.out.println((day+1)+"일의 할 일은");
		days[day].show();
	}
	private void finish() {
		System.out.println("프로그램을 종료합니다.");
		sc.close();
	}
	public void run() {
		System.out.print("이번달 스케줄 관리 프로그램.");
		while(true) {
			System.out.println();
			System.out.print("할일(입력:1, 보기:2, 끝내기:3)>>");
			int select = sc.nextInt();
			switch(select) {
			case 1: input(); break;
			case 2: view(); break;
			case 3: finish(); break;
			}
		}
	}

	public static void main(String[] args) {
		MonthSchedule april = new MonthSchedule(30);
		april.run();
	}

}
