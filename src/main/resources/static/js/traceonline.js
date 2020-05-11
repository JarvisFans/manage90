function postForm() {
    var params = $("#searchForm").serialize();

    $.post("/traceonline",params,function (result) {
        if(result){
            var aToStr=JSON.stringify(result);
            // alert(aToStr);
            // for(var i=0;i<result.length;i++){
            //     s = "<tr><td>"+result + "</td></tr>";
            //     $("#tab").append(s);
            // }
        }else{
            alert("查询错误");
        }
    })
}