package comp_important;

public class KMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isPattern("abc","deabcabcd");
		

	}
	public static int[] lpsFunction(String str) {
		char[] c=str.toCharArray();
		int l=str.length();
		int[] lps=new int[l];
		lps[0]=0;
		int i=1,len=0;
		while(i<l) {
			if(c[i]==c[len]) {
				len++;
				lps[i]=len;
				i++;
			}else {
				if(len!=0) {
					len=lps[len-1];
				}else{
					lps[i]=len;
					i++;
				}
			}
		}
		return lps;
	}
	public static void isPattern(String pat,String txt) {
		int[] lps=lpsFunction(pat);
		int M=pat.length();
		int N=txt.length();
		int i=0,j=0;
		while(i<N) {
			if(txt.charAt(i)==pat.charAt(j)) {
				i++;
				j++;
			}if(j==M) {
				System.out.println("found pattern at index:"+(i-j));
				j=lps[j-1];
			}else if(i<N && txt.charAt(i)!=pat.charAt(j)){
				if(j!=0) {
					j=lps[j-1];
				}
				else {
					i++;
				}
			}
		}
	}
}
