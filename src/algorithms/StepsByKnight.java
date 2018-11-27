package algorithms;

import java.util.*;
import java.lang.*;

class cell{
    int x,y,dis;
    public cell(int x,int y,int dis){
        this.x=x;this.y=y;this.dis=dis;
    }
}
class StepsByKnight {
	public static boolean isValid(int i,int j,int n,int m){
        return (i>=1 && j>=1 && i<=n && j<=m);
    }
    public static int minKnightPath(int s1,int d1,int s2,int d2,int n,int m){
        boolean visit[][] = new boolean[n+1][m+1];
        int row[] = {-2, -1, 1, 2, -2, -1, 1, 2};
        int col[] = {-1, -2, -2, -1, 1, 2, 2, 1};
        Queue<cell> q = new LinkedList<>();
        q.add(new cell(s1,d1,0));
        visit[s1][d1] = true;
        while(!q.isEmpty()){
            cell t = q.remove();
            if(t.x == s2 && t.y == d2){
                return t.dis;
            }
            for(int k=0;k<8;k++){
                int x = t.x+row[k];
                int y = t.y+col[k];
                if(isValid(x,y,n,m) && !visit[x][y]){
                    visit[x][y] = true;
                    q.add(new cell(x,y,t.dis+1));
                }
            }
        }
        return 1;
    }
	public static void main (String[] args) {
		//code
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t>0){
		    int n = s.nextInt();
		    int s1 = s.nextInt(),d1=s.nextInt();
		    int s2=s.nextInt(),d2=s.nextInt();
		    System.out.println(minKnightPath(s1,d1,s2,d2,n,n));
		    t--;
		}
	}
}