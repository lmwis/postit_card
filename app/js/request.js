let hostPre = "http://localhost:8001"

let RequestUtil = {

    getCardPage:function(current,size){
        $.ajax({
            url: hostPre+"/card/page",
            data:{
                current:current,
                size:size
            },
            withCredentials:true,
            headers:{
              "Content-type":"application/json"
            },
            success:function (res){
                console.log(res);
                if(res.status==="success"){
                    let records = res.data.records;
                    let current = res.data.current;
                    let pages = res.data.pages;
                }
            },
            err:function (res){
                console.log(res);
            }
        });
    },
    getCardById:function (id){
        $.ajax({
            url: hostPre+"/card/"+id,
            withCredentials:true,
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
    },
    insertCard:function (){

    },
    updateCard:function (){

    }
}