package projectBFS;
import java.util.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trokzen on 25.05.2017.
 */
 public class AhoCorasickTest extends AhoCorasick.Node
{
    //old test
    @Test//Тестируем несколько подстрок
    public void testEqualsOld() {
        AhoCorasick ahoCorasick = new AhoCorasick(1000);
        ahoCorasick.addString("bac");
        ahoCorasick.addString("a");
        String s = "abacbaca";
        int node = 0;
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            node = ahoCorasick.transition(node, s.charAt(i));
            if (ahoCorasick.nodes[node].leaf)
                positions.add(i);
        }
        List<Integer> positionsTest = new ArrayList<>();
        positionsTest.add(0);
        positionsTest.add(3);
        positionsTest.add(6);
        positionsTest.add(7);
        assertEquals(positionsTest,positions);
    }
    @Test//Тестируем с инъекцией ошибки
    public void testNotEqualsOld() {
        AhoCorasick ahoCorasick = new AhoCorasick(1000);
        ahoCorasick.addString("bac");
        ahoCorasick.addString("a");
        String s = "abacbaca";
        int node = 0;
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            node = ahoCorasick.transition(node, s.charAt(i));
            if (ahoCorasick.nodes[node].leaf)
                positions.add(i);
        }
        List<Integer> positionsTest = new ArrayList<>();
        positionsTest.add(0);
        positionsTest.add(5);
        positionsTest.add(6);
        positionsTest.add(7);
        assertNotEquals(positionsTest,positions);
    }
    @Test//Тестируем с инъекцией ошибки
    public void testOneStrOld() {
        AhoCorasick ahoCorasick = new AhoCorasick(1000);
        ahoCorasick.addString("bac");
        String s = "abacbaca";
        int node = 0;
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            node = ahoCorasick.transition(node, s.charAt(i));
            if (ahoCorasick.nodes[node].leaf)
                positions.add(i);
        }
        List<Integer> positionsTest = new ArrayList<>();
        positionsTest.add(3);
        positionsTest.add(6);
        assertEquals(positionsTest,positions);
    }
    //New Test
    @Test//Тестируем несколько подстрок
    public void testEqualsNew() {
        AhoCorasick2 ahoCorasick2 = new AhoCorasick2(1000);
        ahoCorasick2.addString("bac");
        ahoCorasick2.addString("a");
        String s = "abacbaca";
        int node = 0;
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            node = ahoCorasick2.transition(node, s.charAt(i));
            if (ahoCorasick2.nodes[node].leaf)
                positions.add(i);
        }
        List<Integer> positionsTest = new ArrayList<>();
        positionsTest.add(0);
        positionsTest.add(3);
        positionsTest.add(6);
        positionsTest.add(7);
        assertEquals(positionsTest,positions);
    }
    @Test//Тестируем с инъекцией ошибки
    public void testNotEqualsNew() {
        AhoCorasick2 ahoCorasick2 = new AhoCorasick2(1000);
        ahoCorasick2.addString("bac");
        ahoCorasick2.addString("a");
        String s = "abacbaca";
        int node = 0;
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            node = ahoCorasick2.transition(node, s.charAt(i));
            if (ahoCorasick2.nodes[node].leaf)
                positions.add(i);
        }
        List<Integer> positionsTest = new ArrayList<>();
        positionsTest.add(0);
        positionsTest.add(5);
        positionsTest.add(6);
        positionsTest.add(7);
        assertNotEquals(positionsTest,positions);
    }
    @Test//Тестируем с инъекцией ошибки
    public void TestOneStrNew() {
        AhoCorasick2 ahoCorasick2 = new AhoCorasick2(1000);
        ahoCorasick2.addString("bac");
        String s = "abacbaca";
        int node = 0;
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            node = ahoCorasick2.transition(node, s.charAt(i));
            if (ahoCorasick2.nodes[node].leaf)
                positions.add(i);
        }
        List<Integer> positionsTest = new ArrayList<>();
        positionsTest.add(3);
        positionsTest.add(5);
        assertNotEquals(positionsTest,positions);
    }
    @Test//Другой случай поиска строк
    public void testOneStrNew() {
        AhoCorasick2 ahoCorasick2 = new AhoCorasick2(1000);
        ahoCorasick2.addString("a");
        ahoCorasick2.addString("b");
        String s = "abacbaca";
        int node = 0;
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            node = ahoCorasick2.transition(node, s.charAt(i));
            if (ahoCorasick2.nodes[node].leaf)
                positions.add(i);
        }
        List<Integer> positionsTest = new ArrayList<>();
        positionsTest.add(0);
        positionsTest.add(1);
        positionsTest.add(2);
        positionsTest.add(4);
        positionsTest.add(5);
        positionsTest.add(7);
        assertEquals(positionsTest,positions);
    }
    @Test(timeout = 1000)//Тест с ограничение времени на прохождение
    public void time() {
        AhoCorasick2 ahoCorasick2 = new AhoCorasick2(1000);
        ahoCorasick2.addString("bac");
        String s = "abacbaca";
        int node = 0;
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            node = ahoCorasick2.transition(node, s.charAt(i));
            if (ahoCorasick2.nodes[node].leaf)
                positions.add(i);
        }
        List<Integer> positionsTest = new ArrayList<>();
        positionsTest.add(3);
        positionsTest.add(6);
    }
}