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
    searchCard:function (key,current,size){
        let r = {};
        $.ajax({
            url: hostPre+"/card/search",
            data:{
                key,
                current,
                size
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
    insertCard:function (title,body,expirationDate,isVisible){
        let r={};
        $.ajax({
            url: hostPre+"/card",
            withCredentials:true,
            data:{
                title,
                body,
                isVisible,
                expirationDate
            },
            method:"post",
            async:false,
            success:function (res){
                r= res;
            },
            err:function (res){
                r= res;
            }
        });
        return r;

    },
    deleteCard:function (id){
        // const data = JSON.stringify(card);
        let r={};
        $.ajax({
            url: hostPre+"/card/"+id,
            withCredentials:true,
            method:"delete",
            async:false,
            success:function (res){
                r= res;
            },
            err:function (res){
                r= res;
            }
        });
        return r;
    },
    updateCard:function (card){
        // const data = JSON.stringify(card);
        let r={};
        $.ajax({
            url: hostPre+"/card/"+card.id,
            withCredentials:true,
            data:{
                body:card.body,
                title:card.title,
                isVisible:card.isVisible
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