package greedy;

class activity implements Comparable{
	int start;
	int end;
	public activity(int start,int end) {
		this.start=start;
		this.end=end;
	}
	@Override
	public int compareTo(Object arg0) {
		activity a=(activity)arg0;
		if(this.end==a.end) {
			return 0;
		}
		else if(this.end<a.end) {
			return -1;
		}
		return 1;
	}
}
public class max_activity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s[] =  {10,12,20}; 
	    int f[] =  {20,25,30}; 
	    int l=s.length;
	    activity[] arr=new activity[l];
	    int i;
	    for(i=0;i<l;i++) {
	    	arr[i]=new activity(s[i],f[i]);
	    }
	    func(arr);
	}
	//when activities  are sorted by end time
	public static void func(activity[] arr) {
		int i,l=arr.length,last=0;
		System.out.print(0+" ");
		for(i=1;i<l;i++) {
			if(arr[i].start>=arr[last].end) {
				System.out.print(i+" ");
				last=i;
			}
		}
	}

}
