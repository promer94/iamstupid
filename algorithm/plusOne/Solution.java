class Solution{
    public int[] plusOne(int[] digits){
        int n = digits.length;
        for (int i=n-1; i >= 0; i -=1){
            /** When the number is less than 9 simplely add 1 */
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            /** when the number is equal to 9, need carry */
            digits[i] = 0;
        }
        /** when all the number is equal to 9, need carry. more space required */
        int[] newNumber = new int[n+1];
        newNumber[0] = 1;
        return newNumber;
    }
}