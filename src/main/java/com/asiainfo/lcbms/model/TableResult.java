package com.asiainfo.lcbms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.*;

/**
 * @author felix
 */
public class TableResult implements Serializable {

    private static final long serialVersionUID = -5063527180151987941L;

    private int errorNo;

    private String errorInfo;

    private Map<String, Object> data = null;

    public TableResult() {
        this.errorNo = 0;
    }

    /**
     * @param errorNo   错误码
     * @param errorInfo 错误消息
     * @Description:
     * @author: fallsea
     * @date: 2017年10月22日 下午8:29:29
     */
    public TableResult(int errorNo, String errorInfo) {
        this.errorNo = errorNo;
        this.errorInfo = errorInfo;
    }


    public int getErrorNo() {
        return errorNo;
    }

    public void setErrorNo(int errorNo) {
        this.errorNo = errorNo;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public Map<String, Object> getData() {
        return data;
    }

    /**
     * @return
     * @Description: 获取第一个集合
     * @author: fallsea
     * @date: 2017年10月22日 下午8:29:43
     */
    @JsonIgnore
    public Object getResult() {
        if (null != this.data) {
            Set<String> set = this.data.keySet();
            if (null != set && !set.isEmpty()) {
                Iterator<String> iter = set.iterator();
                if (iter.hasNext()) {
                    String key = iter.next();
                    return getResult(key);
                }
            }
        }
        return null;
    }

    /**
     * @param dsName
     * @return
     * @Description: 获取属性集合
     * @author: fallsea
     * @date: 2017年10月22日 下午8:29:51
     */
    @JsonIgnore
    public Object getResult(String dsName) {
        if (null != getData()) {
            return getData().get(dsName);
        }
        return null;
    }


    /**
     * @param object
     * @Description: 当一个 接口只返回一个结果集时，可调用此方法
     * @author: fallsea
     * @date: 2017年10月22日 下午8:30:28
     */
    public void setResult(Object object) {
        this.setResult("list", object);
        this.setResult("pageNum",1);
        this.setResult("pageSize",10);
        this.setResult("pages",10);
        this.setResult("total",((List)object).size());
    }

    /**
     * @param name
     * @param object
     * @Description: 多个结果集需使用此方法，前台根据结果集名称获取不同的数据
     * @author: fallsea
     * @date: 2017年10月22日 下午8:30:42
     */
    public void setResult(String name, Object object) {
        if (null == this.data) {
            this.data = new HashMap<>();
        }
        this.data.put(name, object);
    }
}
