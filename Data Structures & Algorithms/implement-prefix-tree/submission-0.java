class PrefixTree {

    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord;
    }

    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.children.containsKey(c)) {
                return false;
            } else {
                curr = curr.children.get(c);
            }
        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!curr.children.containsKey(c)) {
                return false;
            } else {
                curr = curr.children.get(c);
            }
        }
        return true;
    }
}
