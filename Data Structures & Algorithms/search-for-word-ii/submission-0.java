
 class TrieNode{
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        boolean isEndOfWord;
    }
     class Solution {
        private TrieNode root;
        public Solution() {
            root = new TrieNode();
        }
        public List<String> findWords(char[][] board, String[] words) {
            for ( int i = 0; i < words.length; i++ ) {
            insert(words[i]);
        }
        TrieNode root = this.root;
        Set<String> res = new HashSet<String>();

        for (int row  = 0; row  < board.length; row ++) {
            for ( int col = 0; col < board[0].length; col++) {
                dfs(board, row, col, root , "",res);
            }
        }
        return new ArrayList<String>(res);
        }
        private void dfs(char[][] board,int row,int col , TrieNode node, String path , Set<String> res) {
        if(row == board.length || row < 0|| col == board[0].length || col < 0|| board[row][col] == '#'){
            return;
        }
        char ch = board[row][col];

        if(!node.children.containsKey(ch))return;

        TrieNode nextNode = node.children.get(ch);
        String newPath = path + ch;
        if(nextNode.isEndOfWord){
            res.add(newPath);
        }
        char temp = board[row][col];
        board[row][col] = '#';
        dfs(board, row + 1, col, nextNode, newPath, res);
        dfs(board, row -1, col, nextNode, newPath, res);
        dfs(board, row, col + 1, nextNode, newPath, res);
        dfs(board, row, col - 1, nextNode, newPath, res);
        board[row][col] = temp;


        }
        public void insert(String word){
            TrieNode curr = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if (!curr.children.containsKey(c)){
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
            }
            curr.isEndOfWord = true;

        }

    }
