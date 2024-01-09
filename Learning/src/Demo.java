

class St
{
	@Override
	protected void finalize() throws Throwable {
		System.out.println("GC");
	}
}
public class Demo {
	public static void main(String[] args) {
		
		St s1 = new St();
		St s2 = new St();
		s1=s2;
		
		System.gc();
	}
}
