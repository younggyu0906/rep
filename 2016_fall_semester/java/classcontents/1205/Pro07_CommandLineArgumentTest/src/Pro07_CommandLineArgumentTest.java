
public class Pro07_CommandLineArgumentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < args.length; i++)
			System.out.println(args[i]);
		
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		
		System.out.println(n1 + n2);
	}

}
//Run -> RunConfiguration -> Arguments ���� ����