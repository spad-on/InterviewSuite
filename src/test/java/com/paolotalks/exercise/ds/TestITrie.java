package com.paolotalks.exercise.ds;

import com.paolotalks.exercise.util.PartialTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Constructor;

import static org.junit.Assert.*;

@RunWith(PartialTestRunner.class)
public class TestITrie extends BaseDSTestCase {

    private static final String CLASS_PATH = PACKAGE_PATH + ".TrieImpl";

    protected static ITrie createTrie(){
        Class<?> cls = getImplClass(CLASS_PATH);
        try {
            Constructor<?> supplier = cls.getConstructor();
            return (ITrie) supplier.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void checkIsWord(String word, ITrie trie){
        checkPrefix(word, trie, true);
    }

    private void checkNonWordPrefix(String word, ITrie trie){
        checkPrefix(word, trie, false);
    }

    private void checkPrefix(String word, ITrie trie, boolean valid){
        ITrieNode node = trie.getRoot();
        for (char c : word.toCharArray()){
            node = node.getChild(c);
            assertNotNull(node);
        }
        if (valid)
            assertTrue(node.isWord());
        else
            assertFalse(node.isWord());
    }

    private ITrieNode findPrefix(String word, ITrie trie){
        ITrieNode node = trie.getRoot();
        for (char c : word.toCharArray()){
            node = node.getChild(c);
            if (node == null) return null;
        }
        return node;
    }

    @Test
    public void testEmptyTrie() {
        ITrie trie = createTrie();
        ITrieNode node = trie.getRoot();
        assertNotNull(node);
        assertEquals('\0', node.getData());
        assertFalse(node.isWord());
    }

    @Test
    public void testSimpleWord() {
        ITrie trie = createTrie();
        assertNull(findPrefix("hello", trie));
        trie.addWord("hello");
        checkIsWord("hello", trie);
        checkNonWordPrefix("hell", trie);
        assertNull(findPrefix("heck", trie));
    }

    @Test
    public void testSubPrefixBecomesWord() {
        ITrie trie = createTrie();
        trie.addWord("hello");
        trie.addWord("hell");
        checkIsWord("hello", trie);
        checkIsWord("hell", trie);
        checkNonWordPrefix("hel", trie);
        assertNull(findPrefix("hi", trie));
    }

    @Test
    public void testThreeWords() {
        ITrie trie = createTrie();
        trie.addWord("people");
        trie.addWord("are");
        trie.addWord("crazy");
        checkIsWord("people", trie);
        checkIsWord("crazy", trie);
        checkIsWord("are", trie);
        checkNonWordPrefix("cra", trie);
        assertNull(findPrefix("savage", trie));
    }

    @Test
    public void testEmptyWord() {
        ITrie trie = createTrie();
        assertNull(findPrefix("", trie));
        trie.addWord("");
        checkIsWord("", trie);
        assertNull(findPrefix("hello", trie));
    }

}
