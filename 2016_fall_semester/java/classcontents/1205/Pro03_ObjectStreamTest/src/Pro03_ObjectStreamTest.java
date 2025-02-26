// 객체 단위 입출력을 하기 위한
// 클래스는 Serializable interface를 구현해야 한다
// file에 출력하는 경우를 직렬화(serialization)
// file에서 읽는 경우를 역직렬화(deserialization)
// 객페를 전송하기 위해서는 마샬링(marshalling)이 필요하다.(객체를 바이트 단위로 분해

import java.io.*;

class Student implements Serializable {
	private static final long serialVersionUID = 100L;
	private int id;
	private String name;
	
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public String toString() {
		return id + ", " + name;
	}
}
public class Pro03_ObjectStreamTest {
	public static void main(String[] args) {
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(
					new FileOutputStream("object.dat")));
			out.writeObject(new Student(1, "Hong"));	// IOException
			out.writeObject(new Student(2, "Kim"));
			out.writeObject(new Student(3, "Choi"));
			out.flush();
			
			in = new ObjectInputStream(new FileInputStream("object.dat"));
			
			System.out.println((Student)in.readObject());	// ClassNotFoundException
			// readObject() 는 Object를 리턴하기 때문에 형변환 필요
			System.out.println((Student)in.readObject());
			System.out.println((Student)in.readObject());
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		} catch (ClassNotFoundException e) {
			System.out.println("classNotFoundException");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException");
			System.out.println(e.getMessage());
		}
	}
}
