package cn.skcks.server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataContext {
    private final List<Entity> entityList;
    private final List<Mapping> mappingList;

    private final Map<String,String> entityMap;   // servlet-name => servlet-class
    private final Map<String,String> mappingMap;  // url-pattern  => servlet-name

    public DataContext(List<Entity> entityList, List<Mapping> mappingList) {
        this.entityList = entityList;
        this.mappingList = mappingList;

        this.entityMap = new HashMap<>();
        this.mappingMap = new HashMap<>();

        for(Entity entity:entityList)
        {
            entityMap.put(entity.getName(),entity.getClz());
        }
        for(Mapping mapping:mappingList)
        {
            for(String pattern:mapping.getPatternSet())
            {
                mappingMap.put(pattern,mapping.getName());
            }
        }
    }

    // 通过 pattern 查找对应的 class
    public String getClz(String pattern){
        // 通过 pattern 查找 => servlet-name 查找 => servlet-class
        return entityMap.get(mappingMap.get(pattern));
    }
}
