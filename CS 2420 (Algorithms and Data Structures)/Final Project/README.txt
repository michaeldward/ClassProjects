Mini Search Engine Instructions
1. Please change the string docLocation in main to the location of your documents to be searched
2. Enter search query and documents that contain the word will be printed
3. If no words contain the desired word, "NOT FOUND" will be printed
4. Enter two words with AND in between to find all documents that contain both words
5. Enter two words with OR in between to find all documents that contain either word
6. If "NOT FOUND" is returned, please check your spelling to make sure you are searching for the words you meant to search for.
7. Please enter all query words in lowercase
8. AND or OR can be all caps or lowercase
9. If the second word is not AND or OR, a one-word search will be executed with the first word entered

How it works:
The program reads in documents cranfield0001 through cranfield 0050 in the location specified in the function main.
The words are then stored in a hash table. When the user enters a query, the hash table is searched for the user's query.
The numbers of all documents that the query word is found in are then printed to the console. The user can enter AND between 
two words to find all the documents that contain both words specified. Additionally, the user can enter OR between words
to find all documents that contain either word.