package com.ejet.bi.dynamicservice.vo;

import com.ejet.bi.dynamicservice.model.BiApiServiceModel;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: BiApiVO
 * Author:   Ejet
 * CreateDate:     2018-10-09 17:04
 * Description: api信息
 * History:
 * Version: 1.0
 */
public class BiApiVO extends BiApiServiceModel {
    /**  分组名称  */
    private String apiCategoryame;
    /** 分组URL前缀   */
    private String urlPrefix;
    /** 资源ID */
    private String resourceUuid;

    public String getApiCategoryame() {
        return apiCategoryame;
    }

    public void setApiCategoryame(String apiCategoryame) {
        this.apiCategoryame = apiCategoryame;
    }

    public String getUrlPrefix() {
        return urlPrefix;
    }

    public void setUrlPrefix(String urlPrefix) {
        this.urlPrefix = urlPrefix;
    }

    public String getResourceUuid() {
        return resourceUuid;
    }

    public void setResourceUuid(String resourceUuid) {
        this.resourceUuid = resourceUuid;
    }
}
