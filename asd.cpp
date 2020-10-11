#include<bits/stdc++.h>
#define ll          long long
#define ld          long double
#define mod         (1000000000+7)
#define ull         unsigned long long
#define pb          push_back
#define	endl		'\n'
#define pi          acos(-1)
#define pii         pair<ll int,ll int>
#define all(a)      (a).begin(),(a).end()
#define F           first
#define S           second
#define sz(x)       (ll int)x.size()
#define SIZE(X)     ((int)((X).size()))
#define hell        1000000007
#define rep(i,a,b)	for(ll int i=a;i<b;i++)
#define lbnd        lower_bound
#define ubnd        upper_bound
#define bs          binary_search
#define mp          make_pair
#define fo(i,s,n)  for(int i=s;i<n;i++)
#define FORE(i,s,n) for(int i=s;i<=n;i++)
#define rep(i,n) for(int i=0;i<(n);++i)
#define repf(i,a,b) for(int i=(a);i<=(b);++i)
#define ERASE(x)    x.erase(unique(x.begin(),x.end()),x.end()) //removes repeated element;
#define Fast        ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(0);

using namespace std;
const int N = 10010;
vector <ll> is_prime(N+1 , true);
bool sortinrev(const pair<int,int> &a,const pair<int,int> &b){return (a.first > b.first);}
bool sortbysecdesc(const pair<int,int> &a,const pair<int,int> &b){return a.second>b.second;}
bool sortbysec(const pair<int,int> &a,const pair<int,int> &b) {return (a.second < b.second);}
ll int pow(ll int x, ll int y) { ll int res = 1; while (y > 0) { if (y & 1) res = ((res) * (x)); res %= N; y = y >> 1; x = ((x) * (x)); } return res; }
ll int powm(ll int x, ll int y, ll int p)  { ll int res = 1; x = x % p; while (y > 0) {if (y & 1) res = (res * x) % p; y = y >> 1; x = (x * x) % p;}   return res; }
ll int power(ll int a , ll int b) { if(b == 1) return a; if(b == 0) return 1; ll int m1 = power(a,b/2); if(b%2) return m1*m1*a; return m1*m1; }
void seive_of_eras(ll n) { is_prime[0] = 0; is_prime[1] = 0; for(ll i=2;i*i<=n;i++) { if(is_prime[i]) { for(ll j=i*i;j<=n;j+=i) { is_prime[j] = false; } } } }
bool isprime (ll a) { if(a<=1) return false; if(a==2||a==3) return true; if(a%2==0||a%3==0) return false; for(ll i=5;i*i<=a;i=i+6) { if(a%i==0||a%(i+2)==0) return false; } return true;}

void codeit()
{
    ll n , k; cin>>n>>k;
    string s; cin>>s;
    if(k>0)
    {
        for(ll i=1;i<n-1;i++)
        {
            if(s[i]=='L'&&s[i+1]=='W'&&s[i-1]=='W' && k>0)
                s[i] = 'W' , k--;
            if(k<=0)
                break;
        }
    }
    //cout<<"SSS"<<" "<<s<<endl;
    for(ll i=0;i<n;)
    {
        if(s[i]=='L' && k>0)
        {
            ll j = i; ll c = 0;
            while(s[j]=='L'&&j<n)
            {//cout<<"W"<<endl;
                c++;
                j++;
            }
            //cout<<s[j]<<endl;
            //cout<<j<<" "<<c<<" "<<j-1<<" "<<j-c<<endl;
            if(c<=k)
            {
                k = k-c;
            }
            else
            {
                c = k;
                k = 0;
            }
            for(ll k=j-1;k>=j-c;k--){
                s[k] = 'W';}
            i = j;
        }
        else if(s[i]=='W'&&s[i+1]=='L' && k>0)
        {
            ll j = i+1; ll c = 0;
            while(s[j]=='L' && j<n)
            {
                c++; j++;
            }
            if(c<=k)
            {
                k = k-c;
            }
            else
            {
                c = k;
                k = 0;
            }
            for(ll k1=i+1;k1<c+i+1;k1++)
                s[k1] = 'W';
            i = j;
        }
        else
            i++;
    }
    //cout<<s<<endl;
    ll ans = 0;
    ll f = 0;
    for(ll i=0;i<n;i++)
    {
        if(s[i]=='W')
        {
            if(f==0)
            {
                ans += 1;
            }
            else
            {
                ans += 2;
            }
            f = 1;
        }
        else
            f = 0;
    }
    cout<<ans<<endl;
    return;
}

int main()
{
    //Fast
    //freopen("input.txt", "r", stdin);
    //freopen("output.txt", "w", stdout);
    ll tt; tt = 1;
    cin>>tt;
    for(ll i=0;i<tt;i++)
        codeit();

}

