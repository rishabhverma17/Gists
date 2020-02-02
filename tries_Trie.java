package com.tries;

import java.util.ArrayList;

class Trie{
    private final TrieNode root;
    Trie(){
        this.root = new TrieNode();
    }

    public int query(final String s){
        TrieNode current = root;
        for(int i=0; i<s.length(); i++){
            if(current == null || current.next(s.charAt(i))==null){
                return 0;
            }
            else{
                current = current.next(s.charAt(i));
            }
        }
        return current.terminating;
    }

    public void insert(final String s){
        TrieNode current = root;
        for(int i=0; i<s.length();i++){
            if(current.trieNodes[s.charAt(i) - 'a'] == null){
                current.trieNodes[s.charAt(i) - 'a'] = new TrieNode();
            }
            current = current.next(s.charAt(i));
            current.visited++;
        }
        current.terminating++;
    }

    public void delete(final String s){
        TrieNode current = root;
        for(int i=0; i<s.length();i++){
            if(current == null){
                throw new RuntimeException();
            }
            current = current.next(s.charAt(i));
            current.visited--;
        }
        if(current.terminating != 0){
            current.terminating--;
        }else{
            throw new RuntimeException();
        }
    }

    public void update(final String old, final String newString){
        delete(old);
        insert(newString);
    }

    // This is Not working rightnow
    public String ModifiedSearch(final ArrayList<String> input){
        StringBuilder result = new StringBuilder();
        for(String in : input){
            TrieNode current = root;
            int matchCount = 0;
            int strLen = in.length();
            for(int i=0; i<strLen; i++){
                if(current.trieNodes[in.charAt(i) - 'a'] != null){
                    matchCount++;
                    current = current.next(in.charAt(i));
                }
                // current = current.next(in.charAt(i));
            }
            if((strLen - matchCount) == 1){
                result.append("1");
            }
            else{
                result.append("0");
            }
        }

        return result.toString();
    }

    public ArrayList<String> shortestUniquePrefix(final ArrayList<String> input){
        ArrayList<String> result = new ArrayList<>();
        for(String in : input){
            TrieNode current = root;
            StringBuilder res = new StringBuilder();
            for(int i=0; i < in.length(); i++){
                int visited = current.trieNodes[in.charAt(i) - 'a'].visited;
                if(visited == 1){
                    String item = ""+ in.charAt(i);
                    res.append(item);
                    break;
                }
                String item = ""+ in.charAt(i);
                res.append(item);
                current = current.next(in.charAt(i));
            }
            result.add(res.toString());
        }
        return result;
    }
}
