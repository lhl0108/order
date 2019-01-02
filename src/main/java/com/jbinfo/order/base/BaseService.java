package com.jbinfo.order.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;


public interface BaseService<T>
{
    void insert(T entity);
    
    void insertBatch(List<T> entityList);
    
    void insertBatch(List<T> entityList, int batchSize);
    
    void deleteById(Serializable id);
    
    void delete(T entity);
    
    void deleteBatchIds(Collection<? extends Serializable> idList);
    
    void deleteBatchIds(Collection<? extends Serializable> idList, int batchSize);
    
    void deleteByMap(Map<String, Object> columnMap);
    
    void update(T entity);
    
    void updateBatchIds(List<T> entityList);
    
    void updateBatchIds(List<T> entityList, int batchSize);
    
    void insertOrUpdate(T entity);
    
    T selectById(Serializable id);
    
    List<T> selectBatchIds(Collection<? extends Serializable> idList);
    
    List<T> selectByMap(Map<String, Object> columnMap);
    
    T selectOne(T entity);
    
    T selectMap(Map<String, Object> columnMap);
    
    long selectCount(T entity);
    
    List<T> selectList(T entity);

}
