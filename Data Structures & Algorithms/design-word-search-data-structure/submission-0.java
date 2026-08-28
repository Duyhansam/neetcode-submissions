 class TrieNode {
            HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
            private boolean isEndOfWord;
        }

         class WordDictionary {
            private TrieNode root;

            public WordDictionary() {
            root = new TrieNode();
            }

            public void addWord(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!curr.children.containsKey(ch)) {
                curr.children.put(ch, new TrieNode());
                }
                curr = curr.children.get(ch);
            }
            curr.isEndOfWord = true;
            }

            public boolean search(String word) {
            return searchHepler(root, word, 0);
            }
            private boolean searchHepler(TrieNode node, String word, int index) {
                if (index == word.length()) {
                    return node.isEndOfWord;
                }
                char ch = word.charAt(index);

                if (ch != '.') {
                    if (!node.children.containsKey(ch)) {
                        return false;
                    }
                }else {
                        for (TrieNode child : node.children.values()) {
                            if (searchHepler(child, word, index+1)) {
                                return true;
                            }
                        }
                        return false;
                }

                return searchHepler(node.children.get(ch), word, index+1);
            }
        }
