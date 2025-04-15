#include <bits/stdc++.h>
#define MOD 998244353
using namespace std;
typedef long long int ll;

int A[12345] = {0};
ll dp[12345] = {0}; 

int main(){
	cin.sync_with_stdio(false);
	cin.tie(NULL);
	
	for(int i=0; i<12345; i++) dp[i] = 1;
	
	int N;
	cin >> N;
	for(int i=0; i<N; i++){
		cin >> A[i];
	}
	
	for(int i=1; i<N; i++){
		for(int j=0; j<i; j++){
			if(A[j] < A[i]){
				dp[i] += dp[j];
				dp[i] %= MOD;
			}
		}
	}
	
	for(int i=0; i<N; i++){
		cout << dp[i] << " ";
	}
	return 0;
}