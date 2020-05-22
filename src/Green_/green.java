package Green_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class green {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();

        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");


        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        HashSet<String> allArea = new HashSet<String>();
        allArea.add("北京");
        allArea.add("上海");
        allArea.add("天津");
        allArea.add("广州");
        allArea.add("深圳");
        allArea.add("杭州");
        allArea.add("成都");
        allArea.add("大连");

        ArrayList<String> selects = new ArrayList<String>();
        HashSet<String> tempset = new HashSet<String>();

        String maxkey = null;
        while (allArea.size() != 0) {
            maxkey = null;

            for (String Key : broadcasts.keySet()) {
                tempset.clear();
                HashSet<String> area = broadcasts.get(Key);
                tempset.addAll(area);

                tempset.retainAll(allArea);//返回与allArea相同的地点
                if (tempset.size() > 0 && (maxkey == null || tempset.size() > broadcasts.get(maxkey).size())) {
                    maxkey = Key;
                }


            }
            if (maxkey != null) {
                selects.add(maxkey);
                allArea.removeAll(broadcasts.get(maxkey));
            }
        }
        System.out.println("结果是:" + selects);
    }
}
