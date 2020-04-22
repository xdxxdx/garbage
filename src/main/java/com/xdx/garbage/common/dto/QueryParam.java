package com.xdx.garbage.common.dto;

import lombok.Data;

@Data
public class QueryParam {
    private String sort="id";
    private String userName;
    private String sortOrder="desc";
    private String userNo;
    private Long userId;
    private Integer direction; //方向，1表示充值，0表示消费
    private String categoryName;
    private String commodityName;

    private String carouselName;//轮播名称

    private String provinceName;//省份名称
    private String cityName;//城市名称
    private Long provinceId;
    private Long cityId;

    private String houseName;

    private String pointName;

    private Integer status;

    private String newsTitle;

    private String agentName;

    private String startTime;

    private String endTime;

   /* public void setSortOrder() {
        if(this.sort.indexOf("-")>-1){
            this.sortOrder = "desc";
        }else{
            this.sortOrder="asc";
        }

    }

    public String getSortOrder(){
        setSortOrder();
        return this.sortOrder;
    }*/

    public void formatSort(){
        if(this.sort.indexOf("-")>-1){
            this.sortOrder = "desc";
            this.sort=this.sort.substring(1);
        }else{
            this.sortOrder="asc";
        }
    }
}
