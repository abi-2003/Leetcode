class Solution {
    boolean check(String s) {
        return "aeiou".indexOf(s.charAt(0)) != -1 && "aeiou".indexOf(s.charAt(s.length() - 1)) != -1;
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] n = new int[words.length];
        int[] ans = new int[queries.length];

        for (int i = 0; i < words.length; i++) {
            n[i] = check(words[i]) ? 1 : 0;
        }

        int[] prefixSum = new int[n.length + 1];
        for (int i = 0; i < n.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + n[i];
        }

        for (int i = 0; i < queries.length; i++) {
            ans[i] = prefixSum[queries[i][1] + 1] - prefixSum[queries[i][0]];
        }

        return ans;
    }
}