function total(){
    var prices=document.getElementsByName("prices");
    var count=document.getElementsByName("count");
    var sum=0;
    for(var i=0; i<prices.length;i++){
       sum+=prices[i].value*count[i].value;
    }
    document.getElementById("totalPrice").getElementsByTagName("span")[0].innerHTML="¥" +sum.toFixed(2);
}
total();