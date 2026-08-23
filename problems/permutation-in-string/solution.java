class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];
         
        int left = 0;

        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
        }

        for (int right = 0; right < s2.length(); right++) {

            windowFreq[s2.charAt(right) - 'a']++;

            if (right - left + 1 == s1.length()) {

                if (Arrays.equals(s1Freq, windowFreq)) {
                    return true;
                }

                windowFreq[s2.charAt(left) - 'a']--;

                left++;
            }
        }

        return false;
    }
}