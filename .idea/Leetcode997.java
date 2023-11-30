class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] trustScore = new int[N+1]; //people labelled from 1 to n

        for (int i = 0; i < trust.length; i++) {
            // Decrease trust score for the person who trusts someone, or count outDegree
            trustScore[trust[i][0]]--;
            // Increase trust score for the person being trusted, or count inDegree
            trustScore[trust[i][1]]++;
        }

        for (int i = 1; i <= N; i++) {
            // If a person is trusted by everyone else and trusts nobody, trust score is N-1
            // or check if inDegree = N-1 (everyone trusts) and outDegree = 0 (trusts nobody)
            if (trustScore[i] == N - 1) {
                return i;
            }
        }

        return -1;
    }
}