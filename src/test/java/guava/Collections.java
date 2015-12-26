package guava;

import com.google.common.collect.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by csophys on 15/8/26.
 */
public class Collections {

    @Test
    public void testCollectionInstance() {
        Maps.newLinkedHashMap();
        Lists.newArrayList();
        Sets.newHashSet();
        ObjectArrays.newArray(Integer.class, 10);
    }

    @Test
    public void testCollectionInitial() {
        ImmutableMap<Integer, Integer> of = ImmutableMap.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assert.assertTrue(of.containsKey(1));

        ArrayList<Integer> arrayList = Lists.newArrayList(1, 2, 3, 4);
        Assert.assertTrue(arrayList.contains(1));

        HashSet<Integer> hashSet = Sets.newHashSet(1, 2);
        Assert.assertTrue(hashSet.contains(1));
    }

    @Test
    public void test() {
        System.out.println(12);
    }

    @Test
    public void testMultiSet() {
        HashMultiset<Integer> multiset = HashMultiset.create();
        multiset.add(1);
        multiset.add(1);
        multiset.add(2);
        multiset.add(2);
        multiset.add(4);
        multiset.add(4);
        multiset.add(4);
        Assert.assertTrue(multiset.size() == 7);
        Assert.assertTrue(multiset.contains(4));
        Assert.assertTrue(multiset.count(4) == 3);
        multiset.add(4, 5);
        Assert.assertTrue(multiset.count(4) == 8);
    }

    @Test
    public void testMultiMap() {
        HashMultimap<Object, Object> hashMultimap = HashMultimap.create();
        hashMultimap.put(1, 2);
        hashMultimap.put(2, 4);
        hashMultimap.put(1, 3);

        assert hashMultimap.get(1).contains(2);
        assert hashMultimap.get(1).contains(3);
    }

    @Test
    public void testBiMap() {
        HashBiMap<Integer, Integer> hashBiMap = HashBiMap.create();
        hashBiMap.put(1, 2);
        assert hashBiMap.get(1) == 2;
        assert hashBiMap.inverse().get(2) == 1;

    }

    @Test
    public void testTable() {
        HashBasedTable<Integer, Integer, Integer> table = HashBasedTable.create();
        table.put(1, 1, 1);
        table.put(1, 2, 2);
        table.put(1, 3, 3);
        table.put(2, 1, 4);
        table.put(2, 2, 5);
        table.put(2, 3, 6);
        assert table.containsRow(1);
        assert table.containsColumn(2);
        assert table.row(1).get(3) == 3;
    }

}
