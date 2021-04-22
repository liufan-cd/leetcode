package person.liufan.middle.design;

import java.util.*;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.middle.design
 * @description: TODO
 * @date 2021/4/20
 */
public class RandomizedSet {
    public static void main(String[] args) {
        RandomizedSet random = new RandomizedSet();
        /*System.out.println(random.insert(1));
        System.out.println(random.remove(2));
        System.out.println(random.insert(2));
        System.out.println(random.getRandom());
        System.out.println(random.remove(1));
        System.out.println(random.insert(2));
        System.out.println(random.getRandom());*/
        System.out.println(random.remove(0));
        System.out.println(random.remove(0));
        System.out.println(random.insert(0));
        System.out.println(random.getRandom());
        System.out.println(random.remove(0));
        System.out.println(random.insert(0));
    }

    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        //查询是否存在
        if (!map.containsKey(val)) {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            Integer lastOne = list.get(list.size() - 1);
            Integer valIndex = map.get(val);
            list.set(valIndex, lastOne);
            map.put(lastOne, valIndex);
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
