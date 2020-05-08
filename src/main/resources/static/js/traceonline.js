function postForm() {
    var params = $("#searchForm").serialize();

    $.post("/traceonline",params,function (result) {
        if(result){
            var aToStr=JSON.stringify(result);
            alert(aToStr + "a");
        }else{
            alert("查询错误");
        }
    })
}