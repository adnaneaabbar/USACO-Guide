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

int countCovered(billboard test, billboard a)
{
    int count = 0;
    test.x1 >= a.x1 &&test.x1 <= a.x2 &&test.y1 >= a.y1 &&test.y1 <= a.y2 ? count++ : count;
    test.x1 >= a.x1 &&test.x1 <= a.x2 &&test.y2 >= a.y1 &&test.y2 <= a.y2 ? count++ : count;
    test.x2 >= a.x1 &&test.x2 <= a.x2 &&test.y2 >= a.y1 &&test.y2 <= a.y2 ? count++ : count;
    test.x2 >= a.x1 &&test.x2 <= a.x2 &&test.y1 >= a.y1 &&test.y1 <= a.y2 ? count++ : count;

    return count;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    freopen("billboard.in", "r", stdin);
    freopen("billboard.out", "w", stdout);
    billboard test, a;
    cin >> test.x1 >> test.y1 >> test.x2 >> test.y2;
    cin >> a.x1 >> a.y1 >> a.x2 >> a.y2;

    int c = countCovered(test, a);
    if (c == 4)
    {
        cout << 0;
    }
    else if (c == 0 or c == 1)
    {
        cout << (test.x2 - test.x1) * (test.y2 - test.y1);
    }
    else
    {
        int l = max(test.x1, a.x1);
        int r = min(test.x2, a.x2);

        int ll = max(test.y1, a.y1);
        int rr = min(test.y2, a.y2);

        int area = (rr - ll) * (r - l);

        cout << (test.x2 - test.x1) * (test.y2 - test.y1) - area;
    }

    return 0;
}