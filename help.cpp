#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void cycle(int cur, int par, vector<bool> &vis, vector<int> &ans, vector<vector<int>> &adj) {
    vis[cur] = true;
    ans.push_back(cur);

    for (int neigh : adj[cur]) {
        if (!vis[neigh]) {
            cycle(neigh, cur, vis, ans, adj);
        } else if (vis[neigh] && neigh != par) { // Cycle detected
            auto it = find(ans.begin(), ans.end(), neigh);
            if (it != ans.end()) {
                size_t cycleStartIdx = distance(ans.begin(), it); // Use size_t to match ans.size()
                cout << ans.size() - cycleStartIdx + 1 << "\n"; // Cycle length

                for (size_t i = cycleStartIdx; i < ans.size(); i++) {
                    cout << ans[i] << " ";
                }
                cout << neigh << "\n"; // To close the cycle
                exit(0);
            }
        }
    }

    ans.pop_back(); // Backtracking
}

int main() {
    int n, m;
    cin >> n >> m;

    vector<vector<int>> adj(n + 1);
    for (int i = 0; i < m; i++) {
        int s, e;
        cin >> s >> e;
        adj[s].push_back(e);
        adj[e].push_back(s);
    }

    vector<bool> vis(n + 1, false);
    vector<int> ans; // Declare ans before calling cycle()

    for (int i = 1; i <= n; i++) {
        if (!vis[i]) {
            cycle(i, -1, vis, ans, adj);
        }
    }

    cout << "IMPOSSIBLE\n";
    return 0;
}
