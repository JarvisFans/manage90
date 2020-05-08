/**
 * @Description: 菜单配置
 * @Copyright: 2017 wueasy.com Inc. All rights reserved.
 * @author: fallsea
 * @version 1.8.4
 * @License：MIT
 */
layui.define(['element', "fsConfig", "fsCommon"], function (exports) {

    var menuConfig = {
        dataType: "local", //获取数据方式，local本地获取，server 服务端获取
        loadUrl: "", //加载数据地址
        method: "post",//请求类型，默认post
        rootMenuId: "0", //根目录菜单id
        defaultSelectTopMenuId: "001", //默认选中头部菜单id
        defaultSelectLeftMenuId: "001001000", //默认选中左边菜单id
        menuIdField: "menuId", //菜单id
        menuNameField: "menuName", //菜单名称
        menuIconField: "menuIcon", //菜单图标，图标必须用css
        menuHrefField: "menuHref", //菜单链接
        parentMenuIdField: "parentMenuId",//父菜单id
        data: [
            {"menuId": "001", "menuName": "系统管理", "menuIcon": "fa-cog", "menuHref": "", "parentMenuId": 0},
            {"menuId": "002", "menuName": "业务受理", "menuIcon": "", "menuHref": "", "parentMenuId": 0},
            {"menuId": "003", "menuName": "综合查询", "menuIcon": "", "menuHref": "", "parentMenuId": 0},
            {"menuId": "001001", "menuName": "服务定义", "menuIcon": "fa-table", "menuHref": "", "parentMenuId": "001"},
            {"menuId": "001002", "menuName": "设备管理", "menuIcon": "", "menuHref": "", "parentMenuId": "001"},
            {"menuId": "002001", "menuName": "用户管理", "menuIcon": "", "menuHref": "", "parentMenuId": "002"},
            {"menuId": "002002", "menuName": "集团管理", "menuIcon": "", "menuHref": "", "parentMenuId": "002"},
            {"menuId": "002003", "menuName": "黑白名单管理", "menuIcon": "", "menuHref": "", "parentMenuId": "002"},
            {"menuId": "003001", "menuName": "用户查询", "menuIcon": "", "menuHref": "", "parentMenuId": "003"},
            {"menuId": "003002", "menuName": "清单查询", "menuIcon": "", "menuHref": "", "parentMenuId": "003"},
            {
                "menuId":"001001000",
                "menuName":"首页",
                "menuIcon":"&#xe68e;",
                "menuHref":"main",
                "parentMenuId":"001001"
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
        ] //本地数据
    };

    var element = layui.element,
        fsCommon = layui.fsCommon,
        fsConfig = layui.fsConfig,
        statusName = $.result(fsConfig, "global.result.statusName", "errorNo"),
        msgName = $.result(fsConfig, "global.result.msgName", "errorInfo"),
        successNo = $.result(fsConfig, "global.result.successNo", "0"),
        dataName = $.result(fsConfig, "global.result.dataName", "results.data"),
        FsMenu = function () {

        };


    FsMenu.prototype.render = function () {

        this.loadData();

        this.showMenu();
    };

    /**
     * 加载数据
     */
    FsMenu.prototype.loadData = function () {

        if (menuConfig.dataType == "server") {//服务端拉取数据

            var url = menuConfig.loadUrl;
            if ($.isEmpty(url)) {
                fsCommon.errorMsg("未配置请求地址！");
                return;
            }

            fsCommon.invoke(url, {}, function (data) {
                if (data[statusName] == successNo) {
                    menuConfig.data = $.result(data, dataName);
                } else {
                    //提示错误消息
                    fsCommon.errorMsg(data[msgName]);
                }
            }, false, menuConfig.method);

        }

    }


    /**
     * 获取图标
     */
    FsMenu.prototype.getIcon = function (menuIcon) {

        if (!$.isEmpty(menuIcon)) {

            if (menuIcon.indexOf("<i") == 0) {
                return menuIcon;
            } else if (menuIcon.indexOf("&#") == 0) {
                return '<i class="layui-icon">' + menuIcon + '</i>';
            } else if (menuIcon.indexOf("fa-") == 0) {
                return '<i class="fa ' + menuIcon + '"></i>';
            } else {
                return '<i class="' + menuIcon + '"></i>';
            }
        }
        return "";
    };

    /**
     * 清空菜单
     */
    FsMenu.prototype.cleanMenu = function () {
        $("#fsTopMenu").html("");
        $("#fsLeftMenu").html("");
    }
    /**
     * 显示菜单
     */
    FsMenu.prototype.showMenu = function () {
        var thisMenu = this;
        var data = menuConfig.data;
        if (!$.isEmpty(data)) {
            var _index = 0;
            //显示顶部一级菜单
            var fsTopMenuElem = $("#fsTopMenu");
            var fsLeftMenu = $("#fsLeftMenu");
            $.each(data, function (i, v) {
                if (menuConfig.rootMenuId == v[menuConfig.parentMenuIdField]) {

                    var topStr = '<li class="layui-nav-item';
                    if ($.isEmpty(menuConfig.defaultSelectTopMenuId) && _index === 0) {//为空默认选中第一个
                        topStr += ' layui-this';
                    } else if (!$.isEmpty(menuConfig.defaultSelectTopMenuId) && menuConfig.defaultSelectTopMenuId == v[menuConfig.menuIdField]) {//默认选中处理
                        topStr += ' layui-this';
                    }
                    _index++;
                    topStr += '" dataPid="' + v[menuConfig.menuIdField] + '"><a href="javascript:;">' + thisMenu.getIcon(v[menuConfig.menuIconField]) + ' <cite>' + v[menuConfig.menuNameField] + '</cite></a></li>';
                    fsTopMenuElem.append(topStr);

                    //显示二级菜单，循环判断是否有子栏目
                    $.each(data, function (i2, v2) {
                        if (v[menuConfig.menuIdField] == v2[menuConfig.parentMenuIdField]) {

                            var menuRow = '<li class="layui-nav-item';
                            if (!$.isEmpty(menuConfig.defaultSelectLeftMenuId) && menuConfig.defaultSelectLeftMenuId == v2[menuConfig.menuIdField]) {//默认选中处理
                                menuRow += ' layui-this';
                            }
                            //显示三级菜单，循环判断是否有子栏目
                            var menuRow3 = "";
                            $.each(data, function (i3, v3) {
                                if (v2[menuConfig.menuIdField] == v3[menuConfig.parentMenuIdField]) {
                                    if ($.isEmpty(menuRow3)) {
                                        menuRow3 = '<dl class="layui-nav-child">';
                                    }
                                    menuRow3 += '<dd';
                                    if (!$.isEmpty(menuConfig.defaultSelectLeftMenuId) && menuConfig.defaultSelectLeftMenuId == v3[menuConfig.menuIdField]) {//默认选中处理
                                        menuRow3 += ' class="layui-this"';
                                        menuRow += ' layui-nav-itemed';//默认展开二级菜单
                                    }

                                    menuRow3 += ' lay-id="' + v3[menuConfig.menuIdField] + '"><a href="javascript:;" menuId="' + v3[menuConfig.menuIdField] + '" dataUrl="' + v3[menuConfig.menuHrefField] + '">' + thisMenu.getIcon(v3[menuConfig.menuIconField]) + ' <cite>' + v3[menuConfig.menuNameField] + '</cite></a></dd>';

                                }

                            });

                            menuRow += '" lay-id="' + v2[menuConfig.menuIdField] + '" dataPid="' + v2[menuConfig.parentMenuIdField] + '" style="display: none;"><a href="javascript:;" menuId="' + v2[menuConfig.menuIdField] + '" dataUrl="' + v2[menuConfig.menuHrefField] + '">' + thisMenu.getIcon(v2[menuConfig.menuIconField]) + ' <cite>' + v2[menuConfig.menuNameField] + '</cite></a>';


                            if (!$.isEmpty(menuRow3)) {
                                menuRow3 += '</dl>';

                                menuRow += menuRow3;
                            }

                            menuRow += '</li>';

                            fsLeftMenu.append(menuRow);
                        }

                    });

                }
            });
        }
        element.render("nav");
    };

    var fsMenu = new FsMenu();
    exports("fsMenu", fsMenu);
});
