 class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            boolean check = true;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        check = false;
                        break;
                    }
                    char top = stack.pop();
                    if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                        check = false;
                        break;
                    }
                }
            }
            if (!stack.isEmpty()) {
                check = false;
            }
            return check;
        }
 }