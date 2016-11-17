package com.mvptest.bean;

import com.frame.bean.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/8/24.
 */

public class IndexContents extends BaseBean implements Serializable{



    private List<BannersBean> banners;

    private List<TitlesBean> titles;

    private List<IndexContentBean> indexContent;

    public List<BannersBean> getBanners() {
        return banners;
    }

    public void setBanners(List<BannersBean> banners) {
        this.banners = banners;
    }

    public List<TitlesBean> getTitles() {
        return titles;
    }

    public void setTitles(List<TitlesBean> titles) {
        this.titles = titles;
    }

    public List<IndexContentBean> getIndexContent() {
        return indexContent;
    }

    public void setIndexContent(List<IndexContentBean> indexContent) {
        this.indexContent = indexContent;
    }

    public static class BannersBean {
        private String id;
        private String jumpUrl;
        private String imageUrl;
        private String bannerType;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getJumpUrl() {
            return jumpUrl;
        }

        public void setJumpUrl(String jumpUrl) {
            this.jumpUrl = jumpUrl;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getBannerType() {
            return bannerType;
        }

        public void setBannerType(String bannerType) {
            this.bannerType = bannerType;
        }
    }

    public static class TitlesBean {
        private String icon;
        private String name;
        private String desc;
        private String linkTableName;
        private String startTime;
        private String endTime;
        private String color;
        private String index;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getLinkTableName() {
            return linkTableName;
        }

        public void setLinkTableName(String linkTableName) {
            this.linkTableName = linkTableName;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }
    }

    public static class IndexContentBean {
        private String id;
        private String name;
        private String index;
        private List<?> shop_list;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public List<?> getShop_list() {
            return shop_list;
        }

        public void setShop_list(List<?> shop_list) {
            this.shop_list = shop_list;
        }
    }
}
