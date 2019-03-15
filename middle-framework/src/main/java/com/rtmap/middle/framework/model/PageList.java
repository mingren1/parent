/*
 * RT MAP, Home of Professional MAP
 * Copyright 2016 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */

/*
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package com.rtmap.middle.framework.model;

import com.github.pagehelper.Page;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PageList<T> {
    private int pageNum;
    private int pageSize;
    private long total;
    private List<T> list;

    public PageList() {
    }

    public PageList(List<T> list) {
        Page<T> p = (Page<T>) list;
        this.pageNum = p.getPageNum();
        this.pageSize = p.getPageSize();
        this.total = p.getTotal();
        this.list = p.getResult();
    }
}
