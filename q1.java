#include <unistd.h>
#include <stdio.h>
#include <limits.h>
int main(int argc,char **argv)
{
	int i,val;
	for(i=1;i<=5;i++)
	{
		printf("%s\n",argv[i]);
	}
} 