function postForm() {
    var params = $("#query_form").serialize();

    $.post("/test/ribbon",params,function (data) {
        console.log(data);
        if(data){
            alert(data);
        }else{
            alert("查询错误");
        }
    })
}