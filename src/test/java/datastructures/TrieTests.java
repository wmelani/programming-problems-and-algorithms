package datastructures;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class TrieTests {
    public void trieCanCreate() {
        var trie = new Trie();
        trie.add("candy");
        trie.print();
    }

    @Test
    public void trieCanCreateAndShareNodes() {
        var trie = new Trie();
        trie.add("candy");
        trie.add("cobra");
        trie.print();
    }

    @Test
    public void trieCanFindNodes() {
        var trie = new Trie();
        trie.add("candy");
        trie.add("cobra");
        trie.print();
        assertTrue(trie.exists("cobra"));
    }

    @Test
    public void trieCanRemove() {
        var trie = new Trie();
        trie.add("candy");
        trie.print();
        assertTrue(trie.remove("candy"));
        trie.print();
    }

    @Test
    public void trieCanBranchFromRoot() {
        var trie = new Trie();
        assertTrue(trie.add("candy"));
        trie.print();
        assertTrue(trie.add("tandy"));
        trie.print();
    }

    @Test
    public void trieCanExtendAWord() {
        var trie = new Trie();
        assertTrue(trie.add("candy"));
        trie.print();
        assertTrue(trie.add("candycane"));
        trie.print();
    }
}
