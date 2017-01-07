import java.text.SimpleDateFormat;
import java.util.Calendar;

public class test {

	public static void main(String[] args) {
		String time = "20170101";
		Calendar today = Calendar.getInstance();
		today.set(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH));
		System.out.println("today = " + new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date(today.getTimeInMillis())));
		Calendar date = Calendar.getInstance();
		date.set(Integer.parseInt(time.substring(0, 4)), Integer.parseInt(time.substring(4, 6))-1, Integer.parseInt(time.substring(6)));
		System.out.println("date = " + new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date(date.getTimeInMillis())));
		System.out.println(today.getTimeInMillis() <= date.getTimeInMillis());
		
//		System.out.println(new java.util.Date("2017/01/07"));
//		System.out.println(new java.util.Date("2017/01/07").getTime()<new java.util.Date("2017/01/07").getTime());
//		Calendar c = Calendar.getInstance();
//		c.set(2017, 1, 7);
//		System.out.println(c.getTime().getTime());
//		Calendar d = Calendar.getInstance();
//		d.set(2017, 1, 6);
//		System.out.println(d.getTime().getTime());
		
//		for(int i = 2;i <= 31;i++){
//			System.out.println("calendarBean.setDate" + i + "(4);");
//		}
		
		
//		System.out.print("switch(Integer.parseInt(day)){");
//		for(int i = 1;i <=31;i++){
//			System.out.println("case " + i + ":");
//			System.out.println("cb.setDate" + i + "(Integer.getInteger(value));");
//			System.out.println("break;");
//		}
//		System.out.println("}");
	}

}
