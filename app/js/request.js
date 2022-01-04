let hostPre = "http://localhost:8001"

let RequestUtil = {

    getCardPage:function(current,size){
        let r = {};
        $.ajax({
            url: hostPre+"/card/page",
            data:{
                current:current,
                size:size
            },
            async:false,
            withCredentials:true,
            headers:{
              "Content-type":"application/json"
            },
            success:function (res){
                r = res;
            },
            err:function (res){
                r = res;
            }
        });
        return r;
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
    updateCard:function (card){
        // const data = JSON.stringify(card);
        let r={};
        $.ajax({
            url: hostPre+"/card/"+card.id,
            withCredentials:true,
            data:{
                body:card.body,
                title:card.title
            },
            method:"put",
            async:false,
            success:function (res){
                r= res;
            },
            err:function (res){
                r= res;
            }
        });
        return r;
    }
}