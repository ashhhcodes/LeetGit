class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int m = n / 2;

        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int odd = 0;
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) != 0) {
                odd++;
                mid = (char) ('a' + i);
            }
        }

        if (odd > 1) return "";

        int[] cnt = new int[26];
        for (int i = 0; i < 26; i++) {
            cnt[i] = freq[i] / 2;
        }

        char[] half = new char[m];

        int i = 0;

        while (i < m) {
            int x = target.charAt(i) - 'a';

            if (cnt[x] == 0) break;

            half[i] = (char) ('a' + x);
            cnt[x]--;
            i++;
        }

        if (i == m) {
            String ans = build(half, mid);

            if (ans.compareTo(target) > 0) {
                return ans;
            }

            return nextPalindrome(half, mid);
        }

        String ans = makeGreater(half, i, cnt, target, mid);

        return ans;
    }

    private String makeGreater(
            char[] half,
            int pos,
            int[] cnt,
            String target,
            char mid) {

        int m = half.length;

        for (int i = pos; i >= 0; i--) {
            if (i < pos) {
                cnt[half[i] - 'a']++;
            }

            int limit = target.charAt(i) - 'a';

            for (int c = limit + 1; c < 26; c++) {
                if (cnt[c] == 0) continue;

                char[] res = half.clone();
                res[i] = (char) ('a' + c);

                int[] temp = cnt.clone();
                temp[c]--;

                int p = i + 1;

                for (int x = 0; x < 26; x++) {
                    while (temp[x] > 0) {
                        res[p++] = (char) ('a' + x);
                        temp[x]--;
                    }
                }

                return build(res, mid);
            }
        }

        return "";
    }

    private String nextPalindrome(char[] half, char mid) {
        char[] a = half.clone();
        int n = a.length;

        int i = n - 2;

        while (i >= 0 && a[i] >= a[i + 1]) {
            i--;
        }

        if (i < 0) return "";

        int j = n - 1;

        while (a[j] <= a[i]) {
            j--;
        }

        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;

        int l = i + 1;
        int r = n - 1;

        while (l < r) {
            temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }

        return build(a, mid);
    }

    private String build(char[] half, char mid) {
        StringBuilder sb = new StringBuilder(half.length * 2 + 1);

        for (char c : half) {
            sb.append(c);
        }

        if (mid != 0) {
            sb.append(mid);
        }

        for (int i = half.length - 1; i >= 0; i--) {
            sb.append(half[i]);
        }

        return sb.toString();
    }
}
