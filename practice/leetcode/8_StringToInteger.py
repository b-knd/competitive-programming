class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.strip()
        res = 0
        
        if s == "":
            return 0
        
        neg = True if s[0] == "-" else False
        s = s[1:] if s[0]=="+" or s[0]=="-" else s
        
        for i, val in enumerate(s):
            if ord(val) - ord('0') < 10 and ord(val) - ord('0') > -1:
                #underflow
                if neg and (res > int((2**31)/10) or (res == int((2**31)/10) and int(val) > 8)):
                    return -2**31
                #overflow
                if not neg and (res > int((2**31-1)/10) or (res == int((2**31-1)/10) and int(val) > 7)):
                    return (2**31)-1
                res = res * 10 + int(val)
            else:
                break
        return -res if neg else res
