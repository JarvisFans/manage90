/*
 * fsLayui - A Front-end Rapid Development Framework.
 * Copyright (C) 2017-2019 wueasy.com

 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.

 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
/**
 * 基础配置
 * @author: fallsea
 * @version 2.3.1
 */
layui.define([], function (exports) {

    var fsConfig = {};

    /**
     * 错误码处理定义
     */
    fsConfig["filters"] = {
        //配置统一未登录错误码处理
        "-999": function (result) {
            //未登录，跳转登陆页
            top.window.location.href = fsConfig["global"]["loginUrl"];
        }
    };

    /**
     * 项目中需要调用到的常量、变量这里配置
     */
    fsConfig["global"] = {
        "servletUrl": "", //异步请求地址,本地工程可以不填
        "loginUrl": "/login", //登录url
        "uploadUrl": "http://49.234.40.74:10100/upload", //上传附件url
        "uploadHtmlUrl": "/plugins/frame/views/file-upload.html", //上传附件html地址，默认/plugins/frame/views/upload.html
        "loadDataType": "1",//加载数据类型，1：使用缓存数据，0：实时查询，默认0  （编辑或查看是否取缓存数据）
        "datagridSubmitType": "1",//数据表格提交类型，1：原数据提交，2：增删改标签提交（fsType）， 默认1
        "notifyType": "sweetalert",//提醒类型，默认layer，执行消息提示类型，sweetalert。toastr
        "tableHeight": "full-125",//默认table高度，默认full-155
        "rsaKey": "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDzlPObayOD1prtJloDYS2YCj/FXlN0PXnxiMjgHHBLWJ18KL58Q/SQCfx0aSFkU4nf5QAZeJDp+0ALzrtIk3Y4fUqSxoRTjOfheSM6e/HS66+97BOhw4iqxyYwoZDMAd4QSi+7sbhBWNYKnJFoWgjazvv1ZoUpzF5Wnh6n+WhPTQIDAQAB",
        "result": { //响应结果配置
            "statusName": "errorNo", //数据状态的字段名称，默认：errorNo
            "msgName": "errorInfo", //状态信息的字段名称，默认：errorInfo
            "successNo": "0", //执行成功错误码统一配置
            "dataName": "data", //非表格数据的字段名称，默认：results.data
            "file": { //文件配置
                "filePath": "filePath",  //返回文件路径属性
                "fileName": "fileName"  //返回文件名称属性
            }
        },
        "page": { //分页配置
            "sortType": "0",//默认排序方式，0：本地排序，1：异步排序，不配置默认为0
            "request": {//请求配置
                "pageName": "pageNum", //页码的参数名称，默认：pageNum
                "limitName": "pageSize" //每页数据量的参数名，默认：pageSize
            },
            "response": {//响应配置
                "countName": "data.total", //数据总数的字段名称，默认：results.data.total
                "dataName": "data", //数据列表的字段名称，默认：results.data
                "dataNamePage": "data.list" //分页数据列表的字段名称，默认：results.data.list
            }//,
//			"limit":10,//每页分页数量。默认20
//			"limits":[10,20,30,50,100]//每页数据选择项，默认[10,20,30,50,100]
        }
    };

    /**
     * 拓展form表单验证规则
     */
    fsConfig["verify"] = {
        /**
         * 对比两个值相等
         */
        "equals": function (value, item) { //value：表单的值、item：表单的DOM对象
            var equalsId = $(item).attr("equalsId");
            if ($.isEmpty(equalsId)) {
                return '未配置对比id';
            }
            var value2 = $("#" + equalsId).val();

            if (value !== value2) {
                var equalsMsg = $(item).attr("equalsMsg");
                if ($.isEmpty(equalsMsg)) {
                    equalsMsg = "值不相等";
                }
                return equalsMsg;
            }
        },
        /**
         * 用户名验证
         */
        "username": [
            /^[a-zA-Z]{1}([a-zA-Z0-9]|[_]){2,19}$/,
            '用户名格式不正确!'
        ],
        /**
         * 最小、最大长度判断
         */
        "length": function (value, item) { //value：表单的值、item：表单的DOM对象
            var minLength = $(item).attr("minLength");//最小长度
            var maxLength = $(item).attr("maxLength");//最大长度
            if (!$.isEmpty(minLength) && '0' !== minLength && parseInt(minLength) > value.length) {
                return "输入内容小于最小值:" + minLength;
            }
            if (!$.isEmpty(maxLength) && '0' !== maxLength && value.length > parseInt(maxLength)) {
                return "输入内容大于最小值:" + maxLength;
            }
        }
    };

    /**
     * 菜单配置
     */
    fsConfig["menuConfig"] = {
        dataType: "local", //获取数据方式，local本地获取，server 服务端获取
        loadUrl: "", //加载数据地址
        method: "post",//请求类型，默认post
        rootMenuId: "0", //根目录菜单id
        defaultSelectTopMenuId: "1", //默认选中头部菜单id
        defaultSelectLeftMenuId: "111", //默认选中左边菜单id
        menuIdField: "menuId", //菜单id
        menuNameField: "menuName", //菜单名称
        menuIconField: "menuIcon", //菜单图标，图标必须用css
        menuHrefField: "menuHref", //菜单链接
        parentMenuIdField: "parentMenuId",//父菜单id
        data: [
            {"menuId": "001", "menuName": "系统管理", "menuIcon": "fa-cog", "menuHref": "", "parentMenuId": 0},
            {
                "menuId": "002",
                "menuName": "业务受理",
                "menuIcon": "layui-icon layui-icon-template-1",
                "menuHref": "",
                "parentMenuId": 0
            },
            {
                "menuId": "003",
                "menuName": "综合查询",
                "menuIcon": "layui-icon layui-icon-component",
                "menuHref": "",
                "parentMenuId": 0
            },
            {"menuId": "001001", "menuName": "服务定义", "menuIcon": "fa-table", "menuHref": "", "parentMenuId": "001"},
            {"menuId": "001002", "menuName": "设备管理", "menuIcon": "", "menuHref": "", "parentMenuId": "001"},
            {"menuId": "002001", "menuName": "用户管理", "menuIcon": "", "menuHref": "", "parentMenuId": "002"},
            {"menuId": "002002", "menuName": "集团管理", "menuIcon": "", "menuHref": "", "parentMenuId": "002"},
            {"menuId": "002003", "menuName": "黑白名单管理", "menuIcon": "", "menuHref": "", "parentMenuId": "002"},
            {"menuId": "003001", "menuName": "用户查询", "menuIcon": "", "menuHref": "", "parentMenuId": "003"},
            {"menuId": "003002", "menuName": "清单查询", "menuIcon": "", "menuHref": "", "parentMenuId": "003"},
            {"menuId": "003003", "menuName": "在线查询", "menuIcon": "", "menuHref": "", "parentMenuId": "003"},
            {
                "menuId": "001001000",
                "menuName": "首页",
                "menuIcon": "&#xe68e;",
                "menuHref": "main",
                "parentMenuId": "001001"
            },
            {
                "menuId": "001001001",
                "menuName": "域名管理",
                "menuIcon": "fa-list",
                "menuHref": "views/datagrid/index.html",
                "parentMenuId": "001001"
            },
            {
                "menuId": "001001002",
                "menuName": "服务类型",
                "menuIcon": "fa-list",
                "menuHref": "views/datagrid2/index.html",
                "parentMenuId": "001001"
            },
            {
                "menuId": "001001003",
                "menuName": "组别管理",
                "menuIcon": "fa-list",
                "menuHref": "views/datagrid2/index.html",
                "parentMenuId": "001001"
            },
            {
                "menuId": "001002001",
                "menuName": "NAS设备管理",
                "menuIcon": "fa-list",
                "menuHref": "views/datagrid2/index.html",
                "parentMenuId": "001002"
            },
            {
                "menuId": "001002002",
                "menuName": "设备黑名单",
                "menuIcon": "fa-list",
                "menuHref": "views/datagrid2/index.html",
                "parentMenuId": "001002"
            },
            {
                "menuId": "002001001",
                "menuName": "宽带用户",
                "menuIcon": "fa-list",
                "menuHref": "views/datagrid2/index.html",
                "parentMenuId": "002001"
            },
            {
                "menuId": "002001002",
                "menuName": "IPTV用户",
                "menuIcon": "fa-list",
                "menuHref": "views/datagrid2/index.html",
                "parentMenuId": "002002"
            },
            {
                "menuId": "003001001",
                "menuName": "宽带在线查询",
                "menuIcon": "fa-list",
                "menuHref": "views/datagrid2/index.html",
                "parentMenuId": "003001"
            },
            {
                "menuId": "003001002",
                "menuName": "宽带离线查询",
                "menuIcon": "fa-list",
                "menuHref": "views/datagrid2/index.html",
                "parentMenuId": "003001"
            },
            {
                "menuId": "003002001",
                "menuName": "7日清单查询",
                "menuIcon": "fa-list",
                "menuHref": "views/datagrid2/index.html",
                "parentMenuId": "003002"
            },
            {
                "menuId": "003003001",
                "menuName": "在线溯源",
                "menuIcon": "",
                "menuHref": "/trace",
                "parentMenuId": "003003"
            },
            {
                "menuId": "003003002",
                "menuName": "在线管理",
                "menuIcon": "",
                "menuHref": "/online/manage",
                "parentMenuId": "003003"
            },
        ] //本地数据
    };

    exports('fsConfig', fsConfig);
});
