package com.rtmap.middle.framework.base;

import com.rtmap.middle.framework.model.PageList;
import com.rtmap.middle.framework.model.Result;
import com.rtmap.middle.framework.model.PageList;
import com.rtmap.middle.framework.model.Result;

public interface BaseInterface<T> {

    Result<Integer> add(T vo);

    Result<Integer> update(T vo);

    Result<Integer> delete(T vo);

    Result<PageList<T>> getList(T query);

    Result<T> get(T vo);

}
