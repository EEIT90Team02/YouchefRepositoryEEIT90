import java.util.ArrayList;
import java.util.List;

public class TESTT {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		List<Integer> ans = new ArrayList<>();
		for(int i = 0;i < 33;i++){
			list.add(i);
		}
		System.out.println(list);
		int total = list.size();	//總筆數
		int size = 10;				//每一頁顯示的筆數
		int page = 4;				//目前頁數
		int totalPage = total/size;	//總頁數
		if(total % size != 0){
			totalPage++;
		}
		System.out.println(totalPage);
		for(int i = 0;i < size;i++){	//迴圈跑每一頁顯示筆數的次數
			if(page != totalPage){		//判斷目前是否為最後一頁
				ans.add(list.get((size * page) - size + i));
			}else{
				System.out.println("Start to page 4");
				if(i == total % size){
					return;
				}
				int j = list.get((size * page) - size + i);
				System.out.println(j);
				ans.add(j);
				System.out.println("ans = " + ans);
			}
		}
		System.out.println(ans);
	}

}
