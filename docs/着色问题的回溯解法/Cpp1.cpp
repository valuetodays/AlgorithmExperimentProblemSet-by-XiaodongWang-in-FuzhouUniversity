#include<iostream.h>
#include<iomanip.h>
class color{
	friend int mcoloring(int,int);
	private:
		int ok(int k);
		void backtrack(int t);
		int n,				//ͼ�Ķ�����
			m,				//������ɫ��
			a[5][5],           //ͼ���ڽӾ���
	        *x;               //��ǰ��
		int	long  sum ;      //��ǰ���ҵ��Ŀ�m��ɫ����
};
int color::ok(int k)
{//�����ɫ������
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
{   color X; //��ʼ��
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