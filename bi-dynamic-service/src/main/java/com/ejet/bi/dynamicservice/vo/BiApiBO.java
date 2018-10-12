package com.ejet.bi.dynamicservice.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: BiApiBO
 * Author:   Ejet
 * CreateDate:     2018-10-12 19:08
 * Description: api服务业务对象
 * History:
 * Version: 1.0
 */
public class BiApiBO {

    private String url;

    private List<BiApiVO> list = new ArrayList<>();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<BiApiVO> getList() {
        return list;
    }

    public void setList(List<BiApiVO> list) {
        this.list = list;
    }
}
