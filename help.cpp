#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int Sol(int n, int x, vector<int>& prices, vector<int>& pages) {
    vector<vector<int>> dp(2, vector<int>(x + 1, 0));

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= x; j++) {
            if (prices[i - 1] <= j) {
                int take = pages[i - 1] + dp[(i - 1) % 2][j - prices[i - 1]];
                int leave = dp[(i - 1) % 2][j];
                dp[i % 2][j] = max(take, leave);
            } else {
                dp[i % 2][j] = dp[(i - 1) % 2][j];
            }
        }
    }

    return dp[n % 2][x];
}

int main() {
    int n, x;
    cin >> n >> x;

    vector<int> prices(n);
    for (int i = 0; i < n; i++) {
        cin >> prices[i];
    }

    vector<int> pages(n);
    for (int i = 0; i < n; i++) {
        cin >> pages[i];
    }

    cout << Sol(n, x, prices, pages) << endl;

    return 0;
}
