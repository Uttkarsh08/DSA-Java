#include <iostream>
#include <vector>

using namespace std;

void dfs(int cur, vector<vector<int>> &adj, vector<bool> &vis) {
    vis[cur] = true;
    for (int neigh : adj[cur]) {
        if (!vis[neigh]) {
            dfs(neigh, adj, vis);
        }
    }
}

int main() {
    int cities, nr;
    cin >> cities >> nr;

    vector<vector<int>> adj(cities + 1);

    while (nr--) {
        int s, e;
        cin >> s >> e;

        adj[s].push_back(e);
        adj[e].push_back(s);
    }

    vector<bool> vis(cities + 1, false);
    vector<int> ans2;
    int ans = 0;

    for (int i = 1; i <= cities; i++) {
        if (!vis[i]) {
            ans2.push_back(i);
            dfs(i, adj, vis);
            ans++;
        }
    }

    cout << ans - 1 << endl;

    for (int i = 0; i < ans - 1; i++) {
        cout << ans2[i] << " " << ans2[i + 1] << endl;
    }

    return 0;
}
