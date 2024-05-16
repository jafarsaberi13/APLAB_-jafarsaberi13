# Longest Palindromic Substring

This Java code provides a solution for finding the longest palindromic substring in a given string.

## Usage

To use this code, follow these steps:

1. Include the `Solution` class in your Java project.
2. Create an instance of the `Solution` class.
3. Call the `longestPalindrome` method, passing the input string as an argument.

Example:
```java
String input = "babad";
Solution solution = new Solution();
String longestPalindrome = solution.longestPalindrome(input);
System.out.println("Longest palindromic substring: " + longestPalindrome);
```

## Methodology

The code uses an efficient algorithm to find the longest palindromic substring within the given string. It employs the approach of expanding around the center for each character in the string. This approach allows it to check both odd-length and even-length palindromes.

## Method Details

### `longestPalindrome(String s)`

This method initiates the process of finding the longest palindromic substring within the given string `s`. It iterates through each character of the string and expands around it to find the longest palindrome. It then returns the longest palindromic substring found.

### `expandPalindrome(char[] s, int j, int k)`

This method is called by the `longestPalindrome` method to expand around a center point defined by indices `j` and `k`. It checks if the characters at indices `j` and `k` form a palindrome and expands outward until the palindrome ends. It updates the `maxLen` and `lo` variables accordingly.

## Note

- This code efficiently finds the longest palindromic substring with a time complexity of O(n^2), where n is the length of the input string.
- If there are multiple longest palindromic substrings, the code returns the one with the earliest occurrence in the input string.
