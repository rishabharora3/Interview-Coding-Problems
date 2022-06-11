package java.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> setColl = new HashSet<>();
        for (int item : nums) {
            if (setColl.contains(item))
                return true;
            setColl.add(item);
        }
        return false;
    }
}

