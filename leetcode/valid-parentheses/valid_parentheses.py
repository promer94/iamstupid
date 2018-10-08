def isValid(s):
    """
    :type s: str
    :rtype: bool
    """
    stack = list()
    for char in s:
        if (char == "{"):
            stack.append(char)
        if (char == "("):
            stack.append(char)
        if (char == "["):
            stack.append(char)
            
        if(char == "}"):
            if(len(stack) == 0): return False
            if(stack.pop() != "{"): return False
        if (char == ")"):
            if(len(stack) == 0): return False
            if(stack.pop() != "("): return False
        if (char == "]"):
            if(len(stack) == 0): return False
            if(stack.pop() !="["): return False
            
    return len(stack) == 0
