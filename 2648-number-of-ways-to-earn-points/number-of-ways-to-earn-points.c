
#define MOD 1000000007

int waysToReachTarget(int target, int** types, int typesSize, int* typesColSize) {
    int dp[target + 1];
    dp[0] = 1;
    for (int i = 1; i <= target; i++) dp[i] = 0;

    for (int i = 0; i < typesSize; i++) {
        int count = types[i][0], marks = types[i][1];
        for (int j = target; j >= marks; j--) {
            for (int k = 1; k <= count && k * marks <= j; k++) {
                dp[j] = (dp[j] + dp[j - k * marks]) % MOD;
            }
        }
    }
    return dp[target];
}