package com.rtmap.middle.framework.base;

import java.util.List;

public interface BaseDao<T> {

    Integer add(T vo);

    Integer update(T vo);

    Integer delete(T vo);

    List<T> getList(T query);

    T get(T vo);
}
