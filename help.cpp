#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
using namespace std;

int Solve(int n, vector<pair<int, int>>& arr) {
    sort(arr.begin(), arr.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
        return a.second < b.second;  // sort by end time
    });

    int cur = INT_MIN;
    int ans = 0;

    for (const auto& interval : arr) {
        if (interval.first >= cur) {
            cur = interval.second;
            ans++;
        }
    }

    return ans;
}

int main() {
    int n;
    cin >> n;

    vector<pair<int, int>> arr(n);
    int max_end = INT_MIN;

    for (int i = 0; i < n; i++) {
        int s, e;
        cin >> s >> e;
        arr[i] = {s, e};
        max_end = max(max_end, e);
    }

    cout << Solve(n, arr) << endl;

    return 0;
}
