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

struct billboard
{
    int x1, y1, x2, y2;
};

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    freopen("billboard.in", "r", stdin);
    freopen("billboard.out", "w", stdout);
    billboard x, y, truck;
    cin >> x.x1 >> x.y1 >> x.x2 >> x.y2;
    cin >> y.x1 >> y.y1 >> y.x2 >> y.y2;
    cin >> truck.x1 >> truck.y1 >> truck.x2 >> truck.y2;
    int areaX = (x.x2 - x.x1) * (x.y2 - x.y1);
    int areaY = (y.x2 - y.x1) * (y.y2 - y.y1);
    int intersectXx = max(0, min(x.x2, truck.x2) - max(x.x1, truck.x1));
    int intersectYx = max(0, min(x.y2, truck.y2) - max(x.y1, truck.y1));
    int intersectXy = max(0, min(y.x2, truck.x2) - max(y.x1, truck.x1));
    int intersectYy = max(0, min(y.y2, truck.y2) - max(y.y1, truck.y1));
    int intersectx = intersectXx * intersectYx;
    int intersecty = intersectXy * intersectYy;
    cout << areaX + areaY - intersectx - intersecty;
    return 0;
}