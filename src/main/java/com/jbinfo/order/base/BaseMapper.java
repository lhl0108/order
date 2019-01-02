package com.jbinfo.order.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface BaseMapper<T> {
    
    void insert(T entity);
    
    void insertBatch(List<T> entityList);
    
    void deleteById(Serializable id);
    
    void delete(T entity);
    
    void deleteByMap(Map<String, Object> columnMap);
    
    void deleteBatchIds(Collection<? extends Serializable> idList);
    
    void update(T entity);
    
    void updateBatchIds(List<T> entityList);
    
    T selectById(Serializable id);
    
    List<T> selectBatchIds(Collection<? extends Serializable> idList);
    
    List<T> selectByMap(Map<String, Object> columnMap);
    
    T selectOne(T entity);
    
    long selectCount(T entity);
    
    List<T> selectList(T entity);
    
    List<T> queryPage(Map<String, Object> paramMap);
}
