class Solution:
    def __init__(self):
        self.table = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
        
    def uniqueMorseRepresentations(self, words: List[str]) -> int:
        #result list that contains unique morse codes
        res = []
        
        for i, word in enumerate(words):
            #build morse code from word, add to list if not already exist
            string = ""
            for j, char in enumerate(word):
                string += self.table[ord(char)-ord('a')]
            if string not in res:
                res += [string]
        return len(res)
