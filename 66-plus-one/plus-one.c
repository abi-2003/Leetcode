int* plusOne(int* digits, int digitsSize, int* returnSize) {
    *returnSize = digitsSize;

   

    //int carry = 1;
    for (int i = digitsSize - 1; i >= 0; i--) {
         if (digits[i] < 9) {
        digits[i]++;
        return digits;
    }
      digits[i]=0;
    }

    digits = realloc(digits, sizeof(int) * (digitsSize + 1));
    for (int i = digitsSize; i > 0; i--) {
        digits[i] = 0;
    }
    digits[0] = 1;

    (*returnSize)++;
    return digits;
}