#include <bits/stdc++.h>

using namespace std;

bool isOut(int x, int y, int x1, int y1, int x2, int y2)
{
    if (x < x1 || x2 < x || y < y1 || y2 < y)
    {
        return true;
    }
    return false;
}

int main()
{
    int t;
    int W, H;
    int x1, y1, x2, y2;
    int w, h;
    cin >> t;
    while (t--)
    {
        int ans = int(1e9);

        cin >> W >> H;
        cin >> x1 >> y1 >> x2 >> y2;
        cin >> w >> h;

        if (x2 - x1 + w <= W) //horizontal
        {
            ans = min(ans, max(0, w - x1));
            ans = min(ans, max(0, x2 - (W - w)));
        }
        if (y2 - y1 + h <= H) //vertical
        {
            ans = min(ans, max(0, h - y1));
            ans = min(ans, max(0, y2 - (H - h)));
        }
        cout << fixed << setprecision(9);
        ans == int(1e9) ? cout << "-1" << endl //no intersection
                        : cout << double(ans) << endl;
    }

    return 0;
}