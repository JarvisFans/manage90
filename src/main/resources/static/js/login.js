$("#login").click(function loginValid() {
    var adminVal = $("#admin").val();
    var passwordVal = $("#password").val();
    if (adminVal == null || adminVal === "" || adminVal === undefined) {
        alert("请输入用户名");
        return false;
    }
    if (passwordVal == null || passwordVal === "" || passwordVal === undefined) {
        alert("请输入密码");
        return false;
    }

    // 提交操作
    var params = $("#loginForm").serialize();
    $.post("/login", params, function (result) {
        if (result === "success") {
            window.location.href = '/index';
        } else {
            alert(result);
        }
    })
    return false;
});