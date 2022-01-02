let hostPre = "http://localhost:8001"

let RequestUtil = {

    getCardPage:function(){
        $.ajax({
            url: hostPre+"/card/500",
            headers:{
              "Content-type":"application/json"
            },
            success:function (res){
                console.log(res);
            },
            err:function (res){
                console.log(res);
            }
        });
    }
}