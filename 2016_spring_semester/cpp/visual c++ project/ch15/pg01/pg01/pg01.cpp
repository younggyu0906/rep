#include <iostream>

using namespace std;
	
class BankAcct {//은행의 계좌를 나타내는 클래스
protected :
	int money, interest;//잔액과 이자를 나타내는 멤버 변수
public :
	BankAcct (int m = 0, int i = 0) {//BankAcct 생성자
		money = m;
		interest = i;
	}
	virtual int getInterest() = 0;//현재 계좌의 이자율을 반환하는 순수가상함수

	void deposit(int d) {//예금 함수
		money += d;
	}
	void withdraw(int w) {//출금 함수
		money -= w;
	}
	virtual void appInterest() = 0;//이자 적용 순수가상함수

	virtual void printMoney() = 0;//잔액을 출력하는 순수가상함수
};

class SavingAcct : public BankAcct {//이자율이 9%인 저츅 예금 계좌, BankAcct를 상속 받는다
public :
	SavingAcct(int m = 0) : BankAcct(m,9) {//SavingAcct생성자
	}
	virtual int getInterest() {//현재 계좌의 이자율을 반환하는 함수 재정의
		return interest;
	}
	virtual void appInterest() {//이자 적용 함수 재정의
		money += money * interest / 100;
	}
	virtual void printMoney() {//잔액 출력 함수 재정의
		cout << "잔액 : " << money << endl;
	}
};

class CheckingAcct : public BankAcct {//이자율이 5%인 당좌 예금 계좌, BankAcct를 상속 받는다
public :
	CheckingAcct(int m = 0) : BankAcct(m,5) {//CheckingAcct생성자
	}
	virtual int getInterest() {//현재 계좌의 이자율을 반환하는 함수 재정의
		return interest;
	}
	virtual void appInterest() {//이자 적용 함수 재정의
		money += money * interest / 100;
	}
	virtual void printMoney() {//잔액 출력 함수 재정의
		cout << "잔액 : " << money << endl;
	}
};

void main() {
	BankAcct * ba[2];//객체 포인터 배열 생성

	ba[0] = new SavingAcct(15000);//ba[0] 객체에 SavingAcct 객체를 동적으로 생성하여 저장
	ba[1] = new CheckingAcct(25000);//ba[1] 객체에 CheckingAcct 객체를 동적으로 생성하여 저장

	for(int i = 0; i < 2; i++) {
		cout << "현재 ";
		ba[i]->printMoney();//현재 잔액 출력

		ba[i]->deposit(5000);//입금
		cout << "입금 후 ";
		ba[i]->printMoney();//입금 후 잔액 출력
		
		ba[i]->withdraw(10000);//출금
		cout << "출금 후 ";
		ba[i]->printMoney();//출금 후 잔액 출력

		ba[i]->appInterest();//이자 적용
		cout << "이자 적용 후 ";
		ba[i]->printMoney();//이자적용 후 잔액 출력

		cout << "이자 : " << ba[i]->getInterest() << "%" << endl << endl;//이자율 출력
	}
};