package com.school.utils;

import com.school.constant.PageConstant;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于接受参数和获取列表的类
 *
 * @author 杨德石
 * @date 2018/11/29
 */
public class Page<T> implements Serializable {

    /**
     * 每页起始
     */
    private Integer index;

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 每页显示条数
     */
    private Integer currentCount;

    /**
     * 总条数
     */
    private Integer totalCount;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 排序的字段
     */
    private String sortName;

    /**
     * 排序的方式
     */
    private String sortOrder;

    /**
     * 其他参数，规范如下
     * 普通列的参数s_xxx
     * 模糊搜索的参数s_like_xxx
     * 多选框这种数组形式的参数s_in_xxx
     */
    private Map<String, Object> params = new HashMap<String, Object>();

    /**
     * 搜索字段，不建议使用，如果只有一个匹配字段的话可以使用这个
     */
    private String search;

    /**
     * 每页显示的数据
     */
    private List<T> list = new ArrayList<T>();

    public Page() {

    }

    public Page(HttpServletRequest request) {
        String param;
        String value;

        param = "currentPage";
        value = request.getParameter(param);
        if (value != null && value.length() > 0) {
            this.currentPage = Integer.parseInt(value);
        } else {
            this.currentPage = PageConstant.CURRENT_PAGE;
        }

        param = "currentCount";
        value = request.getParameter(param);
        if (value != null && value.length() > 0) {
            this.currentCount = Integer.parseInt(value);
            if (this.currentCount > PageConstant.CURRENT_COUNT) {
                this.currentCount = PageConstant.CURRENT_COUNT;
            }
        } else {
            this.currentCount = PageConstant.CURRENT_COUNT;
        }

        this.index = (this.currentPage - 1) * this.currentCount;

        param = "sortName";
        value = request.getParameter(param);
        if (value != null && value.length() > 0) {
            this.sortName = StringUtils.camelToUnderline(value);
        }

        param = "sortOrder";
        value = request.getParameter(param);
        if (value != null && value.length() > 0) {
            this.sortOrder = value;
        } else {
            this.sortOrder = "asc";
        }

        Map<String, String[]> paramMap = request.getParameterMap();
        for (String key : paramMap.keySet()) {
            if (key.startsWith("s_")) {
                String vkey = key.substring(2);
                String[] p = paramMap.get(key);
                if (p.length > 0 && StringUtils.isNotEmpty(p[0])) {
                    getParams().put(vkey, StringUtils.join(p, ","));
                }
            }
        }
    }

    /**
     * @return the params
     */
    public Map<String, Object> getParams() {
        return params;
    }

    /**
     * @param params the param to set
     */
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    /**
     * @return the index
     */
    public Integer getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(Integer index) {
        this.index = index;
    }

    /**
     * @return the currentPage
     */
    public Integer getCurrentPage() {
        return currentPage;
    }

    /**
     * @param currentPage the currentPage to set
     */
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * @return the currentCount
     */
    public Integer getCurrentCount() {
        return currentCount;
    }

    /**
     * @param currentCount the currentCount to set
     */
    public void setCurrentCount(Integer currentCount) {
        this.currentCount = currentCount;
    }

    /**
     * @return the totalCount
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * @param totalCount the totalCount to set
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * @return the totalPage
     */
    public Integer getTotalPage() {
        return totalPage;
    }

    /**
     * @param totalPage the totalPage to set
     */
    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * @return the productList
     */
    public List<T> getList() {
        return list;
    }

    /**
     * @param list the productList to set
     */
    public void setList(List<T> list) {
        this.list = list;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * 设置默认排序方式
     *
     * @param sortName  需要排序的表字段，数据库字段
     * @param sortOrder 排序方式
     */
    public void sortDefault(String sortName, String sortOrder) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(getSortName()) || org.apache.commons.lang3.StringUtils.isEmpty(getSortOrder())) {
            setSortName(sortName);
            setSortOrder(sortOrder);
        }
    }

}
