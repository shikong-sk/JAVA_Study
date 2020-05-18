package cn.skcks.oop;

import java.util.*;

/*
    存储表格数据

    每行使用 Map
    多行多个 Map
 */
public class TestStoreData_1 {
    public static void main(String[] args) {
        List<Map<String,Object>> table = new ArrayList<>();

        Map<String,Object> row1 = new HashMap<>();

        row1.put("学号",1730502127);
        row1.put("姓名","时空");
        row1.put("性别","男");
        row1.put("院系编号","05");
        row1.put("专业编号","02");

        Map<String,Object> row2 = new HashMap<>();

        row2.put("学号",1730502101);
        row2.put("姓名","装逼犯");
        row2.put("性别","男");
        row2.put("院系编号","05");
        row2.put("专业编号","02");

        table.add(row1);
        table.add(row2);

        for(Map<String,Object> row:table)
        {
            Set<String> keySet = row.keySet();

            for (String key:keySet)
            {
                System.out.print(key + " => " + row.get(key) + "\t");
            }

            System.out.println("\n===============================");
        }
    }
}
