package divide_and_conquer;

public class longest_commmon_prefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr= {"geeks","geeksforgeeks","geekyman","geez"};
		System.out.println(lcp(arr,0,arr.length-1));

	}
	public static String lcp(String[] arr,int l,int h) {
		if(l==h) {
			return arr[l];
		}
		int m=(l+h)/2;
		String s1=lcp(arr,l,m);
		String s2=lcp(arr,m+1,h);
		int l1=s1.length();
		int l2=s2.length();
		int length=l1<l2?l1:l2;
		int i;
		StringBuffer s=new StringBuffer();
		for(i=0;i<length;i++) {
			if(s1.charAt(i)==s2.charAt(i)) {
				s.append(s1.charAt(i));
			}else {
				break;
			}
		}
		return s.toString();
	}

}
