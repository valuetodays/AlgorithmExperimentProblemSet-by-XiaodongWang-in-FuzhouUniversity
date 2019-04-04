#include<iostream.h>
#include<iomanip.h>
class color{
	friend int mcoloring(int,int);
	private:
		int ok(int k);
		void backtrack(int t);
		int n,				//图的顶点数
			m,				//可用颜色数
			a[5][5],           //图的邻接矩阵
	        *x;               //当前解
		int	long  sum ;      //当前已找到的可m着色方案
};
int color::ok(int k)
{//检查颜色可用性
	for(int j=1;j<=n;j++)
		if ((a[k][j]==1)&&(x[j]==x[k])) return 0;
		return 1;
}
void color::backtrack(int t)
{
	if(t>n){
		sum++;
		cout<<setw(4)<<sum<<':';
		for(int i=1;i<=n;i++)
			cout<<x[i]<<' ';		
		cout<<endl;
	}
	else
		for(int i=1;i<=m;i++){
			x[t]=i;
			if(ok(t)) backtrack(t+1);
		}		
}
int mcoloring(int n,int m)
{   color X; //初始化
	int a[5][5]={{0,1,1,1,0},{1,0,1,1,1},{1,1,0,1,0},{1,1,1,0,1},{0,1,0,1,0}};
	for (int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			X.a[i][j]=a[i][j];
			cout<<a[i][j]<<' ';
		}
		cout<<endl;
	}
	
	X.n=n;
	X.m=m;
	X.sum=0;
	int *p=new int[n+1];
	for(i=1;i<=n;i++)
		p[i]=0;
	X.x=p;
	X.backtrack(1);
	delete []p;
	return X.sum;
}
void  main()
{   int n=5,m=5;	
	mcoloring(n,m);
}