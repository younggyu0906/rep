#include "KYGLineEditor.h"

void Usage() {
	printf("[메뉴선택] i-입력, d-삭제, r-변경, p-출력, l-파일읽기, s-저장, q-종료 => ");
}

void main() {
	CKYGLineEditor editor;
	char command;
	do {
		Usage();
		command = getchar();
		switch(command) {
		case 'd' : editor.DeletetLine(); break;
		case 'i' : editor.InsertLine(); break;
		case 'r' : editor.ReplaceLine(); break;
		case 'l' : editor.LoadFile("Test.txt"); break;
		case 's' : editor.StoreFile("Test.txt"); break;
		case 'p' : editor.Display(); break;
		case 'q' : break;
		}
		fflush(stdin);
	} while(command != 'q');
	getchar();
	getchar();
}