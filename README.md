# distillery-coding-challenge
From a given string S generate a string, that will be a palindrome of maximal length.
If there is more than one correct result, return any of them.

Solution:
- Sort alphabetically the input
- Parse the sorted array:
	-	If it is the second time we get the working character, insert it at the beginning and the end of our palindrome
	-	If we just changed the working character AND we had an occurence of the previous one AND we can insert at the middle, do it.
	
Time complexity:
- Arrays.sort is O(n*log(n))
- Parsing array is O(n)

Space complexity:
- Sorted array is O(n)
- StringBuilder is O(n)