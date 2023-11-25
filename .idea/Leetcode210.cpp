class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> outgoingEdges(numCourses);
        vector<int> inDegree(numCourses, 0);
        for(int i = 0; i < prerequisites.size(); i++){
            int destination = prerequisites[i][0];
            int source = prerequisites[i][1];
            outgoingEdges[source].push_back(destination);
            inDegree[destination]++;
        }


        // to push nodes that can be visited - either course with no prerequisite or prerequsite fulfilled; inDegree = 0
        queue<int> q;
        for(int node = 0; node < numCourses; node++){
            if(inDegree[node] == 0)
                q.push(node);
        }


        vector<int> courseOrder;
        while(!q.empty()){
            int node = q.front();
            cout << node << endl;
            q.pop();
            courseOrder.push_back(node);

            for(int i = 0; i < outgoingEdges[node].size(); i++){
                int vertex = outgoingEdges[node][i];
                inDegree[vertex]--;
                if(inDegree[vertex] == 0)
                    q.push(vertex);
            }
        }


        if (courseOrder.size() == numCourses)
            return courseOrder;
        return {};
    }
};