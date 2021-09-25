#include <bits/stdc++.h>

#define all(v) v.begin(), v.end()
#define rall(v) v.rbegin(), v.rend()
#define clr(arr) memset(arr, 0, sizeof(arr))
#define ff first
#define ss second
#define mp make_pair
#define pb push_back
#define rep(i, a, b) for (int i = a; i < b; i++)
#define MAX(a, b) ((a) > (b) ? (a) : (b))
#define MIN(a, b) ((a) < (b) ? (a) : (b))
#define ABS(x) ((x) < 0 ? -(x) : (x))

using namespace std;
using ll = long long;
using vi = vector<int>;
using vl = vector<long>;
using pii = pair<int, int>;
using pll = pair<long, long>;

const ll mod = 1000000007;

template <class T>
T gcd(T a, T b)
{
    if (b == 0)
        return a;
    return gcd(b, a % b);
}
template <class T>
T lcm(T a, T b) { return (a * b) / gcd(a, b); }
template <class T>
string converter(T n)
{
    stringstream x;
    x << n;
    return x.str();
}

//void swapi(int *a,int *b){int temp;temp=*a;*a=*b;*b=temp;}
//void swaps (char *x,char *y){char temp;temp=*x;*x=*y;*y=temp;}

/*
adnaneaabbar
*/

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    freopen("paint.in", "r", stdin);
    freopen("paint.out", "w", stdout);
    int n, m, k, t, x, y;
    /*
    cin >> t;
    while (t--)
    {
        cin >> n;
        vi a;
        int temp;
        rep(i, 0, n)
        {
            cin >> temp;
            a.pb(temp);
        }
    }
    */

    return 0;
}