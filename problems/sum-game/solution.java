class Solution {
    public boolean sumGame(String num) {
        
        // my approach
        
        // traverse through string
            //if no que marks then
                //split string in half and make sum 
                    // if sum is equal bob wins return true 
                        // else false

            // if question marks 
                //while string contains que marks
                    // alice will start and put no. which will increase chance of alice 
                    // then bob will do same and put no. for him increase chances of winning
                //once all que marks over same process like above split the string sum the digits and if sum is equal bob wins, return true else false



        int n = num.length();

        int leftSum = 0;
        int rightSum = 0;
        int leftQ = 0;
        int rightQ = 0;

        for (int i = 0; i < n / 2; i++) {
            char c = num.charAt(i);

            if (c == '?') {
                leftQ++;
            } else {
                leftSum += c - '0';
            }
        }

        for (int i = n / 2; i < n; i++) {
            char c = num.charAt(i);

            if (c == '?') {
                rightQ++;
            } else {
                rightSum += c - '0';
            }
        }

        // Bob wins only if the two sides can be made equal.
        return 2 * (leftSum - rightSum) != 9 * (rightQ - leftQ);

    }
}