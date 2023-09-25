#include<bits/stdc++.h>

using namespace std;


bool isOut(int x, int y, int x1, int y1, int x2, int y2)
{
    if(x < x1 || x2 < x || y < y1 || y2 < y)
    {
        return true;
    }
    return false;
}

int main()
{
    int x1, y1, x2, y2, x3, y3, x4, y4, x5, y5, x6, y6;
    cin >> x1 >> y1 >> x2 >> y2 >> x3 >> y3 >> x4 >> y4 >> x5 >> y5 >> x6 >> y6;
    x1 *= 2, y1 *= 2, x2 *= 2, y2 *= 2, x3 *= 2, y3 *= 2, x4 *= 2, y4 *= 2, x5 *= 2, y5 *= 2, x6 *= 2, y6 *= 2;

    for(int x = x1; x <= x2; x++)
    {
        if (isOut(x, y1, x3, y3, x4, y4) && isOut(x, y1, x5, y5, x6, y6))
        {
            cout << "YES";
            return 0;
        }
        if (isOut(x, y2, x3, y3, x4, y4) && isOut(x, y2, x5, y5, x6, y6))
        {
            cout << "YES";
            return 0;
        }
    }
    for(int y = y1; y <= y2; y++)
    {
        if (isOut(x1, y, x3, y3, x4, y4) && isOut(x1, y, x5, y5, x6, y6))
        {
            cout << "YES";
            return 0;
        }
        if (isOut(x2, y, x3, y3, x4, y4) && isOut(x2, y, x5, y5, x6, y6))
        {
            cout << "YES";
            return 0;
        }
    }

    cout << "NO";
    return 0;
}